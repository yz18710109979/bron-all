package com.jy.bron.we.domain.dto.menu;

import lombok.Data;

import java.util.List;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
@Data
public class WeMenuButtonDto {
    private String type;
    private String name;
    private String key;
    private String url;
    private String appid;
    private String pagepath;
    private List<WeMenuButtonDto> sub_button;
}
