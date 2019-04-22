package com.tent.service.impl.hy;

import com.tent.common.entity.Consts;
import com.tent.common.entity.UUser;
import com.tent.dao.hy.UserDao;
import com.tent.po.entity.hy.Member;
import com.tent.po.entity.hy.User;
import com.tent.service.impl.shiro.LoginUser;
import com.tent.service.inte.hy.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Component
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;

    @Override
    public LoginUser findBySusernameOrSmobile(String susername, String smobile) {
        User user = this.userDao.findBySusernameOrSmobile(susername,smobile);
        if (user == null)
            return null;
        if (Consts.BoolType.YES.isEq(user.getBisdelete()))
            return null;
        if (Consts.BoolType.NO.isEq(user.getBisvalid()))
            return null;

        Member member = user.getMember();
        if (member == null)
            return null;

        LoginUser loginUser = new LoginUser(user.getId(), user.getSusername(), user.getSname(), user.getBisadmin(), user.getDlastloginsuccessdate(),
                user.getSpassword(), member.getId(), member.getImembertype(), member.getScnname(), member.getSmemberno(), 0, user.getSlikename(),user.getSmobile(),0,member.getIauthtype(),user.getBisvalid(),user.getBisproducer());


        return loginUser;
    }

    @Override
    public void updateByPrimaryKeySelective(LoginUser record) {

        User user = this.userDao.findOne(record.getId());

        user.setDlastloginsuccessdate(new Date());//更新最后登陆成功时间
        user.setBisvalid(UUser._1);//更新用户状态

        this.userDao.save(user);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public User insert(User record) {
        return this.userDao.save(record);
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
