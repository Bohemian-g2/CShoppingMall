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