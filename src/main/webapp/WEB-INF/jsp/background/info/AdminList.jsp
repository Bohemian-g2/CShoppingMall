<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/3/19
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>管理员列表</title>
</head>
<body>
    <!-- 新页面 -->
    <!-- 手动添加管理员的模态框 -->
    <div class="am-popup am-popup-inner" id="my-popup">
        <div class="am-popup-hd">
            <h4 class="am-popup-title">添加普通管理员</h4>
            <span data-am-modal-close  class="am-close">&times;</span>
        </div>

        <div class="am-popup-bd">
            <form class="am-form tjlanmu" style="width: 90%;margin: auto">
                <div class="am-form-group">
                    <div class="zuo" style="float: left;width: 19%">管理员名称：</div>
                    <div class="you" style="float: right;width: 80%">
                        <input type="text" class="am-input-sm" id="adminName" placeholder="请输入管理员名称">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">账号密码：</div>
                    <div class="you">
                        <input type="password" class="am-input-sm" id="adminPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">确认密码：</div>
                    <div class="you">
                        <input type="password" class="am-input-sm" id="readminPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">联系方式：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="adminPhone" placeholder="请输入联系方式">
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

    <!-- 管理员列表页面 -->
    <div class="admin-biaogelist">
        <!-- 新页面内部导航栏 -->
        <div class="listbiaoti am-cf">
            <ul class="am-icon-users"> 管理员管理</ul>
            <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">管理员列表</a></dl>
            <dl>
                <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-am-modal="{target: '#my-popup'}"> 手动添加管理员</button>
            </dl>
        </div>
        <!-- 管理员列表 -->
        <form class="am-form am-g">
            <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr class="am-success">
                    <th class="table-check"><input type="checkbox" /></th>
                    <th class="table-id">ID</th>
                    <th class="table-title">普通管理员名称</th>
                    <th class="table-author am-hide-sm-only">普通管理员联系方式</th>
                    <th class="table-author am-hide-sm-only">注册日期</th>
                    <th width="130px" class="table-set">操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="checkbox"/></td>
                    <td>14</td>
                    <td><a href="#">德玛西亚</a></td>
                    <td>15736363908</td>
                    <td>2014年9月4日 7:28:47</td>
                    <td>
                        <!-- 操作栏 -->
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改管理员"><span class="am-icon-pencil-square-o"></span></button>
                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除管理员"><span class="am-icon-trash-o" ></span></button>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><input type="checkbox"/></td>
                    <td>14</td>
                    <td><a href="#">德玛西亚</a></td>
                    <td>157373733333</td>
                    <td>2014年9月4日 7:28:47</td>
                    <td>
                        <!-- 操作栏 -->
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改管理员"><span class="am-icon-pencil-square-o"></span></button>
                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除管理员"><span class="am-icon-trash-o" ></span></button>
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
                <a class="am-text-success am-icon-search-plus"> 查询管理员信息</a>
                <a class="am-icon-pencil-square-o am-text-secondary"> 修改管理员信息</a>
                <a class="am-icon-trash-o am-text-danger" > 删除管理员信息</a>
            </p>
        </form>
    </div>
    <!-- 管理员列表页面 结束 -->
</body>
</html>
