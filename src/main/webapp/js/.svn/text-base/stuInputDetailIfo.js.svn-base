var originDeatil = "sss";// 生源地地址
$(document).ready(function() {
	showInformation();
					$("#saveIfo").click(
									function() {
										var politicState = $("#politicState")
												.val();
										var bankNumber = $("#bankNumber").val();
										var sex = $("#sex").val();
										var phone = $("#phone").val();
										var QQ = $("#QQ").val();
										var email = $("#email").val();
										var residence = $("#residence").val();
										var population = $("#population").val();
										var allIncomes = $("#allIncomes").val();
										var incomeType = $("#incomeType").val();
										var mailCode = $("#mailCode").val();
										var department = $("#department").val();
										var areaIdHome = $("#town").val();// 得到镇的areaId
										// 保存
										var areaDeatilHome = $("#vallige").val();
										/*
										 * var areaIdOrigin= $("#town1").val();
										 * selectArea(selectArea(selectArea(selectArea(areaIdHome))));
										 * var areaDeatilHome = address +
										 * $("#vallige").val(); /*address="";
										 * selectArea(selectArea(selectArea(selectArea(areaIdOrigin))));
										 * var areaDetailOrigin=address +
										 * $("#vallige1").val();
										 */

										if (check()) {
											$.ajax({
														type : "post",
														contentType : "application/x-www-form-urlencoded;charset=UTF-8",
														url : '/zzxt/informationController/addDeatilInformation.do',
														async : false,
														data : {
															politicState : politicState,
															bankNumber : bankNumber,
															sex : sex,
															phone : phone,
															QQ : QQ,
															email : email,
															residence : residence,
															population : population,
															allIncomes : allIncomes,
															incomeType : incomeType,
															mailCode : mailCode,
															department : department,
															areaDeatilHome : areaDeatilHome,
															areaIdHome : areaIdHome,
															areaDetailOrigin : originDeatil,
															areaIdOrigin : 1
														},
														dataType : 'json',
														success : function(msg) {
															if (msg.result == true) {
																showInformation();
																alert(msg.message);
																window.location.href = 'inputInfo.html';
																 showInformation();
															} else {
																alert("保存失败！");
																showInformation();
															}
														},
														error : function(msg) {
															alert("网络超时！");
														}
													});
										}
									});
					function check() {
						if (politicState != "" || nation != "" || sex != ""
								|| phone != "" || QQ != "" || email != ""
								|| residence != "" || population != ""
								|| allIncomes != "" || incomeType != ""
								|| mailCode != "" || department != ""
								|| areaDeatil != "") {
							if (checkPoliticState() && checkBankNum()
									&& checkPhone() && checkQQ()
									&& checkEmail() && checkPopulation()
									&& checkAllIncomes() && checkIncomeType()
									&& checkMailCode() && checkDepartment()
									&& checkVallige())
								return true;
							else
								return false;
						} else
							return false;
					}
					
					function checkPoliticState() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var politicState = document
								.getElementById("politicState");
						var value = politicState.value;
						if (!value || value == null) {
							alert("请填写政治面貌！");
							return false;
						}
						if (value.length >= 1 && value.length <= 45) {
							return true;
						} else {
							alert("政治面貌填写不正确！");
							return false;
						}

					}

					function checkBankNum() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var bankNumber = document.getElementById("bankNumber");
						var value = bankNumber.value;
						if (!value || value == null) {
							alert("请填写银行卡号码！");
							return false;
						}
						var pattern = /^\d{19}$/g;
						flag = pattern.test(value);
						if (flag) {
							return true;
						} else {
							alert("银行卡号填写不正确！");
							return false;
						}
					}

					function checkPhone() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var phone = document.getElementById("phone");
						var value = phone.value;
						if (!value || value == null) {
							alert("请填写电话号码！");
							return false;
						}
						var pattern1 = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
						var pattern2 = /^0?(13[0-9]|15[0-9]|18[0-9]|14[57])[0-9]{8}$/;
						flag1 = pattern1.test(value);
						flag2 = pattern2.test(value);
						if (flag1 == true || flag2 == true) {
							return true;
						} else {
							alert("电话号码不正确！");
							return false;
						}
					}
					function checkQQ() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var QQ = document.getElementById("QQ");
						var value = QQ.value;
						if (!value || value == null) {
							alert("请填写QQ号码！");
							return false;
						}
						var pattern = /[1-9][0-9]{4,}/;
						flag = pattern.test(value);
						if (flag) {
							return true;
						} else {
							alert("QQ号码不存在或不正确！");
							return false;
						}
					}
					function checkEmail() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var email = document.getElementById("email");
						var value = email.value;
						if (!value || value == null) {
							alert("请填写邮箱！");
							return false;
						}
						var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
						flag = pattern.test(value);
						if (flag) {
							return true;
						} else {
							alert("邮箱格式不正确！");
							return false;
						}
					}
					function checkPopulation() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var population = document.getElementById("population");
						var value = population.value;
						if (!value || value == null) {
							alert("请填写人口数目！");
							return false;
						}
						var pattern = /[1-9][0-9]{0,}/;
						flag = pattern.test(value);
						if (flag) {
							return true;
						} else {
							alert("请输入正确的人口数！");
							return false;
						}
					}
					function checkAllIncomes() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var allIncomes = document.getElementById("allIncomes");
						var value = allIncomes.value;
						if (!value || value == null) {
							alert("请填写家庭年总收入！");
							return false;
						}
						var pattern = /[1-9][0-9]{0,}/;
						flag = pattern.test(value);
						if (flag) {
							return true;
						} else {
							alert("家庭年总收入不正确！");
							return false;
						}
					}

					function checkIncomeType() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var incomeType = document.getElementById("incomeType");
						var value = incomeType.value;
						if (!value || value == null) {
							alert("请填写收入来源！");
							return false;
						}

						if (value.length >= 1 && value.length <= 45) {
							return true;
						} else {
							alert("收入来源填写格式不正确！");
							return false;
						}

					}
					function checkMailCode() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var mailCode = document.getElementById("mailCode");
						var value = mailCode.value;
						if (!value || value == null) {
							alert("请填写邮编！");
							return false;
						}
						var pattern = /^[1-9][0-9]{5}$/;
						flag = pattern.test(value);
						if (flag) {
							return true;
						} else {
							alert("邮政编码不存在或不正确！");
							return false;
						}
					}
					function checkVallige() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var vallige = document.getElementById("vallige");
						var value = vallige.value;
						if (!value || value == null) {
							alert("请填写所在村/社！");
							return false;
						}
						if (value.length >= 1 && value.length <= 45) {
							return true;
						} else {
							alert("村/社填写不正确！");
							return false;
						}
					}
					function checkDepartment() {
						if (!document.getElementById
								|| !document.createTextNode)
							return false;
						var department = document.getElementById("department");
						var value = department.value;
						if (!value || value == null) {
							alert("请填写所在系！");
							return false;
						}
						if (value.length >= 1 && value.length <= 45) {
							return true;
						} else {
							alert("系别填写不正确！");
							return false;
						}
					}
				});

