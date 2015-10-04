$(document).ready(function (){
	
	showInstitution();
});
function showInstitution()
{
	document.getElementById("stuclass").disabled = "";
	document.getElementById("major").disabled = "";
	document.getElementById("colleage").disabled = "";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/showAllInstitution.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				if (msg.institution != null) {
					if (msg.institution.length > 1) {
						var str = "<option value=\"0\">学院</option>";
						$.each(msg.institution, function(key, val) {
							str += "<option value=\"" + val.instId + "\">" + val.instName + "</option>";
						});
						$("#colleage").empty().append(str);
					} else if (msg.institution.length == 1) {
						var str = "<option value=\"" + msg.institution[0].instId + "\">" + msg.institution[0].instName
								+ "</option>";
						$("#colleage").empty().append(str);
						document.getElementById("colleage").disabled = true;
						showMajor();
					}
				} else {
					
					alert("当前用户非我校人员");
				}
			} else
			{
				alert("执行错误");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}
function showMajor()
{
	document.getElementById("stuclass").disabled = "";
	document.getElementById("major").disabled = "";
	var instId = document.getElementById("colleage").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/showMajor.do',
		async : false,
		data : {
			instId:instId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.major != null) {
					if (msg.major.length > 1) {
						var str = "<option value=\"0\">全部</option>";
						$.each(msg.major, function(key, val) {
							str += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
						});
						$("#major").empty().append(str);
						var str1 = "<option value=\"0\">全部</option>";
						$("#stuclass").empty().append(str1);
					} else if (msg.major.length == 1) {
						str = "<option value=\"" + msg.major[0].majrId + "\">" + msg.major[0].majrName + "</option>";
						$("#major").empty().append(str);
						var str1 = "<option value=\"0\">全部</option>";
						$("#stuclass").empty().append(str1);
						document.getElementById("major").disabled = true;
						showClass();
					}
				} else {
					var str = "<option value=\"0\">全部</option>";
					$("#major").empty().append(str);
					var str1 = "<option value=\"0\">全部</option>";
					$("#stuclass").empty().append(str1);
				}
			}else
			{
				alert("执行错误");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}
function showClass()
{
	document.getElementById("stuclass").disabled = "";
	var majorId = document.getElementById("major").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/showClass.do',
		async : false,
		data : {
			majorId:majorId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.studentclass != null) {
					if (msg.studentclass.length > 1) {
						var str = "<option value=\"0\">全部</option>";
						$.each(msg.studentclass, function(key, val) {
							str += "<option value=\"" + val.classId + "\">" + val.classShortname + "</option>";
						});
						$("#stuclass").empty().append(str);
					} else if (msg.studentclass.length == 1) {
						str = "<option value=\"" + msg.studentclass[0].classId + "\">"
								+ msg.studentclass[0].classShortname + "</option>";
						document.getElementById("stuclass").disabled = true;
						$("#stuclass").empty().append(str);
					}
				} else {
					var str = "<option value=\"0\">全部</option>";
					$("#stuclass").empty().append(str);
				}
			}else
			{
				alert("执行错误");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	var instlength = document.getElementById("colleage").length;
	var majorlength = document.getElementById("major").length;
	var classlength = document.getElementById("stuclass").length;
	if(instlength==1&&majorlength==1&&classlength==1)
	{
		document.getElementById("Query").style.display = "none";
	}
}