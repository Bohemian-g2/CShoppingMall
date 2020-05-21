function getQuestions(url) {
        $("select[name=questionIdOne]").empty(); //清空
        $("select[name=questionIdTwo]").empty(); //清空
        $.ajax({
            url: url,
            type: "post",
            contentType: "application/json;charset=utf-8",
            dataType: "json",

            success: function (result) {

                $.each(result, function (index, item) {
                    console.log(result);
                    var option1 = $("<option></option>").append(item.question).attr("value", item.questionId);
                    var option2 = $("<option></option>").append(item.question).attr("value", item.questionId);
                    $("#qOne").append(option1);
                    $("#qTwo").append(option2);
                })
            }
        });


    }