
var allList;//存所有信息
var list;//存筛选后的信息
var rightlist;
var state;
/*var studentIds =new Array();*/
var studentId =new Array();
$(document).ready(function (){
	showStuList();
	$("#allyes").click(function(){
		 var obj=document.getElementsByName("will");
			for(var i=0;i<obj.length;i++){
				obj[i].checked = true;			
			}
		
	});
	$("#allno").click(function(){
		 var obj=document.getElementsByName("will");
		 
			for(var i=0;i<obj.length;i++){
				obj[i].checked =false;			
			}
		
	});
});


function changeState(){
	var num1=number();
	if(num1!=0){
	 $('#num').html(num1);
	 $('#sureChange').modal('show');
	 $('#confirm_change').click(function(){
		 $('#changeState').modal('show');
			var B_id ="javascript:sureChangeAllState("+")";																									
			$(".surechangeState").attr("onclick",B_id);
	});
	
	}else{
		 $('#reminder').modal('show');
	}       
}


function number(){
	var a = 0;
	var num=0;
	var obj=document.getElementsByName("will");
	for(var i=0;i<obj.length;i++){
		if(obj[i].checked==true){
			studentId[a++]=obj[i].value;
			num++;
		}
	}
	return num;
}

function  sureChangeAllState(){

	var num1=number();
	var prize="";
	var parent ="";
	var learning="";
	var detail = "";
	var obj1=document.getElementsByName("prizeRadio");
	var obj2=document.getElementsByName("parentRadio");
	var obj3=document.getElementsByName("learningRadio");
	var obj4=document.getElementsByName("detailRadio");
	for(var i=0; i<obj1.length; i ++){
	    if(obj1[i].checked){
	    	prize=obj1[i].value;
	        }
	    }
	for(var i=0; i<obj2.length; i ++){
    if(obj2[i].checked){
    	parent=obj2[i].value;
        }
    }
	for(var i=0; i<obj3.length; i ++){
	    if(obj3[i].checked){
	    	learning=obj3[i].value;
	        }
	    }

	for(var i=0; i<obj4.length; i ++){
	    if(obj4[i].checked){
	    	detail=obj4[i].value;
	        }
	    }
	if( prize!="" && parent !="" && learning !="" && detail!=""){
	var a=0;
	for( var j=0;j<num1;j++){
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/informationController/changeOneState.do',
			async : false,
			data : {
				 prizeState:prize,
				 parentState:parent,
				 learningState:learning,
				 detailState:detail,
				 stuId:studentId[j]
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){
				      a++;
					 $('#changeState').modal('hide');
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}

		});	
		if(a<num1){
			document.getElementById("jindu").style.display = "block";
		}
		if(a==num1){
			document.getElementById("jindu").style.display = "none";
			alert("修改成功！");
		}	
	}
	}else{
		alert("请完善选择！");
	}
	
}


function changeOneState(studentId){
	 $('#changeOneState').modal('show');
	var B_id ="javascript:sureChangeOneState("+studentId+")";	
	$(".surechangeState1").attr("onclick",B_id);
	 
}

