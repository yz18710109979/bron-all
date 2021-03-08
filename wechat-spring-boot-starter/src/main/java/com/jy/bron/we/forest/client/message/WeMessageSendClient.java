package com.jy.bron.we.forest.client.message;

import com.dtflys.forest.annotation.DataObject;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.WeConstants;
import com.jy.bron.we.domain.dto.WeResultDto;
import com.jy.bron.we.domain.dto.enterprise.message.WeMessagePushDto;
import com.jy.bron.we.domain.dto.message.SendTemplateReqDto;
import com.jy.bron.we.forest.interceptor.ForestInterceptor;

public interface WeMessageSendClient {

    // 小程序发送统一消息
    @Request(url = WeConstants.MESSAGE_WXOPEN_TEMPLATE_UNIFORM_SEND
            ,type = HttpMethod.POST
            ,interceptor = {ForestInterceptor.class})
    WeResultDto sendMessageToUser(@DataObject WeMessagePushDto weMessagePushDto);


    //小程序发送订阅消息
    @Request(url = WeConstants.MESSAGE_SUBSCRIBE_SEND,
            type = HttpMethod.POST,
            interceptor = {ForestInterceptor.class})
    WeResultDto sendTemplateResponse(@DataObject SendTemplateReqDto sendTemplateReqDto);
}
