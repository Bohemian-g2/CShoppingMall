<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/23
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>我的购物车-服装商城</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/style.css">
    <%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
    <!-- 引入Bootstrap 样式-->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件,也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">
    var totalPage; // 保存总记录数
    var currentPage; // 保存当前页号
    <%--页面加载完成后，发起ajax请求，获取json数据--%>
    /**
     * 发送ajax请求，获取指定页数据
     * @param pageNum
     */
    $(function() {
        $.ajax({
            url:"${APP_PATH}/selectcart",
            type:"GET",
            data:"pn=1",
            // result是服务器返回结果(InfoDTO对象)
            success:function (result) {
                //控制台打印
                console.log(result);
                totalPage = result.dataMap.pageInfo.total;
                currentPage = result.dataMap.pageInfo.pageNum;
                // 1.解析并显示购物车信息
                build_carts_table(result);
                // 2.解析并显示分页信息
                build_page_info(result);
            }
        });
    });
    /**
     * 将获取的json数据解析并显示到购物车信息部分
     * @param result
     */
    function build_carts_table(result) {
    }
    /**
     * 将获取的json数据解析并显示到分页信息部分
     * @param result
     */
    function build_page_info(result) {
         // 清空上一页的显示数据
         $("#page_info_area").empty();
         var pageInfo = result.dataMap.pageInfo;
         var page_info = '当前第 <span class="label label-default">'+pageInfo.pageNum+'</span> 页，\
                             共 <span class="label label-default">'+pageInfo.pages+'</span> 页，\
                             共 <span class="label label-default">'+pageInfo.total+'</span> 条记录'
         $("#page_info_area").append(page_info);
         totalPage=result.dataMap.pageInfo.total;
         currentPage=result.dataMap.pageInfo.pageNum;
     }

    //单个删除,批量删除
    $(document).on("click",".delete_btn",function () {
        //1.弹出是否确认删除对话框
        var cart =  $(this).parents("div").find("td:eq(0)").text();
        var cartId=$(this).attr("del_ids");
        if(confirm("确认删除【"+cart+"】吗")){
            //确认发送AJAX请求删除即可
            $.ajax({
                url:"${APP_PATH}/deletecart/"+empId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == "200"){
                        alert(result.msg);
                        // 跳转到原位置
                        ajax_to_page(currentPage);
                    }
                }
            });
        }
    });
    /**
     * 为全选添加点击事件
     */
    $("#check_all").click(function () {
        $(".checkbox_single").prop("checked", $(this).prop("checked"));
    });
    /**
     * 为每一行的单选框绑定点击事件，当每一页的每一行都选中时，上面的全选框也要随着选中
     */
    $(document).on("click",".checkbox_single",function () {
        // 判断当前页选中的单选框是否等于当前页全部的单选框，若是，则全选框随之选中
        var flag = $(".checkbox_single:checked").length == $(".checkbox_single").length;
        $("#check_all").prop("checked", flag);

    });
     /**
     * 给批量删除按钮(顶部的删除按钮)添加点击事件
     */
    $("#cart_delete_all").click(function () {
        var names = "";
        var ids = "";
        // 遍历选中的记录
        $.each($(".checkbox_single:checked"),function (index,item) {
            names += $(this).parents("div").find("td:eq(2)").text()+",";
            ids += $(this).parents("div").find("td:eq(1)").text()+"-";
        });
        // 去除names最后一个逗号
        names = names.substring(0,names.length-1);
        // 去除ids最后一个-
        ids = ids.substring(0,ids.length-1);
        if(confirm("你确定要删除【"+names+"】吗？")){
            // 发送ajax请求批量删除
            $.ajax({
                url:"${APP_PATH}/deletecart/"+ids,
                type:"DELETE",
                success:function (result) {
                    if(result.code == "200"){
                        alert(result.msg);
                        ajax_to_page(currentPage);
                    }
                }
            });
        }
    });

    //修改购物车信息
    /**
     * 为修改提交按钮绑定单击事件
     */
   /* $("#cart_edit_submit").click(function () {
        $.ajax({
            url:"${APP_PATH}/updatecart/"+$(this).attr("edit-id"),
            type:"PUT",
            data:
    });*/

</script>

<!-- start banner_x -->
<div class="banner_x center">
    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="clear"></div>
</div>

<div class="xiantiao"></div>
<div class="gwcxqbj">
    <div class="gwcxd center">
            <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr class="am-success">
                    <th class="table-check"><input type="checkbox" id="quanxuan" />全选</th>
                    <th class="table-id">商品信息</th>
                    <th class="table-title">单价</th>
                    <th class="table-title">数量</th>
                    <th class="table-author am-hide-sm-only">金额</th>
                    <th width="130px" class="table-set">操作</th>
                </tr>
                </thead>
                <tbody  id="adminInfoPage">
                </tbody>
            </table>
            <tbody>

            </tbody>
           <%-- <c:forEach var="c" items="${collect}">--%>

               <%-- <div class="sub_content1 fl">
                       <a href="${ pageContext.request.contextPath }/delProFromCart.action?pid=${c.cartId}"
                                               class="delete" onclick="return checkDel();">删除</a>
                       <a href="${ pageContext.request.contextPath }/delProFromCart.action?pid=${c.cartId}"
                               class="delete" onclick="return checkDel();">移入收藏夹</a>
                       <a href="similarcommodity">相似商品</a>
                </div>--%>
           <%-- </c:forEach>--%>
    </div>
    <div class="jiesuandan mt20 center">
        <div class="tishi fl ml20">
            <ul>
                <li><a href="${ pageContext.request.contextPath }/clearCart.action"
                       id="check" class="clear">全选</a></li>
                <li><a href="${ pageContext.request.contextPath }/delProFromCart.action?pid=${c.cartId}"
                       class="delete" id="cart_delete_all">删除</a><br></li>
                <li><a href="${ pageContext.request.contextPath }/delProFromCart.action?pid=${c.cartId}"
                       class="delete" onclick="return checkDel();">移入收藏夹</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="jiesuan fr">
           <div class="jiesuanjiage fl">已选商品： 件 &nbsp;&nbsp; 合计（不含运费）：</div>
            <div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>

</div>
</body>
</html>
