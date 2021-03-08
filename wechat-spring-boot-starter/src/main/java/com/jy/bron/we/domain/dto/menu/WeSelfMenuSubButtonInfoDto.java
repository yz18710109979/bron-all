package com.jy.bron.we.domain.dto.menu;

import lombok.Data;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
@Data
public class WeSelfMenuSubButtonInfoDto {
    private String type;
    private String name;
    private String url;
    private String value;
    private String title;
    private String author;
    private String digest;
    private String show_cover;
    private String cover_url;
    private String content_url;
    private String source_url;
    private WeSelfMenuSubButtonDto news_info;
}
