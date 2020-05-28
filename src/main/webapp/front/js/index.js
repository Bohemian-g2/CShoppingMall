$(function(){
    if(($("#init").val() == 1)){
        $.ajax({
            url : "frontCommodity/selectAll",
            type : "POST",
            async : "false",
            datatype:"html",
            success : function(html){
                $("html").html();
                $("html").html(html);
                $("#init").val($("#init").val() + 1);
            }
        })
    }
});

function selectByKind(url){
    $.ajax({
        url : url,
        type : "POST",
        async : "false",
        datatype:"html",
        success : function (html) {
            $("#hotlist").html();
            $("#hotlist").html(html);
        }
    });
}

//根据输入的值显示商品信息
function selectByDim(url){
    var selectCommodityDim = $("#selectCommodity").val();
    $.ajax({
        url : url,
        type : "POST",
        data : "CommodityDim="+selectCommodityDim,
        async : "false",
        datatype : "html",
        success : function(html){
            $("#hotlist").html();
            $("#hotlist").html(html);
        }
    });
}