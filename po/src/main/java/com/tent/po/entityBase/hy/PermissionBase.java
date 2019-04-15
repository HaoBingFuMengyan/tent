package com.tent.po.entityBase.hy;

import com.tent.common.entity.BaseEntity;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class PermissionBase extends BaseEntity {

    private   String spurno; //权限编号 String
    private   String spurcode; //权限码 String
    private   String spurname; //权限名称 String
    private   String sparentname; //父菜单名称 String
    private   String sparentid; //父菜单ID String
    private   String surlpath; //访问路径 String
    private   String sdescription; //权限说明 String
    private   String sjpname; //简拼名 String
    private   String spyname; //全拼名 String
    private   Date dadddate; //添加日期 Date

    public String getSpurno() {
        return spurno;
    }

    public void setSpurno(String spurno) {
        this.spurno = spurno;
    }

    public String getSpurcode() {
        return spurcode;
    }

    public void setSpurcode(String spurcode) {
        this.spurcode = spurcode;
    }

    public String getSpurname() {
        return spurname;
    }

    public void setSpurname(String spurname) {
        this.spurname = spurname;
    }

    public String getSparentname() {
        return sparentname;
    }

    public void setSparentname(String sparentname) {
        this.sparentname = sparentname;
    }

    public String getSparentid() {
        return sparentid;
    }

    public void setSparentid(String sparentid) {
        this.sparentid = sparentid;
    }

    public String getSurlpath() {
        return surlpath;
    }

    public void setSurlpath(String surlpath) {
        this.surlpath = surlpath;
    }

    public String getSdescription() {
        return sdescription;
    }

    public void setSdescription(String sdescription) {
        this.sdescription = sdescription;
    }

    public String getSjpname() {
        return sjpname;
    }

    public void setSjpname(String sjpname) {
        this.sjpname = sjpname;
    }

    public String getSpyname() {
        return spyname;
    }

    public void setSpyname(String spyname) {
        this.spyname = spyname;
    }

    public Date getDadddate() {
        return dadddate;
    }

    public void setDadddate(Date dadddate) {
        this.dadddate = dadddate;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
