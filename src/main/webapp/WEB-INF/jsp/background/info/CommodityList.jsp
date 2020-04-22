<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/19
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>商品列表</title>
</head>
<body>
<!-- 新页面 -->
<!-- 商品分类列表页面 -->
<div class="admin-biaogelist">
    <!-- 新页面内部导航栏 -->
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on"> 栏目名称</ul>
        <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">商品列表</a></dl>
        <dl>
            <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"> 添加产品</button>
        </dl>
    </div>

    <!-- 商品列表 -->
    <div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
        <ul>
            <li>
                <div class="am-btn-group am-btn-group-xs">
                    <select data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                        <option value="b">产品分类</option>
                    </select>
                </div>
            </li>
            <li><input type="text" class="am-form-field am-input-sm am-input-xm" placeholder="关键词搜索" /></li>
            <li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">搜索</button></li>
        </ul>
    </div>


    <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" /></th>
                <th class="table-id">ID</th>
                <th class="table-title">名称</th>
                <th class="table-type">类别</th>
                <th class="table-author am-hide-sm-only">上架/下架 <i class="am-icon-check am-text-warning"></i> <i class="am-icon-close am-text-primary"></i></th>
                <th width="163px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="checkbox" /></td>
                <td>14</td>
                <td><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only"><i class="am-icon-check am-text-warning"></i></td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <button class="am-btn am-btn-default am-btn-xs am-text-success am-round"><span class="am-icon-search"  title="查询商品"></span> </button>
                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"><span class="am-icon-pencil-square-o"  title="修改商品"></span></button>
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round"><span class="am-icon-trash-o" title="删除商品"></span></button>
                    </div>
                </div></td>
            </tr>
            <tr>
                <td><input type="checkbox" /></td>
                <td>14</td>
                <td><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only"><i class="am-icon-check am-text-warning"></i></td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <button class="am-btn am-btn-default am-btn-xs am-text-success am-round"><span class="am-icon-search"  title="查询商品"></span> </button>
                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"><span class="am-icon-pencil-square-o"  title="修改商品"></span></button>
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round"><span class="am-icon-trash-o" title="删除商品"></span></button>
                    </div>
                </div></td>
            </tr>
            </tbody>
        </table>
        <!-- 新页面底部 -->
        <div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 上架</button>
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-minus"></span> 下架</button>
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
            <a class="am-text-success am-icon-search-plus"> 查询商品信息</a>
            <a class="am-icon-pencil-square-o am-text-secondary"> 修改商品信息</a>
            <a class="am-icon-trash-o am-text-danger"> 删除商品信息</a>
            <a class="am-icon-pencil-square-o am-icon-plus"> 上架商品信息</a>
            <a class="am-icon-trash-o am-icon-minus"> 下架商品信息</a>
        </p>
    </form>
</div>
</div>
</div>
</body>
</html>
