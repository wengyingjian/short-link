package com.wengyingjian.common.link.impl;

import com.wengyingjian.common.link.module.Link;
import com.wengyingjian.common.link.utils._10_62_Transfer;
import com.wengyingjian.common.link.service.LinkService;
import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.common.link.dao.LinkDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wengyingjian on 16/2/1.
 */
@Service("linkService")
//@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = LinkService.class, exportPath = "/userService")
public class LinkServiceImpl implements LinkService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LinkDao linkDao;
    @Autowired
    private _10_62_Transfer _10_62_Transfer;

    @Override
    public Result<Link> genShortLink(String originalLink) {
        //1.db操作获取主键
        Link link = new Link();
        link.setOriginalLink(originalLink);
        Link linkWithId = linkDao.insertSelective(link);

        //2.通过主键ID获取短链接
        String shortLink = _10_62_Transfer._10_2_62(linkWithId.getId());

        //3.更新数据库，存入短链接
        linkWithId.setShortLink(shortLink);
        linkDao.updateShortLinkById(linkWithId);

        return ResultUtil.genSuccessResult(linkWithId);
    }

    @Override
    public Result<String> getOriginalLink(String shortLink) {
        long id = _10_62_Transfer._62_2_10(shortLink);
        String originalLink = linkDao.selectOriginalLinkById(id);
        return ResultUtil.genSuccessResult(originalLink);
    }


}

