<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/20
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>用户列表</title>
</head>
<body>
<!-- 新页面 -->
<!-- 用户列表页面 -->
<div class="admin-biaogelist">
    <!-- 新页面内部导航栏 -->
    <div class="listbiaoti am-cf">
        <ul class="am-icon-users"> 用户管理</ul>
        <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">用户列表</a></dl>
    </div>
    <!-- 用户列表 -->
    <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" /></th>
                <th class="table-id">ID</th>
                <th class="table-title">用户名称</th>
                <th class="table-title">用户email</th>
                <th class="table-title">用户证件证件类型</th>
                <th class="table-title">用户证件证件号</th>
                <th width="130px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="checkbox"/></td>
                <td>14</td>
                <td>田源宽</td>
                <td>tianyuankuan@163.com</td>
                <td>美利坚合众国身份证</td>
                <td>1111111111111111</td>
                <td>
                    <!-- 操作栏 -->
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button class="am-btn am-btn-default am-btn-xs am-text-success am-round"><span class="am-icon-search" title="查看用户详情"></span> </button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改用户"><span class="am-icon-pencil-square-o"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除用户"><span class="am-icon-trash-o" ></span></button>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td><input type="checkbox"/></td>
                <td>14</td>
                <td>田源宽</td>
                <td>tianyuankuan@163.com</td>
                <td>美利坚合众国身份证</td>
                <td>1111111111111111</td>
                <td>
                    <!-- 操作栏 -->
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button class="am-btn am-btn-default am-btn-xs am-text-success am-round"><span class="am-icon-search" title="查看用户详情"></span> </button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改用户"><span class="am-icon-pencil-square-o"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除用户"><span class="am-icon-trash-o" ></span></button>
                        </div>
                    </div>
                </td>
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
            <a class="am-text-success am-icon-search-plus"> 查询用户信息</a>
            <a class="am-icon-pencil-square-o am-text-secondary"> 修改用户信息</a>
            <a class="am-icon-trash-o am-text-danger" > 删除用户信息</a>
        </p>
    </form>
</div>
<!-- 用户列表页面 结束 -->
</body>
</html>