function sureChangeOneState(studentId){
	var prize="";
	var parent ="";
	var learning="";
	var detail = "";
	var obj1=document.getElementsByName("prizeRadio1");
	var obj2=document.getElementsByName("parentRadio1");
	var obj3=document.getElementsByName("learningRadio1");
	var obj4=document.getElementsByName("detailRadio1");
	for(var i=0; i<obj1.length; i ++){
	    if(obj1[i].checked){
	    	prize=obj1[i].value;
	        }
	    }
	for(var i=0; i<obj2.length; i ++){
    if(obj2[i].checked){
    	parent=obj2[i].value;
        }
    }
	for(var i=0; i<obj3.length; i ++){
	    if(obj3[i].checked){
	    	learning=obj3[i].value;
	        }
	    }

	for(var i=0; i<obj4.length; i ++){
	    if(obj4[i].checked){
	    	detail=obj4[i].value;
	        }
	    }
	if( prize!="" && parent !="" && learning !="" && detail!="")
	{
		$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/informationController/changeOneState.do',
		async : false,
		data : {
			 prizeState:prize,
			 parentState:parent,
			 learningState:learning,
			 detailState:detail,
			 stuId:studentId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				alert("修改成功！");
				 $('#changeOneState').modal('hide');
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}

	});	
		}else{
			alert("请完善页面上的选择项！")
		}
	
}
function showStuList(){
	document.getElementById("buttons").style.display = "block";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/studentController/showStuList.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true){
				
				document.getElementById("colleage").disabled="disabled";
				var optioni = "<option value='"+msg.institution.instId+"'>"+msg.institution.instName+"</option>";
				$("#colleage").empty().append(optioni);
				var optionm="<option value = 0>全部</option>";
				$.each(msg.major, function(key, val) {
					optionm += "<option value=\"" + val.majrId + "\">" + val.majrName + "</option>";
				});
				$("#major").empty().append(optionm);
				alllist=msg.students;
			    var pageStuList = new Array();
			    var recordCount = alllist.length;
				var pageCount;// 总页数
				var temp = recordCount % 10;// 10条记录一页
				if (temp == 0) {
					pageCount =parseInt(recordCount / 10);
				} else {
					pageCount = 	parseInt(recordCount / 10) + 1;
				}
				var max = 0;
				max =  	alllist.length>  10 ? 10:alllist.length
				var a=0;
				for (var j = 0; j < max; j++) {
					pageStuList[a++]=alllist[j];
				}
				
				
				var students="<thead><tr><th>选择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>查看详细信息</th><th>修改编辑权限</th></tr></thead>";
				  for(var i=0 ;i<pageStuList.length;i++){
					  /*studentIds[i]=pageStuList[i].studentId;*/
						students+="<tr>"+"<td>"+ "<input type='checkbox' class='noborder' name='will' id='yes' value='"+pageStuList[i].studentId+"'>"+"</td><td>"+pageStuList[i].studentName+"</td><td>"+pageStuList[i].studentNumber+"</td>"
						+"<td>"+
						"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studentId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td>"+"<td>"+"<a href=\"javascript:changeOneState("
						 + pageStuList[i].studentId
						 + ")\"><button type='button' class='btn btn-success btn-xs'>修改权限</button>" + "</a>"+"</td>"+"</tr>";
				        }
					$("#students").empty().append(students);
				$("#studentList").paginate({
					count 		: pageCount,
					start 		: 1,
					display     : 10,
					border					: true,
					border_color			: '#fff',
					text_color  			: '#fff',
					background_color    	: 'rgb(66,139,202)',
					border_hover_color		: '#ccc',
					text_hover_color  		: '#000',
					background_hover_color	: '#fff', 
					images					: false,
					mouse					: 'press',
					onChange     			: function(page){
						
					    var pageStuList = new Array();
							var max = 0;
							max = alllist.length > page * 10 ? page * 10:
								 alllist.length;
							var a=0;
							for (var j = (page - 1) * 10; j < max; j++) {
								pageStuList[a++]=alllist[j];
							}
							var students="<thead><tr><th>选择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>查看详细信息</th><th>修改编辑权限</th></tr></thead>";
							  for(var i=0 ;i<pageStuList.length;i++){
			         /*	studentIds[i]=pageStuList[i].studentId;*/
									students+="<tr>"+"<td>"+ "<input type='checkbox' class='noborder' name='will' id='yes' value='"+pageStuList[i].studentId+"'>"+"</td><td>"+pageStuList[i].studentName+"</td><td>"+pageStuList[i].studentNumber+"</td>"
									+"<td>"+
									"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studentId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td>"+"<td>"+"<a href=\"javascript:changeOneState("
									 + pageStuList[i].studentId
									 + ")\"><button type='button' class='btn btn-success btn-xs'>修改权限</button>" + "</a>"+"</td>"+"</tr>";
							        }
								$("#students").empty().append(students);
					}
				});
			}else{
				
			}
		},error : function(msg) {
			alert("网络超时！");
		}
	});	
}

function serch(){
	document.getElementById("studentList").style.display = "block";
	document.getElementById("buttons").style.display = "block";
	var a=0;
	rightlist = new Array();
	$.each(alllist, function(key, val) {
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		if (colleageId  == "0")
			colleageId = val.instId;
		if (majorId  == "0")
			majorId = val.majrId;
		if (classId == "0")
			classId = val.classId;
		if (colleageId == val.instId && majorId == val.majrId && classId == val.classId) {
			rightlist[a] = val;
			++a;
		}
		
	});
				list =rightlist;
				    var recordCount = list.length;
					var pageCount1;// 总页数
					var temp = recordCount % 10;// 10条记录一页
					if (temp == 0) {
						pageCount1 =parseInt(recordCount / 10);
					} else {
						pageCount1 = parseInt(recordCount / 10) + 1;
					}
				var pageStuList = new Array();
				var max = 0;
				max =  list.length>  10 ? 10:list.length
				var a=0;
				for (var j = 0; j < max; j++) {
					pageStuList[a++]=list[j];
				}
				var students="<thead><tr><th>选择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>查看详细信息</th><th>修改编辑权限</th></tr></thead>";
				  for(var i=0 ;i<pageStuList.length;i++){
					   /*studentIds[i]=pageStuList[i].studentId;*/
						students+="<tr>"+"<td>"+ "<input type='checkbox' class='noborder' name='will' id='yes' value='"+pageStuList[i].studentId+"'>"+"</td><td>"+pageStuList[i].studentName+"</td><td>"+pageStuList[i].studentNumber+"</td>"
						+"<td>"+
						"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studentId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td>"+"<td>"+"<a href=\"javascript:changeOneState("
						 + pageStuList[i].studentId
						 + ")\"><button type='button' class='btn btn-success btn-xs'>修改权限</button>" + "</a>"+"</td>"+"</tr>";
				        }
					$("#students").empty().append(students);
				$("#studentList").paginate({
					count 		: pageCount1,
					start 		: 1,
					display     : 10,
					border					: true,
					border_color			: '#fff',
					text_color  			: '#fff',
					background_color    	: 'rgb(66,139,202)',
					border_hover_color		: '#ccc',
					text_hover_color  		: '#000',
					background_hover_color	: '#fff', 
					images					: false,
					mouse					: 'press',
					onChange     			: function(page){
						
						    var recordCount = list.length;
						    var pageStuList = new Array();
							var max = 0;
							max = recordCount > page * 10 ? page * 10:
									recordCount;
							var a=0;
							for (var j = (page - 1) * 10; j < max; j++) {
								pageStuList[a++]=list[j];
							}
							
							var students="<thead><tr><th>选择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>查看详细信息</th><th>修改编辑权限</th></tr></thead>";
							  for(var i=0 ;i<pageStuList.length;i++){
								 /*  studentIds[i]=pageStuList[i].studentId;*/
									students+="<tr>"+"<td>"+ "<input type='checkbox' class='noborder' name='will' id='yes' value='"+pageStuList[i].studentId+"'>"+"</td><td>"+pageStuList[i].studentName+"</td><td>"+pageStuList[i].studentNumber+"</td>"
									+"<td>"+
									"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studentId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td>"+"<td>"+"<a href=\"javascript:changeOneState("
									 + pageStuList[i].studentId
									 + ")\"><button type='button' class='btn btn-success btn-xs'>修改权限</button>" + "</a>"+"</td>"+"</tr>";
							        }
								$("#students").empty().append(students);
					}
		});
}


