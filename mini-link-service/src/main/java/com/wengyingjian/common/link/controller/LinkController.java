package com.wengyingjian.common.link.controller;

import com.wengyingjian.common.link.module.Link;
import com.wengyingjian.common.link.service.LinkService;
import com.wengyingjian.kylin.common.enums.ResultStatus;
import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wengyingjian on 16/12/17.
 */
@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/gen", method = RequestMethod.POST)
    public Result<String> getShortLink(@RequestParam String originalLink) {
        Result<Link> result = linkService.genShortLink(originalLink);
        if (result.getStatus() == ResultStatus.SUCCESS.getCode()) {
            return ResultUtil.genSuccessResult(result.getData().getShortLink());
        }
        return ResultUtil.genCommonError("获取失败！");
    }

    @RequestMapping(value = "/{shortLink}", method = RequestMethod.GET)
    public void redirectOriginalLink(HttpServletResponse response,//
                                     @PathVariable() String shortLink) throws IOException {
        String redirect = "404";
        Result<String> result = linkService.getOriginalLink(shortLink);
        if (result.getStatus() == ResultStatus.SUCCESS.getCode()) {
            redirect = result.getData();
        }
        response.sendRedirect(redirect);
    }
}
