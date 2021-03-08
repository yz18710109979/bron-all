package com.jy.bron.we.forest.client;

import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.Constants;
import com.jy.bron.we.domain.dto.WeAccessTokenDto;

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
    @Request(url = Constants.accessToken,
            type = HttpMethod.GET
    )
    WeAccessTokenDto getAccessToken(@Query("grant_type") String grant_type, @Query("appid") String appid, @Query("secret") String secret);


    //TODO 企业微信相关token

}
