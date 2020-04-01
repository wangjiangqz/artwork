package com.work.artwork.common.util;

import com.work.artwork.entity.SysUser;

import java.util.HashMap;

public class SysUserUtil {

    public final static HashMap<String, String> USER_SESSION_MAP = new HashMap<>();

    public static void userLogin(SysUser sysUser) {
        String uid = sysUser.getId().toString();
        USER_SESSION_MAP.put(CommonUtil.MD5(uid), uid);
    }

    public static void userLogout(SysUser sysUser) {
        String uid = sysUser.getId().toString();
        USER_SESSION_MAP.remove(CommonUtil.MD5(uid));
    }
}
