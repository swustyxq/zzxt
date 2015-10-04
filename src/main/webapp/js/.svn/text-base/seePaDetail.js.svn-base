$(document).ready(function(){
	var studId = 0 ;
	var annual1="";
	var Request = new Object();
	Request = GetRequest();
	if(Request!=null)
	{
		annual1=Request["annual"];
		studId=Request['id'];
	}
	$.ajax({
			type:"post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/paController/showPaDetail.do',
			async : false,
			data : {
				annual:annual1,
				studentId:studId,
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result == true){	
					var allPabxTable="";
					allPabxTable += " <thead><tr><th>姓名</th> <th>学号</th> <th>年度</th> <th>购买时间</th> <th>金额</th> <th>有效开始时间</th> <th>有效截止时间</th> <th>备注</th>  </tr></thead>";				
					$.each(msg.sxpabx,function(key,val){
						allPabxTable +="<tbody><tr><td>"+
						msg.student.studName + "</td><td> " +
						msg.student.studNumber + "</td><td> " +
						val.xspaBuyannual +  "</td><td> " +
						val.xspaBuytime  +  "</td><td> " +
						val.xspaMoney  +  "</td><td> " +
						time(val.xspaFromtime)  +  "</td><td> " +
						time(val.xspaTotime)  +  "</td><td> " +
						val.xspaNote + "</td></tr> </tbody>";	
					});					
					$("#xspabxTable").empty().append(allPabxTable);					
				}else{				
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！!!!!!!");
			}	
	});
	});				
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

function time(date)//时间转换
{
	 var time= new Date(date);
	   var year = time.getFullYear();
	   var month = time.getMonth()+1;//月份要加1
	   var hour = time.getHours();
	   var day = time.getDate();
	   var second = time.getSeconds();
	   var minute = time.getMinutes();
	   if(month<10)
		{
		   month ="0"+month;  
		}
	   
	   if(day<10)
		{
		   day ="0"+day;  
		}
	  
	   if(hour<10)
		{
		   hour ="0"+hour;  
		}
		
		if(minute<10)
			{
			  minute ="0"+minute;  
			}
		
		if(second<10)
		{
			second ="0"+second;  
		}
		var time1=year+"年"+month+"月"+day+"日"+" "+hour+":"+minute+":"+second;
	   
	   return   time1;
}