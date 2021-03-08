package com.jy.bron.we.domain.dto.enterprise.message;

public class ImageMessageDto {
    /**
     * 图片的media_id，可以通过 <a href="https://work.weixin.qq.com/api/doc/90000/90135/90253">素材管理接口</a>获得
     */
    private String media_id;

    /**
     * 图片的链接，仅可使用<a href="https://work.weixin.qq.com/api/doc/90000/90135/90256">上传图片接口</a>得到的链接
     */
    private String pic_url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
