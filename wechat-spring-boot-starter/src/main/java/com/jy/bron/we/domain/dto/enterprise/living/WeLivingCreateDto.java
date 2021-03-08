package com.jy.bron.we.domain.dto.enterprise.living;

public class WeLivingCreateDto {
    private String livingid;
    private String anchor_userid;
    private String theme;
    private Long living_start;
    private Integer living_duration;
    private String description;
    private Integer type;
    private Integer agentid;
    private Integer remind_time;
    private String activity_cover_mediaid;
    private String activity_share_mediaid;
    private WeLivingActivityDetailDto activity_detail;

    public String getLivingid() {
        return livingid;
    }

    public void setLivingid(String livingid) {
        this.livingid = livingid;
    }

    public String getAnchor_userid() {
        return anchor_userid;
    }

    public void setAnchor_userid(String anchor_userid) {
        this.anchor_userid = anchor_userid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Long getLiving_start() {
        return living_start;
    }

    public void setLiving_start(Long living_start) {
        this.living_start = living_start;
    }

    public Integer getLiving_duration() {
        return living_duration;
    }

    public void setLiving_duration(Integer living_duration) {
        this.living_duration = living_duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public Integer getRemind_time() {
        return remind_time;
    }

    public void setRemind_time(Integer remind_time) {
        this.remind_time = remind_time;
    }

    public String getActivity_cover_mediaid() {
        return activity_cover_mediaid;
    }

    public void setActivity_cover_mediaid(String activity_cover_mediaid) {
        this.activity_cover_mediaid = activity_cover_mediaid;
    }

    public String getActivity_share_mediaid() {
        return activity_share_mediaid;
    }

    public void setActivity_share_mediaid(String activity_share_mediaid) {
        this.activity_share_mediaid = activity_share_mediaid;
    }

    public WeLivingActivityDetailDto getActivity_detail() {
        return activity_detail;
    }

    public void setActivity_detail(WeLivingActivityDetailDto activity_detail) {
        this.activity_detail = activity_detail;
    }
}
