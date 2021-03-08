package com.jy.bron.we.domain.dto.enterprise.calendar;

public class WeOaCalendarDto {
    private Integer agentid;
    private WeOaCalendarCreateDto calendar;

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public WeOaCalendarCreateDto getCalendar() {
        return calendar;
    }

    public void setCalendar(WeOaCalendarCreateDto calendar) {
        this.calendar = calendar;
    }
}
