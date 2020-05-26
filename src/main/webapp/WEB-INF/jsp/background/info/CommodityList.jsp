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
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>商品列表</title>


</head>
<body>
<!-- 新页面 -->
<!-- 显示商品具体信息模态框 -->
<div class="am-popup am-popup-inner" id="show_commodity" style="height: 800px;">
    <div class="am-popup-hd">
        <h4 class="am-popup-title">商品信息</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <tr class="am-popup-bd">
        <form class="am-form tjlanmu" style="width: 90%;margin: auto">
            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <tr>
                    <td>商品名称:</td>
                    <td><p id="commodity_name"></p></td>
                </tr>
                <tr>
                    <td>商品图片:</td>
                    <td><img height="100" width="100" class="am-circle" id="commodity_picture"/></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td><p id="commodity_sex"></p></td>
                <tr>
                <tr>
                    <td>颜色款式:</td>
                    <td><p id="commodity_color"></p></td>
                </tr>
                <tr>
                    <td>尺寸大小:</td>
                    <td><p id="commodity_size"></p></td>
                </tr>
                <tr>
                    <td>详情:</td>
                    <td><p id="commodity_descript"></p></td>
                </tr>
                <tr>
                    <td>风格:</td>
                    <td><p id="commodity_style"></p></td>
                </tr>
                <tr>
                    <td>商品来源:</td>
                    <td><p id="commodity_source"></p></td>
                </tr>
                <tr>
                    <td>进货时间:</td>
                    <td><p id="commodity_date"></p></td>
                </tr>
            </table>
        </form>
</div>
</div>
<!-- 显示商品具体信息模态框结束 -->
<!-- 增添商品信息 -->
<div class="am-popup am-popup-inner" id="insert_commodity_modal" style="height: 4000px; overflow-y:auto;" >
    <div class="am-popup-hd">
        <h4 class="am-popup-title">增添商品信息</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <form class="am-form tjlanmu" style="width: 90%;margin: auto" method="post" enctype="multipart/form-data">
        <table class="am-table am-table-bordered am-table-radius am-table-striped">
            <tr>
                <td>名称:</td>
                <td>
                    <input type="text" name="commodityName" id="insert_name" placeholder="商品名称">
                    <span id="check_name" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>图片:</td>
                <td>
                    <div class="am-form-group am-form-file">
                        <div class="am-u-sm-3" style="float:left;border: 1px dashed #dcc8b1; text-align:center; margin:20px 0px;line-height: 20px; width: 120px">
                            <div class="am-form-group am-form-file">
                                <i class="am-icon-camera-retro am-icon-sm am-icon-btn" style="color: #d7b075;background-color: #fff;"></i><br>
                                <span style="color:#d7b075">请添加照片</span>
                                <input type="file" name="file" id="insert_picture" style="height: 100px"/>
                            </div>
                        </div>
                        <!--<div class="am-u-sm-3" style="float:left;padding:10px 10px;">
                            <img id="show_img" src="C:\Users\situa\Desktop\sc02\IMG_0688.JPG" style="height:100px; width:100px;" class="am-circle">
                        </div> src="\photoUpLoad\IMG_0683.JPG"-->
                    </div>
                    <span id="check_picture" style="color: orangered;font-size: 15px;float:left;"></span>
                </td>
            </tr>
            <tr>
                <td>类别:</td>
                <td><select id="insert_kind" name="commodityKind" style="width: 250px;" data-am-selected="{btnWidth: '40%', btnSize: 'sm', btnStyle: 'secondary'}"></select></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <select id="insert_sex" name="commoditySex" style="width: 250px;" data-am-selected="{btnWidth: '40%', btnSize: 'sm', btnStyle: 'secondary'}">
                        <option value="1">男士</option>
                        <option value="2">女士</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>是否上架:</td>
                <td>
                    <select id="insert_status" name="commodityStatus" style="width: 250px;" data-am-selected="{btnWidth: '40%', btnSize: 'sm', btnStyle: 'secondary'}">
                        <option value="1">上架</option>
                        <option value="2">下架</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>单价</td>
                <td>
                    <input type="text" name="commodityMoney" id="insert_money" placeholder="商品单价">
                    <span id="check_money" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>数量</td>
                <td>
                    <input type="text" name="commodityStock" id="insert_stock" placeholder="商品数量">
                    <span id="check_stock" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>尺寸:</td>
                <td>
                    <input type="text" name="commoditySize" id="insert_size" style="width: 300px; float: left;" placeholder="商品尺寸 确定尺码">
                    <select id="size_select" style="width: 80px; float: right;" data-am-selected="{btnWidth: '40%', btnSize: 'sm', btnStyle: 'secondary'}">
                        <option value="尺码" selected>尺码</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                        <option value="XXL">XXL</option>
                        <option value="XXXL">XXXL</option>
                        <option value="4XL">4XL</option>
                        <option value="5XL">5XL</option>
                    </select>
                    <span id="check_size" style="color: orangered;font-size: 15px;float: left;"></span>
                </td>

            </tr>
            <tr>
                <td>颜色款式:</td>
                <td>
                    <input type="text" name="commodityColor" id="insert_color" placeholder="颜色款式">
                    <span id="check_color" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>

            <tr>
                <td>风格:</td>
                <td>
                    <input type="text" name="commodityStyle" id="insert_style" placeholder="风格">
                    <span id="check_style" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>商品来源:</td>
                <td>
                    <input type="text" name="commoditySource" id="insert_source" placeholder="商品来源地">
                    <span id="check_source" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>详情:</td>
                <td>
                    <textarea id="insert_descript" name="commodityDescript" cols="2" rows="2" placeholder="输入商品详情"></textarea>
                    <span id="check_descript" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>进货时间:</td>
                <td>
                    <div class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'dd-mm-yyyy'}">
                        <input type="text" id="insert_date" name="commodityDate" class="am-form-field" placeholder="进货时间" readonly>
                        <span class="am-input-group-btn am-datepicker-add-on">
                                <button id="date_btn" class="am-btn am-btn-default" type="button"><span class="am-icon-calendar"></span> </button>
                            </span>
                    </div>
                    <span id="check_date" style="color: orangered;font-size: 15px;"></span>
                    <%--<div class="am-input-group am-datepicker-date date"  data-am-datepicker="{format: 'yyyy-mm-dd'}">
                        <input id="date" name="entity.date" type="text" class="am-form-field" style="background-color:#fff;" readonly>
                        <span class="am-input-group-label" id="form_dateClear" style="background-color:#fff;"><i class="am-icon-close"></i></span>
                        <span class="am-input-group-label am-datepicker-add-on" style="background-color:#fff;"><i class="am-icon-calendar"></i></span>
                    </div>--%>
                </td>
            </tr>
        </table>
        <button type="button" class="am-btn am-btn-default" id="insert_btn"><span class="am-icon-plus"></span> 确认增添</button>
    </form>
