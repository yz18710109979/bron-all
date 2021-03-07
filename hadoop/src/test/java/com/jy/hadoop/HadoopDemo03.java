package com.jy.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// 文件的上传和下载
public class HadoopDemo03 {

    FileSystem fs = null;
    @Before
    public void before() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("fs.replcation", "2");
        fs = FileSystem.get(new URI("hdfs://hdp01:9000"), conf, "hadoop");

    }

    @Test
    public void listFiles() throws IOException {
        RemoteIterator<LocatedFileStatus> iterator =
                fs.listFiles(new Path("/"), true);
        while (iterator.hasNext()) {
            LocatedFileStatus status = iterator.next();

            Path path = status.getPath(); // 文件路径
            String owner = status.getOwner(); // 所属用户
            long len = status.getLen(); // 长度
            short replication = status.getReplication(); // 副本数

            BlockLocation[] blockLocations = status.getBlockLocations(); // 获取该文件的块详情
            for (int i = 0; i < blockLocations.length; i++) {

                int length = blockLocations.length; // 块的个数
                BlockLocation blockLocation = blockLocations[i];
                String[] names = blockLocation.getNames();
                String[] hosts = blockLocation.getHosts();
                long offset = blockLocation.getOffset(); // 偏移量
                long blockLocationLength = blockLocation.getLength();
            }

        }
    }

    @Test
    public void get() throws IOException {
        // 构建输入流，读取hdfs文件系统的a.txt
        FSDataInputStream in = fs.open(new Path("/a.txt"));

        // 构建输出流，写到本地文件系统
        FileOutputStream out = new FileOutputStream("d:\\a.txt");

        //工具
//        IOUtils.copyBytes(in, out, 4096);
        // 从文件的长度开始读取
        in.seek(1); // 从1开始， 指定
        IOUtils.copyBytes(in, out, 31, true);
    }
    //下载文件的第二块
    @Test
    public void getBlock() throws IOException {
        // 获取文件的属性
        FileStatus fileStatus = fs.getFileStatus(new Path("/a.tar.gz"));
        // 块信息
        BlockLocation[] fileBlockLocations = fs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        // 判断是否存在第二块
        if (fileBlockLocations.length >= 2) {
            // 获取第二块的offset
            // 获取文件的blockSize： fileStatus.getBlockSize();
            // 获取第一块的长度：fileBlockLocations[0].getLength()
            long offset = fileBlockLocations[1].getOffset();
            // 获取第二块的长度
            long length = fileBlockLocations[1].getLength();
            //构建输入输出流指定offset读取length
            FSDataInputStream in = fs.open(new Path("/a.tar.gz"));
            FileOutputStream out = new FileOutputStream("D:\\A.tar.gz");
            in.seek(offset);
            IOUtils.copyBytes(in, out, length, true);
        }
    }
    @After
    public void after() throws IOException {
        fs.close();
    }
}
