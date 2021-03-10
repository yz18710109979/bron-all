package com.jy.service;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    private static Logger log= LoggerFactory.getLogger(WordMapper.class);
    private final static LongWritable one = new LongWritable(1);
    private Text word = new Text();
    /**
     * @param key
     * 默认情况下，是mapreduce所读取到的一行文本的起始偏移量
     * @param value
     * 默认情况下，是mapreduce所读取到的一行文本的内容，hadoop中的序列化类型为Text
     * @param context
     * 是用户自定义逻辑处理完成后输出类定义的KEY，VALUE，交给后续的produce处理
     * @throws InterruptedException
     * @throws IOException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 防止中文乱码
        String sentence = new String(value.getBytes(), 0, value.getLength(), "UTF-8").trim();
        if (StringUtils.isNotEmpty(sentence)) {
            // // 使用jieba分词器
            JiebaSegmenter segmenter = new JiebaSegmenter();
            List<SegToken> process =
                    segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH);
            for (SegToken segToken :process) {
                log.info(segToken.word + "开始位置 : " + segToken.startOffset);
                word.set(segToken.word);
                context.write(word, one);
            }
        }
    }
}
