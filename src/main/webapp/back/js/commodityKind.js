/*
    商品类别 2020.04.23
    YSC
 */
//记录当前页，修改或删除可回到当前页
var cur_page;
//记录全部页
var total_page;
//记录当前页的数据数
var list_size;
/* ============================= 初始化界面 ================================ */
$(function(){
    //初始化页面
    to_page(1,null,"show");

    //刷新页面方法
    function to_page(pn,name,url){
        $("#commodity_list tbody").empty();
        $.ajax({
            url : "../kindBase/"+url,
            data : {
                "pn" : pn,
                "kind_name" : name
            },
            type : "POST",
            success : function (result) {
                console.log(result);
                //商品类别显示
                build_kind_information(result);
                //数据数量显示
                build_page_info(result,name,url);
            },
            error : function(){
                console.log("error");
            }
        });
    };

    //商品类别显示
    function build_kind_information(result) {
        $("#check_all").prop("checked",false);
        //遍历结果
        $.each(result.list,function (index,item) {
            var tr = $("<tr></tr>");
            var selector = $("<td><input type='checkbox' class='check_one'/></td>");
            var kind_id = $("<td></td>").addClass("am-text-center").append(item.kindId);
            var kind_name = $("<td></td>").addClass("am-text-center").append(item.kindName);
            //操作栏
            var update_btn = $("<button type='button' class='update_btn' title='修改'></button>").attr("update_id",item.kindId).
                addClass("am-btn am-btn-default am-btn-xs am-text-secondary am-round").append("<span></span>").addClass("am-icon-pencil-square-o");
            var delete_btn = $("<button type='button' class='delete_btn' title='删除'></button>").attr("delete_id",item.kindId).addClass("am-btn am-btn-default am-btn-xs am-text-danger am-round").
                append("<span></span>").addClass("am-icon-trash-o");
            var td_btn = $("<td></td>").append("<div class='am-btn-toolbar'></div>").append("<div class='am-btn-group am-btn-group-xs'></div>").
                append(update_btn).append(delete_btn);//全部显示
            tr.append(selector).append(kind_id).append(kind_name).append(td_btn).appendTo("#commodity_list tbody");
        });
    }

    //数据数量显示
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

    /* ======================== 初始化界面结束 ===================================*/
    /* ========================= 查询商品类别 ==================================== */
    $("#select_Kind_btn").click(function(){
        var kind_name = $("#kindSelect").val();
        to_page(1,kind_name,"selectKind");
    });
    /* ========================= 查询商品类别结束 ==================================== */
    /* ========================== 增添商品类别 ===================================== */
    $("#insert_kind_name").change(function(){
        validate("#insert_kind_name","#insert_info","#insert_kind_btn");
    });
    $("#insert_kind_btn").click(function(){
        if($("#insert_kind_btn").attr("checkResult") == "error"){
            return false;
        }
        $.ajax({
            url : "../kindBase/insertKind",
            data : $("#insert_kind_modal form").serialize(),
            type : "POST",
            success : function (result) {
                $("#insert_kind_modal").modal('close');
                to_page(total_page,null,"show");
            },
            error :function () {
                console.log("error");
            }
        });
    });
    /* ========================== 增添商品类别结束 ===================================== */
    /* =================== 修改商品类别 ==========================================*/
    //开启模态框+初始化修改商品类别
    $(document).on("click",".update_btn",function(){
        var upd_id = $(this).attr("update_id");
        $("#upd_kind_modal").modal();
        $("#upd_info").text("");
        $("#update_kind_btn").attr("upd_id",upd_id);
        $("#upd_kind_id").val(upd_id);
        $.ajax({
            url : "../kindBase/showKind",
            data : "upd_id="+upd_id,
            success : function (result) {
                console.log(result);
                $("#upd_kind_name").val(result.kindName);
            },
            error : function(){
              console.log("error");
            }
        });
    });
    //商品类别修改的合法性判断
    $("#upd_kind_name").change(function(){
        validate("#upd_kind_name","#upd_info","#update_kind_btn");
    });
    function validate(kindname,span,submit_btn){
        $(span).text("");
        var kind_name = $(kindname).val();
        var reg_kind_name = /(^[a-zA-Z0-9\u2E80-\u9FFF]{1,8}$)/;
        //前端简单校验是否为有效数据
        if(!reg_kind_name.test(kind_name)){
            $(span).text("输入合法类别名称");
            $(submit_btn).attr("checkResult","error");
            return false;
        }
        //查询数据库，防止重复
        $.ajax({
            url : "../kindBase/check_kind",
            data : "kind_name="+kind_name,
            success : function (result) {
                if(result == false){
                    $(span).text("该类别已存在");
                    $(submit_btn).attr("checkResult","error");
                    return false;
                }else{
                    $(submit_btn).removeAttr("checkResult","error");
                }
            },
            error : function () {
                console.log("error");
            }
        });
    }
    //商品类别确认更新
    $("#update_kind_btn").click(function(){
       alert($("#upd_kind_modal form").serialize());
       if($("#update_kind_btn").attr("checkResult") == "error"){
           return false;
       }
       $.ajax({
           url : "../kindBase/updateKind",
           data : $("#upd_kind_modal form").serialize(),
           type : "POST",
           success : function(result){
               alert(result);
               $("#upd_kind_modal").modal('close');
               //跳转回原来页
                to_page(cur_page,null,"show");
           },
           error : function(){
               console.log("error");
           }
       });
    });

    /* =================== 修改商品类别结束 ==========================================*/

    /* ======================删除商品类别 ============================================*/
    //单一删除  类别信息旁边的删除按钮
    $(document).on("click",".delete_btn",function(){
        if(confirm("确定删除"+$(this).parents("tr").find("td:eq(2)").text()+"?")) {
            $.ajax({
                url : "../kindBase/deleteKind",
                data : "delete_id="+$(this).attr("delete_id"),
                success : function (result) {
                    /**
                     * 如果数据是最后一页 会存在是该页最后一条数据的情况
                     * 直接跳回到本页面会超出总页数 所以需要跳回到最后一页
                     */
                    if(cur_page >= total_page){
                        to_page(total_page,null,"show");
                    }else{
                        total_page(cur_page,null,"show");
                    }
                },
                error : function(){
                    console.log("error");
                }
            });
        }else{
            return false;
        }
    });

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

    //批量删除
    $("#delete_Batch_Kind").click(function(){
        var deleteBatchId = "";
        //用 - 作为分隔符
        $.each($(".check_one:checked"),function(index,item){
            deleteBatchId += $(item).parents("tr").find("td:eq(1)").text()+"-";
        });
        //去除最后的 -
        var deleteBatchIds = deleteBatchId.substring(0,deleteBatchId.length-1);
        alert(deleteBatchIds);
        $.ajax({
            url : "../kindBase/deleteBatch",
            data : "deleteBatchIds="+deleteBatchIds,
            success : function (result) {
                alert(cur_page+"-----");
                alert(total_page+"******")
                if(cur_page >= total_page){
                    to_page(total_page,null,"show");
                }else{
                    total_page(cur_page,null,"show");
                }
            }
        });
    });
    /* ======================删除商品类别结束 ============================================*/

})
