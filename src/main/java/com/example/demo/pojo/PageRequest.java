
package com.example.demo.pojo;

import lombok.Data;

@Data
public class PageRequest {
    private int currentPage; // 当前页码
    private int pageSize; // 每页显示条数
    private int offset; // 数据库查询的偏移量
}
