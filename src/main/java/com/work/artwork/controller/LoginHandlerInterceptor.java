package com.work.artwork.controller;

import com.work.artwork.common.model.SysUserConstans;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(LoginHandlerInterceptor.class.getName());

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Object user = request.getSession().getAttribute(SysUserConstans.SESSION_USER_KEY);
        logger.info("afterCompletion----" + user + " ::: " + request.getRequestURL());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object user = request.getSession().getAttribute(SysUserConstans.SESSION_USER_KEY);
        logger.info("postHandle----" + user + " ::: " + request.getRequestURL());

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute(SysUserConstans.SESSION_USER_KEY);
        logger.info("preHandle----" + user + " ::: " + request.getRequestURL());

        if (user == null) {
            request.setAttribute("msg", "无权限请先登录");
            // 重定向到登录页
            response.sendRedirect("/after/login/logIn");
            return false;
        }
        return true;
    }

}
