<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/19
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/back/img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/back/img/app-icon72x72@2x.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/layer.css"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/layui.css">
    <script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/js/layui.js"></script>
    <script src="${pageContext.request.contextPath}/back/js/app.js"></script>
</head>
<body>

<!-- 我的资料模态框 -->
<div class="am-popup am-popup-inner" id="my-superinfo"style="height: 300px;">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">管理员信息修改</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
        <form class="am-form tjlanmu" style="width: 90%;margin: auto">
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">管理员名称：</div>
                <div class="you" style="float: right;width: 80%">
                    <input type="text" class="am-input-sm" id="superadminName" placeholder="${sessionScope.superAdmin.superadminName}">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">账号密码：</div>
                <div class="you">
                    <input type="password" class="am-input-sm" id="superadminPassword" placeholder="**********">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">确认密码：</div>
                <div class="you">
                    <input type="password" class="am-input-sm" id="resuperadminPassword" placeholder="请输入密码">
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you">
                    <p>
                        <button type="button" class="am-btn am-btn-success am-radius" onclick="updateSuperInfo('${pageContext.request.contextPath}/admin/updateSuperAndOrdi')">提交</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- 我的资料模态框结束 -->


<!-- 布局导航栏 -->
<header class="am-topbar admin-header">
    <div class="am-topbar-brand"><img src="${pageContext.request.contextPath}/back/img/logo.png"></div>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
            <li class="am-dropdown tognzhi" data-am-dropdown>
                <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o"  data-am-dropdown-toggle> 消息管理<span class="am-badge am-badge-danger am-round">0</span></button>
                <ul class="am-dropdown-content">
                    <li class="am-dropdown-header">所有消息都在这里</li>
                    <li><a href="#" onclick="loadPage('${pageContext.request.contextPath}/background/OrderList');">未发货订单</a></li>
                </ul>
            </li>
            <li class="kuanjie">
                <a href="#" data-am-modal="{target: '#my-superinfo'}">信息修改</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/Login">退出系统</a>
            </li>
        </ul>
    </div>
</header>

<!-- admin-main开始 -->
<div class="am-cf admin-main">
    <!-- 侧面栏 -->
    <div class="nav-navicon admin-main admin-sidebar">
        <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎超级管理员：${sessionScope.superAdmin.superadminName}</div>

        <!-- 菜单 -->
        <div class="sideMenu">
            <h3 class="am-icon-flag"><em></em> <a href="#">商品管理</a></h3>
            <ul>
                <li><a  onclick="loadPage('${pageContext.request.contextPath}/background/CommodityList',null);" href="#">商品列表</a></li>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/CommodityKindList',null);" href="#">商品分类管理</a></li>
            </ul>
            <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 订单管理</a></h3>
            <ul>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/OrderList',null);" href="#">未发货订单列表</a></li>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/SendOrderList',null);" href="#">发货单列表</a></li>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/ReplaceOrderList',null);" href="#">换货单列表</a></li>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/ReturnOrderList',null);" href="#">到货单列表</a></li>
            </ul>
            <h3 class="am-icon-users"><em></em> <a href="#">会员管理</a></h3>
            <ul>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/UserList','UserList');" href="#">用户列表</a></li>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/AdminList','AdminList');" href="#">普通管理员列表</a></li>
            </ul>
            <h3 class="am-icon-volume-up"><em></em> <a href="#">评论管理</a></h3>
            <ul>
                <li><a onclick="loadPage('${pageContext.request.contextPath}/background/CommentList','CommentList');" href="#">评论列表</a></li>
            </ul>
        </div>
        <!-- 菜单结束 -->

        <script type="text/javascript">
            jQuery(".sideMenu").slide({
                titCell:"h3", //鼠标触发对象
                targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
                effect:"slideDown", //targetCell下拉效果
                delayTime:300 , //效果时间
                triggerTime:150, //鼠标延迟触发时间（默认150）
                defaultPlay:true,//默认是否执行效果（默认true）
                returnDefault:false //鼠标从.sideMen移走后返回默认状态（默认false）
            });
        </script>
    </div>

    <!-- admin-content，内容页面 -->
    <div class=" admin-content">
        <!-- 顶部导航栏 -->
        <div class="daohang">
            <ul id="leader_title">
                <li><button type="button" onclick="loadPage('${pageContext.request.contextPath}/background/UserList','UserList');" class="am-btn am-btn-default am-radius am-btn-xs"> 首页</button></li>
            </ul>
        </div>
        <%--页面内容--%>
        <div id="content"></div>
    </div>
    <!-- admin-mian页面结束 -->
    <script src="${pageContext.request.contextPath}/back/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/js/layer.js"></script>
    <script src="${pageContext.request.contextPath}/back/js/background.js"></script>
    <script>
        $(function () {
            loadPage('${pageContext.request.contextPath}/background/UserList','UserList');
        })

        $(".sideMenu li a").click(function () {
            var url;
            var title=$(this).text();
            if(title=="商品列表") url="CommodityList";
            else if(title=="商品分类管理")url="CommodityKindList";
            else if(title=="未发货订单列表")url="OrderList";
            else if(title=="发货单列表")url="SendOrderList";
            else if(title=="换货单列表")url="ReplaceOrderList";
            else if(title=="到货单列表")url="ReturnOrderList";
            else if(title=="用户列表")url="UserList','UserList";
            else if(title=="普通管理员列表")url="AdminList','AdminList";
            else if(title=="评论列表")url="CommentList','CommentList";

            $("#leader_title").append("<li><button type=\"button\" class=\"am-btn am-btn-default am-radius am-btn-xs\"" +
                "onclick=\"loadPage('/CShoppingMall/background/"+url+"')\">"
                +title+
                "<a  class=\"am-close am-close-spin head_close\"  href='#' onclick='removehead(this)'>×</a></button></li>");
        });
        function removehead(obj){
            $(obj).parent().remove();
        }

    </script>
</div>
</body>
</html>
