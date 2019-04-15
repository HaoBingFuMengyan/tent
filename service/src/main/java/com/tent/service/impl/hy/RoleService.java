package com.tent.service.impl.hy;

import com.google.common.collect.Sets;
import com.tent.dao.hy.RoleDao;
import com.tent.po.entity.hy.Role;
import com.tent.service.inte.hy.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@Transactional
public class RoleService implements IRoleService{

    @Autowired
    private RoleDao roleDao;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }

    @Override
    public Map<String, Object> deleteRoleById(String ids) {
        return null;
    }

    @Override
    public Set<String> findRoleByUserId(String userId) {
        HashSet<String> map = Sets.newHashSet("user");
        return map;
    }

    @Override
    public void initData() {

    }
}
