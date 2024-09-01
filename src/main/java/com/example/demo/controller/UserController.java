package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.MD5Utils;
import com.example.demo.utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public Result<User> register(@Pattern(regexp = "^\\S{1,5}$") String username,@Pattern(regexp = "^\\S{5,10}$") String password)
    {
        User u = userService.findByUserName(username);
        System.out.println(u);
        if (u == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已存在");
        }
    }
    @PostMapping("/login")
    public Result<String> login(String username, @Pattern(regexp = "^\\S{5,10}$") String password)
    {
        User u = userService.findByUserName(username);
        if (u == null) {
            return Result.error("用户名不存在");
        } else {
            if (u.getPassword().equals(MD5Utils.encrypt(password))) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", u.getId());
                claims.put("username", u.getUsername());
                String token = JwtUtils.getJwtToken(claims);
                return Result.success(token);
            } else {
                return Result.error("密码错误");
            }
        }
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String Authorization)
    {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result<User> update(@RequestBody @Validated User user){
        System.out.println(user);
        userService.update(user);
        return Result.success();
    }
    @PatchMapping("/updateAvatar")
    public Result<User> updateAvatar(@RequestParam @URL String avatar){
        System.out.println(avatar);
        userService.updateAvatar(avatar);
        return Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result<User> updatePwd(@RequestBody Map<String, String> params){
        String newPwd = params.get("newPwd");
        String oldPwd = params.get("oldPwd");
        String rePwd = params.get("rePwd");
        if (!newPwd.equals(rePwd)) {
            return Result.error("两次密码不一致");
        } else {
            Map<String, Object> claims = ThreadLocalUtil.get();
            String username = (String) claims.get("username");
            User user = userService.findByUserName(username);
            String oldPwd1 = user.getPassword();
            String oldPwd2 = (String) MD5Utils.encrypt(oldPwd);
            if (user.getPassword().equals(MD5Utils.encrypt(oldPwd))) {
                userService.updatePwd(user);
                return Result.success();
            } else {
                return Result.error("旧密码错误");
            }
        }
    }
}