function findAreaByAreaId(areaId) {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/AreaController/searchAreaByAreaId.do',
		async : false,
		data : {
			areaId : areaId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				HomeAddress += msg.area.areaName;
				// alert(msg.area.areaName);
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function showInformation() {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/informationController/showDeatilInformation.do',
		async : false,
		data : {

		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if(msg.studentinfo.stinIseditable==0){
					$("#infoDeatil :input").attr("disabled",true);
				}
				checkValue(msg.studentinfo.stinPoliticstate);
				checkValue(msg.studentinfo.stinPhone);
				checkValue(msg.studentinfo.stinEmail);
				checkValue(msg.studentinfo.stinResidence);
				checkValue( msg.studentinfo.stinPopulation );
				checkValue(msg.studentinfo.stinAllincomes);
				checkValue(msg.studentinfo.stinIncometype);
				checkValue( msg.studentinfo.stinMailcode);
				checkValue(msg.studentinfo.stinDepartment);
				checkValue( msg.studentinfo.stinQq);
				checkValue( msg.studentinfo.stinAreadetailorigin);
				var stuDeatilInfo = "<tr>" + "<th>政治面貌</th>" + "<td>"
						+ msg.studentinfo.stinPoliticstate + "</td>"
						+ "<th>银行卡号</th>" + "<td>"
						+ msg.studentinfo.stinBanknumber + "</td>"
						+ "<th>性别</th>" + "<td>" + msg.studentinfo.stinSex
						+ "</td>" + "</tr>" + "<tr>" + "<th>电话号码</th>" + "<td>"
						+ msg.studentinfo.stinPhone + "</td>" + "<th>邮箱</th>"
						+ "<td>" + msg.studentinfo.stinEmail + "</td>"
						+ "<th>户口类型</th>" + "<td>"
						+ msg.studentinfo.stinResidence + "</td>" + "</tr>"
						+ "<tr>" + "<th>人口数量</th>" + "<td>"
						+ msg.studentinfo.stinPopulation + "</td>"
						+ "<th>家庭总收入</th>" + "<td>"
						+ msg.studentinfo.stinAllincomes + "</td>"
						+ "<th>收入来源</th>" + "<td>"
						+ msg.studentinfo.stinIncometype + "</td>" + "</tr>"
						+ "<tr>" + "<th>邮政编码</th>" + "<td>"
						+ msg.studentinfo.stinMailcode + "</td>"
						+ "<th>家庭详细地址</th>" + "<td>"
						+ msg.HomeAddress + "</td>"+"<th>系</th>"+"<td>"+msg.studentinfo.stinDepartment + "</td>"+ "</tr>" + "<tr>"
						+ "<th>QQ号码</th>" + "<td>" + msg.studentinfo.stinQq
						+ "</td>" + "<th>生源地详细地址</th>" + "<td colspan=\"3\">"
						+ msg.studentinfo.stinAreadetailorigin + "</td>"
						+ "</tr>";
				$("#studentIfo").empty().append(stuDeatilInfo);
				$("#politicState").empty()
						.val(msg.studentinfo.stinPoliticstate);
				$("#bankNumber").empty().val(msg.studentinfo.stinBanknumber);
				if (msg.studentinfo.stinSex == "男") {
					document.getElementById("man").selected = "selected";
				} else {
					document.getElementById("woman").selected = "selected";
				}
				$("#phone").empty().val(msg.studentinfo.stinPhone);
				$("#QQ").empty().val(msg.studentinfo.stinQq);
				$("#email").empty().val(msg.studentinfo.stinEmail);
				if (msg.studentinfo.stinResidence == "城镇") {
					document.getElementById("chengzhen").selected = "selected";
				} else {
					document.getElementById("nongcun").selected = "selected";
				}
				$("#population").empty().val(msg.studentinfo.stinPopulation);
				$("#allIncomes").empty().val(msg.studentinfo.stinAllincomes);
				$("#mailCode").empty().val(msg.studentinfo.stinMailcode);
				$("#incomeType").val(msg.studentinfo.stinIncometype);
				$("#department").empty().val(msg.studentinfo.stinDepartment);
				originDeatil = msg.studentinfo.stinAreadetailorigin; 
				if(msg.city!=null &&msg.province !=null &&msg.county !=null && msg.town!=null)
				{	
				$("#city").val(msg.city);
				$("#province").val(msg.province);		
				$("#city").val(msg.city);		
				$("#county").val(msg.county);
				$("#town").val(msg.town);
			  }
				$("#vallige").val(msg.studentinfo.stinAreadeatilhome);
			}
		},
		error : function(msg) {
			alert("网络超时！wrong");
		}
	});
};

function selectArea(areaId) {
	var areaParentid = 0;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/AreaController/searchAreaByAreaId.do',
		async : false,
		data : {
			areaId : areaId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				address = msg.area.areaName + address;
				areaParentid = msg.area.areaParentid;
			} else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	return areaParentid;
}

function checkValue(str){
	if(str==null){
		str=null;
	}
}
