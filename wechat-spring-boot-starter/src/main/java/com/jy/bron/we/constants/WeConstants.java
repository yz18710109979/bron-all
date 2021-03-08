package com.jy.bron.we.constants;

public class WeConstants {

    public static final Integer WE_SUCCESS_CODE = 0;
    public static final String accessToken = "/token";
    // 公众号菜单
    public static final String MENU_CREATE = "/menu/create";
    public static final String GET_CURRENT_SELFMENU_INFO = "/get_current_selfmenu_info";

    // 公众号素材管理
    public static final String MEDIA_UPLOAD = "/media/upload";
    public static final String MEDIA_GET = "/media/get";

    // 用户管理
    public static final String USER_INFO = "/user/info";


    // 公众号消息
    public static final String MESSAGE_SUBSCRIBE_SEND = "/message/subscribe/send";
    public static final String MESSAGE_WXOPEN_TEMPLATE_UNIFORM_SEND = "/message/wxopen/template/uniform_send";

    // 企业微信
    public static final String ENTERPRISE_GET_SUITE_TOKEN = "/service/get_suite_token";
    public static final String ENTERPRISE_GET_PROVIDER_TOKEN = "/service/get_provider_token";
    public static final String ENTERPRISE_GET_CORP_TOKEN = "/service/get_corp_token";
    public static final String ENTERPRISE_GET_PRE_AUTH_CODE = "/service/get_pre_auth_code";

    public static final String ENTERPRISE_SET_SESSION_INFO = "/service/set_session_info";
    public static final String ENTERPRISE_GET_PREMENT_CODE = "/service/get_permanent_code";
    public static final String ENTERPRISE_GET_OAUTHUSER = "/service/getuserinfo3rd";
    public static final String ENTERPRISE_GET_REGISTER_CODE = "/service/get_register_code";


    /** 日历相关 **/
    public static final String ENTERPRISE_OA_CALENDAR_ADD = "/oa/calendar/add";


    // 客户管理关系
    public static final String ENTERPRISE_GET_EXTCONTACT_FOLLOW_USER_LIST = "/externalcontact/get_follow_user_list";
    public static final String ENTERPRISE_GET_EXTCONTACT_LIST = "/externalcontact/list";
    public static final String ENTERPRISE_GET_EXTCONTACT_GROUP_CHAT_LIST = "/externalcontact/groupchat/list";



    // 直播相关
    public static final String ENTERPRISE_LIVING_CREATE = "/living/create";
    public static final String ENTERPRISE_LIVING_MODIFY = "/living/modify";
    public static final String ENTERPRISE_LIVING_CANCEL = "/living/cancel";
    public static final String ENTERPRISE_LIVING_DELETE_REPLAY_DATA = "/living/delete_replay_data";
    public static final String ENTERPRISE_LIVING_GET_LIVING_CODE = "/living/get_living_code";
    public static final String ENTERPRISE_LIVING_GET_USER_ALL_LIVING_ID = "/living/get_user_all_livingid";
    public static final String ENTERPRISE_LIVING_GET_LIVING_INFO = "/living/get_living_info";
    public static final String ENTERPRISE_LIVING_GET_WATCH_STATE = "/living/get_watch_stat";


    // 消息推送
    public static final String ENTERPRISE_SEND_MESSAGE = "/message/send";
    public static final String ENTERPRISE_APPCHAT_SEND = "/appchat/send";
}
