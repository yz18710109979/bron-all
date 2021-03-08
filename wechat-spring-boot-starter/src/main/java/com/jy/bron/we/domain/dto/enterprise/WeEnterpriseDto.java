package com.jy.bron.we.domain.dto.enterprise;

import com.jy.bron.we.domain.dto.WeResultDto;

import java.lang.ref.WeakReference;

public class WeEnterpriseDto extends WeResultDto {
    private String pre_auth_code;

    public String getPre_auth_code() {
        return pre_auth_code;
    }

    public void setPre_auth_code(String pre_auth_code) {
        this.pre_auth_code = pre_auth_code;
    }
}
