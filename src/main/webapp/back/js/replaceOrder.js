//当前页
var cur_page;
//最后一页
var total_page;
$(function(){
    to_page(1,2,"showAll");

    //刷新页面
    function to_page(pn,data,url){
        $.ajax({
            //url : "../commodity/showAll",
            url : "../indent/"+url,
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
                build_page_info(result,2,url);
            }
        });
    }
    //刷新商品信息
    function build_commodity_information(result){
        $("#replace_list tbody").empty();
        $.each(result.list,function (index,item) {
            var tr = $("<tr></tr>");
            var selector = $("<td></td>").append("<input type='checkbox' class='check_one'/>");
            var id = $("<td></td>").append(item.indentId);
            var name = $("<td></td>").append(item.userInf.loginName);
            var address = $("<td></td>").append(item.address.addressCity);
            var rec_name = $("<td></td>").append(item.address.addressName);
            var date = new Date(item.indentCreateTime);
            var createTime = $("<td></td>").append(date.getFullYear()+'/'+(date.getMonth()+1)+'/'+date.getDate());
            var way = $("<td></td>").append(item.indentTotal == 0?"支付宝":"微信");
            var draw = new Date(item.indentDrawbackTime);
            var DrawbackTime = $("<td></td>").append(draw.getFullYear()+'/'+(draw.getMonth()+1)+'/'+draw.getDate());
            var total = $("<td></td>").append(item.indentTotal);
            var carriage = $("<td></td>").append(item.indentCarriage);
            //两个按钮
            var detail_btn = $("<button type='button' class='indent_detail_btn am-btn am-btn-default am-btn-xs am-text-success am-round' title='订单详情'></button>").
            attr("com_id",item.indentId).append("<span class='am-icon-search'></span>");
            var btn = $("<td></td>").append("<div class='am-btn-toolbar'></div>").append("<div class='am-btn-group am-btn-group-xs'>").
            append(detail_btn);
            tr.append(selector).append(id).append(name).append(address).append(rec_name).append(createTime).append(way).append(DrawbackTime).append(total).append(carriage).append(btn).appendTo("#replace_list tbody");
        });
    }

    //刷新页面 分页及相关信息
    function build_page_info(result,status,url) {
        $("#page_info_area").empty();
        //显示总数量
        var page_info = $("<li></li>").append("总页数为"+result.pages+"页  共"+result.total+"条数据");
        //判断前页能否点击情况
        var pre_page = $("<li></li>").append($("<a></a>").attr("href","#").append("«"));
        if(result.hasPreviousPage == true){
            //前页的点击更新数据
            pre_page.click(function(){
                to_page(result.prePage,status,url);
            });
        }else{
            pre_page.addClass("am-disabled");
        }
        //判断后页能否点击情况
        var next_page = $("<li></li>").append($("<a></a>").attr("href","#").append("»"));
        if(result.hasNextPage == true){
            //后页的点击更新数据
            next_page.click(function(){
                to_page(result.nextPage,status,url);
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
                to_page(item,status,url);
            });
            page_area.append(nav);
        });
        page_area.append(next_page);
    }
    //显示订单内商品详情
    $(document).on('click',"#indent_detail_btn",function(){
        $("#replace_detail_modal").modal();
        $.ajax({
            url : "../indentDetail/showById",
            data : "indentId="+$(this).attr("com_id"),
            type : "POST",
            success : function(result){
                console.log(result);
                init_indent_detail_table(result);
            }
        });
    });
    function init_indent_detail_table(result){
        $.each(result,function(index,item){
            var tr = $("<tr></tr>");
            var commodityName = $("<td></td>").append(item.commodity.commodityName);
            var commoditySex = $("<td></td>").append(item.commodity.commoditySex == 0?"男士":"女士");
            var commodityColor = $("<td></td>").append(item.commodity.commodityColor);
            var commoditySize = $("<td></td>").append(item.commodity.commoditySize);
            var commodityDescript = $("<td></td>").append(item.commodity.commodityDescript);
            var commodityStyle = $("<td></td>").append(item.commodity.commodityStyle);
            var indentGoodsNum = $("<td></td>").append(item.indentGoodsNum);
            tr.append(commodityName).append(commoditySex).append(commodityColor).append(commoditySize)
                .append(commodityDescript).append(commodityStyle).append(indentGoodsNum).appendTo($("#detail_table tbody"));
        });
    }

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
    //换货
    $("#upd_status").click(function(){
        update_status(cur_page,1,"showAll");
    });
    function update_status(cur_page,upd_status,url){
        var status = "";
        //判断选择框点击情况
        $.each($(".check_one:checked"),function (index,item) {
            status += $(item).parents("tr").find("td:eq(1)").text()+"-";
        });
        var upd_ids = status.substring(0,status.length-1);
        if(upd_ids != "") {
            $.ajax({
                url: "../indent/updateStatus",
                data: {
                    "upd_ids": upd_ids,
                    "upd_status": upd_status
                },
                type: "POST",
                success: function (result) {
                    to_page(cur_page, 2, url);
                },
                error: function () {
                    console.log("error");
                }
            });
        }else{
            return false;
        }
    }
});
