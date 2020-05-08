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
    <title>相似商品-服装商城</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/style.css"/>
</head>
<body>
<%--头部--%>
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="index.jsp" target="_blank">服装商城首页</a></li>
                <li>|</li>
                <li><a href="">我已买到的宝贝</a></li>
                <li>|</li>
                <li><a href="${pageContext.request.contextPath}/front/frontCart">购物车</a></li>
                <li>|</li>
                <li><a href="${pageContext.request.contextPath}/front/frontCollect">收藏夹</a></li>
                <li>|</li>
                <li><a href="${pageContext.request.contextPath}/front/frontRecord">足迹</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="fr">
                <ul>
                    <li><a href="" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="" target="_blank" >注册</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<%--头部结束--%>


<div class="banner_x center">
    <%-- <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
     <a href=""><div class="ad_top fl"></div></a>--%>
    <div class="nav fl">
        <ul>
            <ul>
                <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">女装</a></li><li></li>
                <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">男装</a></li><li></li>
                <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">童装</a></li><li></li>
                <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">中性服装</a></li>
            </ul>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru" placeholder="搜索">
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
    <div class="biaoti center">相似商品</div>
   <%-- <c:forEach var="c" items="${similar}">--%>
        <div class="main center">
                <%--例子1--%>
            <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
                <div class="sub_mingxing"><a href="commoditydetails" target="_blank"><img src=" " alt=""></a></div>
                <div class="pinpai"><a href="commoditydetails" target="_blank">${c.commodityName}例子1</a></div>
                <div class="jiage">￥100</div>
            </div>
                <%--例子2--%>
            <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
                <div class="sub_mingxing"><a href="commoditydetails" target="_blank"><img src=" " alt=""></a></div>
                <div class="pinpai"><a href="commoditydetails" target="_blank">${c.commodityName}例子2</a></div>
                <div class="jiage">￥200</div>
            </div>
                <%--例子3--%>
            <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
                <div class="sub_mingxing"><a href="commoditydetails" target="_blank"><img src=" " alt=""></a></div>
                <div class="pinpai"><a href="commoditydetails" target="_blank">${c.commodityName}例子3</a></div>
                <div class="jiage">￥300</div>
            </div>
            <div class="clear"></div>
        </div>
   <%-- </c:forEach>--%>
</div>
</body>
</html>
