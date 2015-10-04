$(document).ready(function (){
	//alert("666666");
	var studNumber = "20121234";
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
				//alert(msg.student.studNumber+"++"+msg.studentName);				
//				$("#stinDepartment").val(msg.studentInfo.stinDepartment);
				$("#studNumber").val(msg.student.studNumber);
				$("#studName").val(msg.student.studName);
//				$("#stinSex").val(msg.studentInfo.stinSex);
				$("#studBirthday").val(msg.student.studBirthday);
//				$("#stinPoliticstate").val(msg.studentInfo.stinPoliticstate);
				$("#studNation").val(msg.student.studNation);				
				$("#studAdmissiontime").val(msg.student.studAdmissiontime);					
				$("#majrName").val(msg.major.majrName);
				$("#majrEducationsystem").val(msg.major.majrEducationsystem);				
//				$("#stinPhone").val(msg.studentInfo.stinPhone);
				$("#studIdnumber").val(msg.student.studIdnumber);			
				

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
				$("#gjxjAnnual").val(msg.gjjxj.gjxjAnnual);	
				$("#gjxjRanking").val(msg.gjjxj.gjxjRanking);	
				if(msg.gjjxj.gjxjComprehensive=="是"){
					document.getElementById("gjxjComprehensiveYes").checked = true;			
					$("#gjxjComprehensiveranking").val(msg.gjjxj.gjxjComprehensiveranking);
				}
				if(msg.gjjxj.gjxjComprehensive=="否"){
					document.getElementById("gjxjComprehensiveNo").checked = true;
				}				
				//此处没有成功
				$("#gjxjApplyreason").val(msg.gjjxjWithBLOBS.gjxjApplyreason);							
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