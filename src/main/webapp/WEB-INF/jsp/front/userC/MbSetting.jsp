<%--
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/layer.css"/>
<script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/back/js/layer.js"></script>
<body>
<div class="mainPage">
    <div id="userinfo">注册成功，请记住您的用户编号：<br/>
        ${sessionScope.nuser.loginName}</div>
        <div class="card" style="margin: auto;margin-top: 100px;">
                <div class="card-body p-4" >
                    <h4 class="text-center">密保问题设置</h4>
                        <form class="signup-form" id="mb_form" action="${pageContext.request.contextPath}/Answer/AddAnswer" method="post">
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
                                <button type="button" onclick="forward()" class="btn btn-primary btn-block">提交</button>
                            </div>
                        </form>
                 </div>
         </div>
</div>
<script>
    $("select[name=questionIdOne]").empty(); //清空
    $("select[name=questionIdTwo]").empty(); //清空
    $.ajax({
        url: "/CShoppingMall/encry/getEncry",
        type: "post",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            $.each(result, function (index, item) {
                console.log(result);
                var option1 = $("<option></option>").append(item.question).attr("value", item.questionId);
                var option2 = $("<option></option>").append(item.question).attr("value", item.questionId);
                $("#qOne").append(option1);
                $("#qTwo").append(option2);
            })
        }
    });
    function forward(){
        layer.msg('注册成功，3秒后为您跳转至登录页面');
        setTimeout(function(){ $("#mb_form").submit();}, 3000);
    }

</script>
</body>
</html>
