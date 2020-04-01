package com.work.artwork.controller;

import com.work.artwork.common.model.Result;
import com.work.artwork.common.model.SysUserConstans;
import com.work.artwork.common.utils.CommonUtil;
import com.work.artwork.common.utils.SysUserUtil;
import com.work.artwork.entity.SysUser;
import com.work.artwork.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录控制层
 *
 * @author makejava
 * @since 2020-04-01 11:30:06
 */
@Controller
@RequestMapping("/after/login/")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;


    /**
     * 校验用户名和密码是否匹配
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("loginCheck")
    public Result loginCheck(String loginName, String loginPwd, HttpSession session) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(loginName);
        sysUser.setStatus(SysUserConstans.USER_STATUS.NORMAL.getCode());
        List<SysUser> sysUserList = sysUserService.queryByModel(sysUser);
        if (sysUserList == null || sysUserList.isEmpty()) {
            return new Result(false, "用户不存在。");
        }
        sysUser = sysUserList.stream().findFirst().get();
        if (sysUser.getPassword().equals(CommonUtil.MD5(loginPwd))) {
            SysUserUtil.userLogin(sysUser);
            session.setAttribute(SysUserConstans.SESSION_USER_KEY, sysUser);
            return new Result();
        } else {
            return new Result(false, "用户名密码不匹配。");
        }
    }

    /**
     * 功能描述: 注册页
     *
     * @return
     */
    @RequestMapping("register")
    public String register(String userType, Model model) {
        model.addAttribute("userType", userType);
        return "common/register";
    }

    /**
     * 功能描述: 登入
     *
     * @return
     */
    @RequestMapping("logIn")
    public String logIn() {
        return "common/login";
    }

    /**
     * 功能描述: 登出
     *
     * @return
     */
    @RequestMapping("logOut")
    public String logOut(HttpSession session) {
        Object sysUser = session.getAttribute(SysUserConstans.SESSION_USER_KEY);
        if (sysUser != null) {
            SysUserUtil.userLogout((SysUser) sysUser);
        }
        session.removeAttribute(SysUserConstans.SESSION_USER_KEY);
        return "common/login";
    }

    /**
     * 保存用户信息
     *
     * @param sysUser
     * @return
     */
    @RequestMapping("saveRegister")
    public String saveRegister(SysUser sysUser) {
        sysUser.setStatus(SysUserConstans.USER_STATUS.NORMAL.getCode());
        sysUser.setPassword(CommonUtil.MD5(sysUser.getPassword()));
        sysUserService.insert(sysUser);
        return "redirect:/?registerFlag=1";
    }


    /**
     * 功能描述：检验登录名是否重复
     */
    @ResponseBody
    @RequestMapping("checkNo")
    public Result checkNo(SysUser sysUser) {
        Integer count = sysUserService.checkNo(sysUser);
        if (count > 0) {
            return new Result(false, "该工号已存在。");
        } else {
            return new Result();
        }
    }

}