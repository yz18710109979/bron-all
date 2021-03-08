package com.jy.bron.we.domain.dto.enterprise.living;

public class WeLivingResultLivingInfoDto {
    private String theme;
    private Long living_start;
    private Integer living_duration;
    private Integer status;
    private Long reserve_start;
    private Integer reserve_living_duration;
    private String description;
    private String vanchor_userid;
    private Integer main_department;
    private Integer viewer_num;
    private Integer comment_num;
    private Integer mic_num;
    private Integer open_replay;
    private Integer replay_status;
    private Integer type;
    private String push_stream_url;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getReserve_start() {
        return reserve_start;
    }

    public void setReserve_start(Long reserve_start) {
        this.reserve_start = reserve_start;
    }

    public Integer getReserve_living_duration() {
        return reserve_living_duration;
    }

    public void setReserve_living_duration(Integer reserve_living_duration) {
        this.reserve_living_duration = reserve_living_duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVanchor_userid() {
        return vanchor_userid;
    }

    public void setVanchor_userid(String vanchor_userid) {
        this.vanchor_userid = vanchor_userid;
    }

    public Integer getMain_department() {
        return main_department;
    }

    public void setMain_department(Integer main_department) {
        this.main_department = main_department;
    }

    public Integer getViewer_num() {
        return viewer_num;
    }

    public void setViewer_num(Integer viewer_num) {
        this.viewer_num = viewer_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Integer getMic_num() {
        return mic_num;
    }

    public void setMic_num(Integer mic_num) {
        this.mic_num = mic_num;
    }

    public Integer getOpen_replay() {
        return open_replay;
    }

    public void setOpen_replay(Integer open_replay) {
        this.open_replay = open_replay;
    }

    public Integer getReplay_status() {
        return replay_status;
    }

    public void setReplay_status(Integer replay_status) {
        this.replay_status = replay_status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPush_stream_url() {
        return push_stream_url;
    }

    public void setPush_stream_url(String push_stream_url) {
        this.push_stream_url = push_stream_url;
    }
}
