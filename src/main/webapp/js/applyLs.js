$(document).ready(function(){
	document.onkeydown = function(e){    
	    var ev = document.all ? window.event : e;  
	    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
	        //要处理的事件  
	    	document.getElementById("select").click(); //调用登录按钮的登录事件  
	    }
	  };
	  var time = new Date();
	  $.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/lstdController/systemOpenTime.do',
			async : false,
			data : {
				
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					if(time <= new Date(msg.work.workStarttime)||time >= new Date(msg.work.workEndtime)){
						location.href="seeLsList.html";
					}
					//alert(new Date(msg.work.workStarttime)+"@"+new Date(msg.work.workEndtime));
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	  var areaParentId1 = 0;
		findArea(areaParentId1,"#province");
		findArea($("#province").val(),"#city");
		findArea($("#city").val(),"#county");
		findArea($("#county").val(),"#town");
	$("#select").click(function(){
		initialise();//初始化页面
		var studNumber = $("#stuNumber").val();
		if($("#stuNumber").val().length != 8){
			document.getElementById("studNumberyy").style.visibility="visible";
		}else{
			document.getElementById("studNumberyy").style.visibility="hidden";
			$.ajax({
				type:"post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/lstdController/readInfoByStudNumber.do',
				async : false,
				data : {
					studId:0,
					studNumber:studNumber
				},
				success : function(msg) {
					if(msg.result == true){	
						//alert("读取");
						if(msg.workstepfolw == null){//判断是否已经申请 null未申请则执行
							readinfo(msg);
						}else if(msg.workstepfolw.wsflId==42){
							readinfo(msg);
						}else{
							readinfo(msg);
							changebutton();
							alert("该学生已经申请过了");
							//window.location.replace("/zzxt/htmls/seeLsList.html");
						}
						
					}else{
						alert(msg.message);
					}
				},error: function(msg){
				    alert("网络超时！");
				}
			});
			initArea();
		}
	});
	
	$("#submit").click(function(){
		if(check()){
			changebutton();
			insertparent();//添加父母信息
			var state = true;
			insert(state);
			document.getElementById("bitian").style.display="none";
			location.replace(location.href);
		}else{
			document.getElementById("bitian").style.display="block";
		}
	});
	$("#save").click(function(){
		if(check()){
			//alert(check());
			insertparent();//添加父母信息
			var state = false;
			insert(state);
			document.getElementById("bitian").style.display="none";
		}else{
			//alert("不行");
			document.getElementById("bitian").style.display="block";
		}
	});
	daikuan();//一开始读的时候就要加载
});
function daikuan(){
	var obj2 = document.getElementsByName("radio2");//已签订
	 for(var i=0; i<obj2.length; i ++){
	        if(obj2[i].checked){
	        	if(i == 0){
	        		document.getElementById("inputdaikuan").disabled="";
	        		document.getElementById("radio41").disabled="";
	        		document.getElementById("radio42").disabled="";
	        		document.getElementById("lstdReturncode").disabled="";
	        		//贷款金额验证
	        		$("#inputdaikuan").blur(function(){
	        			if(isNaN($("#inputdaikuan").val())){
	        				alert("贷款金额必须为数字！");
	        				//$("inputdaikuan").css({color:red});
	        			}else{
	        				if($("#inputdaikuan").val()==""||$("#inputdaikuan").val()==0){
	        					alert("贷款金额不能为空或0！");
	        				}
	        			}
	        		});
	        	}else{
	        		document.getElementById("inputdaikuan").disabled="disabled";
	        		document.getElementById("radio41").disabled="disabled";
	        		document.getElementById("radio42").disabled="disabled";
	        		document.getElementById("lstdReturncode").disabled="disabled";
	        		$("#inputdaikuan").val(0);
	        		$("#lstdReturncode").val("");
	        	}
	        }
	    }
}

