package com.tent.po.entityBase.hy;

import com.tent.common.entity.BaseEntity;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class MemberBase extends BaseEntity{

    private   String smemberno; //企业编号 String
    private   String scnname; //企业名称 String
    private   String senname; //英文名称 String
    private   String sshortname; //中文简称 String
    private   Integer icredit=0; //信用值 int
    private   Integer icompanytype=0; //公司类型 int
    private   Integer imembertype=0; //会员类型 int
    private   String sbusinessmode; //经营模式 String
    private   String smemberkind; //企业性质 String
    private   String sbusinessno; //工商执照号 String
    private   String sorgcode; //组织机构代码 String
    private   String slegalpersoncode; //法定代表人身份证 String
    private   String staxno; //税务登记号 String
    private   String slegalperson; //法人 String
    private   Integer iemployeeamount=0; //员工人数 int
    private   String sareaid; //地区区号 String
    private   String sprovince; //省份 String
    private   String scity; //城市 String
    private   String sregion; //区县 String
    private   String sopenbank; //开户银行 String
    private   String sopenname; //开户名称 String
    private   String sopenaccount; //开户账号 String
    private   String sbalancebank; //结算银行 String
    private   String sunionaccount; //联行号 String
    private   String sbalancename; //结算户名 String
    private   String sfax; //传真 String
    private   String sbusbigtype; //主营行业大类 String
    private   String sbussmalltype; //主营行业小类 String
    private   String sbussmallname; //主营小类名称 String
    private   String sregaddress; //注册地址 String
    private   String sbusaddress; //经营地址 String
    private   String slinkman; //联系人 String
    private   String szipcode; //邮编 String
    private   String sphone; //电话 String
    private   String smobile; //手机 String
    private   String semail; //Email String
    private   String scompanydesc; //公司简介 String
    private   Date dvaliddate; //有效期 Date
    private   Integer imemberstatus=3; //状态 int
    private   String scheckuserid; //审核人 String
    private   Date dcheckdate; //审核日期 Date
    private   String scheckinfo; //审核意见 String
    private   String sremark; //备注 String
    private   Integer bdelete=0; //是否删除 int
    private   String slogo; //会员LOGO String
    private   Date dapplydate; //申请日期 Date
    private   String sadduser; //添加人 String
    private   Date dmodifydate; //修改日期 Date
    private   String smodifyoperator; //修改人 String
    private   String sshortnamejpname; //简称简拼名 String
    private   String sshortnamepyname; //简称全拼名 String
    private   String sjpname; //简拼名 String
    private   String spyname; //全拼名 String
    private   Integer iauthtype=0; //认证类型 int
    private   Integer isort=0; //排序号 int
    private   String slocation; //地理位置 String
    private   Integer bisopenshop=0; //是否已开通店铺 int
    private   Integer biscardmerged=0; //是否三码合一 int
    private   String ssocialcreditno; //统一社会信息用代码 String
    private   Integer bismembercert=0; //是否通过企业认证 int
    private   Integer bcusource=0; //客户来源


    public String getSmemberno() {
        return smemberno;
    }

    public void setSmemberno(String smemberno) {
        this.smemberno = smemberno;
    }

    public String getScnname() {
        return scnname;
    }

    public void setScnname(String scnname) {
        this.scnname = scnname;
    }

    public String getSenname() {
        return senname;
    }

    public void setSenname(String senname) {
        this.senname = senname;
    }

    public String getSshortname() {
        return sshortname;
    }

    public void setSshortname(String sshortname) {
        this.sshortname = sshortname;
    }

    public Integer getIcredit() {
        return icredit;
    }

    public void setIcredit(Integer icredit) {
        this.icredit = icredit;
    }

    public Integer getIcompanytype() {
        return icompanytype;
    }

    public void setIcompanytype(Integer icompanytype) {
        this.icompanytype = icompanytype;
    }

    public Integer getImembertype() {
        return imembertype;
    }

    public void setImembertype(Integer imembertype) {
        this.imembertype = imembertype;
    }

    public String getSbusinessmode() {
        return sbusinessmode;
    }

    public void setSbusinessmode(String sbusinessmode) {
        this.sbusinessmode = sbusinessmode;
    }

    public String getSmemberkind() {
        return smemberkind;
    }

    public void setSmemberkind(String smemberkind) {
        this.smemberkind = smemberkind;
    }

    public String getSbusinessno() {
        return sbusinessno;
    }

    public void setSbusinessno(String sbusinessno) {
        this.sbusinessno = sbusinessno;
    }

    public String getSorgcode() {
        return sorgcode;
    }

    public void setSorgcode(String sorgcode) {
        this.sorgcode = sorgcode;
    }

    public String getSlegalpersoncode() {
        return slegalpersoncode;
    }

    public void setSlegalpersoncode(String slegalpersoncode) {
        this.slegalpersoncode = slegalpersoncode;
    }

    public String getStaxno() {
        return staxno;
    }

    public void setStaxno(String staxno) {
        this.staxno = staxno;
    }

    public String getSlegalperson() {
        return slegalperson;
    }

    public void setSlegalperson(String slegalperson) {
        this.slegalperson = slegalperson;
    }

    public Integer getIemployeeamount() {
        return iemployeeamount;
    }

    public void setIemployeeamount(Integer iemployeeamount) {
        this.iemployeeamount = iemployeeamount;
    }

    public String getSareaid() {
        return sareaid;
    }

    public void setSareaid(String sareaid) {
        this.sareaid = sareaid;
    }

    public String getSprovince() {
        return sprovince;
    }

    public void setSprovince(String sprovince) {
        this.sprovince = sprovince;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public String getSregion() {
        return sregion;
    }

    public void setSregion(String sregion) {
        this.sregion = sregion;
    }

    public String getSopenbank() {
        return sopenbank;
    }

    public void setSopenbank(String sopenbank) {
        this.sopenbank = sopenbank;
    }

    public String getSopenname() {
        return sopenname;
    }

    public void setSopenname(String sopenname) {
        this.sopenname = sopenname;
    }

    public String getSopenaccount() {
        return sopenaccount;
    }

    public void setSopenaccount(String sopenaccount) {
        this.sopenaccount = sopenaccount;
    }

    public String getSbalancebank() {
        return sbalancebank;
    }

    public void setSbalancebank(String sbalancebank) {
        this.sbalancebank = sbalancebank;
    }

    public String getSunionaccount() {
        return sunionaccount;
    }

    public void setSunionaccount(String sunionaccount) {
        this.sunionaccount = sunionaccount;
    }

    public String getSbalancename() {
        return sbalancename;
    }

    public void setSbalancename(String sbalancename) {
        this.sbalancename = sbalancename;
    }

    public String getSfax() {
        return sfax;
    }

    public void setSfax(String sfax) {
        this.sfax = sfax;
    }

    public String getSbusbigtype() {
        return sbusbigtype;
    }

    public void setSbusbigtype(String sbusbigtype) {
        this.sbusbigtype = sbusbigtype;
    }

    public String getSbussmalltype() {
        return sbussmalltype;
    }

    public void setSbussmalltype(String sbussmalltype) {
        this.sbussmalltype = sbussmalltype;
    }

    public String getSbussmallname() {
        return sbussmallname;
    }

    public void setSbussmallname(String sbussmallname) {
        this.sbussmallname = sbussmallname;
    }

    public String getSregaddress() {
        return sregaddress;
    }

    public void setSregaddress(String sregaddress) {
        this.sregaddress = sregaddress;
    }

    public String getSbusaddress() {
        return sbusaddress;
    }

    public void setSbusaddress(String sbusaddress) {
        this.sbusaddress = sbusaddress;
    }

    public String getSlinkman() {
        return slinkman;
    }

    public void setSlinkman(String slinkman) {
        this.slinkman = slinkman;
    }

    public String getSzipcode() {
        return szipcode;
    }

    public void setSzipcode(String szipcode) {
        this.szipcode = szipcode;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
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

    public String getScompanydesc() {
        return scompanydesc;
    }

    public void setScompanydesc(String scompanydesc) {
        this.scompanydesc = scompanydesc;
    }

    public Date getDvaliddate() {
        return dvaliddate;
    }

    public void setDvaliddate(Date dvaliddate) {
        this.dvaliddate = dvaliddate;
    }

    public Integer getImemberstatus() {
        return imemberstatus;
    }

    public void setImemberstatus(Integer imemberstatus) {
        this.imemberstatus = imemberstatus;
    }

    public String getScheckuserid() {
        return scheckuserid;
    }

    public void setScheckuserid(String scheckuserid) {
        this.scheckuserid = scheckuserid;
    }

    public Date getDcheckdate() {
        return dcheckdate;
    }

    public void setDcheckdate(Date dcheckdate) {
        this.dcheckdate = dcheckdate;
    }

    public String getScheckinfo() {
        return scheckinfo;
    }

    public void setScheckinfo(String scheckinfo) {
        this.scheckinfo = scheckinfo;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public Integer getBdelete() {
        return bdelete;
    }

    public void setBdelete(Integer bdelete) {
        this.bdelete = bdelete;
    }

    public String getSlogo() {
        return slogo;
    }

    public void setSlogo(String slogo) {
        this.slogo = slogo;
    }

    public Date getDapplydate() {
        return dapplydate;
    }

    public void setDapplydate(Date dapplydate) {
        this.dapplydate = dapplydate;
    }

    public String getSadduser() {
        return sadduser;
    }

    public void setSadduser(String sadduser) {
        this.sadduser = sadduser;
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

    public String getSshortnamejpname() {
        return sshortnamejpname;
    }

    public void setSshortnamejpname(String sshortnamejpname) {
        this.sshortnamejpname = sshortnamejpname;
    }

    public String getSshortnamepyname() {
        return sshortnamepyname;
    }

    public void setSshortnamepyname(String sshortnamepyname) {
        this.sshortnamepyname = sshortnamepyname;
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

    public Integer getIauthtype() {
        return iauthtype;
    }

    public void setIauthtype(Integer iauthtype) {
        this.iauthtype = iauthtype;
    }

    public Integer getIsort() {
        return isort;
    }

    public void setIsort(Integer isort) {
        this.isort = isort;
    }

    public String getSlocation() {
        return slocation;
    }

    public void setSlocation(String slocation) {
        this.slocation = slocation;
    }

    public Integer getBisopenshop() {
        return bisopenshop;
    }

    public void setBisopenshop(Integer bisopenshop) {
        this.bisopenshop = bisopenshop;
    }

    public Integer getBiscardmerged() {
        return biscardmerged;
    }

    public void setBiscardmerged(Integer biscardmerged) {
        this.biscardmerged = biscardmerged;
    }

    public String getSsocialcreditno() {
        return ssocialcreditno;
    }

    public void setSsocialcreditno(String ssocialcreditno) {
        this.ssocialcreditno = ssocialcreditno;
    }

    public Integer getBismembercert() {
        return bismembercert;
    }

    public void setBismembercert(Integer bismembercert) {
        this.bismembercert = bismembercert;
    }

    public Integer getBcusource() {
        return bcusource;
    }

    public void setBcusource(Integer bcusource) {
        this.bcusource = bcusource;
    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
