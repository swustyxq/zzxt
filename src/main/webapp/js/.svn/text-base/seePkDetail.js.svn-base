var pksgCommunityopinion="";
var check=1;
$(document).ready(function(){
	var Request = new Object();
	Request = GetRequest();
	var studId = 0 ;
	if(Request!=null)
	{
	studId = Request['id'];
	}
	showdetailinfo(studId);
	$("#save").click(function(){
		var isSure=0;
		saveOrSubmit(isSure,studId);
	});
	$("#submitPk").click(function(){
		var isSure=1;
		saveOrSubmit(isSure,studId);
	});
	$("#back").click(function(){
		var isSure=-1;
		saveOrSubmit(isSure,studId);
	});
});
function saveOrSubmit(isSure,studId)
{
		var pkLevel="";
		var applyreason=$("#applyReason").val();
		var obj=document.getElementsByName("pkLevel");
		var allIncomePerYear=$("#AllIncomePerYear").val();
		for (var i=0;i<obj.length;i++)
		{
			if(obj[i].checked)
			{
				pkLevel = obj[i].value;
			}
			
		}
		var obj1=document.getElementsByName("ok");
		var academyopinion="";
		if(obj1[0].checked)
		{
			academyopinion = pksgCommunityopinion;
			$("#final").val("");
		}else if(obj1[1].checked){
			academyopinion = $("#final").val();
			
			check=$("#final").val();
		}
		var reason = $("#reason").val();
	
		if(pkLevel!=""&&applyreason!=""&&reason!=""&&allIncomePerYear!=""||isSure==-1)
		{
		  if(checknum('AllIncomePerYear')){	
			 
			  if(check!=""){
		$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/instExaminePksglApplication.do',
		async : false,
		data : {
			applyreason:applyreason,
			isSure:isSure,
			reason:reason,
			studId:studId,
			pkLevel:pkLevel,
			allIncomePerYear:allIncomePerYear,
			academyopinion:academyopinion
		},
		dataType : 'json',
		success : function(msg) {
			alert("操作成功");
		},error:function(msg){
			alert("添加失败");
		}
		
		});
		  }else{
			  
			  alert("请填写调整后的意见");
		  }
		}
		}else{
		document.getElementById("tip01").style.display="block";
		
		}
		location.reload();
}
function showdetailinfo(studId)
{
$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showApplyPkTable.do',
		async : false,
		data : {
			studId:studId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
					document.getElementById('inputName').innerHTML=msg.student.studName;
					document.getElementById('inputSex').innerHTML=msg.studentinfo.stinSex;
					document.getElementById('inputNation').innerHTML=msg.student.studNation;
					document.getElementById('inputStudentIDNumber').innerHTML=msg.student.studIdnumber;
					document.getElementById('inputStudentNumber').innerHTML=msg.student.studNumber;
					//document.getElementById('inputBankNumber').innerHTML=msg.studentinfo.stinBanknumber;
					document.getElementById('inputBirthYearAndMonth').innerHTML=msg.student.studBirthday;
					document.getElementById('inputDescription').innerHTML=msg.studentclass.classDescription;
					document.getElementById('inputClassname').innerHTML=msg.studentclass.className;
					document.getElementById("inputPhone").innerHTML=msg.studentinfo.stinPhone;
					document.getElementById("inputQq").innerHTML=msg.studentinfo.stinQq;
					document.getElementById("inputEmail").innerHTML=msg.studentinfo.stinEmail;
					document.getElementById("inputPoliticstate").innerHTML=msg.studentinfo.stinPoliticstate;
					document.getElementById('inputAreadeatilhome').innerHTML=msg.studentinfo.stinAreadeatilhome;
					document.getElementById('inputMailcode').innerHTML=msg.studentinfo.stinMailcode;
					document.getElementById('inputDescription').innerHTML=msg.institution.instName;
					document.getElementById('studPopuNum').innerHTML=msg.studentinfo.stinPopulation;
					if(msg.exist==1)
					{
						$("#AllIncomePerYear").val(msg.pgsgl1.pksgAllincomeperyear);
						$("#applyReason").val(msg.pgsgl1.pksgApplyreason);
						var obj=document.getElementsByName("isDisable");
						pksgCommunityopinion = msg.pgsgl1.pksgRecommendgrade;
						if(msg.pgsgl1.pksgIsdisable==0)
						{
						obj[1].checked="checked";
						}else
						{
						obj[0].checked="checked";
						}
						var obj2=document.getElementsByName("pkLevel");
							for(var i=0;i<obj2.length;i++)
							{
								if(msg.pgsgl1.pksgRecommendgrade==obj2[i].value)
								{
									obj2[i].checked="checked";
								}
							}
							$("#reason").val(msg.pgsgl1.pksgCommunityopinion);
						
						if(msg.user.userType!=1)
						{
							if(msg.maxrole!=2){
								document.getElementById("institutionopinion").style.display="";
								var obj3=document.getElementsByName("ok");
								if(msg.pgsgl1.pksgRecommendgrade==msg.pgsgl1.pksgAcademyopinion)
								{
									obj3[0].checked="checked";
									$('#final').attr("disabled",false);
								}else
								{
									obj3[1].checked="checked";
									$("#final").val(msg.pgsgl1.pksgAcademyopinion);
								}
							}
							if(msg.pgsgl1.pksgWsflid==-1)
							{
								$("#pksgTable :input").attr("disabled",true);
								document.getElementById("save").style.display="none";
								document.getElementById("submitPk").style.display="none";
								document.getElementById("back").style.display="none";
							}else if(msg.workstepfolw1.wsflRoleid!=msg.maxrole)
							{
								$("#pksgTable :input").attr("disabled",true);
								document.getElementById("save").style.display="none";
								document.getElementById("submitPk").style.display="none";
								document.getElementById("back").style.display="none";
							}else{
									$("#pksgTable :input").attr("disabled",false);
								}
						}else{
							var obj3=document.getElementsByName("ok");
							
							if(msg.pgsgl1.pksgAcademyopinion==msg.pgsgl1.pksgRecommendgrade)
							{
								obj3[0].checked="checked";
								$('#final').attr("disabled",false);
							}else{
								
								obj3[1].checked="checked";
								
								$("#final").val(msg.pgsgl1.pksgAcademyopinion);
							}
								$("#pksgTable :input").attr("disabled",true);
								document.getElementById("institutionopinion").style.display="";
								document.getElementById("save").style.display="none";
								document.getElementById("submitPk").style.display="none";
								document.getElementById("back").style.display="none";
						}
					}
			}
			else{
			}
			},error : {
			}
		});
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
function checknum(a)
{
	
	if(document.getElementById(a).value=="")
	{
		alert("人均年收入输入不能为空");
		return false;
	}else if(!isDigit(document.getElementById(a).value)){
		alert("人均年收入请输入整数！");
		return false;
	}else{
		return true;
	}
}
function isDigit(s) 
{ 

var patrn=/^[0-9]{1,20}$/; 

if (!patrn.exec(s)) return false ;

return true ;

}