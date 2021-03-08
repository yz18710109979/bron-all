package com.jy.bron.we.forest.client.menu;

import com.dtflys.forest.annotation.DataObject;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.Constants;
import com.jy.bron.we.domain.dto.menu.WeMenuDto;
import com.jy.bron.we.domain.dto.menu.WeMenuQueryDto;
import com.jy.bron.we.forest.interceptor.ForestInterceptor;

import javax.jws.WebResult;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
public interface WeMenuOprClient {
    // 菜单创建
    @Request(url = Constants.MENU_CREATE,
            type = HttpMethod.POST, interceptor = {ForestInterceptor.class}) WebResult menuCreate(@DataObject WeMenuDto weMenuDto);


    // 菜单查询
    @Request(url = Constants.GET_CURRENT_SELFMENU_INFO,
            type = HttpMethod.GET, interceptor = {ForestInterceptor.class}) WeMenuQueryDto getCurrentSelfmenuInfo();
}
