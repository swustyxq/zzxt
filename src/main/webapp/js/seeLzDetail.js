$(document).ready(function(){
	var Request = new Object();
	Request = GetRequest();
	var studId = 0 ;
	if(Request!=null)
	{
	studId = Request['id'];
	}
	
	$.ajax({
			type:"post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/gjlzjxjController/readStudentByStudNumber.do',
			async : false,
			data : {
				studId:studId
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result == true){	
						var roleId=0;
						$.each(msg.role,function(key,val){
							if(val.roleId == msg.workstepfolw.wsflRoleid){
								roleId =1;
								//alert(val.roleId +" "+ msg.workstepfolw.wsflRoleid+" "+key);
							}
						});
						if(msg.user.userType==1){
							changebutton();
						}else{
							if(roleId == 1){//当前角色匹配工作流
								
							}else{
								changebutton();
							}
						}
						readinfo(msg);
				}else{	
					alert(msg.message);
					window.location.href = "login.html";
				}
			},error: function(msg){
			    alert("网络超时！");
			}
	});
	
	// 提交到gjlzjxj表
	$("#pass").click(function(){
		var state = true;
		insert(state,studId); 
	});
	$("#update").click(function(){
		var state = false;
		insert(state,studId);
	});
	// 获奖信息模态框的内容
	$("#btn1").click(function(){
		var xuhao = 1;
		$("#showPrizInfo").modal('show');
		$.ajax({
			type:"post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/prizeController/findPrizInfo.do',
			async : false,
			data : {
				studId:studId
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result == true){
					var prizelist ="";
					$.each(msg.prize,function(key,val){
						prizelist += "<tr>";
						prizelist +="<td >"+xuhao+"</td>"
									+"<td>"+val.prizTime+"</td>"
									+"<td>"+val.prizName+"</td>"
									+"<td>"+val.prizAwarded+"</td>"
									+"<td>"+"<input type='checkbox' name='radioxx' style='disabled:false' onchange='changezhuangtai1()' value="+val.prizId+">"+"</td>";
						prizelist += "</tr>";
						$("#reward1").empty().append(prizelist);
						xuhao += 1;
					});
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
	});
	
	});
	$("#reject").click(function(){
		$.ajax({
			type:"post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/gjlzjxjController/rejectToStudent.do',
			async : false,
			data : {
				studId:studId
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result == true){
					alert("操作成功！");
					history.go(-1);
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
	});
	
	});
	var str= new Array();
	var j=0;
	$("#confirm").click(function(){
			var ob = document.getElementsByName("radioxx");
			for(var i=0; i<ob.length; i ++){
			    if(ob[i].checked){
			    	str[j]=ob[i].value;
			    	change(str[j]);
			    	//alert(str[j]);
			    	j++;
			    }
			}
	});
	$("#btn2").click(function(){
		kk=0;
		$("#rewrTime1").val("");
		$("#rewrName1").val("");
		$("#rewrAwarded1").val("");
		$("#rewrTime2").val("");
		$("#rewrName2").val("");
		$("#rewrAwarded2").val("");
		$("#rewrTime3").val("");
		$("#rewrName3").val("");
		$("#rewrAwarded3").val("");
		$("#rewrTime4").val("");
		$("#rewrName4").val("");
		$("#rewrAwarded4").val("");
});

	});

var kk = 0;
function change(p_id){
	
	kk += 1;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/prizeController/findPrizInfo1.do',
		async : false,
		data : {
			p_id:p_id
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				if(kk==1){
					$("#rewrTime1").val(msg.prize1.prizTime);
					$("#rewrName1").val(msg.prize1.prizName);
					$("#rewrAwarded1").val(msg.prize1.prizAwarded);
				}else if(kk==2){
					$("#rewrTime2").val(msg.prize1.prizTime);
					$("#rewrName2").val(msg.prize1.prizName);
					$("#rewrAwarded2").val(msg.prize1.prizAwarded);
				}else if(kk==3){
					$("#rewrTime3").val(msg.prize1.prizTime);
					$("#rewrName3").val(msg.prize1.prizName);
					$("#rewrAwarded3").val(msg.prize1.prizAwarded);
				}else if(kk==4){
					$("#rewrTime4").val(msg.prize1.prizTime);
					$("#rewrName4").val(msg.prize1.prizName);
					$("#rewrAwarded4").val(msg.prize1.prizAwarded);
				}else{
					//alert("最多只能选择四条记录！");
					changezhuangtai1();
				}
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	
	}

function changezhuangtai1(){
	var xuanze=0;
	var choice = document.getElementsByName("radioxx");
	for(var i =0;i<choice.length;i++){
		if(xuanze>=4){
			//alert("亲，你只能选择四条哦!");
			document.getElementById("qintishi").style.display="block";
			choice[i].checked=false;
		}else{
			document.getElementById("qintishi").style.display="none";
		}
		if(choice[i].checked){
			xuanze += 1;
		}
	}
}
//对申请理由一栏的判断
function onreasonCheck()
{
	if($("#gjlzApplyreason").val()=="")
	{
		document.getElementById("liyou").style.visibility="visible";
	}else if($("#gjlzApplyreason").val().length>600){
		document.getElementById("liyou2").style.visibility="visible";
	}else{
		document.getElementById("liyou").style.visibility="hidden";
		document.getElementById("liyou2").style.visibility="hidden";
	}
}
function onreasonClean()
{
	if($("#gjlzApplyreason").val()!=""){
		document.getElementById("liyou").style.visibility="hidden";
		document.getElementById("liyou2").style.visibility="hidden";
	}
}


//对名次一栏的判断
function onchengjiCheck(){
	if($("#gjlzRanking").val!=""){
		document.getElementById("chengji").style.visibility="hidden";
	}
}
//获取从list页面传过来的数据
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

function onclick1(){
	var ob = document.getElementsByName("radio2");
		for(var i=0; i<ob.length; i ++){
		    if(ob[i].checked){
		    	if(i==1){
		    		document.getElementById("paiming").disabled=true;
		    		document.getElementById("paiming").placeholder="";
		    		document.getElementById("mingcizongrenshu").disabled=true;
		    		document.getElementById("mingcizongrenshu").placeholder="";
		    	}else{
		    		document.getElementById("paiming").disabled=false;
		    		document.getElementById("paiming").placeholder="请输入";
		    		document.getElementById("mingcizongrenshu").disabled=false;
		    		document.getElementById("mingcizongrenshu").placeholder="请输入";
		    	}
		    }
		}
	}

function insert(state,studId){
	var rewrTime1 =$("#rewrTime1").val();
	var rewrName1 =$("#rewrName1").val();
	var rewrAwarded1 =$("#rewrAwarded1").val();
	var rewrTime2 =$("#rewrTime2").val();
	var rewrName2 =$("#rewrName2").val();
	var rewrAwarded2 =$("#rewrAwarded2").val();
	var rewrTime3 =$("#rewrTime3").val();
	var rewrName3 =$("#rewrName3").val();
	var rewrAwarded3 =$("#rewrAwarded3").val();
	var rewrTime4 =$("#rewrTime4").val();
	var rewrName4 =$("#rewrName4").val();
	var rewrAwarded4 =$("#rewrAwarded4").val();
	
	var gjlzApplyreason = $("#gjlzApplyreason").val();
	var gjlzResidence ="";
	var obj = document.getElementsByName("radio1");
    for(var i=0; i<obj.length; i ++){
        if(obj[i].checked){
        	if(i==0){
        		gjlzResidence=obj[0].value;
        	}else{
        		gjlzResidence=obj[1].value;
        	}
        }
    }

    //alert(gjlzResidence);
    var majorOption = $("#majorOption").val();
    var academyOption = $("#academyOption").val();
    var schoolOption = $("#schoolOption").val();
    var gjlzAllincomes = document.getElementById("stinAllincomes").innerHTML;
    var gjlzIncometype = document.getElementById("stinIncometype").innerHTML;
    var gjlzPopulation = document.getElementById("stinPopulation").innerHTML;
    var gjlzHome = document.getElementById("stinAreadeatilhome").innerHTML;
    var gjlzMailcode = document.getElementById("stinMailcode").innerHTML;
    var gjlzPoliticstate = document.getElementById("stinPoliticstate").innerHTML;
    var gjlzComprehensive = "";
    // 写进去还是？
    var obj2 = document.getElementsByName("radio2");
    for(var i=0; i<obj2.length; i++){
        if(obj2[i].checked){
        	if(i==0){
        		gjlzComprehensive=obj2[0].value;
        	}else {
        		gjlzComprehensive=obj2[1].value;
        	}
        }
    }
    var gjlzComprehensiveranking = "";
    var gjlzRanking = $("#gjlzRanking1").val()+"/"+$("#gjlzRanking2").val();
    gjlzComprehensiveranking = $("#gjlzComprehensiveranking1").val()+"/"+$("#gjlzComprehensiveranking2").val();
    //alert(gjlzRanking);
		$.ajax({
			type:"post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/gjlzjxjController/inputStudLzInfo.do',
			async : false,
			data : {
				gjlzApplyreason:gjlzApplyreason,
				gjlzResidence:gjlzResidence,
				gjlzAllincomes:gjlzAllincomes,
				gjlzIncometype:gjlzIncometype,
				gjlzPopulation:gjlzPopulation,
				gjlzHome:gjlzHome,
				gjlzMailcode:gjlzMailcode,
				gjlzRanking:gjlzRanking,
				gjlzComprehensive:gjlzComprehensive,
				gjlzComprehensiveranking:gjlzComprehensiveranking,
				gjlzPoliticstate:gjlzPoliticstate,
				state:state,
				studId:studId,
				majorOption:majorOption,
				academyOption:academyOption,
				schoolOption:schoolOption
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result == true){
					alert("操作成功！");
					
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
    
		
		
		// 此处插入的时候可能要根据workid和schoolshipid来确定获奖信息是否插入  若已插入则更新，若没有则插入
		$.ajax({
			type:"post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/rewardController/inputStudRewaInfo.do',
			async : false,
			data : {
				studId:0,
				rewrTime1:rewrTime1,
				rewrName1:rewrName1,
				rewrAwarded1:rewrAwarded1,
				rewrTime2:rewrTime2,
				rewrName2:rewrName2,
				rewrAwarded2:rewrAwarded2,
				rewrTime3:rewrTime3,
				rewrName3:rewrName3,
				rewrAwarded3:rewrAwarded3,
				rewrTime4:rewrTime4,
				rewrName4:rewrName4,
				rewrAwarded4:rewrAwarded4
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result == true){
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		
	
});
}	
	
function changebutton(){
	var str = "<button class='btn btn-info'onclick='javascript: history.go(-1);'>" +
	"<span class='glyphicon glyphicon-arrow-left'></span>返回</button>";
	$("#nonebutton").empty().append(str);
	$("#table0 :input").attr("disabled",true);
}
function readinfo(msg){
	$("#studIdnumber").empty().append(msg.student.studIdnumber);// 身份证号码
	$("#studNumber").empty().append(msg.student.studNumber);// 学号
	$("#studName").empty().append(msg.student.studName);// 姓名
	$("#studBirthday").empty().append(msg.student.studBirthday);// 生日
	$("#studNation").empty().append(msg.student.studNation);// 名族
	$("#studAdmissiontime").empty().append(msg.student.studAdmissiontime);// 入学时间
	if(msg.student.studIdnumber.substr(16,1)%2==1){
		$("#stinSex").empty().append("男");// 性别
	}else{
		$("#stinSex").empty().append("女");
	}

$("#majrName").empty().append(msg.major.majrName);// 专业
$("#majrEducationsystem").empty().append(msg.major.majrEducationsystem);// 学制
$("#stinPhone").empty().append(msg.studentInfo.stinPhone);// 电话
$("#stinPoliticstate").empty().append(msg.studentInfo.stinPoliticstate);// 政治面貌
$("#stinDepartment").empty().append(msg.studentInfo.stinDepartment);// 学院
$("#stinPopulation").empty().append(msg.studentInfo.stinPopulation);// 家庭人口总数
$("#stinAllincomes").empty().append(msg.studentInfo.stinAllincomes);// 家庭月总收入
$("#renjunyueshouru").empty().append(msg.studentInfo.stinAllincomes/msg.studentInfo.stinPopulation);// 人均月收入
$("#stinIncometype").empty().append(msg.studentInfo.stinIncometype);// 收入来源
$("#stinMailcode").empty().append(msg.studentInfo.stinMailcode);// 邮政编码

$("#stinAreadeatilhome").empty().append(msg.studentInfo.stinAreadeatilhome);// 家庭详细地址
//家庭户口===户口类型 单选框
var obj1 = document.getElementsByName("radio1");					
	for(var i=0;i<obj1.length;i++){
		obj1[i].checked = false;
	}
	if(msg.gjlzjxjwithblobs.gjlzResidence == "农村"){
		obj1[0].checked = "checked";
	}else{
		obj1[1].checked = "checked";
	}
//此处只输出当前学期的信息，因为年度需要确定，后面可能需要改动
$.each(msg.learning,function(key,val){
	$("#learRequirednumber").empty().append(val.learRequirednumber);// 必修课
	$("#learPassnumber").empty().append(val.learPassnumber);// 及格以上
	return false;
});
if(msg.gjlzjxjwithblobs){
	var gjlzRanking = msg.gjlzjxjwithblobs.gjlzRanking.split("/",1);
	$("#gjlzRanking1").val(gjlzRanking);
	$("#gjlzRanking2").val(gjlzRanking);
	var gjlzComprehensiveranking = msg.gjlzjxjwithblobs.gjlzComprehensiveranking.split("/",1);;
	$("#gjlzComprehensiveranking1").val(gjlzComprehensiveranking);
	$("#gjlzComprehensiveranking2").val(gjlzComprehensiveranking);
	$("#gjlzApplyreason").val(msg.gjlzjxjwithblobs.gjlzApplyreason);
	$("#majorOption").val(msg.gjlzjxjwithblobs.gjlzMajoropinion);
	$("#academyOption").val(msg.gjlzjxjwithblobs.gjlzAcademyopinion);
	$("#schoolOption").val(msg.gjlzjxjwithblobs.gjlzSchoolopinion);
	var rewrTime = new Array();
	var rewrName = new Array();
	var rewrAwarded = new Array();
	$.each(msg.reward,function(key,val){
		rewrTime[key] = val.rewrTime;
		rewrName[key] = val.rewrName;
		rewrAwarded[key] = val.rewrAwarded;
	});
	for(var j=0;j<=4;j++){
		if(j==0){
			$("#rewrTime1").val(rewrTime[j]);
			$("#rewrName1").val(rewrName[j]);
			$("#rewrAwarded1").val(rewrAwarded[j]);
		}else if(j==1){
			$("#rewrTime2").val(rewrTime[j]);
			$("#rewrName2").val(rewrName[j]);
			$("#rewrAwarded2").val(rewrAwarded[j]);
		}else if(j==3){
			$("#rewrTime3").val(rewrTime[j]);
			$("#rewrName3").val(rewrName[j]);
			$("#rewrAwarded3").val(rewrAwarded[j]);
		}else{
			$("#rewrTime4").val(rewrTime[j]);
			$("#rewrName4").val(rewrName[j]);
			$("#rewrAwarded4").val(rewrAwarded[j]);
		}
	}
}
}