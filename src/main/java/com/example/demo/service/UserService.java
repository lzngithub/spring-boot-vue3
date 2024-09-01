package com.example.demo.service;

import com.example.demo.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);

    void update(User user);

    void updateAvatar(String avatar);

    void updatePwd(User user);
}
