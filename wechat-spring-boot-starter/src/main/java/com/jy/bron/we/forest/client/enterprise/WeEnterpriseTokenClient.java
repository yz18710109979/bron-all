package com.jy.bron.we.forest.client.enterprise;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.DataObject;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.WeConstants;
import com.jy.bron.we.domain.dto.WeAccessTokenDto;
import com.jy.bron.we.domain.dto.WeResultDto;
import com.jy.bron.we.domain.dto.enterprise.WeEnterpriseDto;
import com.jy.bron.we.domain.dto.enterprise.WeOauthUserDto;
import com.jy.bron.we.domain.dto.enterprise.WePrementCodeDto;
import com.jy.bron.we.domain.dto.enterprise.WeRegisterCodeDto;
import com.jy.bron.we.domain.dto.enterprise.calendar.WeOaCalendarDto;
import com.jy.bron.we.domain.dto.enterprise.living.WeLivingCreateDto;
import com.jy.bron.we.domain.dto.enterprise.living.WeLivingResultDto;
import com.jy.bron.we.forest.interceptor.ForestEnterpriseInterceptor;

public interface WeEnterpriseTokenClient {
    // 第三方不需要
    @Request(url = WeConstants.ENTERPRISE_GET_SUITE_TOKEN,
            type = HttpMethod.POST,
    interceptor = {ForestEnterpriseInterceptor.class})
    WeAccessTokenDto getSuiteToken(@Body("suite_id") String suiteId, @Body("suite_secret") String suiteSecret, @Body("suite_ticket") String suiteTicket);

    //获取授主题token
    @Request(url = WeConstants.ENTERPRISE_GET_PROVIDER_TOKEN,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeAccessTokenDto getProviderToken(@Body("corpid") String corpid, @Body("provider_secret") String provider_secret);

    // 授权企业token
    @Request(url = WeConstants.ENTERPRISE_GET_CORP_TOKEN,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeAccessTokenDto getCorpAccessToken(@Body("auth_corpid") String authCorpid, @Body("permanent_code") String permanentCode);

    // 获取授权企业的预授权码
    @Request(url = WeConstants.ENTERPRISE_GET_PRE_AUTH_CODE,
            type = HttpMethod.GET,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeEnterpriseDto getPreAuthCode();

    //设置授权session
    @Request(url = WeConstants.ENTERPRISE_SET_SESSION_INFO,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeResultDto setSessionInfo(@Body("pre_auth_code") String preauthcode, @Body("session_info") JSONObject sessioninfo);

    // 获取授权企业永久授权码
    @Request(url = WeConstants.ENTERPRISE_GET_PREMENT_CODE,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WePrementCodeDto getPermentCode(@Body("auth_code") String authCode);

    // 获取登录用户信息
    @Request(url = WeConstants.ENTERPRISE_GET_OAUTHUSER,
            type = HttpMethod.GET,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeOauthUserDto getOauthUser(@Query("code") String code, @Query("agentid") String agentid);

    // 获取注册码
    @Request(url = WeConstants.ENTERPRISE_GET_REGISTER_CODE,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeRegisterCodeDto getRegisterCode(@Body("template_id") String template_id);




    // 日历相关
    // 日历添加
    @Request(url = WeConstants.ENTERPRISE_OA_CALENDAR_ADD,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeResultDto oaCalendarAdd(String corpId, String permanentCode, @DataObject WeOaCalendarDto weOaCalendarDto);


    /** 客户管理关系 */
    // 获取配置了客户联系功能的成员列表
    @Request(url = WeConstants.ENTERPRISE_GET_EXTCONTACT_FOLLOW_USER_LIST,
            type = HttpMethod.GET,
            interceptor = {ForestEnterpriseInterceptor.class}
            ) String getExtContactFollowUserList();

    // 获取指定成员添加的客户列表
    @Request(url = WeConstants.ENTERPRISE_GET_EXTCONTACT_LIST,
            type = HttpMethod.GET,
            interceptor = {ForestEnterpriseInterceptor.class}) String getExtContactList(String userId);

    // 获取配置过客户群管理的客户群列表。
    @Request(url = WeConstants.ENTERPRISE_GET_EXTCONTACT_GROUP_CHAT_LIST,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class}) String getExtContactGroupchatList(@Body("limit") Integer limit);



    /** 直播相关 **/
    @Request(url = WeConstants.ENTERPRISE_LIVING_CREATE,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingCreate(String corpId, String permentCode, @DataObject WeLivingCreateDto weLivingCreateDto);


    @Request(url = WeConstants.ENTERPRISE_LIVING_MODIFY,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingModify(String corpId, String permentCode, @DataObject WeLivingCreateDto weLivingCreateDto);

    @Request(url = WeConstants.ENTERPRISE_LIVING_CANCEL,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingCancel(String corpId, String permentCode, @Body("livingid") String livingid);


    @Request(url = WeConstants.ENTERPRISE_LIVING_DELETE_REPLAY_DATA,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingDeleteReplayData(String corpId, String permentCode, @Body("livingid") String livingid);

    // 获取微信观看直播凭证
    @Request(url = WeConstants.ENTERPRISE_LIVING_GET_LIVING_CODE,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingGetLivingCode(String corpId, String permentCode, @Body("livingid") String livingid, @Body("openid") String openid);

    @Request(url = WeConstants.ENTERPRISE_LIVING_GET_USER_ALL_LIVING_ID,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingGetUserAllLivingId(String corpId, String permentCode, @Body("userid") String userid, @Body("cursor") String cursor, @Body("limit") Integer limit);

    @Request(url = WeConstants.ENTERPRISE_LIVING_GET_LIVING_INFO,
            type = HttpMethod.GET,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingGetLivingInfo(String corpId, String permentCode,  String livingid);

    //获取直播观看明细
    @Request(url = WeConstants.ENTERPRISE_LIVING_GET_WATCH_STATE,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class})
    WeLivingResultDto livingGetWatchState(String corpId, String permentCode, @Body("livingid") String livingid, @Body("next_key") String next_key);
}
