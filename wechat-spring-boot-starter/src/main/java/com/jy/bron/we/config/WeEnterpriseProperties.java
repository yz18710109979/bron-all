package com.jy.bron.we.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
@ConfigurationProperties(prefix = "wx.enterprise")
public class WeEnterpriseProperties {
    private String corpId;
    private String suitId;
}
