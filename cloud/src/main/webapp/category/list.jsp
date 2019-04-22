<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>品种管理</title>
    <script src="${ctxStatic}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${ctxStatic}/layui-v2.4.5/layui.all.js"></script>

    <link rel="stylesheet" href="${ctxStatic}/layui-v2.4.5/css/layui.css">

    <style>
        body {
            margin: 10px;
        }
        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>
</head>
<body>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<%-- 头部工具栏 --%>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
    </div>
</script>

<%-- 右边工具栏 --%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'form'], function () {
        var form = layui.form
            , laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider; //滑块

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , height: 420
            , url: '${ctx}/category/list.json' //数据接口
            , title: '品种表'
            , page: true //开启分页
//            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , toolbar: '#toolbarDemo'
            , totalRow: true //开启合计行
            , limits: [10,20,40,50] //每页条数选择项
            , limit: 20 //每页显示条数
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: '', title: 'ID', width: 80, sort: true, fixed: 'left', totalRowText: '合计：'}
                , {field: '', title: '用户名', width: 80}
                , {field: '', title: '积分', width: 90, sort: true, totalRow: true}
                , {field: '', title: '性别', width: 80, sort: true}
                , {field: '', title: '评分', width: 80, sort: true, totalRow: true}
                , {field: '', title: '城市', width: 150}
                , {field: '', title: '签名', width: 200}
                , {field: '', title: '职业', width: 100}
                , {field: '', title: '财富', width: 135, sort: true, totalRow: true}
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#barDemo'}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    top.layer.open({
                        type: 2,
                        title:'添加',
                        area: ['85%', '85%'],
                        content: '${ctx}/category/add.shtml',
                        btn: ['确定', '关闭'],
                        yes: function(index,layero) {
                            var iframeWin = layero.find('iframe')[0];
                            var $=iframeWin.contentWindow.$;
                            var doc=$(iframeWin.contentWindow.document);


                            if(iframeWin.contentWindow.valiForm()){//这里我想判断校验结果，怎么调用表单校验，不知道有没有自带方法，官网没找到

                                doc.find('.layui-form').submit();//提交表单
                            }



                        },
                        cancel: function(index){}
                    });
                    break;
                case 'getCheckLength':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
                default:
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                layer.msg('查看操作');
            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if (layEvent === 'edit') {
                layer.msg('编辑操作');
            }
        });

    });
</script>

</body>
</html>

