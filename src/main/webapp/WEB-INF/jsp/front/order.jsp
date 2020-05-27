<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/5/8
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/style.css">
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

<%--顶部导航栏--%>
<div class="banner_x center">
    <%-- <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
     <a href=""><div class="ad_top fl"></div></a>--%>
    <div class="nav fl">
        <ul>
            <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">女装</a></li><li></li>
            <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">男装</a></li><li></li>
            <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">童装</a></li><li></li>
            <li><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">中性服装</a></li>
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
<%--顶部导航栏结束--%>


<div class="grzxbj">
    <div class="selfinfo center">
        <%--侧面导航栏--%>
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="#">我的个人中心</a></li>
                    <li><a href="#">收货地址</a></li>
                </ul>
            </div>
        </div>

        <%--订单列表--%>
        <div class="rtcont fr">
            <div class="ddzxbt">交易订单</div>
            <div class="ddxq">
                <div class="ddspt fl"><img src="./image/gwc_xiaomi6.jpg" alt=""></div>
                <div class="ddbh fl">订单号:1705205643098724</div>
                <div class="ztxx fr">
                    <ul>
                        <li>已发货</li>
                        <li>￥2499.00</li>
                        <li>2017/05/20 13:30</li>
                        <li><a href="">订单详情></a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div class="ddxq">
                <div class="ddspt fl"><img src="./image/liebiao_hongmin4_dd.jpg" alt=""></div>
                <div class="ddbh fl">订单号:170526435444865</div>
                <div class="ztxx fr">
                    <ul>
                        <li>已发货</li>
                        <li>￥1999.00</li>
                        <li>2017/05/26 14:02</li>
                        <li><a href="">订单详情></a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
</body>
</html>
