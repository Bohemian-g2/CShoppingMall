//全选
function check_all(object){
    $(".check_one").prop("checked",$("#check_all").prop("checked"));
    changeTotal();
}

//单个选择
function check_one(obj){
    var check_length = $(".check_one:checked").length;
    changeTotal();
    //全选了
    if(check_length == $("#CDTotal").text()){
        $("#check_all").prop("checked",true);
    }else{
        $("#check_all").prop("checked",false);
    }
}

//点复选框 修改已选商品件数和总金额
function changeTotal(){
    var total_number = 0;
    var total_money = 0;
    $.each($(".check_one:checked"),function (index,item) {
        total_money += parseInt($(item).parents("tr").find("td:eq(4)").text());
        total_number ++;
    });
    $("#total_money").text(total_money);
    $("#total_number").text(total_number);
}

//减少一个商品
function reduce(obj){
    var number = parseInt($(obj).parents("td").find("span").text());
    if(number == 1){
        alert("必须购买一个商品呦~");
        return false;
    }
    //减少一个商品
    opera(obj,0);
}

//增加一个商品
function add(obj){
    var number = parseInt($(obj).parents("td").find("span").text());
    if(number >= 99){
        alert("差不多了,兄弟 99个够了~");
        return false;
    }
    //减少一个商品
    opera(obj,1);
}

function opera(obj,opera){
    $.ajax({
        url : "../Cart/updateCDetailMoney",
        data : {
            "cartId":$(obj).parents("tr").find("td:eq(0)").find("input").attr("cartId"),
            "commodityId":$(obj).parents("tr").find("td:eq(0)").find("input").attr("commodityId"),
            "opera":opera
        },
        type : "POST",
        success : function (result) {
            console.log(result);
            if(result == null || result == ""){
                alert("已达到最大库存");
                return false;
            }
            $(obj).parents("tr").find("td:eq(3)").find("span").text(result.cartCommodityNumbe);
            $(obj).parents("tr").find("td:eq(4)").text(result.cartCommodityMoney);
            changeTotal();
        }
    });
}

//删除单个数据
function del_one(obj){
    var commodityIds = $(obj).parents("tr").find("td:eq(0)").find("input").attr("commodityId");
    var cartId = $(obj).parents("tr").find("td:eq(0)").find("input").attr("cartId");
    deleteFunction(commodityIds,cartId);
    $(obj).parents("tr").empty();
    changeTotal();
}

//批量删除数据
function del_batch(){
    var commodityId = "";
    var cartId = "";
    $.each($(".check_one:checked"),function (index,item) {
        commodityId += $(item).parents("tr").find("td:eq(0)").find("input").attr("commodityId") + "-";
        cartId = $(item).parents("tr").find("td:eq(0)").find("input").attr("cartId");
    });
    if(commodityId == "" || commodityId == null){
        return false;
    }
    deleteFunction(commodityId,cartId);
    //页面删除dom元素
    $.each($(".check_one:checked"),function (index,item) {
        $(item).parents("tr").empty();
    });
    changeTotal();
}

function deleteFunction(commodityIds,cartId){
    $.ajax({
        url : "../Cart/deleteBatch",
        data : {
            "commodityIds":commodityIds,
            "cartId":cartId
        },
        type : "POST",
        success : function (result) {
        }
    });
}