	var arrayLearingId = new Array();
	var arrayLearingsem = new Array();
	var arrayLearingrank = new Array();
	var arrayLearingpass = new Array();
	var arrayLearingreq = new Array();
	var arrayLearingselect = new Array();
	var arrayLearingtotal = new Array();
	var arrayLearingisComp = new Array();
	var arrayLearingCompRank = new Array();
	var arrayLearingComptotal = new Array();
	//布尔变量，用于判断当点击“提交”时，是代表“添加true”，还是代表“修改flase”
	var AddorModify = true;
	var graderank;
	var passcourse;
	var requiredcourse;
	var selectcourse;
	var toatlNumber;
	var gradepoint;
	var requirepoint;
	var comprank=0;
	var comtotoalnumvalue=0;
	//布尔变量，用于判断当点击“提交”插入一条学习情况时，所有信息是否符合规定
	var flag = true;
$(document).ready(function() {
	//showallLearing();
	// 响应确定按钮，往数据库插入学习情况新数据
	$("#changestuInfo").click(function() {
		judgeRank();
		if (flag == true){
			var semester = $("#semester").val();
			graderank = $("#grade_rank").val();
			passcourse = $("#pass_course").val();
			requiredcourse = $("#required_course").val();
			selectcourse = $("#select_course").val();
			toatlNumber = $("#totalNum").val();
			gradepoint = $("#gradepoint").val();
			requirepoint = $("#requirepoint").val();
			var iscompreRank = $("#iscompRank").val();
			if ($("#comp_rankvalue").val() != null){
				comprank = $("#comp_rankvalue").val();
			}
			if ($("#com_totoalnumvalue").val() != null){
				comtotoalnumvalue = $("#com_totoalnumvalue").val();
			}
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/learningController/addormodifyStuLearing.do',
				async : false,
				data : {
					addormodify:AddorModify,
					semester : semester,
					graderank : graderank,
					passcourse : passcourse,
					requiredcourse : requiredcourse,
					selectcourse : selectcourse,
					toatlNumber : toatlNumber,
					gradepoint:gradepoint,
					requirepoint:requirepoint,
					iscompreRank : iscompreRank,
					comprank : comprank,
					comtotoalnumvalue : comtotoalnumvalue,
				},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						if (msg.message == "loginout"){
							alert("用户已退出，请重新登录！");
							window.location.href = "login.html";
						}
						if (AddorModify){
							alert("插入成功！");
						}else{
							alert("修改成功！");
						}
						$("#learingmodal").modal('hide');
						showallLearing();
					} else {
						alert("插入失败！");
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}
			});
		}
	});

});

function identifylearing() {
	graderank = $("#grade_rank").val();
	toatlNumber = $("#totalNum").val();
	comprank = $("#comp_rankvalue").val();
	comtotoalnumvalue = $("#com_totoalnumvalue").val();
	if (isInteger(graderank) && isInteger(toatlNumber) && isInteger(comprank)
			&& isInteger(comtotoalnumvalue)) {
		flag = true;
	} else {
		flag = flase;
	}
}

function judgeRank() {
	var numValue = document.getElementById("iscompRank").value;
	if (numValue == "是") {
		document.getElementById("comprank").style.display = "table-row";
	} else {
		document.getElementById("comprank").style.display = "none";
	}
}

// 验证是否是整数
function isInteger(str) {
	var regu = /^[-]{0,1}[0-9]{1,}$/;
	if (!regu.test(str)) {
		alert("请输入一个整数");
		return false;
	}
	return true;
}

