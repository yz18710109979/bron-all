package com.jy.bron.we.forest.interceptor;

import cn.hutool.json.JSONUtil;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.jy.bron.we.config.WeEnterpriseProperties;
import com.jy.bron.we.config.WeProperties;
import com.jy.bron.we.constants.Constants;
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
public class ForestEnterpriseInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(ForestEnterpriseInterceptor.class);
    @Autowired
    private WeProperties properties;

    @Override
    public boolean beforeExecute(ForestRequest request) {
        String uri=request.getUrl().replace("http://","");
        logger.error("企业微信拦截器 : {}", uri);
        WeEnterpriseProperties weEnterpriseProperties = properties.getWeEnterpriseProperties();
        request.setUrl(weEnterpriseProperties.getServerUrl() + weEnterpriseProperties.getPrefix() + uri);
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
        if(null != weResultDto.getErrcode() && !weResultDto.getErrcode().equals(Constants.WE_SUCCESS_CODE)){
            throw new ForestRuntimeException(forestResponse.getContent());
        }
        logger.error("weResultDto = {}", JSONUtil.toJsonStr(weResultDto));
    }
}