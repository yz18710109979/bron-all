package com.jy;

import cn.hutool.json.JSONUtil;
import com.jy.bron.we.config.WeProperties;
import com.jy.bron.we.domain.dto.WeAccessTokenDto;
import com.jy.bron.we.domain.dto.media.WeMediaResultDto;
import com.jy.bron.we.domain.dto.menu.WeMenuQueryDto;
import com.jy.bron.we.forest.client.WeAccessTokenClient;
import com.jy.bron.we.forest.client.media.WeMediaOprClient;
import com.jy.bron.we.forest.client.menu.WeMenuOprClient;
import com.jy.bron.we.service.TestService;
import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;

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
    @Resource WeMenuOprClient weMenuOprClient;
    @Resource WeMediaOprClient weMediaOprClient;

    @GetMapping("/test")
    public String test() {

        logger.error("devtools");
        logger.error("微信平台配置 : {}", properties.toString());
        WeAccessTokenDto accessTokenDto = client.getAccessToken("client_credential", properties.getAppId(), properties.getAppSecret());
        logger.error("获取微信公众平台accessToken : {}", accessTokenDto);
        WeMenuQueryDto currentSelfmenuInfo =
                weMenuOprClient.getCurrentSelfmenuInfo();
        logger.error("获取公众号菜单信息 : {}", JSONUtil.toJsonStr(currentSelfmenuInfo));
        WeMediaResultDto result = weMediaOprClient.mediaUpload("image", new File("D:\\二维码\\test\\0.jpg"));
        logger.error("临时素材上传 : {}", JSONUtil.toJsonStr(result));
        String mediaId = result.getMedia_id();
        InputStream in = weMediaOprClient.mediaGet(mediaId);
        logger.error("获取临时素材信息 : {}", in);
        return testService.test();}
}
