<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/23
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>搜索-服装商城</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/style.css"/>
</head>
<body>
<%--头部--%>
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="../index.jsp" target="_blank">服装商城首页</a></li>
                <li>|</li>
                <li><a href="">我已买到的宝贝</a></li>
                <li>|</li>
                <li><a href="${pageContext.request.contextPath}/Cart/selectAll">购物车</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="fr">
                <c:choose>
                    <c:when test="${sessionScope.user!=null}">
                        <ul>
                            <li><img style=" margin-top:5px; border-radius: 50%; height: 30px;width: 30px;" src="${pageContext.request.contextPath}/usertitle/${sessionScope.user.userTitle}"/></li>
                            <li><a href="/CShoppingMall/user/UserInfo">个人信息</a></li>
                            <li>|</li>
                            <li><a href="/CShoppingMall/user/LoginOut">退出</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/user/ToLogin" target="_blank">登录</a></li>
                            <li>|</li>
                            <li><a href="${pageContext.request.contextPath}/user/ToReg" target="_blank" >注册</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<%--头部结束--%>


<div class="banner_x center">
    <div class="nav fl">
        <ul>
            <ul>
                <li><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">女装</a></li><li></li>
                <li><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">男装</a></li><li></li>
                <li><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=3">童装</a></li><li></li>
            </ul>
        </ul>
    </div>
    <div class="search fr">
        <form action="${pageContext.request.contextPath}/frontCommodity/selectByDim" method="post">
            <div class="text fl">
                <input type="text" class="shuru" placeholder="搜索" name="selectCommodity">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<div class="xiantiao"></div>

<div class="danpin center">
    <div class="biaoti center">商品列表</div>
    <div class="main center">
        <c:forEach items="${commodityList}" var="commodityList" varStatus="status">
            <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
                <div class="sub_mingxing"><a href="commoditydetails" target="_blank"><img src="${commodityList.commodityPicture}" alt=""></a></div>
                <div class="pinpai"><a href="${pageContext.request.contextPath}/frontCommodity/selectOne?commodityId=${commodityList.commodityId}">${commodityList.commodityName}</a></div>
                <div class="jiage">${commodityList.commodityMoney}元</div>
            </div>
        </c:forEach>
        <div class="clear"></div>
    </div>
</div>
</body>
</html>
