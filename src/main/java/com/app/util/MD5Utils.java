package com.app.util;

import org.apache.commons.codec.digest.DigestUtils;
public class MD5Utils {
    //调用MD5加密
    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }
    //加密字符 基数
    private static final String privateKey = "miasanmiaarcaea";
    //将原始的密码首先进行加工：
//原始密码：123123 ，密码加工   1x1231233
    public static String inputPassToNewPass(String pass){
        String newPass =
                privateKey.charAt(0)+privateKey.charAt(1)+pass+privateKey.charAt(5)+"";
        return newPass; //1x1231233
    }
    public static void main(String[] args) {
        System.out.println(md5(inputPassToNewPass("123123")));
    }
}

