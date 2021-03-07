package com.jy.bron.we.forest.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.jy.bron.we.config.WeProperties;
import com.jy.bron.we.forest.client.WeAccessTokenClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;

public class ForestInterceptor implements Interceptor<String> {
    private static final Logger logger = LoggerFactory.getLogger(ForestInterceptor.class);
    @Autowired
    private WeProperties properties;

    @Resource
    WeAccessTokenClient weAccessTokenClient;

    @Override
    public boolean beforeExecute(ForestRequest request) {
        String uri = request.getURI().toString().replace("http://", "");
        logger.error("uri = {}", uri);
        if (!Arrays.asList(properties.getNoAccessTokenUrl()).contains(uri)) {
            request.addQuery("access_token", weAccessTokenClient.getAccessToken("client_credential", properties.getAppId(), properties.getAppSecret()).getAccess_token());
        }
        request.setUrl(properties.getServerUrl() + properties.getPrefix() + uri);
        return false;
    }

    @Override
    public void onSuccess(String s, ForestRequest forestRequest, ForestResponse forestResponse) {

    }

    @Override
    public void onError(ForestRuntimeException e, ForestRequest forestRequest, ForestResponse forestResponse) {
        // 调用失败，则发送微信通知
    }

    @Override
    public void afterExecute(ForestRequest forestRequest, ForestResponse forestResponse) {

    }
}
