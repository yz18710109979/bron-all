package com.jy.bron.we.domain.dto.enterprise;

import com.jy.bron.we.domain.dto.WeResultDto;

public class WeRegisterCodeDto extends WeResultDto {
    private String register_code;

    public String getRegister_code() {
        return register_code;
    }

    public void setRegister_code(String register_code) {
        this.register_code = register_code;
    }
}
