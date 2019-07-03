<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>品种添加</title>
    <script src="${ctxStatic}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${ctxStatic}/layui-v2.4.5/layui.all.js"></script>
    <script src="${ctxStatic}/js/common.js"></script>

    <link rel="stylesheet" href="${ctxStatic}/layui-v2.4.5/css/layui.css">
    <link rel="stylesheet" href="${ctx}/css/layui-extend.css">
    <link rel="stylesheet" href="${ctxStatic}/css/common.css">

    <script>
        var device;
        var form;
        layui.use(['form', 'layedit', 'laydate'], function () {
            device = layui.device();
            form = layui.form;
            form.verify({
                required: function (value) {
                    if (pub.isnull(value)) {
                        return '这是必填项';
                    }
                }
            });
        });

        function valiForm() {//仿照源码写的校验，返回布尔类型
            var verify = form.config.verify, stop = null
                , DANGER = 'layui-form-danger', field = {}, elem = $('.layui-form')
                , verifyElem = elem.find('*[lay-verify]') //获取需要校验的元素
                , formElem = elem //获取当前所在的form元素，如果存在的话
                , fieldElem = elem.find('input,select,textarea') //获取所有表单域
                , filter = '*'; //获取过滤器

            //开始校验
            layui.each(verifyElem, function (_, item) {
                var othis = $(this), ver = othis.attr('lay-verify'), tips = '';
                var value = othis.val(), isFn = typeof verify[ver] === 'function';
                othis.removeClass(DANGER);
                if (verify[ver] && (isFn ? tips = verify[ver](value, item) : !verify[ver][0].test(value))) {
//                    layer.msg(tips || verify[ver][1], {
//                        icon: 5
//                        , shift: 6
//                    });
                    layer.tips(tips || verify[ver][1],othis);
                    //非移动设备自动定位焦点
                    if (!device.android && !device.ios) {
                        item.focus();
                    }
                    othis.addClass(DANGER);
                    return stop = true;
                }
            });

            if (stop) {
                return false;
            }
            else {
                return true;
            }
        };
    </script>
</head>
<body>
<div class="mbody">
    <form id="formInput" class="layui-form" action="${ctx}/category/add.shtml" method="post" enctype="multipart/form-data" autocomplete="on">
        <input type="hidden" name="id" value="${data.id}"/>
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
                <li class="layui-this">品种信息</li>
            </ul>
            <div class="layui-tab-content height-100-perce">
                <div class="layui-tab-item layui-show">
                    <fieldset class="layui-elem-field layui-field-title top20">
                        <legend>品种参数</legend>
                    </fieldset>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">品种名称<em>*</em></label>
                            <div class="layui-input-inline">
                                <input type="text" name="sname" id="sname" value="${data.sname}" class="layui-input" lay-verify="required" placeholder="(必填项)">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">俗名</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" name="slocalname" id="slocalname" value="${data.slocalname}">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">是否常用<em>*</em></label>
                            <div class="layui-input-inline">
                                <%--<input type="text" class="layui-input" lay-verify="required" placeholder="(必填项)" name="biscommon" id="biscommon" value="${data.biscommon}">--%>
                                <consts:BoolType op="select" defval="" defname="全部" name="biscommon" val="${data.biscommon}" option="class='layui-input'"/>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">单位<em>*</em></label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" lay-verify="required" placeholder="(必填项)" name="sweightunit" id="sweightunit" value="${data.sweightunit}">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">规格型号</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" name="sspec" id="sspec" value="${data.sspec}">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">生产厂家<em>*</em></label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" lay-verify="required" placeholder="(必填项)" name="sproducer" id="sproducer" value="${data.sproducer}">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">所属设备</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" name="shostname" id="shostname" value="${data.shostname}">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">所属设备型号</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" name="shostmodel" id="shostmodel" value="${data.shostmodel}">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">所属设备厂商</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" name="shostbrand" id="shostbrand" value="${data.shostbrand}">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">排序号<em>*</em></label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" lay-verify="required" placeholder="(必填项)" name="isort" id="isort" value="${data.isort}">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline layui-form-text">
                            <label class="layui-form-label">品种介绍</label>
                            <div class="layui-input-inline layui-input-text">
                                <textarea class="layui-textarea" name="sdescription" id="sdescription">${data.sdescription}</textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
