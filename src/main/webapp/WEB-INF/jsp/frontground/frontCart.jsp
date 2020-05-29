<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/23
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>我的购物车-服装商城</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/style.css">
    <%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${APP_PATH}/back/js/jquery.min.js"></script>
    <script src="${APP_PATH}/front/js/cart.js"></script>
</head>
<body>

<!-- start banner_x -->
<div class="banner_x center">
    <div class="wdgwc fl ml40">我的购物车 共有<span id="CDTotal">${requestScope.CDTotal}</span>件宝贝</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="clear"></div>
</div>


<div class="xiantiao"></div>
<div class="gwcxqbj">
    <div class="gwcxd center">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" id="check_all" onclick="check_all(this);"/>全选</th>
                <th class="table-id">商品信息</th>
                <th class="table-title">单价</th>
                <th class="table-title">数量</th>
                <th class="table-author am-hide-sm-only">金额</th>
                <th width="130px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody  id="adminInfoPage">
            <c:forEach items="${cDetails}" var="cDetail">
                <tr style="text-align: center;">
                    <td><input type="checkbox" class="check_one" commodityId="${cDetail.commodity.commodityId}" cartId="${cDetail.cartId}" onclick="check_one(this)"></td>
                    <td>${cDetail.commodity.commodityName}</td>
                    <td>${cDetail.commodity.commodityMoney}</td>
                    <td>
                        <%--<button type="button" style="border: none; background-color: white;" onclick="reduce(this)" title="减少">-</button>--%>
                        <button type="button" onclick="reduce(this)" title="减少">
                            <span style="border:2px;">&nbsp;&nbsp;-&nbsp;&nbsp;</span>
                        </button>
                        <span style="display:inline-block;width:20px;">${cDetail.cartCommodityNumbe}</span>
                        <button type="button" onclick="add(this)" title="增加">
                            <span style="border:2px;">&nbsp;&nbsp;+&nbsp;&nbsp;</span>
                        </button>
                        <%--<button type="button" style="border: none; background-color: white;" onclick="add(this)" title="增加">+</button>--%>
                    </td>
                    <td>${cDetail.cartCommodityMoney}</td>
                    <td>
                        <div class="tishi fl ml20">
                            <button type="button" style="border: none; background-color: white;" onclick="del_one(this)" title="删除">删除</button>
                            <button type="button" style="border: none; background-color: white;" onclick="similar(this)" title="相似">
                                <a href="${pageContext.request.contextPath}/frontCommodity/selectByKind?kindId=${cDetail.commodity.commodityKind}">
                                    相似
                                </a>
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <tbody>

        </tbody>
    </div>
    <div class="jiesuandan mt20 center">
        <div class="tishi fl ml20">
            <ul>
                <li><a href="#" id="check" class="clear">全选</a></li>
                <li><a href="#" onclick="del_batch(this)"
                       class="delete" id="cart_delete_all">删除</a><br></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="jiesuan fr">
            <div class="jiesuanjiage fl">已选商品：<span id="total_number">0</span> 件 &nbsp;&nbsp;合计(不含运费)：<span id="total_money" style="display:inline-block;width:35px;">0</span>&nbsp;&nbsp;&nbsp;元 </div>
            <div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>

</div>
</body>
</html>
