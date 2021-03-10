package com.jy.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.*;
import java.util.*;

@Service
public class HDFSService {

    @Resource
    private Configuration conf;

    private static final Logger logger = LoggerFactory.getLogger(HDFSService.class);


    private FileSystem fs = null;

    // 构造
    @PostConstruct
    public void init() throws IOException {
        fs = FileSystem.get(conf);
    }

    // 程序退出前断开
    @PreDestroy
    public void close() throws IOException {
        fs.close();
    }


    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    public boolean mkdir(String path) throws IOException {
        if (StringUtils.isEmpty(path) || null == fs) {
            return false;
        }
        Path hpath = new Path(path);
        if (fs.exists(hpath)) {
            logger.error("file exits : {}", path);
        }
        return fs.mkdirs(hpath);
    }


    // 读取目录消息
    public List<Map<String, Object>> getPathList(String path) throws IOException {
        List<Map<String,Object>> files = new LinkedList<>();
        if (StringUtils.isNoneEmpty(path)) {
            Path hpath = new Path(path);
            FileStatus[] fileStatuses = fs.listStatus(hpath);
            if (fs.exists(hpath) && fileStatuses.length > 0) {
                for (FileStatus f :
                     fileStatuses) {
                    Map map = new HashMap();
                    map.put("filePath", f.getPath());
                    map.put("fileStatus", f.toString());
                    files.add(map);
                }
            }
        }
        return files;
    }

    /**
     * 将文件上传到hdfs指定目录
     * @param hdfsPath
     * @param file
     * @return
     * @throws IOException
     */
    public boolean uploadFile(String hdfsPath, MultipartFile file) throws IOException {
        if (StringUtils.isEmpty(hdfsPath) || null == fs) {
            return false;
        }
        String fileName = file.getOriginalFilename();
        Path newPath = new Path(hdfsPath + "/" + fileName);
        FSDataOutputStream fsDataOutputStream = fs.create(newPath);
        fsDataOutputStream.write(file.getBytes());
        fsDataOutputStream.close();
        return true;
    }



    public boolean downloadFile(String hdfsPath, String localPath) throws IOException {
        if (StringUtils.isEmpty(hdfsPath) || fs == null) {
            return false;
        }
        Path hpath = new Path(hdfsPath);
        FSDataInputStream in = fs.open(hpath);
        FileOutputStream os = new FileOutputStream(localPath);
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = in.read(b)) != -1) {
            os.write(b, 0, len);
        }
        os.close();
        in.close();
        return true;
    }

    /**
     * 本地文件上传到hdfs
     * @param local
     * @param hdfsPath
     * @return
     * @throws IOException
     */
    public boolean localToHdfs(String local, String hdfsPath) throws IOException {
        if (StringUtils.isEmpty(local) || StringUtils.isEmpty(hdfsPath)) {
            return false;
        }
        Path clientPath = new Path(local);
        Path hPath = new Path(hdfsPath);

        fs.copyFromLocalFile(false, clientPath, hPath);
        return true;
    }


    /**
     * 从hdfs下载文件到本地
     * @param hdfsPath
     * @param localPath
     * @return
     * @throws IOException
     */
    public  boolean hdfsToLocal(String hdfsPath, String localPath) throws IOException {
        if (StringUtils.isEmpty(hdfsPath) || StringUtils.isEmpty(localPath)) {
            return false;
        }
        Path clientPath = new Path(hdfsPath);
        Path serverPath = new Path(localPath);


        fs.copyToLocalFile(false, clientPath, serverPath);
        return true;
    }


    // 读取文件内容
    public String readFile(String path) throws IOException {
        if (StringUtils.isEmpty(path) || fs == null) {
            return null;
        }
        if (!fs.exists(new Path(path))) {
            return null;
        }
        Path srcPath = new Path(path);
        FSDataInputStream is = fs.open(srcPath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String lineText = "";
        StringBuffer sb = new StringBuffer();
        if ((lineText = br.readLine()) != null) {
            sb.append(lineText);
        }
        return sb.toString();
    }


    // 读取文件列表
    public  List<Map<String, String>> listFile(String path) throws IOException {
        if (StringUtils.isEmpty(path) || fs == null) {
            return null;
        }
        if (!fs.exists(new Path(path))) {
            return null;
        }
        Path srcPath = new Path(path);
        RemoteIterator<LocatedFileStatus> ite = fs.listFiles(srcPath, true);
        List<Map<String,String>> fileList = new ArrayList<>();
        while (ite.hasNext()) {
            LocatedFileStatus next = ite.next();
            String name = next.getPath().getName();
            Path filePath = next.getPath();
            Map map = new HashMap();
            map.put("fileName", name);
            map.put("filePath", path);
            fileList.add(map);
        }
        return fileList;
    }


    // 重命名
    public boolean renameFile(String oldName, String newName) throws IOException {
        if (StringUtils.isEmpty(oldName) || StringUtils.isEmpty(newName)) {
            return false;
        }
        Path oldPath = new Path(oldName);
        Path newPath = new Path(newName);
        boolean flag = fs.rename(oldPath, newPath);
        return flag;
    }


    // 删除文件
    public boolean deleteFile(String filePath) throws IOException {
        if (StringUtils.isEmpty(filePath)) {
            return false;
        }
        if (!fs.exists(new Path(filePath))) {
            return false;
        }
        Path srcPath = new Path(filePath);
        boolean flag = fs.delete(srcPath, true);
        return flag;
    }


    // 文件复制
    public void copyFile(String sourceFile, String targetFile) throws IOException {
        if (StringUtils.isEmpty(sourceFile) || StringUtils.isEmpty(targetFile)) {
            return;
        }
        Path oldPath = new Path(sourceFile);
        Path newPath = new Path(targetFile);
        FSDataInputStream in = fs.open(oldPath);
        FSDataOutputStream out = fs.create(newPath);
        IOUtils.copyBytes(in, out, 1024, false);
    }


    // 打开HDFS上的文件并返回byte数组
    public byte[] openFileToByte(String filePath) throws IOException {
        if (StringUtils.isEmpty(filePath) || fs == null) {
            return null;
        }
        if (!fs.exists(new Path(filePath))) {
            return null;
        }
        Path srcPath = new Path(filePath);
        FSDataInputStream in = fs.open(srcPath);
        return IOUtils.readFullyToByteArray(in);
    }


    // 获取文件在集群中的位置
    public BlockLocation[] getFileBlockLocation(String filePath) throws IOException {
        if (StringUtils.isEmpty(filePath)) {
            return null;
        }
        if (!fs.exists(new Path(filePath))) {
            return null;
        }
        Path srcPath = new Path(filePath);
        FileStatus fileStatus = fs.getFileStatus(srcPath);
        return fs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
    }
}
