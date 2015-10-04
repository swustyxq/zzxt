var studId = 0;

$(document).ready(function() {
	var Request = new Object();// 页面响应请求，得到学生id
	Request = GetRequest();
	if (Request != null) {
		studId = Request['id'];
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/shjxjController/showStuAllShjxjInfo.do',
		async : false,
		data : {
			studId : studId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.message == "loginout") {
					alert("用户已退出，请重新登录！");
					window.location.href = "login.html";
					return;
				}
				if (msg.state == true) {//该学生本年度的社会奖学金为空
					document.getElementById("sjapplyAll").innerHTML = "<h2>您没有申请社会奖学金！</h2>";
					document.getElementById("sjapplyAll").style.display = "block";
					return false;
				}else{
					if (msg.maxroleId == 1 && msg.wsflRoldId == msg.maxroleId){
						document.getElementById("modify").style.display = "table-row";
					}
				}
				var result = "";
				if (msg.maxroleId != 1 && msg.wsflRoldId == msg.maxroleId){
					result += "<button type='submit' class='btn btn-primary' id='pass'"
						    + "onclick='checkresult(true)'><b>通过</b></button>&nbsp;&nbsp;&nbsp;&nbsp;"
				            + "<button type='submit' class='btn btn-primary' id='notpass'"
				            + "onclick='checkresult(false)'><b>驳回</b></button>&nbsp;&nbsp;&nbsp;&nbsp;"
					        + "<button type='reset' class='btn btn-primary' id='returnToIndex'"
					         + "onclick='history.go(-1)''><b>返回</b></button>";
					$("#result").empty().append(result);
				}
				document.getElementById("sjapplyAll").style.display = "block";
				if (msg.user.userType != 1) {// 需要修改
					document.getElementById("sj-colleagerow").style.display = "table-row";
					document.getElementById("sj-colleaderowtext").style.display = "table-row";
				}
				$("#sj-stuName").empty().append(msg.student.studName);// 姓名
				$("#sj-stuSex").empty().append(msg.studentInfo.stinSex);// 性别
				$("#sj-stuNation").empty().append(msg.student.studNation);// 民族
				$("#sj-stubirth").empty().append(msg.student.studBirthday);// 出生年月
				$("#sj-stuPhone").empty().append(msg.studentInfo.stinPhone);// 手机
				// $("#sj-stuSex").empty().append(msg.studentInfo.stinSex);//座机,没有座机了
				$("#sj-stuColleage").empty().append(msg.institution.instName);// 学院
				$("#sj-stuClass").empty().append(msg.studentclass.className);// 专业班级
				$("#sj-stuNumber").empty().append(msg.student.studNumber);// 学号
				$("#sj-stuIDNumber").empty().append(msg.student.studIdnumber);// 身份证号码
				$("#sj-bankNumber").empty().append(msg.shjxj.sjxjBanknumber);// 农行卡号
				$("#sj-Instructor").empty().append(msg.shjxj.sjxjInstructor);// 辅导员
				$("#sj-InstrPhone").empty().append(msg.shjxj.sjxjInstructorphone);// 联系电话
				$("#sj-StuDepartmentPhone").empty().append(msg.shjxj.sjxjInstructorcall);// 学办电话
				$("#sj-PrizeSitu").empty().append(msg.shjxj.sjxjAwards);// 受奖励情况
				$("#sj-ApplyReason").empty().append(msg.shjxj.sjxjApplyreason);// 申请理由
				$("#sj-reasonDate").empty().append(msg.date);// 申请时间
				var obj1 = document.getElementsByName("Radio1");
				if (msg.shjxj.sjxjIspoor == "是") {
					document.getElementById("sj-poorRank").style.display = "";
					document.getElementById("sj-poorText").style.display = "";
					obj1[0].checked = true;
					obj1[1].checked = false;
					var obj2 = document.getElementsByName("Radio2");
					if (msg.shjxj.sjxjPoorrank == "一般困难") {
						obj2[0].checked = true;
						obj2[1].checked = false;
						obj2[2].checked = false;
					} else if (msg.shjxj.sjxjPoorrank == "困难") {
						obj2[0].checked = false;
						obj2[1].checked = true;
						obj2[2].checked = false;
					} else {
						obj2[0].checked = false;
						obj2[1].checked = false;
						obj2[2].checked = true;
					}
				} else {
					obj1[0].checked = false;
					obj1[1].checked = true;
				}
			} else {
				alert("网络超时！");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	
	
});

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

function checkresult(result){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/shjxjController/checkApply.do',
		async : false,
		data : {
			result:result,
			studId:studId,
		},  
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.message == "loginout"){
					alert("用户已退出，请重新登录！");
					window.location.href = "login.html";
					return;
				}
				if (result){
					alert("审核通过");
				}else{
					alert("驳回成功");
				}
				history.go(-1);
			} else {
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
