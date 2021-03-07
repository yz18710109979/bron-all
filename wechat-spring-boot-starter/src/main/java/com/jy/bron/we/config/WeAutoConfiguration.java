package com.jy.bron.we.config;

import com.jy.bron.we.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(WeProperties.class)
@ConditionalOnProperty(
        prefix = "wx",
        name = "open",
        havingValue = "true"
)
public class WeAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(WeAutoConfiguration.class);
    @Resource
    private WeProperties properties;

    @Bean
    public TestService testService() {
        logger.error("初始化TestService {}", properties.getAppId() + " : " + properties.getAppSecret());
        return new TestService();}
}
