package com.jy.bron.we.domain.dto.media;

import com.jy.bron.we.domain.dto.WeResultDto;
import lombok.Data;

import javax.jws.WebResult;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
@Data
public class WeMediaResultDto extends WeResultDto {
    private String type;
    private String media_id;
    private Integer created_at;
}
