package com.jy.service;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    private LongWritable num = new LongWritable();
    /**
     * @author hw
     * @Description
     * MapReduce框架会将Map阶段缠上的相同key分发到同一个reduce函数处理
     * @param key
     * 第一个Text: 是传入的单词名称，是Mapper中传入的
     * @param values
     * 第二个：LongWritable 是同一个key的值的集合
     * @param context
     * 第三个Text: 是输出到文本中的内容
     * @throws InterruptedException
     * @throws IOException
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        super.reduce(key, values, context);
        long count = 0;
        for (LongWritable v : values) {
            count += v.get();
        }
        num.set(count);
        context.write(key, num);
    }
}
