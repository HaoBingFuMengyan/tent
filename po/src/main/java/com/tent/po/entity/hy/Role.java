package com.tent.po.entity.hy;

import com.google.common.collect.Lists;
import com.tent.po.entityBase.hy.RoleBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hy_role")
public class Role extends RoleBase{


    private List<Permission> permissionList = Lists.newArrayList();

    @ManyToMany()
    @JoinTable(name = "hy_rolepermission",joinColumns = { @JoinColumn(name = "sroleid") }, inverseJoinColumns = { @JoinColumn(name = "spurviewid") })
    @Fetch(FetchMode.SUBSELECT)
    @Lazy(true)
    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}