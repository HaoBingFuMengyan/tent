package com.tent.cloud.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class MyRealmTest {

    SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();
    @Before
    public void getAccount()
    {
        //方便测试  新增用户和角色权限
        simpleAccountRealm.addAccount("papio","papio","admin");
    }
    @Test
    public void AuthenticationTest()
    {
        //1、创建SecurtyManager
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        //2、主体认证/授权
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();//获得当前正在执行程序的用户

        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("papio","papio");
        //3、login()主体认证请求，里面封装好的不用管，它是由SecurityManager认证->Authenticate认证->Realm验证组成，这样就可以实现认证。
        subject.login(usernamePasswordToken);
        System.out.println("isAuthen:"+subject.isAuthenticated());
        //3、checkRole()主体授权请求，里面封装好的不用管，它是由SecurityManager授权->Authenticate授权->Realm获取角色权限组成，这样就可以实现授权功能。
        subject.checkRole("admin");
    }

}
