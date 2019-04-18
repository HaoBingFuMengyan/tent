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
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <shiro:principal property="susername"/>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${ctx}/logout.html">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" tab_id="111" data-url="http://www.taobao.com">文章列表</a></dd>
                        <dd><a href="javascript:;" tab_id="222" data-url="http://www.hao123.com">发送信息</a></dd>
                        <dd><a href="javascript:;" tab_id="333">权限分配</a></dd>
                        <dd><a href="javascript:;" tab_id="444" data-url="../index.html">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
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
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${ctxStatic}/layui-v2.4.5/layui.all.js"></script>
<script>
    //JavaScript代码区域
    var $ = layui.jquery,
        element = layui.element;
    $(document).on('click', 'a', function () {
        if (!$(this)[0].hasAttribute("tab_id") || $(this).attr("tab_id") === '') {
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