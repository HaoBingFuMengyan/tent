package com.tent.dao.hy;


import com.tent.common.jpa.BaseDao;
import com.tent.po.entity.hy.Permission;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface PermissionDao extends BaseDao<Permission,String>{


//    @Query("select distinct(p.surlpath) from   ro join ro.rightList p  where ro.id in (select o.sroleid from  UserActor o where o.suserid=?1)")
//    Collection<String> getAllPermission(String userid);
}
