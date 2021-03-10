package com.jy.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.lib.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.IOException;

@Service
public class WordCountMRService {
    @Resource
    Configuration conf;
    private static final int bufsize=4 * 1024 * 1024;
    private Job job = null;
    @PostConstruct
    public void init() throws IOException {
        job = Job.getInstance(conf, "WordCountMR");
        job.setMapperClass(WordMapper.class);
        job.setCombinerClass(WordReducer.class);
        job.setReducerClass(WordReducer.class);


        //		指定Mapper输出数据的（key,value）类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // 指定reduce输出
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 小文件合并设置
        job.setInputFormatClass(CombineTextInputFormat.class);

        // 最大分片
        CombineTextInputFormat.setMaxInputSplitSize(job, bufsize);

        // 最小分片
        CombineTextInputFormat.setMinInputSplitSize(job, bufsize);
    }


    @PreDestroy
    public void destory() throws IOException {
        job.killJob();
    }

    public void doWordCount(String inputPath, String outputPath) {
        if (StringUtils.isEmpty(inputPath) || StringUtils.isEmpty(outputPath)) {
            return;
        }
//        FileInputFormat.addInputPath(job, new Path(inputPath));
//        FileOutputFormat.setOutputPath(job, new Path(outputPath));
//
////		将job交给YARN去运行
//        boolean complate=job.waitForCompletion(true);
////		job.submit();
    }
}
