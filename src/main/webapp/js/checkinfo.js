$(document).ready(function() {

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/checkStuInfo.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				
			} else {
				alert("请先完善："+msg.info+"信息");
				location.href = "/zzxt/htmls/inputInfo.html?pareid=1&funid=14";
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
});