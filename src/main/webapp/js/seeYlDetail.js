var ylbzinfo;
$(document).ready(function (){
	var Request = new Object();
	Request = GetRequest();
	var ylbzId = 0 ;
	if(Request!=null)
	{
	ylbzId = Request['id'];
	}
	$.ajax({
	type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/showApplyYlTable1.do',
		async : false,
		data : {
			ylbzId:ylbzId
		},
		dataType : 'json',
		success : function(msg) {
		ylbzinfo = msg.ylbz;
		document.getElementById('Name1').innerHTML=msg.student.studName;
		document.getElementById('Institution1').innerHTML=msg.institution.instName;
		document.getElementById('StudClass1').innerHTML=msg.studentclass.className;
		document.getElementById('StudNumber1').innerHTML=msg.student.studNumber;
		document.getElementById('StudIDNumber1').innerHTML=msg.student.studIdnumber;
		document.getElementById('BankNumber1').innerHTML=msg.studentinfo.stinBanknumber;
		document.getElementById("StudPhone1").innerHTML=msg.studentinfo.stinPhone;
		if(msg.pgsgl.pksgRank!=null)
		{
		document.getElementById("PkLevel1").innerHTML=msg.pgsgl.pksgRank;
		}else{
		document.getElementById("PkLevel1").innerHTML="非贫困生";
		}
		if(msg.czylbx!=null)
		{
			if(msg.czylbx.czlyIssuccess==0)
			{
			document.getElementById("isSuccess2").innerHTML="否";
			}else{
			document.getElementById("isSuccess2").innerHTML="是";
			}
		}else{
			document.getElementById("isSuccess2").innerHTML="否";
		}
		if(msg.ylbz!=null)
		{
			$("#applyType").val(msg.ylbz.ylbzApplytype);
			$("#SSSum").val(msg.ylbz.ylbzSssum);
			$("#CISum").val(msg.ylbz.ylbzCisum);
			var obj=document.getElementsByName("radio1");
			if(msg.ylbz.ylbzSafetype=="新农合")
			{
				obj[0].checked = "checked";
				document.getElementById("isSuccess1").style.visibility="hidden";
				document.getElementById("isSuccess2").style.visibility="hidden";
			}else{
				obj[1].checked = "checked";
				document.getElementById("isSuccess1").style.visibility="visible";
				document.getElementById("isSuccess2").style.visibility="visible";
			}
			$("#InTime1").val(msg.ylbz.ylbzIntime);
			$("#OutTime1").val(msg.ylbz.ylbzOuttime);
			$("#MainDiagnosis1").val(msg.ylbz.ylbzDiagnosis);
			$("#Inovice1").val(msg.ylbz.ylbzInovice);
			$("#SSSum1").val(msg.ylbz.ylbzSssum);
			$("#CISum1").val(msg.ylbz.ylbzCisum);
			document.getElementById("applytime").innerHTML = time(msg.ylbz.ylbzApplytime);
			if(msg.ylbz.ylbzApplytype!="住院")
			{
				document.getElementById("inandout").style.display = "none";
				document.getElementById("linediv").style.display = "none";
				document.getElementById("isorno").style.display = "none";
			}else{
				if(ylbzinfo.ylbzCisum!=0){
					document.getElementById("isorno").style.display = "none";
				}
			}
			if(msg.ylbz.ylbzState==1){
				document.getElementById("audit").style.display="none";
				$("#ylbztable :input").attr("disabled",true);
			}else if(msg.user1.userType!=7){
			document.getElementById("audit").style.display="none";
				$("#ylbztable :input").attr("disabled",true);
			}else{
				$("#ylbztable :input").attr("disabled",false);
			}
		}
		
		},error:function(msg){
		alert("查询失败");
		}
	});
});
function suresubmit()
{
		var MainDiagnosis2=$("#MainDiagnosis1").val();
		var Inovice2 =$("#Inovice1").val();
		var SSSum2 =$("#SSSum1").val();
		var CISum2 =$("#CISum1").val();
		var obj=document.getElementsByName("radio1");
		var safeType="";
		var inTime=$("#InTime1").val();
		var outTime=$("#OutTime1").val();
		var money = $("#money").val();
		var line = $("#line").val();
		for(var i=0;i<obj.length;i++)
		{
			if(obj[i].checked){
				safeType = obj[i].value;
		    }
		}
		if(money=="")
		{
			alert("请先计算金额");
		}
		else if(MainDiagnosis2!=""&&Inovice2!=""&&SSSum2!=""&&CISum2!=""&&safeType!="")
		{
		$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/ylController/saveYlApplication1.do',
		async : false,
		data : {
			line:line,
			ylbzId:ylbzinfo.ylbzId,
			MainDiagnosis2:MainDiagnosis2,
			Inovice2:Inovice2,
			SSSum2:SSSum2,
			CISum2:CISum2,
			safeType:safeType,
			inTime:inTime,
			outTime:outTime,
			money:money
		},
		dataType : 'json',
		success : function(msg) {
			alert("提交成功");
			location.replace(document.referrer);
		},error:function(msg){
			alert("添加失败");
		}
		});
		}else
		{
		alert("请完善所有信息！");
		}
}
function calculateAmount()
{
    var reimbursable = $("#reimbursable").val();
	var money=888;
	if(reimbursable=="")
	{
		alert("请输入可报销金额");
	}
	else if(ylbzinfo.ylbzApplytype=="住院")
	{
		var line = $("#line").val();
		if(line=="")
		{
			alert("请输入起报线");
		}
		else if(ylbzinfo.ylbzSafetype=="城镇居民医疗保险"){
			if(ylbzinfo.ylbzCisum!=0)//有商保
			{
				if(reimbursable<line){//起报线以下
					money = (reimbursable-ylbzinfo.ylbzCisum)*7/10;
				}else{
					money = (reimbursable - ylbzinfo.ylbzCisum-ylbzinfo.ylbzSssum)*7/10;
				}
			}else{
				var is="";
				var obj = document.getElementByName("yesorno");
				for(var i=0;i<obj.length;i++)
				{
					if(obj[i].checked=="checked"){
						is=obj[i].value;
					}
				}
				alert(is);
				if(reimbursable<line){//起报线以下
					if(is=="是"){
						money = (reimbursable-ylbzinfo.ylbzCisum)*5/10;
					}else{
						money = (reimbursable-ylbzinfo.ylbzCisum)*3/10;
					}
				}else{//起报线以上
					if(is=="是"){
						money = (reimbursable-ylbzinfo.ylbzSssum)*7/10+line*5/10;
					}else{
						money = (reimbursable-ylbzinfo.ylbzSssum)*7/10+line*3/10;
					}
				}
			}
		}
		else if(ylbzinfo.ylbzSafetype=="新农合"){
			if(ylbzinfo.ylbzCisum!=0){//有商保
				money=(reimbursable - ylbzinfo.ylbzSssum-ylbzinfo.ylbzCisum)*7/10;
			}else{//无商保
				money=(reimbursable - ylbzinfo.ylbzSssum)*5/10;
			}
		}
	}
	else if(ylbzinfo.ylbzApplytype=="慢性病")
	{	
		money=(reimbursable - ylbzinfo.ylbzSssum-ylbzinfo.ylbzCisum)/2;
	}else if(ylbzinfo.ylbzApplytype=="意外门诊")
	{
		money = reimbursable - ylbzinfo.ylbzCisum;
	}
	if(money<0){//计算出的补助金额小于0则补助金额为0
		money=0;
	}
	$("#money").val(money);
}
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
function GetRequest() {
	var url = location.search; //获取url中"?"符后的字串
	var theRequest = new Object();
	
	if (url.indexOf("?") != -1) { 
		var str = url.substr(1);
		strs = str.split("&");
		for(var i = 0; i < strs.length; i ++) { 
			theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
			}
		}
		if(url.indexOf("id")==-1)
		{
		theRequest = null;
		}
	return theRequest;
}
function time(date)
{
	   var time= new Date(date);
	   var year = time.getFullYear();
	   var month = time.getMonth()+1;//月份要加1
	   var day = time.getDate();
	   if(month<10)
		{
		   month ="0"+month;  
		}
	   if(day<10)
		{
		   day ="0"+day;  
		}
		var time1=year+"年"+month+"月"+day+"日";
	    return time1;
}