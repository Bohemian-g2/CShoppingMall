<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/19
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>换货订单列表</title>

</head>
<body>
<!-- 显示商品具体信息模态框 -->
<div class="am-popup am-popup-inner" id="replace_detail_modal" style="height: 400px;overflow-y:auto;">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">订单商品详情</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <tr class="am-popup-bd">
        <form class="am-form tjlanmu" style="width: 90%;margin: auto">
            <table class="am-table am-table-bordered am-table-radius am-table-striped" id="detail_table">
                <thead>
                <tr>
                    <th>商品名称</th>
                    <th>性别</th>
                    <th>颜色款式</th>
                    <th>尺寸大小</th>
                    <th>详情</th>
                    <th>风格</th>
                    <th>购买量</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </form>
</div>
</div>
<!-- 显示商品具体信息模态框结束 -->
<!-- 换货订单列表页面 -->
<div class="admin-biaogelist">
    <!-- 新页面内部导航栏 -->
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on"> 订单列表</ul>
        <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">换货订单列表</a></dl>
    </div>

    <!-- 订单列表-->
    <form class="am-form am-g" id="replace_list" id="replace_list">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" id="check_all"/></th>
                <th class="table-id">ID</th>
                <th class="table-author am-hide-sm-only">购买人</th>
                <th class="table-author am-hide-sm-only">地址</th>
                <th class="table-author am-hide-sm-only">收货人</th>
                <th class="table-date am-hide-sm-only">购买日期</th>
                <th class="table-date am-hide-sm-only">支付方式</th>
                <th class="table-date am-hide-sm-only">换货时间</th>
                <th class="table-title">总金额</th>
                <th class="table-type">运费</th>
                <th width="130px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="checkbox" /></td>
                <td>14</td>
                <td><a href="#">肥皂</a></td>
                <td>11</td>
                <td>杨司成</td>
                <td>天津</td>
                <td>2020年4月5日</td>
                <td>已换货</td>
                <td>
                    <!-- 操作栏 -->
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button class="am-btn am-btn-default am-btn-xs am-text-success am-round"><span class="am-icon-search" title="查看订单详情"></span> </button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改订单"><span class="am-icon-pencil-square-o"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除订单"><span class="am-icon-trash-o" ></span></button>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td><input type="checkbox" /></td>
                <td>14</td>
                <td><a href="#">肥皂</a></td>
                <td>11</td>
                <td>杨司成</td>
                <td>天津</td>
                <td>2020年4月5日</td>
                <td>未换货</td>
                <td>
                    <!-- 操作栏 -->
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button class="am-btn am-btn-default am-btn-xs am-text-success am-round"><span class="am-icon-search" title="查看订单详情"></span> </button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改订单"><span class="am-icon-pencil-square-o"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除订单"><span class="am-icon-trash-o" ></span></button>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <!-- 新页面底部 -->
        <%--<div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-search-plus"></span> 查询</button>
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
        </div>--%>
        <!-- 新页面底部 -->
        <div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default" id="upd_status"> 可换货</button>
        </div>
        <!-- 分页标签 -->
        <ul class="am-pagination am-fr" id="page_info_area">
            <%--<li class="am-disabled"><a href="#">«</a></li>
            <li class="am-active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">»</a></li>--%>
        </ul>
        <hr />
        <p>
            备注：操作图标含义
            <a class="am-text-success am-icon-search-plus"> 查询订单信息</a>
            <a class="am-icon-pencil-square-o am-text-secondary"> 修改订单信息</a>
            <a class="am-icon-trash-o am-text-danger" > 删除订单信息</a>
        </p>
    </form>
</div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/replaceOrder.js"></script>
</body>
</html>