</div>
</div>
<!-- 增添商品信息结束 -->
<!-- 修改商品信息 -->
<div class="am-popup am-popup-inner" id="update_commodity_modal" style="height: 4000px; overflow-y:auto;" >
    <div class="am-popup-hd">
        <h4 class="am-popup-title">修改商品信息</h4>
        <span data-am-modal-close  class="am-close">&times;</span>
    </div>
    <form class="am-form tjlanmu" style="width: 90%;margin: auto" method="post" enctype="multipart/form-data">
        <table class="am-table am-table-bordered am-table-radius am-table-striped">
            <tr>
                <td>名称:</td>
                <td>
                    <input type="text" name="commodityName" id="update_name" placeholder="商品名称">
                    <span id="check_update_name" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>图片:</td>
                <td>
                    <div class="am-form-group am-form-file">
                        <img height="100" width="100" class="am-circle" id="show_picture" style="float: left;"/>
                        <div class="am-u-sm-3" style="float:left;border: 1px dashed #dcc8b1; text-align:center; margin:20px 0px;line-height: 20px; width: 120px">
                            <div class="am-form-group am-form-file">
                                <i class="am-icon-camera-retro am-icon-sm am-icon-btn" style="color: #d7b075;background-color: #fff;"></i><br>
                                <span style="color:#d7b075">请添加照片</span>
                                <input type="file" name="file" id="update_picture" style="height: 100px"/>
                            </div>
                        </div>
                        <!--<div class="am-u-sm-3" style="float:left;padding:10px 10px;">
                            <img id="show_img" src="C:\Users\situa\Desktop\sc02\IMG_0688.JPG" style="height:100px; width:100px;" class="am-circle">
                        </div> src="\photoUpLoad\IMG_0683.JPG"-->
                    </div>
                    <span id="check_update_picture" style="color: orangered;font-size: 15px;float:left;"></span>
                </td>
            </tr>
            <tr>
                <td>类别:</td>
                <td><select id="update_kind" name="commodityKind" style="width: 250px;" data-am-selected="{btnWidth: '40%', btnSize: 'sm', btnStyle: 'secondary'}"></select></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <select id="update_sex" name="commoditySex" style="width: 250px;" data-am-selected="{btnWidth: '40%', btnSize: 'sm', btnStyle: 'secondary'}">
                        <option value="1">男士</option>
                        <option value="2">女士</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>单价</td>
                <td>
                    <input type="text" name="commodityMoney" id="update_money" placeholder="商品单价">
                    <span id="check_update_money" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>数量</td>
                <td>
                    <input type="text" name="commodityStock" id="update_stock" placeholder="商品数量">
                    <span id="check_update_stock" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>尺寸:</td>
                <td>
                    <input type="text" name="commoditySize" id="update_size" style="width: 300px; float: left;" placeholder="商品尺寸 确定尺码">
                    <select id="update_select" style="width: 80px; float: right;" data-am-selected="{btnWidth: '40%', btnSize: 'sm', btnStyle: 'secondary'}">
                        <option value="尺码" selected>尺码</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                        <option value="XXL">XXL</option>
                        <option value="XXXL">XXXL</option>
                        <option value="4XL">4XL</option>
                        <option value="5XL">5XL</option>
                    </select>
                    <span id="check_update_size" style="color: orangered;font-size: 15px;float: left;"></span>
                </td>

            </tr>
            <tr>
                <td>颜色款式:</td>
                <td>
                    <input type="text" name="commodityColor" id="update_color" placeholder="颜色款式">
                    <span id="check_update_color" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>

            <tr>
                <td>风格:</td>
                <td>
                    <input type="text" name="commodityStyle" id="update_style" placeholder="风格">
                    <span id="check_update_style" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>商品来源:</td>
                <td>
                    <input type="text" name="commoditySource" id="update_source" placeholder="商品来源地">
                    <span id="check_update_source" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>详情:</td>
                <td>
                    <textarea id="update_descript" name="commodityDescript" cols="2" rows="2" placeholder="输入商品详情"></textarea>
                    <span id="check_update_descript" style="color: orangered;font-size: 15px;"></span>
                </td>
            </tr>
            <tr>
                <td>进货时间:</td>
                <td>
                    <div class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'dd-mm-yyyy'}">
                        <input type="text" id="update_date" name="commodityDate" class="am-form-field" placeholder="进货时间" readonly>
                        <span class="am-input-group-btn am-datepicker-add-on">
                                <button id="update_date_btn" class="am-btn am-btn-default" type="button"><span class="am-icon-calendar"></span> </button>
                            </span>
                    </div>
                    <span id="check_date" style="color: orangered;font-size: 15px;"></span>
                    <%--<div class="am-input-group am-datepicker-date date"  data-am-datepicker="{format: 'yyyy-mm-dd'}">
                        <input id="date" name="entity.date" type="text" class="am-form-field" style="background-color:#fff;" readonly>
                        <span class="am-input-group-label" id="form_dateClear" style="background-color:#fff;"><i class="am-icon-close"></i></span>
                        <span class="am-input-group-label am-datepicker-add-on" style="background-color:#fff;"><i class="am-icon-calendar"></i></span>
                    </div>--%>
                </td>
            </tr>
        </table>
        <button type="button" class="am-btn am-btn-default" id="update_btn"><span class="am-icon-plus"></span> 确认修改</button>
    </form>
