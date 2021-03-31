<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/common-header.jsp"%>
</head>
<body>
<script type="text/html" id="optBtn">
    <div class="layui-btn-container">
        <button class="layui-btn" lay-event="addBug">新增</button>
        <button class="layui-btn" lay-event="updateBug">修改</button>
        <button class="layui-btn" lay-event="deleteBug">删除</button>
        <button class="layui-btn" lay-event="menu">分配菜单</button>
    </div>
</script>
<fieldset class="layui-elem-field">
    <div class="layui-field-box">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-block">
                        <select class="layui-select" name="state">
                            <option value="">请选择</option>
                            <option value="0">正常</option>
                            <option value="1">禁用</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-admin" lay-submit lay-filter="my-table-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script>
    layui.use(['table','laydate'], function(){
        var table = layui.table;
        var util = layui.util;
        var $=layui.jquery;
        var layer = layui.layer;
        var form = layui.form;

        table.render({
            elem: '#test'
            ,url:'/kgc_sys_war/user/queryAll/'
           ,toolbar:'#optBtn'
            ,page:true
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {type:'checkbox'},
                {field:'id', width:80, title: '主键', sort: true}
                ,{field:'name', width:80, title: '用户名'}
                ,{field:'state', width:80, title: '状态',templet:function (data) {
                    if(data.state ==0) return "正常";
                    if(data.state ==1) return "禁用";
                 }}
                ,{field:'createUser', width:80, title: '创建人'}
                ,{field:'createDate', width:80, title: '创建时间',templet:function (d) {
                    return layui.util.toDateString(d.createDate,'yyyy-MM-dd HH:mm:ss')
                }}
                ,{field:'modifyUser', width:80, title: '修改人'}
                ,{field:'modifyDate', width:80, title: '创建时间',templet:function (d) {
                    return layui.util.toDateString(d.modifyDate,'yyyy-MM-dd HH:mm:ss')
                }}
            ]]
        });

        //监听上面的按钮操作
        table.on('toolbar(test)', function(obj){
            if(obj.event ==='addBug'){
                layer.open({
                    type: 2,
                    title:'添加bug',
                    content:'/kgc_sys_war/user/toAdd', //跳转到controller
                    offset:'t',
                    area:['550px','350px'],
                    end:function () {
                        location.reload();//刷新页面
                    }
                });
            }
            else if(obj.event ==='updateBug'){
                var data = layui.table.checkStatus('test').data;
                if(data.length ==0){
                    layer.msg("请选择数据",{
                        time:1000
                    });
                    return false;
                }
                if(data.length>1){
                    layer.msg("只能选择一条数据",{
                        time:1000
                    });
                    return false;
                }
                layer.open({
                    type: 2,
                    title:'修改bug信息',
                    content:'/kgc_sys_war/user/toUpdate?id='+data[0].id, //跳转到controller
                    offset:'t',
                    area:['550px','350px']
                });
            }
            //删除操作
            else if(obj.event==='deleteBug'){
                var data = layui.table.checkStatus('test').data;
                if(data.length ===0){
                    layer.msg("请选择数据",{time:1000});
                    return false;
                }
                //循环data获取数据的id
                var ids=[];
                $.each(data,function(i,item){
                    // ids[i]=item.id;
                    ids.push(item.id);
                });
                //使用ajax删除
                $.ajax({
                    url:'/kgc_sys_war/user/deleteByIds?ids='+ids,
                    type:'DELETE',
                    success:function (data) {
                        data = eval('('+data+')');
                        if(data.code===0){
                            layer.msg("删除成功",{time:1000});
                            location.reload();
                        }else{
                            layer.msg("删除失败，请重试！",{time:1000});
                        }
                    },
                    error:function (e) {
                        console.log(e.message);
                        layer.msg("删除失败，请重试！",{time:1000});
                    }
                })
            }
            //分配菜单
            else if(obj.event ==='menu'){
                var data = layui.table.checkStatus('test').data;
                if(data.length ==0){
                    layer.msg("请选择数据",{
                        time:1000
                    });
                    return false;
                }
                if(data.length>1){
                    layer.msg("只能选择一条数据",{
                        time:1000
                    });
                    return false;
                }
                layer.open({
                    type: 2,
                    title:'分配菜单',
                    content:'/kgc_sys_war/menu/toMenu?uId='+data[0].id, //跳转到controller
                    offset:'t',
                    area:['550px','350px'],
                    end:function () {
                        location.reload();//刷新页面
                    }
                });
            }

        });

        var form = layui.form;
        //页面搜索功能
        form.on('submit(my-table-search)', function(data){
            var field = data.field;
            //执行重载
            table.reload('test', {
                url:'/kgc_sys_war/user/queryAll/',
                where: field,
                page:{
                    curr:1
                }
            });
        });
    });

</script>
</body>
</html>