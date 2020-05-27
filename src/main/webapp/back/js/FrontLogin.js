function loginCheck(url){
    var name = $("#logname").val();    //用户名
    var pwd = $("#logpass").val();      //密码
    var datas;                  //返回来的结果
    $.ajax({
        type: "post",
        contentType:"application/json;charset=utf-8",
        dataType:"text",
        data : JSON.stringify({
            logname:name,
            logpass:pwd,
        }),
        async:false,
        url : url,
        success: function (data) {
            datas=data;
        }
    });
    if(datas == "nameError"){                 //用户名不正确
        layer.tips('用户名不存在！', '#logname', {
            tips: [2, '#FF3030'],
            time: 3000
        });
    }else if(datas == "pwdError"){            //密码不正确
        layer.tips('密码不正确	！', '#logpass', {
            tips: [2, '#FF3030'],
            time: 3000
        });
    }else{
        $("#f").submit();
    }
}