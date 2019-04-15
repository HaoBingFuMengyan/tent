package com.tent.po.entityBase.hy;

import com.tent.common.entity.BaseEntity;
import net.sf.json.JSONObject;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RoleBase extends BaseEntity {

    /**角色名称*/
    private String srolename;
    /**角色类型*/
    private String type;
    /**备注*/
    private String sremark;

    public String getSrolename() {
        return srolename;
    }

    public void setSrolename(String srolename) {
        this.srolename = srolename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
