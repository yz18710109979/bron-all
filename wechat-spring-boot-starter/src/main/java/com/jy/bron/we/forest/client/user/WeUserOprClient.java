package com.jy.bron.we.forest.client.user;

import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.Constants;
import com.jy.bron.we.domain.dto.user.WeUserInfoResultDto;
import com.jy.bron.we.forest.interceptor.ForestInterceptor;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
public interface WeUserOprClient {
    @Request(url = Constants.USER_INFO,
            type = HttpMethod.GET, interceptor = {ForestInterceptor.class})
    WeUserInfoResultDto userInfo(String openid, String lang);
}
