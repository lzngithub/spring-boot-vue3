package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

// 在编译时期自动生成getter/setter/toString等方法
// pom中添加依赖，在实体类上添加注解
@Data
public class User {
    @NotNull
    private Integer id; // id
    private String username; // 用户名
    @JsonIgnore
    private String password; // 密码
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname; // 昵称
    @NotEmpty
    @Email
    private String email; // 邮箱
    private String avatar; // 头像
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}

