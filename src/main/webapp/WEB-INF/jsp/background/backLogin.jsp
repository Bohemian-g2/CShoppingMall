<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/16
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理系统登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/component.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/layer.css"/>

    <script src="${pageContext.request.contextPath}/back/js/html5.js"></script>


</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>服装商城后台系统</h3>
                <form action="LoginInSys" id="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="logname" id="logname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="logpass"  id="logpass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="" type="password" placeholder="请输入密码">
                    </div>
                    <div class="mb2"><a class="act-but submit" onclick="loginCheck('${pageContext.request.contextPath}/admin/LoginCheck');" href="#" style="color: #FFFFFF">登录</a></div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/login.js"></script>
<script src="${pageContext.request.contextPath}/back/js/layer.js"></script>
<script src="${pageContext.request.contextPath}/back/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/back/js/demo-1.js"></script>
</body>
</html>