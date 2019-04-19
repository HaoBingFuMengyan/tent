<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>开始使用layui</title>
    <link rel="stylesheet" href="${ctxStatic}/layui-v2.4.5/css/layui.css">
    <link rel="stylesheet" href="${ctx}/css/of/index.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">logo</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a top_id="0001" validate="true">会员中心</a></li>
            <li class="layui-nav-item"><a top_id="0002" validate="true">商品管理</a></li>
            <li class="layui-nav-item"><a top_id="0003" validate="true">用户</a></li>
            <li class="layui-nav-item">
                <a validate="true">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a validate="false" href="">邮件管理</a></dd>
                    <dd><a validate="false" href="">消息管理</a></dd>
                    <dd><a validate="false" href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="">控制台<span class="layui-badge">9</span></a>
            </li>
            <li class="layui-nav-item">
                <a validate="false">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <shiro:principal property="susername"/>
                </a>
                <dl class="layui-nav-child">
                    <dd><a validate="false" href="">基本资料</a></dd>
                    <dd><a validate="false" href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a validate="false" href="${ctx}/logout.html">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test" top_id="0001">
                <li class="layui-nav-item layui-nav-itemed">
                    <a validate="false">会员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a tab_id="201904180000" data-url="http://www.taobao.com"><i class="layui-icon">&#xe613;</i>&nbsp;会员认证</a>
                        </dd>
                        <dd><a tab_id="201904180001" data-url="http://www.hao123.com"><i class="layui-icon">&#xe678;</i>&nbsp;修改手机号</a>
                        </dd>
                        <dd><a tab_id="201904180002" data-url=""><i class="layui-icon">&#xe673;</i>&nbsp;登陆密码</a></dd>
                        <dd><a tab_id="201904180003" data-url=""><i class="layui-icon">&#xe60e;</i>&nbsp;会员信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a validate="false">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a>列表一</a></dd>
                        <dd><a>列表二</a></dd>
                        <dd><a>超链接</a></dd>
                    </dl>
                </li>
            </ul>

            <ul class="layui-nav layui-nav-tree layui-hide" lay-filter="test" top_id="0002">
                <li class="layui-nav-item layui-nav-itemed">
                    <a validate="false">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a tab_id="">权限分配</a></dd>
                        <dd><a tab_id="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div>
            <div class="layui-tab" lay-filter="mytab" lay-allowClose="true">
                <ul class="layui-tab-title">
                    <li class="layui-this">
                        <i class="layui-icon">
                            &#xe620;
                            <cite>控制面板</cite>
                        </i>
                    </li>
                </ul>
                <div class="layui-tab-content" style="min-height: 800px;border: none">
                    <div class="layui-tab-item layui-show">
                        <iframe src=""></iframe>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script src="${ctxStatic}/layui-v2.4.5/layui.all.js"></script>
<script>
    //JavaScript代码区域
    var $ = layui.jquery,
        element = layui.element,
        layer = layui.layer;
    $(document).on('click', 'a', function () {
        if (!$(this)[0].hasAttribute("tab_id") || $(this).attr("tab_id") === '') {
            var flag = $(this).attr("validate");
            if (flag == 'true') {
                var topid = $(this).attr("top_id");
                if (topid == undefined || topid === "" || topid == null) {
                    layer.msg("请先设置top_id属性");
                    return;
                }
                $("div.layui-side-scroll").find("ul").addClass('layui-hide');
                $("div.layui-side-scroll").find("ul[top_id='" + topid + "']").removeClass('layui-hide');

                return;
            }
            return;
        }
        var layid = $(this).attr("tab_id");
        var text = $(this).text();
        var dataurl = $(this).attr("data-url");
        var tabs = $(".layui-tab-title").children();
        var msg = true;
        $.each(tabs, function (i, item) {
            var tabid = $(item).attr("lay-id");
            if (tabid === layid) {
                msg = false;
                return false;
            }
        });
        if (msg) {
            element.tabAdd('mytab', {
                title: text,
                content: "<iframe frameborder='0' width='100%' height='100%' src='" + dataurl + "'></iframe>",
                id: layid
            });
        }
        resize();
        element.tabChange('mytab', layid);

    });

    function resize() {
        var $content = $(".layui-tab-content");
        $content.height($(this).height() - 200);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
            $(this).width("100%")
        })

    }

    $(window).on('resize', function () {
        var $content = $(".layui-tab-content");
        $content.height($(this).height() - 200);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
            $(this).width("100%")
        });

    });
    $(window).on('load', function () {
        var $content = $(".layui-tab-content");
        $content.height($(this).height() - 200);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
            $(this).width("100%")
        });

    })


    /* element.on('nav(test)', function(elem){
     console.log(JSON.stringify(elem)); //得到当前点击的DOM对象
     var layid=location.hash.replace(/^#tab=/,'');
     alert(layid);
     element.tabChange('mytab',layid);
     });*/

</script>
</body>
</html>