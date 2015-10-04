$(document).ready(function() {	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/qyshjxjController/showApplyQyshjxjTable.do',
		async : false,
		data : {
			studId:-1,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {				
				document.getElementById('qyshjxj_name').innerHTML=msg.student.studName;//姓名
				document.getElementById('qyshjxj_sex').innerHTML=msg.studentinfo.stinSex;//性别
				document.getElementById('qyshjxj_number').innerHTML=msg.student.studNumber;//学号
				document.getElementById('qyshjxj_politicState').innerHTML=msg.studentinfo.stinPoliticstate;//政治面貌
				document.getElementById('qyshjxj_institution').innerHTML=msg.institution.instName;//学院
				document.getElementById('qyshjxj_majorname').innerHTML=msg.major.majrName;//专业
				document.getElementById('qyshjxj_birthday').innerHTML=msg.student.studBirthday;//出生年月
	            document.getElementById('qyshjxj_instructor').innerHTML=msg.instuser.userName;//辅导员
				document.getElementById('qyshjxj_phone').innerHTML=msg.studentinfo.stinPhone;//联系电话
			  	document.getElementById('qyshjxj_E-mail').innerHTML=msg.studentinfo.stinEmail;//E-mail			
			}
		},error : function(msg) {
			alert("网络超时！");
		}
	});
});