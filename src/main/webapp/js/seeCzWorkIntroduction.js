$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/czController/showCzWorkIntroduction.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var czWorkIntroduction="";
				czWorkIntroduction="<h4 align='center'><b>"+msg.czWorkIntroduction.title+"</b></h4>"
								+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.czWorkIntroduction.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>所属类别：</span><span>"+msg.czWorkIntroduction.type+"</span><br />"
								+"<span>最后修改时间：</span><span>"+msg.czWorkIntroduction.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>发布时间：</span><span>"+msg.czWorkIntroduction.publishTime+"</span></div><br />" +
								"<pre>"+msg.czWorkIntroduction.content+"</pre>";
				$("#czWorkIntroduction").empty().append(czWorkIntroduction);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});