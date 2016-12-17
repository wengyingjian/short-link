package com.wengyingjian.common.link.dao;


import com.wengyingjian.common.link.dao.mapper.LinkMapper;
import com.wengyingjian.common.link.module.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wengyingjian on 16/2/1.
 */
@Repository
public class LinkDao {

    @Autowired
    private LinkMapper masterLinkMapper;
    @Autowired
    private LinkMapper slaveLinkMapper;

    public Link insertSelective(Link link) {
        masterLinkMapper.insertSelective(link);
        return link;
    }

    public void updateShortLinkById(Link link) {
        masterLinkMapper.updateShortLinkById(link);
    }

    public String selectOriginalLinkById(long id) {
        return masterLinkMapper.selectOriginalLinkById(id);
    }
}
