
var allList;//存所有信息
var list;//存筛选后的信息
var state;
$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/studentController/showAllStudents.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true){
				alllist=msg.students;
			    var pageStuList = new Array();
				var max = 0;
				max =  	alllist.length>  10 ? 10:alllist.length;
				var a=0;
				for (var j = 0; j < max; j++) {
					pageStuList[a++]=alllist[j];
				}
				var students="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>民族</th><th>身份证号码</th><th>查看详细信息</th></tr></thead>";
				  for(var i=0 ;i<pageStuList.length;i++){
						students+="<tr><td>"+pageStuList[i].studName+"</td><td>"+pageStuList[i].studNumber+"</td><td>"+
						pageStuList[i].studNation+"</td><td>"+pageStuList[i].studIdnumber+"</td><td>"+
						"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td></tr>";
				        }
					$("#students").empty().append(students);
				$("#studentList").paginate({
					count 		: msg.pageCount,
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
							var students="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>民族</th><th>身份证号码</th><th>查看详细信息</th></tr></thead>";
						        for(var i=0 ;i<pageStuList.length;i++){
								students+="<tr><td>"+pageStuList[i].studName+"</td><td>"+pageStuList[i].studNumber+"</td><td>"+
								pageStuList[i].studNation+"</td><td>"+pageStuList[i].studIdnumber+"</td><td>"+
								"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td></tr>";
						        }
							$("#students").empty().append(students);
					}
				});
				}
			else{
				$("#students").empty().append("无数据");
			}
		},error : function(msg) {
			alert("网络超时！");
		}
	});
	
	

	    	
	//下载
	$("#download").click(function(){
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		stuSex = document.getElementById("stuSex").value;
		stuNation=document.getElementById("stuNation").value;
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/studentController/queryStuByConditions.do',
			async : false,
			data : {
				colleageId:	colleageId,
				majorId:	majorId,
				classId:    classId,
				stuSex :    stuSex ,
				stuNation:   stuNation
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result==true){
					}
			},error: function(msg){
			    alert("网络超时！");
			}
	});
		location.href="/zzxt/informationController/download.do?id=1";
		});
		
	$("#QueryByConditions").click(function(){
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		stuSex = document.getElementById("stuSex").value;
		stuNation=document.getElementById("stuNation").value;
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/studentController/queryStuByConditions.do',
			async : false,
			data : {
				colleageId:	colleageId,
				majorId:	majorId,
				classId:    classId,
				stuSex :    stuSex ,
				stuNation:   stuNation
			},
			dataType : 'json',
			success : function(msg) {
				document.getElementById("reInfo").style.display="none";	
				if(msg.result==true){
					list = msg.students;
					  var recordCount = list.length;
						var pageCount;// 总页数
						var temp = recordCount % 10;// 10条记录一页
						if (temp == 0) {
							pageCount = recordCount / 10;
						} else {
							pageCount = recordCount / 10 + 1;
						}
					var pageStuList = new Array();
					var max = 0;
					max =  list.length>  10 ? 10:list.length;
					var a=0;
					for (var j = 0; j < max; j++) {
						pageStuList[a++]=list[j];
					}
					var students="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>民族</th><th>身份证号码</th><th>查看详细信息</th></tr></thead>";
					   for( var i=0;i<pageStuList.length;i++){
						students+="<tr><td>"+pageStuList[i].studentName+"</td><td>"+pageStuList[i].studentNumber+"</td><td>"+
						pageStuList[i].studentNation+"</td><td>"+pageStuList[i].studentIDNumber+"</td><td>"+
						"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studentId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td></tr>";
					}
						$("#students").empty().append(students);
					$("#studentList").paginate({
						count 		: msg.pageCount,
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
								
								var students="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>民族</th><th>身份证号码</th><th>查看详细信息</th></tr></thead>";
								   for( var i=0;i<pageStuList.length;i++){
									students+="<tr><td>"+pageStuList[i].studentName+"</td><td>"+pageStuList[i].studentNumber+"</td><td>"+
									pageStuList[i].studentNation+"</td><td>"+pageStuList[i].studentIDNumber+"</td><td>"+
									"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+pageStuList[i].studentId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td></tr>";
								}
									$("#students").empty().append(students);
						}
					});
					}
				else{
					$("#students").empty().append("");
					$("#studentList").empty().append("");
				}
			},error: function(msg){
			    alert("网络超时！");
			}
			
	});
		
	});
	
	$("#QueryByKey").click(function(){
		
	 var key =  $("#seachKey").val();
	key= ignoreSpaces(key);
	state =isDigit(key);
	 if(cheack1())
		 {
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
					var students="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>民族</th><th>身份证号码</th><th>查看详细信息</th></tr></thead>";
						students+="<tr><td>"+msg.student.studName+"</td><td>"+msg.student.studNumber+"</td><td>"+
						msg.student.studNation+"</td><td>"+msg.student.studIdnumber+"</td><td>"+
						"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+msg.student.studId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td></tr>";
					$("#students1").empty().append(students);
					}
					else if(state==1){
						var students="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>民族</th><th>身份证号码</th><th>查看详细信息</th></tr></thead>";
						$.each(msg.stuList, function(key, val){
							students+="<tr><td>"+val.studName+"</td><td>"+val.studNumber+"</td><td>"+
							val.studNation+"</td><td>"+val.studIdnumber+"</td><td>"+
							"<a href=\"/zzxt/htmls/seeStuDetail.html?id="+val.studId+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>"+"</td></tr>";
						});	
						$("#students1").empty().append(students);
						
					}
				}else{
					document.getElementById("noExist1").style.display = "block";
				}
				
			},error: function(msg){
			    alert("网络超时！");
			}
	});}
	});
	
	});

