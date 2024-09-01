package com.example.demo.pojo;

import lombok.Data;
import java.util.List;

@Data
public class Page<T> {
    private int currentPage; // 当前页码
    private int pageSize; // 每页显示条数
    private int total; // 总记录数
    private List<T> list; // 当前页数据
}
