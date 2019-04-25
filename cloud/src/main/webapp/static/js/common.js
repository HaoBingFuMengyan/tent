String.prototype.trim = function () {
    return this.replace(/(^\s*)|(\s*$)/g, '');
}

var pub = {
    /**
     * 判断字符串是否为空
     * @param val
     * @returns {boolean}
     */
    isnull: function (val) {
        return (val == undefined || val == '' || val == null);
    },
    /**
     * layui open iframe
     * @param title     窗口标题
     * @param contentUrl    iframe请求地址
     * @param ajaxUrl   数据保存地址
     */
    open: function (title,contentUrl,ajaxUrl){
        top.layer.open({
            type: 2,
            title:title,
            area: ['85%', '85%'],
            content: contentUrl,
            btn: ['确定', '关闭'],
            yes: function(index,layero) {
                var iframeWin = layero.find('iframe')[0];
                var $=iframeWin.contentWindow.$;
                var doc=$(iframeWin.contentWindow.document);

                if(iframeWin.contentWindow.valiForm()){//这里我想判断校验结果，怎么调用表单校验，不知道有没有自带方法，官网没找到
                    $.ajax({
                        type: "POST",
                        url: ajaxUrl,
                        data: doc.find('.layui-form').serialize(),
                        dataType:'json',
                        cache: false,
                        success:function (data) {
                            if(data.success){
                                top.layer.closeAll();//返回成功，关闭所有弹窗
                                if(data.msg){
                                    top.layer.msg(data.msg,{icon:1});
                                }else {
                                    top.layer.msg("操作成功!",{icon:1});
                                }
//                                            parent.location.reload();//更新父级页面
                            }else {
                                top.layer.msg(data.msg,{icon:2});
                            }
                        },
                        error:function (data) {
                            top.layer.msg("系统错误，请联系管理员",{icon:2});
                        }
                    })
                }

            },
            cancel: function(index){}
        });
    },
    /**
     * layui open iframe
     * @param title     窗口标题
     * @param contentUrl    iframe请求地址
     */
    detail: function (title,contentUrl){
        top.layer.open({
            type: 2,
            title:title,
            area: ['85%', '85%'],
            content: contentUrl,
            btn: ['关闭'],
            cancel: function(index){}
        });
    }

}
