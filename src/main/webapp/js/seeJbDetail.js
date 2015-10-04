$(document).ready(function(){
	var Request = new Object();
	Request = GetRequest();
	var studId = 0 ;
	if(Request!=null)
	{
	studId = Request['id'];
	}
	showStuJbDeatail(studId);
});

var str = "<tr><th>姓名</th><th>学号</th><th>获得金额</th><th>获取时间</th><th>具体内容</th></tr>";
function showStuJbDeatail(studId){
	$.ajax({
		type:"post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/jbController/selectJbInfoByStuId.do',
		async : false,
		data : {
			studId:studId
		},
		success : function(msg) {
			if(msg.result == true){	
				str +="<tr>"+"<td>"+msg.student.studName+"</td>"+"<td>"+msg.student.studNumber+"</td>"
				+"<td>"+msg.xfjb.xfjbAmount+"</td>"+"<td>"+msg.xfjb.xfjbTime+"</td>"+"<td>"+msg.xfjb.xfjbContent+"</td>"
				+"</tr>";
				$("#xfjbDetail").empty().append(str);
			
			}else{
				$("#xfjbDetail").empty().append("<tr>"+"<td>"+msg.message+"</td>"+"</tr>");
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}
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