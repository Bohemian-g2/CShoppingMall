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
    <title>商品分类列表</title>

</head>
<body>
<!-- 新页面 -->
<!-- 手动添加商品分类的模态框 -->
<div class="am-popup am-popup-inner" id="my-popup">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">添加商品一级分类</h4>
        <span data-am-modal-close class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
        <form class="am-form tjlanmu">
            <div class="am-form-group">
                <div class="zuo">商品种类名称：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="commodity_kind" placeholder="请输入名称">
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you">
                    <p>
                        <button type="submit" class="am-btn am-btn-success am-radius">提交</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- 商品分类列表页面 -->
<div class="admin-biaogelist">
    <!-- 新页面内部导航栏 -->
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">商品栏目管理</ul>
        <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">商品分类列表</a></dl>
        <dl>
            <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-am-modal="{target: '#my-popup'}">添加商品一级分类</button>
        </dl>
    </div>
    <!-- 商品分类列表 -->
    <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" /></th>
                <th class="table-id am-text-center">ID</th>
                <th class="table-title">商品种类名称</th>
                <th width="163px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="checkbox" /></td>
                <td class="am-text-center">14</td>
                <td><a href="#">Business management</a></td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="添加子分类"></a>
                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改"><span class="am-icon-pencil-square-o" ></span></button>
                        <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  title="删除"><span class="am-icon-trash-o"></span></button>
                    </div>
                </div></td>
            </tr>
            <tr>
                <td><input type="checkbox" /></td>
                <td class="am-text-center">14</td>
                <td><a href="#">Business management</a></td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="添加子分类"></a>
                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改"><span class="am-icon-pencil-square-o" ></span></button>
                        <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  title="删除"><span class="am-icon-trash-o"></span></button>
                    </div>
                </div></td>
            </tr> <tr>
                <td><input type="checkbox" /></td>
                <td class="am-text-center">14</td>
                <td><a href="#">Business management</a></td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="添加子分类"></a>
                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改"><span class="am-icon-pencil-square-o" ></span></button>
                        <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
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
            <a class="am-text-success am-icon-search-plus" > 查询商品种类信息</a>
            <a class="am-icon-pencil-square-o am-text-secondary" > 修改商品种类信息</a>
            <a class="am-icon-trash-o am-text-danger" > 删除商品种类信息</a>
        </p>
    </form>
</div>
</div>
</div>
</body>
</html>
