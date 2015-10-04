var time1,time2;
var workName;
function editTime(workId)
{
	alert(workId);
	var startTime=$("#InTime1").val();
	var endTime=$("#OutTime1").val();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/WorkController/editWorkTime.do',
		async : false,
		data : {
			startTime:startTime,
			endTime:endTime,
			workId:workId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				time1= new Date(msg.work.workStarttime);
				time2= new Date(msg.work.workEndtime);
				workName = msg.work.workName;
				document.getElementById("startTime").innerHTML = time(msg.work.workStarttime);
				document.getElementById("endTime").innerHTML = time(msg.work.workEndtime);
			}else{
				
			}
		},error : function(msg){
			alert("网络超时！");
		}
	});
}
function showTime(workId){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/WorkController/showWorkTime.do',
		async : false,
		data : {
			workId:workId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				document.getElementById("startTime").innerHTML = time(msg.work.workStarttime);
				document.getElementById("endTime").innerHTML = time(msg.work.workEndtime);
				time1= new Date(msg.work.workStarttime);
				time2= new Date(msg.work.workEndtime);
				workName = msg.work.workName;
				setInterval(showtime, 1000);
				setInterval(showtime, 1000);
			}else{
				
			}
		},error : function(msg){
			alert("网络超时！");
		}
	});
}
function showtime()
{
ShowCountDown1(time1.getFullYear(),time1.getMonth()+1,time1.getDate(),time1.getHours(),time1.getMinutes(),time1.getSeconds(),'divdown1');
ShowCountDown2(time2.getFullYear(),time2.getMonth()+1,time2.getDate(),time2.getHours(),time2.getMinutes(),time2.getSeconds(),'divdown2');

}
function ShowCountDown1(year,month,day,hour,minite,second,divname) 
{ 
var now = new Date(); 
var endDate = new Date(year, month-1, day,hour,minite,second); 
var leftTime=endDate.getTime()-now.getTime();
var cc = document.getElementById(divname); 
if(leftTime>0)
{
var leftsecond = parseInt(leftTime/1000); 
var day1=Math.floor(leftsecond/(60*60*24)); 
var hour=Math.floor((leftsecond-day1*24*60*60)/3600);
var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
cc.innerHTML = "提示:距离"+workName+"系统开启时间还有"+day1+"天"+hour+"小时"+minute+"分"+second+"秒";
}else{
cc.innerHTML = workName+"系统已经开启";
}
} 
function ShowCountDown2(year,month,day,hour,minite,second,divname) { 
var now = new Date(); 
var endDate = new Date(year, month-1, day); 
var leftTime=endDate.getTime()-now.getTime(); 
var cc = document.getElementById(divname); 
if(leftTime>0)
{
var leftsecond = parseInt(leftTime/1000);
//var day1=parseInt(leftsecond/(24*60*60*6)); 
var day1=Math.floor(leftsecond/(60*60*24)); 
var hour=Math.floor((leftsecond-day1*24*60*60)/3600); 
var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
cc.innerHTML = "距离"+workName+"系统截止时间还有"+day1+"天"+hour+"小时"+minute+"分"+second+"秒";
}else{
	cc.innerHTML = workName+"系统已经截止";
}
} 
function time(date)
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