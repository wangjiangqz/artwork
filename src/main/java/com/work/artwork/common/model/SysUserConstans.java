package com.work.artwork.common.model;

public class SysUserConstans {

    public final static String SESSION_USER_KEY = "user_in_session";

    public enum USER_STATUS {
        NORMAL("0", "正常"),
        INVALID("1", "失效"),
        DELETE("9", "删除");

        public String code;
        public String msg;

        USER_STATUS(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

}
