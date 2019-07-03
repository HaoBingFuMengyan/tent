package com.tent.common.web;

import com.tent.common.entity.IConst;
import com.tent.common.utils.B;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class BaseTag extends SimpleTagSupport {
    enum OP {
        eq,
        ext,
        js,
        select,
        addcontent,
        label,
        radio,
        checkbox,
        syspara,
        bizpara,
        bizselect,
        ne,
        not
    }

    private String val = "";
    private String op;
    private String option = "";
    private String addcontent;
    private String id;
    private String name;
    private String defname;
    private String defval;
    private String nshow = "";


    public void setNshow(String nshow) {
        this.nshow = nshow;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setOp(String op) {
        this.op = op;
    }


    public void setVal(String val) {
        this.val = val;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefname(String defname) {
        this.defname = defname;
    }

    public void setDefval(String defval) {
        this.defval = defval;
    }


    public void setAddcontent(String addcontent) {
        this.addcontent = addcontent;
    }


    protected IConst currentconst;

    public void setCurrentconst(IConst currentconst, int val) {
        this.currentconst = currentconst;
        if (op == null)
            this.op = "eq";
        this.val = String.valueOf(val);
    }

    public void doTag() throws JspException, IOException {
        if (op == null) {
            IConst setval = StringUtils.isNotBlank(val) ? this.GetConst(Integer.parseInt(val)) : null;
            this.getJspContext().getOut().write(setval == null ? "errorvalue:" + setval.val() : setval.label());
            return;
        }
        DoOut();
    }

    public abstract IConst GetConst(int val);

    public abstract IConst[] GetVals();

    public void DoOut() throws JspException, IOException {
        OP o = OP.valueOf(op);
        switch (o) {
            case eq: {
                IConst setval = StringUtils.isNotBlank(val) ? this.GetConst(Integer.parseInt(val)) : null;
                if (this.currentconst == setval)
                    this.getJspBody().invoke(null);
                break;
            }
            case ne:
            case not: {
                IConst setval = StringUtils.isNotBlank(val) ? this.GetConst(Integer.parseInt(val)) : null;
                if (this.currentconst != setval)
                    this.getJspBody().invoke(null);
                break;
            }
            case ext:
            case js: {//domain显示为 js数组
                StringBuffer bf = new StringBuffer();
                bf.append("[");
                if (B.N(defname) || B.N(defval))
                    bf.append("[" + (B.N(defval) ? defval : "''") + ",'" + defname + "']");
                IConst[] alls = this.GetVals();
                for (int i = 0; i < alls.length; i++) {
                    IConst item = alls[i];
                    if (show(item))
                        continue;
                    if (bf.toString().endsWith("]"))
                        bf.append(",[");
                    else
                        bf.append("[");
                    bf.append(item.val() + ",'" + item.label() + "']");
                }
                bf.append("]");
                this.getJspContext().getOut().write(bf.toString());
                break;
            }
            case select: {//domain显示为<select>
                StringBuffer bf = new StringBuffer();
                bf.append("<select " + (StringUtils.isBlank(id) ? "" : "id=\"" + id + "\" "));
                bf.append((StringUtils.isBlank(name) ? "" : " name=\"" + name + "\" "));
                bf.append(option + " >");
                if (defname != null) {
                    if (defval == null)
                        bf.append("<option value=\"\">" + defname + "</option>");
                    else
                        bf.append("<option value=\"" + defval + "\" " + (defval == String.valueOf(val) ? " selected=\"selected\" " : "") + ">" + defname + "</option>");
                }
                IConst[] alls = this.GetVals();
                for (int i = 0; i < alls.length; i++) {
                    IConst item = alls[i];
                    if (show(item))
                        continue;
                    bf.append("<option value=\"" + item.val() + "\" " + ((StringUtils.isNotBlank(val) && Integer.parseInt(val) == item.val()) ? " selected=\"selected\" " : "") + ">" + item.label() + "</option>");
                }
                if (B.N(addcontent))
                    bf.append(addcontent);
                bf.append("</select>");
                this.getJspContext().getOut().write(bf.toString());
                break;
            }
            case radio: {//domain 显示为一个 radio组
                StringBuffer bf = new StringBuffer();
                IConst[] alls = this.GetVals();
                for (int i = 0; i < alls.length; i++) {
                    IConst item = alls[i];
                    if (show(item))
                        continue;
                    bf.append("<input type=\"radio\" " + (StringUtils.isBlank(id) ? "" : "id=\"" + id + "\" "));
                    bf.append((StringUtils.isBlank(name) ? "" : " name=\"" + name + "\" "));
                    bf.append(option + " ");
                    bf.append("value=\"" + item.val() + "\" " + ((StringUtils.isNotBlank(val) && Integer.parseInt(val) == item.val()) ? " checked" : "") + "/><span class=\"after\">" + item.label() + "</span>");
                }

                this.getJspContext().getOut().write(bf.toString());
                break;
            }
            case checkbox: {
                StringBuffer bf = new StringBuffer();
                IConst[] alls = this.GetVals();
                for (int i = 0; i < alls.length; i++) {
                    IConst item = alls[i];
                    if (show(item))
                        continue;
                    bf.append("<input type=\"checkbox\" " + (StringUtils.isBlank(id) ? "" : "id=\"" + id + "\" "));
                    bf.append((StringUtils.isBlank(name) ? "" : " name=\"" + name + "\" "));
                    bf.append(option + " ");
                    bf.append("value=\"" + item.val() + "\" " + ((StringUtils.isNotBlank(val) && Integer.parseInt(val) == item.val()) ? " checked" : "") + "/><span class=\"after\">" + item.label() + "</span>");
                }

                this.getJspContext().getOut().write(bf.toString());
                break;
            }
            case bizpara: {
                break;
            }
            case label: {
                IConst setval = StringUtils.isNotBlank(val) ? this.GetConst(Integer.parseInt(val)) : null;
                if (setval == null)
                    return;
                this.getJspContext().getOut().write(setval.label());
                break;
            }

        }
    }

    /**
     * 需要过滤不显示的项
     *
     * @param item
     * @return
     */
    private boolean show(IConst item) {
        if (B.Y(nshow))
            return false;

        List<String> list = Arrays.asList(nshow.split(","));
        return list.contains(String.valueOf(item.val()));
    }
}
