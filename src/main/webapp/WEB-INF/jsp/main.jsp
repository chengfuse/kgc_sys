<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
   <%@ include file="/WEB-INF/jsp/common/common-header.jsp"%>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <!--遍历所有的一级菜单-->
                <c:forEach items="${menuList}" var="list">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">${list.menuName}</a>
                        <dl class="layui-nav-child">
                            <!--根据一级菜单遍历二级菜单-->
                            <c:if test="${list.childMenu != null}">
                                <c:forEach items="${list.childMenu}" var="child">
                                    <dd>
                                        <a data-url="/kgc_sys_war${child.menuUrl}" data-id="${child.id}" data-title="${child.menuName}" href="#" class="site-demo-active" data-type="tabAdd">${child.menuName}</a>
                                    </dd>
                                </c:forEach>
                            </c:if>
                        </dl>
                    </li>
                </c:forEach>


            </ul>
        </div>
    </div>

    <div class="layui-tab" lay-allowClose="true" lay-filter="demo" style="margin-left: 200px">
        <ul class="layui-tab-title"></ul>
        <ul class="layui-tab-content" style="height: 500px"></ul>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script type="text/javascript" src="/kgc_sys_war/layui/js/layui-change.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>