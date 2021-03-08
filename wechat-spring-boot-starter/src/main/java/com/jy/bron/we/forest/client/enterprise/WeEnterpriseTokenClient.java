package com.jy.bron.we.forest.client.enterprise;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.Constants;
import com.jy.bron.we.domain.dto.WeAccessTokenDto;
import com.jy.bron.we.forest.interceptor.ForestEnterpriseInterceptor;

public interface WeEnterpriseTokenClient {
    // 第三方不需要
    @Request(url = Constants.ENTERPRISE_GET_SUITE_TOKEN,
            type = HttpMethod.POST,
    interceptor = {ForestEnterpriseInterceptor.class})
    WeAccessTokenDto getSuiteToken(@Body("suite_id") String suiteId, @Body("suite_secret") String suiteSecret, @Body("suite_ticket") String suiteTicket);

    //获取授主题token
    @Request(url = Constants.ENTERPRISE_GET_PROVIDER_TOKEN,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeAccessTokenDto getProviderToken(@Body("corpid") String corpid, @Body("provider_secret") String provider_secret);

    // 授权企业token
    @Request(url = Constants.ENTERPRISE_GET_CORP_TOKEN,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeAccessTokenDto getCorpAccessToken(@Body("auth_corpid") String authCorpid, @Body("permanent_code") String permanentCode);
}
