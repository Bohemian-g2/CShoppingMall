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
    <title>商品详情-服装商城</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/product.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/remark.css" />
    <script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/js/commoditydetail.js"></script>
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


<div class="jieshao mt20 w">
    <div class="left fl"> <img src="${pageContext.request.contextPath}/${commodity.commodityPicture}"></div>
    <div class="right fr">
        <div class="h3 ml20 mt20"> 名称：${commodity.commodityName}：</div>
        <div class="jianjie mr40 ml20 mt10">简单介绍获取</div>
        <div class="jiage ml20 mt10">价格：￥${commodity.commodityMoney}元</div>
        <div class="ft20 ml20 mt20">尺码</div>
        <div class="xzbb ml20 mt10">
            <div class="size fl">
                <a><span>S </span></a>
            </div>
            <div class="size fl">
                <a><span>M</span></a>
            </div>
            <div class="size fl">
                <a><span>L</span></a>
            </div>
            <div class="size fl">
                <a><span>XL</span></a>
            </div>
            <div class="clear"></div>
        </div>
        <div class="ft20 ml20 mt20">颜色分类</div>
        <div class="xzbb ml20 mt10">
            <div class="color fl">
                <a>
                    <span>黑色</span>
                </a>
            </div>
            <div class="color fl">
                <a>
                    <span>白色</span>
                </a>
            </div>
            <div class="color fl">
                <a>
                    <span>蓝色</span>
                </a>
            </div>
            <div class="color fl">
                <a>
                    <span>卡其色</span>
                </a>
            </div>
        </div>
            <div class="xiadan ml20 mt20">
                <input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
                <input class="jrgwc" type="button" name="jrgwc" value="加入购物车" />
            </div>
        </div>
</div>

<div  id="foot" style="width: 1226px;margin:auto;margin-top: 50px;">
    <ul class="nav nav-tabs" >
        <li role="presentation" class="remark_header active" color="#ff6700"><a href="#foot" >商品介绍</a></li>
        <%--<li role="presentation"><a href="#" onclick="loadComment('${commodity.commodityId}')">商品评价</a></li>--%>
        <li role="presentation" class="remark_header" color="#ff6700"><a href="#foot"  onclick="loadComment(1)">商品评价</a></li>
    </ul>
    <div id="commoditydetail" style="margin-top:20px;">
        这里直接写商品介绍，我在commoditydetail.js文件中写了异步函数，点击评论信息直接切换出评论页面
    </div>
</div>
<div class="copyright">版权所有，维权必究，所有数据均由出自我组测试</div>
<script>

    $(".remark_header").click(function(){
        $(".remark_header").removeClass("active");
        $(this).addClass("active");
    });
</script>
</body>
</html>
