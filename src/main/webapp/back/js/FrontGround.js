/*用户注册*/
function saveUser() {
    var password = $("#password").val();
    var repassword = $("#repassword").val();
    var userEmail = $("#userEmail").val();
    var userPhone = $("#userPhone").val();
    var passwRegex = /^[\w]{6,16}$/;
    var phoneRegex = /^1[3578][0-9]{9}$/;
    var emailRegex = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;

    if (!passwRegex.test(password)) {
        layer.tips('密码格式不正确，密码只能为数字字母，长度6-16位！', '#password', {
            tips: [1, '#FF3030'],
            time: 3000
        });
        return false;
    } else if(password!=repassword){
        layer.tips('两次输入的密码不一致', '#repassword', {
            tips: [1, '#FF3030'],
            time: 3000
        });
    }else if(userEmail=="") {
        layer.tips('请输入邮箱！', '#userEmail', {
            tips: [1, '#FF3030'],
            time: 3000
        });
        return false;
    } else if (!emailRegex.test(userEmail)) {
        layer.tips('邮箱格式不正确!', '#userEmail', {
            tips: [1, '#FF3030'],
            time: 3000
        });
        return false;
    } else if (userPhone=="") {
        layer.tips('请输入电话号码!', '#userPhone', {
            tips: [1, '#FF3030'],
            time: 3000
        });
        return false;
    }else if(!phoneRegex.test(userPhone)) {
        layer.tips('电话号码格式不正确！', '#userPhone', {
            tips: [1, '#FF3030'],
            time: 3000
        });
        return false;
    } else {
        $("#t").submit();
    }




}