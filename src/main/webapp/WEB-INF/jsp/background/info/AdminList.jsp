<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="am-popup am-popup-inner" id="my-admin">
        <div class="am-popup-hd">
            <h4 class="am-popup-title">添加普通管理员</h4>
            <span data-am-modal-close  class="am-close">&times;</span>
        </div>
        <div class="am-popup-bd">
            <form class="am-form tjlanmu"  id="adminform" style="width: 90%;margin: auto">
                <div class="am-form-group">
                    <div class="zuo" style="float: left;width: 19%">管理员名称：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="regAdminName" placeholder="请输入管理员名称">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">账号密码：</div>
                    <div class="you">
                        <input type="password" class="am-input-sm" id="regAdminPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">确认密码：</div>
                    <div class="you">
                        <input type="password" class="am-input-sm" id="reregAdminPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">联系方式：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="regAdminPhone" placeholder="请输入联系方式">

                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="you">
                        <p>
                            <button type="button" class="am-btn am-btn-success am-radius"
                                    onclick="saveAdmin('${pageContext.request.contextPath}/ordiadmin/AddAdmin')">提交</button>
                        </p>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <%--添加管理员模态框结束--%>

    <!-- 修改管理员的模态框 -->
    <div class="am-popup am-popup-inner" id="my-updadminfo">
        <div class="am-popup-hd">
            <h4 class="am-popup-title">修改普通管理员信息</h4>
            <span data-am-modal-close  class="am-close">&times;</span>
        </div>
        <div class="am-popup-bd">
            <form class="am-form tjlanmu"  id="adminUpdateform" style="width: 90%;margin: auto">
                <div class="am-form-group">
                    <div class="zuo" style="float: left;width: 19%">管理员名称：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="updateAdminName" placeholder="请输入管理员名称">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">联系方式：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="updateAdminPhone" placeholder="请输入联系方式">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="you">
                        <p>
                            <button type="button" class="am-btn am-btn-success am-radius"
                                    onclick="updateAdmin('${pageContext.request.contextPath}/ordiadmin/updateAdmin')">提交</button>
                        </p>
                    </div>
                </div>
                <input type="hidden" id="updateAdminId"/>
            </form>
        </div>
    </div>
    <%--修改管理员模态框结束--%>

    <%--条件查询的模态框--%>
    <div class="am-popup am-popup-inner" id="my-secadmininfo">
        <div class="am-popup-hd">
            <h4 class="am-popup-title">查询普通管理员信息</h4>
            <span data-am-modal-close  class="am-close">&times;</span>
        </div>
        <div class="am-popup-bd">
            <form class="am-form tjlanmu"   style="width: 90%;margin: auto">
                <div class="am-form-group">
                    <div class="zuo" style="float: left;width: 19%">管理员id：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="SecAdminId" placeholder="请输入管理员id">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo" style="float: left;width: 19%">管理员账号：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="SecAdminUsername" placeholder="请输入管理员账号">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo" style="float: left;width: 19%">管理员名称：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="SecAdminName" placeholder="请输入管理员名称">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo">联系方式：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="SecAdminPhone" placeholder="请输入联系方式">
                    </div>
                </div>
                <div class="am-form-group">
                    <div class="zuo" style="float: left;width: 19%">注册日期：</div>
                    <div class="you">
                        <input type="text" class="am-input-sm" id="SecRegisterDate" placeholder="请输入注册日期">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="you">
                        <p>
                            <button type="button" class="am-btn am-btn-success am-radius"
                                    onclick="getAdminList()">提交</button>
                        </p>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <%--条件查询的模态框结束--%>

    <!-- 管理员列表页面 -->
    <div class="admin-biaogelist">
        <!-- 新页面内部导航栏 -->
        <div class="listbiaoti am-cf">
            <ul class="am-icon-users"> 管理员管理</ul>
            <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">管理员列表</a></dl>
            <dl>
                <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-am-modal="{target: '#my-admin'}"> 手动添加管理员</button>
            </dl>
        </div>
        <!-- 管理员列表 -->
        <form class="am-form am-g">
            <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr class="am-success">
                    <th class="table-check"><input type="checkbox" id="allcheck"  onclick="allselect(this,'admincheckbox')"/></th>
                    <th class="table-id">ID</th>
                    <th class="table-title">普通管理员账号</th>
                    <th class="table-title">普通管理员名称</th>
                    <th class="table-author am-hide-sm-only">普通管理员联系方式</th>
                    <th class="table-author am-hide-sm-only">注册日期</th>
                    <th width="130px" class="table-set">操作</th>
                </tr>
                </thead>
                <tbody  id="adminInfoPage">
                </tbody>
            </table>
            <!-- 新页面底部 -->
            <div style="width: 100%">
                    <div class="am-btn-group am-btn-group-xs" style="float: left;margin-top: 10px ">
                        <button type="button" class="am-btn am-btn-default"  data-am-modal="{target: '#my-secadmininfo'}" style="font-size: 1.4rem">
                            <span class="am-icon-search-plus"></span> 查询</button>
                        <button type="button" class="am-btn am-btn-default" onclick="deleteInfo('admincheckbox','${pageContext.request.contextPath}/ordiadmin/deleteAdminList')" style="font-size: 1.4rem">
                            <span class="am-icon-trash-o" ></span> 删除</button>
                    </div>
                <%--分页按钮--%>
                <div id="laypage" style="float: right;"></div>
                <div style="clear: both"></div>
            </div>
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
<script>

</script>
</body>
</html>
