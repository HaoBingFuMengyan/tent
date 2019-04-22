<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>会员信息</title>
    <link rel="stylesheet" href="${ctxStatic}/layui-v2.4.5/css/layui.css">
    <link rel="stylesheet" href="${ctx}/css/of/index.css">
    <link rel="stylesheet" href="${ctx}/css/layui-extend.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>会员信息</legend>
</fieldset>
<div class="layui-collapse" lay-filter="test">
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">企业名称：${member.scnname}</h2>
        <div class="layui-colla-content layui-show">
            <div class="layui-info">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">企业名称：</label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label  class="layui-form-label">社会信用代码： </label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label  class="layui-form-label">公司类型： </label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">账户全称：</label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label  class="layui-form-label">开户行： </label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label  class="layui-form-label">账号： </label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">联行号：</label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label  class="layui-form-label">联系人： </label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label  class="layui-form-label">手机号： </label>
                        <div class="layui-input-inline">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-block">
                        <label  class="layui-form-label">企业地址：</label>
                        <div class="layui-input-block">

                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-block">
                        <label  class="layui-form-label">备注：</label>
                        <div class="layui-input-block">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="layui-collapse top10">
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">鲁迅</h2>
        <div class="layui-colla-content layui-show">
            <div class="layui-info">
                <div class="layui-form-item">
                    <div class="layui-block">
                        <label  class="layui-form-label">介绍： </label>
                        <div class="layui-input-block">
                            鲁迅一生在文学创作、文学批评、思想研究、文学史研究、翻译、美术理论引进、基础科学介绍和古籍校勘与研究等多个领域具有重大贡献。他对于五四运动以后的中国社会思想文化发展具有重大影响，蜚声世界文坛，尤其在韩国、日本思想文化领域有极其重要的地位和影响，被誉为“二十世纪东亚文化地图上占最大领土的作家”。
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${ctxStatic}/layui-v2.4.5/layui.all.js"></script>
<script>
    layui.use(['element', 'layer'], function () {
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function (data) {
//            layer.msg('展开状态：' + data.show);
        });
    });
</script>
</body>
</html>