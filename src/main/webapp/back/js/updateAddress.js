$(function () {

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