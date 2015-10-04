$(document).ready(function() {
	var roleId=0;
	var Request = new Object();
	Request = GetRequest();
	if(Request!=null)
	{
		roleId=Request['id'];
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/editController/showRoleMessage.do',
		async : false,
		data : {
			roleId:roleId,
		},
		dataType : 'json',
		success : function(msg) {
			var str="";
			if (msg.result == true){
				document.getElementById('roleType').innerHTML ="角色类型:"+msg.role.roleName;// 角色类型	
				$.each(msg.function1, function(key, val) {
					str += "<tr><td>"
					/*+"<input type='checkbox' checked=checked class='noborder' name='will' id='yes' value=function1[key]>"
					*/
					+"&nbsp" + (key + 1)
					+ "</td><td>" + val.funcName 
					+ "</td></tr>";
				});
				$("#functionType").empty().append(str);
				}
		},error : function(msg) {
			alert("网络超时！");
		}
	});
	
});
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