package com.example.demo.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 文章实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Article extends PageRequest {

    private Integer id;

    private String title;

    private String content;

    private String coverImg;

    private Integer status;

    private Integer categoryId;

    private Integer createUser;

    private Date createTime;

    private Date updateTime;

    private PageRequest pageRequest;
}

