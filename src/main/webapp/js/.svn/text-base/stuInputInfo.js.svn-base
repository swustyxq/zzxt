var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ]; // 加权因子
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ]; // 身份证验证位值.10代表X

$(document).ready(function() {
	ShowPersonalInfo();
	//showPareInfo();

	$("#add").click(function() {
		$('#addPareInfo').modal('show');

	});

});

var m_id;
var B_id;
function editPare(pareId) {
	m_id = 'editPareInfo' + pareId;
	B_id = "javascript:submitChange(" + pareId + ")";
	$(".motai").attr("id", m_id);
	$(".buttonChange").attr("onclick", B_id);
	$("#" + m_id).modal('show');
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/parentController/findParentById.do',
		async : false,
		cache : false,
		data : {
			pareId : pareId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				$("#pareName").val(msg.parent.pareName);
				$("#parePhone").val(msg.parent.parePhone);
				$("#pareWork").val(msg.parent.pareWork);
				$("#pareRole").val(msg.parent.pareRole);
				$("#pareRelation").val(msg.parent.pareRelation);
				$("#pareIdNumber").val(msg.parent.pareIdnumber);
				$("#pareOccupation").val(msg.parent.pareOccupation);
				$("#pareDuties").val(msg.parent.pareDuties);
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function addParent() {
	var pare_name = $("#addpareName").val();
	var pare_phone = $("#addparePhone").val();
	var pare_work = $("#addpareWork").val();
	var pare_role = $("#addpareRole").val();
	var pare_relation = $("#addpareRelation").val();
	var pare_IDNumber = $("#addpareIdNumber").val();
	var pare_occupation = $("#addpareOccupation").val();
	var pare_duties = $("#addpareDuties").val();
	if (check()) {
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/parentController/addParentInfo.do',
			async : false,
			cache : false,
			data : {
				pare_name : pare_name,
				pare_phone : pare_phone,
				pare_role : pare_role,
				pare_work : pare_work,
				pare_relation : pare_relation,
				pare_IDNumber : pare_IDNumber,
				pare_occupation : pare_occupation,
				pare_duties : pare_duties,
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					alert("添加成功");
					showPareInfo();
					$('#addPareInfo').modal('hide');
				} else {
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	} else {
		alert("请完善所有信息！");
	}

	/*
	 * author:赵学融 2014.07.1 判定输入信息是否规范
	 */
	function check() {
		if (pare_name != "" && pare_phone != "" && pare_role != "" && pare_work != "" && pare_relation != ""
			&& pare_IDNumber != "" && pare_occupation != "") {
			if (checkPhoneForm() && checkInputLenth() && CheckIdNumber(pare_IDNumber))
				return true;
			else
				return false;
		}

		else
			return false;
	}
	function checkPhoneForm() {

		if (!document.getElementById || !document.createTextNode)
			return false;
		var phone = document.getElementById("addparePhone");
		var str = phone.value;
		var phone = /^0\d{2,3}-?\d{7,8}$/;
		var regPartton = /1[3578]+\d{9}/;
		if (!str || str == null) {
			alert("手机号码不能为空！");
			phone.focus();
			return false;
		} else if (!regPartton.test(str) && !phone.test(str)) {
			alert("手机号码格式不正确！");
			phone.focus();
			return false;
		} else {
			return true;
		}
	}

	function checkInputLenth() {
		if ((pare_name.length >= 2 && pare_name.length <= 12) && (pare_role.length >= 2 && pare_role.length <= 4)) {
			return true;
		}else {
			alert("输入信息格式错误！");
			return false;
		}
	}

	function CheckIdNumber(idCard) {
		idCard = trim(idCard.replace(/ /g, "")); // 去掉字符串头尾空格
		if (idCard.length == 15) {
			return isValidityBrithBy15IdCard(idCard); // 进行15位身份证的验证
		} else if (idCard.length == 18) {
			var a_idCard = idCard.split(""); // 得到身份证数组
			if (isValidityBrithBy18IdCard(idCard) && isTrueValidateCodeBy18IdCard(a_idCard)) { // 进行18位身份证的基本验证和第18位的验证
				return true;
			} else {
				alert("身份证错误！");
				return false;
			}
		} else {
			alert("身份证错误！");
			return false;
		}
	}
	/**
	 * 判断身份证号码为18位时最后的验证位是否正确
	 * 
	 * @param a_idCard
	 *            身份证号码数组
	 * @return
	 */
	function isTrueValidateCodeBy18IdCard(a_idCard) {
		var sum = 0; // 声明加权求和变量
		if (a_idCard[17].toLowerCase() == 'x') {
			a_idCard[17] = 10; // 将最后位为x的验证码替换为10方便后续操作
		}
		for ( var i = 0; i < 17; i++) {
			sum += Wi[i] * a_idCard[i]; // 加权求和
		}
		valCodePosition = sum % 11; // 得到验证码所位置
		if (a_idCard[17] == ValideCode[valCodePosition]) {
			return true;
		} else {
			alert("身份证错误！");
			return false;
		}
	}
	/**
	 * 验证18位数身份证号码中的生日是否是有效生日
	 * 
	 * @param idCard
	 *            18位书身份证字符串
	 * @return
	 */
	function isValidityBrithBy18IdCard(idCard18) {
		var year = idCard18.substring(6, 10);
		var month = idCard18.substring(10, 12);
		var day = idCard18.substring(12, 14);
		var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
		// 这里用getFullYear()获取年份，避免千年虫问题
		if (temp_date.getFullYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1
				|| temp_date.getDate() != parseFloat(day)) {
			alert("身份证错误！");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 验证15位数身份证号码中的生日是否是有效生日
	 * 
	 * @param idCard15
	 *            15位书身份证字符串
	 * @return
	 */
	function isValidityBrithBy15IdCard(idCard15) {
		var year = idCard15.substring(6, 8);
		var month = idCard15.substring(8, 10);
		var day = idCard15.substring(10, 12);
		var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
		// 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
		if (temp_date.getYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1
				|| temp_date.getDate() != parseFloat(day)) {
			alert("身份证错误！");
			return false;
		} else {
			return true;
		}
	}
	// 去掉字符串头尾空格
	function trim(str) {
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}

	// console.log($("#pareInfoChange"));

}

function deleteParentInfo(pareId) {
	$("#deletePareInfo").modal('show');
	$("#deletePareBut").attr("onclick", "javascript:deleteParent(" + pareId + ")");
}
function deleteParent(pareId) {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/parentController/deletePareInfo.do',
		async : false,
		data : {
			pare_Id : pareId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert("删除成功");
				showPareInfo();
				$("#deletePareInfo").modal('hide');
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

/*
 * 作者：赵学融 20140710 实现动态展示父母信息
 */

function showPareInfo() {
	var type = -1;
	
	$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/studentController/showPareInfo.do',
				async : false,
				data : {
					studId :type,
				},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						var allPareTable = "";
						allPareTable += "<tr><th>姓名</th><th>身份</th><th>电话</th><th>职业</th><th>工作单位</th><th>与本人关系</th><th>身份证</th><th>操作</th></tr>";
						if(msg.parentsList != null){
						$.each(msg.parentsList, function(key, val) {
						//	alert(val.pareIseditable);
							allPareTable += "<tr>" + "<td>" + val.pareName + "</td>" + "<td>" + val.pareRole + "</td>"
									+ "<td>" + val.parePhone + "</td>" + "<td>" + val.pareOccupation + "</td>" + "<td>"
									+ val.pareWork + "</td>" + "<td>" + val.pareRelation + "</td>" + "<td>"
									+ val.pareIdnumber + "</td>";
							/*if (val.pareIseditable == 1) {*/
								allPareTable += "<td>" + "<a href=\"javascript:editPare(" + val.pareId + ")\"><button type=\"button\" class=\"btn btn-warning btn-xs\">修改</button>"
										+ "</a>&nbsp;&nbsp;&nbsp;";
							/*} else {
								allPareTable += "<td>";
							}*/
							allPareTable += "<a href=\"javascript:deleteParentInfo(" + val.pareId + ")\"><button type=\"button\" class=\"btn btn-danger btn-xs\">删除</button></a>"
									+ "</td>";
							allPareTable += "</tr>";
							//alert(val.pareIseditable);
							if(val.pareIseditable==0){
								$("#parents :input").attr("disabled",true);
							}
						});
						}else{
							allPareTable += "<tr><th>无</th><th>无</th><th>无</th><th>无</th><th>无</th><th>无</th><th>无</th><th>无</th></tr>";
						}
						$("#parentInfo").empty().append(allPareTable);
					} else {
						alert(msg.message);
					}
				},
				error : function(msg) {
					alert("网络超时！");
				}
			});

}

function submitChange(pareId) {
	var pare_name = $("#pareName").val();
	var pare_phone = $("#parePhone").val();
	var pare_work = $("#pareWork").val();
	var pare_role = $("#pareRole").val();
	var pare_relation = $("#pareRelation").val();
	var pare_IDNumber = $("#pareIdNumber").val();
	var pare_occupation = $("#pareOccupation").val();
	var pare_duties = $("#pareDuties").val();
	if (check()) {
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/parentController/setPareInfo.do',
			async : false,
			data : {
				pare_id : pareId,
				pare_name : pare_name,
				pare_phone : pare_phone,
				pare_role : pare_role,
				pare_work : pare_work,
				pare_relation : pare_relation,
				pare_IDNumber : pare_IDNumber,
				pare_occupation : pare_occupation,
				pare_duties : pare_duties,
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					// alert("修改成功");
					showPareInfo();
					$('#' + m_id).modal('hide');
				} else {
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	} else {
		alert("请完善所有信息！");
	}

	/*
	 * author:赵学融 2014.07.1 判定输入信息是否规范
	 */
	function check() {
		if (pare_name != "" && pare_phone != "" && pare_role != "" && pare_work != "" && pare_relation != ""
				&& pare_IDNumber != "" && pare_occupation != "") {
			if (checkPhoneForm() && checkInputLenth() && CheckIdNumber(pare_IDNumber))
				return true;
			else
				return false;
		}

		else{
			
			return false;
		}
			
	}
	function checkPhoneForm() {

		if (!document.getElementById || !document.createTextNode)
			return false;
		var phone = document.getElementById("parePhone");
		var str = phone.value;
		var phone = /^0\d{2,3}-?\d{7,8}$/;
		var regPartton = /1[3578]+\d{9}/;
		if (!str || str == null) {
			alert("手机号码不能为空！");
			phone.focus();
			return false;
		} else if (!regPartton.test(str) && !phone.test(str)) {
			alert("手机号码格式不正确！");
			phone.focus();
			return false;
		} else {
			return true;
		}
	}

	function checkInputLenth() {
		if ((pare_name.length >= 2 && pare_name.length <= 12) && (pare_role.length >= 2 && pare_role.length <= 4)) {
			return true;
		}

		else {

			alert("输入信息格式错误！" + pare_relation.length);
			return false;
		}
	}

	function CheckIdNumber(idCard) {
		idCard = trim(idCard.replace(/ /g, "")); // 去掉字符串头尾空格
		if (idCard.length == 15) {
			return isValidityBrithBy15IdCard(idCard); // 进行15位身份证的验证
		} else if (idCard.length == 18) {
			var a_idCard = idCard.split(""); // 得到身份证数组
			if (isValidityBrithBy18IdCard(idCard) && isTrueValidateCodeBy18IdCard(a_idCard)) { // 进行18位身份证的基本验证和第18位的验证
				return true;
			} else {
				alert("身份证错误！");
				return false;
			}
		} else {
			alert("身份证错误！");
			return false;
		}
	}
	/**
	 * 判断身份证号码为18位时最后的验证位是否正确
	 * 
	 * @param a_idCard
	 *            身份证号码数组
	 * @return
	 */
	function isTrueValidateCodeBy18IdCard(a_idCard) {
		var sum = 0; // 声明加权求和变量
		if (a_idCard[17].toLowerCase() == 'x') {
			a_idCard[17] = 10; // 将最后位为x的验证码替换为10方便后续操作
		}
		for ( var i = 0; i < 17; i++) {
			sum += Wi[i] * a_idCard[i]; // 加权求和
		}
		valCodePosition = sum % 11; // 得到验证码所位置
		if (a_idCard[17] == ValideCode[valCodePosition]) {
			return true;
		} else {
			alert("身份证错误！");
			return false;
		}
	}
	/**
	 * 验证18位数身份证号码中的生日是否是有效生日
	 * 
	 * @param idCard
	 *            18位书身份证字符串
	 * @return
	 */
	function isValidityBrithBy18IdCard(idCard18) {
		var year = idCard18.substring(6, 10);
		var month = idCard18.substring(10, 12);
		var day = idCard18.substring(12, 14);
		var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
		// 这里用getFullYear()获取年份，避免千年虫问题
		if (temp_date.getFullYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1
				|| temp_date.getDate() != parseFloat(day)) {
			alert("身份证错误！");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 验证15位数身份证号码中的生日是否是有效生日
	 * 
	 * @param idCard15
	 *            15位书身份证字符串
	 * @return
	 */
	function isValidityBrithBy15IdCard(idCard15) {
		var year = idCard15.substring(6, 8);
		var month = idCard15.substring(8, 10);
		var day = idCard15.substring(10, 12);
		var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
		// 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
		if (temp_date.getYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1
				|| temp_date.getDate() != parseFloat(day)) {
			alert("身份证错误！");
			return false;
		} else {
			return true;
		}
	}
	// 去掉字符串头尾空格
	function trim(str) {
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}
}

function ShowPersonalInfo() {
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
				$("#personalStuClass").html(msg.studentClass.className);// 班级
				$("#personalStuName").html(msg.student[0].studName);// 姓名
				$("#personalStuNumber").html(msg.student[0].studNumber);// 学号
				$("#personalStuNation").html(msg.student[0].studNation);// 民族
				$("#personalStuDepartment").html(msg.major.majrName);// 专业
				$("#personalStuPhone").html(msg.studentInfo.stinPhone);// 电话
				$("#personalStuIdNumber").html(msg.student[0].studIdnumber);// 身份证号码
				$("#personalStuQQ").html(msg.studentInfo.stinQq);// QQ号
				$("#personalStuEmail").html(msg.studentInfo.stinEmail);// 邮箱
			/*	$("#personalStuHome").html(msg.studentInfo.stinAreadeatilhome);// 家庭详细地址
*/				// $("#gjlzRanking").val(msg.gjlzjxj.gjlzRanking);//成绩排名
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
