package com.tent.service.impl.hy;

import com.tent.common.entity.UUser;
import com.tent.dao.hy.UserDao;
import com.tent.po.entity.hy.User;
import com.tent.service.inte.hy.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public User insert(User record) {
        return null;
    }

    @Override
    public User insertSelective(User record) {
        return null;
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public void updateByPrimaryKeySelective(User record) {
        record.setStatus(UUser._1);//更新用户状态

        this.userDao.save(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public User login(String email, String pswd) {
//        return this.userDao.findByEmailAndPswd(email,pswd);
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public Map<String, Object> deleteUserById(String ids) {
        return null;
    }

    @Override
    public Map<String, Object> updateForbidUserById(Long id, Long status) {
        return null;
    }

    @Override
    public Map<String, Object> addRole2User(Long userId, String ids) {
        return null;
    }

    @Override
    public Map<String, Object> deleteRoleByUserIds(String userIds) {
        return null;
    }
}
