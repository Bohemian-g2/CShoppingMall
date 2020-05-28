<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/5/8
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>订单中心</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/style.css">
    <!--<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/front/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/order.js"></script>
</head>
<body>

<%--头部--%>
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="index.jsp" target="_blank">服装商城首页</a></li>
                <li>|</li>
                <li><a href="${pageContext.request.contextPath}/front/frontShowIndent">我已买到的宝贝</a></li>
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

            <c:forEach items="${sessionScope.indentList}" var="indent" varStatus="status">
                <input type="hidden"  id="myid" value="${indent.indentId}"/>
                <div class="ddxq">
                        <div class="ddspt fl"><img src="./image/gwc_xiaomi6.jpg" alt=""></div>
                        <div class="ddbh fl" >${indent.indentId}</div>  <!-- 订单id-->
                        <div class="ztxx fr">
                            <ul>
                                <li>  <!-- 订单状态-->
                                    <c:set var="indentStatus" value="${indent.indentStatus}"></c:set>
                                    <c:if test="${indentStatus==0}">
                                        未支付
                                    </c:if>
                                    <c:if test="${indentStatus==1}">
                                        已发货
                                    </c:if>
                                    <c:if test="${indentStatus==2}">
                                        换货
                                    </c:if>
                                    <c:if test="${indentStatus==3}">
                                        已到货
                                    </c:if>
                                </li>
                                <li>￥ ${indent.indentTotal}</li>      <!-- 订单总金额-->
                                <li>
                                    <c:set var="oldTime" value="${indent.indentCreateTime}" scope="request"></c:set>
                                    <%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(request.getAttribute("oldTime"))%>
                                </li>        <!-- 订单创建时间-->
                                <li>
                                    <!-- 订单详情 跳转模态框-->
                                    <!-- Button trigger modal -->
                                    <button class="btn btn-default" type="button" onclick="getIndentDetail(${indent.indentId})" data-toggle="modal" data-target="#myModal" style="margin-top: 10px;">
                                        订单详情
                                    </button>
                                </li>
                                <div class="clear"></div>
                            </ul>
                        </div>
                        <div class="clear"></div>
                </div>
            </c:forEach>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document" aria-hidden="true">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">订单详情</h4>
            </div>
            <div class="modal-body" id="mymodal_body">

                    <div style="margin-bottom: 20px;">
                    订单号：<div id="myindentid" style="display: inline-block; margin-right: 285px;"></div>
                    下单时间：<div id="myindentcreatetime" style="display: inline-block;font-family: 'Times New Roman';"></div><br>
                    </div>
                    <div class="strap" style="border-radius: 3px;border-left:2px solid #FF6700;
                        border-right: 1px solid #BBBBBB;border-top: 1px solid #BBBBBB;
                        border-bottom:1px solid #BBBBBB;background-color: #F8F8F8;font-family:Microsoft JhengHei;">商品详情</div>
                    <table id="tabjson" class="table table-hover" style="text-align: center">
                        <tbody >
                        <tr>
                            <th style='text-align: center;font-family: SimSun;'>商品名</th>
                            <th style='text-align: center;font-family: SimSun;'>尺寸</th>
                            <th style='text-align: center;font-family: SimSun;'>颜色</th>
                            <th style='text-align: center;font-family: SimSun;'>适穿性别</th>
                            <th style='text-align: center;font-family: SimSun;'>单价</th>
                            <th style='text-align: center;font-family: SimSun;'>数量</th>
                        </tr>
                        </tbody>
                    </table>
                    <div id="indentBottom" style="margin-bottom:5px;margin-left: 450px;">
                        订单金额：
                        <div id="myindenttotal" style="display: inline-block;color:#ff6700;font-family: 'Weibei SC';font-size:18px; "></div>
                    </div>
                    <table class="table table-hover" id="tabjson2" style="text-align: center"></table>
                    <div id="div1"></div>
                    <div id="myComment"></div>
            </div>
            <div class="modal-footer" id="mymodalfooter">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="closeButton">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
