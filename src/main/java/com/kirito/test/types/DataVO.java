package com.kirito.test.types;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 实体类，这里的注解会解析为Excel中的表头
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataVO {
    @ExcelProperty("编号")
    private Integer id;
    @ExcelProperty("名称")
    private String name;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("城市")
    private String cityName;
    @ExcelProperty("日期")
    private Date date;

    public static List<DataVO> getSheet1List() {
        List<DataVO> list = new ArrayList<>();
        list.add(new DataVO(1, "AA", "183", "nj", new Date()));
        return list;
    }

    public static List<DataVO> getSheet2List() {
        List<DataVO> list = new ArrayList<>();
        list.add(new DataVO(1, "AA", "183", "nj", new Date()));
        list.add(new DataVO(1, "BB", "186", "xc", new Date()));
        return list;
    }
}