package com.tent.common.web;


import com.tent.common.utils.LoggerUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Msg {

    private String metype;
    private int allowhide = 0;
    private int type = 0;
    private String title = "";

    public String getMetype() {
        return metype;
    }

    public void setMetype(String metype) {
        this.metype = metype;
    }

    public int getAllowhide() {
        return allowhide;
    }

    public void setAllowhide(int allowhide) {
        this.allowhide = allowhide;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Msg(int type, String msg) {
        this.title = msg;
        this.type = type;
    }

    public Msg(String metype, String msg, int allowhide) {
        this.title = msg;
        this.metype = metype;
        this.allowhide = allowhide;
        this.initType(metype);
    }

    public Msg(String metype, String msg) {
        this.title = msg;
        this.metype = metype;
        this.initType(metype);
    }

    private void initType(String metype) {
        if("danger".equals(metype)) {
            this.type = 1;
        } else if("warning".equals(metype)) {
            this.type = 2;
        }
    }
    public static void success(Model model, String message, int allowHide) {
        model.addAttribute("message", new Msg("success", message, allowHide));
    }

    public static void success(RedirectAttributes model, String message, int allowHide) {
        model.addFlashAttribute("message", new Msg("success", message, allowHide));
    }

    public static void error(Model model,String message){
        model.addAttribute("message",new Msg("danger",message));
    }
    public static void error(RedirectAttributes rmodel,String message){
        rmodel.addAttribute("message",new Msg("danger",message));
    }

    public static void warn(Model model, String message) {
        model.addAttribute("message", new Msg("warning", message));
    }

    public static void warn(RedirectAttributes model, String message) {
        model.addFlashAttribute("message", new Msg("warning", message));
    }

    public static void error(Model model, Exception e) {
        error(model, e.getMessage());
        if(!(e instanceof ServiceException)) {
            LoggerUtils.fmtError(Msg.class, e.getMessage(), new Throwable[]{e});
        }

    }

    public static void error(RedirectAttributes model, Exception e) {
        String msg = e.getMessage();
        if(!(e instanceof ServiceException)) {
            msg = "操作失败了";
            LoggerUtils.fmtError(Msg.class,e.getMessage(), new Throwable[]{e});
        }

        error(model, msg);
    }
}
