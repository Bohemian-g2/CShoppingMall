/*评论页面载入函数*/
function loadComment(url){
    $.ajax({
        type:"GET",
        url:url,
        async:true,
        datatype:"html",
        contentType:"application/json;charset=utf-8",
        success:function(html){
            $("#commoditydetail").html(html);
        },
        error:function(){
            alert("出现错误"+url);
        }
    });
}