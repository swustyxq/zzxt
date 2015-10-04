$(document).ready(function (){
	$.ajax({
	type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/showApplyYlTable.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
		document.getElementById('Name1').innerHTML=msg.student.studName;
		document.getElementById('Name2').innerHTML=msg.student.studName;
		document.getElementById('Name3').innerHTML=msg.student.studName;
		document.getElementById('Institution1').innerHTML=msg.institution.instName;
		document.getElementById('Institution2').innerHTML=msg.institution.instName;
		document.getElementById('Institution3').innerHTML=msg.institution.instName;
		document.getElementById('StudClass1').innerHTML=msg.studentclass.className;
		document.getElementById('StudClass2').innerHTML=msg.studentclass.className;
		document.getElementById('StudClass3').innerHTML=msg.studentclass.className;
		document.getElementById('StudNumber1').innerHTML=msg.student.studNumber;
		document.getElementById('StudNumber2').innerHTML=msg.student.studNumber;
		document.getElementById('StudNumber3').innerHTML=msg.student.studNumber;
		document.getElementById('StudIDNumber1').innerHTML=msg.student.studIdnumber;
		document.getElementById('StudIDNumber2').innerHTML=msg.student.studIdnumber;
		document.getElementById('StudIDNumber3').innerHTML=msg.student.studIdnumber;
		document.getElementById('BankNumber1').innerHTML=msg.studentinfo.stinBanknumber;
		document.getElementById('BankNumber2').innerHTML=msg.studentinfo.stinBanknumber;
		document.getElementById('BankNumber3').innerHTML=msg.studentinfo.stinBanknumber;
		document.getElementById("StudPhone1").innerHTML=msg.studentinfo.stinPhone;
		document.getElementById("StudPhone2").innerHTML=msg.studentinfo.stinPhone;
		document.getElementById("StudPhone3").innerHTML=msg.studentinfo.stinPhone;
		if(msg.pgsgl!=null)
		{
		document.getElementById("PkLevel1").innerHTML=msg.pgsgl.pksgRank;
		document.getElementById("PkLevel2").innerHTML=msg.pgsgl.pksgRank;
		document.getElementById("PkLevel3").innerHTML=msg.pgsgl.pksgRank;
		}else
		{
			document.getElementById("PkLevel1").innerHTML="不贫困";
			document.getElementById("PkLevel2").innerHTML="不贫困";
			document.getElementById("PkLevel3").innerHTML="不贫困";
		}
		if(msg.czylbx!=null)
		{
			if(msg.czylbx.czlyIssuccess==0)
			{
			document.getElementById("isSuccess2").innerHTML="否";
			document.getElementById("isSuccess4").innerHTML="否";
			document.getElementById("isSuccess6").innerHTML="否";
			}else{
			document.getElementById("isSuccess2").innerHTML="是";
			document.getElementById("isSuccess4").innerHTML="是";
			document.getElementById("isSuccess6").innerHTML="是";
			}
		}else{
			document.getElementById("isSuccess2").innerHTML="否";
			document.getElementById("isSuccess4").innerHTML="否";
			document.getElementById("isSuccess6").innerHTML="否";
		}
		},error:function(msg){
		alert("查询失败");
		}
	});
	$("#save1").click(function(){
		var MainDiagnosis2=$("#MainDiagnosis1").val();
		var Inovice2 =$("#Inovice1").val();
		var SSSum2 =$("#SSSum1").val();
		var CISum2 =$("#CISum1").val();
		var obj=document.getElementsByName("radio1");
		var safeType="";
		var inTime=$("#InTime1").val();
		var outTime=$("#OutTime1").val();
		for(var i=0;i<obj.length;i++)
		{
			if(obj[i].checked){
				safeType = obj[i].value;
		    }
		}
		var applyType="住院";
		if(MainDiagnosis2!=""&&Inovice2!=""&&SSSum2!=""&&CISum2!=""&&safeType!=""&&inTime!=""&&outTime!="")
		{
		$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/saveYlApplication.do',
		async : false,
		data : {
			MainDiagnosis2:MainDiagnosis2,
			Inovice2:Inovice2,
			SSSum2:SSSum2,
			CISum2:CISum2,
			safeType:safeType,
			applyType:applyType,
			inTime:inTime,
			outTime:outTime,
			money:null
		},
		dataType : 'json',
		success : function(msg) {
			alert("提交成功");
		},error:function(msg){
			alert("添加失败");
		}
		});
		}else
		{
		alert("请完善所有信息！");
		}
	});
	$("#save2").click(function(){
		var MainDiagnosis2=$("#MainDiagnosis2").val();
		var Inovice2 =$("#Inovice2").val();
		var SSSum2 =$("#SSSum2").val();
		var CISum2 =$("#CISum2").val();
		var obj=document.getElementsByName("radio2");
		var safeType="";
		var inTime="";
		var outTime="";
		for(var i=0;i<obj.length;i++)
		{
			if(obj[i].checked){
				safeType = obj[i].value;
		    }
		}
		var applyType="意外门诊";
		if(MainDiagnosis2!=""&&Inovice2!=""&&SSSum2!=""&&CISum2!=""&&safeType!="")
		{
		$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/saveYlApplication.do',
		async : false,
		data : {
			MainDiagnosis2:MainDiagnosis2,
			Inovice2:Inovice2,
			SSSum2:SSSum2,
			CISum2:CISum2,
			safeType:safeType,
			applyType:applyType,
			inTime:inTime,
			outTime:outTime,
			money:null
		},
		dataType : 'json',
		success : function(msg) {
			alert("提交成功");
		},error:function(msg){
			alert("添加失败");
		}
		});
		}else{
		alert("请完善所有信息！");
		}
	});
	$("#save3").click(function(){
		var MainDiagnosis2=$("#MainDiagnosis3").val();
		var Inovice2 =$("#Inovice3").val();
		var SSSum2 =$("#SSSum3").val();
		var CISum2 =$("#CISum3").val();
		var obj=document.getElementsByName("radio3");
		var safeType="";
		var inTime="";
		var outTime="";
		for(var i=0;i<obj.length;i++)
		{
			if(obj[i].checked){
				safeType = obj[i].value;
		    }
		}
		var applyType="慢性病";
		if(MainDiagnosis2!=""&&Inovice2!=""&&SSSum2!=""&&CISum2!=""&&safeType!="")
		{
		$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/saveYlApplication.do',
		async : false,
		data : {
			MainDiagnosis2:MainDiagnosis2,
			Inovice2:Inovice2,
			SSSum2:SSSum2,
			CISum2:CISum2,
			safeType:safeType,
			applyType:applyType,
			inTime:inTime,
			outTime:outTime,
			money:null
		},
		dataType : 'json',
		success : function(msg) {
			alert("提交成功");
		},error:function(msg){
			alert("添加失败");
		}
		});
		}else{
		alert("请完善所有信息！");
		}
	});
});
function onclick1(a,b)//选择新农合或城镇居民医疗保险
{a+="";b+="";
document.getElementById(a).style.visibility="hidden";
document.getElementById(b).style.visibility="hidden";
}
function onclick2(a,b)
{a+="";b+="";
document.getElementById(a).style.visibility="visible";
document.getElementById(b).style.visibility="visible";
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
function cheakTimeIn(inputId,tip1Id,tip2Id)//时间检测
{
	inputId+="";tip1Id+="";tip2Id+="";
	document.getElementById(tip1Id).style.display="none";
	document.getElementById(tip2Id).style.display="none";
}
function cheakTimeOut(inputId,tip1Id,tip2Id)
{
	inputId+="";tip1Id+="";tip2Id+="";
	var time = new Date();
	var year = time.getFullYear();
	var month = time.getMonth()+1;
	month = month < 10 ? ("0" + month) : month;
	var date = time.getDate();
	date = date < 10 ? ("0" + date) : date;
	today = year +"-" + month + "-" + date;
	var time2 = document.getElementById(inputId).value;
	if(time2=="")
	{
	document.getElementById(tip1Id).style.display="none";
	document.getElementById(tip2Id).style.display="block";
	}else if(time2 > today)
	{
	document.getElementById(tip1Id).style.display="block";
	document.getElementById(tip2Id).style.display="none";
	document.getElementById(inputId).value="";
	}else{
	document.getElementById(tip1Id).style.display="none";
	document.getElementById(tip2Id).style.display="none";
	}
}
function isDigit(s) 
{ 

var patrn=/^[0-9]{1,20}$/; 

if (!patrn.exec(s)) return false ;

return true ;

}