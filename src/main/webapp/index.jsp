<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/16
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服装商城</title>
    <link rel="stylesheet" type="text/css" href="./front/css/style.css"/>
</head>
<body>

<%--头部--%>
<header>
    <a href="admin/Login">进入后台登录系统</a>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="index.jsp" target="_blank">服装商城首页</a></li>
                <li>|</li>
                <li><a href="">我已买到的宝贝</a></li>
                <li>|</li>
                <li><a href="front/frontCart">购物车</a></li>
                <li>|</li>
                <li><a href="front/frontCollect">收藏夹</a></li>
                <li>|</li>
                <li><a href="front/frontRecord">足迹</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="fr">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/user/ToLogin" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="${pageContext.request.contextPath}/user/ToReg" target="_blank" >注册</a></li>
                </ul>
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

<%--侧面导航栏--%>
<div class="banner_y center">
    <div class="nav">
        <ul>
            <li>
                <a href="">女装</a>
            </li>
            <li>
                <a href="">女裙</a>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                    <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                    <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                    <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                        <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                        <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
                        <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
                        <div class="clear"></div>
                    </div>
                    <div>
                        <div class="xuangou_left fl">
                            <a href="">
                                <div class="img fl"><img src="" alt=""></div>
                                <span class="fl">孕产妇</span>
                                <div class="clear"></div>
                            </a>
                        </div>
                        <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </li>
            <li>
                <a href="">中性服装</a>

                <div class="pop">
                    <div class="left fl">
                        <div>
                            <div class="xuangou_left fl">
                                <a href="">
                                    <div class="img fl"><img src="" alt=""></div>
                                    <span class="fl">中性服装</span>
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
                                    <span class="fl">大码服装</span>
                                    <div class="clear"></div>
                                </a>
                            </div>
                            <div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/FindByKindId.action?kindId=${KindBase.kindId}">选购</a></div>
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
    <div class="main center">
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./front/img/qz1.png" alt=""></a></div>
            <div class="pinpai"><a href="front/commoditydetails">服装</a></div>
            <div class="youhui">5月9日-10日，下单立减50元</div>
            <div class="jiage">350元起</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./front/img/kz1.png" alt=""></a></div>
            <div class="pinpai"><a href="front/commoditydetails">服装</a></div>
            <div class="youhui">5月9日-10日，下单立减50元</div>
            <div class="jiage">350</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./front/img/wt1.png" alt=""></a></div>
            <div class="pinpai"><a href="front/commoditydetails">服装</a></div>
            <div class="youhui">5月9日-10日，下单立减50元</div>
            <div class="jiage">350</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="" alt=""></a></div>
            <div class="pinpai"><a href="front/commoditydetails">服装</a></div>
            <div class="youhui">5月9日-10日，下单立减50元</div>
            <div class="jiage">350</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="" alt=""></a></div>
            <div class="pinpai"><a href="front/commoditydetails">服装</a></div>
            <div class="youhui">5月9日-10日，下单立减50元</div>
            <div class="jiage">350</div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- 热卖服装结束 -->

<!-- 好评服装 -->
<div class="peijian w">
    <div class="biaoti center">好评服装</div>
    <div class="main center">
        <div class="content">
            <div class="remen fl"><a href=""><img src=" "></a>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span>新品</span></div>
                <div class="tu"><a href=""><img src=" "></a></div>
                <div class="miaoshu"><a href="front/commoditydetails">服装</a></div>
                <div class="jiage">49元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！</span>
                        <span>评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=" "></a></div>
                <div class="miaoshu"><a href="front/commoditydetails">服装</a></div>
                <div class="jiage">29元</div>
                <div class="pingjia">372人评价</div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:red">享6折</span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href="front/commoditydetails">服装</a></div>
                <div class="jiage">19元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快</span>
                        <span>评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="./image/peijian5.jpg"></a></div>
                <div class="miaoshu"><a href="">服装</a></div>
                <div class="jiage">89元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快</span>
                        <span>评价</span>
                    </a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="content">
            <div class="remen fl"><a href=""><img src=" "></a>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=" "></a></div>
                <div class="miaoshu"><a href="front/commoditydetails">服装</a></div>
                <div class="jiage">19元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快</span>
                        <span>评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href="front/commoditydetails">服装</a></div>
                <div class="jiage">19.9元</div>
                <div class="pingjia">372人评价</div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href="front/commoditydetails">服装</a></div>
                <div class="jiage">59元</div>
                <div class="pingjia">775人评价</div>
            </div>
            <div class="remenlast fr">
                <div class="hongmi"><a href=""><img src="./image/hongmin4.png" alt=""></a></div>
                <div class="liulangengduo"><a href=""><img src="./image/liulangengduo.png" alt=""></a></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<!-- 好评服装结束-->
<a href="front/commoditydetails">商品详情</a>
<a href="front/frontCart">购物车</a>
<a href="front/frontCollect">收藏夹</a>
<a href="front/frontRecord">浏览记录</a>
<a href="front/frontShow">商品显示</a>
<a href="front/similarcommodity">类似商品</a>
<a href="front/order">订单中心</a>
</body>
</html>
