package com.tent.common.shiro;

public interface ILoginUser {

    public abstract String getId();

    public abstract String getLoginName();

    public abstract String getName();

    public abstract String getLastlogintime();

    public abstract boolean IsAdmin();

    public abstract String getPassword();

    public abstract String getMemberId();

    public abstract String getMemberName();

    public abstract int getBisproducer();
}
