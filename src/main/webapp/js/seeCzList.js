var czylIseditable;
var czylbxIds = new Array();
var year1;
var userType;
var colleageId=0 ;
var majorId=0 ;
var classId=0 ;
var sign=1;
var input="";
$(document).ready(function(){
	
	showInstitution();
	showOneyear();
	colleageId = document.getElementById("colleage").value;
	majorId = document.getElementById("major").value;
	classId = document.getElementById("stuclass").value;
	var allCzylTable123="";
	allCzylTable123 +="<thead ><tr><td><button type='button' class='btn btn-success btn-xs' id='allyes'>全选</button></td><td><button type='button' class='btn btn-success btn-xs' id='allno'>全不选</button></td><td><button type='button' class='btn btn-success btn-xs' id='change'>批量修改</button></td></tr></thead>";
	$("#buttons").empty().append(allCzylTable123);
	if(userType>=6){
	
		var allCzylTable="";
		allCzylTable +="<thead><tr><td><button type='button' class='btn btn-success' id='count'><span class='glyphicon glyphicon-share-alt'></span>按学院统计</button></td></tr></thead>";
		$("#count-button").empty().append(allCzylTable);
		
	}else{
		var allCzylTable="";
		var allCzylTable1="";
		allCzylTable1 +="<thead><tr><td><button type='button' class='btn btn-success' id='count1'><span class='glyphicon glyphicon-share-alt'></span>按专业统计</button></td></tr></thead>";
		allCzylTable +="<thead><tr><td><button type='button' class='btn btn-success' id='count2'><span class='glyphicon glyphicon-share-alt'></span>按班级统计</button></td></tr></thead>";
		$("#count-button1").empty().append(allCzylTable1);
		$("#count-button").empty().append(allCzylTable);
		
	}
$("#Query").click(function(){
	sign=1;
	$("#nameOrnumber").val("");
	$("#return").empty().append("");
	    var year=$("#year").val();
 
		var allCzylTable="";
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/czController/showCzStud.do',
			async : false,
			data : {
				year:year,
				colleageId:colleageId,
				majorId:majorId,
				classId:classId
			},
			beforeSend: function(){ 
		    	 var allCzylTable="";
		    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在查询,请稍后......</td></tr></thead>";
		    	$("#loader_container").empty().append(allCzylTable);
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){	
					
					remove_loading();
					year1=msg.firstCzylList[0].czlyBuyAnnual;
				
					statistics();
				allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;作</th></tr></thead>";
			for(var i=0;i<msg.firstCzylList.length;i++){
				 
				czylbxIds[i]=msg.firstCzylList[i].czylbxId;
				    allCzylTable +="<tr>";
				    allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>";
				    allCzylTable +=msg.firstCzylList[i].studentName + "</td><td> " +							
					msg.firstCzylList[i].studentNumber+ "</td><td> " +
					msg.firstCzylList[i].czlyBuyAnnual+ "</td><td> "  ;
					
				    if(msg.firstCzylList[i].czlyIsneed==1){
						allCzylTable+="是"+"</td><td>";
						}
					else if(msg.firstCzylList[i].czlyIsneed==0) {
						allCzylTable+="否"+"</td><td>";
					}
					else
						{
						allCzylTable+="还没有填写意愿"+"</td><td>";
						}
				 
				     if(msg.firstCzylList[i].czlyIssuccess==1){
						   allCzylTable+="购买成功"+"</td>";
						}
				 
					else if(msg.firstCzylList[i].czlyIssuccess==0){
						allCzylTable+="未购买"+"</td><";
					}
				 
					else{
						allCzylTable+="购买失败"+"</td>";
					}
				     
				  
				     allCzylTable +="<td>"
						 + "<a href=\"javascript:changeStuwill("
						 + msg.firstCzylList[i].studentId+","+year
						 +","+msg.firstCzylList[i].czylIseditable
						 +","+msg.firstCzylList[i].czlyIsneed
						 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
				    	 "<td>"
						 + "<a href=\"javascript:checkStuCzyl("
						 + msg.firstCzylList[i].studentId
						 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>";
				     
				    
				     
				}
			$("#czylState").empty().append(allCzylTable);
			$("#demo5").paginate({
				count 		: msg.pageCount,
				start 		: 1,
				display     : 50,
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
					
											$.ajax({
												type : "post",
												contentType : "application/x-www-form-urlencoded;charset=UTF-8",
												url : '/zzxt/czController/checkOnePageCzStud.do',
												async : false,
												data : {
													year:year,
													colleageId:colleageId,
													majorId:majorId,
													classId:classId,
													page:page
												},
												dataType : 'json',
												success : function(msg) {
													if(msg.result == true){	
														allCzylTable="";
														
														
														allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;&nbsp;作</th></tr></thead>";
														for(var i=0;i<msg.pageCzylList.length;i++){
															czylbxIds[i]=msg.pageCzylList[i].czylbxId;
															allCzylTable +="<tr>";
															 allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>" ;
															 allCzylTable +=msg.pageCzylList[i].studentName + "</td><td> " +							
																msg.pageCzylList[i].studentNumber+ "</td><td> " +
																msg.pageCzylList[i].czlyBuyAnnual+ "</td><td> ";
																
															    if(msg.pageCzylList[i].czlyIsneed==1){
																	allCzylTable+="是"+"</td><td>";
																	}
																else if(msg.pageCzylList[i].czlyIsneed==0) {
																	allCzylTable+="否"+"</td><td>";
																}
																else
																	{
																	allCzylTable+="还没有填写意愿"+"</td><td>";
																	}
															 
															     if(msg.pageCzylList[i].czlyIssuccess==1){
																	   allCzylTable+="购买成功"+"</td>";
																	}
															 
																else if(msg.pageCzylList[i].czlyIssuccess==0){
																	allCzylTable+="未购买"+"</td>";
																}
															 
																else{
																	allCzylTable+="购买失败"+"</td>";
																}
															     
															     allCzylTable +="<td>"
																	 + "<a href=\"javascript:changeStuwill("
																	 + msg.pageCzylList[i].studentId+","+year
																	 +","+msg.pageCzylList[i].czylIseditable
																	 +","+msg.pageCzylList[i].czlyIsneed
																	 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
															    	 "<td>"
																	 + "<a href=\"javascript:checkStuCzyl("
																	 + msg.pageCzylList[i].studentId
																	 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>";
															    
														}
														$("#czylState").empty().append(allCzylTable);
													}else{
														alert(msg.message);
													}
												},error: function(msg){
											        alert("网络超时！");
												}
											});
				}
			});
			
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
			$("#change").click(function(){

				
					changewills();
					       	
			});
				}else{
					remove_loading();
					alert(msg.message);
					year1=$("#year").val();
					allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;作</th></tr></thead>";
					$("#czylState").empty().append(allCzylTable);
					$("#demo5").paginate({
						count 		: 1,
						start 		: 1,
						display     : 50,
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
							
						}
							
						});
				}
		},error: function(msg){
			    alert("网络超时!");
			}
		});
	});
