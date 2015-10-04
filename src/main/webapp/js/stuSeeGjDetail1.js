$(document).ready(function (){
	var studNumber = "20112356";
	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/gjjxjController/obtainGjjxjByStudNumber.do',
		async : false,
		data : {
			studNumber:studNumber
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				$("#studName").empty().append(msg.student.studName);	
				if(msg.getGjxjApplytime!=""){
					$("#gzxjApplytime").empty().append(msg.getGjxjApplytime);
					$("#gjxjRecommendreason").empty().append(msg.gjjxjWithBLOBS.gjxjRecommendreason);
					$("#gjxjAcademyopinion").empty().append(msg.gjjxjWithBLOBS.gjxjAcademyopinion);
					$("#gjxjSchoolopinion").empty().append(msg.gjjxjWithBLOBS.gjxjSchoolopinion);
				}else{
					alert("还没有申请信息");
				}	
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});