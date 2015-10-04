var t1 = new Array(); //创建一个数组
var t2 = new Array(); //创建一个数组
var workname = new Array(); //创建一个数组
$(document).ready(function() {
	findTime();//获取时间
	
	showTimes();
	
	var type1=3;//资助通知
	var content1=showInfo(type1);
	content1+="<p class='text-right'><a href='showAnnouncements.html?type=3'>更多&gt;&gt;</a></p>";
	
	var type2=4;//公示
	var content2=showInfo(type2);
	content2+="<p class='text-right'><a href='showAnnouncements.html?type=4'>更多&gt;&gt;</a></p>";
	$("#zhengce").empty().append(content1);
	$("#gongshi").empty().append(content2);
});

function showInfo(type){
	var content="";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/announcementController/findAnnouncementsByType.do',
		async : false,
		data : {
			type:type
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var max=msg.announcement.length>5?5:msg.announcement.length;
				content+="<ol>";
				for(var i=0;i<max;i++){
					content+="<li><a href='seeAnnouncementDetail.html?id="+msg.announcement[i].id+"'> <span class='glyphicon glyphicon-folder-close'></span>&nbsp;"+
							msg.announcement[i].title+"</a></li>";
				}
				content+="</ol>";
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	return content;
}

function showTimes(){
	var str="";
	for(var i=0;i<t1.length;i++){
		var time_distance,time_distance2;
		 var time_now=new Date();
		 time_distance=t2[i]-time_now;
		 time_distance2=time_now-t1[i];
		 var int_day,int_hour,int_minute,int_second;
		 if(time_distance2<0)
		 {
		 	  time_distance2=-time_distance2;
			  int_day=Math.floor(time_distance2/86400000);
			  time_distance2-=int_day*86400000;
			  int_hour=Math.floor(time_distance2/3600000);
			  time_distance2-=int_hour*3600000;
			  int_minute=Math.floor(time_distance2/60000);
			  time_distance2-=int_minute*60000;
			  int_second=Math.floor(time_distance2/1000);
			  if(int_hour<10)
			  int_hour="0"+int_hour;
			  if(int_minute<10)
			  int_minute="0"+int_minute;
			  if(int_second<10)
			   int_second="0"+int_second;
			   str+="<li>"+workname[i]+"还有"+"<font  color=\"red\"><b>"+int_day+"天"+int_hour+"小时"+int_minute+"分钟"+int_second+"秒</b></font >开启,&nbsp;&nbsp;";
		 }else{
		 		str+="<li>"+workname[i]+"系统已经开启"+",&nbsp;&nbsp;";
		 }
		 if(time_distance>0)
		 {
			  int_day=Math.floor(time_distance/86400000);
			  time_distance-=int_day*86400000;
			  int_hour=Math.floor(time_distance/3600000);
			  time_distance-=int_hour*3600000;
			  int_minute=Math.floor(time_distance/60000);
			  time_distance-=int_minute*60000;
			  int_second=Math.floor(time_distance/1000);
			  if(int_hour<10)
			  int_hour="0"+int_hour;
			  if(int_minute<10)
			  int_minute="0"+int_minute;
			  if(int_second<10)
			  int_second="0"+int_second;
			  str+=""+workname[i]+"还有<font  color=\"red\"><b>"+int_day+"天"+int_hour+"小时"+int_minute+"分钟"+int_second+"秒</b></font >"+"截止</li>";
		 }else
		 {
		  	  str+=""+workname[i]+"到期"+"</li>";
		 }
	$("#tishi").empty().append(str);
	//setTimeout("showTimes",1000*60);
	}
}

function findTime(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/WorkController/showAllWorkinfo.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result==true)
			{
				for(var i=0;i<msg.work.length;i++)
				{
					 
					 var time1= new Date(msg.work[i].workStarttime);
					 var time2= new Date(msg.work[i].workEndtime);
					 time_start = time1;
					 time_end = time2;
					 t1[i]=time1;
					 t2[i]=time2;
					 workname[i]=msg.work[i].workName;
				}	 
				setInterval(showTimes,1000);
			}else{
				alert("系统时间已经截止！");
			}
		},error : function(msg){
			alert("网络超时！");
		}
	});
}