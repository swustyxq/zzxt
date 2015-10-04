$(document).ready(function (){
		//showallprizInfo();
		$("#prizsubmit").click(function(){//提交学生奖励信息
		//检查时间是否超过当前时间
			var priz_name=$("#priz_name").val();
			var priz_level=$("#priz_level").val();
			var priz_awarded=$("#priz_awarded").val();
			var priz_time=$("#priz_time").val();
			var obj=document.getElementsByName("priz_isIndividual");
			var priz_isIndividual=-1;//默认为个人奖
			for(var i=0; i<obj.length; i ++){
	        if(obj[i].checked){
	        	priz_isIndividual=obj[i].value;
		        }
		    }
		    if(priz_name!=""&&priz_level!=""&&priz_awarded!=""&&priz_time!=""&&priz_isIndividual!=-1)
		    {
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/zzxt/prizeController/inputStuPrizInfo.do',
				async : false,
				data : {
					prizname:priz_name,
					prizlevel:priz_level,
					prizawarded:priz_awarded,
					priztime:priz_time,
					prizisIndividual:priz_isIndividual,
				},
				dataType : 'json',
				success : function(msg) {
					if(msg.result ==true){
						$('#addModal').modal('hide');//隐藏模态框
						showallprizInfo();//刷新信息
					}},error: function(msg){
				        alert("网络超时！");
					}
				});
			}else{
				alert("请完善所有信息！");
			}
		});
});
function onprizeNameCheck()//奖励信息验证
{
	if($("#priz_name").val()=="")
	{
		document.getElementById("priztip01").style.display="block";
	}else if($("#priz_name").val().length>100){
		document.getElementById("priztip02").style.display="block";
	}else{
		document.getElementById("priztip01").style.display="none";
		document.getElementById("priztip02").style.display="none";
	}
}
function onprizeNameClean()
{
	document.getElementById("priztip01").style.display="none";
	document.getElementById("priztip02").style.display="none";
}
function onprizeLevelCheck()
{
	if($("#priz_level").val()=="")
	{
		document.getElementById("priztip03").style.display="block";
	}else if($("#priz_level").val().length>100){
		document.getElementById("priztip04").style.display="block";
	}else{
		document.getElementById("priztip03").style.display="none";
		document.getElementById("priztip04").style.display="none";
	}
}
function onprizeLevelClean()
{
	document.getElementById("priztip03").style.display="none";
	document.getElementById("priztip04").style.display="none";
}
function onprizeAwardedCheck()
{
	if($("#priz_awarded").val()=="")
	{
		document.getElementById("priztip05").style.display="block";
	}else if($("#priz_awarded").val().length>100){
		document.getElementById("priztip06").style.display="block";
	}
	else{
		document.getElementById("priztip05").style.display="none";
		document.getElementById("priztip06").style.display="none";
	}
}
function onprizeAwardedClean()
{
	document.getElementById("priztip05").style.display="none";
	document.getElementById("priztip06").style.display="none";
}
function onprizeTimeCheck()
{
	if($("#priz_time").val()=="")
	{
		document.getElementById("priztip07").style.display="block";
	}else if($("#priz_time").val().length>100){
		document.getElementById("priztip08").style.display="block";
	}else{
		document.getElementById("priztip07").style.display="none";
		document.getElementById("priztip08").style.display="none";
	}
}
function onprizeTimeClean()
{
	document.getElementById("priztip07").style.display="none";
	document.getElementById("priztip08").style.display="none";
}
function OnPrizeEditCheck(cheakId){
	if(cheakId==1)
	{
		if($("#priz_name").val()=="")
		{
			document.getElementById("priztip11").style.display="block";
		}else if($("#priz_name").val().length>100){
			document.getElementById("priztip12").style.display="block";
		}else{
			document.getElementById("priztip11").style.display="none";
			document.getElementById("priztip12").style.display="none";
		}
	}else if(cheakId==3)
	{
		if($("#priz_name").val()=="")
		{
			document.getElementById("priztip13").style.display="block";
		}else if($("#priz_name").val().length>100){
			document.getElementById("priztip14").style.display="block";
		}else{
			document.getElementById("priztip13").style.display="none";
			document.getElementById("priztip14").style.display="none";
		}
	}else if(cheakId==5)
	{
		if($("#priz_name").val()=="")
		{
			document.getElementById("priztip15").style.display="block";
		}else if($("#priz_name").val().length>100){
			document.getElementById("priztip16").style.display="block";
		}else{
			document.getElementById("priztip15").style.display="none";
			document.getElementById("priztip16").style.display="none";
		}
	}else if(cheakId==2)
	{
	document.getElementById("priztip11").style.display="none";
	document.getElementById("priztip12").style.display="none";
	}else if(cheakId==4)
	{
	document.getElementById("priztip13").style.display="none";
	document.getElementById("priztip14").style.display="none";
	}else if(cheakId==6)
	{
	document.getElementById("priztip15").style.display="none";
	document.getElementById("priztip16").style.display="none";
	}
}
function showallprizInfo()//获取该学生获奖信息
{
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/prizeController/showAllStuPrizInfo.do',
			async : false,
			data : {
			},
			dataType : 'json',
			success : function(msg) {
				
				document.getElementById('Uname').innerHTML=msg.student.studName;
				if(msg.result ==true){
				var allPrizeTable="";
				allPrizeTable +="<thead><tr><th>序&nbsp;&nbsp;&nbsp;号</th><th>获奖名称</th><th>获奖级别</th><th>颁奖单位</th><th>获奖时间</th><th>个人奖励</th><th align=\"center\">操作</th></tr></thead>";
				var a=1;
				$.each(msg.firstPrizeList,function(key,val){
					
						allPrizeTable +="<tr><td align=\"center\">"+
						(a++) + "</td><td> " + 
						val.prizName +  "</td><td> " +
						val.prizLevel +  "</td><td> " +
						val.prizAwarded +  "</td><td> " +
						val.prizTime + "</td><td align=\"center\"> ";
						 if(val.prizIsindividual==1)
						 {
						 	allPrizeTable+="是"+"</td>";
						 }else
						 {
						 allPrizeTable+="否"+"</td>";
						 }
						/* if(val.prizState==1)
						 {
						 	allPrizeTable+="是"+"</td>";
						 }else
						 {
						 allPrizeTable+="否"+"</td>";
						 }*/
						 allPrizeTable+="<td>"
						 + "<a href=\"javascript:editUser("
						 + val.prizId
						 + ")\">" + "<button type='button' class='btn btn-warning btn-xs'>修改</button></a>"
						 + "&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:deleteUser("
						 + val.prizId
						 + ")\">" + "<button type='button' class='btn btn-danger btn-xs'>删除</button></a>" 
						 + "</td>" + "</tr>" + "</tbody>";
						// alert(val.prizIseditable);
						 if(val.prizIseditable==0){
								$("#Reward :input").attr("disabled",true);
							    }
						 });
				$("#HasWonAward").empty().append(allPrizeTable);
				$("#demo5").paginate({
					count 		: msg.pageCount,
					start 		: 1,
					display     : 10,
					border					: true,
					border_color			: '#fff',
					text_color  			: '#fff',
					background_color    	: 'rgb(66,139,202)',
					border_hover_color		: '#ccc',
					text_hover_color  		: '#000',
					background_hover_color	: '#fff', 
					images					: false,
					mouse					: 'press',
					onChange     			: function(page){
												//alert(page);
												$.ajax({
													type : "post",
													contentType : "application/x-www-form-urlencoded;charset=UTF-8",
													url : '/zzxt/prizeController/showOnePageStuPrizInfo.do',
													async : false,
													data : {
														page:page
													},
													dataType : 'json',
													success : function(msg) {
														if(msg.result == true){
														allPrizeTable="";
														document.getElementById('Uname').innerHTML=msg.student.studName;
														allPrizeTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>获奖名称</th><th>获奖级别</th><th>颁奖单位</th><th>获奖时间</th><th>个人奖励</th><th>操作</th></tr></thead>";
														$.each(msg.pagePrizeList,function(key,val){
																allPrizeTable +="<tr><td>"+
																msg.student.studName + "</td><td> " + 
																val.prizName +  "</td><td> " +
																val.prizLevel +  "</td><td> " +
																val.prizAwarded +  "</td><td> " +
																val.prizTime + "</td><td> ";
																 if(val.prizIsindividual==1)
																 {
																 	allPrizeTable+="是"+"</td>";
																 }else
																 {
																 allPrizeTable+="否"+"</td>";
																 }
																 allPrizeTable+="<td>"
																 + "<a href=\"javascript:editUser("
																 + val.prizId
																 + ")\">编辑" + "</a>"
																 + "<a href=\"javascript:deleteUser("
																 + val.prizId
																 + ")\">删除" + "</a>" 
																 + "</td>" + "</tr>" + "</tbody>";
														});
														$("#HasWonAward").empty().append(allPrizeTable);
														}else{
															
														}
													},error: function(msg){
												        alert("网络超时！");
													}
												});
					}
				});
				}else{
					var allPrizeTable="";
					allPrizeTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>获奖名称</th><th>获奖级别</th><th>颁奖单位</th><th>获奖时间</th><th>个人奖励</th><th>是否审核</th><th>操作</th></tr></thead>";
					$("#HasWonAward").empty().append(allPrizeTable);
				}
				},error: function(msg){
			        alert("网络超时！wrong");
				}
		});
};
function sureDeletePrize(prizId)
{
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/prizeController/deletePrizInfo.do',
			async : false,
			data : {
				prizId:prizId
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					
				} else {
					alert("删除失败");
				}
				showallprizInfo();//重新从数据库中导入奖励数据
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
}
//删除一条奖励信息
function deleteUser(prizId) {
	//$("#isDelete").click();//提示是否删除
	$('#myDeleteModal').modal('show');
	var B_id ="javascript:sureDeletePrize("
	+ prizId 
	+ ")";
	$(".surePrizDelete").attr("onclick",B_id);
	/*$("#sureDelete").click(function(){
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/prizeController/deletePrizInfo.do',
			async : false,
			data : {
				prizId:prizId
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					//alert("删除成功");
					//location.reload(true);
					//data-dismiss="modal"
					//window.location.reload();
					//window.name = "__self"; 
            		//window.open(window.location.href, "__self");
            		showallprizInfo();//重新从数据库中导入奖励数据
            		
				} else {
					alert("删除失败");
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	});*/
};
function surePrizeEdit(prizId)
{
		var prizName = $("#priz_name1").val();
		var prizLevel = $("#priz_level1").val();
		var prizAwarded = $("#priz_awarded1").val();
		var prizTime = $("#priz_time1").val();
		var obj=document.getElementsByName("priz_isIndividual1");
		var prizIsIndividual=-1;//默认为个人奖
		for(var i=0; i<obj.length; i ++){
        if(obj[i].checked){
        	prizIsIndividual=obj[i].value;
	        }
	    }
	     if(prizName!=""&&prizLevel!=""&&prizAwarded!=""&&prizTime!=""&&prizIsIndividual!=-1)
		    {
				$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					url : '/zzxt/prizeController/editPrizeInfo.do',
					async : false,
					data : {
						prizId:prizId,
						prizName:prizName,
						prizLevel:prizLevel,
						prizAwarded:prizAwarded,
						prizTime:prizTime,
						prizIsIndividual:prizIsIndividual,
					},
					dataType : 'json',
					success : function(msg) {
							$('#myEditPrizeModal').modal('hide');
							showallprizInfo();
					},
					error : function(msg) {
						alert("网络超时！");
					}
				});
			}else{
				alert("请完善所有信息！");
				$('#myEditPrizeModal').modal('show');
			}
}
//修改一条奖励信息
function editUser(prizId) {
		/*$("#myEditPrizeModal").on("hidden.bs.modal", function() {
		    $(this).removeData("bs.modal");
		});*/
		var B_id ="javascript:surePrizeEdit("
		+ prizId 
		+ ")";
		$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					url : '/zzxt/prizeController/findOnePrizInfo.do',
					async : false,
					data : {
						prizId:prizId
					},
					dataType : 'json',
					success : function(msg) {
						if (msg.result == true) {
							document.getElementById('Uname2').innerHTML=msg.student.studName;
							//在input框显示奖励信息
							$("#priz_name1").val(msg.prize.prizName);
							$("#priz_level1").val(msg.prize.prizLevel);
							$("#priz_awarded1").val(msg.prize.prizAwarded);
							$("#priz_time1").val(msg.prize.prizTime);
							//$("#priz_isIndividual1").val(msg.prize.prizIsIndividual);
							var obj=document.getElementsByName("priz_isIndividual1");
							for(var i=0; i<obj.length; i++) {  
		           				obj[i].checked = false; 
		        			}  
		        			if(msg.prize.prizIsindividual=="1") { 
		           				obj[0].checked = "checked";
		           			}else
		           			{
		           				obj[1].checked = "checked";
		           			}
							$('#myEditPrizeModal').modal('show');
						} else {
							alert("获取信息失败");
						}
					},
					error : function(msg) {
						alert("网络超时！");
						flag = false;
					}
				});
				$(".sureEditPrize").attr("onclick",B_id);
	/*$("#sureEditPrize").click(function(){//确定修改
		//$("#myDeleteModal").hide();
		var prizName = $("#priz_name1").val();
		var prizLevel = $("#priz_level1").val();
		var prizAwarded = $("#priz_awarded1").val();
		var prizTime = $("#priz_time1").val();
		var obj=document.getElementsByName("priz_isIndividual1");
		var prizIsIndividual=1;//默认为个人奖
		for(var i=0; i<obj.length; i ++){
        if(obj[i].checked){
        	prizIsIndividual=obj[i].value;
	        }
	    }
	     if(priz_name!=""&&priz_level!=""&&priz_awarded!=""&&priz_time!=""&&priz_isIndividual!=-1)
		    {
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/prizeController/editPrizeInfo.do',
			async : false,
			data : {
				prizId:prizId,
				prizName:prizName,
				prizLevel:prizLevel,
				prizAwarded:prizAwarded,
				prizTime:prizTime,
				prizIsIndividual:prizIsIndividual,
			},
			dataType : 'json',
			success : function(msg) {
					$('#myEditPrizeModal').modal('hide');
					alert("hhhhhhhhhhh");
					showallprizInfo();
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	});*/
};
//获取一条奖励信息并显示
function findOnePrizeInfoAndShow(prizId)
{
		$("#myEditPrizeModal").on("hidden.bs.modal", function() {
		    $(this).removeData("bs.modal");
		});
	var flag=false;
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/prizeController/findOnePrizInfo.do',
			async : false,
			data : {
				prizId:prizId
			},
			dataType : 'json',
			success : function(msg) {
				document.getElementById('Uname2').innerHTML=msg.student.studName;
				if (msg.result == true) {
					//在input框显示奖励信息
					$("#priz_name1").val(msg.prize.prizName);
					$("#priz_level1").val(msg.prize.prizLevel);
					$("#priz_awarded1").val(msg.prize.prizAwarded);
					$("#priz_time1").val(msg.prize.prizTime);
					//$("#priz_isIndividual1").val(msg.prize.prizIsIndividual);
					var obj=document.getElementsByName("priz_isIndividual1");
					
					for(var i=0; i<obj.length; i++) {  
           				obj[i].checked = false; 
        			}  
        			if(msg.prize.prizIsindividual=="1") { 
           				obj[0].checked = "checked";
           			}else
           			{
           				obj[1].checked = "checked";
           			}
					$('#myEditPrizeModal').modal('show');
					flag = true;
				} else {
					alert("获取信息失败");
					flag = false;
				}
			},
			error : function(msg) {
				alert("网络超时！");
				flag = false;
			}
		});
		return flag;
}
function deletebyid(prizId)
{
//$("#myDeleteModal").hide();
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/prizeController/deletePrizInfo.do',
			async : false,
			data : {
				prizId:prizId
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					//alert("删除成功");
					//location.reload(true);
					//data-dismiss="modal"
					//window.location.reload();
					//window.name = "__self"; 
            		//window.open(window.location.href, "__self");
            		showallprizInfo();//重新从数据库中导入奖励数据
            		
				} else {
					alert("删除失败");
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
}
function isDigit(str) //验证汉字，暂未用到
{ 

 var reg = /^[\u4e00-\u9fa5]+$/i; 
 if (!reg.test(str)) 
 {
  //alert("请输入中文名字！"); 
  //document.regFrm.user.focus(); 
  return false; 
  }
  return true;

}