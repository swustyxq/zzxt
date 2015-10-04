$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/showPaIntroduction.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var paIntroduction="";
				paIntroduction="<h4 align='center'><b>"+msg.paIntroduction.title+"</b></h4>"
								+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.paIntroduction.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>所属类别：</span><span>"+msg.paIntroduction.type+"</span><br />"
								+"<span>最后修改时间：</span><span>"+msg.paIntroduction.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>发布时间：</span><span>"+msg.paIntroduction.publishTime+"</span></div><br />" +
								"<pre>"+msg.paIntroduction.content+"</pre>";
				$("#paIntroduction").empty().append(paIntroduction);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});