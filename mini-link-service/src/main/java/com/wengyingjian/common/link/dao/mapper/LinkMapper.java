package com.wengyingjian.common.link.dao.mapper;


import com.wengyingjian.common.link.module.Link;

/**
 * Created by wengyingjian on 16/2/1.
 */
public interface LinkMapper {

    void insertSelective(Link link);

    int updateShortLinkById(Link link);

    String selectOriginalLinkById(long id);
}
