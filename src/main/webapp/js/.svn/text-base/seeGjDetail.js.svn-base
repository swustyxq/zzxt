var studId = 0;
var listId = 0;
var type = 0;
 var rawardFlagId = new Array("-1", "-1", "-1", "-1");
$(document).ready(function() {
	var Request = new Object();
	Request = GetRequest();

	if (Request != null) {
		studId = Request['stuid'];
		listId = Request['listid'];
		type = Request['type'];
	}
	var tr1 = document.getElementById("classtable");
	tr1.style.display = 'table-row';
	var tr2 = document.getElementById("academytable");
	tr2.style.display = 'table-row';
	if (type != 2) {
		$("#mingci").attr("disabled", "disabled");
		$("#zongrenshu").attr("disabled", "disabled");
		$("#data0").attr("disabled", "disabled");
		$("#prizeName0").attr("disabled", "disabled");
		$("#prizeAwar0").attr("disabled", "disabled");
		$("#data1").attr("disabled", "disabled");
		$("#prizeName1").attr("disabled", "disabled");
		$("#prizeAwar1").attr("disabled", "disabled");
		$("#data2").attr("disabled", "disabled");
		$("#prizeName2").attr("disabled", "disabled");
		$("#prizeAwar2").attr("disabled", "disabled");
		$("#data3").attr("disabled", "disabled");
		$("#prizeName3").attr("disabled", "disabled");
		$("#prizeAwar3").attr("disabled", "disabled");
		$("#academyOption").attr("disabled", "disabled");
		$("#gjjxjApplyreason").attr("disabled", "disabled");
		$("#classOption").attr("disabled", "disabled");
		document.getElementById("paiming").disabled = true;
		document.getElementById("mingcizongrenshu").disabled = true;
		$("#gjxjComprehensiveYes").attr("disabled", "disabled");
		$("#gjxjComprehensiveNo").attr("disabled", "disabled");
		$("#gongneng").empty();
	}else
		$("#fanhui").empty();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjjxjController/readStudentByStudNumber.do',
		async : false,
		data : {
			stuid:studId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
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
				$("#renjunyueshouru").empty().append(msg.studentInfo.stinAllincomes / msg.studentInfo.stinPopulation);// 人均月收入
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
			listid:listId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				gjjxjFlag = msg.gjjxjWithBLOBS.gjxjId;
				$("#mingci").empty().val(msg.ranking[0]);
				$("#zongrenshu").empty().val(msg.ranking[1]);
				$("#gjjxjApplyreason").empty().val(msg.gjjxjWithBLOBS.gjxjApplyreason);
				$("#classOption").empty().val(msg.gjjxjWithBLOBS.gjxjAcademyopinion);
				$("#academyOption").empty().val(msg.gjjxjWithBLOBS.gjxjSchoolopinion);
				var obj2 = document.getElementsByName("radio2");
				for ( var i = 0; i < obj2.length; i++) {
					obj2[i].checked = false;
				}
				if (msg.gjjxjWithBLOBS.gjxjComprehensive == "是") {
					obj2[0].checked = "checked";
					if(type!=1){
						document.getElementById("paiming").disabled = false;
						document.getElementById("mingcizongrenshu").disabled = false;
					}
					$("#paiming").val(msg.comprehensiveRanking[0]);
					$("#mingcizongrenshu").val(msg.comprehensiveRanking[1]);
				} else {
					obj2[1].checked = "checked";
					document.getElementById("paiming").disabled = true;
					document.getElementById("paiming").placeholder = "";
					document.getElementById("mingcizongrenshu").disabled = true;
					document.getElementById("mingcizongrenshu").placeholder = "";
				}
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
			schoolershipId : listId,	
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

function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();

	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for ( var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	if (url.indexOf("id") == -1) {
		theRequest = null;
	}
	return theRequest;
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

function audit(auditid) {
	var comprehensive;
	var temp = document.getElementsByName("radio2");
	for ( var i = 0; i < temp.length; i++) {
		if (temp[i].checked) {
			comprehensive = temp[i].value;
		}
	}
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
	var mingci = $("#mingci").val();
	var zongrenshu = $("#zongrenshu").val();
	var paiming = $("#paiming").val();
	var mingcizongrenshu = $("#mingcizongrenshu").val();
	var applyReason = $("#gjjxjApplyreason").val();
	var classOption = $("#classOption").val();
	var academyOption = $("#academyOption").val();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjjxjController/auditGjjxjApply.do',
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
			comprehensive:comprehensive,
			paiming:paiming,
			mingcizongrenshu:mingcizongrenshu,
			mingci:mingci,
			zongrenshu:zongrenshu,
			gjjxjid : listId,
			auditid : auditid,
			applyReason : applyReason,
			classOption : classOption,
			academyOption : academyOption,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert("处理成功!");
				if(auditid!=0)
					location.href = "/zzxt/htmls/seeGjList.html";
			}else{
				alert("处理失败！");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}