package com.jy.bron.we.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
@ConfigurationProperties(prefix = "wx.enterprise")
public class WeEnterpriseProperties {
    private String corpId;
    private String providerSecret;
    private String suitId;
    private String suiteSecret;
    private String token;
    private String encodingAESKey;
    private Integer authType;
    private String templateId;
    private String serverUrl = "https://qyapi.weixin.qq.com/";
    private String prefix = "cgi-bin";
    private String[] noAccessTokenUrl = new String[] {"/service/get_suite_token", "/service/get_provider_token"};
    private String[] needSuiteTokenUrl = new String[] {};
    private String[] needProviderTokenUrl = new String[]{"/service/get_register_code"};
    /** 需要corp_access_token **/
    private String[] needCorpAccessTokenUrl = new String[] {"/message/send"};

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getProviderSecret() {
        return providerSecret;
    }

    public void setProviderSecret(String providerSecret) {
        this.providerSecret = providerSecret;
    }

    public String getSuitId() {
        return suitId;
    }

    public void setSuitId(String suitId) {
        this.suitId = suitId;
    }

    public String getSuiteSecret() {
        return suiteSecret;
    }

    public void setSuiteSecret(String suiteSecret) {
        this.suiteSecret = suiteSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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

    public String[] getNeedSuiteTokenUrl() {
        return needSuiteTokenUrl;
    }

    public void setNeedSuiteTokenUrl(String[] needSuiteTokenUrl) {
        this.needSuiteTokenUrl = needSuiteTokenUrl;
    }

    public String[] getNeedProviderTokenUrl() {
        return needProviderTokenUrl;
    }

    public void setNeedProviderTokenUrl(String[] needProviderTokenUrl) {
        this.needProviderTokenUrl = needProviderTokenUrl;
    }

    public String[] getNeedCorpAccessTokenUrl() {
        return needCorpAccessTokenUrl;
    }

    public void setNeedCorpAccessTokenUrl(String[] needCorpAccessTokenUrl) {
        this.needCorpAccessTokenUrl = needCorpAccessTokenUrl;
    }
}
