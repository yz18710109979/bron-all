package com.jy.bron.we.config;

import com.jy.bron.we.service.TestService;
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
    @Resource
    private WeProperties properties;

    @Bean
    public TestService testService() { return new TestService();}
}
