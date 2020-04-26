function loadPage(url){
	$.ajax({
		type:"GET",
		url:url,
		async:true,
		datatype:"html",
		contentType:"application/json;charset=utf-8",
		success:function(html){
			$("#content").html(html);
		},
		error:function(){
			alert("出现错误"+url);
		}
	});
}

function saveAdmin(url){
	var adminName=$("#regAdminName").val();
	var adminPassword=$("#regAdminPassword").val();
	var readminPassword=$("#reregAdminPassword").val();
	var adminPhone=$("#regAdminPhone").val();
	var passwRegex=/^[\w]{6,18}$/;
	var phoneRegex=/^1[3578][0-9]{9}$/;
	if(adminName.length<0||adminName.length>20){
		layer.tips('昵称过长！', '#regAdminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	if(!passwRegex.test(adminPassword)){
		layer.tips('密码格式不正确，密码只能为数字字母，长度6-18位！', '#regAdminPassword', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	if(!phoneRegex.test(adminPhone)){
		layer.tips('电话不存在！', '#regAdminPhone', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	if(readminPassword!=adminPassword){
		layer.tips('密码不一致！', '#reregAdminPassword', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "text",
		data: JSON.stringify({
			adminName: adminName,
			adminPassword: adminPassword,
			adminPhone: adminPhone,
		}),
		async: false,
		url: url,
		success: function (data) {
			datas = data;
		}
	});
	if (datas == "passwError") {                 //密码格式不正确
		layer.tips('密码格式不正确，密码只能为数字字母，长度6-18位！', '#regAdminPassword', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if (datas == "nameError") {            //姓名长度不正确
		layer.tips('昵称过长！', '#regAdminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if (datas == "phoneError") {            //电话格式不正确
		layer.tips('电话不存在！', '#regAdminPhone', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else {
		$("#regAdminName").val("");
		$("#regAdminPassword").val("");
		$("#reregAdminPassword").val("");
		$("#regAdminPhone").val("");
		alert("添加成功,新管理员账号："+datas);
	}
}

