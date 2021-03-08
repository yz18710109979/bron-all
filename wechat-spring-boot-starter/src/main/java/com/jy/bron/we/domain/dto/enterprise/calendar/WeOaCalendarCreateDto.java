package com.jy.bron.we.domain.dto.enterprise.calendar;

import java.util.List;

public class WeOaCalendarCreateDto {
    private String organizer;
    private String readonly;
    private String set_as_default;
    private String summary;
    private String color;
    private String description;
    private List<WeOaCalendarCreateSharesDto> shares;

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    public String getSet_as_default() {
        return set_as_default;
    }

    public void setSet_as_default(String set_as_default) {
        this.set_as_default = set_as_default;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WeOaCalendarCreateSharesDto> getShares() {
        return shares;
    }

    public void setShares(List<WeOaCalendarCreateSharesDto> shares) {
        this.shares = shares;
    }
}
