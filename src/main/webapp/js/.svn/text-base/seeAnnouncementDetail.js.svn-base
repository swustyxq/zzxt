$(document).ready(function (){
	var Request = new Object();
	Request = GetRequest();

	if (Request != null) {
		id = Request['id'];
	}

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/announcementController/findAnnouncementsById.do',
		async : false,
		data : {
			id:id
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var detail="";
				detail="<h4 align='center'><b>"+msg.detail.title+"</b></h4>"
								+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.detail.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>所属类别：</span><span>"+msg.detail.type+"</span><br />"
								+"<span>最后修改时间：</span><span>"+msg.detail.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>发布时间：</span><span>"+msg.detail.publishTime+"</span></div><br />" +
								"<pre>"+msg.detail.content+"</pre>";
				$("#detail").empty().append(detail);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});



function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();

	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for ( var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	if (url.indexOf("id") == -1) {
		theRequest = null;
	}
	return theRequest;
}