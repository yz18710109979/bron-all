package com.jy.bron.we.domain.dto.enterprise.message;

public class LinkMessageDto {
    /**
     * 图文消息标题
     */
    private String title;

    /**
     * 图文消息封面的url
     */
    private String picurl;

    /**
     * 图文消息的描述，最多512个字节
     */
    private String desc;

    /**
     * 图文消息的链接
     */
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
