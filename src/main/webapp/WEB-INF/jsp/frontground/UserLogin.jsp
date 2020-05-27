<%--
  Created by IntelliJ IDEA.
  User: 23676
  Date: 2020/4/25
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/UserLoginTheme.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/layer.css"/>
<script src="${pageContext.request.contextPath}/back/js/FrontLogin.js"></script>
<script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/layer.js"></script>



<body>
<div class="login-page">
<nav class="navbar navbar-expand-md navbar-dark bg-primary fixed-top sticky-navigation" id="gravity-navbar">
    <a class="navbar-brand" href="index.html">
        网上服装商城系统
    </a>

</nav>
<!--hero header-->
<section class="py-6 py-md-7 bg-primary" id="home">
    <div class="container">
        <div class="row">
            <div class="col-md-6 my-md-auto text-center text-md-left pb-5 pb-md-0">
                <h1 class="display-3 text-white">我们将带您探索不一样的衣装</h1>
                <a href="${pageContext.request.contextPath}/user/ToReg" class="btn btn-secondary page-scroll">新用户注册</a>
            </div>
            <div class="col-md-5 ml-auto">
                <div class="card">
                    <div class="card-body p-4">
                        <h4 class="text-center">用户登录</h4>
                        <form class="signup-form" action="${pageContext.request.contextPath}/user/LoginShop" id="f" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="用户名" name="logname" id="logname">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="密码" name="logpass"  id="logpass">
                            </div>

                            <div class="form-group">
                                <button type="button" class="btn btn-primary btn-block" onclick="loginCheck('${pageContext.request.contextPath}/user/LoginCheck');">登录</button>
                            </div>
                            <a class="forg" href="${pageContext.request.contextPath}/user/LogToFind" >忘记密码？</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>
</body>
</html>
