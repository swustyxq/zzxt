$(document).ready(function(){
	var choose;
	var time=CurentTime();
	var sure;
	document.getElementById("input").disabled = true;
	document.getElementById("yes").disabled = true;
	document.getElementById("no").disabled = true;
	document.getElementById("buyAnnual").innerHTML=time;
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
				var now = new Date();
				var startTime=new Date(msg.work.workStarttime);
				var endTime=new Date(msg.work.workEndtime);
				if(now<startTime)
					{
					   alert("城镇医疗保险系统暂未开放！");
					   location.href = "/zzxt/htmls/index.html";
			}else if(now>endTime){
				 alert("城镇医疗保险申请已结束！");
				document.getElementById("input").disabled = true;
				document.getElementById("yes").disabled = true;
				document.getElementById("no").disabled = true;
			}else{
				choose=msg.choose;
				  if(choose==null){
					  document.getElementById("care").innerHTML=msg.studentinfo.stinBanknumber;
					  $('#checkcare').modal('show');
					  var obj=document.getElementsByName("will1");
					 
						$("#surecare").click(function(){
						
								for(var i=0; i<obj.length; i ++){
							    if(obj[i].checked){
							    	sure=obj[i].value;
							        }
							    }
								$('#checkcare').modal('hide');
						
						if(sure==0){
							
							alert("请尽快前往财务处进行修改！");
							document.getElementById("input").disabled = true;
							document.getElementById("yes").disabled = true;
							document.getElementById("no").disabled = true;
							
						}
						else if(sure==1){
							
							  document.getElementById("input").disabled = false;
							  document.getElementById("yes").disabled = false;
							  document.getElementById("no").disabled = false;
							
							$("#input").click(function(){
								inputWill(time,msg.czylbx.czlyIsneed);
								
							});
						}else{
							alert("你没有进行选择，请重新确认！");
							document.getElementById("input").disabled = true;
							document.getElementById("yes").disabled = true;
							document.getElementById("no").disabled = true;
						}
					});	
				  }else{
					  var obj=document.getElementsByName("will");
					 
	        			if(msg.czylbx.czlyIsneed=="1") { 
	           				obj[0].checked = "checked";
	           			}else
	           			{
	           				obj[1].checked = "checked";
	           			}
					  
					  document.getElementById("input").disabled = true;
					  document.getElementById("yes").disabled = true;
						document.getElementById("no").disabled = true;

				  }
			}
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}

	});	
 
});

function inputWill(year,czlyIsneed){
	
    
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
				alert("提交成功！");
				  var obj=document.getElementsByName("will");
					 
      			if(czlyIsneed=="1") { 
         				obj[0].checked = "checked";
         			}else
         			{
         				obj[1].checked = "checked";
         			}
				document.getElementById("input").disabled = true;
				document.getElementById("yes").disabled = true;
				document.getElementById("no").disabled = true;
			
				location.href = "/zzxt/htmls/applyBuyYlbx.html?pareid=55&funid=50";
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}

	});	
		}else{
			alert("选择不能为空，提交失败！" +"\n"
					+"     "+"请重新提交！");
		}
				
} 
function CurentTime()
{ 
    var now = new Date();
   
    var year = now.getFullYear();       //年
               
    var clock = year + "";

    return(clock); 
} 

