package com.jy.bron.we.domain.dto.user;

import lombok.Data;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
@Data
public class WeUserInfoResultDto {
    private Integer subscribe;
    private String openid;
    private String nickname;
    private Integer sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private Integer subscribe_time;
    private String unionid;
    private String remark;
    private Integer groupid;
    private Integer[] tagid_list;
    private String subscribe_scene;
    private Integer qr_scene;
    private String qr_scene_str;
}
