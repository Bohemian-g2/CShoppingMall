$(document).ready(function(){

    $('#myModal').on('hidden.bs.modal', function (){
        window.location.reload();
    });

    $("#mymodalfooter").on("click","#payButton",function(){
        var myid=$('#myindentid').html();      //取对应的订单id
        var addressId=$("input[name='r1']:checked").val();
        var payway=$("input[name='r2']:checked").val();
        var myurl="frontPayIndent?id="+myid+"&addressId="+addressId+"&payway="+payway;
        $.ajax({
            url : myurl,
            type : "POST",
            data: {                },
            success : function(data) {
                alert(data.paymessage);
                $('#myModal').modal('hide');
                location.href ="frontShowIndent";
            },error:function(XMLHttpRequest, textStatus, errorThrown){
                alert("支付失败,请选择收货人信息与支付方式");
            }
        });
    });

    $('#mymodalfooter').on("click",'#sureButton',function(){
        var myid=$('#myindentid').html();      //取对应的订单id
        var myurl="frontSureIndent?id="+myid;
        $.ajax({
            url : myurl,
            type : "POST",
            data: {                },
            success : function() {
                alert("确认收货成功！");
                $('#myModal').modal('hide');
                window.location.reload();
            }
        });
    });

    $('#mymodalfooter').on("click",'#deleteButton',function(){
        var myid=$('#myindentid').html();      //取对应的订单id
        var myurl="frontDeleteIndent?id="+myid;
        $.ajax({
            url :myurl,
            type : "POST",
            data : { },
            success : function() {
                alert("删除成功！");
                $('#myModal').modal('hide');
                location.href ="frontShowIndent";
            }
        });
    });

    $('#mymodalfooter').on("click",'#changeButton',function(){
        var myid=$('#myindentid').html();       //取对应的订单id
        var myurl="frontChangeIndent?id="+myid;
        $.ajax({
            url : myurl,
            type : "POST",
            data : { },
            success : function() {
                alert("换货成功！");
                $('#myModal').modal('hide');
                window.location.reload();
            }
        });
    });


});

function find_address_by_id(id){
    var myurl= "frontShowAddressByUserId?id="+id;            //注意路径书写
    $.ajax({
        url:myurl,
        type: "post",
        dataType: "json",
        success: function (a) {
            var tab = $("#tabjson2");
            var i=0;
            $.each(a, function (name, val) {
                if (i == 0) {
                    $("#indentBottom").after("<div style=\"border-radius: 3px;border-left:2px solid #FF6700;\n" +
                        "                        border-right: 1px solid #BBBBBB;border-top: 1px solid #BBBBBB;\n" +
                        "                        border-bottom:1px solid #BBBBBB;background-color: #F8F8F8;font-family:Microsoft JhengHei;margin-top: 20px;\">收货详情</div>");
                    tab.append(" <tbody >" +
                        "<tr>" +
                        "<th style='text-align: center;font-family: SimSun;'>选择</th>" +
                        "<th style='text-align: center;font-family: SimSun;'>收件人</th>" +
                        "<th style='text-align: center;font-family: SimSun;'>地址</th>" +
                        "<th style='text-align: center;font-family: SimSun;'>详细地址</th>" +
                        "<th style='text-align: center;font-family: SimSun;'>电话</th>" +
                        "<th style='text-align: center;font-family: SimSun;'>邮编</th>" +
                        "</tr>" +
                        "</tbody>");
                }
                item = "<tr>" +
                    "<td>" +"<input type=\"radio\" name=\"r1\" value='"+val.addressId+"'>" + "</td>" +
                    "<td>" + val.addressName + "</td>" +
                    "<td>" + val.addressProvince+" "+val.addressCity+"  "+val.addressDistrict + "</td>" +
                    "<td>" + val.detailedAddress + "</td>" +
                    "<td>" + val.addressPhone + "</td>" +
                    "<td>" + val.addressPostcode + "</td>" +
                    "</tr>";
                tab.append(item);
                i++;
            });
        }
    });

};

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

