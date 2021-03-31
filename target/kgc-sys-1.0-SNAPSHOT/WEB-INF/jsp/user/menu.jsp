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
    <div id="test12" class="demo-tree-more"></div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>
<script>
    //获取controller里面的数据
    var menuList = eval('('+ '${list}'+')');  //所有菜单列表
    var userId = '${uId}';//用户ID
    var menuIds = ','+'${userOwnMenIds}'+',';  //用户已有的菜单ID
    var treeData=[];//所有的菜单信息
    var checkData=[];//获取tree中选中的行
    //组装tree里面的data数据
    if(menuList !=null){
        $.each(menuList,function (index,item) {
            var curData = getTreeData(item);
            //设置二级菜单
            var child=[];
            $.each(item.childMenu,function (i, data) {
                //根据二级菜单信息组装json
                child.push(getTreeData(data));
            });
            //将二级菜单放入到一级菜单的child属性中
            curData.children=child;
            //将一级菜单放入到treeData中
            treeData.push(curData);
        })
    }
    //根据item组装json数据
    function getTreeData(item){
        var tree ={};
        tree.title= item.menuName;
        tree.id= item.id;
        //判断用户是否有该菜单的权限
        if(menuIds.indexOf(','+item.id +',')>=0){
            tree.checked = true;
        }
        return tree;
    }
    layui.use(['tree', 'util'], function() {
        var tree = layui.tree
            , layer = layui.layer
            //模拟数据
            , data = treeData;
        //基本演示
        tree.render({
            elem: '#test12'
            ,data: data
            ,showCheckbox: true  //是否显示复选框
            ,id: 'treeDemo'
            ,isJump: true //是否允许点击节点时弹出新窗口跳转
            ,click: function(obj){
                var data = obj.data;  //获取当前点击的节点数据
                layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
            }
        });
       checkData = tree.getChecked('treeDemo');
    });
    layui.use('form', function(){
        var form = layui.form;
        var tree = layui.form;
        form.on('submit(demo1)', function(data){
            var checkedIds=[];
            //获取tree的选中的id
            if(checkData.length<=0){
                parent.layer.msg("请勾选菜单", {
                    time: 1000
                });
                return false;
            }
            //循环获取数据的ID属性
            $.each(checkData,function (i,item) {
               if(item.checked){
                   checkedIds.push(item.id);
                   $.each(item.children,function (ind,dat) {
                       if(data.checked){
                           checkedIds.push(data.id);
                       }
                   })
               }
            });
            var data = {};
            data.uId=userId;
            data.menuIds=checkedIds.toString();
            $.post('/kgc_sys_war/user/updateMenu', JSON.toString(data), function (ev) {
                ev = eval('('+ev+')');//将string转为json
                if (ev.code === 0) {
                    parent.layer.msg("添加成功", {
                        time: 1000
                    }, function () {
                        parent.layer.closeAll();
                    });
                } else {
                    layer.msg(ev.msg);
                }
            });
        });
    });
</script>
</body>
</html>