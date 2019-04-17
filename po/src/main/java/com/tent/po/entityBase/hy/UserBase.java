package com.tent.po.entityBase.hy;


import com.tent.common.entity.BaseEntity;
import com.tent.po.entity.hy.User;
import com.tent.po.entity.hy.UserRole;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class UserBase extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private   String smemberid; //会员ID String
    private   String suserno; //交易员编号 String
    private   String susername; //用户名 String
    private   String spassword; //用户密码 String
    private   String stradepassword; //交易密码 String
    private   String slikename; //昵称 String
    private   String sname; //姓名 String
    private   Integer isex=0; //性别 int
    private   String sphone; //电话 String
    private   String sfax; //传真 String
    private   String smobile; //手机 String
    private   String semail; //Email String
    private   Integer bisymobile=0; //手机号是否已验证 int
    private   Integer bisyemail=0; //Email是否已验证 int
    private   String sqq; //QQ String
    private   Integer bisvalid=1; //是否有效 int
    private   Integer bisadmin=0; //是否管理员 int
    private   Integer bisdelete=0; //是否删除 int
    private   Integer ierrorcount=0; //当天密码错误次数 int
    private   Date dlastlogintime; //上次登陆时间 Date
    private   Date dendlogintime; //最后登陆时间 Date
    private   String sremark; //备注 String
    private   Date dadddate; //添加日期 Date
    private   String saddoperator; //添加人 String
    private   Date dmodifydate; //修改日期 Date
    private   String smodifyoperator; //修改人 String
    private   Date dlastloginsuccessdate; //最后登录成功日期 Date
    private   Integer imembertype=0; //会员类型
    private   Integer iauthtype=0; //认证类型


    public String getSmemberid() {
        return smemberid;
    }

    public void setSmemberid(String smemberid) {
        this.smemberid = smemberid;
    }

    public String getSuserno() {
        return suserno;
    }

    public void setSuserno(String suserno) {
        this.suserno = suserno;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getStradepassword() {
        return stradepassword;
    }

    public void setStradepassword(String stradepassword) {
        this.stradepassword = stradepassword;
    }

    public String getSlikename() {
        return slikename;
    }

    public void setSlikename(String slikename) {
        this.slikename = slikename;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getIsex() {
        return isex;
    }

    public void setIsex(Integer isex) {
        this.isex = isex;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSfax() {
        return sfax;
    }

    public void setSfax(String sfax) {
        this.sfax = sfax;
    }

    public String getSmobile() {
        return smobile;
    }

    public void setSmobile(String smobile) {
        this.smobile = smobile;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Integer getBisymobile() {
        return bisymobile;
    }

    public void setBisymobile(Integer bisymobile) {
        this.bisymobile = bisymobile;
    }

    public Integer getBisyemail() {
        return bisyemail;
    }

    public void setBisyemail(Integer bisyemail) {
        this.bisyemail = bisyemail;
    }

    public String getSqq() {
        return sqq;
    }

    public void setSqq(String sqq) {
        this.sqq = sqq;
    }

    public Integer getBisvalid() {
        return bisvalid;
    }

    public void setBisvalid(Integer bisvalid) {
        this.bisvalid = bisvalid;
    }

    public Integer getBisadmin() {
        return bisadmin;
    }

    public void setBisadmin(Integer bisadmin) {
        this.bisadmin = bisadmin;
    }

    public Integer getBisdelete() {
        return bisdelete;
    }

    public void setBisdelete(Integer bisdelete) {
        this.bisdelete = bisdelete;
    }

    public Integer getIerrorcount() {
        return ierrorcount;
    }

    public void setIerrorcount(Integer ierrorcount) {
        this.ierrorcount = ierrorcount;
    }

    public Date getDlastlogintime() {
        return dlastlogintime;
    }

    public void setDlastlogintime(Date dlastlogintime) {
        this.dlastlogintime = dlastlogintime;
    }

    public Date getDendlogintime() {
        return dendlogintime;
    }

    public void setDendlogintime(Date dendlogintime) {
        this.dendlogintime = dendlogintime;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public Date getDadddate() {
        return dadddate;
    }

    public void setDadddate(Date dadddate) {
        this.dadddate = dadddate;
    }

    public String getSaddoperator() {
        return saddoperator;
    }

    public void setSaddoperator(String saddoperator) {
        this.saddoperator = saddoperator;
    }

    public Date getDmodifydate() {
        return dmodifydate;
    }

    public void setDmodifydate(Date dmodifydate) {
        this.dmodifydate = dmodifydate;
    }

    public String getSmodifyoperator() {
        return smodifyoperator;
    }

    public void setSmodifyoperator(String smodifyoperator) {
        this.smodifyoperator = smodifyoperator;
    }

    public Date getDlastloginsuccessdate() {
        return dlastloginsuccessdate;
    }

    public void setDlastloginsuccessdate(Date dlastloginsuccessdate) {
        this.dlastloginsuccessdate = dlastloginsuccessdate;
    }

    public Integer getImembertype() {
        return imembertype;
    }

    public void setImembertype(Integer imembertype) {
        this.imembertype = imembertype;
    }

    public Integer getIauthtype() {
        return iauthtype;
    }

    public void setIauthtype(Integer iauthtype) {
        this.iauthtype = iauthtype;
    }

    public UserBase() {
    }
    public UserBase(User user) {
        this.smemberid = user.getSmemberid();
        this.suserno = user.getSuserno();
        this.susername = user.getSusername();
        this.spassword = user.getSpassword();
        this.stradepassword = user.getStradepassword();
        this.slikename = user.getSlikename();
        this.sname = user.getSname();
        this.isex = user.getIsex();
        this.sphone = user.getSphone();
        this.sfax = user.getSfax();
        this.smobile = user.getSmobile();
        this.semail = user.getSemail();
        this.bisymobile = user.getBisymobile();
        this.bisyemail = user.getBisyemail();
        this.sqq = user.getSqq();
        this.bisvalid = user.getBisvalid();
        this.bisadmin = user.getBisadmin();
        this.bisdelete = user.getBisdelete();
        this.ierrorcount = user.getIerrorcount();
        this.dlastlogintime = user.getDlastlogintime();
        this.dendlogintime = user.getDendlogintime();
        this.sremark = user.getSremark();
        this.dadddate = user.getDadddate();
        this.saddoperator = user.getSaddoperator();
        this.dmodifydate = user.getDmodifydate();
        this.smodifyoperator = user.getSmodifyoperator();
        this.dlastloginsuccessdate = user.getDlastloginsuccessdate();
        this.imembertype = user.getImembertype();
        this.iauthtype = user.getIauthtype();
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
