package com.jy.bron.we.forest.interceptor;

import cn.hutool.json.JSONUtil;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.jy.bron.core.utils.Objects;
import com.jy.bron.core.utils.StringUtils;
import com.jy.bron.we.cache.LocalCache;
import com.jy.bron.we.config.WeProperties;
import com.jy.bron.we.constants.WeConstants;
import com.jy.bron.we.domain.dto.WeAccessTokenDto;
import com.jy.bron.we.domain.dto.WeResultDto;
import com.jy.bron.we.forest.client.WeAccessTokenClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

@Component
public class ForestInterceptor implements Interceptor {
    @Autowired
    private WeProperties properties;
    private static final Logger logger = LoggerFactory.getLogger(ForestInterceptor.class);

    @Resource
    WeAccessTokenClient weAccessTokenClient;

    @Override
    public boolean beforeExecute(ForestRequest request) {
        String uri=request.getUrl().replace("http://","");
        logger.error("uri = {}", uri);
        if (!Arrays.asList(properties.getNoAccessTokenUrl()).contains(uri)) {
            String accessToken = String.valueOf(LocalCache.getInstance().getValue("ACCESS_TOKEN"));
            if (StringUtils.isBlank(accessToken)) {
                String appId = properties.getAppId();
                String appSecret = properties.getAppSecret();
                WeAccessTokenDto result = weAccessTokenClient.getAccessToken("client_credential", appId, appSecret);
                accessToken = result.getAccess_token();
                LocalCache.getInstance().putValue("ACCESS_TOKEN", accessToken, 7200);
            }
            logger.error("URL = {}请求地址获取本地缓冲ACCESS_TOKEN : {}", uri, accessToken);
            request.addQuery("access_token",accessToken);
            if (WeConstants.MEDIA_UPLOAD.equals(uri)) {
                request.addQuery("type", request.getArguments()[0]);
            }
            if (WeConstants.MEDIA_GET.equals(uri)) {
                request.addQuery("media_id", request.getArguments()[0]);
            }
        }
        request.setUrl(properties.getServerUrl() + properties.getPrefix() + uri);
        return true;
    }

    /**
     *  请求发送失败时被调用
     * @param e
     * @param forestRequest
     * @param forestResponse
     */
    @Override
    public void onError(ForestRuntimeException e, ForestRequest forestRequest, ForestResponse forestResponse) {


    }


    /**
     *  请求成功调用(微信端错误异常统一处理)
     * @param o
     * @param forestRequest
     * @param forestResponse
     */
    @Override
    public void onSuccess(Object o, ForestRequest forestRequest, ForestResponse forestResponse) {
        WeResultDto weResultDto = JSONUtil.toBean(forestResponse.getContent(), WeResultDto.class);
        if(null != weResultDto.getErrcode() && !weResultDto.getErrcode().equals(WeConstants.WE_SUCCESS_CODE)){
            throw new ForestRuntimeException(forestResponse.getContent());
        }
        logger.error("weResultDto = {}", JSONUtil.toJsonStr(weResultDto));
    }
}
