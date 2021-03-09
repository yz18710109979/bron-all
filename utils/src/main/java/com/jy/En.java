package com.jy;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class En extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String no;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2,format = "yyyy/MM/dd HH:mm:ss")
    private Date args1;

    @ExcelProperty(index = 3,format = "yyyy/MM/dd HH:mm:ss")
    private Date args2;

    @ExcelProperty(index = 4,format = "yyyy/MM/dd HH:mm:ss")
    private Date args3;

    @ExcelProperty(index = 5,format = "yyyy/MM/dd HH:mm:ss")
    private Date args4;

    @Override
    public String toString() {
        return "En{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", args1=" + args1 +
                ", args2=" + args2 +
                ", args3=" + args3 +
                ", args4=" + args4 +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getArgs1() {
        return args1;
    }

    public void setArgs1(Date args1) {
        this.args1 = args1;
    }

    public Date getArgs2() {
        return args2;
    }

    public void setArgs2(Date args2) {
        this.args2 = args2;
    }

    public Date getArgs3() {
        return args3;
    }

    public void setArgs3(Date args3) {
        this.args3 = args3;
    }

    public Date getArgs4() {
        return args4;
    }

    public void setArgs4(Date args4) {
        this.args4 = args4;
    }
}
