<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/16
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>服装商城</title>
    <link rel="stylesheet" type="text/css" href="./front/css/style.css"/>
    <script src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script src="front/js/index.js"></script>
</head>
<body>

<%--头部--%>
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="index.jsp" target="_blank">服装商城首页</a></li>
                <li>|</li>
                <li><a href="front/frontShowIndent">我已买到的宝贝</a></li>
                <li>|</li>
                <li><a href="Cart/selectAll">购物车</a></li>
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
<input type="hidden" id="init" value="1">
<%--顶部导航栏--%>
<div class="banner_x center">
    <%-- <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
     <a href=""><div class="ad_top fl"></div></a>--%>
    <div class="nav fl">
        <ul>
            <li><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">女装</a></li><li></li>
            <li><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">男装</a></li><li></li>
            <li><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=3">童装</a></li><li></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="${pageContext.request.contextPath}/frontCommodity/selectByDim" method="post">
            <div class="text fl">
                <input type="text" class="shuru" placeholder="搜索" name="selectCommodity">
            </div>
            <div class="submit fl">
                <%--<input type="submit" class="sousuo" value="搜索" onclick="selectByDim('${pageContext.request.contextPath}/frontCommodity/selectByDim')"/>--%>
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<%--顶部导航栏结束--%>

<%--侧面导航栏--%>
<div class="banner_y center">
    <div class="nav">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">女装</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=4">女裙</a>
                <a href="">连衣裙 半身裙 旗袍</a>
                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">连衣裙</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">半身裙</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">旗袍</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">选购</a></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li>
                <a href="">上装(女）雪纺衫 卫衣 T恤</a>
                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">上装(女）</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=5">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">雪纺衫</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">卫衣</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">T恤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">选购</a></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>

            <li>
                <a href="">女裤 牛仔裤 休闲裤 打底</a>
                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">女裤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=6">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">牛仔裤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=6">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">休闲裤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=6">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl"> 打底</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=6">选购</a></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>


            <li>
                <a href="">外套(女）西装 风衣 毛衣</a>
                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">外套(女）</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">西装</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">风衣</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=7">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">毛呢</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=1">选购</a></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>

            <li>
                <a href="">男装</a>
            </li>

            <li>
                <a href="">男裤 休闲裤 运动裤 牛仔</a>
                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">男裤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">休闲裤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">运动裤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">牛仔</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">选购</a></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>

            <li>
                <a href="">上装(男）T恤 衬衫 卫衣</a>
                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">上装(男）</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">T恤</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">衬衫</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=2">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">卫衣</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=7">选购</a></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>

            <li>
                <a href="">童装</a>
                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">1-2岁</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=3">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">3-6岁</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=3">选购</a></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">6-12岁</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=3">选购</a></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>
        </ul>
    </div>

</div>
<%--侧面导航栏结束--%>

<!-- 热卖服装 -->
<div class="danpin center">
    <div class="biaoti center">热卖服装</div>
    <div class="main center" id="hotlist">
        <c:forEach items="${hotlist}" var="hotlist" varStatus="states">
            <div class="mingxing fl">
                <div class="sub_mingxing"><a href=""><img width="160px;" height="160px;" src="${hotlist.commodityPicture}" alt=""></a></div>
                    <%--<div class="sub_mingxing"><a href=""><img src="./front/img/qz1.png" alt=""></a></div>--%>
                <div class="pinpai"><a href="${pageContext.request.contextPath}/frontCommodity/selectOne?commodityId=${hotlist.commodityId}">${hotlist.commodityName}</a></div>
                <div class="youhui">5月9日-10日，下单立减50元</div>
                <div class="jiage">${hotlist.commodityMoney}</div>
            </div>
        </c:forEach>
        <div class="clear"></div>
    </div>
</div>
<!-- 热卖服装结束 -->

<!-- 好评服装 -->
<div class="peijian w">
    <div class="biaoti center">好评服装</div>
    <div class="main center">
        <div class="content">
            <c:forEach items="${goodlist}" var="goodlist" varStatus="states" begin="0" end="4">
                <div class="remen fl">
                    <div class="xinpin"><span style="background:#fff"></span></div>
                    <div class="tu"><a href=""><img width="160px;" height="160px;" src="${goodlist.commodityPicture}"></a></div>
                    <div class="miaoshu"><a href="${pageContext.request.contextPath}/frontCommodity/selectOne?commodityId=${goodlist.commodityId}">${goodlist.commodityName}</a></div>
                    <div class="jiage">29元</div>
                    <div class="pingjia">372人评价</div>
                </div>
            </c:forEach>
            <div class="clear"></div>
        </div>
        <div class="content">
            <c:forEach items="${goodlist}" var="goodlist" varStatus="states" begin="5" end="9">
                <div class="remen fl">
                    <div class="xinpin"><span style="background:#fff"></span></div>
                    <div class="tu"><a href=""><img width="160px;" height="160px;" src="${goodlist.commodityPicture}"></a></div>
                    <div class="miaoshu"><a href="${pageContext.request.contextPath}/frontCommodity/selectOne?commodityId=${goodlist.commodityId}">${goodlist.commodityName}</a></div>
                    <div class="jiage">${goodlist.commodityMoney}</div>
                    <div class="pingjia">372人评价</div>
                </div>
            </c:forEach>
            <div class="clear"></div>

        </div>
    </div>
</div>
<!-- 好评服装结束-->
</body>
</html>
