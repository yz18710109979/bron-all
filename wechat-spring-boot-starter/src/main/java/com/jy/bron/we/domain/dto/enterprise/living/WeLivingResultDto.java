package com.jy.bron.we.domain.dto.enterprise.living;

public class WeLivingResultDto {
    private String livingid;
    private WeLivingResultLivingInfoDto living_info;

    public String getLivingid() {
        return livingid;
    }

    public void setLivingid(String livingid) {
        this.livingid = livingid;
    }

    public WeLivingResultLivingInfoDto getLiving_info() {
        return living_info;
    }

    public void setLiving_info(WeLivingResultLivingInfoDto living_info) {
        this.living_info = living_info;
    }
}
