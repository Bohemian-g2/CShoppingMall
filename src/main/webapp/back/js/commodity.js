
//当前页
var cur_page;
//最后一页
var total_page;
$(function(){

    to_page(1,null,"showAll");

    //刷新页面
    function to_page(pn,data,url){
        $.ajax({
            //url : "../commodity/showAll",
            url : "../commodity/"+url,
            data : {
                "pn":pn,
                "data":data
            },
            type : "POST",
            success : function (result) {
                console.log(result);
                //刷新商品信息
                build_commodity_information(result);
                //刷新页面 分页及相关信息
                build_page_info(result,name,url);
            }
        });
    }
    //刷新商品信息
    function build_commodity_information(result){
        $("#commodity_list tbody").empty();
        $("#check_all").prop("checked",false);
        $.each(result.list,function (index,item) {
            var tr = $("<tr></tr>");
            var selector = $("<td></td>").append("<input type='checkbox' class='check_one'/>");
            var id = $("<td></td>").append(item.commodityId);
            var name = $("<td></td>").append(item.commodityName);
            var commodity_kind = $("<td></td>").append(item.kindBase.kindName);
            var stock = $("<td></td>").append(item.commodityStock);
            var money = $("<td></td>").append(item.commodityMoney);
            var status = $("<td></td>").addClass("am-hide-sm-only").append(item.commodityStatus == 1?"<i class='am-icon-check am-text-warning'></i>":"<i class='am-icon-close am-text-primary'></i>");
            //三个按钮
            var detail_btn = $("<button type='button' class='commodity_detail_btn am-btn am-btn-default am-btn-xs am-text-success am-round' title='详情' ></button>").
            attr("com_id",item.commodityId).append("<span class='am-icon-search'></span>");
            var upd_btn = $("<button type='button' class='upd_btn am-btn am-btn-default am-btn-xs am-text-secondary am-round' title='修改'></button>").
            attr("com_id",item.commodityId).append("<span class='am-icon-pencil-square-o'></span>");
            var delete_btn = $("<button type='button' class='del_btn am-btn am-btn-default am-btn-xs am-text-danger am-round' title='删除'></button>").
            attr("com_id",item.commodityId).append("<span class='am-icon-trash-o'></span>");
            var btn = $("<td></td>").append("<div class='am-btn-toolbar'></div>").append("<div class='am-btn-group am-btn-group-xs'>").
            append(detail_btn).append(upd_btn).append(delete_btn);
            tr.append(selector).append(id).append(name).append(commodity_kind).append(stock).append(money).append(status).append(btn).appendTo("#commodity_list tbody");
        });
    }

    //刷新页面 分页及相关信息
    function build_page_info(result,name,url) {
        $("#page_info_area").empty();
        //显示总数量
        var page_info = $("<li></li>").append("总页数为"+result.pages+"页  共"+result.total+"条数据");
        //判断前页能否点击情况
        var pre_page = $("<li></li>").append($("<a></a>").attr("href","#").append("«"));
        if(result.hasPreviousPage == true){
            //前页的点击更新数据
            pre_page.click(function(){
                to_page(result.prePage,name,url);
            });
        }else{
            pre_page.addClass("am-disabled");
        }
        //判断后页能否点击情况
        var next_page = $("<li></li>").append($("<a></a>").attr("href","#").append("»"));
        if(result.hasNextPage == true){
            //后页的点击更新数据
            next_page.click(function(){
                to_page(result.nextPage,name,url);
            });
        }else{
            next_page.addClass("am-disabled");
        }
        var page_area = $("#page_info_area").append(page_info).append(pre_page);
        //获取到当前页
        cur_page = result.pageNum;
        //获取全部页
        total_page = result.pages;
        //获取当前页数据数
        list_size = result.size;
        //循环中间页
        $.each(result.navigatepageNums,function(index,item){
            var nav = $("<li></li>").append($("<a></a>").attr("href","#").append(item));
            if(item == cur_page){
                nav.addClass("am-active");
            }
            nav.click(function(){
                to_page(item,name,url);
            });
            page_area.append(nav);
        });
        page_area.append(next_page);
    }

    //显示具体数据
    $(document).on("click",".commodity_detail_btn",function(){
        $("#show_commodity").modal();
        $.ajax({
            url : "../commodity/selectOne",
            data : "selectId="+$(this).attr("com_id"),
            type : "POST",
            success : function(result){
                $("#commodity_name").text(result.commodityName);
                $("#commodity_picture").attr("src",result.commodityPicture);
                $("#commodity_sex").text(result.commoditySex == 1?"男士":"女士");
                $("#commodity_color").text(result.commodityColor);
                $("#commodity_size").text(result.commoditySize);
                $("#commodity_descript").text(result.commodityDescript);
                $("#commodity_style").text(result.commodityStyle);
                $("#commodity_source").text(result.commoditySource);
                //显示时间
                var data = new Date(result.commodityDate);
                //$("#commodity_date").text(data.getFullYear()+'/'+(data.getMonth()+1)+'/'+data.getDate()+' '+data.getHours()+':'+data.getMinutes());
                $("#commodity_date").text(data.getFullYear()+'/'+(data.getMonth()+1)+'/'+data.getDate());
            }
        });
    });

    //模糊查询
    $("#select_btn").click(function(){
        var name = $("#select_name").val();
        to_page(1,name,"selectCommodity");
    });
    /* ============================== 查询商品信息结束 =========================== */
    /* =============================== 增添商品信息 ============================== */
    $("#insert_commocity_btn").click(function(){
        $("#insert_commodity_modal").modal();//初始化商品类型
        $("#check_name").val("");
        $("#check_money").val("");
        $("#check_picture").val("");
        $("#check_stock").val("");
        $("#check_size").val("");
        $("#check_descript").val("");
        $("#check_color").val("");
        $("#check_style").val("");
        $("#check_source").val("");
        $("#check_date").val("");
        init_kindName("#insert_kind");
    });
    function init_kindName(id){
        $.ajax({
            url : "../kindBase/showKindName",
            success : function (result) {
                console.log(result);
                $.each(result,function(index,item){
                    var option = $("<option></option>").append(item.kindName).attr("value",item.kindId);
                    $(id).append(option);
                });
            }
        });
    }
    //选择日期
    $("#date_btn").datepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,//显示‘今日’按钮
        autoClose: false,
        todayHighlight: 1,
        startView: 2,
        minView: 2,  //Number, String. 默认值：0, 'hour'，日期时间选择器所能够提供的最精确的时间选择视图。
        forceParse: 0,
        endDate: new Date(), //不起作用 别看了
    }).on('changeDate.datepicker.amui',function(){
        var now = new Date();
        $("#insert_date").val($(this).data('date'));
    });
    /**
     *  增添页面的信息校验
     */
    $("#insert_name").change(function(){
        $("#check_name").empty();
        //前端简单校验
        var reg_name = /^[a-z0-9\u2E80-\u9FFF]{3,16}$/;
        var name = $(this).val();
        if(!reg_name.test(name)){
            $(this).val("");
            $("#check_name").text("名称格式有错");
            $(this).focus();
            return false;
        }
        //后台校验
        $.ajax({
            url : "../commodity/select_check_name",
            data : "check_name="+$(this).val(),
            type : "post",
            success : function(result){
                if(result == "error"){
                    $("#insert_name").val("");
                    $("#insert_name").attr("status","error");
                    $("#check_name").text("名称重复了 请重新输入");
                    $("#insert_name").focus();
                }
            }
        });
    });
    $("#insert_money").change(function(){
        $("#check_money").empty();
        var reg = /^([0-9]{1,5})|(([0-9]{1,5})\.[0-9]{1,2})$/
        var money = $(this).val();
        if(!reg.test(money)){
            $(this).val("");
            $("#check_money").text("格式错误 请输入数字(可含小数点)");
            $(this).focus();
            return false;
        }
    });
    $("#insert_stock").change(function(){
        $("#check_stock").empty();
        var reg = /^([0-9]{1,5})$/
        var stock = $(this).val();
        if(!reg.test(stock)){
            $(this).val("");
            $("#check_stock").text("格式错误 请输入整数");
            $(this).focus();
            return false;
        }
    });
    //尺寸 若选择尺码 可以添加数字 若是其他的 则禁止添加数字
    $("#size_select").change(function(){
        var select = $("#size_select").get(0).selectedIndex;
        if(select != 0){
            $("#insert_size").val($("#size_select option:selected").val());
            $("#insert_size").attr("readonly","readonly");
        }else{
            $("#insert_size").val();
            $("#insert_size").removeAttr("readonly");
        }
    });
    $("#insert_size").change(function(){
        $("#check_size").empty();
        var reg = /^([0-9]{1,2})$/;
        var size = $(this).val();
        if($(this).attr("readonly") != "readonly"){
            if(!reg.test(size)){
                $("#check_size").text("请输入一个整数");
                $(this).val("");
                $(this).focus();
                return false;
            }
        }
    });
    function change_status(id,span){
        $(span).empty();
        if($(id).val() == "" || $(id).val() == null){
            $(span).text("不允许为空");
            $(id).focus();
            return false;
        }
    };
    $("#insert_picture").change(function() {
        change_status("#insert_picture", "#check_picture");
    });
    $("#insert_color").change(function() {
        change_status("#insert_color", "#check_color");
    });
    $("#insert_style").change(function() {
        change_status("#insert_style", "#check_style");
    });
    $("#insert_source").change(function() {
        change_status("#insert_source", "#check_source");
    });
    $("#insert_descript").change(function() {
        change_status("#insert_descript", "#check_descript");
    });

    //向后台添加商品信息
    $("#insert_btn").click(function(){
        //提交前的判断
        change_status("#insert_name", "#check_name");
        change_status("#insert_picture", "#check_picture");
        change_status("#insert_money", "#check_money");
        change_status("#insert_stock", "#check_stock");
        change_status("#insert_size", "#check_size");
        change_status("#insert_color", "#check_color");
        change_status("#insert_style", "#check_style");
        change_status("#insert_source", "#check_source");
        change_status("#insert_descript", "#check_descript");
        change_status("#insert_date", "#check_date");
        if($("#insert_date").val() == "" || $("#insert_date").val() == null){
            $("#check_date").text("不允许为空");
            return false;
        }else{
            $("#check_date").empty();
        }
        //不可以使用serialize，只能序列化一般数据 不能提交文件
        //$("#insert_commodity_modal form").serialize();
        var formdata = new FormData();
        formdata.append("file",$("#insert_picture")[0].files[0]);
        $.ajax({
            url : "../commodity/insertPhoto",
            data : formdata,
            type : "POST",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success : function(result){
                insert_commodity(result);
            },
            error : function(){
                console.log("insert error");
            }
        });
    });
    function insert_commodity(filepath){
        var formdata = new FormData();
        var size = "";
        if($("#size_select").get(0).selectedIndex == 0){
            size = $("#insert_size").val()+"码";
        }else{
            size = $("#insert_size").val();
        }
        //添加到formdata
        formdata.append("commodityKind",$("#insert_kind option:selected").val())
        formdata.append("commodityName",$("#insert_name").val())
        formdata.append("commodityStatus",$("#insert_status option:selected").val())
        formdata.append("commodityMoney",$("#insert_money").val())
        formdata.append("commodityStock",$("#insert_stock").val())
        formdata.append("commoditySize",size)
        formdata.append("commoditySex",$("#insert_sex option:selected").val())
        formdata.append("commodityPicture",filepath)
        formdata.append("commodityDescript",$("#insert_descript").val())
        formdata.append("commodityColor",$("#insert_color").val())
        formdata.append("commodityStyle",$("#insert_style").val())
        formdata.append("commoditySource",$("#insert_source").val())
        formdata.append("commodityDate",$("#insert_date").val());
        $.ajax({
            url : "../commodity/insertCommodity",
            data : formdata,
            type : "POST",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success : function(result){
                alert(result);
                $("#insert_commodity_modal").modal('close');
                $("#insert_name").val("");
                $("#insert_money").val("");
                $("#insert_picture").val("");
                $("#insert_stock").val("");
                $("#insert_size").val("");
                $("#insert_descript").val("");
                $("#insert_color").val("");
                $("#insert_style").val("");
                $("#insert_source").val("");
                $("#insert_date").val("");
                to_page(total_page,null,"showAll");
            },
            error : function(){
                console.log("insert error");
            }
        });
    }
    /* =============================== 增添商品信息结束 ============================== */
    /* ============================ 修改商品信息 ======================= */
    //全选 全不选
    $("#check_all").click(function(){
        $(".check_one").prop("checked",$(this).prop("checked"));
    });

    $(document).on("click",".check_one",function(){
        var check_length = $(".check_one:checked").length;
        //全选了
        if(check_length == list_size){
            $("#check_all").prop("checked",true);
        }else{
            $("#check_all").prop("checked",false);
        }
    });

    //修改上架下架
    //上架
    $("#upd_status_true").click(function(){
        update_status(cur_page,"true","showAll");
    });
    //下架
    $("#upd_status_false").click(function(){
        update_status(cur_page,"false","showAll");
    });
    function update_status(cur_page,upd_status,url){
        var status = "";
        //判断选择框点击情况
        $.each($(".check_one:checked"),function (index,item) {
            status += $(item).parents("tr").find("td:eq(1)").text()+"-";
        });
        var commodity_status = status.substring(0,status.length-1);
        if(commodity_status != ""){
            $.ajax({
                url : "../commodity/updateStatus",
                data : {
                    "commodity_status":commodity_status,
                    "upd_status":upd_status
                },
                type : "POST",
                success :function (result) {
                    to_page(cur_page,null,url);
                },
                error : function () {
                    console.log("error");
                }
            });
        }else{
            return false;
        }
    }
    //触发修改商品模态框
    $(document).on("click",".upd_btn",function(){
        $("#update_commodity_modal").modal();
        $("#check_update_name").val("");
        $("#check_update_money").val("");
        $("#check_update_picture").val("");
        $("#check_update_stock").val("");
        $("#check_update_size").val("");
        $("#check_update_descript").val("");
        $("#check_update_color").val("");
        $("#check_update_style").val("");
        $("#check_update_source").val("");
        $("#check_update_date").val("");
        $("#update_btn").attr("upd_id",$(this).attr("com_id"));
        $.ajax({
            url : "../commodity/selectOne",
            data : "selectId="+$(this).attr("com_id"),
            type : "POST",
            success : function(result){
                $("#update_name").val(result.commodityName);
                $("#show_picture").attr("src",result.commodityPicture);
                //初始化类别
                init_kindName("#update_kind");
                $("#update_kind").val(result.commodityKind);
                $("#update_sex").val(result.commoditySex);
                $("#update_money").val(result.commodityMoney);
                $("#update_stock").val(result.commodityStock);
                $("#update_size").val(result.commoditySize);
                $("#update_size").attr("readonly","readonly");
                $("#update_color").val(result.commodityColor);
                $("#update_style").val(result.commodityStyle);
                $("#update_source").val(result.commoditySource);
                $("#update_descript").val(result.commodityDescript);
                var data = new Date(result.commodityDate);
                $("#update_date").val(data.getFullYear()+'/'+(data.getMonth()+1)+'/'+data.getDate());
            },
            error : function(){
                console.log("修改模态框打开失败");
            }
        });
    });
    //选择日期
    $("#update_date_btn").datepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,//显示‘今日’按钮
        autoClose: false,
        todayHighlight: 1,
        startView: 2,
        minView: 2,  //Number, String. 默认值：0, 'hour'，日期时间选择器所能够提供的最精确的时间选择视图。
        forceParse: 0,
        endDate: new Date(), //不起作用 别看了
    }).on('changeDate.datepicker.amui',function(){
        var now = new Date();
        $("#update_date").val($(this).data('date'));
    });
    /**
     *  修改页面的信息校验
     */
    $("#update_name").change(function(){
        $("#check_update_name").empty();
        //前端简单校验
        var reg_name = /^[a-z0-9\u2E80-\u9FFF]{3,16}$/;
        var name = $(this).val();
        if(!reg_name.test(name)){
            $(this).val("");
            $("#check_update_name").text("名称格式有错");
            $(this).focus();
            return false;
        }
        //后台校验
        $.ajax({
            url : "../commodity/select_check_name",
            data : "check_name="+$(this).val(),
            type : "post",
            success : function(result){
                if(result == "error"){
                    $("#update_name").val("");
                    $("#check_update_name").text("名称重复了 请重新输入");
                    $("#update_name").focus();
                }
            }
        });
    });
    $("#update_money").change(function(){
        $("#check_update_money").empty();
        var reg = /^([0-9]{1,5})|(([0-9]{1,5})\.[0-9]{1,2})$/
        var money = $(this).val();
        if(!reg.test(money)){
            $(this).val("");
            $("#check_update_money").text("格式错误 请输入数字(可含小数点)");
            $(this).focus();
            return false;
        }
    });
    $("#update_stock").change(function(){
        $("#check_update_stock").empty();
        var reg = /^([0-9]{1,5})$/
        var stock = $(this).val();
        if(!reg.test(stock)){
            $(this).val("");
            $("#check_update_stock").text("格式错误 请输入整数");
            $(this).focus();
            return false;
        }
    });
    //尺寸 若选择尺码 可以添加数字 若是其他的 则禁止添加数字
    $("#update_select").change(function(){
        var select = $("#update_select").get(0).selectedIndex;
        if(select != 0){
            $("#update_size").val($("#update_select option:selected").val());
            $("#update_size").attr("readonly","readonly");
        }else{
            $("#update_size").val();
            $("#update_size").removeAttr("readonly");
        }
    });
    $("#update_size").change(function(){
        $("#check_update_size").empty();
        var reg = /^([0-9]{1,2})$/;
        var size = $(this).val();
        if($(this).attr("readonly") != "readonly"){
            if(!reg.test(size)){
                $("#check_update_size").text("请输入一个整数");
                $(this).val("");
                $(this).focus();
                return false;
            }
        }
    });
    $("#update_picture").change(function() {
        change_status("#update_picture", "#check_update_picture");
    });
    $("#update_color").change(function() {
        change_status("#update_color", "#check_update_color");
    });
    $("#update_style").change(function() {
        change_status("#update_style", "#check_update_style");
    });
    $("#update_source").change(function() {
        change_status("#update_source", "#check_update_source");
    });
    $("#update_descript").change(function() {
        change_status("#update_descript", "#check_update_descript");
    });
    //向后台修改商品信息
    $("#update_btn").click(function(){
        //提交前的判断
        change_status("#update_name", "#check_update_name");
        change_status("#update_picture", "#check_update_picture");
        change_status("#update_money", "#check_update_money");
        change_status("#update_stock", "#check_update_stock");
        change_status("#update_size", "#check_update_size");
        change_status("#update_color", "#check_update_color");
        change_status("#update_style", "#check_update_style");
        change_status("#update_source", "#check_update_source");
        change_status("#update_descript", "#check_update_descript");
        change_status("#update_date", "#check_update_date");
        var formdata = new FormData();
        formdata.append("file",$("#update_picture")[0].files[0]);
        formdata.append("upd_id",$(this).attr("upd_id"));
        $.ajax({
            url : "../commodity/updatePhoto",
            data : formdata,
            type : "POST",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success : function(result){
                update_commodity(result);
            },
            error : function(){
                console.log("insert error");
            }
        });
    });
    function update_commodity(filepath){
        var formdata = new FormData();
        var size = "";
        if($("#update_select").get(0).selectedIndex == 0){
            size = $("#update_size").val()+"码";
        }else{
            size = $("#update_size").val();
        }
        //添加到formdata
        formdata.append("commodityId",$("#update_btn").attr("upd_id"));
        formdata.append("commodityKind",$("#update_kind option:selected").val())
        formdata.append("commodityName",$("#update_name").val())
        formdata.append("commodityMoney",$("#update_money").val())
        formdata.append("commodityStock",$("#update_stock").val())
        formdata.append("commoditySize",size)
        formdata.append("commoditySex",$("#update_sex option:selected").val())
        formdata.append("commodityPicture",filepath)
        formdata.append("commodityDescript",$("#update_descript").val())
        formdata.append("commodityColor",$("#update_color").val())
        formdata.append("commodityStyle",$("#update_style").val())
        formdata.append("commoditySource",$("#update_source").val())
        formdata.append("commodityDate",$("#update_date").val());
        $.ajax({
            url : "../commodity/updateCommodity",
            data : formdata,
            type : "POST",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success : function(result){
                $("#update_commodity_modal").modal('close');
                $("#update_picture").val("");
                $("#check_name").val("");
                $("#check_money").val("");
                $("#check_picture").val("");
                $("#check_stock").val("");
                $("#check_size").val("");
                $("#check_descript").val("");
                $("#check_color").val("");
                $("#check_style").val("");
                $("#check_source").val("");
                $("#check_date").val("");
                to_page(cur_page,null,"showAll");
            },
            error : function(){
                console.log("update error");
            }
        });
    }
    /* ============================ 修改商品信息结束 ======================= */

    /* ============================ 删除商品信息 =========================== */
    //单个删除
    $(document).on("click",".del_btn",function() {
        $.ajax({
            url: "../commodity/deleteCommodity",
            data: "deleteId=" + $(this).attr("com_id"),
            type: "POST",
            success: function (result) {
                to_page(cur_page, null, "showAll");
            },
            error: function () {
                console.log("error");
            }
        });
    });
    //批量删除
    $("#delete_Batch_btn").click(function(){
        var del_id = "";
        $.each($(".check_one:checked"),function (index,item) {
            del_id += $(item).parents("tr").find("td:eq(1)").text()+"-";
        });
        var del_ids = del_id.split(0,del_id.length-1);
        alert(del_ids);
        if(del_ids != ""){
            $.ajax({
                url : "../commodity/deleteBatchCommodity",
                data : "del_ids="+del_ids,
                type : "POST",
                success : function (result) {
                    to_page(cur_page,null,"showAll");
                },
                error : function () {
                    console.log("error");
                }
            });
        }else{
            return false;
        }
    });

});
/* ============================ 删除商品信息 =========================== */
