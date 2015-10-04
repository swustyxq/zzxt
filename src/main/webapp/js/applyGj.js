var rawardFlagId = new Array("-1", "-1", "-1", "-1");
var prizeFlagId = new Array("-1", "-1", "-1", "-1");
var gjjxjFlag = -1;

$(document).ready(function() {

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjjxjController/readStudentByStudNumber.do',
		async : false,
		data : {
			stuid : -1,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				/* applyLz.html中的内容 */
				var date1 = new Date();
				var date2 = new Date(msg.work.workStarttime);
				var date3 = new Date(msg.work.workEndtime);
				if (date1 > date2 && date1 < date3) {
				} else {
					alert("系统暂未开启！");
					history.go(-1);
				}
				$("#stinDepartment").empty().append(msg.studentInfo.stinDepartment);// 学院
				$("#studNumber").empty().append(msg.student.studNumber);// 学号
				$("#studName").empty().append(msg.student.studName);// 姓名
				$("#stinSex").empty().append(msg.studentInfo.stinSex);// 性别
				$("#studBirthday").empty().append(msg.student.studBirthday);// 生日
				$("#stinPoliticstate").empty().append(msg.studentInfo.stinPoliticstate);// 政治面貌
				$("#studNation").empty().append(msg.student.studNation);// 名族
				$("#studAdmissiontime").empty().append(msg.student.studAdmissiontime);// 入学时间
				$("#majrName").empty().append(msg.major.majrName);// 专业
				$("#majrEducationsystem").empty().append(msg.major.majrEducationsystem);// 学制
				$("#stinPhone").empty().append(msg.studentInfo.stinPhone);// 电话
				$("#studIdnumber").empty().append(msg.student.studIdnumber);// 身份证号码
				// 家庭户口===户口类型 单选框
				var obj1 = document.getElementsByName("radio1");
				for ( var i = 0; i < obj1.length; i++) {
					obj1[i].checked = false;
				}
				if (msg.studentInfo.stinResidence == "农村") {
					obj1[0].checked = "checked";
				} else {
					obj1[1].checked = "checked";
				}

				$("#stinPopulation").empty().append(msg.studentInfo.stinPopulation);// 家庭人口总数
				$("#stinAllincomes").empty().append(msg.studentInfo.stinAllincomes);// 家庭月总收入
				$("#renjunyueshouru").empty().append(parseInt(msg.studentInfo.stinAllincomes / msg.studentInfo.stinPopulation));// 人均月收入
				$("#stinIncometype").empty().append(msg.studentInfo.stinIncometype);// 收入来源
				$("#stinMailcode").empty().append(msg.studentInfo.stinMailcode);// 邮政编码
				$("#stinAreadeatilhome").empty().append(msg.studentInfo.stinAreadeatilhome);// 家庭详细地址
				if (msg.learning != null) {
					$("#learRequirednumber").empty().append(msg.learning[0].learRequirednumber);// 必修课
					$("#learPassnumber").empty().append(msg.learning[0].learPassnumber);// 及格以上
				}
				readGjjxj();
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
});

function readGjjxj() {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjjxjController/obtainGjjxjByStudNumber.do',
		async : false,
		data : {
			listid : -1,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.gjjxjWithBLOBS != null) {
					if (msg.workstepfolw.wsflOrder > 1) {
						alert("已提交过申请，请等待审核！");
						location.href = "/zzxt/htmls/seeGjList.html?pareid=10&funid=41";
						return;
					}
				}else{
					alert("已提交过申请，请等待审核！");
					location.href = "/zzxt/htmls/seeGjList.html?pareid=10&funid=41";
				}
				gjjxjFlag = msg.gjjxjWithBLOBS.gjxjId;
				$("#mingci").empty().val(msg.ranking[0]);
				$("#zongrenshu").empty().val(msg.ranking[1]);
				$("#gjjxjApplyreason").empty().val(msg.gjjxjWithBLOBS.gjxjApplyreason);
				readRewards(msg.gjjxjWithBLOBS.gjxjId);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function readRewards(schoolershipId) {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjjxjController/findRewardByWorkId.do',
		async : false,
		data : {
			schoolershipId : schoolershipId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var dataId = "";
				var prizeNameId = "";
				var prizeAwareId = "";
				$.each(msg.rewards, function(key, val) {
					dataId = "data" + key;
					prizeNameId = "prizeName" + key;
					prizeAwareId = "prizeAwar" + key;
					$("#" + dataId).val(val.rewrTime);
					$("#" + prizeNameId).val(val.rewrName);
					$("#" + prizeAwareId).val(val.rewrAwarded);
					rawardFlagId[key] = val.rewrId;
				});
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function onclick1() {
	var ob = document.getElementsByName("radio2");
	for ( var i = 0; i < ob.length; i++) {
		if (ob[i].checked) {
			if (i == 1) {
				document.getElementById("paiming").disabled = true;
				document.getElementById("paiming").placeholder = "";
				document.getElementById("mingcizongrenshu").disabled = true;
				document.getElementById("mingcizongrenshu").placeholder = "";
			} else {
				document.getElementById("paiming").disabled = false;
				document.getElementById("paiming").placeholder = "请输入";
				document.getElementById("mingcizongrenshu").disabled = false;
				document.getElementById("mingcizongrenshu").placeholder = "请输入";
			}
		}
	}
}

function selectPrize(labId) {
	$("#selectPrize").modal("show");
	var contentThings = "";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjjxjController/getAllPrize.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				contentThings += "<tr><th>日期</th><th>获奖名称</th><th>颁奖单位</th><th>操作</th></tr>";
				$.each(msg.prizes, function(key, val) {
					var flag = 0;
					for ( var i = 0; i < 4; ++i) {
						if (val.prizId == prizeFlagId[i])
							flag = 1;
					}
					if (flag != 1) {
						var time = val.prizTime;
						var name = val.prizName;
						var awarded = val.prizAwarded;
						contentThings += "<tr>" + "<td>" + val.prizTime + "</td>" + "<td >" + val.prizName + "</td>"
								+ "<td >" + val.prizAwarded + "</td>" + "<td><a href=\"javascript:addPrize(" + labId
								+ ",\'" + time + "\',\'" + name + "\',\'" + awarded + "\'," + val.prizId + ")\">"
								+ "添加" + "</a>" + "</td></tr>";
					}
					$("#selectModal").empty().append(contentThings);
				});
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function addPrize(labId, time, name, awarded, prizeid) {
	var dataId = "data" + labId;
	var prizeNameId = "prizeName" + labId;
	var prizeAwareId = "prizeAwar" + labId;
	$("#" + dataId).val(time);
	$("#" + prizeNameId).val(name);
	$("#" + prizeAwareId).val(awarded);
	prizeFlagId[labId] = prizeid;
	$("#selectPrize").modal("hide");
}

function deletePrize(labId) {
	var dataId = "data" + labId;
	var prizeNameId = "prizeName" + labId;
	var prizeAwareId = "prizeAwar" + labId;
	$("#" + dataId).empty().val("");
	$("#" + prizeNameId).empty().val("");
	$("#" + prizeAwareId).empty().val("");
	prizeFlagId[labId] = -1;
}

function submitGjjxj() {
	var comprehensive;
	var temp = document.getElementsByName("radio2");
	for ( var i = 0; i < temp.length; i++) {
		if (temp[i].checked) {
			comprehensive = temp[i].value;
		}
	}

	var paiming = $("#paiming").val();
	var mingcizongrenshu = $("#mingcizongrenshu").val();

	var stinPoliticstate = $("#stinPoliticstate").text();// 政治面貌
	var applyReason = $("#gjjxjApplyreason").val();
	var mingci = $("#mingci").val();
	var zongrenshu = $("#zongrenshu").val();
	var time = new Array();
	var name = new Array();
	var awaer = new Array();

	for ( var i = 0; i < 4; ++i) {
		var dataId = "data" + i;
		var prizeNameId = "prizeName" + i;
		var prizeAwareId = "prizeAwar" + i;
		time[i] = $("#" + dataId).val();
		name[i] = $("#" + prizeNameId).val();
		awaer[i] = $("#" + prizeAwareId).val();
	}
	if (check()) {
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/gjjxjController/submitRewardsInfo.do',
			async : false,
			data : {
				rawardFlagId0 : rawardFlagId[0],
				rawardFlagId1 : rawardFlagId[1],
				rawardFlagId2 : rawardFlagId[2],
				rawardFlagId3 : rawardFlagId[3],
				time0 : time[0],
				name0 : name[0],
				awaer0 : awaer[0],
				time1 : time[1],
				name1 : name[1],
				awaer1 : awaer[1],
				time2 : time[2],
				name2 : name[2],
				awaer2 : awaer[2],
				time3 : time[3],
				name3 : name[3],
				awaer3 : awaer[3],
				gjjxjFlag : gjjxjFlag,
				mingci : mingci,
				zongrenshu : zongrenshu,
				stinPoliticstate : stinPoliticstate,
				comprehensive : comprehensive,
				paiming : paiming,
				mingcizongrenshu : mingcizongrenshu,
				applyReason : applyReason,
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {

					alert(msg.message);
					location.reload(true);
				} else {
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	}
}

function saveGjjxj() {
	var comprehensive;
	var temp = document.getElementsByName("radio2");
	for ( var i = 0; i < temp.length; i++) {
		if (temp[i].checked) {
			comprehensive = temp[i].value;
		}
	}

	var paiming = $("#paiming").val();
	var mingcizongrenshu = $("#mingcizongrenshu").val();

	var stinPoliticstate = $("#stinPoliticstate").text();// 政治面貌
	var applyReason = $("#gjjxjApplyreason").val();
	var mingci = $("#mingci").val();
	var zongrenshu = $("#zongrenshu").val();
	var time = new Array();
	var name = new Array();
	var awaer = new Array();

	for ( var i = 0; i < 4; ++i) {
		var dataId = "data" + i;
		var prizeNameId = "prizeName" + i;
		var prizeAwareId = "prizeAwar" + i;
		time[i] = $("#" + dataId).val();
		name[i] = $("#" + prizeNameId).val();
		awaer[i] = $("#" + prizeAwareId).val();
	}
	if (check()) {
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/gjjxjController/saveRewardsInfo.do',
			async : false,
			data : {
				rawardFlagId0 : rawardFlagId[0],
				rawardFlagId1 : rawardFlagId[1],
				rawardFlagId2 : rawardFlagId[2],
				rawardFlagId3 : rawardFlagId[3],
				time0 : time[0],
				name0 : name[0],
				awaer0 : awaer[0],
				time1 : time[1],
				name1 : name[1],
				awaer1 : awaer[1],
				time2 : time[2],
				name2 : name[2],
				awaer2 : awaer[2],
				time3 : time[3],
				name3 : name[3],
				awaer3 : awaer[3],
				gjjxjFlag : gjjxjFlag,
				mingci : mingci,
				zongrenshu : zongrenshu,
				stinPoliticstate : stinPoliticstate,
				comprehensive : comprehensive,
				paiming : paiming,
				mingcizongrenshu : mingcizongrenshu,
				applyReason : applyReason,
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {

					alert(msg.message);
					location.reload(true);
				} else {
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	}
}

function check() {
	var applyReason = $("#gjjxjApplyreason").val();
	var mingci = $("#mingci").val();
	var zongrenshu = $("#zongrenshu").val();
	if (mingci == null || mingci == "" || zongrenshu == null || zongrenshu == "") {
		$("#cjpm").append("<br/><font color=\"red\">成绩排名不能为空</font>");
		return false;
	}
	if (applyReason == null) {
		$("#sqly").append("<br/><font color=\"red\">申请理由不能为空</font>");
		return false;
	}
	return true;
}
