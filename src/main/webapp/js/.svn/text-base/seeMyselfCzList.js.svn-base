
function seebefore(){
	
	
	var year=$("#year").val();
	 showAllInfo1(year);	//用于显示默认年度的城镇医疗保险情况
		
	$("#check").click(function(){//用于显示查询年度的城镇医疗保险情况
		var year=$("#year").val();
	
		
		if(year!="所有")//查询一个年度的情况
		{
			 showAllInfo1(year);	
			 
		}else{

			var allCzylTable1="";
			var allCzylTable2="";
			//var allCzylTable3="";
			//var allCzylTable4="";
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/czController/showAllCzylInfo.do',
				async : false,
				data : {
		
				},
				dataType : 'json',
				success : function(msg) {
					if(msg.result ==true){
						czylIseditable=0;
						year1="所有";
						beforechoose=null;
						allCzylTable1 +="<thead><tr><th width=200px>&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;</th><th width=200px>&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</th><th width=200px>购买保险的金额</th><th width=200px>是否需要购买&nbsp;</th><th width=200px>是否购买成功&nbsp;</th></tr></thead>";
						allCzylTable2 +="<thead><tr><th width=200px>购&nbsp;买&nbsp;年&nbsp;度</th><th width=200px>购&nbsp;买&nbsp;时&nbsp;间&nbsp;</th><th width=200px>保险的开始时间</th><th width=200px>保险的截止时间</th><th width=200px>是否能修改意愿</th></tr></thead>";
					//	allCzylTable3 +="<thead><tr><th width=400px>描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述</th><th width=400px>备&nbsp;&nbsp;&nbsp;注</th></tr></thead>";
					//	allCzylTable3 +="<thead><tr><th width=400px>备&nbsp;&nbsp;&nbsp;注</th></tr></thead>";
						$.each(msg.czylbx,function(key,val){
								allCzylTable1 +="<tr><td>"+
								msg.student.studName + "</td><td> " + 
								msg.student.studNumber +  "</td><td> " ;
							//	val.czlyMoney +  "</td><td> " ;
								if(val.czlyMoney!=null)
								{
								allCzylTable1 +=val.czlyMoney +  "</td><td> " ;
								}
							else{
								allCzylTable1 +=" "+  "</td><td> " ;
							}
								
								if(val.czlyIsneed==1){
									allCzylTable1+="是"+"</td><td>";
									}
								else if(val.czlyIsneed==0) {
									allCzylTable1+="否"+"</td><td>";
								}
								else
									{
									allCzylTable1+="请填写您的意愿"+"</td><td>";
									}
								
								if(val.czlyIssuccess==1){
									allCzylTable1+="购买成功"+"</td>";
									}
								else if(val.czlyIssuccess==0){
									allCzylTable1+="未投保"+"</td>";
								}
								else{
									allCzylTable1+="购买失败"+"</td>";
								}
								
								allCzylTable1+= "</tr>" + "</tbody>";
								
								
								allCzylTable2 +="<tr><td>"+
								val.czlyBuyannual +  "</td><td> " ;
								
								if(val.czlyBuytime!=null)
								{
									
								allCzylTable2 +=val.czlyBuytime +  "</td><td> " ;
								}
							else{
								allCzylTable2 +=" "+  "</td><td> " ;
							}
								
								if(val.czylFormtime!=null)
								{
									var time1=time(val.czylFormtime);
								    allCzylTable2 +=time1 +  "</td><td> " ;
								}
							else{
								allCzylTable2 +=" "+  "</td><td> " ;
							}
								if(val.czylTotime!=null)
								{
									var time1=time(val.czylTotime);
								allCzylTable2 +=time1 +  "</td><td> " ;
								}
							else{
								allCzylTable2 +=" "+  "</td><td> " ;
							}
								if(val.czylIseditable==1){
									allCzylTable2+="是"+"</td>";
									}
								else{
									allCzylTable2+="否"+"</td>";
								}								
								allCzylTable2+= "</tr>" + "</tbody>";
								
							//	allCzylTable3 +="<tr><td height=40px>";							
							//	if(val.czlyDescription!=null)
							//	{
							//	allCzylTable3 +=val.czlyDescription +  "</td> " ;
							//	}
							//else{
							//	allCzylTable3 +=" "+  "</td> " ;
						///	}
								
							
							//	allCzylTable3+= "</tr>" + "</tbody>";
								
							//	allCzylTable4 +="<tr><td height=40px>";
							//	if(val.czlyNote!=null)
							//	{
							//		allCzylTable4 +=val.czlyNote +  "</td> " ;
							//	}
						//	else{
						//		allCzylTable4 +=" "+  "</td> " ;
						//	}
						//		allCzylTable4+= "</tr>" + "</tbody>";
						});	
						$("#czylState11").empty().append(allCzylTable1);
						$("#czylState22").empty().append(allCzylTable2);
					//	$("#czylState33").empty().append(allCzylTable3);
					//	$("#czylState44").empty().append(allCzylTable4);
						
						
					
					}else{
						alert(msg.message);
					}
				},error: function(msg){
				    alert("网络超时！");
				}
		
			});
		}
		
	});	
	
}

