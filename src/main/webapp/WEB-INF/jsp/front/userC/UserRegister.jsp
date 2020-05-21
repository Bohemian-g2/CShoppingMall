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
                                <input id="loginName" class="input-material" type="text" name="loginName" placeholder="请输入用户名" >
                                <div class="invalid-feedback">
                                    用户名必须在6~8位之间
                                </div>
                            </div>
                            <div class="form-group">
                                <input id="password" class="input-material" type="password" name="password" placeholder="请输入密码"   >
                                <div class="invalid-feedback">
                                    密码必须在6~16位之间
                                </div>
                            </div>
                            <div class="form-group">
                                <input id="userName" class="input-material" type="text" name="userName" placeholder="真实姓名"   >
                                <div class="invalid-feedback">
                                    真实姓名
                                </div>
                            </div>
                            <div class="form-group">
                                <input id="userEmail" class="input-material" type="text" name="userEmail" placeholder="邮箱"   >
                                <div class="invalid-feedback">
                                    邮箱
                                </div>
                            </div>
                            <div class="form-group">
                                <input id="userPhone" class="input-material" type="text" name="userPhone" placeholder="手机号"   >
                                <div class="invalid-feedback">
                                    手机号
                                </div>
                            </div>
                            <div class="form-group">
                                <button id="regbtn" type="submit"  class="btn btn-primary"
                                        onclick="saveAdmin()">注册</button>
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
