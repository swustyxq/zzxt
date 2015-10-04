var list;// 存所有信息
var rightlist = new Array();// 存符合筛选条件的信息
var page;// 存总页数
var num = 20;// 每页显示的最大数量
var countlist;//统计信息
var roleid;
$(document).ready(		
		function() {
			document.onkeydown = function(e){    
			    var ev = document.all ? window.event : e;  
			    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
			        //要处理的事件  
			    	document.getElementById("serchbut").click(); //调用登录按钮的登录事件  
			    }
			  };
			  var tablehead = "<tr><th>#</th><th>姓名</th><th>学号</th><th>学院</th><th>专业</th><th>班级</th><th>申请年度</th><th>申请状态</th><th>操作</th></tr>";
				$("#biaotou").empty().append(tablehead);
				$("#listbody").empty().append("<td colspan='9' align='center'>加载中，请稍候。。</td>");
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
						var table = "";
						var i = 0;
						list = msg.listModals;
						roleid = msg.role;
						if (msg.role == 1) {
							$("#fenye").empty()
							$("#chaxun").empty();
							$.each(msg.listModals, function(key, val) {
								++i;
								table += "<tr>";
								table += "<td>" + i + "</td>";
								table += "<td>" + val.name + "</td>";
								table += "<td>" + val.stunumber + "</td>";
								table += "<td>" + val.academy + "</td>";
								table += "<td>" + val.major + "</td>";
								table += "<td>" + val.stuclass + "</td>";
								table += "<td>" + val.annual + "</td>";
								table += "<td>" + val.statusdescript + "</td>";
								table += "<td><a target='_blank' href=\"/zzxt/htmls/seeGjDetail.html?listid=" + val.listid + "&stuid="
										+ val.stuid + "&type=1" + "\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看</button></a></td>";
								table += "</tr>";
							});
							$("#listbody").empty().append(table);
						} else if (msg.role >= 2) {
							countlist = msg.count;
							page = parseInt((msg.listModals.length + num - 1) / num);
							var fy = "<li><a href='javascript:showpage(1," + 1 + ")'>&laquo;</a></li>";
							for ( var i = 1; i <= page; ++i) {
								fy += "<li id='" + i + "'><a href='javascript:showpage(" + i + "," + 1
										+ ")'>" + i + "</a></li>";
							}
							fy += "<li id='" + i + "'><a href='javascript:showpage(" + page + "," + 1
									+ ")'>&raquo;</a></li>";
							$("#controlbar").empty().append(fy);
							showpage(1, 1);
							if(msg.role<15){
								$("#academy").val(msg.instid);
								$("#academy").attr("disabled","disabled");
								academyChange();
							}
						}
					} else {
						alert(msg.message);
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}
			});
			$("#download").click(function(){
				var academyid = $("#academy").val();
				var majorid = $("#major").val();
				var classid = $("#classinfo").val();
				$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					url : '/zzxt/gjjxjController/export.do',
					async : false,
					data : {
						academyid : academyid,
						majorid:majorid,
						classid:classid
					},
					dataType : 'json',
					success : function(msg) {
						if (msg.result == true) {
							location.href="/zzxt/gjjxjController/download.do?academyid="+academyid+"&majorid="+majorid+"&classid="+classid;
							/*var path = "/zzxt/gjjxjController/download.do?id=1&date="+ msg.date;
							location.href=path;*/
						}
					},
					error : function(msg) {
						alert("网络超时！");
					}
				});
				
			});
});

function academyChange() {
	var academyid = $("#academy").val();
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
	var a=0;
	rightlist = new Array();
	$.each(list, function(key, val) {
		var academyid = $("#academy").val();
		var majorid = $("#major").val();
		var classid = $("#classinfo").val();
		if (academyid == "0")
			academyid = val.academyid;
		if (majorid == "0")
			majorid = val.majorid;
		if (classid == "0")
			classid = val.stuclassid;
		if (academyid == val.academyid && majorid == val.majorid && classid == val.stuclassid) {
			rightlist[a] = val;
			++a;
		}
		
	});
	page = parseInt((rightlist.length + num - 1) / num);
	var fy = "<li><a href='javascript:showpage(1," + 2 + ")'>&laquo;</a></li>";
	for ( var i = 1; i <= page; ++i) {
		fy += "<li id='" + i + "'><a href='javascript:showpage(" + i + "," + 2 + ")'>" + i + "</a></li>";
	}
	fy += "<li id='" + i + "'><a href='javascript:showpage(" + page + "," + 2 + ")'>&raquo;</a></li>";
	$("#controlbar").empty().append(fy);
	showpage(1, 2);
}

