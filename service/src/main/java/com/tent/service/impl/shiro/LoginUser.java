package com.tent.service.impl.shiro;

import com.tent.common.entity.Consts;
import com.tent.common.shiro.ILoginUser;

import java.io.Serializable;
import java.util.Date;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class LoginUser implements Serializable, ILoginUser {

    private String id;
    private String loginName;
    private String name;
    private int bisadmin;
    private Date lastlogintime;
    private String password;
    private String memberId;
    private int membertype;
    private String membercnname;
    private String memberno;
    private int bissalesman;
    private String slikename;
    private String smobile;
    private int bisselfsaler;
    private int authtype;
    private int bisvalid;

    public LoginUser(String id, String loginName, String name, int bisadmin, Date lastlogintime, String password, String memberId, int membertype, String membercnname, String memberno, int bissalesman, String slikename, String smobile, int bisselfsaler, int authtype, int bisvalid) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.bisadmin = bisadmin;
        this.lastlogintime = lastlogintime;
        this.password = password;
        this.memberId = memberId;
        this.membertype = membertype;
        this.membercnname = membercnname;
        this.memberno = memberno;
        this.bissalesman = bissalesman;
        this.slikename = slikename;
        this.smobile = smobile;
        this.bisselfsaler = bisselfsaler;
        this.authtype = authtype;
        this.bisvalid = bisvalid;
    }

    public int getBisvalid(){
        return this.bisvalid;
    }

    public int getAuthtype() {
        return this.authtype;
    }

    public int getMembertype() {
        return this.membertype;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getLoginName() {
        return this.loginName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastlogintime() {
        return null;
    }

    @Override
    public boolean IsAdmin() {
        if (Consts.BoolType.NO.isEq(this.bisadmin))
            return false;
        else
            return true;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getMemberId() {
        return this.memberId;
    }

    @Override
    public String getMemberName() {
        return this.membercnname;
    }

    /**
     * 重载equals,只计算loginName;
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LoginUser other = (LoginUser) obj;
        if (loginName == null) {
            if (other.loginName != null) {
                return false;
            }
        } else if (!loginName.equals(other.loginName)) {
            return false;
        }
        return true;
    }
}
