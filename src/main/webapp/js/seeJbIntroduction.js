$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/jbController/showJbIntroduction.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var jbIntroduction="";
				jbIntroduction="<h4 align='center'><b>"+msg.jbIntroduction.title+"</b></h4>"
								+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.jbIntroduction.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>所属类别：</span><span>"+msg.jbIntroduction.type+"</span><br />"
								+"<span>最后修改时间：</span><span>"+msg.jbIntroduction.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>发布时间：</span><span>"+msg.jbIntroduction.publishTime+"</span></div><br />" +
								"<pre>"+msg.jbIntroduction.content+"</pre>";
				$("#jbIntroduction").empty().append(jbIntroduction);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});