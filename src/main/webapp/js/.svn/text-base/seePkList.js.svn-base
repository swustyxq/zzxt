var list;// 存所有信息
var rightlist = new Array();// 存符合筛选条件的信息
var countlist;//统计信息
var pagecount;
var everypage=10;//
var colleageId;
var majorId;
var classId;
$(document).ready(function(){
	document.onkeydown = function(e){    
	    var ev = document.all ? window.event : e;  
	    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
	        //要处理的事件  
	    	document.getElementById("Query").click(); //调用登录按钮的登录事件  
	    }
	  };
	  showPkstu();
});
//按条件查询的贫困生列表
function showPkstu()
{
		document.getElementById("studentList").style.display="";
		colleageId = document.getElementById("colleage").value;
		majorId = document.getElementById("major").value;
		classId = document.getElementById("stuclass").value;
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/pkController/showPkStud.do',
			async : false,
			data : {
				colleageId:colleageId,
				majorId:majorId,
				classId:classId
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.user.userType!=1){
				document.getElementById("fenye").style.display="block";
				}
				if(msg.pksglbasicinfo==""||msg.pksglbasicinfo==null){
					alert("无可查看的贫困生信息");
					var str="<tr><th><h3>无可查看的贫困生信息</h3></th></tr>";
					$("#studentPkListTable").empty().append(str);
				}else{
				rightlist = msg.pksglbasicinfo;
				var pageStuList = new Array();
				var max = 0;
				max=rightlist.length>everypage ? everypage:rightlist.length;
				var a=0;
				for (var j = 0; j < max; j++) {
					pageStuList[a++]=rightlist[j];
				}
				pagecount = rightlist.length%everypage==0?parseInt(rightlist.length/everypage):parseInt(rightlist.length/everypage)+1;
				var str="<tr><th>序号</th><th>学院</th><th>专业</th><th>班级</th><th>姓名</th><th>申请时间</th><th>审核状态</th><th>操作</th></tr>";
				for(var i=0;i<pageStuList.length;i++)
				{
					if(pageStuList!=null)
					{
						str+="<tr><td>"+(i+1)
						+"</td><td>"+pageStuList[i].instShortName
						+"</td><td>"+pageStuList[i].majrName
						+"</td><td>"+pageStuList[i].classShortName
						+"</td><td>"+pageStuList[i].studentName
						+"</td><td>"+time1(pageStuList[i].applyTime);
						if(pageStuList[i].roleId==0)
						{
						str+="</td><td>"+"审核完成";
						}else if(pageStuList[i].roleId==1)
						{
						str+="</td><td>"+"学生已填写申请";
						}else if(pageStuList[i].roleId==2)
						{
						str+="</td><td>"+"待辅导员审核";
						}else if(pageStuList[i].roleId==6)
						{
						str+="</td><td>"+"待经办老师审核";
						}else if(pageStuList[i].roleId==13)
						{
						str+="</td><td>"+"待学办主任审核";
						}else if(pageStuList[i].roleId==14)
						{
						str+="</td><td>"+"待学院分管副书记审核";
						}else if(pageStuList[i].roleId==20)
						{
						str+="</td><td>"+"待学生处审核";
						}
						if(msg.maxrole==pageStuList[i].roleId)
						{
						str+=
						"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>审核</button></a>"
						+"</td></tr>";
						}else
						{
						str+=
						"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>查看详细</button></a>"
						+"</td></tr>";
						}
					}
				}
				$("#studentPkListTable").empty().append(str);
				if(msg.user.userType>=6)
				{
					document.getElementById("table1").style.display="";
					document.getElementById("table2").style.display="";
					document.getElementById("tongji2").style.display="none";
					document.getElementById("tongji3").style.display="none";
				}else if(msg.user.userType>2){
					document.getElementById("table1").style.display="";
					document.getElementById("table2").style.display="";
					document.getElementById("tongji1").style.display="none";
				}else if(msg.user.userType==2){
					document.getElementById("table1").style.display="";
					document.getElementById("table2").style.display="";
					document.getElementById("tongji1").style.display="none";
					document.getElementById("tongji2").style.display="none";
				}else{
				}
				$("#studentList").paginate({
					count 		: pagecount,
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
							max = rightlist.length > page * everypage ? page * everypage:
								 rightlist.length;
							var a=0;
							for (var j = (page - 1) * everypage; j < max; j++) {
								pageStuList[a++]=rightlist[j];
							}
							var str="<tr><th>序号</th><th>学院</th><th>专业</th><th>班级</th><th>姓名</th><th>申请时间</th><th>审核状态</th><th>操作</th></tr>";
							if(pageStuList!=null)
							{
							for(var i=0;i<pageStuList.length;i++)
							{
								if(pageStuList[i]!=null)
								{
									str+="<tr><td>"+(i+1)
									+"</td><td>"+pageStuList[i].instShortName
									+"</td><td>"+pageStuList[i].majrName
									+"</td><td>"+pageStuList[i].classShortName
									+"</td><td>"+pageStuList[i].studentName
									+"</td><td>"+time1(pageStuList[i].applyTime);
									if(pageStuList[i].roleId==0)
									{
									str+="</td><td>"+"审核完成";
									}else if(pageStuList[i].roleId==1)
									{
									str+="</td><td>"+"学生已填写申请";
									}else if(pageStuList[i].roleId==2)
									{
									str+="</td><td>"+"待辅导员审核";
									}else if(pageStuList[i].roleId==6)
									{
									str+="</td><td>"+"待经办老师审核";
									}else if(pageStuList[i].roleId==13)
									{
									str+="</td><td>"+"待学办主任审核";
									}else if(pageStuList[i].roleId==14)
									{
									str+="</td><td>"+"待学院分管副书记审核";
									}else if(pageStuList[i].roleId==20)
									{
									str+="</td><td>"+"待学生处审核";
									}
									if(msg.maxrole==pageStuList[i].roleId)
									{
									str+=
									"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>审核</button></a>"
									+"</td></tr>";
									}else
									{
									str+=
									"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>查看详细</button></a>"
									+"</td></tr>";
									}
								}
							}
							}
							$("#studentPkListTable").empty().append(str);
					}
				});
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
}
//页面加载时显示的贫困生列表(已不用)
function showAllPkStu(){
$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showALLPkStu.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				list = msg.pksglbasicinfo;
				//document.getElementById("select").style.display="none";
				var str="<tr><td>序号</td><td>学院</td><td>专业</td><td>班级</td><td>姓名</td><td>申请时间</td><td>审核状态</td><td>操作</td></tr>";
				if(msg.pksglbasicinfo.length>0)
				{
				for(var i=0;i<msg.pksglbasicinfo.length;i++)
				{
						str+="<tr><td>"+(i+1)
						+"</td><td>"+msg.pksglbasicinfo[i].instShortName
						+"</td><td>"+msg.pksglbasicinfo[i].majrName
						+"</td><td>"+msg.pksglbasicinfo[i].classShortName
						+"</td><td>"+msg.pksglbasicinfo[i].studentName
						+"</td><td>"+msg.pksglbasicinfo[i].applyTime;
						if(msg.pksglbasicinfo[i].roleId==0)
						{
						str+="</td><td>"+"审核完成";
						}else if(msg.pksglbasicinfo[i].roleId==1)
						{
						str+="</td><td>"+"学生已填写申请";
						}else if(msg.pksglbasicinfo[i].roleId==2)
						{
						str+="</td><td>"+"待辅导员审核";
						}else if(msg.pksglbasicinfo[i].roleId==6)
						{
						str+="</td><td>"+"待经办老师审核";
						}else if(msg.pksglbasicinfo[i].roleId==13)
						{
						str+="</td><td>"+"待学办主任审核";
						}else if(msg.pksglbasicinfo[i].roleId==14)
						{
						str+="</td><td>"+"待学院分管副书记审核";
						}else if(msg.pksglbasicinfo[i].roleId==20)
						{
						str+="</td><td>"+"待学生处审核";
						}
						if(msg.maxrole==msg.pksglbasicinfo[i].roleId)
						{
						str+=
						"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+msg.pksglbasicinfo[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>审核</button></a>"
						+"</td></tr>";
						}else
						{
						str+=
						"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+msg.pksglbasicinfo[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>查看详细</button></a>"
						+"</td></tr>";
						}
				}
				$("#studentPkListTable").empty().append(str);
				if(msg.user.userType==1)
				{
					document.getElementById("table1").style.display="none";
					document.getElementById("table2").style.display="none";
				}
				}else{
					alert("无可查看的贫困生信息");
				}
				if(msg.user.userType>=6)
				{
					document.getElementById("tongji2").style.display="none";
					document.getElementById("tongji3").style.display="none";
				}else if(msg.user.userType>2){
					document.getElementById("tongji1").style.display="none";
				}else if(msg.user.userType==2){
					document.getElementById("tongji1").style.display="none";
					document.getElementById("tongji2").style.display="none";
				}else{
					document.getElementById("tongji1").style.display="none";
					document.getElementById("tongji2").style.display="none";
					document.getElementById("tongji3").style.display="none";
				}
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}
//导出表格
function export1(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/export.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				//alert("已成功导出到d盘——lstdApply");
				location.href="/zzxt/pkController/download.do?id=1";
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
//显示统计信息
function showTongjiinfo(st)
{
	document.getElementById("studentList").style.display="none";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showTongjiinfo.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			var allCzylTable="";
			if(st==1){
				var str="<tr><td>序号</td><td>学院</td><td>学院总人数</td><td>贫困生申请人数</td>"
				+"<td>特殊贫困人数</td><td>贫困人数</td><td>一般贫困人数</td><td>不贫困人数</td><td>贫困生总人数</td><td>贫困生比例</td></tr>";
				for(var i=0;i<msg.tongjiinfo.length;i++){
					if(msg.tongjiinfo[i].instId!=15&&msg.tongjiinfo[i].instId!=18&&msg.tongjiinfo[i].instId!=20&&msg.tongjiinfo[i].instId!=19)
					{
						str+="<tr><td>"+(i+1)+"</td><td>"
						+msg.tongjiinfo[i].instName+"</td><td>"
						+msg.tongjiinfo[i].studSumNum+"</td><td>"
						+msg.tongjiinfo[i].studApplyNum+"</td><td>"
						+msg.tongjiinfo[i].teshuPkstudNum+"</td><td>"
						+msg.tongjiinfo[i].pinkunStudNum+"</td><td>"
						+msg.tongjiinfo[i].yibanPkStudNum+"</td><td>"
						+msg.tongjiinfo[i].bupinkunNum+"</td><td>"
						+msg.tongjiinfo[i].allPkNum+"</td><td>";
						if(msg.tongjiinfo[i].studSumNum!=0)
						{
							var t=0;
							t = parseInt((msg.tongjiinfo[i].allPkNum*100)/msg.tongjiinfo[i].studSumNum);
							str += t/10+"%"+"</td><td>";
						}else{
							str +="——</td><td>";
						}
					}
				}
				$("#studentPkListTable").empty().append(str);
				
				allCzylTable +="<thead><tr><td align='center'><button type='button' class='btn btn-info' onclick='javascript:return2()'><span class='glyphicon glyphicon-arrow-left'></span>返回</button></td></tr></thead>";
				$("#return").empty().append(allCzylTable);
			}else if(st==2){
				var str="<tr><td>序号</td><td>专业</td><td>专业总人数</td><td>贫困生申请人数</td>"
				+"<td>特殊贫困人数</td><td>贫困人数</td><td>一般贫困人数</td><td>不贫困人数</td><td>贫困生总人数</td><td>贫困生比例</td></tr>";
				for(var i=0;i<msg.tongjiinfo1.length;i++){
					if(msg.tongjiinfo[i].instId!=15&&msg.tongjiinfo[i].instId!=18&&msg.tongjiinfo[i].instId!=20&&msg.tongjiinfo[i].instId!=19)
					{
						str+="<tr><td>"+(i+1)+"</td><td>"
						+msg.tongjiinfo1[i].majrName+"</td><td>"
						+msg.tongjiinfo1[i].studSumNum+"</td><td>"
						+msg.tongjiinfo1[i].studApplyNum+"</td><td>"
						+msg.tongjiinfo1[i].teshuPkstudNum+"</td><td>"
						+msg.tongjiinfo1[i].pinkunStudNum+"</td><td>"
						+msg.tongjiinfo1[i].yibanPkStudNum+"</td><td>"
						+msg.tongjiinfo1[i].bupinkunNum+"</td><td>"
						+msg.tongjiinfo1[i].allPkNum+"</td><td>";
						if(msg.tongjiinfo[i].studSumNum!=0)
						{
							var t=0;
							t = parseInt((msg.tongjiinfo[i].allPkNum*100)/msg.tongjiinfo[i].studSumNum);
							str += t/10+"%"+"</td><td>";
						}else{
							str +="——</td><td>";
						}
					}
				}
				$("#studentPkListTable").empty().append(str);
				allCzylTable +="<thead><tr><td align='center'><button type='button' class='btn btn-info' onclick='javascript:return2()'><span class='glyphicon glyphicon-arrow-left'></span>返回</button></td></tr></thead>";
				$("#return").empty().append(allCzylTable);
			}else if(st==3){
				var str="<tr><td>序号</td><td>班级</td><td>班级总人数</td><td>贫困生申请人数</td>"
				+"<td>特殊贫困人数</td><td>贫困人数</td><td>一般贫困人数</td><td>不贫困人数</td><td>贫困生总人数</td><td>贫困生比例</td></tr>";
				for(var i=0;i<msg.tongjiinfo.length;i++){
					if(msg.tongjiinfo[i].instId!=15&&msg.tongjiinfo[i].instId!=18&&msg.tongjiinfo[i].instId!=20&&msg.tongjiinfo[i].instId!=19)
					{
						str+="<tr><td>"+(i+1)+"</td><td>"
						+msg.tongjiinfo[i].studClassName+"</td><td>"
						+msg.tongjiinfo[i].studSumNum+"</td><td>"
						+msg.tongjiinfo[i].studApplyNum+"</td><td>"
						+msg.tongjiinfo[i].teshuPkstudNum+"</td><td>"
						+msg.tongjiinfo[i].pinkunStudNum+"</td><td>"
						+msg.tongjiinfo[i].yibanPkStudNum+"</td><td>"
						+msg.tongjiinfo[i].bupinkunNum+"</td><td>"
						+msg.tongjiinfo[i].allPkNum+"</td><td>";
						if(msg.tongjiinfo[i].studSumNum!=0)
						{
							var t=0;
							t = parseInt((msg.tongjiinfo[i].allPkNum*100)/msg.tongjiinfo[i].studSumNum);
							str += t/10+"%"+"</td><td>";
						}else{
							str +="——</td><td>";
						}
					}
				}
				$("#studentPkListTable").empty().append(str);
				allCzylTable +="<thead><tr><td align='center'><button type='button' class='btn btn-info' onclick='javascript:return2()'><span class='glyphicon glyphicon-arrow-left'></span>返回</button></td></tr></thead>";
				$("#return").empty().append(allCzylTable);
			}
		},error : function(msg) {
		}
	});
}
function time1(date)
{
	   var time= date;
	   var year = time.substring(0,4);
	   var month = time.substring(5,7);//月份要加1
	   var day = time.substring(8,10);
		var time1=year+"年"+month+"月"+day+"日"; 
	   return time1;
}
function time(date)
{
	 var time= new Date(date);
	   var year = time.getFullYear();
	   var month = time.getMonth()+1;//月份要加1
	   var day = time.getDate();
	   if(month<10)
		{
		   month ="0"+month;
		}
	   if(day<10)
		{
		   day ="0"+day;  
		}
		var time1=year+"年"+month+"月"+day+"日"; 
	   return time1;
}
function return2(){
	$("#return").empty().append("");
	//showPkstu();

	document.getElementById("studentList").style.display="";
	//colleageId = document.getElementById("colleage").value;
	//majorId = document.getElementById("major").value;
	//classId = document.getElementById("stuclass").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/pkController/showPkStud.do',
		async : false,
		data : {
			colleageId:colleageId,
			majorId:majorId,
			classId:classId
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.user.userType!=1){
			document.getElementById("fenye").style.display="block";
			}
			if(msg.pksglbasicinfo==""||msg.pksglbasicinfo==null){
				//alert("无可查看的贫困生信息");
				var str="<tr><th><h3>无可查看的贫困生信息</h3></th></tr>";
				$("#studentPkListTable").empty().append(str);
			}else{
			rightlist = msg.pksglbasicinfo;
			var pageStuList = new Array();
			var max = 0;
			max=rightlist.length>everypage ? everypage:rightlist.length;
			var a=0;
			for (var j = 0; j < max; j++) {
				pageStuList[a++]=rightlist[j];
			}
			pagecount = rightlist.length%everypage==0?parseInt(rightlist.length/everypage):parseInt(rightlist.length/everypage)+1;
			var str="<tr><th>序号</th><th>学院</th><th>专业</th><th>班级</th><th>姓名</th><th>申请时间</th><th>审核状态</th><th>操作</th></tr>";
			for(var i=0;i<pageStuList.length;i++)
			{
				if(pageStuList!=null)
				{
					str+="<tr><td>"+(i+1)
					+"</td><td>"+pageStuList[i].instShortName
					+"</td><td>"+pageStuList[i].majrName
					+"</td><td>"+pageStuList[i].classShortName
					+"</td><td>"+pageStuList[i].studentName
					+"</td><td>"+time1(pageStuList[i].applyTime);
					if(pageStuList[i].roleId==0)
					{
					str+="</td><td>"+"审核完成";
					}else if(pageStuList[i].roleId==1)
					{
					str+="</td><td>"+"学生已填写申请";
					}else if(pageStuList[i].roleId==2)
					{
					str+="</td><td>"+"待辅导员审核";
					}else if(pageStuList[i].roleId==6)
					{
					str+="</td><td>"+"待经办老师审核";
					}else if(pageStuList[i].roleId==13)
					{
					str+="</td><td>"+"待学办主任审核";
					}else if(pageStuList[i].roleId==14)
					{
					str+="</td><td>"+"待学院分管副书记审核";
					}else if(pageStuList[i].roleId==15)
					{
					str+="</td><td>"+"待学生处审核";
					}
					if(msg.maxrole==pageStuList[i].roleId)
					{
					str+=
					"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>审核</button></a>"
					+"</td></tr>";
					}else
					{
					str+=
					"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>查看详细</button></a>"
					+"</td></tr>";
					}
				}
			}
			$("#studentPkListTable").empty().append(str);
			if(msg.user.userType>=6)
			{
				document.getElementById("table1").style.display="";
				document.getElementById("table2").style.display="";
				document.getElementById("tongji2").style.display="none";
				document.getElementById("tongji3").style.display="none";
			}else if(msg.user.userType>2){
				document.getElementById("table1").style.display="";
				document.getElementById("table2").style.display="";
				document.getElementById("tongji1").style.display="none";
			}else if(msg.user.userType==2){
				document.getElementById("table1").style.display="";
				document.getElementById("table2").style.display="";
				document.getElementById("tongji1").style.display="none";
				document.getElementById("tongji2").style.display="none";
			}else{
			}
			$("#studentList").paginate({
				count 		: pagecount,
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
						max = rightlist.length > page * everypage ? page * everypage:
							 rightlist.length;
						var a=0;
						for (var j = (page - 1) * everypage; j < max; j++) {
							pageStuList[a++]=rightlist[j];
						}
						var str="<tr><th>序号</th><th>学院</th><th>专业</th><th>班级</th><th>姓名</th><th>申请时间</th><th>审核状态</th><th>操作</th></tr>";
						if(pageStuList!=null)
						{
						for(var i=0;i<pageStuList.length;i++)
						{
							if(pageStuList[i]!=null)
							{
								str+="<tr><td>"+(i+1)
								+"</td><td>"+pageStuList[i].instShortName
								+"</td><td>"+pageStuList[i].majrName
								+"</td><td>"+pageStuList[i].classShortName
								+"</td><td>"+pageStuList[i].studentName
								+"</td><td>"+time1(pageStuList[i].applyTime);
								if(pageStuList[i].roleId==0)
								{
								str+="</td><td>"+"审核完成";
								}else if(pageStuList[i].roleId==1)
								{
								str+="</td><td>"+"学生已填写申请";
								}else if(pageStuList[i].roleId==2)
								{
								str+="</td><td>"+"待辅导员审核";
								}else if(pageStuList[i].roleId==6)
								{
								str+="</td><td>"+"待经办老师审核";
								}else if(pageStuList[i].roleId==13)
								{
								str+="</td><td>"+"待学办主任审核";
								}else if(pageStuList[i].roleId==14)
								{
								str+="</td><td>"+"待学院分管副书记审核";
								}else if(pageStuList[i].roleId==15)
								{
								str+="</td><td>"+"待学生处审核";
								}
								if(msg.maxrole==pageStuList[i].roleId)
								{
								str+=
								"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>审核</button></a>"
								+"</td></tr>";
								}else
								{
								str+=
								"</td><td>"+"<a href=\"/zzxt/htmls/seePkDetail.html?id="+pageStuList[i].studentId+"\"><button type='button' class='btn btn-success btn-xs'>查看详细</button></a>"
								+"</td></tr>";
								}
							}
						}
						}
						$("#studentPkListTable").empty().append(str);
				}
			});
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});

}