$(document).ready(function(){
	showinfo();
	showInstitution();
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/ylController/showApplyYlList.do',
			async : false,
			data : {
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){
				if(msg.ylbzbasicinfo.length!=0)
					{
					var str="<tr><td>序号</td><td>学院</td><td>专业</td><td>班级</td><td>姓名</td><td>申请类型</td><td>申请时间</td><td>审核状态</td><td>操作</td></tr>";
						var i=0;
						$.each(msg.ylbzbasicinfo,function(key,val){
							str+="<tr><td>"+(i+1)
							+"</td><td>"+val.instShortName
							+"</td><td>"+val.majrName
							+"</td><td>"+val.classShortName
							+"</td><td>"+val.studentName
							+"</td><td>"+val.applyType
							+"</td><td>"+time1(val.applyTime);
							if(val.state==0){
							str+="</td><td>"+"未审核";
							}else{
							str+="</td><td>"+"审核通过";
							}
							if(msg.user.userType==7&&val.state==0)
							{
								str+="</td><td>"+"<a href=\"/zzxt/htmls/seeYlDetail.html?id="+val.ylbzId+"\"><button type='button' class='btn btn-success btn-xs'>审核</button></a>"
								+"</td></tr>";
							}else{
								str+="</td><td>"+"<a href=\"/zzxt/htmls/seeYlDetail.html?id="+val.ylbzId+"\"><button type='button' class='btn btn-success btn-xs'>查看详细</button></a>"
								+"</td></tr>";
							}
							i++;
						});
						$("#studentYlListTable").empty().append(str);
						}
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
	$("#Query").click(function(){
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/ylController/showYlList.do',
			async : false,
			data : {
				colleageId:colleageId,
				majorId:majorId,
				classId:classId
			},
			dataType : 'json',
			success : function(msg) {
			if(msg.result ==true){
			if(msg.ylbzbasicinfo.length!=0)
				{
					var str="<tr><td>序号</td><td>学院</td><td>专业</td><td>班级</td><td>姓名</td><td>申请类型</td><td>申请时间</td><td>审核状态</td><td>操作</td></tr>";
					var i=0;
					$.each(msg.ylbzbasicinfo,function(key,val){
						str+="<tr><td>"+(i+1)
						+"</td><td>"+val.instShortName
						+"</td><td>"+val.majrName
						+"</td><td>"+val.classShortName
						+"</td><td>"+val.studentName
						+"</td><td>"+val.applyType
						+"</td><td>"+time1(val.applyTime);
						if(val.state==0){
						str+="</td><td>"+"未审核";
						}else{
						str+="</td><td>"+"审核通过";
						}
						str+="</td><td>"+"<a href=\"/zzxt/htmls/seeYlDetail.html?id="+val.ylbzId+"\"><button type='button' class='btn btn-success btn-xs'>查看详细</button></a>"
						+"</td></tr>";
						i++;
					});
					$("#studentYlListTable").empty().append(str);
					}else{
						var str="<tr><td>序号</td><td>学院</td><td>专业</td><td>班级</td><td>姓名</td><td>申请类型</td><td>申请时间</td><td>审核状态</td><td>操作</td></tr>";
						$("#studentYlListTable").empty().append(str);
					}
			}else{
				alert(msg.message);
			}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
	});
});
function showInstitution()
{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/showAllInstitution.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
					if(msg.institution!=null)
					{
						if(msg.institution.length>1)
						{
						var str = "<option value=\"0\">全部</option>";
						$.each(msg.institution,function(key,val){
							str += "<option value=\""+val.instId+"\">"+val.instName+"</option>";
						});
						$("#colleage").empty().append(str);
						}else if(msg.institution.length==1)
						{
							var str = "<option value=\""+msg.institution[0].instId+"\">"+msg.institution[0].instName+"</option>";
							$("#colleage").empty().append(str);
							document.getElementById("colleage").disabled = true;
							showMajor();
						}else
						{
							var str = "<option value=\"0\">全部</option>";
							$("#major").empty().append(str);
							$("#stuclass").empty().append(str);
						}
					}else{
						alert("当前用户非我校人员");
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
	document.getElementById("major").disabled = false;
	document.getElementById("stuclass").disabled = false;
	var instId = document.getElementById("colleage").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/showMajor.do',
		async : false,
		data : {
			instId:instId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				if(msg.major!=null)
				{
					if(msg.major.length>1)
					{
					var str = "<option value=\"0\">全部</option>";
					$.each(msg.major,function(key,val){
						str += "<option value=\""+val.majrId+"\">"+val.majrName+"</option>";
					});
					$("#major").empty().append(str);
					var str = "<option value=\"0\">全部</option>";
					$("#stuclass").empty().append(str);
					}else if(msg.major.length==1)
					{
						str = "<option value=\""+msg.major[0].majrId+"\">"+msg.major[0].majrName+"</option>";
						$("#major").empty().append(str);
						document.getElementById("major").disabled = true;
						showClass();
					}else
					{
						var str = "<option value=\"0\">全部</option>";
						$("#major").empty().append(str);
						$("#stuclass").empty().append(str);
					}
				}else{
					var str = "<option value=\"0\">全部</option>";
					$("#major").empty().append(str);
					$("#stuclass").empty().append(str);
				}
			}else
			{
				var str = "<option value=\"0\">全部</option>";
				$("#major").empty().append(str);
				$("#stuclass").empty().append(str);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}
function showClass()
{
	document.getElementById("stuclass").disabled = false;
	var majorId = document.getElementById("major").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/showClass.do',
		async : false,
		data : {
			majorId:majorId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				if(msg.studentclass!=null)
				{
					if(msg.studentclass.length>1)
					{
					var str = "<option value=\"0\">全部</option>";
					$.each(msg.studentclass,function(key,val){
						str += "<option value=\""+val.classId+"\">"+val.classShortname+"</option>";
					});
					$("#stuclass").empty().append(str);
					}else if(msg.studentclass.length==1)
					{
						str = "<option value=\""+msg.studentclass[0].classId+"\">"+msg.studentclass[0].classShortname+"</option>";
						document.getElementById("stuclass").disabled = true;
						$("#stuclass").empty().append(str);
					}
					else
					{
						var str = "<option value=\"0\">全部</option>";
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
	var instlength = document.getElementById("colleage").length;
	var majorlength = document.getElementById("major").length;
	var classlength = document.getElementById("stuclass").length;
	if(instlength==1&&majorlength==1&&classlength==1)
	{
		document.getElementById("Query").style.display = "none";
	}
}
function showinfo()
{
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/announcementController/showWorkIntroduction.do',
			async : false,
			data : {
				id:9
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){
					var paIntroduction="";
					paIntroduction="<h4 align='center'><b>"+msg.czWorkIntroduction.title+"</b></h4>"
									+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.czWorkIntroduction.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
									"<span>所属类别：</span><span>"+msg.czWorkIntroduction.type+"</span><br />"
									+"<span>最后修改时间：</span><span>"+msg.czWorkIntroduction.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
									"<span>发布时间：</span><span>"+msg.czWorkIntroduction.publishTime+"</span></div><br />" +
									"<pre>"+msg.czWorkIntroduction.content+"</pre>";
					$("#YlIntroduction1").empty().append(paIntroduction);
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/announcementController/showWorkIntroduction.do',
			async : false,
			data : {
				id:10
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){
					var paIntroduction="";
					paIntroduction="<h4 align='center'><b>"+msg.czWorkIntroduction.title+"</b></h4>"
									+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.czWorkIntroduction.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
									"<span>所属类别：</span><span>"+msg.czWorkIntroduction.type+"</span><br />"
									+"<span>最后修改时间：</span><span>"+msg.czWorkIntroduction.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
									"<span>发布时间：</span><span>"+msg.czWorkIntroduction.publishTime+"</span></div><br />" +
									"<pre>"+msg.czWorkIntroduction.content+"</pre>";
					$("#seeworkflow1").empty().append(paIntroduction);
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
}
function time1(date)
{
	   var time= date;
	   var year = time.substring(0,4);
	   var month = time.substring(5,7);//月份要加1
	   var day = time.substring(8,10);
		var time1=year+"年"+month+"月"+day+"日"; 
	   return time1;
}
function time(date)
{
	   var time= new Date(date);
	   var year = time.getFullYear();
	   var month = time.getMonth()+1;//月份要加1
	   var day = time.getDate();
	   if(month<10)
		{
		   month ="0"+month;  
		}
	   if(day<10)
		{
		   day ="0"+day;  
		}
		var time1=year+"年"+month+"月"+day+"日";
	    return time1;
}