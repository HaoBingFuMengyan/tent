package com.tent.po.entityBase.hy;

import com.tent.common.entity.BaseEntity;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserRoleBase extends BaseEntity{
    private   String suserid; //交易员 String
    private   String sroleid; //角色 String

    public String getSuserid() {
        return suserid;
    }

    public void setSuserid(String suserid) {
        this.suserid = suserid;
    }

    public String getSroleid() {
        return sroleid;
    }

    public void setSroleid(String sroleid) {
        this.sroleid = sroleid;
    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
