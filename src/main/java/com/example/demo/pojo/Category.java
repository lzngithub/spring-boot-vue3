package com.example.demo.pojo;

import lombok.Data;

@Data
public class Category {

    private Integer id;

    private String categoryName;

    private String categoryAlias;

    private Integer createUser;

    private java.util.Date createTime;

    private java.util.Date updateTime;
}