function getIndentDetail(indentId){

    $('#myModal').on('shown.bs.modal', function () {
        var id=indentId;
        var myurl= "frontShowIndentDetailByIndentId?id="+id;            //注意路径书写
        var indent_status;
        var payTime;
        $.ajax({
            url:myurl,
            type: "post",
            dataType: "json",
            success: function (a) {
                var tab = $("#tabjson");
                var i=0;
                $.each(a, function (name, val) {
                    item = "<tr>" +
                        "<td>" + val.commodity.commodityName + "</td>" +
                        "<td>" + val.commodity.commoditySize + "</td>" +
                        "<td>" + val.commodity.commodityColor+ "</td>" ;
                    if( val.commodity.commoditySex==1){
                        item+="<td>男</td>";
                    }else if ( val.commodity.commoditySex==0){
                        item+="<td>女</td>";
                    }
                    item+="<td>" + val.commodity.commodityMoney + "</td>" +
                        "<td>" + val.indentGoodsNum+ "</td>" +
                        "</tr>";
                    $('#tabjson').append(item);
                    if(i==0){
                        indent_status=val.indent.indentStatus;
                        $('#myindentid').html(val.indent.indentId);
                        $("#myindentcreatetime").text(changeDateFormat(val.indent.indentCreateTime));
                        $('#myindenttotal').text("￥"+val.indent.indentTotal);
                        payTime=val.indent.indent_paid_time;
                    }
                    i++;
                });
                if(indent_status==0){           //未支付（未发货）

                    find_address_by_id(222);        //从session中获得userid，先写死
                    var div1= $("#div1");
                    div1.append("<div class=\"strap\" style=\"border-radius: 3px;border-left:2px solid #FF6700;\n" +
                        "                        border-right: 1px solid #BBBBBB;border-top: 1px solid #BBBBBB;\n" +
                        "                        border-bottom:1px solid #BBBBBB;background-color: #F8F8F8;font-family:Microsoft JhengHei;\">支付详情</div>")
                    div1.append("<input type='radio' name='r2' value='0'> <img src=\"img/zfb.jpg\" style='width:273px;height:205px; '>");
                    div1.append("<input type='radio' name='r2' value='1'> <img src=\"img/wxzf.png\"  style='width:233px;height:174px;margin-bottom: 10px; '>");

                    var payInput="<button type='button' class='btn btn-default' id='payButton'>支付</button>";
                    $("#closeButton").before(payInput);
                    var cancelInput="<button type='button' class='btn btn-default' id='deleteButton'>取消并删除订单</button>";
                    $("#closeButton").before(cancelInput);
                }else if(indent_status==1||indent_status==2) {         //已支付（发货）或换货
                    //显示支付时间
                    $("#myindentcreatetime").after("<div id=\"myindentpayime\" style=\"display: inline-block;font-family: 'Times New Roman';\"></div>");
                    $("#myindentpayime").text(changeDateFormat(payTime));
                    var sureInput = "<button type='button' class='btn btn-default' id='sureButton'>确认收货</button>";
                    $('#closeButton').before(sureInput);
                    var changeInput = "<button type='button' class='btn btn-default' id='changeButton'>换货</button>";
                    $('#closeButton').before(changeInput);
                }
                else if(indent_status==3){          //已到货
                    var deleteInput="<button type='button'  class='btn btn-default' id='deleteButton'>删除订单</button>";
                    $('#closeButton').before(deleteInput);
                    $.ajax({
                        type: "post",
                        contentType: "application/json;charset=utf-8",
                        async: false,
                        url:"frontFindCommentByid?id="+id,
                        success : function(a) {
                            if (a =="") {  //还没有添加评论
                                $("#myComment").html(
                                    "<form action='frontInsertComment' style='margin-top: 20px;'>" +
                                    "<input type='text' name='myComment' class=\"form-control\" style='height: 60px;'> <br>" +
                                    "<input type='hidden' name='indentId' value='"+id+"'>" +
                                    "<input type='submit' class=\"btn btn-default\" id='subComment' value='提交评论' style='margin-left: 480px;'>" +
                                    "</form>");
                            }   else {    //已经评论过
                                $('#myComment').html("我的评价：" + a.content + "<br/>评论时间:" + changeDateFormat(a.commentTime));
                            }
                            $("#div1").after("<div class=\"strap\" style=\"border-radius: 3px;border-left:2px solid #FF6700;\n" +
                                "border-right: 1px solid #BBBBBB;border-top: 1px solid #BBBBBB;\n" +
                                "border-bottom:1px solid #BBBBBB;background-color: #F8F8F8;font-family:Microsoft JhengHei;margin-top: 20px;\">我的评论</div>\n")

                        }
                    });

                }
            }
        });

    });
}


