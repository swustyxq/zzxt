$(document).ready(function (){
	showInstitution();
});
function showInstitution()
{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showAllInstitution.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				if(msg.institution!=null){
					if(msg.institution.length>1)
					{
					var str = "<option value=\"0\">全部</option>";
					$.each(msg.institution,function(key,val){
						str += "<option value=\""+val.instId+"\">"+val.instName+"</option>";
					});
					$("#colleage").empty().append(str);
					document.getElementById("colleage").disabled = false;
					//showMajor();
					}else if(msg.institution.length==1)
					{
						var str = "<option value=\""+msg.institution[0].instId+"\">"+msg.institution[0].instName+"</option>";
						$("#colleage").empty().append(str);
						document.getElementById("colleage").disabled = true;
						showMajor();
					}
				}else
				{
					alert("执行错误");
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
function showMajor()
{
	var instId = document.getElementById("colleage").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showMajor.do',
		async : false,
		data : {
			instId:instId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				if(msg.major!==null)
				{
					if(msg.major.length>1)
			
				{
				document.getElementById("major").disabled = false;
				var str = "<option value=\"0\">全部</option>";
				$.each(msg.major,function(key,val){
					str += "<option value=\""+val.majrId+"\">"+val.majrName+"</option>";
				});
				$("#major").empty().append(str);
				showClass();
				}else if(msg.major.length==1)
				{
					str = "<option value=\""+msg.major[0].majrId+"\">"+msg.major[0].majrName+"</option>";
					$("#major").empty().append(str);
					document.getElementById("major").disabled = true;
					showClass();
				}
				}
				else{
					var str = "<option value=\"0\">全部</option>";
					$("#major").empty().append(str);
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
}
function showClass()
{
	var majorId = document.getElementById("major").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showClass.do',
		async : false,
		data : {
			majorId:majorId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				if(msg.studentclass!=null){
					
				if(msg.studentclass.length>1)
				{
				document.getElementById("stuclass").disabled = false;
				var str = "<option value=\"0\">全部</option>";
				$.each(msg.studentclass,function(key,val){
					str += "<option value=\""+val.classId+"\">"+val.className+"</option>";
				});
				$("#stuclass").empty().append(str);
				}else if(msg.studentclass.length==1)
				{
					str = "<option value=\""+msg.studentclass[0].classId+"\">"+msg.studentclass[0].classShortname+"</option>";
					document.getElementById("stuclass").disabled = true;
					$("#stuclass").empty().append(str);
				}
				}else
				{
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
}