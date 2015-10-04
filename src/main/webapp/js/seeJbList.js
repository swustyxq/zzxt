var countlist;// 全部信息
var list;//筛选后的信息
var List;
$(document).ready(function(){
	showAllJbinfo();
	//下载
	$("#download").click(function(){
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/jbController/downLoadJbByConditions.do',
			async : false,
			data : {
				colleageId:	colleageId,
				majorId:	majorId,
				classId:    classId,
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result==true){
					location.href="/zzxt/jbController/download.do?id=1";
					}
			},error: function(msg){
			    alert("网络超时！");
			}
	});
		
		});
	
});

//显示当前角色能看到的所有学费奖补信息
function showAllJbinfo(){
	$.ajax({
		type:"post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/jbController/showAllJbinfo.do',
		async : false,
		data : {
			
		},
		success : function(msg) {
			if(msg.result == true){	
				 countlist =msg.AllXfjbList;
				 if(msg.userType==1){
					 document.getElementById("xianshi").style.display="none";
					 document.getElementById("fenye").style.display="none";
				 }
				    var pageList = new Array();
					var max = 0;
					max = countlist.length>  10 ? 10: countlist.length
					var a=0;
					for (var j = 0; j < max; j++) {
						pageList[a++]=countlist[j];
					}
					var str = "<tr><th>#</th><th>姓名</th><th>学号</th><th>学院</th><th>专业</th><th>班级</th><th>操作</th></tr>";
					for(var i=0;i<pageList.length;i++){
						str += "<tr>";
						str += "<td>" + (i+1) + "</td>";
						str += "<td>" + pageList[i].stuName + "</td>";
						str += "<td>" + pageList[i].stuNumber + "</td>";
						str += "<td>" + pageList[i].instName + "</td>";
						str += "<td>" + pageList[i].majrName + "</td>";
						str += "<td>" + pageList[i].className + "</td>";
						str += "<td>" +"<a href=\"/zzxt/htmls/seeJbDetail.html?id="+pageList[i].xfjbStudid+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>" + "</td>";
						str+="</tr>";	
					}
					$("#xfjbList").empty().append(str);
					$("#fenye").paginate({
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
							
						    var recordCount = countlist.length;
						    var pageList = new Array();
							var max = 0;
							max = recordCount > page * 10 ? page * 10:
									recordCount;
							var a=0;
							for (var j = (page - 1) * 10; j < max; j++) {
								pageList[a++]=countlist[j];
							}
								var str = "<tr><th>#</th><th>姓名</th><th>学号</th><th>学院</th><th>专业</th><th>班级</th><th>操作</th></tr>";
								for(var i=0;i<pageList.length;i++){
									str += "<tr>";
									str += "<td>" + (i+1) + "</td>";
									str += "<td>" + pageList[i].stuName + "</td>";
									str += "<td>" + pageList[i].stuNumber + "</td>";
									str += "<td>" + pageList[i].instName + "</td>";
									str += "<td>" + pageList[i].majrName + "</td>";
									str += "<td>" + pageList[i].className + "</td>";
									str += "<td>" +"<a href=\"/zzxt/htmls/seeJbDetail.html?id="+pageList[i].xfjbStudid+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>" + "</td>";
									str+="</tr>";	
								}
								$("#xfjbList").empty().append(str);	
						}
					});
			}else{
				$("#xfjbList").empty().append("<tr>"+"<td>"+msg.message+"</td>"+"</tr>");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}

function queryJbByConditions(){
	document.getElementById("reInfo").style.display="none";
	document.getElementById("fenye").style.display="block";
	colleageId = document.getElementById("colleage").value;
	majorId = document.getElementById("major").value;
	classId = document.getElementById("stuclass").value;
	$.ajax({
		type:"post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/jbController/queryJbByConditions.do',
		async : false,
		data : {
			colleageId:	colleageId,
			majorId:	majorId,
			classId:    classId
		},
		success : function(msg) {
			if(msg.result == true){	
				   list = msg.xfjbList;
				   var pageList = new Array();
					var max = 0;
					max =  	 list.length>  10 ? 10: list.length
					var a=0;
					for (var j = 0; j < max; j++) {
						pageList[a++]=list[j];
					}
					var str = "<tr><th>#</th><th>姓名</th><th>学号</th><th>学院</th><th>专业</th><th>班级</th><th>操作</th></tr>";
					for(var i=0;i<pageList.length;i++){
						str += "<tr>";
						str += "<td>" + (i+1) + "</td>";
						str += "<td>" + pageList[i].stuName + "</td>";
						str += "<td>" + pageList[i].stuNumber + "</td>";
						str += "<td>" + pageList[i].instName + "</td>";
						str += "<td>" + pageList[i].majrName + "</td>";
						str += "<td>" + pageList[i].className + "</td>";
						str += "<td>" +"<a href=\"/zzxt/htmls/seeJbDetail.html?id="+pageList[i].xfjbStudid+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>" + "</td>";
						str+="</tr>";	
					}
					$("#xfjbList").empty().append(str);
					$("#fenye").paginate({
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
								pageList[a++]=list[j];
							}
								var str = "<tr><th>#</th><th>姓名</th><th>学号</th><th>学院</th><th>专业</th><th>班级</th><th>操作</th></tr>";
								for(var i=0;i<pageList.length;i++){
									str += "<tr>";
									str += "<td>" + (i+1) + "</td>";
									str += "<td>" + pageList[i].stuName + "</td>";
									str += "<td>" + pageList[i].stuNumber + "</td>";
									str += "<td>" + pageList[i].instName + "</td>";
									str += "<td>" + pageList[i].majrName + "</td>";
									str += "<td>" + pageList[i].className + "</td>";
									str += "<td>" +"<a href=\"/zzxt/htmls/seeJbDetail.html?id="+pageList[i].xfjbStudid+"\"><button type=\"button\" class=\"btn btn-success btn-xs\">查看详细信息</button></a>" + "</td>";
									str+="</tr>";	
								}
								$("#xfjbList").empty().append(str);	
						}
					});
			}else{
				$("#xfjbList").empty().append("<tr>"+"<td>"+msg.message+"</td>"+"</tr>");
				document.getElementById("fenye").style.display="none";
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}


function tongji(){
	
	$("#xfjbList").empty().append("<tr>"+"<td>"+"加载中，请稍后。。。。。"+"<td>"+"</tr>");
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/jbController/countByAcademy.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				List= msg.xfjbTjModels;
			     type=msg.type;
				
			}
		},
		error : function(msg) {
			List="";
			alert("网络超时！");
		}
	});
	
    var str1;
	if(type==2){
		
		str1 = "<tr><th>#</th><th>班级</th><th>班级总人数</th>";
	
	}else if(type==3 ||type ==4 ||type ==5){
		
		str1 = "<tr><th>#</th><th>专业</th><th>专业总人数</th>";
	}else if(type==6){
		
		str1 = "<tr><th>#</th><th>学院</th><th>学院总人数</th>";
	}
	var str = str1+"<th>获得奖补人数</th><th>奖补总金额</th></tr>";
	if(List!=null){
	for(var i=0;i<List.length;++i){
			if(type==2){
				var academyid =  $("#stuclass").val();				
			}else if(type==3 ||type ==4 ||type ==5){
				var academyid = $("#major").val();				
			}else if(type==6){
				var academyid = $("#colleage").val();				
			}
		
		if(academyid==0)
			academyid = List[i].instid;
		if(academyid == List[i].instid){
			str += "<tr>";
			str += "<td>" + (i+1) + "</td>";
			str += "<td>" +List[i].name + "</td>";
			str += "<td>" + List[i].studentsum + "</td>";
			str += "<td>" + List[i].sum + "</td>";
			str += "<td>" + List[i].amount + "</td>";
			str+="</tr>";
		}
	}
	}
	$("#xfjbList").empty().append(str);
	document.getElementById("fenye").style.display="none";
	document.getElementById("reInfo").style.display="block";
	$("#reInfo").empty().attr("align","center").append("<button id='Query' class='btn btn-primary' onclick='javascript:query()' type='button'>以当前条件返回</button>");
}

function query(){
	     document.getElementById("QueryByConditions").click(); 
	     //document.getElementById("reInfo").style.display="none";
		//document.getElementById("fenye").style.display="none";
}