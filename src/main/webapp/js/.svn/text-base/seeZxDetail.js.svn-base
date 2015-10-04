	var studId = 0;
	var listId = 0;
	var type = 0;

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
		$("#incomeType").attr("disabled", "disabled");
		$("#allIncomes").attr("disabled", "disabled");
		$("#personalIncomes").attr("disabled", "disabled");
		$("#familySum").attr("disabled", "disabled");
		$("#classOption").attr("disabled", "disabled");
		$("#academyOption").attr("disabled", "disabled");
		$("#applyReason").attr("disabled", "disabled");
		$("#level").attr("disabled", "disabled");
		$("#gongneng").empty();
	}else
		$("#fanhui").empty();

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/readStudentByStudNumber.do',
		async : false,
		data : {
			studId : studId,
			listId : listId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				$("#stu-class-discription").html(msg.studentInfo.stinDepartment);// 学院
				$("#stu-class-name").html(msg.studentClass.className);// 班级

				$("#stu-name").html(msg.student.studName);// 姓名
				$("#stu-sex").html(msg.studentInfo.stinSex);// 性别
				$("#stu-birthday").html(msg.student.studBirthday);// 生日
				$("#politicState").html(msg.studentInfo.stinPoliticstate);// 政治面貌
				$("#stu-nation").html(msg.student.studNation);// 名族
				$("#stu-admissionTime").html(msg.student.studAdmissiontime);// 入学时间
				$("#majrName").html(msg.major.majrName);// 专业
				$("#stuphone").html(msg.studentInfo.stinPhone);// 电话
				$("#stu-idNumber").html(msg.student.studIdnumber);// 身份证号码

				// $("#gjlzResidence").val(msg.gjlzjxjwithblobs.gjlzResidence);//家庭户口===户口类型
				// alert(msg.gjlzjxjwithblobs.gjlzResidence);

				$("#familySum").val(msg.studentInfo.stinPopulation);// 家庭人口总数
				$("#allIncomes").val(msg.studentInfo.stinAllincomes + 0);// 家庭月总收入
				$("#personalIncomes").val(msg.studentInfo.stinAllincomes / msg.studentInfo.stinPopulation);// 人均月收入
				$("#incomeType").val(msg.studentInfo.stinIncometype);// 收入来源
				$("#mailcode").html(msg.studentInfo.stinMailcode);// 邮政编码
				$("#home").html(msg.studentInfo.stinAreadeatilhome);// 家庭详细地址
				// $("#gjlzRanking").val(msg.gjlzjxj.gjlzRanking);//成绩排名
				// alert(msg.gjzxjWithBLOBs.gzxjAllincomes);
				if (msg.gjzxjWithBLOBs != null) {
					$("#residence").empty().html(msg.gjzxjWithBLOBs.gzxjResidence);
					$("#familySum").empty().val(msg.gjzxjWithBLOBs.gzxjPopulation);// 家庭人口总数
					$("#allIncomes").val(msg.gjzxjWithBLOBs.gzxjAllincomes);// 家庭月总收入
					$("#personalIncomes").val(msg.gjzxjWithBLOBs.gzxjAllincomes / msg.studentInfo.stinPopulation);// 人均月收入
					$("#incomeType").val(msg.gjzxjWithBLOBs.gzxjIncometype);// 收入来源
					if (msg.gjzxjWithBLOBs.gzxjState != 1) {
						$("#station").empty().html("审核中");
					} else {
						$("#station").empty().html("已批准");
					}
					$("#annual").empty().html(msg.gjzxjWithBLOBs.gzxjAnnual);
					$("#level").val(msg.gjzxjWithBLOBs.gzxjLevel);
					$("#applyReason").empty().html(msg.gjzxjWithBLOBs.gzxjApplyreason);
					$("#classOption").empty().html(msg.gjzxjWithBLOBs.gzxjClassopinion);
					$("#academyOption").empty().html(msg.gjzxjWithBLOBs.gzxjAcademyopinion);
				}
				showPareInfo();
				var a = 10;
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {

			alert("网络超时！");
		}
	});
});

function showPareInfo() {
	var namelist = new Array();
	var rolelist = new Array();
	var relationlist = new Array();
	var worklist = new Array();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/studentController/showPareInfo.do',
		async : false,
		data : {
			studId:studId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				$.each(msg.parentsList, function(key, val) {
					namelist.push(val.pareName);
					rolelist.push(val.pareRole);
					relationlist.push(val.pareRelation);
					worklist.push(val.pareWork);
				});

				for ( var i = 0; i < namelist.length, i < 3; i++) {
					var type = i + 1;
					var nameId = "#gzxj_pareName" + type;
					var roleId = "#gzxj_pareRole" + type;
					var relationId = "#gzxj_pareRelation" + type;
					var workId = "#gzxj_pareWork" + type;
					$(nameId).html(namelist[i]);
					$(roleId).html(rolelist[i]);
					$(relationId).html(relationlist[i]);
					$(workId).html(worklist[i]);
				}
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

function audit(auditid) {
	var familySum = $("#familySum").val();
	var allIncomes = $("#allIncomes").val();
	var incomeType = $("#incomeType").val();
	var applyReason = $("#applyReason").val();
	var classOption = $("#classOption").val();
	var academyOption = $("#academyOption").val();
	var level = $("#level").val();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/auditGjzxjApply.do',
		async : false,
		data : {
			gjzxjid : listId,
			auditid : auditid,
			familySum : familySum,
			allIncomes : allIncomes,
			incomeType : incomeType,
			applyReason : applyReason,
			classOption : classOption,
			academyOption : academyOption,
			level:level
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert("处理成功!");
				if(auditid!=0)
					location.href = "/zzxt/htmls/seeZxList.html";
			}else{
				alert("处理失败！");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}