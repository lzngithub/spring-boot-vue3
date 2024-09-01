package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUserName(String username);

    void add(String username, String password);

    void updateData(User user);

    void updateAvatar(int id, String avatar);

    void updatePwd(int id, String password);
}