function majorChange() {
	var majorid = $("#major").val();
	var option = "";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjzxjController/findClass.do',
		async : false,
		data : {
			majorid : majorid,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.stuclass != null) {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$.each(msg.stuclass, function(key, val) {
						option += "<option value=\"" + val.classId + "\">" + val.className + "</option>";
					});
					$("#stuclass").empty().append(option);
				} else {
					option += "<option value=\"0\" selected=\"selected\">全部</option>";
					$("#stuclass").empty().append(option);
				}
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function searchBykey()	{
	document.getElementById("studentList").style.display = "none";
	document.getElementById("buttons").style.display = "block";
    var key =  $("#seachKey").val();
	key= ignoreSpaces(key);
	state =isDigit(key);
	
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/studentController/queryStuByKey.do',
			async : false,
			data : {
				key:key,
				state:state
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result==true){
					if(state==0){
						studentId[0]=msg.student.studId;
						var students="<thead><tr><th>选择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>查看详细信息</th><th>修改编辑权限</th></tr></thead>";
						students+="<tr>"+"<td>"+ "<input type='checkbox' class='noborder' name='will' id='yes' value='"+msg.student.studId+"'>"+"</td><td>"+msg.student.studName+"</td><td>"+msg.student.studNumber+"</td>"
						+"<td>"+
						"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+msg.student.studId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td>"+"<td>"+"<a href=\"javascript:changeOneState("
						 + msg.student.studId
						 + ")\"><button type='button' class='btn btn-success btn-xs'>修改权限</button>" + "</a>"+"</td>"+"</tr>";			        
					$("#students").empty().append(students);
					}
					else if(state==1){
						var students="<thead><tr><th>选择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>查看详细信息</th><th>修改编辑权限</th></tr></thead>";
						$.each(msg.stuList, function(key, val){
							students+="<tr>"+"<td>"+ "<input type='checkbox' class='noborder' name='will' id='yes' value='"+val.studId+"'>"+"</td><td>"+val.studName+"</td><td>"+val.studNumber+"</td>"
							+"<td>"+
							"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+val.studId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td>"+"<td>"+"<a href=\"javascript:changeOneState("
							 + val.studId
							 + ")\"><button type='button' class='btn btn-success btn-xs'>修改权限</button>" + "</a>"+"</td>"+"</tr>";			        
						});	
						$("#students").empty().append(students);
						
					}
				}else{
					var info = "<tr>"+"<td>"+"查找结果为空！"+"</td>"+"</tr>";
					document.getElementById("buttons").style.display = "none";
					$("#students").empty().append(info);
				}
				
			},error: function(msg){
			    alert("网络超时！");
			}
	});
}

document.onkeydown = function(e){    
    var ev = document.all ? window.event : e;  
    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
        //要处理的事件  
    	var seachKey= $("#seachKey").val();
    	if(seachKey!=null )   //回车键的键值为13 
   		 document.getElementById("QueryByKey").click(); 
     }
  };
  
function ignoreSpaces(string) {  
	 var temp = "";  
	 string = '' + string;  
	 splitstring = string.split(" "); //双引号之间是个空格；   
	 for(i = 0; i < splitstring.length; i++)  
	 temp += splitstring[i];  
	 return temp;  
	 }  

 function checkRate(input)//验证数字
 {  
     var  pattern= /^[0-9]+.?[0-9]*$/;   
 	 flag = pattern.test(value); 
 	if (flag) {
		return 0;
	} else {
		return 1;
	}
 } 
 
 
 function isDigit(str) //验证汉字
 { 
  var reg =/^[\u4e00-\u9fa5]+$/i; 
  if (!reg.test( str)) 
  {
   return 0; 
   }
   return 1;
 }


