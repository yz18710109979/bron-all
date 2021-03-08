package com.jy.bron.we.domain.dto.enterprise.living;

public class WeLivingActivityDetailDto {
    private String[] image_list;
    private String description = "活动描述，非活动类型的直播不用传";

    public String[] getImage_list() {
        return image_list;
    }

    public void setImage_list(String[] image_list) {
        this.image_list = image_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
