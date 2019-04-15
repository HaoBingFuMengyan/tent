<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="decorator" content="default"/>
    <script src="${ctxStatic}/jquery/jquery-2.1.1.min.js"></script>
    <title>会员登陆</title>
    <link rel="icon" href="${ctx}/images/favicon.ico"/>
    <link href="${ctx}/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="login_box">
    <%--<div class="login_l_img"><img src="${ctx}/images/login-img.png"/></div>--%>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="${ctx}/images/login_logo.png"/></a></div>
        <div class="login_name">
            <p>会员管理系统</p>
        </div>
        <!--<form id="inputForm" ng-controller="formCtrl" ng-submit="loginAction()">-->
        <!--<input type="text" placeholder="用户名" ng-modhyuser.sname" required ng-minlength="11">-->

        <!--<input type="password" placeholder="密码" ng-modhyuser.spassword" required ng-minlength="6"/>-->

        <!--<input type="text" placeholder="验证码" ng-modhyuser.checkcode" required ng-minlength="4"/>-->
        <!--<a onclick="refreshCaptcha()">-->
        <!--&lt;!&ndash;<img class="captcha" id="captchaImg" src="${ctx}/captcha.html"/>&ndash;&gt;-->
        <!--</a>-->
        <!--<input id="login" value="登录" style="width:100%;" type="submit">-->
        <!--</form>-->
        <form id="inputForm" method="post" action="${ctx}/login.html">
            <input type="text" id="username" name="username" placeholder="用户名"maxlength="11"/>
            <input type="text" id="password" name="password" placeholder="密码" maxlength="11"/>
            <input type="text" id="checkcode" name="checkcode" placeholder="验证码" maxlength="6"/>
            <input type="submit" value="登陆" />
        </form>
    </div>
    <div class="copyright">HaoSHI有限公司 版权所有©2018-2118 技术支持电话：021-00000000</div>
</div>
</body>
</html>