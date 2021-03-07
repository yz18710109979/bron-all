package com.jy.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Hadoop01 {

    FileSystem fs = null;
    @Before
    public void before() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("fs.replcation", "2");
        fs = FileSystem.get(new URI("hdfs://hdp01:9000"), conf, "hadoop");

    }

    @Test
    public void mkdirs() throws IOException {
        boolean mkdirs = fs.mkdirs(new Path("/aa"));
        System.out.println("hadoop hdfs文件系统创建文件 ：" + (mkdirs ? "成功" : "失败"));
    }



    @Test
    public void get() {
//        fs.copyToLocalFile(new Path("/a.txt", new Path("D:\\aa")), false);
    }
    @After
    public void after() throws IOException {
        fs.close();
    }
}
