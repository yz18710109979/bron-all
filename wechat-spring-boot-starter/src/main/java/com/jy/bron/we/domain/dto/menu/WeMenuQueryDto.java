package com.jy.bron.we.domain.dto.menu;

import lombok.Data;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
@Data
public class WeMenuQueryDto {
    private Integer is_menu_open;
    private WeSelfMenuInfoDto selfmenu_info;
}