function showallLearing() {
	var Learinglist = "";
$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/learningController/showAllLearning.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var LearinglistVar = Learinglist;
				var Index = 0;
				$.each(msg.AllLearing, function(key, val) {
				
					var learComp = val.learComprehensive;
					var learComp_total = val.learComprehensivetotal;
					if(learComp == null && learComp_total == null){
						learComp = "—";
						learComp_total = "—";
					}
					arrayLearingId[key] = val.learId;
					arrayLearingsem[key] = val.learSemester;
					arrayLearingrank[key] = val.learRanking;
					arrayLearingpass[key] = val.learPassnumber;
					arrayLearingreq[key] = val.learRequirednumber;
					arrayLearingselect[key] = val.learSelectivesnumber;
					arrayLearingtotal[key] = val.learTotalnumber;
					arrayLearingisComp[key] = val.learEvaluationtype;
					arrayLearingCompRank[key] = val.learComprehensive;
					arrayLearingComptotal[key] = val.learComprehensivetotal;
					Index++;
					LearinglistVar += "<tr>" +"<td>"+Index+"</td>" +"<td>" + val.learSemester + "</td>" + "<td>" + val.learRanking + "</td>"
							+ "<td>" + val.learPassnumber + "</td>" + "<td>" + val.learGradepoint + "</td>"
							+ "<td>" + val.learGradepointrequired + "</td>" 
							+ "<td>&nbsp;&nbsp;&nbsp;" + val.learEvaluationtype + "</td>" + "<td>"
							+ "<button class='btn btn-success btn-xs' type='button' onclick='showOneDetails("+ key +")'>详细</button>&nbsp;"
							+ "<button class='btn btn-warning btn-xs' onclick='modifylearing(" + key
							+ ")'>" + "<b>" + "修改" + "</b>"
							+ "</button>&nbsp;" + "<button class='btn btn-danger btn-xs' onclick='confirmdelete(" + key
							+ ")'>" + "删除"  + "</button>" + "</td>" + "</tr>";
					if(val.learIseditable==0){
						$("#learing :input").attr("disabled",true);

					}
				});
				$("#allLearning").empty().append(LearinglistVar);
			}else {
				alert("显示失败！");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

//弹出小模态框，以确认用户是否删除该条学习信息

function confirmdelete(order){
	
	$("#deletelearing").modal('show');
	$("#confirm_delete").attr("onclick", "javascript:deleteLearning(" + order + ")");
	
}

function deleteLearning(order){
	alert(arrayLearingId[order]);
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/learningController/deleteLearing.do',
		async : false,
		data : {
			id : arrayLearingId[order]
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				$("#deletelearing").modal('hide');
				showallLearing();
			}else {
				alert("删除失败！");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function modifylearing(order) {//下面的条目有问题，改
	document.getElementById("grade_rank").value = arrayLearingrank[order];
	document.getElementById("totalNum").value = arrayLearingtotal[order];
	document.getElementById("iscompRank").value = arrayLearingisComp[order];
	if (arrayLearingisComp[order] == "是"){
		document.getElementById("comp_rankvalue").value = arrayLearingCompRank[order];
		document.getElementById("com_totoalnumvalue").value = arrayLearingComptotal[order];
		document.getElementById("comprank").style.display = "table-row";
	}else{
		document.getElementById("comprank").style.display = "none";
	}
	AddorModify = false;//将状态设置为“修改”,必须在模态框弹出之前！
	$("#learingmodal").modal();
}

function addOneLearning(){
	AddorModify = true;//将状态设置为“添加”
	$("#learingmodal").modal('show');
}

function showOneDetails(order){
	$("#detaillearingmodal").modal('show');
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/learningController/showOneLearning.do',
		async : false,
		data : {
			id:arrayLearingId[order],
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				$("#semester1").empty().append(msg.learning.learSemester);
				$("#learRanking").empty().append(msg.learning.learRanking);
				$("#learPassnumber").empty().append(msg.learning.learPassnumber);
				$("#learRequirednumber").empty().append(msg.learning.learRequirednumber);
				$("#learSelectivesnumber").empty().append(msg.learning.learSelectivesnumber);
				$("#learTotalnumber").empty().append(msg.learning.learTotalnumber);
				$("#learGradepoint").empty().append(msg.learning.learGradepoint);
				$("#learGradepointrequired").empty().append(msg.learning.learGradepointrequired);
				$("#learEvaluationtype").empty().append(msg.learning.learEvaluationtype);
				if (msg.learning.learEvaluationtype == "是"){
					$("#learComprehensive").empty().append(msg.learning.learComprehensive);
					$("#learComprehensivetotal").empty().append(msg.learning.learComprehensivetotal);
					document.getElementById("comprankDetail").style.display = "table-row";
				}
			}else {
				alert("显示失败！");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
