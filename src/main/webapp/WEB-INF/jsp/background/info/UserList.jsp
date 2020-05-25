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
<!-- 用户条件查询的模态框 -->
<div class="am-popup am-popup-inner" id="my-secuserinfo">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">查询用户信息</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
        <form class="am-form tjlanmu"  style="width: 90%;margin: auto">
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">用户ID：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecUserId" placeholder="请输入用户ID">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">用户名称：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecUserName" placeholder="请输入用户名称">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%;">用户账号：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecUserLoginName" placeholder="请输入用户账号">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">身份证类型：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecUserIdType" placeholder="请输入身份证类型">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">身份证号码：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecUserIdNumber" placeholder="请输入身份证号码">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">联系方式：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecUserPhone" placeholder="请输入联系方式">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">e-mail：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecUserEmail" placeholder="请输入e-mail">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">性别：</div>
                <div class="you">
                    <input type="radio" class="am-input-sm" name="SecUserSex" value="1"/>男
                    <input type="radio" class="am-input-sm" name="SecUserSex" value="2"/>女
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you">
                    <p>
                        <button type="button" class="am-btn am-btn-success am-radius"
                                onclick="getUserList(1)">提交</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
<%--用户条件查询模态框结束--%>

<%--user修改模态框--%>
<div class="am-popup am-popup-inner" id="my-upduserinfo">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">修改用户信息</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
        <form class="am-form tjlanmu" style="width: 90%;margin: auto">
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">用户ID：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="upateUserId" placeholder="请输入用户ID" readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%;margin-top: 5px;">用户账号：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="upateUserLoginName" placeholder="请输入用户账号"readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">身份证类型：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="updateUserIdType" placeholder="请输入身份证类型" readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">身份证号码：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="updateUserIdNumber" placeholder="请输入身份证号码" readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">用户名称：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="upateUserName" placeholder="请输入用户名称"/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">e-mail：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="updateUserEmail" placeholder="请输入e-mail" />
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">联系方式：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="updateUserPhone" placeholder="请输入联系方式" />
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">性别：</div>
                <div class="you">
                    <input type="radio" class="am-input-sm" name="updateUserSex" value="1"/>男
                    <input type="radio" class="am-input-sm" name="updateUserSex" value="0"/>女
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you">
                    <p>
                        <button type="button" class="am-btn am-btn-success am-radius"
                                onclick="updateUser('${pageContext.request.contextPath}/backuser/updateUser')">提交</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
<%--user修改模态框结束--%>


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
                <th class="table-check"><input type="checkbox" onclick="allselect(this,'usercheckbox')"/></th>
                <th class="table-id">ID</th>
                <th class="table-title">用户账号</th>
                <th class="table-title">用户名称</th>
                <th class="table-title">用户证件类型</th>
                <th class="table-title">用户证件证件号</th>
                <th class="table-title">性别</th>
                <th class="table-title">联系方式</th>
                <th width="130px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody id="userInfoPage">
            </tbody>
        </table>
        <!-- 新页面底部 -->
        <div class="am-btn-group am-btn-group-xs" style="float: left;margin-top: 10px ">
            <button type="button" class="am-btn am-btn-default"  data-am-modal="{target: '#my-secuserinfo'}" style="font-size: 1.4rem">
                <span class="am-icon-search-plus"></span>查询</button>
            <button type="button" class="am-btn am-btn-default" style="font-size: 1.4rem"
             onclick="deleteInfo('usercheckbox','${pageContext.request.contextPath}/backuser/deleteUserList')" >
                <span class="am-icon-trash-o"></span> 删除</button>
        </div>
        <%--分页按钮--%>
        <div id="laypage" style="float: right;"></div>
        <div style="clear: both"></div>
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