$(document).keydown(function(event){ 
	if(event.keyCode == 13){ //绑定回车 
	$('#Query1').click(); //自动触发精确查询按钮 
	} 
}); 
$("#Query1").click(function(){
	sign=0;
	input=$("#nameOrnumber").val();
	$("#return").empty().append("");
	var year=$("#year").val();
	var NameOrNumber=$("#nameOrnumber").val();
	var allCzylTable="";
	if(NameOrNumber=="")
		{
		 alert("查询条件不能为空，请重新输入");
		}
	else{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/checkOneCzStud.do',
		async : false,
		data : {
			year:year,
			NameOrNumber:NameOrNumber
		},
		    beforeSend: function(){ 
		    	 var allCzylTable="";
		    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在查询,请稍后......</td></tr></thead>";
		    	$("#loader_container").empty().append(allCzylTable);
			}, 
		dataType : 'json',
		success : function(msg) {			
			if(msg.result ==true){
				var allCzylTable123="";
				allCzylTable123 +="<thead ><tr><td><button type='button' class='btn btn-success btn-xs' id='allyes'>全选</button></td><td><button type='button' class='btn btn-success btn-xs' id='allno'>全不选</button></td><td><button type='button' class='btn btn-success btn-xs' id='change'>批量修改</button></td></tr></thead>";
				$("#buttons").empty().append(allCzylTable123);
				remove_loading();
				year1=msg.czylbxbasicinfo[0].czlyBuyAnnual;
				allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;&nbsp;作</th></tr></thead>";
				for(var i=0;i<msg.czylbxbasicinfo.length;i++){
					czylbxIds[i]=msg.czylbxbasicinfo[i].czylbxId;
					allCzylTable +="<tr>";
					  allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>" ;
					  allCzylTable +=msg.czylbxbasicinfo[i].studentName + "</td><td> " +							
						msg.czylbxbasicinfo[i].studentNumber+ "</td><td> " +
						msg.czylbxbasicinfo[i].czlyBuyAnnual+ "</td><td> ";
						
					    if(msg.czylbxbasicinfo[i].czlyIsneed==1){
							allCzylTable+="是"+"</td><td>";
							}
						else if(msg.czylbxbasicinfo[i].czlyIsneed==0) {
							allCzylTable+="否"+"</td><td>";
						}
						else
							{
							allCzylTable+="还没有填写意愿"+"</td><td>";
							}
					 
					     if(msg.czylbxbasicinfo[i].czlyIssuccess==1){
							   allCzylTable+="购买成功"+"</td>";
							}
					 
						else if(msg.czylbxbasicinfo[i].czlyIssuccess==0){
							allCzylTable+="未购买"+"</td>";
						}
					 
						else{
							allCzylTable+="购买失败"+"</td>";
						}
					     
					     allCzylTable +="<td>"
							 + "<a href=\"javascript:changeStuwill("
							 + msg.czylbxbasicinfo[i].studentId+","+year
							 +","+msg.czylbxbasicinfo[i].czylIseditable
							 +","+msg.czylbxbasicinfo[i].czlyIsneed
							 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
					    	 "<td>"
							 + "<a href=\"javascript:checkStuCzyl("
							 + msg.czylbxbasicinfo[i].studentId
							 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>";
					  
					     
					}
				$("#czylState").empty().append(allCzylTable);
				$("#demo5").paginate({
					count 		: 1,
					start 		: 1,
					display     : 50,
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
						
					}
						
					});
			
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
				$("#change").click(function(){

					
						changewills();
						       	
				});
		}else{
		
			remove_loading();
			alert(msg.message);
			allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;作</th></tr></thead>";
			$("#czylState").empty().append(allCzylTable);
			$("#demo5").paginate({
				count 		: 1,
				start 		: 1,
				display     : 50,
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
					
				}
					
				});
		}
	},error: function(msg){
	    alert("网络超时！");
	}
	
	
});
}	
});
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
$("#change").click(function(){

	
		changewills();
		       	
});
$("#export").click(function(){
	//alert(colleageId);

	     export1();  	
});
$("#count").click(function(){

	count1();  	
});
$("#count1").click(function(){

	count2major();  	
});
$("#count2").click(function(){

	count3class();  	
});
//$("#return1").click(function(){
  //	return2();
