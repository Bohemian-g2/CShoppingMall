<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/19
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>超级管理员个人信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/Info.css">
</head>
<body>
<div class="grxx">
    <div class="selfinfo center">
        <div class="rtcont fr">
            <div class="grzlbt ml40">我的资料</div>
            <div class="subgrzl ml40"><span>昵称</span><span>${sessionScope.superadmin.superadminName}</span></div>
            <div class="subgrzl ml40"><span>密码</span><span>************</span><span><a href="">编辑</a></span></div>
        </div>
        <div class="clear"></div>
    </div>
</div>
</body>
</html>
