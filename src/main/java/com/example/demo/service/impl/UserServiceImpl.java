package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5Utils;
import com.example.demo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        String md5Password =MD5Utils.encrypt(password);
        userMapper.add(username, md5Password);
    }

    @Override
    public void update(User user) {
        userMapper.updateData(user);
    }

    @Override
    public void updateAvatar(String avatar) {
        Map<String, Object> user = ThreadLocalUtil.get();
        int id = (int) user.get("id");
        userMapper.updateAvatar(id, avatar);
    }

    @Override
    public void updatePwd(User user) {
        int id = (int) user.getId();
        String password = (String) user.getPassword();
        String md5Password =MD5Utils.encrypt(password);
        userMapper.updatePwd(id, md5Password);
    }
}