function showAllInfo1(year){

	var allCzylTable1="";
	var allCzylTable2="";
	//var allCzylTable3="";
	//var allCzylTable4="";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/checkYear.do',
		async : false,
		data : {
			year:year,
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
			    czylIseditable=msg.czylbx.czylIseditable;
				year1=msg.year;
				beforechoose=msg.czylbx.czlyIsneed;
				allCzylTable1 +="<thead><tr><th width=200px>&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;</th><th width=200px>&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</th><th width=200px>购买保险的金额</th><th width=200px>是否需要购买&nbsp;</th><th width=200px>是否购买成功&nbsp;</th></tr></thead>";
				allCzylTable2 +="<thead><tr><th width=200px>购&nbsp;买&nbsp;年&nbsp;度</th><th width=200px>购&nbsp;买&nbsp;时&nbsp;间&nbsp;</th><th width=200px>保险的开始时间</th><th width=200px>保险的截止时间</th><th width=200px>是否能修改意愿</th></tr></thead>";
				//allCzylTable3 +="<thead><tr><th>描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述</th></tr></thead>";
				//allCzylTable4 +="<thead><tr><th>备&nbsp;&nbsp;&nbsp;注</th></tr></thead>";
				
						allCzylTable1 +="<tr><td>"+
						msg.student.studName + "</td><td> " + 
						msg.student.studNumber +  "</td><td> " ;
						
						if(msg.czylbx.czlyMoney!=null)
							{
							allCzylTable1 +=msg.czylbx.czlyMoney +  "</td><td> " ;
							}
						else{
							allCzylTable1 +=" "+  "</td><td> " ;
						}
						if(msg.czylbx.czlyIsneed==1){
							allCzylTable1+="是"+"</td><td>";
							}
						else if(msg.czylbx.czlyIsneed==0){
							allCzylTable1+="否"+"</td><td>";
						}
						else
						{
						allCzylTable1+="请填写您的意愿"+"</td><td>";
						}
						if(msg.czylbx.czlyIssuccess==1){
							allCzylTable1+="购买成功"+"</td>";
							}
						else if(msg.czylbx.czlyIssuccess==0){
							allCzylTable1+="未投保"+"</td>";
						}
						else{
							allCzylTable1+="购买失败"+"</td>";
						}
						
						
						allCzylTable1+= "</tr>" + "</tbody>";
						
						
						allCzylTable2 +="<tr><td>"+
						msg.czylbx.czlyBuyannual +  "</td><td> " ;
						
						if(msg.czylbx.czlyBuytime!=null)
						{
						allCzylTable2 +=msg.czylbx.czlyBuytime +  "</td><td> " ;
						}
					else{
						allCzylTable2 +=" "+  "</td><td> " ;
					}
						
						
						if(msg.czylbx.czylFormtime!=null)
						{
							var time1=time(msg.czylbx.czylFormtime);
						allCzylTable2 +=time1 +  "</td><td> " ;
						}
					else{
						allCzylTable2 +=" "+  "</td><td> " ;
					}
						if(msg.czylbx.czylTotime!=null)
						{
							var time1=time(msg.czylbx.czylTotime);
						   allCzylTable2 +=time1 +  "</td><td> " ;
						}
					else{
						allCzylTable2 +=" "+  "</td><td> " ;
					}
						if(msg.czylbx.czylIseditable==1){
							allCzylTable2+="是"+"</td>";
							}
						else{
							allCzylTable2+="否"+"</td>";
						}								
						allCzylTable2+= "</tr>" + "</tbody>";
									
						//allCzylTable3 +="<tr><td height=40px>";							
						//if(msg.czylbx.czlyDescription!=null)
						//{
						//allCzylTable3 +=msg.czylbx.czlyDescription +  "</td> " ;
						//}
					//else{
						//allCzylTable3 +=" "+  "</td> " ;
					//}
						
					
						//allCzylTable3+= "</tr>" + "</tbody>";
						
						//allCzylTable4 +="<tr><td height=40px>";
						//if(msg.czylbx.czlyNote!=null)
						//{
						//	allCzylTable4 +=msg.czylbx.czlyNote +  "</td> " ;
						//}
					//else{
					//	allCzylTable4 +=" "+  "</td> " ;
					//}
					//	allCzylTable4+= "</tr>" + "</tbody>";
				$("#czylState11").empty().append(allCzylTable1);
				$("#czylState22").empty().append(allCzylTable2);
				//$("#czylState33").empty().append(allCzylTable3);
			//	$("#czylState44").empty().append(allCzylTable4);		
				
				
			}else{
				alert(msg.message);
				allCzylTable1 +="<thead><tr><th width=200px>&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;</th><th width=200px>&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</th><th width=200px>购买保险的金额</th><th width=200px>是否需要购买&nbsp;</th><th width=200px>是否购买成功&nbsp;</th></tr></thead>";
				allCzylTable2 +="<thead><tr><th width=200px>购&nbsp;买&nbsp;年&nbsp;度</th><th width=200px>购&nbsp;买&nbsp;时&nbsp;间&nbsp;</th><th width=200px>保险的开始时间</th><th width=200px>保险的截止时间</th><th width=200px>是否能修改意愿</th></tr></thead>";				
				$("#czylState11").empty().append(allCzylTable1);
				$("#czylState22").empty().append(allCzylTable2);
			}
		},error: function(msg){
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
