<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="am-popup am-popup-inner" id="insert_kind_modal" style="height: 220px; width: 600px;">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">添加商品一级分类</h4>
        <span data-am-modal-close class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd" >
        <form class="am-form tjlanmu">
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 30%">商品种类名称：</div>
                <div class="you" style="float: right;width: 69%">
                    <input type="text" class="am-input-sm" id="insert_kind_name" name="kindName" placeholder="请输入名称">
                    <span id="insert_info"></span>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you" >
                    <p>
                        <button type="submit" class="am-btn am-btn-success am-radius" id="insert_kind_btn">提交</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- 添加商品类别信息模态框结束 -->
<!-- 修改商品类别信息模态框 -->
<div class="am-popup am-popup-inner" id="upd_kind_modal" style="height: 220px; width: 600px;">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">商品类别修改</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd" id="kind_info">
        <form class="am-form tjlanmu" style="width: 90%;margin: auto">
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">商品id：</div>
                <div class="you" style="float: right;width: 80%">
                    <input type="text" class="am-input-sm" name="kindId" id="upd_kind_id" readonly="readonly">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">商品类别：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" name="kindName" id="upd_kind_name">
                    <span id="upd_info"></span>
                </div>
            </div>

            <div class="am-form-group am-cf">
                <div class="you">
                    <p>
                        <button type="button" class="am-btn am-btn-success am-radius" id="update_kind_btn">确认修改</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- 修改商品类别模态框结束 -->
<!-- 商品分类列表页面 -->
<div class="admin-biaogelist">
    <!-- 新页面内部导航栏 -->
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">商品栏目管理</ul>
        <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">商品分类列表</a></dl>
        <dl>
            <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-am-modal="{target: '#insert_kind_modal'}">添加商品一级分类</button>
        </dl>
    </div>
    <!-- 商品列表 -->
    <div class="am-btn-group am-btn-group-xs am-kg am-cf">
        <ul>
            <li><input type="text" class="am-form-field am-input-sm am-input-xm" placeholder="关键词搜索" id="kindSelect"/></li>
            <li><button type="button" class="am-btn am-btn-default" id="select_Kind_btn"><span class="am-icon-search-plus"></span> 查询</button></li>
            <li><button type="button" class="am-btn am-btn-default" id="delete_Batch_Kind"><span class="am-icon-trash-o"></span> 删除</button></li>
        </ul>
    </div>
    <!-- 商品分类列表 -->
    <form class="am-form am-g" id="commodity_list">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" id="check_all"/></th>
                <th class="table-id am-text-center">ID</th>
                <th class="table-title am-text-center">商品种类名称</th>
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
            </tbody>
        </table>

        <!-- 分页标签 -->
        <ul class="am-pagination am-fr" id="c">
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
            <a class="am-text-success am-icon-search-plus" > 查询商品种类信息</a>
            <a class="am-icon-pencil-square-o am-text-secondary" > 修改商品种类信息</a>
            <a class="am-icon-trash-o am-text-danger" > 删除商品种类信息</a>
        </p>
    </form>
</div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/commodityKind.js"></script>
</body>
</html>
