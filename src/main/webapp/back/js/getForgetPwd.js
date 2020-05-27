$(function() {
    $("#getUserId").blur(function () {
        var loginRegex = /^[0-9]{6,10}$/;
        if(!loginRegex.test($("#getUserId").val())){
            layer.tips('账号不存在', '#getUserId', {
                tips: [1, '#FF3030'],
                time: 3000
            });
        }else {
            var userId = $("#getUserId").val();
            $("select[name=AnswerOne]").empty(); //清空
            $("select[name=AnswerTwo]").empty(); //清空
            $.ajax({
                url: "/CShoppingMall/Answer/getForgetEncry",
                type: "post",
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                data: JSON.stringify({
                    getUserId: userId,
                }),
                success: function (data) {
                    $.each(data, function (index, item) {
                        var option1 = $("<option></option>").append(item.question.question).attr("value", item.question.questionId);
                        $("#AOne").append(option1);
                    })

                }
            });
        }
    });

});



