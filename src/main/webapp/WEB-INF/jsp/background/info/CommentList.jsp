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
<!-- 评论条件查询的模态框 -->
<div class="am-popup am-popup-inner" id="my-seccommentinfo">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">查询用户信息</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
        <form class="am-form tjlanmu"  style="width: 90%;margin: auto">
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">评论ID：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecCommentId" placeholder="请输入评论ID">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">用户账号：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecULNComment" placeholder="请输入用户账号">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">商品ID：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecCIDComment" placeholder="请输入商品ID">
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">商品名称：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="SecCNComment" placeholder="请输入商品名称">
                </div>
            </div>

            <div class="am-form-group am-cf">
                <div class="you">
                    <p>
                        <button type="button" class="am-btn am-btn-success am-radius"
                                onclick="getCommentList()">提交</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
<%--评论条件查询模态框结束--%>

<!-- 评论详情的模态框 -->
<div class="am-popup am-popup-inner" id="my-commentdetail">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">查询用户信息</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
        <form class="am-form tjlanmu"  style="width: 90%;margin: auto">
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">评论ID：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailCommentId" readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">用户ID：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailUIdComment"readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo" style="float: left;width: 19%">用户账号：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailULNComment"readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">商品ID：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailCIDComment"readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">商品名称：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailCNComment"readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">订单号：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailCommentIndent"readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">评论时间：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailCommentDate"readonly/>
                </div>
            </div>
            <div class="am-form-group">
                <div class="zuo">评论内容：</div>
                <div class="you">
                    <input type="text" class="am-input-sm" id="detailCommentContent"readonly/>
                </div>
            </div>
        </form>
    </div>
</div>
<%--评论详情模态框结束--%>


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
                <th class="table-check"><input type="checkbox"  onclick="allselect(this,'commentcheckbox')"/></th>
                <th class="table-id">ID</th>
                <th class="table-id">用户账号</th>
                <th class="table-title">商品名称</th>
                <th class="table-title" >商品评论</th>
                <th class="table-title">评论时间</th>
                <th width="125px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody id="commentInfoPage">
            </tbody>
        </table>
        <!-- 新页面底部 -->
        <div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default" data-am-modal="{target: '#my-seccommentinfo'}" style="font-size: 1.4rem">
                <span class="am-icon-search-plus"></span> 查询</button>
            <button type="button" class="am-btn am-btn-default"  style="font-size: 1.4rem"
             onclick="deleteInfo('commentcheckbox','${pageContext.request.contextPath}/comment/deleteCommentList')">
                <span class="am-icon-trash-o"></span> 删除</button>
        </div>
        <%--分页按钮--%>
        <div id="laypage" style="float: right;"></div>
        <div style="clear: both"></div>

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
