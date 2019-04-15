package com.tent.po.entityBase.hy;

import com.tent.common.entity.BaseEntity;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RolePermissionBase extends BaseEntity {

    private   String sroleid; //角色ID String
    private   String spurviewid; //权限码ID String

    public String getSroleid() {
        return sroleid;
    }

    public void setSroleid(String sroleid) {
        this.sroleid = sroleid;
    }

    public String getSpurviewid() {
        return spurviewid;
    }

    public void setSpurviewid(String spurviewid) {
        this.spurviewid = spurviewid;
    }

    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
