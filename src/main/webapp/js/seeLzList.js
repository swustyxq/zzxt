var list;//所有信息
var rightlist = new Array();// 存符合筛选条件的信息
var countlist;//统计信息
var user;
var page;//总页数
var num = 20;// 每页显示的最大数量
var instId;

$(document).ready(function() {
	// 查找相关信息
	selectquanbu();
});

//按学院查找
function academyChange(){
	var academyid = $("#academy").val();
	//alert(academyid);
	var option = "";
	var op1 = "<option value='0'>专业</option>";
	var op2 = "<option value='0'>班级</option>";
	if(academyid == "0"){
		$("#major").empty().append(op1);
	}
	$("#studentclass").empty().append(op2);
	//联动的实现
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/findMajor.do',
		async : false,
		data : {
			academyid : academyid
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				option += "<option value=\"0\" selected=\"selected\">全部</option>";
				$.each(msg.major, function(key, val) {
					option += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
				});
				$("#major").empty().append(option);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	
}
function majorChange() {
	//var academyid = $("#academy").val();
	var majorid = $("#major").val();
	var option = "";
	if(majorid == "0"){
		var op1 = "<option value='0'>班级</option>";
		$("#studentclass").empty().append(op1);
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/findClass.do',
		async : false,
		data : {
			majorid : majorid
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				option += "<option value=\"0\" selected=\"selected\">全部</option>";
				$.each(msg.stuclass, function(key, val) {
					option += "<option value=\"" + val.classId + "\">" + val.classShortname + "</option>";
				});
				$("#studentclass").empty().append(option);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	
}
//点击查询后按学号查询
function search() {
	var a=0;
	rightlist = new Array();
	$.each(list, function(key, val) {
		var academyid = $("#academy").val();
		var majorid = $("#major").val();
		var classid = $("#studentclass").val();
		if (academyid == "0")
			academyid = val.departmentId;
		if (majorid == "0")
			majorid = val.majorId;
		if (classid == "0")
			classid = val.classId;
		if (academyid == val.departmentId && majorid == val.majorId && classid == val.classId) {
			rightlist[a] = val;
			//alert(rightlist.length);
			++a;
		}
		//alert(academyid+"@"+majorid+"@"+classid);
	});
	//此处page为筛选条件下的页数
	page = parseInt((rightlist.length + num - 1) / num);
	var fy = "<li><a href='javascript:paging(1," + 2 + ")'>&laquo;</a></li>";
	for ( var i = 1; i <= page; ++i) {
		fy += "<li id='" + i + "'><a href='javascript:paging(" + i + "," + 2 + ")'>" + i + "</a></li>";
	}
	fy += "<li id='" + i + "'><a href='javascript:paging(" + page + "," + 2 + ")'>&raquo;</a></li>";
	$("#controlbar").empty().append(fy);
	paging(1, 2);
}

function gjlzjxjshenhe(val){
	var gjlzjxjstate="";
	if(val.gjlzState == 0){
		if(val.gjlzWsflid == 16){
			gjlzjxjstate ="学生已填写申请";
		}else if(val.gjlzWsflid == 17){
			gjlzjxjstate="待辅导员审核";
		}else if(val.gjlzWsflid == 18){
			gjlzjxjstate="待经办老师审核";
		}else if(val.gjlzWsflid == 19){
			gjlzjxjstate="待学办主任审核";
		}else if(val.gjlzWsflid == 20){
			gjlzjxjstate="待学院分管书记审核";
		}else if(val.gjlzWsflid == 21){
			gjlzjxjstate="待学生处审核";
		}
	}else{
		gjlzjxjstate="<font color='success'>审核完成</font>";
	}
	return gjlzjxjstate;
}
function paging(n,flag){
	$("#fenye").css("display",""); 
	$("#reInfo").empty();
	$("#sumpage").text(page);
	var min = (n - 1) * num;
	var max = n * num;
	var str = "<tr><th>#</th><th>姓名</th><th>学号</th><th>学 院 </th><th>专业</th><th>班级</th><th>申请时间</th><th>审核状态</th><th>操作</th></tr>";
	var value;
	if (flag == 1)
		value = list;
	else
		value = rightlist;
	for ( var i = min; i < max; ++i) {
		if (i >= value.length)
			break;
	var gjlzstate = gjlzjxjshenhe(value[i]);
	var date = new Date(value[i].gjlzApplyreasontime);
	str += "<tr><td>"+(i+1)+"</td>" 
			+"<td>"+value[i].stuName+"</td>"
			+"<td>"+value[i].stuNumber+"</td>"
			+"<td>"+value[i].departmentshortname+"</td>" 
			+"<td>"+value[i].stuMajor+"</td>"
			+"<td>"+value[i].stuClass+"</td>"
			+"<td>"+date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日"+"</td>" //这儿的申请时间暂时为设置
			+"<td>"+gjlzstate+"</td>" 
			+"<td><a href='seeLzDetail.html?id="+value[i].gjlzStudid+"&studNumber="+value[i].stuNumber+"' target='_blank'><button type='button' class='btn btn-success btn-xs'>查看详细</button></a></td>"+"</tr>";
	}
	if(str!="<tr><th>#</th><th>姓名</th><th>学号</th><th>学 院 </th><th>专业</th><th>班级</th><th>申请时间</th><th>审核状态</th><th>操作</th></tr>")
		$("#tabletongji").empty().append(str);
	else{
		$("#tabletongji").empty().append("<tr><td><b style='color:red'>无查询信息</b></td></tr>");
		document.getElementById("fenye").style.display="none";//分页隐藏
		if(user.userType == 1){
			$("#tabletongji").empty().append("<tr><td><b style='color:red'>你没有申请国家励志奖学金</b></td></tr>");
		}
	}
	var left = 0;
	var sum = 5;
	var right = sum - left;
	for ( var j = 1; j <= page; ++j) {
		if (page - n >= 2) {
			right = sum - left;
			if (j == n) {
				$("#" + j).css("display", "");
				$("#" + j).attr("class", "active");
			} else if (j < n && j >= n - 2) {
				++left;
				$("#" + j).css("display", "");
				$("#" + j).attr("class", "");
			} else if (j > n && j < n + right) {
				$("#" + j).css("display", "");
				$("#" + j).attr("class", "");
			} else {
				$("#" + j).css("display", "none");
			}
		} else {
			right = page - n;
			left = sum - right;
			if (j == n) {
				$("#" + j).css("display", "");
				$("#" + j).attr("class", "active");
			} else if (j < n && j > n - left) {
				$("#" + j).css("display", "");
				$("#" + j).attr("class", "");
			} else if (j > n && j <= n + right) {
				$("#" + j).css("display", "");
				$("#" + j).attr("class", "");
			} else {
				$("#" + j).css("display", "none");
			}
		}
	}
}
function selectquanbu(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjlzjxjController/findApplyList.do',
		async : false,
		data : {
				
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				list = msg.gjlzjxj;
				user = msg.user;
				page = parseInt((msg.gjlzjxj.length + num - 1) / num);
				if(msg.user.userType == 1){
					document.getElementById("tablelist").style.display="none";
				}else if(msg.user.userType == 2){
					document.getElementById("tablelist").style="block";
					document.getElementById("tongji4").style.display="block";
					document.getElementById("download").style.display="block";
					document.getElementById("academy").disabled="disabled";
					var optioni = "<option value='"+msg.institution.instId+"'>"+msg.institution.instName+"</option>";
					$("#academy").empty().append(optioni);
					var optionm="<option value = 0>全部</option>";
					$.each(msg.major, function(key, val) {
						optionm += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
					});
					$("#major").empty().append(optionm);
				}else if(msg.user.userType==3){
					document.getElementById("tablelist").style.display="block";
					document.getElementById("tongji3").style.display="block";
					document.getElementById("download").style.display="block";
					document.getElementById("academy").disabled="disabled";
					var optioni = "<option value='"+msg.institution.instId+"'>"+msg.institution.instName+"</option>";
					$("#academy").empty().append(optioni);
					var optionm="<option value = 0>全部</option>";
					$.each(msg.major, function(key, val) {
						optionm += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
					});
					$("#major").empty().append(optionm);
				}else if(msg.user.userType==4||msg.user.userType==5){
					document.getElementById("tablelist").style.display="block";
					document.getElementById("download").style.display="block";
					document.getElementById("tongji3").style.display="block";
					document.getElementById("academy").disabled="disabled";
					var optioni = "<option value='"+msg.institution.instId+"'>"+msg.institution.instName+"</option>";
					$("#academy").empty().append(optioni);
					var optionm="<option value=0>全部</option>";
					$.each(msg.major, function(key, val) {
						optionm += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
					});
					$("#major").empty().append(optionm);
				}else{
					document.getElementById("tablelist").style.display="block";
					document.getElementById("tongji1").style.display="block";
					document.getElementById("download").style.display="block";
					document.onkeydown = function(e){    
					    var ev = document.all ? window.event : e;  
					    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
					        //要处理的事件  
					    	document.getElementById("search").click(); //调用登录按钮的登录事件  
					    }
					  };
				}
				var fy = "<li><a href='javascript:javascript:paging(1," + 1 + ")'>&laquo;</a></li>";
				for ( var i = 1; i <= page; ++i) {
					fy += "<li id='" + i + "'><a href='javascript:paging(" + i + "," + 1
							+ ")'>" + i + "</a></li>";
				}
					fy += "<li id='" + i + "'><a href='javascript:paging(" + page + "," + 1
							+ ")'>&raquo;</a></li>";
				$("#controlbar").empty().append(fy);
				paging(1, 1);
				if(user.userType == 1)document.getElementById("fenye").style.display="none";
				
					
			} else {
				alert(msg.message);
				//window.location.href = "login.html";
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function export1(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjlzjxjController/export.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var path = "/zzxt/gjlzjxjController/download.do?id=1&date="+ msg.date;
				location.href=path;
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}