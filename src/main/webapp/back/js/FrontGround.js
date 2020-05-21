/*用户注册*/
function saveAdmin() {
    var loginName = $("#loginName").val();
    var password = $("#password").val();
    var userName = $("#userName").val();
    var userEmail = $("#userEmail").val();
    var userPhone = $("#userPhone").val();
    var passwRegex = /^[\w]{6,16}$/;
    var phoneRegex = /^1[3578][0-9]{9}$/;
    var emailRegex = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;

    if (loginName.length < 0 || loginName.length > 20) {
        layer.tips('昵称格式不正确！', '#loginName', {
            tips: [2, '#FF3030'],
            time: 2000
        });
        return false;
    } else if (!passwRegex.test(password)) {
        layer.tips('密码格式不正确，密码只能为数字字母，长度6-16位！', '#password', {
            tips: [2, '#FF3030'],
            time: 2000
        });
        return false;
    } else if (!phoneRegex.test(userPhone)) {
        layer.tips('电话格式不正确！', '#userPhone', {
            tips: [2, '#FF3030'],
            time: 2000
        });
        return false;
    } else if (!emailRegex.test(userEmail)) {
        layer.tips('邮箱格式不正确!', 'userEmail', {
            tips: [2, '#FF3030'],
            time: 2000
        });
        return false;
    } else {
        $("#t").submit();
    }




}