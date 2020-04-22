<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/19
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>评论列表</title>
</head>
<body>
<!-- 评论列表页面 -->
<div class="admin-biaogelist">
    <!-- 新页面内部导航栏 -->
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">用户评论</ul>
        <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">用户评论</a></dl>
    </div>
    <!-- 评论列表 -->
    <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" /></th>
                <th class="table-id">排序</th>
                <th class="table-id am-text-center">ID</th>
                <th class="table-title">商品名称</th>
                <th class="table-type">商品评论</th>
                <th width="125px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="checkbox" /></td>
                <td class="am-text-center">14</td>
                <td><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  title="删除"><span class="am-icon-trash-o"></span></button>
                    </div>
                </div></td>
            </tr>
            <tr>
                <td><input type="checkbox" /></td>
                <td class="am-text-center">14</td>
                <td><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  title="删除"><span class="am-icon-trash-o"></span></button>
                    </div>
                </div></td>
            </tr>
            </tbody>
        </table>
        <!-- 新页面底部 -->
        <div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-search-plus"></span> 查询</button>
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
        </div>
        <!-- 分页标签 -->
        <ul class="am-pagination am-fr">
            <li class="am-disabled"><a href="#">«</a></li>
            <li class="am-active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">»</a></li>
        </ul>
        <hr />
        <p>
            备注：操作图标含义
            <a class="am-text-success am-icon-search-plus" > 查询评论信息</a>
            <a class="am-icon-pencil-square-o am-text-secondary" > 修改评论信息</a>
            <a class="am-icon-trash-o am-text-danger" > 删除评论信息</a>
        </p>
    </form>
</div>
</div>
</div>

</body>
</html>
