package com.wengyingjian.common.link.impl;

import com.wengyingjian.common.link.ServiceApp;
import com.wengyingjian.common.link.service.LinkService;
import com.wengyingjian.common.link.utils._10_62_Transfer;
import com.wengyingjian.kylin.common.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Created by wengyingjian on 16/12/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApp.class)
@WebAppConfiguration
public class LinkServiceImplTest {
    @Autowired
    private LinkService linkService;
    @Autowired
    private _10_62_Transfer _10_62;

    @Test
    public void genShortLink() throws Exception {
        linkService.genShortLink("www.baidu.com");
    }

    @Test
    public void getOriginalLink() throws Exception {
        Result<String> ret = linkService.getOriginalLink("qqqqqw");
        System.out.println("a=" + ret.getData());
    }

}