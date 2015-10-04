$(document).ready(function (){
	document.onkeydown = function(e){
	    var ev = document.all ? window.event : e;  
	    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
	        //要处理的事件  
	    	document.getElementById("isDelete").click(); //调用登录按钮的登录事件  
	    }
	  };
	$.ajax({
	type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showApplyPkTable.do',
		async : false,
		data : {
			studId:0,
		},
		dataType : 'json',
		success : function(msg) {
			document.getElementById('inputName').innerHTML=msg.student.studName;
			document.getElementById('inputSex').innerHTML=msg.studentinfo.stinSex;
			document.getElementById('inputNation').innerHTML=msg.student.studNation;
			document.getElementById('inputStudentIDNumber').innerHTML=msg.student.studIdnumber;
			document.getElementById('inputStudentNumber').innerHTML=msg.student.studNumber;
			//document.getElementById('inputBankNumber').innerHTML=msg.studentinfo.stinBanknumber;
			document.getElementById('inputBirthYearAndMonth').innerHTML=msg.student.studBirthday;
			document.getElementById('inputDescription').innerHTML=msg.institution.instName;
			document.getElementById('inputClassname').innerHTML=msg.studentclass.className;
			document.getElementById("inputPhone").innerHTML=msg.studentinfo.stinPhone;
			document.getElementById("inputQq").innerHTML=msg.studentinfo.stinQq;
			document.getElementById("inputEmail").innerHTML=msg.studentinfo.stinEmail;
			document.getElementById("inputPoliticstate").innerHTML=msg.studentinfo.stinPoliticstate;
			document.getElementById('inputAreadeatilhome').innerHTML=msg.studentinfo.stinAreadeatilhome;
			document.getElementById('inputMailcode').innerHTML=msg.studentinfo.stinMailcode;
			document.getElementById('studPopuNum').innerHTML=msg.studentinfo.stinPopulation;
			var obj1=document.getElementsByName("isDisable");
			obj1[1].checked="checked";//默认为非残疾
			if(msg.exist==1)
			{
				$("#AllIncomePerYear").val(msg.pgsgl1.pksgAllincomeperyear);
				$("#applyReason").val(msg.pgsgl1.pksgApplyreason);
				var obj=document.getElementsByName("isDisable");
				if(msg.pgsgl1.pksgIsdisable==0)
				{
					obj[1].checked="checked";
				}else
				{
					obj[0].checked="checked";
				}
				if(msg.pgsgl1.pksgWsflid == -1  )
				{
					$("#pksgTable :input").attr("disabled",true);
					document.getElementById("save").style.display="none";
					document.getElementById("isDelete").style.display="none";
				}else if(msg.workstepfolw1.wsflOrder!=1){
					$("#pksgTable :input").attr("disabled",true);
					document.getElementById("save").style.display="none";
					document.getElementById("isDelete").style.display="none";
				}
			}else
			{
				$("#pksgTable :input").attr("disabled",false);
			}
			var date1 = new Date(); 
			var date2 = new Date(msg.work.workStarttime); 
			var date3 = new Date(msg.work.workEndtime); 
			if(date1>date2&&date1<date3)
			{
			}else{
				alert("系统暂未开启！");
				$("#pksgTable :input").attr("disabled",true);
				document.getElementById("save").style.display="none";
				document.getElementById("isDelete").style.display="none";
			}
		},error:function(msg){
		alert("查询失败");
		}
	});
	$("#save").click(function(){
		var applyreason=$("#applyReason").val();
		var obj=document.getElementsByName("isDisable");
		var isDisable=0;
		var allIncomePerYear = $("#AllIncomePerYear").val();
		for(var i=0; i<obj.length; i ++){
	        if(obj[i].checked){
	        	isDisable=obj[i].value;
		        }
		    }
		if(applyreason!=""&&allIncomePerYear!=""&&checknum('AllIncomePerYear'))
		{
		$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/saveApplyPkTable.do',
		async : false,
		data : {
			applyreason:applyreason,
			isDisable:isDisable,
			isSure:0,
			allIncomePerYear:allIncomePerYear
		},
		dataType : 'json',
		success : function(msg) {
			alert("操作成功");
		},error:function(msg){
			alert("添加失败");
		}
		
		});
		}else{
		document.getElementById("tip01").style.display="block";
		}
	});
	$("#submitPk").click(function(){
		var applyreason=$("#applyReason").val();
		var obj=document.getElementsByName("isDisable");
		var isDisable=0;
		var allIncomePerYear = $("#AllIncomePerYear").val();
		for(var i=0; i<obj.length; i ++){
	        if(obj[i].checked){
	        	isDisable=obj[i].value;
		    }
		}
		if(applyreason!=""&&allIncomePerYear!="" && checknum('AllIncomePerYear'))
		{
			$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/pkController/saveApplyPkTable.do',
			async : false,
			data : {
				applyreason:applyreason,
				isDisable:isDisable,
				isSure:1,
				allIncomePerYear:allIncomePerYear
			},
			dataType : 'json',
			success : function(msg) {
				
			},error:function(msg){
				alert("添加失败");
			}
		});
			window.location.href="seePkList.html";
		}else{
			document.getElementById("tip01").style.display="block";
		}
		
	});
});
function checknum(a)
{
	
	if(document.getElementById(a).value=="")
	{
		alert("输入不能为空");
		return false;
	}else if(!isDigit(document.getElementById(a).value)){
		alert("请输入整数！");
		return false;
	}else{
		return true;
	}
}
function checktext(a)
{
	
	if(document.getElementById(a).value=="")
	{
		alert("输入不能为空");
	}
}
function cheakOut(a,b,c)//数字检测
{	a+="";b+="";c+="";
	if(document.getElementById(a).value=="")
	{
	document.getElementById(b).style.display="none";
	document.getElementById(c).style.display="block";
	}else if(!isDigit(document.getElementById(a).value))
	{
		document.getElementById(b).style.display="block";
		document.getElementById(c).style.display="none";
	}else
	{
		document.getElementById(b).style.display="none";
		document.getElementById(c).style.display="none";
	}
}
function cheakIn(a,b,c)
{
	a+="";b+="";c+="";
	document.getElementById(b).style.display="none";
	document.getElementById(c).style.display="none";
}
function isDigit(s) 
{ 

var patrn=/^[0-9]{1,20}$/; 

if (!patrn.exec(s)) return false ;

return true ;

}