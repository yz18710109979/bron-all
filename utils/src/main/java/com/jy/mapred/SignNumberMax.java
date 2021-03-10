package com.jy.mapred;

import java.util.Map;

// 多个文件中的数字最大值
public class SignNumberMax {
    public static void main(String[] args) {
        Map<String, Integer> map01 = readFile("");
        Map<String, Integer> map02 = readFile("");
        Map<String, Integer> map03 = readFile("");
        Map<String, Integer> map04 = readFile("");
        Map<String, Integer> map05 = readFile("");
        Map<String, Integer> resultMap = mergeFile(map01, map02, map03, map04, map05);
        System.out.println(resultMap);
    }
    public static Map<String, Integer> readFile(String path) {
        return null;
    }
    public static Map<String,Integer> mergeFile(Map<String, Integer> ...maps) {
        return null;
    }
}
