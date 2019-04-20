package com.tent.cloud.shiro.token;

import com.google.common.collect.Sets;
import com.tent.common.shiro.ILoginUser;
import com.tent.common.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {
    public ShiroUtils() {
    }

    public static String getCurrentUserName() {
        ILoginUser user = (ILoginUser)SecurityUtils.getSubject().getPrincipal();
        return user == null?"":user.getLoginName();
    }

    public static String getCurrentName() {
        ILoginUser user = (ILoginUser)SecurityUtils.getSubject().getPrincipal();
        return user == null?"":user.getName();
    }

    public static String getCurrentMemberId() {
        ILoginUser user = (ILoginUser) SecurityUtils.getSubject().getPrincipal();
        return user == null?"":user.getMemberId();
    }

    public static String getCurrentUserId() {
        ILoginUser user = (ILoginUser)SecurityUtils.getSubject().getPrincipal();
        return user == null?"":user.getId();
    }

    public static boolean isAdmin() {
        ILoginUser user = (ILoginUser)SecurityUtils.getSubject().getPrincipal();
        if(user == null) {
            return false;
        } else {
            Sets.newHashSet();
            return user.IsAdmin();
        }
    }

    public static ILoginUser getCurrentUser() {
        return (ILoginUser)SecurityUtils.getSubject().getPrincipal();
    }

    public static String EncodePassword(String spassword) {
        return MD5.encode(spassword);
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

}