function empty1() {
	document.getElementById("validateId1").style.display = "none";
	document.getElementById("noExist1").style.display = "none";
	document.getElementById("seachKey").value="";
	$("#students1").empty().append("");
	}

function empty2() {

	document.getElementById("seachKey").value="";
}

function cheack1(){
	if($("#seachKey").val()==""){
		document.getElementById("validateId1").style.display = "block";
		return false;
	}else{
		return true;
	}
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
  


function count(){
	 var selectIndex1 = document.getElementById("colleage").selectedIndex;
	 var colleage = document.getElementById("colleage").options[selectIndex1].text;
	 var selectIndex2 = document.getElementById("major").selectedIndex;
	var major =  document.getElementById("major").options[selectIndex2].text ;
	var selectIndex3 = document.getElementById("stuclass").selectedIndex;
	var clas =  document.getElementById("stuclass").options[selectIndex3].text ;
	var selectIndex4 = document.getElementById("stuSex").selectedIndex;
	var sex=  document.getElementById("stuSex").options[selectIndex4].text ;
	var selectIndex5= document.getElementById("stuNation").selectedIndex;
	var nation=  document.getElementById("stuNation").options[selectIndex5].text ;
	colleageId = document.getElementById("colleage").value;
	majorId = document.getElementById("major").value;
	classId = document.getElementById("stuclass").value;
	stuSex = document.getElementById("stuSex").value;
	stuNation=document.getElementById("stuNation").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/studentController/queryStuByConditions.do',
		async : false,
		data : {
			colleageId:	colleageId,
			majorId:	majorId,
			classId:    classId,
			stuSex :    stuSex ,
			stuNation:   stuNation
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true){
				var countlist="";
				countlist+="<thead><tr><th>筛选信息</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>专&nbsp;&nbsp;&nbsp;业</th><th>班&nbsp;&nbsp;&nbsp;级</th><th>性&nbsp;&nbsp;&nbsp;别</th><th>民&nbsp;&nbsp;&nbsp;族</th></tr></thead>";
			    countlist+="<tbody><tr><td>&nbsp;</td>"+"<td>"+colleage+"</td>"+"<td>"+major+"</td>"+"<td>"+clas+"</td>"+"<td>"+sex+"</td>"+"<td>"+nation+"</td>";
				countlist+="<tr>"+"<th colspan=\"2\">筛选条件下人数统计</th>"+"<td colspan=\"4\">"+"共&nbsp;"+msg.count+"&nbsp;人"+"</td>"+"</tr>"+"</tbody>";
			    
				$("#students").empty().append(countlist);
				$("#studentList").empty().append("");
				}else{
					$("#students").empty().append("");
					$("#studentList").empty().append("");
				}
		},error: function(msg){
		    alert("网络超时！");
		}
});
	document.getElementById("reInfo").style.display="block";
	$("#reInfo").empty().attr("align","center").append("<button id='Query' class='btn btn-primary' onclick='javascript:query()' type='button'>以当前条件返回</button>");
}

function query(){
	    document.getElementById("QueryByConditions").click(); 
}


function tongji(){
	empty1();
	$("#studentTj").empty().append("<tr>"+"<td>"+"加载中，请稍后。。。。。"+"<td>"+"</tr>");
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/studentController/countByAcademy.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				countlist= msg.studentTjModels;
			     type=msg.type;
				
			}
		},
		error : function(msg) {
			countlist="";
			alert("网络超时！");
		}
	});
	
    var str1="";
	if(type==2){
		str1 = "<tr><th>#</th><th>班级</th><th>班级总人数</th>";
	
	}else if(type==3 ||type ==4 ||type ==5){
		str1 = "<tr><th>#</th><th>专业</th><th>专业总人数</th>";
	}else if(type==6){
		str1 = "<tr><th>#</th><th>学院</th><th>学院总人数</th>";
	}
	var str = str1+"<th>男生人数</th><th>女生人数</th><th>汉族人数</th><th>少数民族人数</th></tr>";
	if(countlist!=null){
	for(var i=0;i<countlist.length;++i){
	/*	var academyid = $("#colleage").val();*/
	/*	if(academyid==0)
			academyid = countlist[i].instid;
		if(academyid == countlist[i].instid){*/
			str += "<tr>";
			str += "<td>" + (i+1) + "</td>";
			str += "<td>" + countlist[i].name + "</td>";
			str += "<td>" + countlist[i].sum + "</td>";
			str += "<td>" + countlist[i].manSum + "</td>";
			str += "<td>" + countlist[i].womenSum + "</td>";
			str += "<td>" + countlist[i].hanNation + "</td>";
			str += "<td>" + countlist[i].minNation + "</td>";
			str+="</tr>";
	/*	}*/
	}
	}
	$("#studentTj").empty().append(str);
}

function ignoreSpaces(string) {  
	 var temp = "";  
	 string = '' + string;  
	 splitstring = string.split(" "); //双引号之间是个空格；   
	 for(var i = 0; i < splitstring.length; i++)  
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

