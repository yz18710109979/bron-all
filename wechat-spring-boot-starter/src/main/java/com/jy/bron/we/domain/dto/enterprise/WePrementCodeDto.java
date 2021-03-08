package com.jy.bron.we.domain.dto.enterprise;

import com.jy.bron.we.domain.dto.WeResultDto;
import lombok.Data;

@Data
public class WePrementCodeDto extends WeResultDto {
    private String permanent_code;
    private WePrementAuthCorpInfoDto auth_corp_info;
    private WePrementAuthInfoDto auth_info;
    private WePrementAuthUserInfoDto auth_user_info;
}
