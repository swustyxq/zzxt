/*author:Simon
 * Time:20140717*/
var flag = true;
var SaveorApply = true;//默认是Apply
$(document).ready(
		function() {
			bankNumber();phone();awardsituation();
			applyReason();checkYear();checkMonth();checkDay();
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/shjxjController/readStuShjxjInfo.do',
				async : false,
				data : {},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						if (msg.message == "loginout"){
							alert("用户已退出，请重新登录！");
							window.location.href = "login.html";
							return;
						}
						if (msg.state == false){//社会奖学金不为空
							if (msg.workstepfolw.wsflOrder != 1){
								$("#applyshjxj").empty().append("<h2>您本年度已经申请过社会奖学金!</h2>");
								/*setTimeout("window.location.href = 'seeSjList.html'",1000);*/
							}
						}
						if (msg.user.userType != 1) {//需要修改
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
						$("#sj-Instructor").empty().val(msg.instName);// 辅导员
						$("#sj-InstrPhone").empty().val(msg.instructor.instPhonenumber);// 联系电话
						if(msg.state == false){
							$("#sj-bankNumber").empty().val(msg.shjxj.sjxjBanknumber);//农行卡号
							$("#sj-StuDepartmentPhone").empty().val(msg.shjxj.sjxjInstructorcall);//学办电话
							$("#sj-PrizeSitu").empty().val(msg.shjxj.sjxjAwards);//受奖励情况
							$("#sj-ApplyReason").empty().val(msg.shjxj.sjxjApplyreason);//申请理由
							var strY = msg.date.substr(0,4);
							var strM = msg.date.substr(5,2);
							var strD = msg.date.substr(8,2);
							$("#sj-reasonYear").empty().val(strY);//申请时间
							$("#sj-reasonMonth").empty().val(strM);
							$("#sj-reasonDay").empty().val(strD);
							var obj1=document.getElementsByName("Radio1");
							if (msg.shjxj.sjxjIspoor == "是"){
								document.getElementById("sj-poorRank").style.display = "";
								document.getElementById("sj-poorText").style.display = "";
								obj1[0].checked = true;
								obj1[1].checked = false;
								var obj2=document.getElementsByName("Radio2");
								if (msg.shjxj.sjxjPoorrank == "一般困难"){
									obj2[0].checked = true;
									obj2[1].checked = false;
									obj2[2].checked = false;
								}else if(msg.shjxj.sjxjPoorrank == "困难"){
									obj2[0].checked = false;
									obj2[1].checked = true;
									obj2[2].checked = false;
								}else{
									obj2[0].checked = false;
									obj2[1].checked = false;
									obj2[2].checked = true;
								}
							}else{
								obj1[0].checked = false;
								obj1[1].checked = true;
							}
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

function save(){
	ApplyOrSave(false);
}
function apply(){
	ApplyOrSave(true);
}
function ApplyOrSave(SaveorApply){
	var sjBankNumber = $("#sj-bankNumber").val();
	var sjIspoor = "";
	var sjPoorRank = "";
	var obj1 = document.getElementsByName("Radio1");
	for ( var i = 0; i < obj1.length; i++) {
		if (obj1[i].checked == true) {
			if (i == 0) {
				sjIspoor = "是";
			} else {
				sjIspoor = "否";
			}
		}
	}
	if (sjIspoor == "是") {
		
		var obj2 = document.getElementsByName("Radio2");
		for ( var i = 0; i < obj2.length; i++) {
			if (obj2[i].checked == true) {
				if (i == 0) {
					sjPoorRank = "一般困难";
				} else if (i == 1) {
					sjPoorRank = "困难";
				} else {
					sjPoorRank = "特殊困难";
				}
			}
		}
	}
	var sjInstructor = $("#sj-Instructor").val();
	var sjInstrPhone = $("#sj-InstrPhone").val();
	var sjStuDepartmentPhone = $("#sj-StuDepartmentPhone").val();
	var sjPrizeSitu = $("#sj-PrizeSitu").val();
	var sjApplyReason = $("#sj-ApplyReason").val();
	var sjReasonYear = $("#sj-reasonYear").val();
	var sjReasonMonth = $("#sj-reasonMonth").val();
	var sjReasonDay = $("#sj-reasonDay").val();
	if (flag == true) {//输入数据通过js验证，均正确
		if (sjBankNumber != "" && sjIspoor != "" && sjPoorRank != "" && sjInstructor != ""
				&& sjInstrPhone != "" && sjStuDepartmentPhone != "" && sjPrizeSitu != ""
				&& sjApplyReason != "" && sjReasonYear != "" && sjReasonMonth != ""
				&& sjReasonDay != "" ) {//是否贫困的radio需要修改
			$("#sj-errorHint").empty();
			document.getElementById("sj-errorHint").style.display = "none";
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/shjxjController/addOneStudShjxj.do',
				async : false,
				data : {
					sjBankNumber : sjBankNumber,
					sjIspoor : sjIspoor,
					sjPoorRank : sjPoorRank,
					sjInstructor : sjInstructor,
					sjInstrPhone : sjInstrPhone,
					sjStuDepartmentPhone : sjStuDepartmentPhone,
					sjPrizeSitu : sjPrizeSitu,
					sjApplyReason : sjApplyReason,
					sjReasonYear : sjReasonYear,
					sjReasonMonth : sjReasonMonth,
					sjReasonDay : sjReasonDay,
					SaveorApply:SaveorApply,
				},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						if (msg.message == "loginout"){
							alert("用户已退出，请重新登录！");
							window.location.href = "login.html";
							return;
						}
						if (SaveorApply){
							alert("提交成功");
							window.location.href="seeSjList";
						}else{
							alert("保存成功");
						}
					} else {
						alert(msg.message);
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}
			});
		} else {
			$("#sj-errorHint").empty().append("<p style='color:red;'><b>请先完整填写申请内容！</b></p>");
			document.getElementById("sj-errorHint").style.display = "block";
		}
	} else {
		$("#sj-errorHint").empty().append("<p style='color:red;'><b>请修改红色的错误！</b></p>");
		document.getElementById("sj-errorHint").style.display = "block";
	}
}

function isPoor() {
	var obj2 = document.getElementsByName("Radio1");
	for ( var i = 0; i < obj2.length; i++) {
		if (obj2[i].checked) {
			if (i == 0) {
				document.getElementById("sj-poorRank").style.display = "";
				document.getElementById("sj-poorText").style.display = "";
			} else {
				document.getElementById("sj-poorRank").style.display = "none";
				document.getElementById("sj-poorText").style.display = "none";
			}
		}
	}
}

function bankNumber() {
	var banknumber = "";
	banknumber = $("#sj-bankNumber").val();
	var reg = /^\d{19}$/g;
	if (banknumber == "") {
		return;
	}
	if (!reg.test(banknumber)) {
		flag = false;
		document.getElementById("sj-bankNumber").style.color = "red";
	} else {
		flag = true;
		document.getElementById("sj-bankNumber").style.color = "black";
	}
}

function instructor() {
	var instructor = "";
	instructor = $("#sj-Instructor").val();
	var reg = /^[\u4E00-\u9FA5]+$/;
	if (instructor == "") {
		return;
	}
	if (!reg.test(instructor)) {
		flag = false;
		document.getElementById("sj-Instructor").style.color = "red";
	} else {
		flag = true;
		document.getElementById("sj-Instructor").style.color = "black";
	}
}

function telephone() {
	var telephoneNumber = "";
	telephoneNumber = $("#sj-InstrPhone").val();
	if (telephoneNumber == "") {
		return;
	}
	var reg = /1[3578]+\d{9}/;
	if (!reg.test(telephoneNumber)) {
		flag = false;
		document.getElementById("sj-InstrPhone").style.color = "red";
	} else {
		flag = true;
		document.getElementById("sj-InstrPhone").style.color = "black";
	}
}

function phone() {
	var phoneNumber = "";
	phoneNumber = $("#sj-StuDepartmentPhone").val();
	if (phoneNumber == "") {
		return;
	}
	var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
	if (!reg.test(phoneNumber)) {
		flag = false;
		document.getElementById("sj-StuDepartmentPhone").style.color = "red";
	} else {
		flag = true;
		document.getElementById("sj-StuDepartmentPhone").style.color = "black";
	}
}

function awardsituation() {
	var awardsituation = "";
	awardsituation = $("#sj-PrizeSitu").val();
	var reg = /^([\u4e00-\u9fa5]|[a-z]|[A-Z]|[0-9]|[\r\n]|[!]|[！]|[,]|[ ]|[，]|[、]|["]|[“]|[”]|[.]|[。]|[?]|[？]|[:]|[：]|[\/]|[\\]|[(]|[)]|[（]|[）]|[\[]|[\]]){0,200}$/;// 限制字数200
	if (!reg.test(awardsituation)) {
		alert("只能输入汉字、字母、数字、基本标点符号！");
		// document.getElementById("sj-PrizeSitu").fontcolor = "red";
		flag = false;
	} else {
		flag = true;
	}
}

function applyReason() {
	var applyReasons = "";
	applyReasons = $("#sj-ApplyReason").val();
	var reg = /^([\u4e00-\u9fa5]|[a-z]|[A-Z]|[0-9]|[\r\n]|[!]|[！]|[,]|[ ]|[，]|[、]|["]|[“]|[”]|[.]|[。]|[?]|[？]|[:]|[：]|[\/]|[\\]|[(]|[)]|[（]|[）]|[\[]|[\]]){0,200}$/;// 限制字数200
	if (!reg.test(applyReasons)) {
		alert("只能输入汉字、字母、数字、基本标点符号！");
		flag = false;
	} else {
		flag = true;
	}
}
///^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/
function checkYear(){
	//document.getElementsByTagName("input")[0].getAttribute("id");
	//alert(document.getElementsByTagName("input")[1].getAttribute("id"));
	var year = "";
	year = $("#sj-reasonYear").val();
	if (year == "") {
		return;
	}
	var reg = /[1-9]+\d{3}/;
	if (!reg.test(year)) {
		flag = false;
		document.getElementById("sj-reasonYear").style.color = "red";
	} else {
		flag = true;
		document.getElementById("sj-reasonYear").style.color = "black";
	}
}

function checkMonth(){
	var month = "";
	month = $("#sj-reasonMonth").val();
	if (month == "") {
		return;
	}
	var reg = /1[0-2]|[1-9]/;
	if (!reg.test(month)) {
		flag = false;
		document.getElementById("sj-reasonMonth").style.color = "red";
	} else {
		flag = true;
		document.getElementById("sj-reasonMonth").style.color = "black";
	}
}

function checkDay(){
	var day = "",year="",month="";
	day = $("#sj-reasonDay").val();
	month = $("#sj-reasonMonth").val();
	year = $("#sj-reasonYear").val();
	if (month == "" || year == "" || day == "") {
		return;
	}
	var reg;
	if (month == 1||month == 3||month == 5||month== 7||month == 8||month == 10||month == 12){
		reg = /^[1-9]|1[0-9]|2[0-9]|3[01]$/;
	}else if (month != 2){
		reg = /^[1-9]|1[0-9]|2[0-9]|30$/;
	}else{
		if (year % 400 == 0 || (year%400!=0&&year%4==0)){
			reg = /^[1-9]|1[0-9]|2[0-9]$/;
		}else{
			reg = /^[1-9]|1[0-9]|2[0-8]$/;
		}
	}
	if (!reg.test(day)) {
		flag = false;
		document.getElementById("sj-reasonDay").style.color = "red";
	} else {
		flag = true;
		document.getElementById("sj-reasonDay").style.color = "black";
	}
}