//});
});
function changewills(){
	var num1=number();
	if(num1!=0){
	if(window.confirm('你这次一共选择了'+num1+'名学生\n'+'    确定要修改吗？')){
		
		 $('#EditWills').modal('show');
			var B_id ="javascript:sureEditwills("+")";																									
			$(".sureEditwills").attr("onclick",B_id);
        //alert("确定");
       // return true;
     }else{
        //alert("取消");
       // return false;
    }
	}else{
		alert("你没有选择任何一人！");
	}       
		    	  			
}
function sureEditwills(){
	var num1=number();
	//var obj=document.getElementsByName("will");
	
	var obj1=document.getElementsByName("will1");
	var czylwill;
	for(var i=0; i<obj1.length; i ++){
   if(obj1[i].checked){
    	czylwill=obj1[i].value;
        }
   }
	if(czylwill!=null){	
		
	for(var i=0;i<num1;i++){
		
			
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/czController/editWills.do',
				async : false,
				data : {
					czylwill:czylwill,			
					czylbxId:czylbxIds[i]
				},
				dataType : 'json',
				success : function(msg) {
					if(msg.result ==true){
						
					}else{
						alert(msg.message);
					}
				},error: function(msg){
				    alert("网络超时！");
				}

			});	
		
	  }
	  $('#EditWills').modal('hide');
	alert("修改成功！");
	showOneyear();
	}else{		
		alert("选择不能为空，修改失败！" +"\n"
				+"     "+"请重新修改！");	
    }
}
function showOneyear(){
    var year=$("#year").val();
  
	var allCzylTable="";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/showALLCzStud.do',
		async : false,
		data : {
			year:year
		},
		beforeSend: function(){ 
	    	 var allCzylTable="";
	    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在查询,请稍后......</td></tr></thead>";
	    	$("#loader_container").empty().append(allCzylTable);
		}, 
		dataType : 'json',
		success : function(msg) {			
			if(msg.result ==true){
				remove_loading();
				 userType=msg.user.userType;
				year1=msg.firstCzylList[0].czlyBuyAnnual;			
				allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;&nbsp;作</th></tr></thead>";
				for(var i=0;i<msg.firstCzylList.length;i++){
					czylbxIds[i]=msg.firstCzylList[i].czylbxId;
					allCzylTable +="<tr>";
					  allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>";
					  allCzylTable +=msg.firstCzylList[i].studentName + "</td><td> " +							
						msg.firstCzylList[i].studentNumber+ "</td><td> " +
						msg.firstCzylList[i].czlyBuyAnnual+ "</td><td> ";
						
					    if(msg.firstCzylList[i].czlyIsneed==1){
							allCzylTable+="是"+"</td><td>";
							}
						else if(msg.firstCzylList[i].czlyIsneed==0) {
							allCzylTable+="否"+"</td><td>";
						}
						else
							{
							allCzylTable+="还没有填写意愿"+"</td><td>";
							}
					 
					     if(msg.firstCzylList[i].czlyIssuccess==1){
							   allCzylTable+="购买成功"+"</td>";
							}
					 
						else if(msg.firstCzylList[i].czlyIssuccess==0){
							allCzylTable+="未购买"+"</td>";
						}
					 
						else{
							allCzylTable+="购买失败"+"</td>";
						}
					     			
					     
					     allCzylTable +="<td>"
							 + "<a href=\"javascript:changeStuwill("
							 + msg.firstCzylList[i].studentId+","+year
							 +","+msg.firstCzylList[i].czylIseditable
							 +","+msg.firstCzylList[i].czlyIsneed
							 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
					    	 "<td>"
							 + "<a href=\"javascript:checkStuCzyl("
							 + msg.firstCzylList[i].studentId
							 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>";
					   
					     
					}
				$("#czylState").empty().append(allCzylTable);
				$("#demo5").paginate({
					count 		: msg.pageCount,
					start 		: 1,
					display     : 50,
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
						
												$.ajax({
													type : "post",
													contentType : "application/x-www-form-urlencoded;charset=UTF-8",
													url : '/zzxt/czController/showOnePageCzStud.do',
													async : false,
													data : {
														year:year,
														page:page
													},
													dataType : 'json',
													success : function(msg) {
														if(msg.result == true){	
															allCzylTable="";
															allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;&nbsp;作</th></tr></thead>";
															for(var i=0;i<msg.pageCzylList.length;i++){
																czylbxIds[i]=msg.pageCzylList[i].czylbxId;
																allCzylTable +="<tr>";
																  allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>";
																  allCzylTable +=msg.pageCzylList[i].studentName + "</td><td> " +							
																	msg.pageCzylList[i].studentNumber+ "</td><td> " +
																	msg.pageCzylList[i].czlyBuyAnnual+ "</td><td> ";
																	
																    if(msg.pageCzylList[i].czlyIsneed==1){
																		allCzylTable+="是"+"</td><td>";
																		}
																	else if(msg.pageCzylList[i].czlyIsneed==0) {
																		allCzylTable+="否"+"</td><td>";
																	}
																	else
																		{
																		allCzylTable+="还没有填写意愿"+"</td><td>";
																		}
																 
																     if(msg.pageCzylList[i].czlyIssuccess==1){
																		   allCzylTable+="购买成功"+"</td>";
																		}
																 
																	else if(msg.pageCzylList[i].czlyIssuccess==0){
																		allCzylTable+="未购买"+"</td>";
																	}
																 
																	else{
																		allCzylTable+="购买失败"+"</td>";
																	}
																     
																     allCzylTable +="<td>"
																		 + "<a href=\"javascript:changeStuwill("
																		 + msg.pageCzylList[i].studentId+","+year
																		 +","+msg.pageCzylList[i].czylIseditable
																		 +","+msg.pageCzylList[i].czlyIsneed
																		 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
																    	 "<td>"
																		 + "<a href=\"javascript:checkStuCzyl("
																		 + msg.pageCzylList[i].studentId
																		 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>" ;
																   
															}
															$("#czylState").empty().append(allCzylTable);
														}else{
															alert(msg.message);
														}
													},error: function(msg){
												        alert("网络超时！");
													}
												});
					}
				});
			
		}else{
			remove_loading();
			alert(msg.message);
			userType=msg.user.userType;
			year1=$("#year").val();
			allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;作</th></tr></thead>";
			$("#czylState").empty().append(allCzylTable);
			$("#demo5").paginate({
				count 		: 1,
				start 		: 1,
				display     : 50,
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
					
				}
					
				});
		}
	},error: function(msg){
	    alert("网络超时！");
	}
	
	
});
	
}
function checkStuCzyl(stuId){
	var year=$("#year").val();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/findoneCzyl.do',
		async : false,
		data : {
			stuId:stuId,
			year:year
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				
				document.getElementById("a1").innerHTML=msg.student.studName;
				document.getElementById("a2").innerHTML=msg.student.studNumber;
				document.getElementById("a3").innerHTML=msg.student.studIdnumber;
				document.getElementById("a4").innerHTML=msg.studentinfo.stinBanknumber;
				document.getElementById("a5").innerHTML=msg.czylbx.czlyMoney;
				document.getElementById("a6").innerHTML=msg.czylbx.czlyBuyannual;
				if(msg.czylbx.czlyIsneed==null){
					document.getElementById("a7").innerHTML="请填写您的意愿 ";
					}
				else{
					if(msg.czylbx.czlyIsneed==1)
					{
					document.getElementById("a7").innerHTML="是";
					
					}
					else{
						document.getElementById("a7").innerHTML="否";
					}
				}
				if(msg.czylbx.czylIseditable==1){
					document.getElementById("a8").innerHTML="&nbsp;是";
					}
				else{
					document.getElementById("a8").innerHTML="&nbsp;否";
				}
				
				if(msg.czylbx.czlyIssuccess==1){
					document.getElementById("a9").innerHTML="购买成功";
					}
				else if(msg.czylbx.czlyIssuccess==0){
					document.getElementById("a9").innerHTML="未购买";
				}
				else{
					document.getElementById("a9").innerHTML="购买失败";
				}
				
							 
				document.getElementById("a10").innerHTML=msg.czylbx.czlyBuytime;
				
				if(msg.czylbx.czylFormtime!=null){ 
					var time1=time(msg.czylbx.czylFormtime);				   				   
				document.getElementById("a11").innerHTML=time1;
				
				}else{
					
					document.getElementById("a11").innerHTML=" ";
				}
				
				
				
				if(msg.czylbx.czylTotime!=null){
					var time2=time(msg.czylbx.czylTotime);
				document.getElementById("a12").innerHTML=time2;
				
				}
				else{
					document.getElementById("a12").innerHTML=" ";
					
				}
			
			//	document.getElementById("a11").innerHTML=msg.czylbx.czlyDescription;
			//	document.getElementById("a12").innerHTML=msg.czylbx.czlyNote;				
	              $('#myseeCzylModal').modal('show');
	
			}else {
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
		});
}
function showInstitution()
{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/showAllInstitution.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
					if(msg.institution.length>1)
					{
					var str = "<option value=\"0\">全部</option>";
					$.each(msg.institution,function(key,val){
						str += "<option value=\""+val.instId+"\">"+val.instName+"</option>";
					});
					$("#colleage").empty().append(str);
					}else if(msg.institution.length==1)
					{   
						var str = "<option value=\""+msg.institution[0].instId+"\">"+msg.institution[0].instName+"</option>";
						$("#colleage").empty().append(str);
						document.getElementById("colleage").disabled = true;
						showMajor();
					}else{
						alert("当前用户非我校人员");
					}
			}else
			{
				alert("执行错误");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}
