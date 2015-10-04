var list;//保存班级信息
var teachrlist;//保存辅导员信息
var institution;//保存学院信息
var laoshi=new Array();
var allTeacher;
$(document).ready(
		function() {

			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/academyRoleController/getInstrator.do',
				async : false,
				data : {

				},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						var table = "";
						var i = 0;
						list = msg.studentclasses;
						teachrlist = msg.teacher;
						institution = msg.institution;
						allTeacher = msg.allTeacherList;
						selectMajor();// 选择专业
						$.each(msg.studentclasses, function(key, val) {
							++i;
							table += "<tr>";
							table += "<td>" + i + "</td>";
							table += "<td>" + val.className + "</td>";
							table += "<td>" + msg.institution.instShortname + "</td>";
							var flag = "xuanze" + key;
							table += "<td><select id=\"" + flag + "\" class=\"form-control\">";
							$.each(msg.teacher, function(i, temp) {
								if (temp.instid == val.classInstid) 
									table += "<option selected=\"selected\" value=\"" + temp.instid + "\">" + temp.name
											+ "</option>";
								else
									table += "<option value=\"" + temp.instid + "\">" + temp.name + "</option>";
							});
							table += "</select></td>";
							table += "<td><a href=\"javascript:edit(\'" + flag + "\'," + val.classId + ")"
									+ "\"><button type=\"button\" class=\"btn btn-success btn-xs\">确认更改</button></a></td>";
							table += "</tr>";
						});
						$("#listbody").empty().append(table);
						for(var i=1;i<=10;++i){
							showls(i);
						}
					} else {
						alert(msg.message);
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}
			});
			$("#download1").click(function(){
				var majorid = $("#major").val();
				var classid = $("#classinfo").val();
				$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					url : '/zzxt/academyRoleController/export1.do',
					async : false,
					data : {
						majorid:majorid,
						classid:classid
					},
					dataType : 'json',
					success : function(msg) {
						if (msg.result == true) {
							location.href="/zzxt/academyRoleController/download1.do?"+"majorid="+majorid+"&classid="+classid;
						}
					},
					error : function(msg) {
						alert("网络超时！");
					}
				});
				
			});
			
			$("#download2").click(function(){
				$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					url : '/zzxt/academyRoleController/export2.do',
					async : false,
					data : {
					},
					dataType : 'json',
					success : function(msg) {
						if (msg.result == true) {
							location.href="/zzxt/academyRoleController/download2.do";
						}
					},
					error : function(msg) {
						alert("网络超时！");
					}
				});
				
			});
		});

function selectMajor() {
	var option = "";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/findMajor.do',
		async : false,
		data : {
			academyid : institution.instId,
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
				} else {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$("#major").empty().append(option);
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
					$("#classinfo").empty().append(option);
				} else {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$("#classinfo").empty().append(option);
				}
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function serch() {
	var table = "";
	$.each(list, function(key, val) {
		var majorid = $("#major").val();
		var classid = $("#classinfo").val();
		if (majorid == "0")
			majorid = val.classMajrid;
		if (classid == "0")
			classid = val.classId;
		if (majorid == val.classMajrid && classid == val.classId) {
			table += "<tr>";
			table += "<td>" + key + "</td>";
			table += "<td>" + val.className + "</td>";
			table += "<td>" + institution.instShortname + "</td>";
			var flag = "xuanze" + key;
			table += "<td><select id=\"" + flag + "\" class=\"form-control\">";
			$.each(teachrlist, function(i, temp) {
				if (temp.instid == val.classInstid)
					table += "<option selected=\"selected\" value=\"" + temp.instid + "\">" + temp.name + "</option>";
				else
					table += "<option value=\"" + temp.instid + "\">" + temp.name + "</option>";
			});
			table += "</select></td>";
			table += "<td><a href=\"javascript:edit(\'" + flag + "\'," + val.classId + ")" + "\"><button type=\"button\" class=\"btn btn-success btn-xs\">确认更改</button></a></td>";
			table += "</tr>";
		}
	});
	$("#listbody").empty().append(table);
}

function edit(flag, classid) {
	var instid = 0;
	instid = $("#" + flag).val();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/academyRoleController/editClass.do',
		async : false,
		data : {
			classid : classid,
			instid : instid,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert("更改成功！");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function showls(i){
	var id="ls"+i;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/academyRoleController/showLs.do',
		async : false,
		data : {
			roleid:i+2
		},
		dataType : 'json',
		success : function(msg) {
			var table = "";
			if (msg.result == true) {
				laoshi[i-1] = msg.laoshi; 
				$.each(msg.laoshi, function(key, val) {
					table += val.userName;
					table += ",";
				});
			}
			$("#"+id).empty().append(table);
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}


function editjb(i){
	var id = i-2;
	$("#modaltitle").text($("#titel"+id).text());
	var table = "";
	$.each(allTeacher, function(key, val) {
		table += "<tr>";
		var num = key+1;
		table +="<td>"+ num +"</td>";
		var flag = 0;
		$.each(laoshi[id-1], function(x, temp) {
			if(val.userId==temp.userId)
				flag = 1;
		});
		if(flag==1)
			table += "<td>"+"<input type='checkbox' name='allList' style='disabled:false' checked='checked' value='"+val.userId+"'></td>";
		else
			table += "<td>"+"<input type='checkbox' name='allList' style='disabled:false'  value='"+val.userId+"'></td>";
		table +="<td>"+val.userName+"</td>";
		table +="<td>"+val.userLoginname+"</td>";
		table += "</tr>";			
	});
	$("#selectJb").empty().append(table);
	$("#ok").attr("onclick","javascript:save("+i+")");
	$("#changeJb").modal('show');
}

function save(i){
	var choice = document.getElementsByName("allList");
	for(var j=0;j<choice.length;++j){
		if(choice[j].checked){
			addjb(i,allTeacher[j].userId);
		}else{
			deletejb(i,allTeacher[j].userId);
		}
	}
	alert("操作成功！");
	showls(i-2);
	$("#changeJb").modal('hide');
	
}

function addjb(i,userid){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/academyRoleController/addJb.do',
		async : false,
		data : {
			roleid:i,
			userid:userid
		},
		dataType : 'json',
		success : function(msg) {
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function deletejb(i,userid){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/academyRoleController/deleteJb.do',
		async : false,
		data : {
			roleid:i,
			userid:userid
		},
		dataType : 'json',
		success : function(msg) {
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}