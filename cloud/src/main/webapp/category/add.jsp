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

    <link rel="stylesheet" href="${ctxStatic}/layui-v2.4.5/css/layui.css">
    <link rel="stylesheet" href="${ctx}/css/layui-extend.css">
    <link rel="stylesheet" href="${ctxStatic}/css/common.css">
</head>
<body>
<div class="mbody">
    <form id="formInput" class="layui-form" action="${ctx}/category/add.shtml" method="post" enctype="multipart/form-data" autocomplete="on">
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
                            <label class="layui-form-label">品种名称</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">俗名</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">是否常用</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">单位</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">规格型号</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">生产厂家</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">所属设备</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">所属设备型号</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">所属设备厂商</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">排序号</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline layui-form-text">
                            <label class="layui-form-label">品种介绍</label>
                            <div class="layui-input-inline layui-input-text">
                                <textarea class="layui-textarea"></textarea>
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
