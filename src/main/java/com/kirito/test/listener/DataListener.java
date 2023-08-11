package com.kirito.test.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kirito.test.types.DataVO;

import java.util.Map;

public class DataListener extends AnalysisEventListener<DataVO> {
    /**
     * 接收解析的数据块
     */
    @Override
    public void invoke(DataVO data, AnalysisContext context) {
        System.out.println("DataListener："+data);
    }
    /**
     * 接收解析的表头
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("DataListener："+headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("DataListener：after...all...analysed");
    }
}