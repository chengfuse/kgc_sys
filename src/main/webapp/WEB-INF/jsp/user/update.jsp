<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2021/3/15
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/common-header.jsp"%>
</head>
<body>
<form class="layui-form" id="myForm"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <div class="layui-form-item">
        主键：<input type="text" name="id" value="${user.id}">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="userName" value="${user.userName}" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="number" name="age" value="${user.age}" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <input type="text" name="address" value="${user.address}" placeholder="请输入"/>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.on('submit(demo1)', function(data){
            // var index = layer.load(1, {
            //     shade: [0.1, '#fff'] //0.1透明度的白色背景
            // });
            var data = $("#myForm").serialize();//表单序列化获取表单的数据
            $.post('/kgc_sys_war/user/addUser', data, function (ev) {
                if (ev.code == 0) {
                    layer.msg("添加成功", {
                        time: 1000
                    }, function () {
                        parent.layer.closeAll();
                        //  parent.location.href = "/bug/toPage";
                    });
                } else {
                    layer.close(index);
                    layer.msg(ev.msg);
                }
            }, 'json');
        });
    });
</script>
</body>
</html>