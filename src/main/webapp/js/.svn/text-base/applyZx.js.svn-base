/*author:zxr
 * 2014.07.13
 * 完成了申请表的添加 修改未实现*/

$(document).ready(function() {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/studentController/readStudentByStudNumber.do',
		async : false,
		data : {

		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var date1 = new Date();
				var date2 = new Date(msg.work.workStarttime);
				var date3 = new Date(msg.work.workEndtime);
				if (date1 > date2 && date1 < date3) {
				} else {
					alert("系统暂未开启！");
					history.go(-1);
				}
				$("#stu-class-discription").html(msg.studentInfo.stinDepartment);// 学院
				$("#stu-class-name").html(msg.studentClass.className);// 班级
				$("#stu-name").html(msg.student[0].studName);// 姓名
				$("#stu-sex").html(msg.studentInfo.stinSex);// 性别
				$("#stu-birthday").html(msg.student[0].studBirthday);// 生日
				$("#politicState").html(msg.studentInfo.stinPoliticstate);// 政治面貌
				$("#stu-nation").html(msg.student[0].studNation);// 名族
				$("#stu-admissionTime").html(msg.student[0].studAdmissiontime);// 入学时间
				$("#majrName").html(msg.major.majrName);// 专业
				$("#stuphone").html(msg.studentInfo.stinPhone);// 电话
				$("#stu-idNumber").html(msg.student[0].studIdnumber);// 身份证号码

				// $("#gjlzResidence").val(msg.gjlzjxjwithblobs.gjlzResidence);//家庭户口===户口类型
				// alert(msg.gjlzjxjwithblobs.gjlzResidence);

				$("#familySum").val(msg.studentInfo.stinPopulation);// 家庭人口总数
				$("#allIncomes").val(msg.studentInfo.stinAllincomes);// 家庭月总收入
				$("#personalIncomes").val(parseInt(msg.studentInfo.stinAllincomes / msg.studentInfo.stinPopulation));// 人均月收入
				$("#incomeType").val(msg.studentInfo.stinIncometype);// 收入来源
				$("#mailcode").html(msg.studentInfo.stinMailcode);// 邮政编码
				$("#home").html(msg.studentInfo.stinAreadeatilhome);// 家庭详细地址
				var obj1 = document.getElementsByName("residence");
				if (msg.studentInfo.stinResidence == "农村") {
					obj1[0].checked = "checked";
				} else {
					obj1[1].checked = "checked";
				}

				// $("#gjlzRanking").val(msg.gjlzjxj.gjlzRanking);//成绩排名
				if (msg.gjzxjWithBLOBs != null) {
					if (msg.workstepfolw != null) {
						if (msg.workstepfolw.wsflOrder > 1) {
							alert("已提交过申请，请等待审核！");
							location.href = "/zzxt/htmls/seeZxList.html?pareid=10&funid=41";
							return;
						}
					} else {
						alert("已提交过申请，请等待审核！");
						location.href = "/zzxt/htmls/seeZxList.html?pareid=10&funid=41";
					}
					$("#residence").empty().val(msg.gjzxjWithBLOBs.gzxjResidence);
					$("#familySum").empty().val(msg.gjzxjWithBLOBs.gzxjPopulation);// 家庭人口总数
					$("#allIncomes").val(msg.gjzxjWithBLOBs.gzxjAllincomes);// 家庭月总收入
					$("#personalIncomes").val(parseInt(msg.gjzxjWithBLOBs.gzxjAllincomes / msg.studentInfo.stinPopulation));// 人均月收入
					$("#incomeType").val(msg.gjzxjWithBLOBs.gzxjIncometype);// 收入来源
					//$("#annual").val(msg.gjzxjWithBLOBs.gzxjAnnual);
					$("#applyReason").val(msg.gjzxjWithBLOBs.gzxjApplyreason);
				}
				showPareInfo();
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});

	/*
	 * 作者：赵学融 20140713 点击之后提交信息
	 */
	$("#comitApplyGjzxj").click(function() {
		var politicState = $("#politicState").text();// 政治
		var residence;// 户口
		var familySum = $("#familySum").val();// 人数
		var applyReason = $("#applyReason").val();// 申请理由
		var classDetail = $("#stu-class-discription").text() + $("#stu-class-name").text();// 班级信息
		var allIncomes = $("#allIncomes").val();// 总收入
		var incomeType = $("#incomeType").val();// 收入来源
		var mailcode = $("#mailcode").text();// 邮编
		var home = $("#home").text();// 家庭住址
		var annual = "2014-2015";// 年度
		var level = $("#level").val();
		function CheckRadio() {
			var temp = document.getElementsByName("residence");
			for ( var i = 0; i < temp.length; i++) {
				if (temp[i].checked) {
					residence = temp[i].value;
				}
			}

		}

		function Check() {
			if (residence == "" || applyReason == "" || annual == "" || familySum == "" || allIncomes=="" || incomeType=="") {
				alert("请仔细填完所有项！");
				return false;
			}
			var annualCheck = /20\d{2}\W{1}20\d{2}/;
			if (!annualCheck.test(annual)) {
				alert("请正确填写年度信息！\r\t例：2012至2013");
				return false;
			}
			if(isNaN(familySum) == true || familySum <= 0){
				alert("家庭人数信息错误！");
				return false;
			}
			if(isNaN(allIncomes) == true){
				alert("家庭收入信息错误！");
				return false;
			}
			return true;
		}
		CheckRadio();
		if (Check()) {
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/gjzxjController/addGjzxjApply.do',
				async : false,
				data : {
					politicState : politicState,
					residence : residence,
					familySum : familySum,
					applyReason : applyReason,
					classDetail : classDetail,
					allIncomes : allIncomes,
					incomeType : incomeType,
					mailcode : mailcode,
					home : home,
					annual : annual,
					workId : 10,
					level : level
				},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						alert("已提交过申请，请等待审核！");
						location.href = "/zzxt/htmls/seeZxList.html";
					} else {
						alert(msg.message);
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}
			});
		}
	});

	$("#saveGjzxj").click(function() {
		var politicState = $("#politicState").text();// 政治
		var residence;// 户口
		var familySum = $("#familySum").val();// 人数
		var applyReason = $("#applyReason").val();// 申请理由
		var classDetail = $("#stu-class-discription").text() + $("#stu-class-name").text();// 班级信息
		var allIncomes = $("#allIncomes").val();// 总收入
		var incomeType = $("#incomeType").val();// 收入来源
		var mailcode = $("#mailcode").text();// 邮编
		var home = $("#home").text();// 家庭住址
		var annual ="2014-2015"; //$("#annual").val();// 年度
		var level = $("#level").val();
		function CheckRadio() {
			var temp = document.getElementsByName("residence");
			for ( var i = 0; i < temp.length; i++) {
				if (temp[i].checked) {
					residence = temp[i].value;
				}
			}

		}

		function Check() {
			if (residence == "" || applyReason == "" || annual == "" || familySum == "" || allIncomes=="" || incomeType=="") {
				alert("请仔细填完所有项！");
				return false;
			}
			var annualCheck = /20\d{2}\W{1}20\d{2}/;
			if (!annualCheck.test(annual)) {
				alert("请正确填写年度信息！\r\t例：2012至2013");
				return false;
			}
			if(isNaN(familySum) == true || familySum<=0){
				alert("家庭人数信息错误！");
				return false;
			}
			if(isNaN(allIncomes) == true){
				alert("家庭收入信息错误！");
				return false;
			}
			return true;
		}
		CheckRadio();
		if (Check()) {
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/gjzxjController/saveGjzxjApply.do',
				async : false,
				data : {
					politicState : politicState,
					residence : residence,
					familySum : familySum,
					applyReason : applyReason,
					classDetail : classDetail,
					allIncomes : allIncomes,
					incomeType : incomeType,
					mailcode : mailcode,
					home : home,
					annual : annual,
					workId : 10,
					level : level
				},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						alert("已保存！");
					} else {
						alert(msg.message);
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}
			});
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
			studId : -1,
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
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
