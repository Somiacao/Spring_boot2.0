package com.meiyingying.springlaunch.model;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//@Repository
//改变返回的字符串的顺序
//@JsonPropertyOrder(value = {"content","title"})
public class ArticleVO {

    /**
     * id : 1
     * author : 曹红梅
     * title : t2
     * content : 小梅梅spring boot
     * createTime : 2019-09-09 12:09:09
     * reader : [{"name":"曹红梅","age":16},{"name":"张政豪","age":40}]
     */

    private Long id;
//    为属性起一个别名
//    @JsonProperty("authorAlia")
    private String author;
    private String title;
    private String content;
//    对日期进行序列化和反序列化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    如果值为空的话则不进行序列化和反序列化
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createTime;
//    @JsonIgnore
    private List<Reader> reader;

}