function kaifabank(){
	var obj4 = document.getElementsByName("radio4");//贷款银行
	 for(var i=0; i<obj4.length; i ++){
	        if(obj4[i].checked){
	        	if(i==0){
	        		document.getElementById("lstdReturncode").disabled="disabled";
	        		$("#lstdReturncode").val("");
	        	}else{
	        		document.getElementById("lstdReturncode").disabled="";
	        		$("#lstdReturncode").blur(function(){
	        			if($("#lstdReturncode").val()==""){
	        				alert("您选择了国家开发银行，必须填写验证码！");
	        			}
	        		});
	        	}
	        }
	    }
}
//计算学费加住宿费 即申请缓缴总额
function jisuan(){
	var lstdApplytuition=$("#lstdApplytuition").val();//缓交的学费
	var lstdApplyaccommodation=$("#lstdApplyaccommodation").val();//缓交的住宿费
	var zonge = (lstdApplytuition-0)+(lstdApplyaccommodation-0);
	$("#zonge").empty().append(zonge);
	$("#lstdApplytuition1").empty().append(lstdApplytuition);//缓缴费用承诺 
	$("#lstdApplyaccommodation1").empty().append(lstdApplyaccommodation);
	$("#lstdtion1").empty().append(lstdApplytuition);
	$("#lstdtion2").empty().append(lstdApplyaccommodation);
	$("#zonge1").empty().append(zonge);
	//两个都是数字，判断总和是否为0
	if(zonge == 0){
		alert("贷款金额不能为0！");
		$("#lstdApplytuition").empty().val("");
		$("#lstdApplyaccommodation").empty().val("");
	}else if($("#lstdApplytuition").val() == "" || $("#lstdApplyaccommodation").val() == ""){
		alert("学费、住宿费都不能为空");
	}else if(isNaN($("#lstdApplytuition").val()) || isNaN($("#lstdApplyaccommodation").val())){
		//其中，至少有一个不是数字
		if(isNaN($("#lstdApplytuition").val())){
			alert("申请学费贷款，输入内容为数字！");
			$("#lstdApplytuition").val("");
		}
		if(isNaN($("#lstdApplyaccommodation").val())){
			alert("申请住宿费贷款，输入内容为数字！");
			$("#lstdApplyaccommodation").val("");
		}
	}
}

