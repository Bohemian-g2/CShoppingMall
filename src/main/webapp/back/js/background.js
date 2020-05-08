/*页面载入函数*/
function loadPage(url,jspName){
	$.ajax({
		type:"GET",
		url:url,
		async:true,
		datatype:"html",
		contentType:"application/json;charset=utf-8",
		success:function(html){
			$("#content").html(html);
			if(jspName=="adminList"){
				getAdminList();
			}
			if(jspName=="userList"){
				getUserList();
			}
			if(jspName=="commentList"){
				getCommentList();
			}

		},
		error:function(){
			alert("出现错误"+url);
		}
	});
}


/*超管个人信息修改函数*/
function updateSuperInfo(url) {
	var superadminName=$("#superadminName").val();
	var superadminPassword=$("#superadminPassword").val();
	var resuperadminPassword=$("#resuperadminPassword").val();
	var passwRegex=/^[\w]{6,18}$/;
	var datas;
	if(superadminName.length>20){
		layer.tips('昵称过长！', '#superadminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	if(superadminPassword.length>0){//当修改密码时做出判断
		if(!passwRegex.test(superadminPassword)){
			layer.tips('密码格式不正确，密码只能为数字字母，长度6-18位！', '#superadminPassword', {
				tips: [2, '#FF3030'],
				time: 2000
			});
			return false;
		}
		if(resuperadminPassword!=superadminPassword){
			layer.tips('密码不一致！', '#resuperadminPassword', {
				tips: [2, '#FF3030'],
				time: 2000
			});
			return false;
		}
	}
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "text",
		data: JSON.stringify({
			name: superadminName,
			password: superadminPassword,
		}),
		async: false,
		url: url,
		success: function (data) {
			datas = data;
		}
	});
	if (datas == "passwError") {                 //密码格式不正确
		layer.tips('密码格式不正确，密码只能为数字字母，长度6-18位！', '#superadminPassword', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if (datas == "nameError") {            //姓名长度不正确
		layer.tips('昵称过长！', '#superadminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	}else if(datas=="success"){
		layer.msg("修改成功,重新登录后生效");
	}else {
		layer.msg("修改失败");
	}

}
/*普管个人信息修改函数*/
function updateAdminInfo(url) {
	var adminName=$("#adminName").val();
	var adminPassword=$("#adminPassword").val();
	var readminPassword=$("#readminPassword").val();
	var adminPhone=$("#adminPhone").val();
	var passwRegex=/^[\w]{6,18}$/;
	var phoneRegex=/^1[3578][0-9]{9}$/;
	var datas;
	if(adminName.length>20){
		layer.tips('昵称过长！', '#adminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	if(adminPhone.length>0){//当电话不为空时做出判断
		if(!phoneRegex.test(adminPhone)){
			layer.tips('电话不存在！', '#adminPhone', {
				tips: [2, '#FF3030'],
				time: 2000
			});
			return false;
		}
	}
	if(adminPassword.length>0){//当密码不为空时做出判断
		if(!passwRegex.test(adminPassword)){
			layer.tips('密码格式不正确，密码只能为数字字母，长度6-18位！', '#adminPassword', {
				tips: [2, '#FF3030'],
				time: 2000
			});
			return false;
		}
		if(readminPassword!=adminPassword){
			layer.tips('密码不一致！', '#readminPassword', {
				tips: [2, '#FF3030'],
				time: 2000
			});
			return false;
		}
	}
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "text",
		data: JSON.stringify({
			name: adminName,
			password: adminPassword,
			phone: adminPhone,
		}),
		async: false,
		url: url,
		success: function (data) {
			datas = data;
		}
	});
	if (datas == "passwError") {                 //密码格式不正确
		layer.tips('密码格式不正确，密码只能为数字字母，长度6-18位！', '#adminPassword', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if (datas == "nameError") {            //姓名长度不正确
		layer.tips('昵称过长！', '#adminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if (datas == "phoneError") {            //电话格式不正确
		layer.tips('电话不存在！', '#adminPhone', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if(datas=="success"){
		layer.msg("修改成功,重新登录后生效");
	}else {
		layer.msg("修改失败");
	}
}


/*管理员信息部分*/
/*admin分页查询+条件查询函数*/
function getAdminList(adminpage) {
	if(adminpage==null){
		adminpage=1;
	}
	var adminId=$("#SecAdminId").val();
	var adminUsername=$("#SecAdminUsername").val();
	var adminName=$("#SecAdminName").val();
	var adminRegisterDate=$("#SecRegisterDate").val();
	var adminPhone=$("#SecAdminPhone").val();
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "json",
		data: JSON.stringify({
			adminId:adminId,
			adminUsername:adminUsername,
			adminName:adminName,
			adminRegisterDate:adminRegisterDate,
			adminPhone:adminPhone,
			currentPage:adminpage,
		}),
		async: false,
		url: "/CShoppingMall/ordiadmin/queryAdminListBySec",
		success: function (ret) {
			loadAmdinInfo(ret.admins);
			paging(ret);
		},
		error:function(){
			alert("数据获取出现错误");
		}
	});
}
/*admin数据表格填充函数*/
function loadAmdinInfo(data1) {
	var html='';
	for(var i=0;i<data1.length;i++){
		html+='<tr>';
		html+=' <td>';
		html+='     <input type="checkbox" value="'+data1[i].adminId+'"name="admincheckbox"/>';
		html+=' </td>';
		html+=' <td>'+data1[i].adminId+'</td>';
		html+=' <td>'+data1[i].adminUsername+'</td>';
		html+=' <td>'+data1[i].adminName+'</td>';
		html+=' <td>'+data1[i].adminPhone+'</td>';
		html+=' <td>'+data1[i].adminRegisterDate+'</td>';
		html+=' <td><div class="am-btn-toolbar">';
		html+=' <div class="am-btn-group am-btn-group-xs">';
		html+=' <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" ' +
			         'data-am-modal="{target: '+'\'#my-updadminfo\''+'}" title="修改管理员"' +
					 'onclick="fulupdateAdmin(\''+data1[i].adminName+'\',\''+data1[i].adminPhone+'\',\''+data1[i].adminId+'\')">'+
					 '<span class="am-icon-pencil-square-o"></span></button>';
		html+=' <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"title="删除管理员"' +
					 'onclick="simdeleteInfo('+data1[i].adminId+',\'/CShoppingMall/ordiadmin/deleteAdminList\',\'adminlist\')">' +
					 '<span class="am-icon-trash-o" ></span></button>';
		html+='</div></div>';
		html+='</td>';
		html+='</tr>';
	}
	$("#adminInfoPage").empty().append(html);
}
/*admin修改*/
/*admin修改栏填充函数*/
function fulupdateAdmin(name,phone,id) {
	$("#updateAdminName").attr("value",name);
	$("#updateAdminPhone").attr("value",phone);
	$("#updateAdminId").attr("value",id)
}
/*修改管理员列表函数*/
function updateAdmin(url){
	var adminName=$("#updateAdminName").val();
	var adminPhone=$("#updateAdminPhone").val();
	var id=$("#updateAdminId").val();
	var phoneRegex=/^1[3578][0-9]{9}$/;
	if(adminName.length<0||adminName.length>20){
		layer.tips('昵称过长！', '#updateAdminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	if(!phoneRegex.test(adminPhone)){
		layer.tips('电话不存在！', '#updateAdminPhone', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	var datas;
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "text",
		data: JSON.stringify({
			adminName: adminName,
			adminPhone: adminPhone,
			adminId:id,
		}),
		async: false,
		url: url,
		success: function (data) {
			datas = data;
		}
	});
	if (datas == "nameError") {            //姓名长度不正确
		layer.tips('昵称过长！', '#updateAdminName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if (datas == "phoneError") {            //电话格式不正确
		layer.tips('电话不存在！', '#updateAdminPhone', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if(datas=="updateSuccess"){
		layer.alert('修改成功', {
			skin: 'layui-layer-mo'
			,closeBtn: 0
			,anim: 4 //动画类型
		});
		getAdminList();//刷新界面
	}else{
		layer.alert('修改失败', {
			skin: 'layui-layer-mo'
			,closeBtn: 0
			,anim: 4 //动画类型
		});
	}
}
/*管理员信息部分结束*/


/*用户信息部分*/
/*user分页查询+条件查询函数*/
function getUserList(userpage) {
	if(userpage==null){
		userpage=1;
	}
	var userId=$("#SecUserId").val();
	var userLoginname=$("#SecUserLoginName").val();
	var userName=$("#SecUsrName").val();
	var userIdType=$("#SecUserIdType").val();
	var userIdNumber=$("#SecUserIdNumber").val();
	var userPhone=$("#SecUserPhone").val();
	var userSex=$("input[name='usersex']:checked").val();
	var userEmail=$("#SecUserEmail").val();
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "json",
		data: JSON.stringify({
			userId:userId,
			loginName:userLoginname,
			userName:userName,
			identityType:userIdType,
			identityNumber:userIdNumber,
			userPhone:userPhone,
			sex:userSex,
			userEmail:userEmail,
			currentPage:userpage,
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
/*user数据表格填充函数*/
function loadUserInfo(data) {
	var html='';
	for(var i=0;i<data.length;i++){
		var sex;
		var Idtype
		if(data[i].sex==1){
			sex="男";
		}else{
			sex="女";
		}
		switch (data[i].identityType) {
			case 1:
				Idtype="中华人民共和国居民身份证"
				break;
			case 2:
				Idtype="美利坚合众国居民身份证"
				break;
		}
		html+='<tr>';
		html+=' <td>';
		html+='     <input type="checkbox" value="'+data[i].userId+'" name="usercheckbox"/>';
		html+=' </td>';
		html+=' <td>'+data[i].userId+'</td>';
		html+=' <td>'+data[i].loginName+'</td>';
		html+=' <td>'+data[i].userName+'</td>';
		html+=' <td>'+Idtype+'</td>';
		html+=' <td>'+data[i].identityNumber+'</td>';
		html+=' <td>'+sex+'</td>';
		html+=' <td>'+data[i].userPhone+'</td>';
		html+=' <td><div class="am-btn-toolbar">';
		html+=' <div class="am-btn-group am-btn-group-xs">';
		html+=' <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" ' +
			'data-am-modal="{target: '+'\'#my-upduserinfo\''+'}" title="修改用户"' +
			'onclick="fulupdateUser(\''+data[i].userId+
									'\',\''+ data[i].loginName+
									'\',\''+ Idtype+
									'\',\''+ data[i].identityNumber+
									'\',\''+ data[i].userName+
									'\',\''+ data[i].userEmail+
									'\',\''+ sex+
									'\',\''+ data[i].userPhone+'\')">'+
			'<span class="am-icon-pencil-square-o"></span></button>';
		html+=' <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"title="删除用户"' +
			'onclick="simdeleteInfo('+data[i].userId+',\'/CShoppingMall/backuser/deleteUserList\',\'userlist\')">' +
			'<span class="am-icon-trash-o" ></span></button>';
		html+='</div></div>';
		html+='</td>';
		html+='</tr>';
	}
	$("#userInfoPage").empty().append(html);
}
/*user修改栏填充*/
function fulupdateUser(id,username,idType,idNumber,name,Email,sex,phone) {
	$("#upateUserId").attr("value",id);
	$("#upateUserLoginName").attr("value",username);
	$("#updateUserIdType").attr("value",idType);
	$("#updateUserIdNumber").attr("value",idNumber);
	$("#upateUserName").attr("value",name);
	$("#updateUserEmail").attr("value",Email);
	if(sex=="男"){
		$("input[name='updateUserSex']:eq(0)").attr("checked",'checked');
	}else{
		$("input[name='updateUserSex']:eq(1)").attr("checked",'checked');
	}
	$("#updateUserPhone").attr("value",phone);

}
/*修改user列表函数*/
function updateUser(url){
	var userName=$("#upateUserName").val();
	var userEmail=$("#updateUserEmail").val();
	var userPhone=$("#updateUserPhone").val();
	var userSex=$("input[name='updateUserSex']:checked").val();
	var id=$("#upateUserId").val();
	var phoneRegex=/^1[3578][0-9]{9}$/;
	if(userName.length<0||userName.length>20){
		layer.tips('昵称过长！', '#upateUserName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	if(!phoneRegex.test(userPhone)){
		layer.tips('电话不存在！', '#updateUserPhone', {
			tips: [2, '#FF3030'],
			time: 2000
		});
		return false;
	}
	var datas;
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "text",
		data: JSON.stringify({
			userName: userName,
			userEmail:userEmail,
			userPhone: userPhone,
			sex:userSex,
			userId:id,
		}),
		async: false,
		url: url,
		success: function (data) {
			datas = data;
		}
	});
	if (datas == "nameError") {            //姓名长度不正确
		layer.tips('昵称过长！', '#upateUserName', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if (datas == "phoneError") {            //电话格式不正确
		alert("电话不存在");
		layer.tips('电话不存在！', '#updateUserPhone', {
			tips: [2, '#FF3030'],
			time: 2000
		});
	} else if(datas=="updateSuccess"){
		layer.alert('修改成功', {
			skin: 'layui-layer-mo'
			,closeBtn: 0
			,anim: 4 //动画类型
		});
		getUserList(null);//刷新界面
	}else{
		layer.alert('修改失败', {
			skin: 'layui-layer-mo'
			,closeBtn: 0
			,anim: 4 //动画类型
		});
	}
}
/*用户信息结束*/

/*评论信息部分*/
/*Comment分页查询+条件查询函数*/
function getCommentList(commentpage) {
	if(commentpage==null){
		commentpage=1;
	}
	var commentId=$("#SecCommentId").val();
	var ULN=$("#SecULNComment").val();//用户账号
	var CID=$("#SecCIDComment").val();//商品id
	var CN=$("#SecCNComment").val();//商品名称
	$.ajax({
		type: "post",
		contentType: "application/json;charset=utf-8",
		dataType: "json",
		data: JSON.stringify({
			commentId:commentId,
			ULN:ULN,
			commodityId:CID,
			commodityName:CN,
			currentPage:commentpage,
		}),
		async: false,
		url: "/CShoppingMall/comment/querycommentListBySec",
		success: function (ret) {
			loadCommentInfo(ret.comments);
			paging(ret);
		},
		error:function(){
			alert("数据获取出现错误");
		}
	});
}
/*Comment数据表格填充函数*/
function loadCommentInfo(data1) {
	var html='';
	for(var i=0;i<data1.length;i++){
		html+='<tr>';
		html+=' <td>';
		html+='     <input type="checkbox" value="'+data1[i].commentId+'" name="commentcheckbox"/>';
		html+=' </td>';
		html+=' <td>'+data1[i].commentId+'</td>';
		html+=' <td>'+data1[i].userLoginName+'</td>';
		html+=' <td>'+data1[i].commodityName+'</td>';
		html+=' <td>'+data1[i].content+'</td>';
		html+=' <td>'+data1[i].commentTime+'</td>';
		html+=' <td><div class="am-btn-toolbar">';
		html+=' <div class="am-btn-group am-btn-group-xs">';
		html+=' <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" ' +
			'data-am-modal="{target: '+'\'#my-commentdetail\''+'}" title="查看详情"' +
			'onclick="fulComment(\''+data1[i].commentId+
								'\',\''+data1[i].userId+
								'\',\''+data1[i].userLoginName+
								'\',\''+data1[i].commodityId+
								'\',\''+data1[i].commodityName+
								'\',\''+data1[i].indentId+
								'\',\''+data1[i].commentTime+
								'\',\''+data1[i].content+'\')">'+
			'<span class="am-icon-search-plus"></span></button>';
		html+=' <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"title="删除评论"' +
			'onclick="simdeleteInfo('+data1[i].commentId+',\'/CShoppingMall/comment/deleteCommentList\',\'commentlist\')">' +
			'<span class="am-icon-trash-o" ></span></button>';
		html+='</div></div>';
		html+='</td>';
		html+='</tr>';
	}
	$("#commentInfoPage").empty().append(html);
}
/*Comment详情*/
/*Comment详情栏填充函数*/
function fulComment(id,uid,uln,cid,cn,indentId,date,content) {
	$("#detailCommentId").attr("value",id);
	$("#detailUIdComment").attr("value",uid);
	$("#detailULNComment").attr("value",uln);
	$("#detailCIDComment").attr("value",cid);
	$("#detailCNComment").attr("value",cn);
	$("#detailCommentIndent").attr("value",indentId);
	$("#detailCommentDate").attr("value",date);
	$("#detailCommentContent").attr("value",content);
}
/*评论信息部分结束*/




/*分页插件,分页插件统一命名laypage*/
function paging(data) {
	layui.use('laypage', function() {
		var laypage = layui.laypage;
		laypage.render({
			elem: 'laypage' //注意，这里的 laypage 是 ID，不用加 # 号
			, count: data.total //数据总数，从服务端得到
			, limit: 6
			, curr: data.nowPage
			, first: false
			, last: false
			, prev: '<em>«</em>'
			, next: '<em>»</em>'
			, jump: function (obj, first) {
				if (!first) {
					getAdminList(obj.curr);
				}
			}
		});
	})
}


/*删除部分,删除部分函数通用*/
/*全选，反选函数*/
function allselect(obj,checkname) {
	if (obj.checked){
		$("input[name="+checkname+"]").each(function(){
			$(this).prop("checked", true);
		});
	} else {
		$("input[name="+checkname+"]").each(function() {
			$(this).prop("checked", false);
		});
	}
}
//删除函数
function deleteInfo(checkname,url){
	/*获得被选中的id*/
	var ids=new Array();
	$("input[name="+checkname+"]:checked").each(function () {
		ids.push($(this).val());
	});
	$.ajax({
		type:"post",
		url:url,//对应controller的URL
		contentType: "application/json;charset=utf-8",
		async:false,
		dataType: 'text',
		data:JSON.stringify({
			"deleteIdList":ids,
		}),
		success:function(result){
			if(result=="deletesuccess"){
				layer.msg('删除成功');
					getAdminList();
					getUserList();
					getCommentList();
			}else{
				layer.msg('删除失败');
			}
		},
		error:function(){
			alert("数据获取出现错误");
		}
	});
}
//单点删除管理员信息函数
function simdeleteInfo(id,url,list){
	/*获得被选中的id*/
	var ids=new Array();
	ids.push(id);
	$.ajax({
		type:"post",
		url:url,//对应controller的URL
		contentType: "application/json;charset=utf-8",
		async:false,
		dataType: 'text',
		data:JSON.stringify({
			"deleteIdList":ids,
		}),
		success:function(result){
			if(result=="deletesuccess"){
				layer.msg('删除成功');
				if(list=="adminlist"){
					getAdminList();
				}
				if(list=="userlist"){
					getUserList();
				}
				if(list=="commentlist"){
					getCommentList();
				}
			}else{
				layer.msg('删除失败');
			}
		},
		error:function(){
			alert("数据获取出现错误");
		}
	});
}
/*删除部分结束*/

/*添加管理员函数*/
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
		getAdminList();
		layer.alert('添加成功,新管理员账号：'+datas, {
			skin: 'layui-layer-mo'
			,closeBtn: 0
			,anim: 4 //动画类型
		});
	}
}




