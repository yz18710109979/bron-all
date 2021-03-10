package com.jy.conf;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HDFSConfiguration {
    @Value("${hdfs.path}")
    private String hpath;

    @Value("${hdfs.username}")
    private String username;

    @Bean
    public org.apache.hadoop.conf.Configuration getHdfsConfig(){
        org.apache.hadoop.conf.Configuration conf=new org.apache.hadoop.conf.Configuration();
        conf.set("fs.defaultFS",hpath);
        conf.set("DHADOOP_USER_NAME", username);
        //
//		其他属性设置可以在这里继续添加
        return conf;
    }
}
