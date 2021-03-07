package com.jy;

import com.jy.bron.we.config.WeProperties;
import com.jy.bron.we.forest.client.WeAccessTokenClient;
import com.jy.bron.we.service.TestService;
import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@ForestScan(basePackages = "com.jy.bron.we.forest.client")
@RestController
@SpringBootApplication
public class Bron {
    private static final Logger logger = LoggerFactory.getLogger(Bron.class);
    public static void main(String[] args) {
        SpringApplication.run(Bron.class, args);
    }

    @Resource
    private WeAccessTokenClient client;
    @Resource
    private TestService testService;
    @Resource
    private WeProperties properties;

    @GetMapping("/test")
    public String test() {
        logger.error("微信平台配置 : {}", properties.toString());
        logger.error("获取微信公众平台accessToken : {}", client.getAccessToken("client_credential", properties.getAppId(), properties.getAppSecret()).toString());
        return testService.test();}
}
