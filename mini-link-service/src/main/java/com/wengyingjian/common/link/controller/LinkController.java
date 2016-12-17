package com.wengyingjian.common.link.controller;

import com.wengyingjian.common.link.module.Link;
import com.wengyingjian.common.link.service.LinkService;
import com.wengyingjian.kylin.common.enums.ResultStatus;
import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wengyingjian on 16/12/17.
 */
@RestController
public class LinkController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/gen", method = RequestMethod.POST)
    public Result<String> getShortLink(@RequestParam String originalLink) {
        try {
            logger.info("getShortLink...");

            Result<Link> result = linkService.genShortLink(originalLink);
            return ResultUtil.genSuccessResult(result.getData().getShortLink());
        } catch (Exception e) {
            logger.error("getShortLink failed for originalLink[" + originalLink + "], error msg is: ", e);
            return ResultUtil.genCommonError("获取失败！");
        }
    }

    @RequestMapping(value = "/{shortLink}", method = RequestMethod.GET)
    public void redirectOriginalLink(HttpServletResponse response,//
                                     @PathVariable() String shortLink) throws IOException {
        logger.info("redirectOriginalLink...");

        Result<String> result = linkService.getOriginalLink(shortLink);
        if (result.getStatus() == ResultStatus.SUCCESS.getCode()) {
            response.sendRedirect(result.getData());
            return;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("page/index.html")));
        ServletOutputStream out = response.getOutputStream();
        String line = br.readLine();
        while (line != null) {
            out.print(line);
            line = br.readLine();
        }
        out.close();
        br.close();
    }
}
