package com.tent.cloud.hy;

import com.tent.cloud.shiro.token.ShiroUtils;
import com.tent.common.shiro.ILoginUser;
import com.tent.common.utils.S;
import com.tent.common.web.Msg;
import com.tent.po.entity.hy.Member;
import com.tent.service.inte.hy.IMemberService;
import com.tent.service.inte.hy.IUserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/member/")
public class MemberAction {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMemberService memberService;

    /**
     * 会员信息
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "info.shtml",method = RequestMethod.GET)
    public String memberInfo(Model model, HttpServletRequest request, HttpSession session){
        ILoginUser user = ShiroUtils.getCurrentUser();
        try {
            Member member = this.memberService.findBySmemberid(user.getMemberId());

            model.addAttribute("member",member);
        }catch (ServiceException ex){
            ex.printStackTrace();
            Msg.error(model,ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            Msg.error(model,e.getMessage());
        }
        return S.toPage("member/info");
    }


    @RequestMapping(value = "index.shtml")
    public String memberIndex(Model model, HttpServletRequest request){
        return "member/index";
    }

}
