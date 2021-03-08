package com.jy.bron.we.forest.client;

import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.WeConstants;
import com.jy.bron.we.domain.dto.WeAccessTokenDto;
import com.jy.bron.we.forest.interceptor.ForestInterceptor;

/**
 * @author Yangz on:
 */
public interface WeAccessTokenClient {

    @Request(url = "http://localhost:8080/test", type = HttpMethod.GET)
    String firstRequest();


    /**
     * 微信公众平台accessToken
     * @param grant_type client_credential
     * @param appid
     * @param secret
     * @return
     */
    @Request(url = WeConstants.accessToken,
            type = HttpMethod.GET,
            interceptor = {ForestInterceptor.class}
    )
    WeAccessTokenDto getAccessToken(@Query("grant_type") String grant_type, @Query("appid") String appid, @Query("secret") String secret);
}
