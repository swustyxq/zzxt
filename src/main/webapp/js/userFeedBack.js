$(document).ready(function (){
	$("#save").click(function(){
			var content=$("#content").val();
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/suggestionController/publishSuggestion.do',
				async : false,
				data : {
					content:content
				},
				dataType : 'json',
				success : function(msg) {
					if(msg.result ==true){
						alert("反馈成功！");
						var tip="<div class='alert alert-success alert-dismissible fade in' role='alert'>"
						+"<button type='button' class='close' data-dismiss='alert'>"
							+"<span aria-hidden='true'>×</span><span class='sr-only'>Close</span>"
						+"</button><h4>温馨提示：</h4></table>感谢您的意见</div>"
						+"<div align='center'><button onclick='javascript:opener.loaction.reload()' class='btn btn-primary' type='button'>再次填写</button>"
							+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick='javascript: history.go(-1);' class='btn btn-info' type='button'>"
						+"<span class='glyphicon glyphicon-arrow-left'></span> 返回</button></div>";
						$("#backinfo").empty().append(tip);
					}else{
						alert(msg.message);
					}
				},error: function(msg){
				    alert("网络超时！");
				}
			});
		
	});
});

function check(){
	if($("#title").val().trim()==""){
		var tip="<div class='alert alert-danger alert-dismissible fade in' role='alert'>"+
      "<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>×</span><span class='sr-only'>Close</span></button>"+
	    "标题不能为空！</div>";
		$("#tip").empty().append(tip);
		return false;
	}else if($("#content").val().trim()=="" || $("#content").val().length<10){
		var tip="<div class='alert alert-danger alert-dismissible fade in' role='alert'>"+
	      "<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>×</span><span class='sr-only'>Close</span></button>"+
		    "反馈的内容不能为空！请检查您的内容！</div>";
			$("#tip1").empty().append(tip);
		return false;
	}else{
		return true;
	}
};

function cleanTip(){
	$("#tip").empty();
}

function cleanTip1(){
	$("#tip1").empty();
}