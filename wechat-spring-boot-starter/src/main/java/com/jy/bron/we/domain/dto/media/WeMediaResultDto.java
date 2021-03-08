package com.jy.bron.we.domain.dto.media;

import com.jy.bron.we.domain.dto.WeResultDto;
import lombok.Data;

import javax.jws.WebResult;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
public class WeMediaResultDto extends WeResultDto {
    private String type;
    private String media_id;
    private Integer created_at;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }
}
