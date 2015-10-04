var list;//所有信息
var rightlist = new Array();// 存符合筛选条件的信息
var countlist;//统计信息
var user;
var page;//总页数
var num = 10;// 每页显示的最大数量
var instId;
var role;
$(document).ready(function() {
	// 查找相关信息
	selectquanbu();
});
//按学院查找
function academyChange(){
	var academyid = $("#academy").val();
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
				option += "<option value='0' selected='selected'>全部</option>";
				$.each(msg.major, function(key, val) {
					option += "<option value='" + val.majrId + "'>" + val.majrName + "</option>";
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
	var majorid = $("#major").val();
	var option = "";
	if(majorid == 0){
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
			}else{
				var str = "<tr><td>未查到学生</td></tr>";
				$("#tabletongji").empty().append(str);//清空 查不到就不显示
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
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
	var lstdstate = lstdshenhe(value[i]);
	var date = new Date(value[i].lstdClassopiniontime);
	//alert(date);
	str += "<tr><td>"+(i+1)+"</td>" 
			+"<td>"+value[i].stuName+"</td>"
			+"<td>"+value[i].stuNumber+"</td>"
			+"<td>"+value[i].departmentshortname+"</td>" 
			+"<td>"+value[i].stuMajor+"</td>"
			+"<td>"+value[i].stuClass+"</td>"
			+"<td>"+date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日"+"</td>" 
			+"<td>"+lstdstate+"</td>" ;
		var roleyz=0; 
		$.each(role,function(key,val){
			if(val.roleId == value[i].roleId){
				roleyz =1;
			}
		});
		if(roleyz == 1){
			str += "<td><a href='seeLsDetail.html?id="+value[i].lstdStudid+"&studNumber="+value[i].stuNumber+"' ><button type='button' class='btn btn-success btn-xs'>审核</button></a></td>"+"</tr>";
		}else{
			str += "<td><a href='seeLsDetail.html?id="+value[i].lstdStudid+"&studNumber="+value[i].stuNumber+"' ><button type='button' class='btn btn-success btn-xs'>查看详细</button></a></td>"+"</tr>";
		}
	}
	if(str!="<tr><th>#</th><th>姓名</th><th>学号</th><th>学 院 </th><th>专业</th><th>班级</th><th>申请时间</th><th>审核状态</th><th>操作</th></tr>")
		$("#tabletongji").empty().append(str);
	else{
		$("#tabletongji").empty().append("<tr><td><b style='color:red'>无查询信息</b></td></tr>");
		document.getElementById("fenye").style.display="none";//分页隐藏
		if(user.userType == 1){
			$("#tabletongji").empty().append("<tr><td><b style='color:red'>你没有申请绿色通道</b></td></tr>");
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
		//alert(academyid+""+majorid+""+classid);
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

function lstdshenhe(val){
	var lstdstate="";
	if(val.lstdState == 0){
		if(val.lstdWsflid == 42){
			lstdstate ="学生已填写申请";
		}else if(val.lstdWsflid == 43){
			lstdstate="待学办主任审核";
		}else if(val.lstdWsflid == 44){
			lstdstate="待学院分管书记审核";
		}else if(val.lstdWsflid == 45){
			lstdstate="待学生处审核";
		}
	}else{
		lstdstate="<font color='success'>审核完成</font>";
	}
	return lstdstate;
}

// 用来显示非本学院 已申请的学生
function applyRole(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/lstdController/findStudentByUserId.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var a=0;
				rightlist = new Array();
				$.each(msg.lstd, function(key, val) {
					if (instId !=  val.departmentId) {
						rightlist[a] = val;
						++a;
					}
					//alert(instId+"@"+val.departmentId);
				});
				//alert(rightlist.length);
				//此处page为筛选条件下的页数
				page = parseInt((rightlist.length + num - 1) / num);
				var fy = "<li><a href='javascript:paging(1," + 2 + ")'>&laquo;</a></li>";
				for ( var i = 1; i <= page; ++i) {
					fy += "<li id='" + i + "'><a href='javascript:paging(" + i + "," + 2 + ")'>" + i + "</a></li>";
				}
				fy += "<li id='" + i + "'><a href='javascript:paging(" + page + "," + 2 + ")'>&raquo;</a></li>";
				$("#controlbar").empty().append(fy);
				paging(1, 2);
				//lstdlist(msg);
			}else{
				var str ="<tr><th><font color='red'>无非本学院学生信息<font/></th></tr>";
				$("#tabletongji").empty().append(str);//清空 查不到就不显示
				document.getElementById("fenye").style.display="none";
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
//点击查询后按学号或身份证号查询
function searchbystudnumber(){
	var studNumber = $("#studNumber").val();
	if(studNumber.length != 8){
		document.getElementById("qingshuru").style.display="table-row";
	}else{
		document.getElementById("qingshuru").style.display="none";
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/lstdController/findStud.do',
			async : false,
			data : {
				studNumber:studNumber
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					var a=0;
					rightlist = new Array();
					$.each(msg.lstd, function(key, val) {
						if (studNumber ==  val.stuNumber) {
							rightlist[a] = val;
							++a;
						}
						//alert(studNumber+"@"+val.stuNumber);
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
				}else{
					var str ="<tr><th><font color='red'>学号、身份证号输入错误或此学生未申请</font></th></tr>";
					$("#tabletongji").empty().append(str);//清空 查不到就不显示
					document.getElementById("fenye").style.display="none";
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	}
	//var studNumber = $("#studNumber").val();
}

function selectquanbu(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/lstdController/findApplyList.do',
		async : false,
		data : {
			
		},
		success : function(msg) {
			if(msg.result == true){	
				list = msg.lstd;
				page = parseInt((msg.lstd.length + num - 1) / num);
				user = msg.user;
				role = msg.role;
				if(msg.user.userType == 1){
					document.getElementById("tablelist").style.display="none";
				}else if(msg.user.userType == 2){
					//alert("jinlail");
					document.getElementById("fenye").style.display="block";
					document.getElementById("tablelist").style.display="block";
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
					document.onkeydown = function(e){    
					    var ev = document.all ? window.event : e;  
					    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
					        //要处理的事件  
					    	document.getElementById("search").click(); //调用登录按钮的登录事件  
					    }
					  };
				}else if(msg.user.userType==3){//判断是不是当前功能的经办老师
					document.getElementById("fenye").style.display="block";
					document.getElementById("tablelist").style.display="block";
					//document.getElementById("tongji3").style.display="block";
					instId = msg.institution.instId;
					var button = "<tr>" +
									"<td><div><input type='text'class='form-control'id='studNumber'placeholder='请输入学号'/></div></td>" +
									"<td><button type='button'class='btn btn-primary' onclick='searchbystudnumber()'id='search'>查询</button></td>" +
									"<td><button type='button'class='btn btn-primary'onclick='selectquanbu()'>显示全部学生</button></td>" +
									"<td><button type='button'class='btn btn-primary'onclick='applyRole()'>显示非本学院学生</button></td>" +
									"<td><button type='button'class='btn btn-success'onclick='export1()'>" +
											"<span class='glyphicon glyphicon-share-alt'></span>导出Excel</button></td>" +
									"<td><div id='qingshuru'style='display:none'><font color='red'>请输入正确的学号</font><div></td></tr>";
					$("#tablelist").empty().append(button);
					document.onkeydown = function(e){    
					    var ev = document.all ? window.event : e;  
					    if(ev.keyCode==13) {
					    	document.getElementById("search").click(); 
					    }
					  };
				}else if(msg.user.userType==4||msg.user.userType==5){
					document.getElementById("fenye").style.display="block";
					document.getElementById("tablelist").style.display="block";
					document.getElementById("tongji3").style.display="block";
					document.getElementById("download").style.display="block";
					document.getElementById("academy").disabled="disabled";
					var optioni = "<option value='"+msg.institution.instId+"'>"+msg.institution.instName+"</option>";
					$("#academy").empty().append(optioni);
					var optionm="<option value=0>全部</option>";
					$.each(msg.major, function(key, val) {
						optionm += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
					});
					$("#major").empty().append(optionm);
					$("#studentclass").empty().append("<option value=0>班级</option>");
					document.onkeydown = function(e){
					    var ev = document.all ? window.event : e;  
					    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
					        //要处理的事件  
					    	document.getElementById("search").click(); //调用登录按钮的登录事件  
					    }
					  };
				}else{
					document.getElementById("fenye").style.display="block";
					document.getElementById("tablelist").style.display="block";
					document.getElementById("download").style.display="block";
					document.getElementById("tongji1").style.display="block";
					//document.getElementById("tongji2").style.display="block";
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
				//lstdlist(msg);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}

function export1(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/lstdController/export.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				//alert("已成功导出到d盘——lstdApply");
				var path = "/zzxt/lstdController/download.do?id=1&date="+ msg.date;
				location.href=path;
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function tongji(){
	document.getElementById("fenye").style.display="none";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/lstdController/countByAcademy.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				countlist = msg.countModals;
				
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	var str = "<tr><th>#</th>";
	if(user.userType == 2){
		str += "<th>班级</th><th>学生总人数</th>";
	}else if(user.userType == 6){
		str += "<th>学院</th><th>学院总人数</th>";
	}else{
		str += "<th>专业</th><th>专业总人数</th>";
	}
	str += "<th>申请人数</th><th>通过人数</th><th>申请比例</th><th>通过比例</th></tr>";
	for(var i=0;i<countlist.length;++i){
		var saveid;
		if(user.userType == 2){
			saveid = $("#studentclass").val();
		}else if(user.userType == 6){
			saveid = $("#academy").val();
		}else{
			saveid = $("#major").val();
			//alert(countlist[i].instid+"@@@"+saveid);
		}
		if(saveid==0)
			saveid = countlist[i].instid;
		if(saveid == countlist[i].instid){
			str += "<tr>";
			str += "<td>" + (i+1) + "</td>";
			str += "<td>" + countlist[i].name + "</td>";
			str += "<td>" + countlist[i].sum + "</td>";
			str += "<td>" + countlist[i].applysum + "</td>";
			str += "<td>" + countlist[i].passsum + "</td>";
			
			var t=0;
			t = parseInt((countlist[i].applysum*100)/countlist[i].sum);
			if(countlist[i].sum!=0)
				str += "<td>" + t+"%" + "</td>";
			else
				str += "<td>" + "--" + "</td>";
			
			var x=parseInt((countlist[i].passsum*100)/countlist[i].applysum);
			if(countlist[i].applysum!=0)
				str += "<td>" + x+"%" + "</td>";
			else
				str += "<td>" + "--" + "</td>";
			str += "</tr>";
		}
	}
	var strfoot = "<td><button id='fanhuifoot'class='btn btn-info'onclick='search()';>" +
	"<span class='glyphicon glyphicon-arrow-left'></span>返回</button></td>";
	str += "<tr>"+strfoot+"</tr>";
	//alert(str);
	$("#tabletongji").empty().append(str);
}
