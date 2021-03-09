package com.jy.bron.we.forest.interceptor;

import cn.hutool.json.JSONUtil;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.utils.ForestDataType;
import com.jy.bron.core.utils.StringUtils;
import com.jy.bron.we.cache.LocalCache;
import com.jy.bron.we.config.WqEnterpriseProperties;
import com.jy.bron.we.config.WeProperties;
import com.jy.bron.we.constants.WeConstants;
import com.jy.bron.we.domain.dto.WeAccessTokenDto;
import com.jy.bron.we.domain.dto.WeResultDto;
import com.jy.bron.we.forest.client.enterprise.WeEnterpriseTokenClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

@Component
public class ForestEnterpriseInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(ForestEnterpriseInterceptor.class);
    @Resource
    private WqEnterpriseProperties enterpriseProperties;
    @Resource
    private WeEnterpriseTokenClient weEnterpriseTokenClient;

    @Override
    public boolean beforeExecute(ForestRequest request) {
        String uri=request.getUrl().replace("http://","");
        request.setDataType(ForestDataType.JSON);
        request.setContentType("application/json");
        logger.error("企业微信拦截器 : {}", uri);
        // 企业微信不需要任何token信息
        String[] urls = enterpriseProperties.getNoAccessTokenUrl();
        if (!Arrays.asList(urls).contains(uri)) {
            if (Arrays.asList(enterpriseProperties.getNeedSuiteTokenUrl()).contains(uri)) {
                request.addQuery("suite_access_token", suiteToken());
            }
            if (Arrays.asList(enterpriseProperties.getNeedProviderTokenUrl()).contains(uri)) {
                request.addQuery("provider_access_token", providerAccessToken());
            }
            if (Arrays.asList(enterpriseProperties.getNeedCorpAccessTokenUrl()).contains(uri)) {
                request.addQuery("access_token", corpAccessToken(request));
            }
        }
        request.setUrl(enterpriseProperties.getServerUrl() + enterpriseProperties.getPrefix() + uri);
        return true;
    }

    /**
     *
     * @param request
     * @return
     */
    private String corpAccessToken(ForestRequest request) {
        String corpAccessToken = LocalCache.getInstance().getValue(WeConstants.CORP_ACCESS_TOKEN);
        if (StringUtils.isBlank(corpAccessToken)) {
            Object[] arguments = request.getArguments();
            String corpId = String.valueOf(arguments[0]);
            String permanentCode = String.valueOf(arguments[1]);
            LocalCache.getInstance().putValue(WeConstants.CORP_ACCESS_TOKEN, weEnterpriseTokenClient.getCorpAccessToken(corpId, permanentCode).getAccess_token(), 7200);
        }
        return LocalCache.getInstance().getValue(WeConstants.CORP_ACCESS_TOKEN);
    }

    /**
     *
     * @return
     */
    private String providerAccessToken() {
        String providerAccessToken = LocalCache.getInstance().getValue(WeConstants.PROVIDER_ACCESS_TOKEN);
        if (StringUtils.isBlank(providerAccessToken)) {
            String corpId = enterpriseProperties.getCorpId();
            String providerSecret = enterpriseProperties.getProviderSecret();
            WeAccessTokenDto result = weEnterpriseTokenClient.getProviderToken(corpId, providerSecret);
            LocalCache.getInstance().putValue(WeConstants.PROVIDER_ACCESS_TOKEN, result.getProvider_access_token(), 7200);
        }
        return LocalCache.getInstance().getValue(WeConstants.PROVIDER_ACCESS_TOKEN);
    }

    /**
     *
     * @return
     */
    private String suiteToken() {
        String suiteToken = LocalCache.getInstance().getValue(WeConstants.SUITE_ACCESS_TOKEN);
        if (StringUtils.isBlank(suiteToken)) {
            String suitId = enterpriseProperties.getSuitId();
            String suiteSecret = enterpriseProperties.getSuiteSecret();
            WeAccessTokenDto result =
                    weEnterpriseTokenClient.getSuiteToken(suitId, suiteSecret, LocalCache.getInstance().getValue(WeConstants.SUITE_TICKET));
            LocalCache.getInstance().putValue(WeConstants.SUITE_ACCESS_TOKEN, result.getSuite_access_token(), 7200);
        }
        return LocalCache.getInstance().getValue(WeConstants.SUITE_ACCESS_TOKEN);
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
        if(null != weResultDto.getErrcode()
                && !weResultDto.getErrcode().equals(WeConstants.WE_SUCCESS_CODE)){
            logger.error(this.getClass().getName() + "返回信息 : {}", forestResponse.getContent());
        }
        logger.error("weResultDto = {}", JSONUtil.toJsonStr(weResultDto));
    }
}
