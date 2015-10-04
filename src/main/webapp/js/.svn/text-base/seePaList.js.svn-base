
var alllist;
var list;
$(document).ready(function(){
	var annual=$("#annual").val();
	document.onkeydown = function(e){    
	    var ev = document.all ? window.event : e;  
	    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
	        //要处理的事件  
	    	document.getElementById("Query").click(); //调用登录按钮的登录事件  
	    }
	  };
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/showALLPaStud.do',
		async : false,
		data : {
			annual:annual,
		},
		dataType : 'json',
		success : function(msg) {			
			if(msg.result ==true){
				var str="";
				alllist =msg.pabxbasicinfo;
				    var pageList = new Array();
				    var recordCount = alllist.length;
					var pageCount;// 总页数
					var temp = recordCount % 10;// 10条记录一页
					if (temp == 0) {
						pageCount =parseInt(recordCount / 10);
					} else {
						pageCount = parseInt(recordCount / 10) + 1;
					}
					var max = 0;
					max =  	alllist.length>  10 ? 10:alllist.length
					var a=0;
					for (var j = 0; j < max; j++) {
						pageList[a++]=alllist[j];
					}
					
					//alert(pageList.length);
				if(msg.pabxbasicinfo.length>0){
					if(msg.user.userType==1)
					{
						document.getElementById("table").style.display="none";
						document.getElementById("table2").style.display="none";
					}else if(msg.user.userType==2){
						document.getElementById("count1").style.display="none";
						document.getElementById("count2").style.display="none";
					}else if(msg.user.userType>5){
						document.getElementById("count2").style.display="none";
						document.getElementById("count3").style.display="none";						
					}else{
						document.getElementById("count1").style.display="none";							
					}
					
			  for(var i=0 ;i<pageList.length;i++){
				
						str+="<tr><td>"+(i+1)
						+"</td><td>"+pageList[i].studentName						
						+"</td><td>"+pageList[i].buyAnnual
						+"</td><td>"+pageList[i].instShortName
						+"</td><td>"+pageList[i].majrName
						+"</td><td>"+pageList[i].classShortName
						+"</td><td>"+"<a href=\"/zzxt/htmls/seePaDetail.html?id="+pageList[i].studentId+ "&"+ "annual="+pageList[i].buyAnnual+"\"><button type='button' class='btn btn-success btn-xs'>详细情况</button></a>"
						+"</td></tr>";
					  }
				$("#studentPaListTable").empty().append(str);
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
						str="";
					    var pageList = new Array();
							var max = 0;
							max = alllist.length > page * 10 ? page * 10:
								 alllist.length;
							var a=0;
							for (var j = (page - 1) * 10; j < max; j++) {
								pageList[a++]=alllist[j];
							}
							  for(var i=0 ;i<pageList.length;i++){
									
									str+="<tr><td>"+(i+1)
									+"</td><td>"+pageList[i].studentName						
									+"</td><td>"+pageList[i].buyAnnual
									+"</td><td>"+pageList[i].instShortName
									+"</td><td>"+pageList[i].majrName
									+"</td><td>"+pageList[i].classShortName
									+"</td><td>"+"<a href=\"/zzxt/htmls/seePaDetail.html?id="+pageList[i].studentId+ "&"+ "annual="+pageList[i].buyAnnual+"\"><button type='button' class='btn btn-success btn-xs'>详细情况</button></a>"
									+"</td></tr>";
								  }
							$("#studentPaListTable").empty().append(str);
					}
				});
			}else{
				$("#studentPaListTable").empty().append("<tr><td rowspan='7'><h3>没有学生信息！<h3></td></tr>");
				}
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	$("#Query").click(function(){
		  var annual=$("#annual").val();
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/paController/showPaStud.do',
			async : false,
			data : {
				annual:annual,
				colleageId:colleageId,
				majorId:majorId,
				classId:classId
			}, 
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){
					var str="";
					list =msg.pabxbasicinfo;
					    var pageList = new Array();
					    var recordCount = list.length;
						var pageCount;// 总页数
						var temp = recordCount % 10;// 10条记录一页
						if (temp == 0) {
							pageCount =parseInt(recordCount / 10);
						} else {
							pageCount = parseInt(recordCount / 10) + 1;
						}
						var max = 0;
						max =  	list.length>  10 ? 10:list.length
						var a=0;
						for (var j = 0; j < max; j++) {
							pageList[a++]=list[j];
						}
						
						//alert(pageList.length);
					if(msg.pabxbasicinfo.length>0){
						if(msg.user.userType==1)
						{
							document.getElementById("table").style.display="none";
							document.getElementById("table2").style.display="none";
						}else if(msg.user.userType==2){
							document.getElementById("count1").style.display="none";
							document.getElementById("count2").style.display="none";
						}else if(msg.user.userType>5){
							document.getElementById("count2").style.display="none";
							document.getElementById("count3").style.display="none";						
						}else{
							document.getElementById("count1").style.display="none";							
						}
						
				  for(var i=0 ;i<pageList.length;i++){
					
							str+="<tr><td>"+(i+1)
							+"</td><td>"+pageList[i].studentName						
							+"</td><td>"+pageList[i].buyAnnual
							+"</td><td>"+pageList[i].instShortName
							+"</td><td>"+pageList[i].majrName
							+"</td><td>"+pageList[i].classShortName
							+"</td><td>"+"<a href=\"/zzxt/htmls/seePaDetail.html?id="+pageList[i].studentId+ "&"+ "annual="+pageList[i].buyAnnual+"\"><button type='button' class='btn btn-success btn-xs'>详细情况</button></a>"
							+"</td></tr>";
						  }
					$("#studentPaListTable").empty().append(str);
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
							str="";
						    var pageList = new Array();
								var max = 0;
								max = list.length > page * 10 ? page * 10:
									 list.length;
								var a=0;
								for (var j = (page - 1) * 10; j < max; j++) {
									pageList[a++]=list[j];
								}
								  for(var i=0 ;i<pageList.length;i++){
										
										str+="<tr><td>"+(i+1)
										+"</td><td>"+pageList[i].studentName						
										+"</td><td>"+pageList[i].buyAnnual
										+"</td><td>"+pageList[i].instShortName
										+"</td><td>"+pageList[i].majrName
										+"</td><td>"+pageList[i].classShortName
										+"</td><td>"+"<a href=\"/zzxt/htmls/seePaDetail.html?id="+pageList[i].studentId+ "&"+ "annual="+pageList[i].buyAnnual+"\"><button type='button' class='btn btn-success btn-xs'>详细情况</button></a>"
										+"</td></tr>";
									  }
								$("#studentPaListTable").empty().append(str);
						}
					});
				}else{
					$("#studentPaListTable").empty().append("<tr><td rowspan='7'><h3>没有学生信息！<h3></td></tr>");
					}
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时!");
			}
		});
	});
});
function export1(){     //导出表格
	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/export.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				location.href="/zzxt/paController/download.do?id=1";
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function countone(){//学院统计
	var annual=$("#annual").val();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/countColleage.do',
		async : false,
		data : {
			annual:annual,
		},
		dataType : 'json',
		success : function(msg) {
					if (msg.result == true) {
						var Info = "";
						Info = "<thead><tr><th>#</th><th>学院</th><th>购买人数</th><th>总人数</th><th>购买率</th></tr></thead>";
						for ( var i = 0; i < msg.countModals.length; i++) {
							Info += "<tr>";
							Info += "<td>" + (i + 1) + "</td>";
							Info += "<td>" + msg.countModals[i].name + "</td>";
							Info += "<td>" + msg.countModals[i].buyNum + "</td>";
							Info += "<td>" + msg.countModals[i].allNum + "</td>";
							var t = 0;
							t = parseInt((msg.countModals[i].buyNum * 100) / msg.countModals[i].allNum);
							if (msg.countModals[i].allNum != 0) {
								Info += "<td>" + t + "%" + "</td>";
							} else {
								Info += "<td>" + "--" + "</td>" + "</tr>" + "</tbody>";
							}
						}
						$("#info").empty().append(Info);
					}
				},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function counttwo(){//专业统计
	var annual=$("#annual").val();
	var colleageId = document.getElementById("colleage").value;	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/countMajor.do',
		async : false,
		data : {
			annual:annual,
			colleageId:colleageId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var Info = "";
				Info = "<thead><tr><th>#</th><th>专业</th><th>购买人数</th><th>总人数</th><th>购买率</th></tr></thead>";
				for ( var i = 0; i < msg.countModals.length; i++) {
					Info += "<tr>";
					Info += "<td>" + (i + 1) + "</td>";
					Info += "<td>" + msg.countModals[i].name + "</td>";
					Info += "<td>" + msg.countModals[i].buyNum + "</td>";
					Info += "<td>" + msg.countModals[i].allNum + "</td>";
					var t = 0;
					t = parseInt((msg.countModals[i].buyNum * 100) / msg.countModals[i].allNum);
					if (msg.countModals[i].allNum != 0) {
						Info += "<td>" + t + "%" + "</td>";
					} else {
						Info += "<td>" + "--" + "</td>" + "</tr>" + "</tbody>";
					}
				}
				$("#info").empty().append(Info);			
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function countthree(){//班级统计
	var annual=$("#annual").val();
	var colleageId = document.getElementById("colleage").value;	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/countClass.do',
		async : false,
		data : {
			annual:annual,
			colleageId:colleageId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var Info = "";
				Info = "<thead><tr><th>#</th><th>班级</th><th>购买人数</th><th>总人数</th><th>购买率</th></tr></thead>";
				for ( var i = 0; i < msg.countModals.length; i++) {
					Info += "<tr>";
					Info += "<td>" + (i + 1) + "</td>";
					Info += "<td>" + msg.countModals[i].name + "</td>";
					Info += "<td>" + msg.countModals[i].buyNum + "</td>";
					Info += "<td>" + msg.countModals[i].allNum + "</td>";
					var t = 0;
					t = parseInt((msg.countModals[i].buyNum * 100) / msg.countModals[i].allNum);
					if (msg.countModals[i].allNum != 0) {
						Info += "<td>" + t + "%" + "</td>";
					} else {
						Info += "<td>" + "--" + "</td>" + "</tr>" + "</tbody>";
					}
				}
				$("#info").empty().append(Info);
			
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}