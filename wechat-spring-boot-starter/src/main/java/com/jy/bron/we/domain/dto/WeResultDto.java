package com.jy.bron.we.domain.dto;

import lombok.Data;

/**
 * @deprecated
 * @author Yangz on:
 */
public class WeResultDto {
    private String errmsg;
    private Integer errcode;
    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }
}
