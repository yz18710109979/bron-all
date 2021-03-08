package com.jy.bron.we.domain.dto.enterprise.calendar;

public class WeOaCalendarCreateSharesDto {
    private String userid;
    private Integer readonly;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getReadonly() {
        return readonly;
    }

    public void setReadonly(Integer readonly) {
        this.readonly = readonly;
    }
}
