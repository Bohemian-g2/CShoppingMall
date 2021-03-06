/*评论页面载入函数*/
function loadComment(commodityId){
    $.ajax({
        type: "post",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            commodityId:commodityId,
        }),
        async: false,
        url: "/CShoppingMall/FrontComment/getCommentByCdtId",
        success: function (ret) {
            var data=eval(ret);
            loadCommentInfo(data);
        },
        error:function(){
            alert("数据获取出现错误");
        }
    });
}
function loadCommentInfo(data) {
    var html='';
    for(var i=0;i<data.length;i++){
        html+="<div class=\"user_remark\">" +
              "  <div class=\"user_remark_info\">" +
              "      <img class=\"circleImg\" src='/CShoppingMall/usertitle/"+data[i]['userTitle']+"'/><br/>" +
              "  </div>\n" +
              "  <div class=\"user_remark_content\">" +
              "     <span class=\"user_name\">"+data[i]["userName"]+"</span>" +
              "     &nbsp; &nbsp;<span class=\"content_time\">"+changeDateFormat(data[i]["commentTime"])+"</span><br/>" +
              "     <span class=\"remark_content\">"+data[i]["content"]+"</span>" +
              "  </div>" +
              "</div>"
    }
    $("#commoditydetail").empty().append(html);
}
function changeDateFormat(val) {
    if (val != null) {
        var date = new Date(parseInt(val, 10));
        //月份为0-11所以+1，月份小于10补个0
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        var dd = date.getFullYear() + "-" + month + "-" + currentDate + " " + hour + ":" + minute + ":" + second;
        return dd;
    }
}

/**
 * 商品详情页 添加商品至购物车
 * @param url
 */
function insertCart(url){
    $.ajax({
        url : url,
        type : "POST",
        data : "commodityId="+$("#insertCart").attr("commodityId"),
        success : function(result){
            if(result == "stock"){
                layer.alert('库存不够了 无法购买', {
                    skin: 'layui-layer-cheng'
                    ,closeBtn: 0
                    ,anim: 4 //动画类型
                });
                return false;
            }
            console.log(result);
            layer.alert('已添加入购物车', {
                skin: 'layui-layer-cheng'
                ,closeBtn: 0
                ,anim: 4 //动画类型
            });
        },
        error : function (result) {
            // 解决Ajax异步请求 springMvc 不跳转页面的问题
            $.ajaxSetup({
                //设置ajax请求结束后的执行动作
                complete:
                    function (XMLHttpRequest, textStatus) {
                        // 通过XMLHttpRequest取得响应头，sessionstatus
                        var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
                        if (sessionstatus == "TIMEOUT") {
                            var win = window;
                            while (win != win.top) {
                                win = win.top;
                            }
                            win.location.href = XMLHttpRequest.getResponseHeader("CONTEXTPATH");
                        }
                    }
            });
        }
    });

}

function insertCartCurrent(url){
    $.ajax({
        url : url,
        type : "POST",
        data : "commodityId="+$("#insertCart").attr("commodityId"),
        success : function(result){
            if(result == "stock"){
                layer.alert('库存不够了 无法购买', {
                    skin: 'layui-layer-lan'
                    ,closeBtn: 0
                    ,anim: 4 //动画类型
                });
                return false;
            }
            layer.alert('已添加入购物车', {
                skin: 'layui-layer-lan'
                ,closeBtn: 0
                ,anim: 4 //动画类型
            });
        },
    });
}

function loadCommodityDetile(commodityId){
    $.ajax({
        url : "../frontCommodity/selectOneJson",
        data : "commodityId="+commodityId,
        type : "POST",
        success : function(result){
            console.log(result);
            data="<font class=\"left_title\">尺码：</font><font class=\"right_info\">"+result.commoditySize+"</font><br/>" +
                "<font class=\"left_title\">颜色：</font>  <font class=\"right_info\">"+result.commodityColor+"</font><br/>" +
                "<font class=\"left_title\">风格：</font>  <font class=\"right_info\">"+result.commodityStyle+"</font><br/>" +
                "<font class=\"left_title\">出产商：</font><font class=\"right_info\">"+result.commoditySource+"</font> <br/>" +
                "<font class=\"left_title\">商品详情：</font><font class=\"right_info\"> "+result.commodityDescript+"</font><br/>"
            $("#commoditydetail").empty().append(data);
        }
    });
}