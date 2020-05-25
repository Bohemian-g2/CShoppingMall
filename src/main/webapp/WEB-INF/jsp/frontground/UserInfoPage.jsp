<%@ page import="com.wsfzsc.pojo.UserInf" %><%--
  Created by IntelliJ IDEA.
  User: 23676
  Date: 2020/5/18
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户个人信息</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/UserInforeset.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/UserInfolayout.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/UserInfostyle.css" type="text/css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery-1.5.2.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/kwicks-1.5.1.pack.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/script.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/sanJselect.js" charset="UTF-8"></script>



</head>
<body id="page1" >

<a href="#">返回商城</a>
<div class="body1">
    <header>
        <h1>用户个人信息</h1>

    </header>
    <div class="body2">
        <div class="main">

            <section id="content">
                <div class="inner">
                    <div class="kwiks_wrap">
                        <ul class="kwicks horizontal">
                            <li id="page_1">
                                <div class="text">Main Page</div>
                                <div class="cont">
                                    <div class="left">
                                    <figure class="left marg_right1">
                                        <img src="
                                              <%
                                                UserInf user = (UserInf) session.getAttribute("user");
                                                if(user.getUserTitle()==null){
                                              %>
                                                  ${pageContext.request.contextPath}/back/img/UserTitle.jpg
                                              <%
                                              }else{
                                              %>
                                                  ${pageContext.request.contextPath}/usertitle/${sessionScope.user.userTitle}
                                              <%
                                              }
                                              %>"
                                             width="150px" height="150px">
                                    </figure>
                                    <div class="bottom">
                                    <form action="${pageContext.request.contextPath}/user/uploadTitle" method="post" enctype="multipart/form-data">
                                        <input type="file" id="file" name="file" value="点击上传头像"><br>
                                        <input type="submit" value="上传">
                                    </form>
                                    </div>
                                    </div>
                                    <div class="right uif">
                                    用户ID:${sessionScope.user.userId}<br>
                                    真实姓名:${sessionScope.user.userName}<br>
                                    联系方式:${sessionScope.user.userPhone}<br>
                                    邮箱:${sessionScope.user.userEmail}<br>
                                    性别:<%
                                        if (null!=user.getSex()){
                                            if (user.getSex()==1){
                                                %>男<%
                                            }else {
                                                %>女<%
                                            }
                                        }else {
                                            %>${sessionScope.user.sex}<%
                                            }
                                    %><br>

                                    证件类型:<%
                                        if(null!=user.getIdentityType()){
                                            if (user.getIdentityType()==1){
                                                %>身份证<%
                                            }else if(user.getIdentityType()==2) {
                                                %>护照<%
                                            }else if(user.getIdentityType()==3){
                                                %>军官证<%
                                            }
                                        }else {
                                            %>${sessionScope.user.identityType}<%
                                            }
                                    %><br>
                                    证件号:${sessionScope.user.identityNumber}
                                    </div>
                                </div>
                            </li>
                            <li id="page_2">
                                <div class="text">Update Userinfo</div>
                                <div class="cont">
                                    <center><h3>个人信息修改</h3></center>
                                <form action="${pageContext.request.contextPath}/user/updateUserInfo" method="post">
                                    真实姓名:${sessionScope.user.userName}<br>
                                    联系方式:<input type="text" name="newPhone" value="${sessionScope.user.userPhone}"><br>
                                    邮箱:<input type="text" name="newEmail" value="${sessionScope.user.userEmail}"><br>
                                    证件类型:<select name="identype">
                                            <option value="1" selected="selected">身份证</option>
                                            <option value="2">护照</option>
                                            <option value="3">军官证</option>
                                            </select><br>
                                    证件号:<input type="text" name="indenNum"><br>
                                    性别:<select name="usex">
                                            <option value="1" selected="selected">男</option>
                                            <option value="2">女</option>
                                        </select><br>
                                    <input type="submit" value="提交">
                                </form>
                                </div>
                            </li>
                            <li id="page_3">
                                <div class="text">Update Password</div>
                                <div class="cont">
                                    <center><h3>密码修改</h3></center>
                                <form action="${pageContext.request.contextPath}/user/updatePwd" method="post">
                                    <input type="text" name="newPwd" placeholder="请输入新密码">
                                    <input type="submit" value="修改密码">
                                </form>
                                </div>
                            </li>
                            <li id="page_4" onclick="showAddress('${pageContext.request.contextPath}/address/showAddress')">
                                <div class="text">My address</div>
                                <br>
                                <div class="cont">
                                    <center><h3>我的收货地址</h3></center>
                                    <div id="addressMes">
                                    </div>
                                </div>
                            </li>
                            <li id="page_5">
                                <div class="text">Add address</div>
                                <div class="cont">
                                    <center><h3>新增收货地址</h3></center>
                                    <form action="${pageContext.request.contextPath}/address/AddAddress" method="post">
                                        收货人姓名:<input type="text" name="addressName"><br>
                                        收货人电话:<input type="text" name="addressPhone"><br>
                                        省：
                                        <select name="province" id="province">
                                            <option value="">请选择</option>
                                        </select>
                                        市：
                                        <select name="city" id="city" disabled="disabled">
                                            <option value="">请选择</option>
                                        </select>
                                        区：
                                        <select name="district" id="district" disabled="disabled">
                                            <option value="">请选择</option>
                                        </select><br>
                                        邮编:<input type="text" name="postCode"><br>
                                        详细地址:<input type="text" name="detailedAddress"><br>
                                        <input type="submit" value="添加">
                                    </form>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
</body>

</body>
</html>
