package com.wengyingjian.common.link;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.wengyingjian.kylin", "com.wengyingjian.common.link"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ServiceApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServiceApp.class);
    }
}