package com.work.artwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.work.artwork.common.model.Result;
import com.work.artwork.common.model.SysUserConstans;
import com.work.artwork.common.utils.CommonUtil;
import com.work.artwork.entity.SysUser;
import com.work.artwork.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-04-01 11:30:06
 */
@Controller
@RequestMapping("/after/sysUser/")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 查看修改个人信息
     *
     * @return 单条数据
     */
    @RequestMapping("userInfo")
    public String userInfo(HttpServletRequest request, Model model, String updateFlag) {
        Object sysUser = request.getSession().getAttribute(SysUserConstans.SESSION_USER_KEY);
        if (sysUser != null) {
            sysUser = this.sysUserService.queryById(((SysUser) sysUser).getId());
            model.addAttribute("sysUser", sysUser);
            model.addAttribute("updateFlag", updateFlag);
        }
        return "user/userInfo";
    }

    /**
     * 人员列表页
     *
     * @return
     */
    @RequestMapping("userList")
    public String userList(String updateFlag, Model model) {
        model.addAttribute("updateFlag", updateFlag);
        return "user/userList";
    }

    /**
     * 人员列表页数据填充
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/userListData")
    public JSONObject userListData(SysUser sysUser, int page, int limit) {
        return sysUserService.queryListData(sysUser, page, limit);
    }

    /**
     * 用户的添加/修改
     *
     * @return
     */
    @RequestMapping("/userAdd")
    public String userAdd(SysUser sysUser, Model model) {
        sysUser = sysUserService.queryById(sysUser.getId());
        if (sysUser != null) {
            model.addAttribute("sysUser",sysUser);
        }
        return "user/userAdd";
    }

    /**
     * 用户查看
     *
     * @param sysUser
     * @param model
     * @return
     */
    @RequestMapping("/userView")
    public String userView(SysUser sysUser, Model model) {
        if (sysUser != null && sysUser.getId() != null && sysUser.getId() != 0) {
            model.addAttribute("user", sysUserService.queryById(sysUser.getId()));
        }
        return "user/userView";
    }

    /**
     * 用户新增
     *
     * @param sysUser
     * @return
     */
    @RequestMapping("/userSave")
    public String userSave(SysUser sysUser) {
        if (StringUtils.hasText(sysUser.getPassword())){
            sysUser.setPassword(CommonUtil.MD5(sysUser.getPassword()));
        }
        if (sysUser.getId() != null){
            sysUserService.update(sysUser);
        }else {
            sysUserService.insert(sysUser);
        }
        return "redirect:/after/sysUser/userList?updateFlag=1";
    }

    /**
     * 用户修改
     *
     * @param sysUser
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public Result updateStatus(SysUser sysUser) {
        if (StringUtils.hasText(sysUser.getPassword())){
            sysUser.setPassword(CommonUtil.MD5(sysUser.getPassword()));
        }
        sysUserService.update(sysUser);
        return new Result();
    }

    /**
     * 用户删除
     *
     * @param sysUser
     * @return
     */
    @ResponseBody
    @RequestMapping("/userDel")
    public Result userDel(SysUser sysUser) {
        if (sysUser != null && sysUser.getId() != null && sysUser.getId() != 0) {
            sysUserService.deleteById(sysUser.getId());
        }
        return new Result();
    }

    @RequestMapping("updateRegister")
    public String updateRegister(SysUser sysUser, HttpSession session) {
        if (StringUtils.hasText(sysUser.getPassword())){
            sysUser.setPassword(CommonUtil.MD5(sysUser.getPassword()));
        }
        sysUserService.update(sysUser);
        session.setAttribute(SysUserConstans.SESSION_USER_KEY, sysUser);
        return "redirect:/after/sysUser/userInfo?updateFlag=1";
    }

}