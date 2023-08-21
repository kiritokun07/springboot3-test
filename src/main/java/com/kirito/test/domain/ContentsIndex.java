//package com.kirito.test.domain;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//import org.springframework.data.elasticsearch.annotations.DateFormat;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * 内容表索引
// *
// * @author 公众号:知了一笑
// * @since 2023-07-28 13:29
// */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@JsonIgnoreProperties(ignoreUnknown = true) //解决索引中字段和实体类非一一对应的而引起的JSON解析问题
//@Document(indexName = "contents_index", createIndex = false)
//public class ContentsIndex implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Field(type = FieldType.Integer)
//    private Integer id;
//
//    @Field(type = FieldType.Keyword)
//    private String title;
//
//    @Field(type = FieldType.Keyword)
//    private String intro;
//
//    @Field(type = FieldType.Text)
//    private String content;
//
//    @Field(type = FieldType.Integer)
//    private Integer createId;
//
//    @Field(type = FieldType.Keyword)
//    private String createName;
//
//    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)
//    private Date createTime;
//}
