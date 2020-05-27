<%--
  Created by IntelliJ IDEA.
  User: 23676
  Date: 2020/4/25
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/UserRegTheme.css" id="theme-stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/layer.css"/>

<script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/layer.js"></script>
<script src="${pageContext.request.contextPath}/back/js/FrontGround.js"></script>


<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">

                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>欢迎注册</h1>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form action="${pageContext.request.contextPath}/user/AddUser" id="t" method="post">
                            <div class="form-group">
                                <input id="password" class="input-material" type="password" name="password" placeholder="请输入密码"   >
                            </div>
                            <div class="form-group">
                                <input id="repassword" class="input-material" type="password" name="repassword" placeholder="请再次输入密码">
                            </div>
                            <div class="form-group">
                                <input id="userName" class="input-material" type="text" name="userName" placeholder="真实姓名"   >
                            </div>
                            <div class="form-group">
                                <input id="userEmail" class="input-material" type="text" name="userEmail" placeholder="邮箱"   >
                            </div>
                            <div class="form-group">
                                <input id="userPhone" class="input-material" type="text" name="userPhone" placeholder="手机号"   >
                            </div>
                            <div class="form-group">
                                <button id="regbtn" type="button"  class="btn btn-primary"
                                        onclick="saveUser()">注册</button>
                            </div>
                            <small>已有账号?</small><a href="${pageContext.request.contextPath}/user/ToLogin" class="signup">&nbsp;登录</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
