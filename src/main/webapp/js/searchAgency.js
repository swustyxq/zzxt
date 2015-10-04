var list;// 存所有信息
var rightlist = new Array();// 存符合筛选条件的信息
var roleid;
$(document).ready(	
		function(){
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/gjjxjController/showList.do',
				async : false,
				data : {

				},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
							if(msg.role<15){
								//alert(msg.instid);
								$("#colleage").val(msg.instid);
								$("#colleage").attr("disabled","disabled");
								academyChange();
							}
						
					} else {
						alert(msg.message);
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}		
		});
});

function academyChange() {
	var academyid = $("#colleage").val();
	var option = "";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/findMajor.do',
		async : false,
		data : {
			academyid : academyid,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.major != null) {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$.each(msg.major, function(key, val) {
						option += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
					});
					$("#major").empty().append(option);
					majorChange();
				} else {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$("#major").empty().append(option);
					majorChange();
				}
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function majorChange() {
	var majorid = $("#major").val();
	var option = "";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/findClass.do',
		async : false,
		data : {
			majorid : majorid,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.stuclass != null) {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$.each(msg.stuclass, function(key, val) {
						option += "<option value=\"" + val.classId + "\">" + val.className + "</option>";
					});
					$("#stuclass").empty().append(option);
				} else {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$("#stuclass").empty().append(option);
				}
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