function showMajor()
{
	var instId = document.getElementById("colleage").value;
	if(instId==0||instId==18||instId==19)
		{
		var str = "<option value=\"0\">全部</option>";
		$("#major").empty().append(str);
		showClass();
		}else{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/showMajor.do',
		async : false,
		data : {
			instId:instId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{ 
				
				if(msg.major.length>1)
				{
				var str = "<option value=\"0\">全部</option>";
				$.each(msg.major,function(key,val){
					str += "<option value=\""+val.majrId+"\">"+val.majrName+"</option>";
				});
				$("#major").empty().append(str);
				}else if(msg.major.length==1)
				{
					str = "<option value=\""+msg.major[0].majrId+"\">"+msg.major[0].majrName+"</option>";
					$("#major").empty().append(str);
					//document.getElementById("major").disabled = true;
					showClass();
				}else{
					var str = "<option value=\"0\">全部</option>";
					$("#major").empty().append(str);
					$("#stuclass").empty().append(str);
				}
			}else
			{
				alert("执行错误");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	}
}
function showClass()
{
	var majorId = document.getElementById("major").value;
	if(majorId==0)
		{
		var str = "<option value=\"0\">全部</option>";
		$("#stuclass").empty().append(str);
		}else{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/showClass.do',
		async : false,
		data : {
			majorId:majorId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				if(msg.studentclass.length>1)
				{
				var str = "<option value=\"0\">全部</option>";
				$.each(msg.studentclass,function(key,val){
					str += "<option value=\""+val.classId+"\">"+val.classShortname+"</option>";
				});
				$("#stuclass").empty().append(str);
				}else if(msg.studentclass.length==1)
				{
					str = "<option value=\""+msg.studentclass[0].classId+"\">"+msg.studentclass[0].classShortname+"</option>";
				    //document.getElementById("stuclass").disabled = true;
					$("#stuclass").empty().append(str);
				}else
				{
					var str = "<option value=\"0\">全部</option>";
					$("#stuclass").empty().append(str);
				}
			}else
			{
				alert("执行错误");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}
	var instlength = document.getElementById("colleage").length;
	var majorlength = document.getElementById("major").length;
	var classlength = document.getElementById("stuclass").length;
	if(instlength==1&&majorlength==1&&classlength==1)
	{
		document.getElementById("Query").style.display = "none";
	}
}
function changeStuwill(studentId,year1,czylIseditable,beforechoose){
	
	var B_id ="javascript:sureFillOrEditWill("+studentId+","+year1+")";			

	if(window.confirm('你确定要修改意愿吗？')){
		if(czylIseditable==1)
		{
		
		if(beforechoose==null){
			document.getElementById("before").innerHTML="还没填写意愿";
		}else if(beforechoose==1){
			
			document.getElementById("before").innerHTML="是";
		}else{
			document.getElementById("before").innerHTML="否";
		}
	$('#fillOrEditWill').modal('show');
	

 }else{
	 alert("无法修改意愿！");
 }
																
$(".sureFillOrEdit").attr("onclick",B_id);
	
       // return true;
     }else{
        //alert("取消");
       // return false;
    }
	
}
function sureFillOrEditWill(studentId,year){
	
    
	var obj=document.getElementsByName("will2");
	var stuWill;
	for(var i=0; i<obj.length; i ++){
    if(obj[i].checked){
    	stuWill=obj[i].value;
        }
    }
	if(stuWill!=null)
		{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/EditOneStuWill.do',
		async : false,
		data : {
			stuWill:stuWill,
			year:year,
			studentId:studentId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				alert("意愿修改成功！");
				$('#fillOrEditWill').modal('hide');
				showOneyear();
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}

	});	
		}else{
			alert("选择不能为空，修改失败！" +"\n"
					+"     "+"请重新修改！");
		}
				
} 
function statistics(){
	var nameid;
	if(userType==2)
	{  
		 nameid=classId;
				 
		}else if(userType>2&&userType<6){
			nameid=majorId;
			
		}else{
			
			nameid=colleageId;
		}
	
	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/showstatistics.do',
		async : false,
		data : {
			
			year:year1,
			nameid:nameid
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var allCzylTable123="";
				allCzylTable123 +="<thead ><tr><td><button type='button' class='btn btn-success btn-xs' id='allyes'>全选</button></td><td><button type='button' class='btn btn-success btn-xs' id='allno'>全不选</button></td><td><button type='button' class='btn btn-success btn-xs' id='change'>批量修改</button></td></tr></thead>";
				$("#buttons").empty().append(allCzylTable123);
				
				if(userType==2)
				{
					   document.getElementById("0").innerHTML="<strong>统计：</strong>&nbsp;";
						document.getElementById("1").innerHTML=""+msg.name+"班总共:"+msg.num+"人&nbsp;&nbsp;";
						document.getElementById("2").innerHTML="申请购买"+msg.num1+"人&nbsp;&nbsp;";
						document.getElementById("3").innerHTML="申请不购买"+msg.num2+"人&nbsp;&nbsp;";
						document.getElementById("4").innerHTML="未申请"+msg.num3+"人";
					}else if(userType>2&&userType<6){
						   document.getElementById("0").innerHTML="<strong>统计：</strong>&nbsp;";
							document.getElementById("1").innerHTML=""+msg.name+"专业总共:"+msg.num+"人&nbsp;&nbsp;";
							document.getElementById("2").innerHTML="申请购买"+msg.num1+"人&nbsp;&nbsp;";
							document.getElementById("3").innerHTML="申请不购买"+msg.num2+"人&nbsp;&nbsp;";
							document.getElementById("4").innerHTML="未申请"+msg.num3+"人";
					}else{
						
						   document.getElementById("0").innerHTML="<strong>统计：</strong>&nbsp;";
							document.getElementById("1").innerHTML=""+msg.name+"总共:"+msg.num+"人&nbsp;&nbsp;";
							document.getElementById("2").innerHTML="申请购买"+msg.num1+"人&nbsp;&nbsp;";
							document.getElementById("3").innerHTML="申请不购买"+msg.num2+"人&nbsp;&nbsp;";
							document.getElementById("4").innerHTML="未申请"+msg.num3+"人";
					}
				     
					
							
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}

	});	
		
}
function export1(){

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/export.do',
		async : false,
		data : {
	        year:year1,
	        colleageId:colleageId,
	        majorId:majorId,
	        classId:classId,
			
		},
		beforeSend: function(){ 
	    	 var allCzylTable="";
	    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在导出,请稍后......</td></tr></thead>";
	    	$("#loader_container").empty().append(allCzylTable);
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				remove_loading();
				location.href="/zzxt/czController/download.do?colleageId="+colleageId+"&majorId="+majorId+"&classId="+classId;
				//alert("已成功导出到桌面——lstdApply");
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}

function time(date){
	 var time= new Date(date);
	   var year = time.getFullYear();
	   var month = time.getMonth()+1;//月份要加1
	   if(month<10)
		{
		   month ="0"+month;  
		}
	   var day = time.getDate();
	   if(day<10)
		{
		   day ="0"+day;  
		}
	
		var time1=year+"年"+month+"月"+day+"日";
	return time1;
}
function remove_loading(){ 
    var targelem = document.getElementById('infoword'); 
      targelem.style.display='none'; 
       targelem.style.visibility='hidden';
       
} 

function number(){
	var num=0;
	var obj=document.getElementsByName("will");
	for(var i=0;i<obj.length;i++){
		if(obj[i].checked==true){	
			num++;
		}
	}
	return num;
}
function count1(){
	var year=$("#year").val();
	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/show.do',
		async : false,
		data : {
	        year:year,
			
		},beforeSend: function(){ 
	    	 var allCzylTable="";
		    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在统计,请稍后......</td></tr></thead>";
		    	$("#loader_container").empty().append(allCzylTable);
			},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				remove_loading();
				var allCzylTable = "";
				var table = "";
				    table = "<thead><tr><th>#</th><th>学院</th><th>申请购买人数</th><th>申请不购买人数</th><th>未申请人数</th><th>总人数</th><th>申请购买率</th></tr></thead>";
				for(var i=0;i<msg.countModals.length;i++){
					table += "<tr>";
					table += "<td>" + (i + 1) + "</td>";
					table += "<td>" + msg.countModals[i].name + "</td>";
					table += "<td>" + msg.countModals[i].applyYessum + "</td>";
					table += "<td>" + msg.countModals[i].applyNosum + "</td>";
					table += "<td>" + msg.countModals[i].nullsum + "</td>";
					table += "<td>" + msg.countModals[i].sum + "</td>";
					var t = 0;
					t = parseInt((msg.countModals[i].applyYessum * 100) / msg.countModals[i].sum);
					if (msg.countModals[i].sum != 0)
						table += "<td>" + t + "%" + "</td>";
					else
						table += "<td>" + "--" + "</td>"+"</tr>"+"</tbody>";
						
				}
				$("#czylState").empty().append(table);
				$("#demo5").empty().append("");
				$("#buttons").empty().append("");
				//allCzylTable +="<thead><tr><td align='center'><button type='submit' class='btn btn-primary' data-toggle='modal' id='return1' style='width: 50px;' onclick='javascript: return2()'>返回</button></td></tr></thead>";
				allCzylTable +="<thead><tr><td align='center'><button type='button' class='btn btn-info' onclick='javascript:return2()'><span class='glyphicon glyphicon-arrow-left'></span>返回</button></td></tr></thead>";
				$("#return").empty().append(allCzylTable);
			}else{
				remove_loading();
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function count2major(){
	var year=$("#year").val();

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/countByMajor.do',
		async : false,
		data : {
	        year:year,
			
		},beforeSend: function(){ 
	    	 var allCzylTable="";
		    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在统计,请稍后......</td></tr></thead>";
		    	$("#loader_container").empty().append(allCzylTable);
			},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				remove_loading();
				var allCzylTable = "";
				var table = "";
				    table = "<thead><tr><th>#</th><th>专业</th><th>申请购买人数</th><th>申请不购买人数</th><th>未申请人数</th><th>总人数</th><th>申请购买率</th></tr></thead>";
				for(var i=0;i<msg.countModals.length;i++){
					table += "<tr>";
					table += "<td>" + (i + 1) + "</td>";
					table += "<td>" + msg.countModals[i].name + "</td>";
					table += "<td>" + msg.countModals[i].applyYessum + "</td>";
					table += "<td>" + msg.countModals[i].applyNosum + "</td>";
					table += "<td>" + msg.countModals[i].nullsum + "</td>";
					table += "<td>" + msg.countModals[i].sum + "</td>";
					var t = 0;
					t = parseInt((msg.countModals[i].applyYessum * 100) / msg.countModals[i].sum);
					if (msg.countModals[i].sum != 0)
						table += "<td>" + t + "%" + "</td>";
					else
						table += "<td>" + "--" + "</td>"+"</tr>"+"</tbody>";
						
				}
				$("#czylState").empty().append(table);
				$("#demo5").empty().append("");
				$("#buttons").empty().append("");
				//allCzylTable +="<thead><tr><td align='center'><button type='submit' class='btn btn-primary' data-toggle='modal' id='return1' style='width: 50px;' onclick='javascript:return2()'>返回</button></td></tr></thead>";
				//allCzylTable +="<thead><tr><td align='center'><button type='button' class='btn btn-info' onclick='javascript:return2()'><span class='glyphicon glyphicon-arrow-left'></span>返回</button></td></tr></thead>";
				allCzylTable +="<thead><tr><td align='center'><button type='button' class='btn btn-info' onclick='javascript:return2()'><span class='glyphicon glyphicon-arrow-left'></span>返回</button></td></tr></thead>";
				$("#return").empty().append(allCzylTable);
			}else{
				remove_loading();
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function count3class(){
	var year=$("#year").val();

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/countByClass.do',
		async : false,
		data : {
	        year:year,
			
		},beforeSend: function(){ 
	    	 var allCzylTable="";
		    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在统计,请稍后......</td></tr></thead>";
		    	$("#loader_container").empty().append(allCzylTable);
			},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				remove_loading();
				var allCzylTable = "";
				var table = "";
				    table = "<thead><tr><th>#</th><th>班级</th><th>申请购买人数</th><th>申请不购买人数</th><th>未申请人数</th><th>总人数</th><th>申请购买率</th></tr></thead>";
				for(var i=0;i<msg.countModals.length;i++){
					table += "<tr>";
					table += "<td>" + (i + 1) + "</td>";
					table += "<td>" + msg.countModals[i].name + "</td>";
					table += "<td>" + msg.countModals[i].applyYessum + "</td>";
					table += "<td>" + msg.countModals[i].applyNosum + "</td>";
					table += "<td>" + msg.countModals[i].nullsum + "</td>";
					table += "<td>" + msg.countModals[i].sum + "</td>";
					var t = 0;
					t = parseInt((msg.countModals[i].applyYessum * 100) / msg.countModals[i].sum);
					if (msg.countModals[i].sum != 0)
						table += "<td>" + t + "%" + "</td>";
					else
						table += "<td>" + "--" + "</td>"+"</tr>"+"</tbody>";
						
				}
				$("#czylState").empty().append(table);
				$("#demo5").empty().append("");
				$("#buttons").empty().append("");
				//allCzylTable +="<thead><tr><td align='center'><button type='submit' class='btn btn-primary' data-toggle='modal' id='return1' style='width: 50px;' onclick='javascript:return2()'>返回</button></td></tr></thead>";
				allCzylTable +="<thead><tr><td align='center'><button type='button' class='btn btn-info' onclick='javascript:return2()'><span class='glyphicon glyphicon-arrow-left'></span>返回</button></td></tr></thead>";
				$("#return").empty().append(allCzylTable);
			}else{
				remove_loading();
				alert(msg.message);
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
function return2(){
	
	if(sign==1){
			var allCzylTable="";
		//	colleageId = document.getElementById("colleage").value;
		//	majorId = document.getElementById("major").value;
		//	classId = document.getElementById("stuclass").value;
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/czController/showCzStud.do',
				async : false,
				data : {
					year:year1,
					colleageId:colleageId,
					majorId:majorId,
					classId:classId
				},
				beforeSend: function(){ 
			    	 var allCzylTable="";
			    	 
			    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在返回,请稍后......</td></tr></thead>";
			    	$("#loader_container").empty().append(allCzylTable);
				},
				dataType : 'json',
				success : function(msg) {
					if(msg.result ==true){	
						$("#return").empty().append("");
						$("#year").val(year1);
						remove_loading();				
						statistics();
					allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;作</th></tr></thead>";
				for(var i=0;i<msg.firstCzylList.length;i++){
					 
					czylbxIds[i]=msg.firstCzylList[i].czylbxId;
					    allCzylTable +="<tr>";
					    allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>";
					    allCzylTable +=msg.firstCzylList[i].studentName + "</td><td> " +							
						msg.firstCzylList[i].studentNumber+ "</td><td> " +
						msg.firstCzylList[i].czlyBuyAnnual+ "</td><td> "  ;
						
					    if(msg.firstCzylList[i].czlyIsneed==1){
							allCzylTable+="是"+"</td><td>";
							}
						else if(msg.firstCzylList[i].czlyIsneed==0) {
							allCzylTable+="否"+"</td><td>";
						}
						else
							{
							allCzylTable+="还没有填写意愿"+"</td><td>";
							}
					 
					     if(msg.firstCzylList[i].czlyIssuccess==1){
							   allCzylTable+="购买成功"+"</td>";
							}
					 
						else if(msg.firstCzylList[i].czlyIssuccess==0){
							allCzylTable+="未购买"+"</td><";
						}
					 
						else{
							allCzylTable+="购买失败"+"</td>";
						}
					     
					  
					     allCzylTable +="<td>"
							 + "<a href=\"javascript:changeStuwill("
							 + msg.firstCzylList[i].studentId+","+year
							 +","+msg.firstCzylList[i].czylIseditable
							 +","+msg.firstCzylList[i].czlyIsneed
							 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
					    	 "<td>"
							 + "<a href=\"javascript:checkStuCzyl("
							 + msg.firstCzylList[i].studentId
							 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>";
					     
					    
					     
					}
				$("#czylState").empty().append(allCzylTable);
				$("#demo5").paginate({
					count 		: msg.pageCount,
					start 		: 1,
					display     : 50,
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
						
												$.ajax({
													type : "post",
													contentType : "application/x-www-form-urlencoded;charset=UTF-8",
													url : '/zzxt/czController/checkOnePageCzStud.do',
													async : false,
													data : {
														year:year1,
														colleageId:colleageId,
														majorId:majorId,
														classId:classId,
														page:page
													},
													dataType : 'json',
													success : function(msg) {
														if(msg.result == true){	
															allCzylTable="";
															
															
															allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;&nbsp;作</th></tr></thead>";
															for(var i=0;i<msg.pageCzylList.length;i++){
																czylbxIds[i]=msg.pageCzylList[i].czylbxId;
																allCzylTable +="<tr>";
																 allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>" ;
																 allCzylTable +=msg.pageCzylList[i].studentName + "</td><td> " +							
																	msg.pageCzylList[i].studentNumber+ "</td><td> " +
																	msg.pageCzylList[i].czlyBuyAnnual+ "</td><td> ";
																	
																    if(msg.pageCzylList[i].czlyIsneed==1){
																		allCzylTable+="是"+"</td><td>";
																		}
																	else if(msg.pageCzylList[i].czlyIsneed==0) {
																		allCzylTable+="否"+"</td><td>";
																	}
																	else
																		{
																		allCzylTable+="还没有填写意愿"+"</td><td>";
																		}
																 
																     if(msg.pageCzylList[i].czlyIssuccess==1){
																		   allCzylTable+="购买成功"+"</td>";
																		}
																 
																	else if(msg.pageCzylList[i].czlyIssuccess==0){
																		allCzylTable+="未购买"+"</td>";
																	}
																 
																	else{
																		allCzylTable+="购买失败"+"</td>";
																	}
																     
																     allCzylTable +="<td>"
																		 + "<a href=\"javascript:changeStuwill("
																		 + msg.pageCzylList[i].studentId+","+year
																		 +","+msg.pageCzylList[i].czylIseditable
																		 +","+msg.pageCzylList[i].czlyIsneed
																		 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
																    	 "<td>"
																		 + "<a href=\"javascript:checkStuCzyl("
																		 + msg.pageCzylList[i].studentId
																		 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>";
																    
															}
															$("#czylState").empty().append(allCzylTable);
														}else{
															alert(msg.message);
														}
													},error: function(msg){
												        alert("网络超时！");
													}
												});
					}
				});
				
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
				$("#change").click(function(){

					
						changewills();
						       	
				});
					}else{
						remove_loading();
						alert(msg.message);
						$("#return").empty().append("");
						$("#year").val(year1);
						allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;作</th></tr></thead>";
						$("#czylState").empty().append(allCzylTable);
						$("#demo5").paginate({
							count 		: 1,
							start 		: 1,
							display     : 50,
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
								
							}
								
							});
					}
			},error: function(msg){
				    alert("网络超时!");
				}
			});
		
		
		
	}else{	
		var allCzylTable="";	
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/czController/checkOneCzStud.do',
			async : false,
			data : {
				year:year1,
				NameOrNumber:input
			},
			    beforeSend: function(){ 
			    	 var allCzylTable="";
			    	allCzylTable +="<thead><tr><td align='center' id='infoword'>正在返回,请稍后......</td></tr></thead>";
			    	$("#loader_container").empty().append(allCzylTable);
				}, 
			dataType : 'json',
			success : function(msg) {			
				if(msg.result ==true){
					$("#return").empty().append("");
					$("#year").val(year1);
					var allCzylTable123="";
					allCzylTable123 +="<thead ><tr><td><button type='button' class='btn btn-success btn-xs' id='allyes'>全选</button></td><td><button type='button' class='btn btn-success btn-xs' id='allno'>全不选</button></td><td><button type='button' class='btn btn-success btn-xs' id='change'>批量修改</button></td></tr></thead>";
					$("#buttons").empty().append(allCzylTable123);
					remove_loading();
					year1=msg.czylbxbasicinfo[0].czlyBuyAnnual;
					allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;&nbsp;作</th></tr></thead>";
					for(var i=0;i<msg.czylbxbasicinfo.length;i++){
						czylbxIds[i]=msg.czylbxbasicinfo[i].czylbxId;
						allCzylTable +="<tr>";
						  allCzylTable += "<td>" + "<input type='checkbox' class='noborder' name='will' id='yes' value=czylbxIds[i]>"+"</td><td>" ;
						  allCzylTable +=msg.czylbxbasicinfo[i].studentName + "</td><td> " +							
							msg.czylbxbasicinfo[i].studentNumber+ "</td><td> " +
							msg.czylbxbasicinfo[i].czlyBuyAnnual+ "</td><td> ";
							
						    if(msg.czylbxbasicinfo[i].czlyIsneed==1){
								allCzylTable+="是"+"</td><td>";
								}
							else if(msg.czylbxbasicinfo[i].czlyIsneed==0) {
								allCzylTable+="否"+"</td><td>";
							}
							else
								{
								allCzylTable+="还没有填写意愿"+"</td><td>";
								}
						 
						     if(msg.czylbxbasicinfo[i].czlyIssuccess==1){
								   allCzylTable+="购买成功"+"</td>";
								}
						 
							else if(msg.czylbxbasicinfo[i].czlyIssuccess==0){
								allCzylTable+="未购买"+"</td>";
							}
						 
							else{
								allCzylTable+="购买失败"+"</td>";
							}
						     
						     allCzylTable +="<td>"
								 + "<a href=\"javascript:changeStuwill("
								 + msg.czylbxbasicinfo[i].studentId+","+year
								 +","+msg.czylbxbasicinfo[i].czylIseditable
								 +","+msg.czylbxbasicinfo[i].czlyIsneed
								 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>" + "</td>"+
						    	 "<td>"
								 + "<a href=\"javascript:checkStuCzyl("
								 + msg.czylbxbasicinfo[i].studentId
								 + ")\"><button type='button' class='btn btn-success btn-xs'>查看详细</button>" + "</a>" + "</td>"+"</tr>" + "</tbody>";
						  
						     
						}
					$("#czylState").empty().append(allCzylTable);
					$("#demo5").paginate({
						count 		: 1,
						start 		: 1,
						display     : 50,
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
							
						}
							
						});
					
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
					$("#change").click(function(){

						
							changewills();
							       	
					});
				
			}else{
			
				remove_loading();
				alert(msg.message);
				$("#return").empty().append("");
				$("#year").val(year1);
				allCzylTable +="<thead><tr><th>选&nbsp;&nbsp;择</th><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;号</th><th>购买年度</th><th>是否需要购买</th><th>是否购买成功</th><th>修改意愿</th><th>操&nbsp;&nbsp;作</th></tr></thead>";
				$("#czylState").empty().append(allCzylTable);
				$("#demo5").paginate({
					count 		: 1,
					start 		: 1,
					display     : 50,
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
						
					}
						
					});
			}

			
		},error: function(msg){
		    alert("网络超时！");
		}
			
	});
			
	}	
}