</div>
</div>
<!-- 修改商品信息结束 -->
<!-- 商品分类列表页面 -->
<div class="admin-biaogelist">
    <!-- 新页面内部导航栏 -->
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on"> 栏目名称</ul>
        <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">商品列表</a></dl>
        <dl>
            <button type="button" id="insert_commocity_btn" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"> 添加产品</button>
        </dl>
    </div>

    <!-- 商品列表 -->
    <div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
        <ul>
            <li><input type="text" class="am-form-field am-input-sm am-input-xm" placeholder="关键词搜索" id="select_name"/></li>
            <li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;" id="select_btn">搜索</button></li>
        </ul>
    </div>


    <form class="am-form am-g" id="commodity_list">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
            <tr class="am-success">
                <th class="table-check"><input type="checkbox" id="check_all"/></th>
                <th class="table-id">ID</th>
                <th class="table-title">名称</th>
                <th class="table-type">类别</th>
                <th class="table-stock">库存</th>
                <th class="table-money">单价</th>
                <th class="table-author am-hide-sm-only">上架/下架 <i class="am-icon-check am-text-warning"></i> <i class="am-icon-close am-text-primary"></i></th>
                <th width="163px" class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>
            <%--<tr>
                <td><input type="checkbox" /></td>
                <td>14</td>
                <td><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only"><i class="am-icon-check am-text-warning"></i></td>
                <!-- 操作栏 -->
                <td><div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <button class="am-btn am-btn-default am-btn-xs am-text-success am-round" title="详情"><span class="am-icon-search"  ></span> </button>
                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改"><span class="am-icon-pencil-square-o" ></span></button>
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span class="am-icon-trash-o" title=></span></button>
                    </div>
                </div></td>
            </tr>--%>
            </tbody>
        </table>
        <!-- 新页面底部 -->
        <div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default" id="upd_status_true"><span class="am-icon-plus"></span> 上架</button>
            <button type="button" class="am-btn am-btn-default" id="upd_status_false"><span class="am-icon-minus"></span> 下架</button>
            <button type="button" class="am-btn am-btn-default" id="delete_Batch_btn"><span class="am-icon-trash-o"></span> 删除</button>
        </div>
        <!-- 分页标签 -->
        <ul class="am-pagination am-fr" id="page_info_area"><%--
            <li class="am-disabled"><a href="#">«</a></li>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/commodity.js"></script>
</body>
</html>
