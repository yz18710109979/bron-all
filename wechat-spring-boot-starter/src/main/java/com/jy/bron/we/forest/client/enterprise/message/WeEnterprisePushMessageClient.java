package com.jy.bron.we.forest.client.enterprise.message;

import com.dtflys.forest.annotation.DataObject;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.WeConstants;
import com.jy.bron.we.domain.dto.enterprise.message.WeMessagePushDto;
import com.jy.bron.we.domain.dto.enterprise.message.WeMessagePushGroupDto;
import com.jy.bron.we.domain.dto.enterprise.message.WeMessagePushResultDto;
import com.jy.bron.we.forest.interceptor.ForestEnterpriseInterceptor;

public interface WeEnterprisePushMessageClient {
    /**
     * 发送应用消息
     */
    @Request(url = WeConstants.ENTERPRISE_SEND_MESSAGE,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class}
    )
    WeMessagePushResultDto sendMessageToUser(@DataObject WeMessagePushDto weMessagePushDto);

    /**
     * 应用推送消息
     */
    @Request(url = WeConstants.ENTERPRISE_APPCHAT_SEND,
            type = HttpMethod.POST,
            interceptor = {ForestEnterpriseInterceptor.class}
    )
    WeMessagePushResultDto sendMessageToUserGroup(@DataObject WeMessagePushGroupDto weMessagePushGroupDto);
}
