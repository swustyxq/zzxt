$(document).ready(function (){
	var studNumber = "20112356";
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/studentController/obtainStudentByStudNumber.do',
		async : false,
		data : {
			studNumber:studNumber
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){				
				$("#stinDepartment").empty().append(msg.studentInfo.stinDepartment);
				$("#studNumber").empty().append(msg.student.studNumber);
				$("#studName").empty().append(msg.student.studName);
				$("#stinSex").empty().append(msg.studentInfo.stinSex);
				$("#studBirthday").empty().append(msg.student.studBirthday);
				$("#stinPoliticstate").empty().append(msg.studentInfo.stinPoliticstate);
				$("#studNation").empty().append(msg.student.studNation);				
				$("#studAdmissiontime").empty().append(msg.student.studAdmissiontime);					
				$("#majrName").empty().append(msg.major.majrName);
				$("#majrEducationsystem").empty().append(msg.major.majrEducationsystem);				
				$("#stinPhone").empty().append(msg.studentInfo.stinPhone);
				$("#studIdnumber").empty().append(msg.student.studIdnumber);	

			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	
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
				$("#gjxjAnnual").empty().append(msg.gjjxj.gjxjAnnual);	
				$("#gjxjRanking").empty().append(msg.gjjxj.gjxjRanking);	
				if(msg.gjjxj.gjxjComprehensive=="是"){
					document.getElementById("gjxjComprehensiveYes").checked = true;			
					$("#gjxjComprehensiveranking").empty().append(msg.gjjxj.gjxjComprehensiveranking);
				}
				if(msg.gjjxj.gjxjComprehensive=="否"){
					document.getElementById("gjxjComprehensiveNo").checked = true;
				}				
				$("#gjxjApplyreason").empty().append(msg.gjjxjWithBLOBS.gjxjApplyreason);							
				$("#gjxjRecommendreason").empty().append(msg.gjjxjWithBLOBS.gjxjRecommendreason);
				$("#gjxjAcademyopinion").empty().append(msg.gjjxjWithBLOBS.gjxjAcademyopinion);
				$("#gjxjSchoolopinion").empty().append(msg.gjjxjWithBLOBS.gjxjSchoolopinion);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	
	//此处查询可能还需要对学期进行限定。
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/learningController/obtainLearningByStudNumber.do',
		async : false,
		data : {
			studNumber:studNumber
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				//alert(msg.learning!= null);
				if(msg.learning!= null){
					$("#learPassnumber").empty().append(msg.learning.learPassnumber);	
					$("#learRequirednumber").empty().append(msg.learning.learRequirednumber);	
				}else{
					alert("暂时没有必修课信息");
				}
				
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
});