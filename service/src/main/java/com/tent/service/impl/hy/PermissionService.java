package com.tent.service.impl.hy;

import com.google.common.collect.Sets;
import com.tent.common.utils.B;
import com.tent.common.utils.LoggerUtils;
import com.tent.dao.hy.PermissionDao;
import com.tent.po.entity.hy.Permission;
import com.tent.service.inte.hy.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Transactional
public class PermissionService implements IPermissionService{


    @Autowired
    private PermissionDao permissionDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public Permission insert(Permission record) {
        return null;
    }

    @Override
    public Permission insertSelective(Permission record) {
        return null;
    }

    @Override
    public Permission selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return 0;
    }

    @Override
    public Map<String, Object> deletePermissionById(String ids) {
        return null;
    }

    @Override
    public List<Permission> selectPermissionById(String id) {
        return null;
    }

    @Override
    public Map<String, Object> addPermission2Role(String roleId, String ids) {
        return null;
    }

    @Override
    public Map<String, Object> deleteByRids(String roleIds) {
        return null;
    }

    @Override
    public Set<String> findPermissionByUserId(String userId) {

        Collection<String> db;
        Set<String> rs = Sets.newHashSet();

        db = this.permissionDao.getAllPermission(userId);

        for (String t : db) {
            String[] as = t.split(",");
            for (String b : as) {
                if(B.N(b.trim()))
                    rs.add(b.trim());
            }
        }
        LoggerUtils.debug(getClass(),"所有权限："+ rs.toString());

        return rs;
    }
}