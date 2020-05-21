<%--
  Created by IntelliJ IDEA.
  User: 23676
  Date: 2020/5/13
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码找回</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/MbDefault.css">
<script src="${pageContext.request.contextPath}/back/js/getForgetPwd.js"></script>
<script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<body>
<div class="mainPage">
    <div class="col-md-5 ml-auto">
        <div class="card">
            <div class="card-body p-4">
                <h4 class="text-center">密码找回</h4>
                <form class="signup-form" method="post">
                    <h5>用户编号：</h5>
                    <div class="form-group">
                        <input type="text" class="form-control" id="getUserId" name="getUserId" placeholder="请输入您的用户编号">
                    </div>

                    <div class="form-group">
                        <button type="button" class="btn btn-primary btn-block" onclick="getForgetQuestion('${pageContext.request.contextPath}/Answer/getForgetEncry')">查询密保问题</button>
                    </div>
                </form>

                <form method="post" action="${pageContext.request.contextPath}/Answer/getForgetPwd" class="signup-form">
                    <div class="form-group">
                        <select id="AOne" name="AnswerOne">
                            <option value="null">---您的密保问题---</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control"  name="AnswerOneToOne" id="AnswerOneToOne">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block" >查询密码</button>
                    </div>

                </form>



            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
