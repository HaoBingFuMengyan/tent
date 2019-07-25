package com.tent.cloud.mb;

import com.tent.cloud.shiro.token.ShiroUtils;
import com.tent.common.jpa.MobileResult;
import com.tent.common.shiro.ILoginUser;
import com.tent.common.utils.B;
import com.tent.common.utils.Lg;
import com.tent.po.entity.hy.Member;
import com.tent.service.inte.hy.IMemberService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/mb/")
public class Authentication {

    @Autowired
    private IMemberService memberService;

    @RequestMapping(value = "login.jhtml")
    @ResponseBody
    public MobileResult login(String susername, String spassword,
                              @RequestParam(value = "version",defaultValue = "2.0") String version,
                              HttpServletRequest request, HttpServletResponse response, HttpSession session){
        try {
            if (ShiroUtils.getSubject().isAuthenticated())
                ShiroUtils.getSubject().logout();

            if (!version.equalsIgnoreCase(version))
                return MobileResult.failure("请更新到最新版本");

            if (B.Y(susername))
                return MobileResult.failure("用户名不能为空");
            if (B.Y(spassword))
                return MobileResult.failure("密码不能为空");

            UsernamePasswordToken token = new UsernamePasswordToken(susername, spassword);
            token.setRememberMe(true);

            Lg.info(Authentication.class,"为登陆用户封装的token："+ ReflectionToStringBuilder.toString(token));

            ShiroUtils.getSubject().login(token);
            ShiroUtils.getSubject().getSession().setTimeout(1000*60*60*24*7);

            response.setHeader("token",ReflectionToStringBuilder.toString(token));
            MobileResult mobileResult = MobileResult.ok();
            mobileResult.put("token",ReflectionToStringBuilder.toString(token));
            mobileResult.put("user",ShiroUtils.getCurrentUser());

            return mobileResult;
        }catch (ServiceException ex){
            ex.printStackTrace();
            return MobileResult.error(ex.getMessage());
        }catch(UnknownAccountException uae){
            uae.printStackTrace();
            return MobileResult.failure("用户名不正确");
        }catch(IncorrectCredentialsException ice){
            ice.printStackTrace();
            return MobileResult.failure("密码不正确");
        }catch(AuthenticationException ae){
            ae.printStackTrace();
            return MobileResult.failure("用户名或密码不正确");
        }catch (Exception e){
            e.printStackTrace();
            return MobileResult.failure("登陆失败");
        }
    }

    @RequestMapping(value = "logout.jhtml",method = RequestMethod.GET)
    @ResponseBody
    public MobileResult logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        if (ShiroUtils.getSubject().isAuthenticated())
            ShiroUtils.getSubject().logout();

        return MobileResult.ok("登出成功");
    }

    @RequestMapping(value = "memberinfo.jhtml")
    @RequiresAuthentication
    @ResponseBody
    public MobileResult memberInfo(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        ILoginUser user = ShiroUtils.getCurrentUser();
        try {
            Member member = memberService.findBySmemberid(user.getMemberId());
            return MobileResult.ok(member);
        }catch (ServiceException ex){
            ex.printStackTrace();
            return MobileResult.failure(ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return MobileResult.failure("接口异常");
        }
    }

}
