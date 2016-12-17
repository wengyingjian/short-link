package com.wengyingjian.common.link.module;

import java.io.Serializable;

/**
 * Created by wengyingjian on 16/12/16.
 */
public class Link implements Serializable {
    private Long id;
    private String shortLink;
    private String originalLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }
}
