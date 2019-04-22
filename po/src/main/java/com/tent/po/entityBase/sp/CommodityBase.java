package com.tent.po.entityBase.sp;

import com.tent.common.entity.BaseEntity;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class CommodityBase extends BaseEntity {

    private   String scommoditysystemcode; //品名系统编码 String
    private   String scategoryid; //品种ID String
    private   String sname; //品名 String
    private   String slocalname; //俗名 String
    private   String senname; //英文名 String
    private   String ssubstitute; //替代品 String
    private   String sdescription; //品种介绍 String
    private   String sjpname; //简拼名 String
    private   String spyname; //全拼名 String
    private   String saddress; //图片地址 String
    private   Integer biscommon=0; //是否常用 int
    private   String sspecset; //规格设置 String
    private   String sweightunit; //计量单位 String
    private   String sspec; //规格型号 String
    private   String sproducer; //生产厂家 String
    private   String shostname; //所属设备 String
    private   String shostmodel; //所属设备型号 String
    private   String shostbrand; //所属设备厂商 String
    private Date daddtime; //添加时间 Date
    private   String ssupplier; //供应商 String
    private   Integer iimgtype=0; //图片类型 int
    private   String sappdescription; //app品种介绍 String
    private   Integer bisaddimg=0; //图片是否维护 int

    public String getScommoditysystemcode() {
        return scommoditysystemcode;
    }

    public void setScommoditysystemcode(String scommoditysystemcode) {
        this.scommoditysystemcode = scommoditysystemcode;
    }

    public String getScategoryid() {
        return scategoryid;
    }

    public void setScategoryid(String scategoryid) {
        this.scategoryid = scategoryid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSlocalname() {
        return slocalname;
    }

    public void setSlocalname(String slocalname) {
        this.slocalname = slocalname;
    }

    public String getSenname() {
        return senname;
    }

    public void setSenname(String senname) {
        this.senname = senname;
    }

    public String getSsubstitute() {
        return ssubstitute;
    }

    public void setSsubstitute(String ssubstitute) {
        this.ssubstitute = ssubstitute;
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

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public Integer getBiscommon() {
        return biscommon;
    }

    public void setBiscommon(Integer biscommon) {
        this.biscommon = biscommon;
    }

    public String getSspecset() {
        return sspecset;
    }

    public void setSspecset(String sspecset) {
        this.sspecset = sspecset;
    }

    public String getSweightunit() {
        return sweightunit;
    }

    public void setSweightunit(String sweightunit) {
        this.sweightunit = sweightunit;
    }

    public String getSspec() {
        return sspec;
    }

    public void setSspec(String sspec) {
        this.sspec = sspec;
    }

    public String getSproducer() {
        return sproducer;
    }

    public void setSproducer(String sproducer) {
        this.sproducer = sproducer;
    }

    public String getShostname() {
        return shostname;
    }

    public void setShostname(String shostname) {
        this.shostname = shostname;
    }

    public String getShostmodel() {
        return shostmodel;
    }

    public void setShostmodel(String shostmodel) {
        this.shostmodel = shostmodel;
    }

    public String getShostbrand() {
        return shostbrand;
    }

    public void setShostbrand(String shostbrand) {
        this.shostbrand = shostbrand;
    }

    public Date getDaddtime() {
        return daddtime;
    }

    public void setDaddtime(Date daddtime) {
        this.daddtime = daddtime;
    }

    public String getSsupplier() {
        return ssupplier;
    }

    public void setSsupplier(String ssupplier) {
        this.ssupplier = ssupplier;
    }

    public Integer getIimgtype() {
        return iimgtype;
    }

    public void setIimgtype(Integer iimgtype) {
        this.iimgtype = iimgtype;
    }

    public String getSappdescription() {
        return sappdescription;
    }

    public void setSappdescription(String sappdescription) {
        this.sappdescription = sappdescription;
    }

    public Integer getBisaddimg() {
        return bisaddimg;
    }

    public void setBisaddimg(Integer bisaddimg) {
        this.bisaddimg = bisaddimg;
    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
