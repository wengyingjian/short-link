package com.wengyingjian.common.link.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wengyingjian on 16/12/17.
 */
@RestController
public class ViewController {

    @RequestMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
