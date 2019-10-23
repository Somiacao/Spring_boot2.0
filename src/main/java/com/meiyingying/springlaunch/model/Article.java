package com.meiyingying.springlaunch.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Article {

    /**
     * id : 1
     * author : 曹红梅
     * title : t2
     * content : 小梅梅spring boot
     * createTime : 2019-09-09 12:09:09
     * reader : [{"name":"曹红梅","age":16},{"name":"张政豪","age":40}]
     */

    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;

}
