package com.tent.po.entityBase.hy;

import com.tent.common.entity.BaseEntity;

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

}
