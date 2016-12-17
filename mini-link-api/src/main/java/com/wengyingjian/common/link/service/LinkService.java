package com.wengyingjian.common.link.service;

import com.wengyingjian.common.link.module.Link;
import com.wengyingjian.kylin.common.model.Result;

/**
 * Created by wengyingjian on 16/12/16.
 */
public interface LinkService {
    /**
     * 生成短链接
     *
     * @param originalUrl
     * @return
     */
    Result<Link> genShortLink(String originalUrl);

    /**
     * 获取原始的长链接
     *
     * @param shortLink
     * @return
     */
    Result<String> getOriginalLink(String shortLink);
}
