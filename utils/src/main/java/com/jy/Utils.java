package com.jy;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.jy.listener.ExcelListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Utils {
    public static void main(String[] args) throws FileNotFoundException {
        read();
    }

    public static void read() throws FileNotFoundException {
        InputStream is = new FileInputStream(new File("G:\\excels\\历史告警模板.xlsx"));
        // 解析每行结果在listener中处理
        ExcelListener excelListener = new ExcelListener();
        EasyExcelFactory.readBySax(is, new Sheet(1, 1), excelListener);
    }
}
