package com.jy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;

public class ExcelListener extends AnalysisEventListener {

    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
        System.out.println("当前行："+analysisContext.getCurrentRowNum());
        System.out.println(object);
        doSomething(object);//根据自己业务做处理
    }
    private void doSomething(Object object) {
        //1、入库调用接口
       List<String> data = (List) object;
        System.out.println(data.size());
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
