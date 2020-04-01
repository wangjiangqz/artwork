package com.work.artwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 后台控制层
 *
 * @author makejava
 * @since 2020-04-01 11:30:06
 */
@Controller
@RequestMapping("/after/")
public class IndexController {

    /**
     * 功能描述: 登录成功进入首页
     *
     * @return
     */
    @RequestMapping("index")
    public String loginSuc(HttpSession session, Model model) {
        model.addAttribute("session", session);
        return "common/iframe";
    }

}