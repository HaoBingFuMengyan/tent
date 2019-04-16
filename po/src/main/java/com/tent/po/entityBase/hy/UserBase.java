package com.tent.po.entityBase.hy;


import com.tent.common.entity.BaseEntity;
import com.tent.po.entity.hy.User;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class UserBase extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**昵称*/
    private String nickname;
    /**邮箱 | 登录帐号*/
    private String email;
    /**密码*/
    private transient String pswd;
    /**创建时间*/
    private Date createTime;
    /**最后登录时间*/
    private Date lastLoginTime;
    /**1:有效，0:禁止登录*/
    private Integer status;

    public UserBase(){}
    public UserBase(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.pswd = user.getPswd();
        this.createTime = user.getCreateTime();
        this.lastLoginTime = user.getLastLoginTime();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
