package com.jy.bron.we.domain.dto;

public class WeAccessTokenDto extends WeResultDto {
    private String access_token;
    private Integer expires_in;
    private String suite_access_token;
    private String provider_access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getSuite_access_token() {
        return suite_access_token;
    }

    public void setSuite_access_token(String suite_access_token) {
        this.suite_access_token = suite_access_token;
    }

    public String getProvider_access_token() {
        return provider_access_token;
    }

    public void setProvider_access_token(String provider_access_token) {
        this.provider_access_token = provider_access_token;
    }

    @Override
    public String toString() {
        return "WeAccessTokenDto{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", suite_access_token='" + suite_access_token + '\'' +
                ", provider_access_token='" + provider_access_token + '\'' +
                '}';
    }
}
