package com.tent.cloud.hy;

import com.tent.common.shiro.ILoginUser;
import com.tent.common.utils.S;
import com.tent.service.impl.hy.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class LoginAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.html",method = RequestMethod.GET)
    public String login(Model model) {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return S.redirect("index.shtml");
        }
        return S.toPage("member/login");
    }

    @RequestMapping(value = "login.html", method = RequestMethod.POST)
    public String fail(
            @RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,
            Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM,
                userName);
        ILoginUser u = userService.findBySusernameOrSmobile(userName,userName);
        if(u==null)
            model.addAttribute("errormsg", "用户不存在");

        model.addAttribute("userName",userName);
        return S.toPage("member/login");
    }

//    @RequestMapping(value="login.html", method=RequestMethod.POST)
//    public void login(HttpServletRequest request){
//        String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String checkword = request.getParameter("checkword");
//
//        System.out.println("登陆输入的验证码为：" + checkword + ",原始验证为：" + request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
//
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);
//        Lg.debug(getClass(),"验证登陆用户封装的token为："+ ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
//        //获取当前的Subject
//        Subject currentUser = SecurityUtils.getSubject();
//        try {
//            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
//            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
//            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证开始");
//            currentUser.login(token);
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证通过");
//            resultPageURL = "main";
//        }catch(UnknownAccountException uae){
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证，验证未通过，未知账户");
//            request.setAttribute("message_login", "未知账户");
//        }catch(IncorrectCredentialsException ice){
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证，验证失败，错误凭证");
//            request.setAttribute("message_login", "密码不正确");
//        }catch(LockedAccountException lae){
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证，验证失败，账户已锁定");
//            request.setAttribute("message_login", "账户已锁定");
//        }catch(ExcessiveAttemptsException eae){
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证，验证失败，错误次数过多");
//            request.setAttribute("message_login", "用户名或密码错误次数过多");
//        }catch(AuthenticationException ae){
//            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证，验证失败，堆栈轨迹如下");
//            ae.printStackTrace();
//            request.setAttribute("message_login", "用户名或密码不正确");
//        }
//        //验证是否登录成功
//        if(currentUser.isAuthenticated()){
//            Lg.debug(getClass(),"用户[" + username + "]进行登录验证，验证通过（这里可以进行一些认证通过后的一些系统参数初始化操作）");
//
//            getUserInfo(request);
//            System.out.println(SecurityUtils.getSubject().isAuthenticated());
//        }else{
//            token.clear();
//        }
//    }

    /**
     * 用户登出
     */
    @RequestMapping("logout.html")
    public String logout(HttpServletRequest request){
        SecurityUtils.getSubject().logout();
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/index.html";
    }

    public void getUserInfo(HttpServletRequest request){
        String currentUser = (String)request.getSession().getAttribute("currentUser");
        System.out.println("当前登录的用户为[" + currentUser + "]");
        request.setAttribute("currUser", currentUser);
    }
}
