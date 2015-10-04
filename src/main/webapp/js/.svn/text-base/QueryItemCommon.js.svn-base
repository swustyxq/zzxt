/*Author:Yang Junhui
 * Time:20140727
 * Function:根据不同用户，动态加载和更新查询范围*/

var InstitutionName = new Array();
var InstitutionId = new Array();
var majorName = new Array();
var majorId = new Array();
var className = new Array();
var classId = new Array();
var userType = 0;

$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/showOneUserMsg.do',
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
				userType = msg.user.userType;
				if (userType >= 6){
					showAllColleages();
				}else{//确定一个学院，并把学院下拉框disabled掉
					$("#colleage1").empty().append(msg.institution.instName);//学院名字
					document.getElementById("colleage").disabled = true;
					if (userType >= 3 && userType <= 5){
						showAllMajorSelective(msg.user.userInstid);//学院Id
					}else if (userType == 2){//确定辅导员所带的专业
						var majorList = "<option>全部</option>";
						$.each(msg.majors, function(key, val){
							majorName[key] = val.majrName;
							majorId[key] = val.majrId;
							majorList += "<option>"+ val.majrName +"</option>";
						});
						$("#major").empty().append(majorList);
					}else if (userType == 1){//学生，只允许查询年度，将别的条件disabled掉
						$("#major1").empty().append(msg.oneMajor.majrName);//专业名字
						document.getElementById("major").disabled = true;
						$("#stuclass1").empty().append(msg.oneClass.className);//班级名字
						document.getElementById("stuclass").disabled = true;
					}
				}
			} else {
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
});

function showAllColleages(){
	var colleageList = "<option>全部</option>";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/shjxjController/showAllColleages.do',
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
				userType = msg.user.userType;
				if (userType == 6 ){
					$.each(msg.institutions, function(key, val){
						InstitutionName[key] = val.instName;
						InstitutionId[key] = val.instId;
						if (val.instName != "学生工作处" && val.instName != "校医院"){
							colleageList += "<option>"+ val.instName +"</option>";
						}
					});
				}
			} else {
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	$("#colleage").empty().append(colleageList);
}

function confirmColleage(){//响应页面
	if (userType >= 6){
		var institution = $("#colleage").val();
		var k=0;
		for (var i = 0;i < InstitutionId.length;i++){
			if (institution == InstitutionName[i]){
				showAllMajorSelective(InstitutionId[i]);
				k=1;
			}
		}
		if(k==0)
		{
		$("#major").empty().append("<option>全部</option>");
		$("#stuclass").empty().append("<option>全部</option>");
		}
	}
}

function showAllMajorSelective(institutionId){
	var majorList = "<option>全部</option>";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/shjxjController/showMajors.do',
		async : false,
		data : {
			institutionId:institutionId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.message == "loginout"){
					alert("用户已退出，请重新登录！");
					window.location.href = "login.html";
					return;
				}
				$.each(msg.majors, function(key, val){
					majorName[key] = val.majrName;
					majorId[key] = val.majrId;
					majorList += "<option>"+ val.majrName +"</option>";
				});
			} else {
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	$("#major").empty().append(majorList);
}

function confirmMajor(){//响应页面
	if (userType >= 2){
		var themajor = $("#major").val();
		var k=0;
		for (var i = 0;i < majorId.length;i++){
			if (themajor == majorName[i]){
				showAllClassSelective(majorId[i]);
				k=1;
			}
		}
		if(k==0)
		{
		$("#stuclass").empty().append("<option>全部</option>");
		}
	}
}

function showAllClassSelective(OnemajorId){
	var classList = "<option>全部</option>";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/shjxjController/showClasses.do',
		async : false,
		data : {
			OnemajorId:OnemajorId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.message == "loginout"){
					alert("用户已退出，请重新登录！");
					window.location.href = "login.html";
					return;
				}
				$.each(msg.stuclassesList, function(key, val){
					classList += "<option>"+ val.className +"</option>";
				});
			} else {
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	$("#stuclass").empty().append(classList);
}