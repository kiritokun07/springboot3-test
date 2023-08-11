package com.kirito.test.controller;

import com.alibaba.excel.EasyExcel;
import com.kirito.test.listener.DataListener;
import com.kirito.test.types.DataVO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class ExcelWeb {

    @GetMapping("excel/download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("Excel数据", StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DataVO.class).sheet("用户").doWrite(DataVO.getSheet1List());
    }

    @ResponseBody
    @PostMapping("excel/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        List<DataVO> dataList = EasyExcel
                .read(file.getInputStream(), DataVO.class, new DataListener()).sheet().doReadSync();
        dataList.forEach(System.out::println);
        return "success";
    }
}