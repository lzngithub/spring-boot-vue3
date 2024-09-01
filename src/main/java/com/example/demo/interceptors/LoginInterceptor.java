package com.example.demo.interceptors;

import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        System.out.println(request);
        try {
            Map<String, Object> claims = JwtUtils.checkJwtToken(token);
            ThreadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }
    public void afterCompletion() throws Exception {
        // 请求结束移除掉线程变量
        ThreadLocalUtil.remove();
    }
}
