package com.tent.po.entityBase.sp;

import com.tent.common.entity.BaseEntity;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CategoryBase extends BaseEntity {

    private   String ssystemcode; //系统编码 String
    private   String sname; //品种名称 String
    private   String slocalname; //俗名 String
    private   String senname; //英文名 String
    private   String ssubstitute; //替代品 String
    private   String sdescription; //品种介绍 String
    private   String sparentid; //父品种 String
    private   Integer isort=0; //排序号 int
    private   String spyname; //全拼名 String
    private   String sjpname; //简拼名 String
    private   Integer bisindex=0; //是否首页显示 int
    private   Integer biscommon=0; //是否常用 int
    private   String sremark; //说明 String
    private   String sweightunit; //单位 String
    private   String sspec; //规格型号 String
    private   String sproducer; //生产厂家 String
    private   String shostname; //所属设备 String
    private   String shostmodel; //所属设备型号 String
    private   String shostbrand; //所属设备厂商 String

    public String getSsystemcode() {
        return ssystemcode;
    }

    public void setSsystemcode(String ssystemcode) {
        this.ssystemcode = ssystemcode;
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

    public String getSparentid() {
        return sparentid;
    }

    public void setSparentid(String sparentid) {
        this.sparentid = sparentid;
    }

    public Integer getIsort() {
        return isort;
    }

    public void setIsort(Integer isort) {
        this.isort = isort;
    }

    public String getSpyname() {
        return spyname;
    }

    public void setSpyname(String spyname) {
        this.spyname = spyname;
    }

    public String getSjpname() {
        return sjpname;
    }

    public void setSjpname(String sjpname) {
        this.sjpname = sjpname;
    }

    public Integer getBisindex() {
        return bisindex;
    }

    public void setBisindex(Integer bisindex) {
        this.bisindex = bisindex;
    }

    public Integer getBiscommon() {
        return biscommon;
    }

    public void setBiscommon(Integer biscommon) {
        this.biscommon = biscommon;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
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

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
