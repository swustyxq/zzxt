$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/showCzIntroduction.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var czIntroduction="";
				czIntroduction="<h4 align='center'><b>"+msg.czIntroduction.title+"</b></h4>"
								+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.czIntroduction.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>所属类别：</span><span>"+msg.czIntroduction.type+"</span><br />"
								+"<span>最后修改时间：</span><span>"+msg.czIntroduction.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>发布时间：</span><span>"+msg.czIntroduction.publishTime+"</span></div><br />" +
								"<pre>"+msg.czIntroduction.content+"</pre>";
				$("#czIntroduction").empty().append(czIntroduction);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});