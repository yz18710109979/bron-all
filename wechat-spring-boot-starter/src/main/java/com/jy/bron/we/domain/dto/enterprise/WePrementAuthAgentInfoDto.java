package com.jy.bron.we.domain.dto.enterprise;

public class WePrementAuthAgentInfoDto {
    private Integer agentid;
    private String name;
    private String round_logo_url;
    private String square_logo_url;
    private String appid;
    private String privilege;

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRound_logo_url() {
        return round_logo_url;
    }

    public void setRound_logo_url(String round_logo_url) {
        this.round_logo_url = round_logo_url;
    }

    public String getSquare_logo_url() {
        return square_logo_url;
    }

    public void setSquare_logo_url(String square_logo_url) {
        this.square_logo_url = square_logo_url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}
