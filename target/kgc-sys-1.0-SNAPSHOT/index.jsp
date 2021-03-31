<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/common-header.jsp"%>
</head>
<title>登录页面</title>
<style type="text/css">
    .login_button{
        width: 150px;
        height: 36px;
        border-radius: 4px;
        border: none;
        color: #FFFFFF;
        background:#4fddfb;
        background:-moz-linear-gradient(left, #4fddfb, rgba(42, 106, 253, 0.5));
        background:-webkit-gradient(linear, 0 18, right 18, from(#4fddfb), to(rgba(42, 106, 253, 0.5)));
        background:-o-linear-gradient(left, #4fddfb, rgba(42, 106, 253, 0.5));
    }
</style>
<script>
    //JavaScript代码区域
    layui.use('form', function(){
        var  form=layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
        //自定义验证规则
        form.verify({
            username: [
                /^[\S]{6,12}$/
                ,'用户名必须6到12位，且不能出现空格'
            ],
            password: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });
    });
</script>
</head>
<body style="text-align: center">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>登录</legend>
</fieldset>
<div class="layui-form"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <div class="layui-form-item" style="padding-left: 33%">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="username"   lay-verify="username"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 33%">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" lay-verify="password"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div>
            <button id="login_button" class="login_button">登录</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        //登录后用户名或密码错误给出提示
        var flag ='${flag}';
        if (flag =='error'){
            layer.msg("用户名或密码错误",{"time":100});
        }
        $('#login_button').click(function () {
            login();
        });
    });
    function login() {
        var un = $('input[name="username"]').val();
        if(!un || un === '') {
            layer.msg("用户名不能为空",{"time":100});
            return;
        }
        var pw = $('input[name="password"]').val();
        if(!pw || pw === '') {
            layer.msg("密码不能为空",{"time":100});
            return;
        }
        $.ajax('/kgc_sys_war/login', {
            data: {
                "userName": un,
                "pwd": pw
            },
            type: 'POST',
            dataType:'json',
            success: function (ret) {
                if (ret =='success') {
                    window.location.href = "/kgc_sys_war/toMain";
                } else {
                    layer.msg("登录失败",{"time":1000});
                }
            },
            error: function (xhr) {
                layer.msg('登录失败',{"time":1000});
            }
        });
    }
</script>
</html>