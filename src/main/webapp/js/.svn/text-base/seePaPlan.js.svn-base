$(document).ready(function (){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/paController/showPaPlan.do',
		async : false,
		data : {			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var paPlan="";
				paPlan="<h4 align='center'><b>"+msg.paPlan.title+"</b></h4>"
								+"<div style='text-align: center'><br /><span>发布人：</span> <span>"+msg.paPlan.user+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>所属类别：</span><span>"+msg.paPlan.type+"</span><br />"
								+"<span>最后修改时间：</span><span>"+msg.paPlan.lastModifyTime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " +
								"<span>发布时间：</span><span>"+msg.paPlan.publishTime+"</span></div><br />" +
								"<pre>"+msg.paPlan.content+"</pre>";
				$("#paPlan").empty().append(paPlan);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});