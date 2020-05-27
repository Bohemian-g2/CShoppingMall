<%--
  Created by IntelliJ IDEA.
  User: 23676
  Date: 2020/5/14
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/MbDefault.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/layer.css"/>
<script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/layer.js"></script>

<body>
<div class="mainPage">
    <div class="col-md-5 ml-auto" >
        <div class="card" style="margin: auto;margin-top: 100px;">
            <div class="card-body p-4" >
                <h4 class="text-center">密码找回</h4>
                <form class="signup-form" id="findpwd" action="${pageContext.request.contextPath}/user/updateForgetPwd" method="post">
                    <h5>用户编号:${sessionScope.getPwdUserId}</h5>
                    <div class="form-group">
                        <input type="text" class="form-control" name="newPwd"  placeholder="请输入您的新密码">
                    </div>

                    <div class="form-group">
                        <button type="button" onclick="forward()" class="btn btn-primary btn-block">重置密码</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<script>
    function forward(){
        layer.msg('重置成功，3秒后为您跳转至登录页面');
        setTimeout(function(){ $("#findpwd").submit();}, 3000);
    }
</script>
</body>
</html>