function showpage(n, flag) {
	$("#fenye").css("display",""); 
	$("#reInfo").empty();
	$("#sumpage").text(page);
	var min = (n - 1) * num;
	var max = n * num;
	var tablehead = "<tr><th>#</th><th>姓名</th><th>学号</th><th>学院</th><th>专业</th><th>班级</th><th>申请年度</th><th>申请状态</th><th>操作</th></tr>";
	$("#biaotou").empty().append(tablehead);
	var table = "";
	var value;
	if (flag == 1)
		value = list;
	else
		value = rightlist;
	for ( var i = min; i < max; ++i) {
		if (i >= value.length)
			break;
		table += "<tr>";
		table += "<td>" + (i + 1) + "</td>";
		table += "<td>" + value[i].name + "</td>";
		table += "<td>" + value[i].stunumber + "</td>";
		table += "<td>" + value[i].academy + "</td>";
		table += "<td>" + value[i].major + "</td>";
		table += "<td>" + value[i].stuclass + "</td>";
		table += "<td>" + value[i].annual + "</td>";
		table += "<td>" + value[i].statusdescript + "</td>";
		if (value[i].type == 1) {
			table += "<td><a target='_blank' href=\"/zzxt/htmls/seeGjDetail.html?listid=" + value[i].listid + "&stuid="
					+ value[i].stuid + "&type=1"
					+ "\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看</button></a></td>";
		} else if (value[i].type == 2) {
			table += "<td><a target='_blank' href=\"/zzxt/htmls/seeGjDetail.html?listid=" + value[i].listid + "&stuid="
					+ value[i].stuid + "&type=2"
					+ "\"><button type=\"button\" class=\"btn btn-warning btn-xs\">审核</button></a>";
		}
		table += "</tr>";
	}
	if(table!="")
		$("#listbody").empty().append(table);
	else
		$("#listbody").empty().append("<tr><td><b style='color:red'>无搜索信息</b></td></tr>");
	var left = 0;
	var sum = 5;
	var right = sum - left;
	for ( var j = 1; j <= page; ++j) {
		// document.getElementById("#"+j).style.display='none';

		// if(j==n)
		// $("#"+j).attr("class","active");
		// else
		// $("#"+j).attr("class","");
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

function conunt() {

	var tablehead = "<tr><th>#</th>";
	if (roleid >= 15) {
		tablehead += "<th>学院</th>";
	} else if (roleid == 2) {
		tablehead += "<th>班级</th>";
	} else {
		tablehead += "<th>专业</th>";
	}
	tablehead+="<th>申请人数</th><th>通过人数</th><th>总人数</th><th>申请率</th><th>通过率</th></tr>"
	$("#biaotou").empty().append(tablehead);
	var table = "";
	for ( var i = 0; i < countlist.length; ++i) {
		var flaginfo;
		if (roleid >= 15) {
			flaginfo = $("#academy").val();
		} else if (roleid == 2) {
			flaginfo = $("#classinfo").val();
		} else {
			flaginfo = $("#major").val();
		}
		if (flaginfo == 0)
			flaginfo = countlist[i].instid;
		if (flaginfo == countlist[i].instid) {
			table += "<tr>";
			table += "<td>" + (i + 1) + "</td>";
			table += "<td>" + countlist[i].name + "</td>";
			table += "<td>" + countlist[i].applysum + "</td>";
			table += "<td>" + countlist[i].passsum + "</td>";
			table += "<td>" + countlist[i].sum + "</td>";
			var t = 0;
			t = parseInt((countlist[i].applysum * 100) / countlist[i].sum);
			if (countlist[i].sum != 0)
				table += "<td>" + t + "%" + "</td>";
			else
				table += "<td>" + "--" + "</td>";

			var x = parseInt((countlist[i].passsum * 100) / countlist[i].applysum);
			if (countlist[i].applysum != 0)
				table += "<td>" + x + "%" + "</td>";
			else
				table += "<td>" + "--" + "</td>";
			table += "</tr>";
		}
	}
	$("#fenye").css("display", "none");
	$("#reInfo")
			.empty()
			.attr("align", "center")
			.append(
					"<button id='serchbut' class='btn btn-primary' onclick='javascript:serch()' type='button'>以当前条件返回</button>");
	$("#listbody").empty().append(table);
}