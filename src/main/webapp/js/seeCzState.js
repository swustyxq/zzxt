 var czylIseditable;
 var beforechoose;
$(document).ready(function (){
	var time=CurentTime();	

	document.getElementById("buyAnnual1").innerHTML=time;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/checkYear.do',
		async : false,
		data : {
			
			year:time,
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var endTime=new Date(msg.work.workEndtime);
				var now = new Date();
				var time_distance=endTime-now;
				if(time_distance>0){
					
					var int_day=Math.floor(time_distance/86400000);
					document.getElementById("day").innerHTML="距离财务处进行城镇医疗保险代购还有"+"<strong>"+int_day+"</strong>"+"天";
				
				}else{
					
					document.getElementById("day").innerHTML="城镇医疗保险代购"+"<strong>"+"已结束"+"</strong>";
				}
			
				choose=msg.choose;
				  if(choose==null){
						var allTable1="";
					  allTable1 +="<thead><tr><td align='center'><h2>你还没有提交申请，请先提交申请!!!</h2></td></tr></thead>";
					  $("#State1").empty().append(allTable1);
					  document.getElementById("fillOrEdit").disabled = true;
				  }else if(choose==0){
					  var allTable1="";
					  allTable1 +="<thead><tr><td align='center'><h2>你没有选择购买，可以通过修改意愿重新购买!!!</h2></td></tr></thead>";
					  $("#State1").empty().append(allTable1);
					  document.getElementById("fillOrEdit").disabled = false;
					
						$("#fillOrEdit").click(function(){
							
							FillOrEditWill(time,czylIseditable,beforechoose);
						});
					  
				  }else{
					   if(msg.czylbx.czylIseditable==0){
						   document.getElementById("fillOrEdit").disabled = true;
					   }else{
						   
						   document.getElementById("fillOrEdit").disabled = false;
					   }
						   
						showAllInfo(time);
						$("#fillOrEdit").click(function(){
							
							FillOrEditWill(time,czylIseditable,beforechoose);
						});

				  }
				
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}

	});	

});
function showAllInfo(year){

	var allTable1="";
	var allTable2="";
	var allTable3="";
	var allTable4="";
	
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
			
				beforechoose=msg.czylbx.czlyIsneed;
			 if(msg.czylbx.czlyIssuccess==0)
				 {
				allTable1 +="<thead><tr><th>&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;</th><th>&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</th><th>&nbsp;&nbsp;农行卡号</th><th>保险金额</th><th>是否购买&nbsp;</th><th>是否能修改意愿&nbsp;</th><th>是否购买成功&nbsp;</th></tr><thead>";
				allTable2 +="<thead><tr><th>备&nbsp;注</th></tr><thead>";
				
						allTable1 +="<tr><td>"+
						msg.student.studName + "</td><td> " + 
						msg.student.studNumber +  "</td><td> " +
						msg.studentinfo.stinBanknumber +  "</td><td> ";
						
						if(msg.czylbx.czlyMoney!=null)
							{
							allTable1 +=msg.czylbx.czlyMoney +  "</td><td> " ;
							}
						else{
							allTable1 +=" "+  "</td><td> " ;
						}																														
						if(msg.czylbx.czlyIsneed==1){
							allTable1+="是"+"</td><td>";
							}
						else if(msg.czylbx.czlyIsneed==0){
							allTable1+="否"+"</td><td>";
						}
						else
							{
							allTable1+="请填写您的意愿"+"</td><td>";
							}
						if(msg.czylbx.czylIseditable==1){
							allTable1+="是"+"</td><td>";
							}
						else{
							allTable1+="否"+"</td><td>";
						}	
						
						
						allTable1+="未投保"+"</td>";
						allTable1+= "</tr>" + "</tbody>";
						
						allTable2 +="<tr><td>";
						
						if(msg.czylbx.czlyNote!=null)
						{
						allTable2 +=msg.czylbx.czlyNote +  "</td> " ;
						}
					else{
						allTable2 +="无"+  "</td> " ;
					}		
						
						allTable2+= "</tr>" + "</tbody>";
				$("#State1").empty().append(allTable1);
				$("#State2").empty().append(allTable2);
				
				 }else if(msg.czylbx.czlyIssuccess==-1){
					 allTable1 +="<thead><tr><th>&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;</th><th>&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</th><th>&nbsp;&nbsp;农行卡号</th><th>保险金额</th><th>是否购买&nbsp;</th><th>是否能修改意愿&nbsp;</th><th>是否购买成功&nbsp;</th></tr></thead>";
					 allTable2 +="<thead><tr><th>备&nbsp;注</th></tr></thead>";	
						
						allTable1 +="<tr><td>"+
						msg.student.studName + "</td><td> " + 
						msg.student.studNumber +  "</td><td> "+
						msg.studentinfo.stinBanknumber +  "</td><td> " ;
						
						if(msg.czylbx.czlyMoney!=null)
							{
							allTable1 +=msg.czylbx.czlyMoney +  "</td><td> " ;
							}
						else{
							allTable1 +=" "+  "</td><td> " ;
						}												
																
						if(msg.czylbx.czlyIsneed==1){
							allTable1+="是"+"</td><td>";
							}
						else if(msg.czylbx.czlyIsneed==0){
							allTable1+="否"+"</td><td>";
						}
						else
							{
							allTable1+="请填写您的意愿"+"</td><td>";
							}
						if(msg.czylbx.czylIseditable==1){
							allTable1+="是"+"</td><td>";
							}
						else{
							allTable1+="否"+"</td><td>";
						}	
						
						allTable1+="购买失败"+"</td>";
						
						allTable2 +="<tr><td>";
						allTable2 +="校医院的座机:6089212 ，亲，若有疑问请尽快联系校医院 "+  "</td> " ;
						allTable2+= "</tr>" + "</tbody>";
						
						allTable1+= "</tr>" + "</tbody>";
						$("#State1").empty().append(allTable1);
						$("#State2").empty().append(allTable2);
					 
				 }else{
					allTable1 +="<thead><tr><th width=200px>&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;</th><th width=200px>&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</th><th width=200px>购买保险的金额</th><th width=200px>是否需要购买&nbsp;</th><th width=200px>是否购买成功&nbsp;</th></tr></thead>";
					allTable2 +="<thead><tr><th width=200px>购&nbsp;买&nbsp;年&nbsp;度</th><th width=200px>购&nbsp;买&nbsp;时&nbsp;间&nbsp;</th><th width=200px>保险的开始时间</th><th width=200px>保险的截止时间</th><th width=200px>是否能修改意愿</th></tr></thead>";
					//allTable3 +="<thead><tr><th width=400px>描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述</th><th width=400px>备&nbsp;&nbsp;&nbsp;注</th></tr></thead>";
					//allTable4 +="<thead><tr><th width=400px>备&nbsp;&nbsp;&nbsp;注</th></tr></thead>";
							allTable1 +="<tr><td>"+
							msg.student.studName + "</td><td> " + 
							msg.student.studNumber +  "</td><td> " ;
							
							if(msg.czylbx.czlyMoney!=null)
								{
								allTable1 +=msg.czylbx.czlyMoney +  "</td><td> " ;
								}
							else{
								allTable1 +=" "+  "</td><td> " ;
							}
							if(msg.czylbx.czlyIsneed==1){
								allTable1+="是"+"</td><td>";
								}
							else if(msg.czylbx.czlyIsneed==0){
								allTable1+="否"+"</td><td>";
							}
							else
							{
							allTable1+="请填写您的意愿"+"</td><td>";
							}
							
								allTable1+="购买成功"+"</td>";
																
							allTable1+= "</tr>" + "</tbody>";
							
							
							allTable2 +="<tr><td>"+
							msg.czylbx.czlyBuyannual +  "</td><td> " ;
							
							if(msg.czylbx.czlyBuytime!=null)
							{
							allTable2 +=msg.czylbx.czlyBuytime +  "</td><td> " ;
							}
						else{
							allTable2 +=" "+  "</td><td> " ;
						}
							
							
							if(msg.czylbx.czylFormtime!=null)
							{
								var time1=time(msg.czylbx.czylFormtime);
							allTable2 +=time1 +  "</td><td> " ;
							}
						else{
							allTable2 +=" "+  "</td><td> " ;
						}
							if(msg.czylbx.czylTotime!=null)
							{
								var time1=time(msg.czylbx.czylTotime);
							   allTable2 +=time1 +  "</td><td> " ;
							}
						else{
							allTable2 +=" "+  "</td><td> " ;
						}
							if(msg.czylbx.czylIseditable==1){
								allTable2+="是"+"</td>";
								}
							else{
								allTable2+="否"+"</td>";
							}								
							allTable2+= "</tr>" + "</tbody>";
							
							//allTable3 +="<tr><td height=40px>";
							//if(msg.czylbx.czlyDescription!=null)
						//	{
						//	allTable3 +=msg.czylbx.czlyDescription +  "</td>" ;
						//	}
						//else{
						//	allTable3 +=" "+  "</td> " ;
						//}
							
							
						//	allTable3+= "</tr>" + "</tbody>";
							
							//allTable4 +="<tr><td height=40px>";
							//if(msg.czylbx.czlyNote!=null)
						//	{
						//	allTable4 +=msg.czylbx.czlyNote +  "</td> " ;
						//	}
						//else{
						//	allTable4 +=" "+  "</td> " ;
						//}
							//allTable4+= "</tr>" + "</tbody>";
					$("#State1").empty().append(allTable1);
					$("#State2").empty().append(allTable2);
					//$("#State3").empty().append(allTable3);	
					//$("#State4").empty().append(allTable4);	
				}
				
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}

	});
}
function FillOrEditWill(year1,czylIseditable,beforechoose){
	
	var B_id ="javascript:sureFillOrEditWill("+year1+")";	
		
	if(window.confirm('你确定要修改意愿吗？')){
      //  alert("确定");
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
        return true;
     }else{
       // alert("取消");
        return false;
    }
		
}
function sureFillOrEditWill(year){

	var obj=document.getElementsByName("will");
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
		url : '/zzxt/czController/fillOrEditWill.do',
		async : false,
		data : {
			stuWill:stuWill,
			year:year,
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				alert("意愿修改成功！");
				$('#fillOrEditWill').modal('hide');
				 showAllInfo(year);
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
function CurentTime()
{ 
    var now = new Date();
   
    var year = now.getFullYear();       //年
               
    var clock = year + "";

    return(clock); 
} 


