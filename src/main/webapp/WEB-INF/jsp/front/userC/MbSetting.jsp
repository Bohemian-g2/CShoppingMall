<%@ page import="com.wsfzsc.pojo.UserInf" %><%--
  Created by IntelliJ IDEA.
  User: 23676
  Date: 2020/5/10
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>密保设置页</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/MbDefault.css">
<script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/Mb.js"></script>
<body>
<%
    UserInf nuser = (UserInf) session.getAttribute("nuser");
%>
<div class="mainPage">
    <div id="userinfo">注册成功，请记住您的用户编号：<br/>
        <%=nuser.getUserId()%></div>
        <div class="card">
                <div class="card-body p-4">
                    <h4 class="text-center">密保问题设置</h4>
                        <form class="signup-form" action="${pageContext.request.contextPath}/Answer/AddAnswer" method="post">
                            <div class="form-group">
                                <select id="qOne" name="questionIdOne">
                                    <option value="null">---请选择您的密保问题1---</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control"  name="answerOne" id="answerOne">
                            </div>
                            <div class="form-group">
                                <select id="qTwo" name="questionIdTwo">
                                    <option value="null">---请选择您的密保问题2---</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control"  name="answerTwo"  id="answerTwo">
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-primary btn-block" onclick="getQuestions('${pageContext.request.contextPath}/encry/getEncry')">获取密保问题</button>
                                <button type="submit" class="btn btn-primary btn-block">提交</button>
                            </div>
                        </form>
                 </div>
         </div>
</div>
</body>
</html>
