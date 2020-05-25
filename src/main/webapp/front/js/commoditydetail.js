/*评论页面载入函数*/
function loadComment(url){
    $.ajax({
        type: "post",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            comm:userId,
        }),
        async: false,
        url: "/CShoppingMall/backuser/queryUserListBySec",
        success: function (ret) {
            loadUserInfo(ret.users);
            paging(ret);
        },
        error:function(){
            alert("数据获取出现错误");
        }
    });
}