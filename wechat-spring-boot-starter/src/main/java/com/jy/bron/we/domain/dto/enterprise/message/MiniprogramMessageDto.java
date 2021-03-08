package com.jy.bron.we.domain.dto.enterprise.message;

public class MiniprogramMessageDto {
    /**
     * 小程序消息标题，最多64个字节
     */
    private String title;

    /**
     * 小程序消息封面的mediaid，封面图建议尺寸为520*416
     */
    private String pic_media_id;

    /**
     * 小程序appid，必须是关联到企业的小程序应用
     */
    private String appid;

    /**
     * 小程序page路径
     */
    private String page;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_media_id() {
        return pic_media_id;
    }

    public void setPic_media_id(String pic_media_id) {
        this.pic_media_id = pic_media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
