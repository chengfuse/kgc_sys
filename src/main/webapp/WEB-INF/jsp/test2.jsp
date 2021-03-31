<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/common-header.jsp"%>
</head>
<body>
<script type="text/html" id="optBtn">
    <div class="layui-btn-container">
        <div class="layui-btn-container">
            <button class="layui-btn" lay-event="addBug">新增</button>
            <button class="layui-btn" lay-event="updateBug">修改</button>
            <button class="layui-btn" lay-event="deleteBug">修改所在班级</button>
        </div>
    </div>
</script>
<fieldset class="layui-elem-field" style="height: 120px">
    <div class="layui-field-box">
        <div class="layui-form layui-card-header">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">开始时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">结束时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">班级名称</label>
                    <div class="layui-input-block">
                        <select class="layui-select">
                            <option value="">请选择</option>
                            <option value="">KADE2016</option>
                            <option value="">KADE2017</option>
                            <option value="">KADE2018</option>
                            <option value="">KADE2019</option>
                            <option value="">KUID2020</option>
                            <option value="">KUID2021</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">学生姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label">打卡状态</label>
                                    <div class="layui-input-block">
                                        <select class="layui-select">
                                            <option value="">请选择</option>
                                            <option value="">正常</option>
                                            <option value="">迟到</option>
                                            <option value="">早退</option>
                                            <option value="">未打卡</option>
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
                {type:'checkbox'}
                // ,{field:'id', width:80, title: '主键', sort: true}
                ,{field:'name', width:80, title: '姓名'}
                ,{field:'name', width:80, title: '班级名称'}
                ,{field:'name', width:80, title: '打卡日期',templet:function (data) {
                        if(data.id==1) return "2020-03-20";
                        if(data.id==2) return "2020-03-19";
                        if(data.id==3) return "2020-03-18";
                        if(data.id==4) return "2020-03-17";
                    }}
                ,{field:'name', width:80, title: '上午打卡时间',templet:function (data) {
                        if(data.id==1) return "08:12:00";
                        if(data.id==2) return "09:35:00";
                        if(data.id==3) return "08:20:00";
                        if(data.id==4) return "";
                    }}
                ,{field:'name', width:80, title: '下午打卡时间',templet:function (data) {
                        if(data.id==1) return "18:00:00";
                        if(data.id==2) return "18:00:00";
                        if(data.id==3) return "18:00:00";
                        if(data.id==4) return "";
                    }}
                ,{field:'state', width:80, title: '状态',templet:function (data) {
                    if(data.id ==1) return "正常";
                    if(data.id ==2) return "迟到";
                    if(data.id ==3) return "正常";
                    if(data.id ==4) return "未打卡";
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