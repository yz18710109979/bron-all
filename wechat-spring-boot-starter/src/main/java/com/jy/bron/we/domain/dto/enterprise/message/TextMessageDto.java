package com.jy.bron.we.domain.dto.enterprise.message;

public class TextMessageDto {
    /**
     * 消息文本内容，最多4000个字节
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
