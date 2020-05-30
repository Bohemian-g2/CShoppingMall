$(function () {
    var temp1;
    var temp2;
//省

    $.getJSON("../back/json/local_P.json",function(date){
        $.each(date,function (index,item) {
            var pOption = "<option id='"+item.id+"' value='"+item.nameP+"'>"+item.nameP+"</option>";
            $("#province").append(pOption);
        });
    });

//市
$("#province").change(function(){
    $("#city").attr("disabled",false);
    $("#city").children(":not(:first)").remove();
    $("#district").children(":not(:first)").remove();
    $.getJSON("../back/json/local_S.json",function(date){
        var pId = $("#province option:selected").attr("id");
       $.each(date,function (index,item) {
            if(item.p_id == pId){
                console.log(temp2);
                var sOption = "<option id='"+item.s_id+"' value='"+item.nameS+"'>"+item.nameS+"</option>";
                $("#city").append(sOption);
            }
        });
    });
});

//区
$("#city").change(function(){
    $("#district").attr("disabled",false);
    $("#district").children(":not(:first)").remove();
    $.getJSON("../back/json/local_Q.json",function(date){
        var sid = $("#city option:selected").attr("id");
        date.forEach(function(item){
            if(item.s_id == sid){
                var qOption = "<option value='"+item.nameq+"'>"+item.nameq+"</option>";
                $("#district").append(qOption);
            }
        });
    });
});

});

function showAddress(url) {

    $.ajax({
        url: url,
        type: "post",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (data) {
            var temp = eval(data);
            $("#addressMes").html("");
            for(var i=0;i<data.length;i++){
                $("#addressMes").append("<div>"+
                    +(i+1)+"."+
                    "The consignee:"+data[i]["addressName"]+
                    "  phone:"+data[i]["addressPhone"]+
                    "  area:"+data[i]["addressProvince"]+
                    data[i]["addressCity"]+
                    data[i]["addressDistrict"]+"  "+
                    "<div id='fin'>"+
                    "<a id='opt' href='/CShoppingMall/address/JumpAndSaveAddress?addressId="+data[i]['addressId']+"'>opt</a>"+
                "|"+"<a id='del' href='/CShoppingMall/address/DeleteAddress?addressId="+data[i]['addressId']+"'>del</a>"
                    +"</div>"
                    + "</div>"
                )
            }

        }
    });

}