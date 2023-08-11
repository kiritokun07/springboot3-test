//package com.kirito.test.service;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.alibaba.excel.write.metadata.WriteTable;
//import com.kirito.test.listener.DataListener;
//import com.kirito.test.types.DataVO;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.util.List;
//
//@Service
//public class ExcelService {
//    /**
//     * Excel-写单个Sheet
//     */
//    public static void writeSheet () throws Exception {
//        // 文件处理
//        String basePath = getAbsolutePath();
//        File file = new File(basePath+"/easy-excel-01.xlsx") ;
//        checkOrCreateFile(file);
//        // 执行写操作
//        EasyExcel.write(file).head(DataVO.class)
//                .sheet(0,"用户信息").doWrite(DataVO.getSheet1List());
//    }
//    /**
//     * Excel-写多个Sheet
//     */
//    public static void writeSheets () throws Exception {
//        // 文件处理
//        String basePath = getAbsolutePath();
//        File file = new File(basePath+"/easy-excel-02.xlsx") ;
//        checkOrCreateFile(file);
//        ExcelWriter excelWriter = null;
//        try {
//            excelWriter = EasyExcel.write(file).build();
//            // Excel-Sheet1
//            WriteSheet writeSheet1 = EasyExcel.writerSheet(0,"分页1").head(DataVO.class).build();
//            // Excel-Sheet2
//            WriteSheet writeSheet2 = EasyExcel.writerSheet(1,"分页2").head(DataVO.class).build();
//            // Excel-Sheet3，写两个Table
//            WriteSheet writeSheet3 = EasyExcel.writerSheet(2,"分页3").build();
//            WriteTable dataTable = EasyExcel.writerTable(0).head(DataVO.class).build();
//            WriteTable dataExtTable = EasyExcel.writerTable(1).head(DataExtVO.class).build();
//            // 执行写操作
//            excelWriter.write(DataVO.getSheet1List(), writeSheet1);
//            excelWriter.write(DataVO.getSheet2List(), writeSheet2);
//            excelWriter.write(DataVO.getSheet1List(),writeSheet3,dataTable) ;
//            excelWriter.write(DataExtVO.getSheetList(),writeSheet3,dataExtTable) ;
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            if (excelWriter != null){
//                excelWriter.close();
//            }
//        }
//    }
//
//    /**
//     * Excel-读取数据
//     */
//    public static void readExcel () throws Exception {
//        // 文件处理
//        String basePath = getAbsolutePath();
//        File file = new File(basePath+"/easy-excel-01.xlsx") ;
//        if (!file.exists()){
//            return ;
//        }
//        // 读取数据
//        List<DataVO> dataList = EasyExcel.read(file).head(DataVO.class)
//                .sheet(0).headRowNumber(1).doReadSync();
//        dataList.forEach(System.out::println);
//    }
//
//    /**
//     * Excel-读取数据使用解析监听器
//     */
//    public static void readExcelListener () throws Exception {
//        // 文件处理
//        String basePath = getAbsolutePath();
//        File file = new File(basePath+"/easy-excel-01.xlsx") ;
//        if (!file.exists()){
//            return ;
//        }
//        // 读取数据，并且使用解析监听器
//        DataListener dataListener = new DataListener() ;
//        List<DataVO> dataSheetList = EasyExcel.read(file,dataListener).head(DataVO.class)
//                .sheet(0).headRowNumber(1).doReadSync();
//        dataSheetList.forEach(System.out::println);
//    }
//
//}
