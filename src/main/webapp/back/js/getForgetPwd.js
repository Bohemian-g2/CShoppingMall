function getForgetQuestion(url) {
    var userId = $("#getUserId").val();
    $("select[name=AnswerOne]").empty(); //清空
    $("select[name=AnswerTwo]").empty(); //清空
    $.ajax({
        url: url,
        type: "post",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            getUserId:userId,
        }),
        success: function (data) {

            $.each(data,function(index,item){
                console.log("1111");
                var option1 = $("<option></option>").append(item.question.question).attr("value", item.question.questionId);
                $("#AOne").append(option1);
            })

        }
    });
}



