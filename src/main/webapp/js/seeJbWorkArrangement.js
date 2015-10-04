$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/jbController/showJbWorkArrangement.do',
		async : false,
		data : {
			id:8
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var JbWorkArrangement="";
				JbWorkArrangement="<h4 align='center'><b>"+msg.JbWorkArrangement.title+"</b></h4>"
								+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.JbWorkArrangement.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>所属类别：</span><span>"+msg.JbWorkArrangement.type+"</span><br />"
								+"<span>最后修改时间：</span><span>"+msg.JbWorkArrangement.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>发布时间：</span><span>"+msg.JbWorkArrangement.publishTime+"</span></div><br />" +
								"<pre>"+msg.JbWorkArrangement.content+"</pre>";
				$("#JbWorkArrangement").empty().append(JbWorkArrangement);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});