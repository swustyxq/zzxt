$(document).ready(function (){
	
	var Request = new Object();
	Request = GetRequest();
	var studId = 0 ;
	if(Request!=null)
	{
	studId = Request['id'];
	}
	showDetailInfo(studId);
});

function showDetailInfo(stuId){
$.ajax({
	type : "post",
	contentType : "application/x-www-form-urlencoded;charset=UTF-8",
	url : '/zzxt/informationController/showStuDeatilInfo.do',
	async : false,
	data : {
		stuId:stuId
	},
	dataType : 'json',
	success : function(msg) {
		if(msg.result==true){
		
			/*个人信息*/
			var stuPersonal="<tr>" + "<th>姓名</th>" + "<td>"
			+ msg.student.studName + "</td>"
			+ "<th>学号</th>" + "<td>"
			+ msg.student.studNumber + "</td>"
			+ "<th>民族</th>" + "<td>" + msg.student.studNation
			+ "</td>" + "</tr>" + "<tr>" + "<th>专业</th>" + "<td>"
			+ msg.major.majrName + "</td>" + "<th>班级</th>"
			+ "<td>" + msg.studentClass.className + "</td>"
			+ "<th>考生号</th>" + "<td>"
			+ msg.student.studKsh + "</td>" + "</tr>"
			"<tr>" + "<th>身份证</th>" + "<td>"
			+ msg.student.studIdnumber + "</td>" + "<th>入学时间</th>"
			+ "<td>" + msg.student.studAdmissiontime + "</td>"
			+ "<th>生日</th>" + "<td>"
			+ msg.student.studBirthday + "</td>" + "</tr>"
			$("#stuPersonal").empty().append(stuPersonal);
		  /*	父母信息*/
			var allPareTable = "";
			allPareTable += "<tr><th>姓名</th><th>身份</th><th>电话</th><th>职业</th><th>工作单位</th><th>与本人关系</th><th>身份证</th></tr>";
			$.each(msg.parents, function(key, val) {
				allPareTable += "<tr>" + "<td>" + val.pareName + "</td>" + "<td>" + val.pareRole + "</td>"
						+ "<td>" + val.parePhone + "</td>" + "<td>" + val.pareOccupation + "</td>" + "<td>"
						+ val.pareWork + "</td>" + "<td>" + val.pareRelation + "</td>" + "<td>"
						+ val.pareIdnumber + "</td>";
						allPareTable += "</tr>";
			});
			$("#stuParents").empty().append(allPareTable);
			
		
		/*	详细资料*/
			var stuDeatilInfo = "<tr>" + "<th>政治面貌</th>" + "<td>"
			+ msg.studentinfo.stinPoliticstate + "</td>"
			+ "<th>银行卡号</th>" + "<td>"
			+ msg.studentinfo.stinBanknumber + "</td>"
			+ "<th>性别</th>" + "<td>" + msg.studentinfo.stinSex
			+ "</td>" + "</tr>" + "<tr>" + "<th>电话号码</th>" + "<td>"
			+ msg.studentinfo.stinPhone + "</td>" + "<th>邮箱</th>"
			+ "<td>" + msg.studentinfo.stinEmail + "</td>"
			+ "<th>户口类型</th>" + "<td>"
			+ msg.studentinfo.stinResidence + "</td>" + "</tr>"
			+ "<tr>" + "<th>人口数量</th>" + "<td>"
			+ msg.studentinfo.stinPopulation + "</td>"
			+ "<th>家庭总收入</th>" + "<td>"
			+ msg.studentinfo.stinAllincomes + "</td>"
			+ "<th>收入来源</th>" + "<td>"
			+ msg.studentinfo.stinIncometype + "</td>" + "</tr>"
			+ "<tr>" + "<th>邮政编码</th>" + "<td>"
			+ msg.studentinfo.stinMailcode + "</td>"
			+ "<th>家庭详细地址</th>" + "<td>"
			+ msg.HomeAddress + "</td>"+"<th>系</th>"+"<td>"+msg.studentinfo.stinDepartment + "</td>"+ "</tr>" + "<tr>"
			+ "<th>QQ号码</th>" + "<td>" + msg.studentinfo.stinQq
			+ "</td>" + "<th>生源地详细地址</th>" + "<td colspan=\"3\">"
			+ msg.studentinfo.stinAreadetailorigin + "</td>"
			+ "</tr>";
	        $("#stuInfo").empty().append(stuDeatilInfo);
	        
	    	/*学习情况*/var Learinglist;
			Learinglist = "<thead>" + "<th>" + "&nbsp;&nbsp;学&nbsp;&nbsp;期" + "</th>" + "<th>" + "名次" + "</th>" + "<th>" + "通过课" + "<br>" + "的程数"
			+ "</th>" + "<th>" + "必修课" + "<br>" + "的程数" + "</th>" + "<th>" + "选修课" + "<br>" + "的程数" + "</th>" + "<th>"
			+ "总人数" + "</th>" + "<th>" + "是否综" + "<br>" + "合测评" + "</th>" + "<th>" + "综合测" + "<br>" + "评名次" + "</th>"
			+ "<th>" + "综合测" + "<br>" + "评人数" + "</th>"  + "</thead>";
			$.each(msg.allLearing, function(key, val) {
				var learComp = val.learComprehensive;
				var learComp_total = val.learComprehensivetotal;
				if(learComp == null && learComp_total == null){
					learComp = "—";
					learComp_total = "—";
				}
				Learinglist +="<tbody>";
				Learinglist += "<tr>" + "<td>" + val.learSemester + "</td>" + "<td>" + val.learRanking + "</td>"
						+ "<td>" + val.learPassnumber + "</td>" + "<td>" + val.learRequirednumber + "</td>"
						+ "<td>" + val.learSelectivesnumber + "</td>" + "<td>" + val.learTotalnumber + "</td>"
						+ "<td>&nbsp;&nbsp;&nbsp;" + val.learEvaluationtype + "</td>" + "<td>" + learComp + "</td>"
						+ "<td>" + learComp_total + "</td>" + "</tr>";
			});
			Learinglist +="</tbody>";
			$("#stuLearing").empty().append(Learinglist);
			
		/*	获奖情况*/
			var allPrizeTable="";
			allPrizeTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>获奖名称</th><th>获奖级别</th><th>颁奖单位</th><th>获奖时间</th><th>个人奖励</th><th>是否审核</th></tr></thead>";
			$.each(msg.prize,function(key,val){
				allPrizeTable +="<tr><td>"+
				msg.student.studName + "</td><td> " + 
				val.prizName +  "</td><td> " +
				val.prizLevel +  "</td><td> " +
				val.prizAwarded +  "</td><td> " +
				val.prizTime + "</td><td> ";
				 if(val.prizIsindividual==1)
				 {
				 	allPrizeTable+="是"+"</td><td>";
				 }else
				 {
				 allPrizeTable+="否"+"</td><td>";
				 }
				 if(val.prizState==1)
				 {
				 	allPrizeTable+="是"+"</td>";
				 }else
				 {
				 allPrizeTable+="否"+"</td>";
				 }
				 allPrizeTable+="</tr>" + "</tbody>";
			});
			$("#stuReward").empty().append(allPrizeTable);
			
		}
		else{
			alert("该学生的详细信息为空！");
		}
	},error : function(msg) {
		alert("网络超时！");
	}
});

}

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