function insert(state){
	var studNumber = $("#stuNumber").val();
	var lstdApplytuition=$("#lstdApplytuition").val();//缓交的学费
	var lstdApplyaccommodation=$("#lstdApplyaccommodation").val();//缓交的住宿费
	var lstdLimittime = $("#lstdLimittime").val();//缓交期限
	var lstdOngoing = 0;
	lstdOngoing = $("#inputdaikuan").val();//贷款金额
	var lstdApplyReason=$("#lstdApplyReason").val();//申请理由
	var lstdPaymentReason=$("#lstdPaymentReason").val();//承诺原因
	var lstdReturncode=$("#lstdReturncode").val();//回执码 开发银行才有
	var classopinion = $("#classopinion").val();//学院意见
	var lstdLoans="";//贷款方式
	var lstdBank="";//贷款的银行
	var lstdRepayWay="";//还款方式
	var lstdDisaster="";//2014年是否受灾
		 var obj4 = document.getElementsByName("radio4");//贷款银行
		 for(var i=0; i<obj4.length; i ++){
		        if(obj4[i].checked){
		        	if(i==0){
		        		lstdBank=obj4[0].value;
		        	}else{
		        		lstdBank=obj4[1].value;
		        	}
		        }
		    }
		 var obj2 = document.getElementsByName("radio2");//贷款方式
		 for(var i=0; i<obj2.length; i ++){
		        if(obj2[i].checked){
		        	if(i == 0){
		        		lstdLoans = obj2[0].value;
		        	}else if(i == 1){
		        		lstdLoans = obj2[1].value;
		        	}else{
		        		lstdLoans = obj2[2].value;
		        	}
		        }
		    }
		 var obj3 = document.getElementsByName("radio5");//还款方式
		 for(var i=0; i<obj3.length; i ++){
		        if(obj3[i].checked){
		        	if(i == 0){
		        		lstdRepayWay = obj3[0].value;
		        	}else if(i == 1){
		        		lstdRepayWay = obj3[1].value;
		        	}else{
		        		lstdRepayWay = obj3[2].value;
		        	}
		        }
		    }
		 var obj5 = document.getElementsByName("radio3");//2014是否受灾
		 for(var i=0; i<obj5.length; i ++){
		        if(obj5[i].checked){
		        	if(i==0){
		        		lstdDisaster=obj5[0].value;
		        	}else{
		        		lstdDisaster=obj5[1].value;
		        	}
		        }
		    }
		 //alert(lstdLoans+"@"+lstdBank+"@"+lstdRepayWay+"@"+lstdDisaster);
		$.ajax({
			type:"post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/lstdController/inputLstdByStudId.do',
			async : false,
			data : {
				lstdApplytuition:lstdApplytuition,
				lstdApplyaccommodation:lstdApplyaccommodation,
				lstdLimittime:lstdLimittime,
				lstdLoans:lstdLoans,
				lstdApplyReason:lstdApplyReason,
				lstdOngoing:lstdOngoing,
				lstdRepayWay:lstdRepayWay,
				lstdPaymentReason:lstdPaymentReason,
				lstdDisaster:lstdDisaster,
				lstdBank:lstdBank,
				lstdReturncode:lstdReturncode,
				state:state,
				classopinion:classopinion,
				academyopinion:"",
				studId:0,
				studNumber:studNumber
			},
			success : function(msg) {
				if(msg.result == true){	
					alert("操作成功!");
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
	

}

function readinfo(msg){
	$("#studName").empty().append(msg.student.studName);
	$("#studNumber").empty().append(msg.student.studNumber);
	if(msg.student.studIdnumber.substr(16,1)%2==1){
		$("#studSex").empty().append("男");// 性别
	}else{
		$("#studSex").empty().append("女");
	}
	$("#studClass").empty().append(msg.studentclass.className);
	$("#instName").empty().append(msg.studentinfo.stinDepartment);
	$("#phoneNumber").empty().append(msg.parent.parePhone);
	$("#stinAreadeatilhome").empty().append(msg.studentinfo.stinAreadetailorigin);
	$("#vallige").empty().val(msg.studentinfo.stinAreadeatilhome);
	//$("#stinAreadeatilhome1").empty().append(msg.studentinfo.stinAreadeatilhome);
	$.each(msg.parent,function(key,val){
		if((val.pareIdnumber.substr(16,1))%2==1){
			$("#fatherName").empty().val(val.pareName);
			$("#FIdNumber").empty().val(val.pareIdnumber);
			$("#phoneNumber").empty().val(val.parePhone);
		}else{
			$("#motherName").empty().val(val.pareName);
			$("#MIdNumber").empty().val(val.pareIdnumber);
			$("#phoneNumber").empty().val(val.parePhone);
		}
	});
	var obj1 = document.getElementsByName("radio1");
	for(var i=0;i<obj1.length;i++){
		obj1[i].checked = false;
	}
	if(msg.studentinfo.stinResidence == "城镇"){
		obj1[0].checked = "checked";
	}else{
		obj1[1].checked = "checked";
	}
	
	if(msg.lstd){
		$("#lstdApplytuition").empty().val(msg.lstd.lstdApplytuition);
			$("#lstdtion1").empty().append(msg.lstd.lstdApplytuition);
		$("#lstdApplyaccommodation").empty().val(msg.lstd.lstdApplyaccommodation);
			$("#lstdtion2").empty().append(msg.lstd.lstdApplytuition);
		$("#lstdReturncode").empty().val(msg.lstd.lstdReturncode);
		$("#inputdaikuan").empty().val(msg.lstd.lstdOngoing);
		$("#lstdApplyReason").empty().val(msg.lstd.lstdApplyReason);
		$("#lstdPaymentReason").empty().val(msg.lstd.lstdPaymentReason);
		$("#classopinion").empty().val(msg.lstd.lstdClassopinion);
		//alert(msg.lstd.lstdClassopinion);
		var lstdLimittime = "";
		lstdLimittime = msg.lstd.lstdLimittime;
		if(lstdLimittime=="一个月"){
			document.getElementById("ygy").selected="selected";
		}else if(lstdLimittime=="两个月"){
			document.getElementById("lgy").selected="selected";
		}else{
			document.getElementById("sgy").selected="selected";
		}
		var obj2 = document.getElementsByName("radio2");
		for(var i=0;i<obj2.length;i++){
			obj2[i].checked = false;
		}if(msg.lstd.lstdLoans == "已签订生源地信用助学贷款合同"){
			obj2[0].checked = "checked";
		}else if(msg.lstd.lstdLoans == "正在办理生源地信用助学贷款"){
			obj2[1].checked = "checked";
			document.getElementById("inputdaikuan").disabled="disabled";
    		document.getElementById("radio41").disabled="disabled";
    		document.getElementById("radio42").disabled="disabled";
    		document.getElementById("lstdReturncode").disabled="disabled";
    		$("#inputdaikuan").val(0);
    		$("#lstdReturncode").val("");
		}else{
			obj2[2].checked = "checked";
			document.getElementById("inputdaikuan").disabled="disabled";
    		document.getElementById("radio41").disabled="disabled";
    		document.getElementById("radio42").disabled="disabled";
    		document.getElementById("lstdReturncode").disabled="disabled";
    		$("#inputdaikuan").val(0);
    		$("#lstdReturncode").val("");
		}
		var obj3 = document.getElementsByName("radio3");
		for(var i=0;i<obj3.length;i++){
			obj3[i].checked = false;
		}if(msg.lstd.lstdDisaster == "没有受灾"){
			obj3[0].checked = "checked";
		}else{
			obj3[1].checked = "checked";
		}
		var obj4 = document.getElementsByName("radio4");
		for(var i=0;i<obj4.length;i++){
			obj4[i].checked = false;
		}if(msg.lstd.lstdBank == "农村信用合作社"){
			obj4[0].checked = "checked";
		}else{
			obj4[1].checked = "checked";
		}
		var obj5 = document.getElementsByName("radio5");
		for(var i=0;i<obj5.length;i++){
			obj5[i].checked = false;
		}if(msg.lstd.lstdRepayWay == "生源地信用助学贷款"){
			obj5[0].checked = "checked";
		}else if(msg.lstd.lstdRepayWay == "分期付款"){
			obj5[1].checked = "checked";
		}else{
			obj5[2].checked = "checked";
		}
		
	}
	
	
}

function insertparent(){
	var studNumber = $("#stuNumber").val();
	var phoneNumber = $("#phoneNumber").val();
	var fatherName = $("#fatherName").val();
	var FIdNumber = $("#FIdNumber").val();
	var motherName = $("#motherName").val();
	var MIdNumber = $("#MIdNumber").val();
	
	var province = $("#province").val();
	var city = $("#city").val();
	var county = $("#county").val();
	var town = $("#town").val();
	var vallige = $("#vallige").val();
	
	var obj1 = document.getElementsByName("radio1");
	for(var i=0; i<obj1.length; i ++){
		if(obj1[i].checked){
        	if(i==0){
        		stinResidence=obj1[0].value;
        	}else{
        		stinResidence=obj1[1].value;
        	}
        }
    }
	//alert(stinResidence);
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/parentController/insertParent.do',
		async : false,
		data : {
			studNumber:studNumber,
			phoneNumber:phoneNumber,
			fatherName:fatherName,
			FIdNumber:FIdNumber,
			motherName:motherName,
			MIdNumber:MIdNumber,
			province:province,
			city:city,
			county:county,
			town:town,
			vallige:vallige,
			stinResidence:stinResidence
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				//alert("xiaohuihuisb");
			} else{
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function changebutton(){
	document.getElementById("nonebutton").style.display="none";
	$("#lstdtable :input").attr("disabled",true);
}

function cityChange(){
	var areaParentId2 = $("#province").val();
	findArea(areaParentId2,"#city");
	var areaParentId3 = $("#city").val();
	findArea(areaParentId3,"#county");
	var areaParentId4 = $("#county").val();
	findArea(areaParentId4,"#town");
}
//市、县、镇三级联动
function countyChange(){
	var areaParentId3 = $("#city").val();
	findArea(areaParentId3,"#county");
	var areaParentId4 = $("#county").val();
	findArea(areaParentId4,"#town");
}
//县、镇、两级联动
function townChange(){
	var areaParentId4 = $("#county").val();
	findArea(areaParentId4,"#town");
}

function findArea(areaParentId,selectId){
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/AreaController/searchAreasByAreaParentId.do',
			async : false,
			data : {
				areaParentId : areaParentId
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					var provinceName="";
					//option遍历输出
					$.each(msg.areaList,function(key,val){
						provinceName +='<option value="' + val.areaId + '">' + val.areaName + '</option>';
						//先清空，再传值
					});
					//加了这个默认值才能显示
					$(selectId).empty().append("<option value='0' disabled='disabled' >请选择</option>"+provinceName);
				} else{
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});

	};
	function initArea() {
		var studNumber = $("#stuNumber").val();
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/AreaController/readinfoByStudNumber.do',
			async : false,
			data : {
				studNumber:studNumber
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					findArea(msg.county,"#town");
					findArea(msg.city,"#county");
					findArea(msg.province,"#city");
					findArea(0,"#province");
					$("#province").val(msg.province);
					$("#city").val(msg.city);
					$("#county").val(msg.county);
					$("#town").val(msg.town);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	}
	function initialise(){
		$("#lstdtable :input").attr("disabled",false);
		document.getElementById("nonebutton").style.display="block";
		$("#lstdApplytuition").val("");	
		$("#lstdApplyaccommodation").val("");
		$("#lstdLimittime").selected="selected";
		$("#inputdaikuan").val(0);
		$("#lstdReturncode").val("");
		$("#vallige").val("");
		$("#phoneNumber").val("");
		$("#fatherName").val("");
		$("#FIdNumber").val("");
		$("#motherName").val("");
		$("#MIdNumber").val("");
		$("#lstdApplyReason").val("");
		$("#lstdPaymentReason").val("");
		$("#classopinion").val();
	}
	function check() {
		if ($("#lstdApplytuition").val() != "" && $("#lstdApplyaccommodation").val() != "" && $("#vallige").val() != ""
			&& $("#phoneNumber").val() != "" && $("#fatherName").val() != "" && $("#FIdNumber").val() != ""
			&& $("#motherName").val() != ""&& $("#MIdNumber").val() != ""&& $("#lstdApplyReason").val() != ""
			&& $("#lstdPaymentReason").val() != ""&& $("#classopinion").val() != "") {
			
			if (checkPhoneForm() && CheckIdNumber($("#FIdNumber").val()) && CheckIdNumber($("#MIdNumber").val()))
				return true;
			else
				return false;
		}else
			return false;
	}
	var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ]; // 加权因子
	var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ]; // 身份证验证位值.10代表X
	function CheckIdNumber(IdNumber){
		IdNumber = trim(IdNumber.replace(/ /g, "")); // 去掉字符串头尾空格
		if (IdNumber.length == 18) {
			var a_idCard = IdNumber.split(""); // 得到身份证数组
			if (isValidityBrithBy18IdCard(IdNumber) && isTrueValidateCodeBy18IdCard(a_idCard)) { // 进行18位身份证的基本验证和第18位的验证
				return true;
			} else {
				alert("请输入正确的身份证号码！");
				return false;
			}
		} else {
			alert("请输入正确的身份证号码！");
			return false;
		}
	}
	$("#FIdNumber").blur(function(){
		var IdNumber = $("#FIdNumber").val();
		if(CheckIdNumber(IdNumber)){
			
		}else{
			$("#FIdNumber").val("");
		}
	});
	$("#MIdNumber").blur(function(){
		var IdNumber = $("#MIdNumber").val();
		if(CheckIdNumber(IdNumber)){
			
		}else{
			$("#MIdNumber").val("");
		}
	});
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
			alert("请输入正确的身份证号码！");
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
			alert("请输入正确的身份证号码！");
			return false;
		} else {
			return true;
		}
	}

	//去掉字符串头尾空格
	function trim(str) {
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	function checkPhoneForm() {

		if (!document.getElementById || !document.createTextNode)
			return false;
		var phone = document.getElementById("phoneNumber");
		var str = phone.value;
		var phone = /^0\d{2,3}-?\d{7,8}$/;
		var regPartton = /1[3578]+\d{9}/;
		if (!str || str == null) {
			alert("手机号码不能为空！");
			return false;
		} else if (!regPartton.test(str) && !phone.test(str)) {
			alert("手机号码格式不正确！");
			return false;
		} else {
			return true;
		}
	}