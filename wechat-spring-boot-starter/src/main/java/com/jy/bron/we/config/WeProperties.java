package com.jy.bron.we.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wx")
public class WeProperties {
    private String appId;
    private String appSecret;
    private String serverUrl = "https://api.weixin.qq.com/";
    private String prefix = "cgi-bin";
    private String[] noAccessTokenUrl = new String[] {"/token"};
    // https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
    private String[] needAccessTokenUrl = new String[] {
            "/menu/create",
            "/get_current_selfmenu_info",
            "/media/upload"
    };

    private WeEnterpriseProperties weEnterpriseProperties;
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String[] getNoAccessTokenUrl() {
        return noAccessTokenUrl;
    }

    public void setNoAccessTokenUrl(String[] noAccessTokenUrl) {
        this.noAccessTokenUrl = noAccessTokenUrl;
    }

    public String[] getNeedAccessTokenUrl() {
        return needAccessTokenUrl;
    }

    public void setNeedAccessTokenUrl(String[] needAccessTokenUrl) {
        this.needAccessTokenUrl = needAccessTokenUrl;
    }

    public WeEnterpriseProperties getWeEnterpriseProperties() {
        return weEnterpriseProperties;
    }

    public void setWeEnterpriseProperties(WeEnterpriseProperties weEnterpriseProperties) {
        this.weEnterpriseProperties = weEnterpriseProperties;
    }
}
