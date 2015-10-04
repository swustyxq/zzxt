/*Author:Yang Junhui
 * Time:20140720
 * Function:在社会奖学金查看列表中，根据不同的搜索条件显示不同的学生列表，并
 * 根据不同用户角色，赋予不同的操作权限*/


$(document).ready(function(){
	Query();
});

$("#Query").click(function(){
	Query();
});


function Query(){
	var annual = "全部",className = "全部",majorName = "全部",colleageName = "全部";//默认全部查询
	annual = $("#annual").val();
	colleageName = $("#colleage").val();
	majorName = $("#major").val();
	className = $("#stuclass").val();
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/shjxjController/showAllSutdSelective.do',
		async : false,
		data : {
			annual:annual,
			colleageName:colleageName,
			majorName:majorName,
			className:className,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (msg.message == "loginout"){
					alert("用户已退出，请重新登录！");
					window.location.href = "login.html";
				}
				//显示申请学生情况列表
				var studentlist = "";
				var index = 1;
				var state = "未提交";
				$.each(msg.stuNeededShowInfos, function(key, val){
					if (msg.maxroleId != 1 && msg.wsflRoleids[key] == msg.maxroleId){
						operation = "审核";
					}else{
						operation = "查看";
					}
					if(msg.wsflRoleids[key] == 2){
						state = "辅导员审核中";
					}else if (msg.wsflRoleids[key] == 8){
						state = "经办老师审核中";
					}else if (msg.wsflRoleids[key] == 13){
						state = "学办主任审核中";
					}else if (msg.wsflRoleids[key] == 14){
						state = "学院审核中";
					}else if (msg.wsflRoleids[key] == 15){
						state = "学校审核中";
					}
					if (msg.shjxjStates[key] == 1){
						state = "通过";
					}
					studentlist += "<tr>"
									+ "<td>" + index + "</td>"
									+ "<td>" + val.studName + "</td>"
									+ "<td>" + val.studNumber + "</td>"
									+ "<td>" + val.studInstShortName + "</td>"
									+ "<td>" + val.studClassShortName + "</td>"
									+ "<td>" + msg.shjxjApllyTime[key] + "</td>"
									+ "<td>" + state + "</td>"
									+ "<td><a href='seeSjDetail.html?id="+ msg.studId[key] +"'>" + operation + "</a></td>"
								 + "</tr>";
					index++;
				});
				$("#Shjxjlist").empty().append(studentlist);
			} else {
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}


