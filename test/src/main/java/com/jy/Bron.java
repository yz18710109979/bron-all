package com.jy;

import com.jy.bron.we.forest.client.WeAccessToeknClient;
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
    private WeAccessToeknClient client;
    @Resource
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        logger.error("test forest {}", client.firstRequest());
        return testService.test();}
}
