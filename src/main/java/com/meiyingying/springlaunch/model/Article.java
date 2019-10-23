package com.meiyingying.springlaunch.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String createTime;
    private List<ReaderBean> reader;


    public static class ReaderBean {
        /**
         * name : 曹红梅
         * age : 16
         */

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
