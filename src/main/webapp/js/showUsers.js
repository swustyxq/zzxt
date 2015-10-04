var role;//存所有的角色
var reuserrole;//存当前角色的role
$(document).ready(function (){
	
	showAllUserInfo();
	$("#usersubmit").click(function(){
	var userName = $("#user_name11").val();
	var userInstid; 

	userInstid=instname($("#college_name11").val());

	var userLoginname = $("#user_loginname11").val();
	var userPassword = $("#user_password11").val();
	var userType;

		userType=typename($("#user_type11").val());

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/addUserInfo.do',
		async : false,
		data : {
			
			userName:userName,
			userInstid:userInstid,
			userLoginname:userLoginname,
			userPassword:userPassword,
			userType:userType,
			
		},
		dataType : 'json',
		success : function(msg) {
			
				alert("添加成功！");
				$('#addModal').modal('hide');//隐藏模态框				
				showAllUserInfo();//刷新信息
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
	$("#user_name11").val("");
	$("#user_loginname11").val("");
	$("#user_password11").val("");
	
	});
	
	$("#check").click(function(){    //筛选
		
		var userInstId=$("#userInst").val();
		var userType=$("#userType").val();
		
		if(userInstId=="所有"&&userType!="所有")
			{
			  checkuserType();
			}
		 if(userType=="所有"&&userInstId!="所有")
			{
			
			  checkuserInst();
			}
		 if(userType=="所有"&&userInstId=="所有"){
			showAllUserInfo();
		}
		 if(userType!="所有"&&userInstId!="所有")
			{
			 checkuserInstAndType();
			}
		
	});
	
	$("#check1").click(function(){  //精确查找
		
		checkuserLoginnameOrName();
		
	});
});
function showAllUserInfo()//获取所有用户信息
{
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/userController/showAllUser.do',
			async : false,
			data : {
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){
					role = msg.role;
				var allUserTable="";
				
				allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
				$.each(msg.firstUserList,function(key,val){
					    allUserTable +="<tr><td>"+
						val.userName + "</td><td> " ;
					   
					   allUserTable +=instid(val.userInstid)+"</td><td>";
					  
					    allUserTable += val.userLoginname +  "</td><td> " +
						                val.userPassword +  "</td><td> " ;	
					    
						allUserTable +=type(val.userType)+"</td><td>";
						 					  
						   if(val.userLastlogintime!=null)             

						{  
						  var time1=time(val.userLastlogintime);																   
						   allUserTable += time1 +  "</td> " ;

						}                
						   else
							   {
							   allUserTable +=" "+"</td> ";
							   }
						 allUserTable+="<td>"
						 + "<a href=\"javascript:editUser("
						 + val.userId
						 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
						 +"</td><td>"
						 + "<a href=\"javascript:deleteUser("
						 + val.userId
						 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
						 +"</td><td>"
						 +"<button type='button' class='btn btn-success btn-xs'" +
						 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
						 + "</td>" + "</tr>" + "</tbody>";
				});
				$("#showAllUsers").empty().append(allUserTable);
				$("#demo5").paginate({
					count 		: msg.pageCount,
					start 		: 1,
					display     : 50,
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
						
												$.ajax({
													type : "post",
													contentType : "application/x-www-form-urlencoded;charset=UTF-8",
													url : '/zzxt/userController/showOnePageUserInfo.do',
													async : false,
													data : {
														page:page
													},
													dataType : 'json',
													success : function(msg) {
														if(msg.result == true){
															allUserTable="";
														
															allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
														$.each(msg.pageUserList,function(key,val){
															 allUserTable +="<tr><td>"+
																val.userName + "</td><td> " ;
															   
																allUserTable+=instid(val.userInstid)+"</td><td>";
																 															 
															    allUserTable += val.userLoginname +  "</td><td> " +
																                val.userPassword +  "</td><td> " ;
															   
																	 allUserTable+=type(val.userType)+"</td><td>";
																 
															    
																   if(val.userLastlogintime!=null)             
																{
	                                                                   var time1=time(val.userLastlogintime);																   
																	   allUserTable += time1 +  "</td> " ;
											
																}                
																   else
																	   {
																	   allUserTable +=" "+"</td> ";
																	   }
																 allUserTable+="<td>"
																 + "<a href=\"javascript:editUser("
																 + val.userId
																 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
																 +"</td><td>"
																 + "<a href=\"javascript:deleteUser("
																 + val.userId
																 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
																 +"</td><td>"
																 +"<button type='button' class='btn btn-success btn-xs'" +
																 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
																 + "</td>" + "</tr>" + "</tbody>";
														});
														$("#showAllUsers").empty().append(allUserTable);
														}else{
															alert(msg.message);
														}
													},error: function(msg){
												        alert("网络超时！");
													}
												});
					}
				});
				}else{
					alert(msg.message);
				}
				},error: function(msg){
			        alert("网络超时！");
				}
		});		
};
function editRole(userId){
	findroleByuserId(userId);
	var id = userId-2;
	$("#myModalLabel").text($("#titel"+id).text());
	var table = "<table class='table table-hover'><thead><tr><th width='100px'>#</th><th width='100px'>选择</th><th width='300px'>角色</th></tr>";
	$.each(role,function(key,val){
		table += "<tr><td>"+(key+1)+"</td><td><input type='checkbox'name='checkbox'id='ch+"+userId+"'value='"+val.roleId+"'/></td><td>"+val.roleName+"</td></tr>";	
	});
	table += "</table>";
	$("#rolelist").empty().append(table);
	//alert(table);
	$("#changeJb").modal('show');
	$.each(reuserrole,function(key,val){
		var ob = document.getElementsByName("checkbox");
		for(var i=0; i<ob.length; i ++){
			if(ob[i].value == val.reurRoleid){
				ob[i].checked="checked";
				//alert(ob[i].value+"hhh"+val.reurRoleid);
				
			}
			
		}
	});
	
	
}
function findroleByuserId(userId){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/findroleByuserId.do',
		async : false,
		data : {
			userId:userId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
        		reuserrole = msg.role;
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});
}
//删除一条用户信息
function suredeleteUser(userId) {
	
	
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/userController/deleteUserInfo.do',
			async : false,
			data : {
				userId:userId
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					alert("删除成功");					
					showAllUserInfo();//重新从数据库中导入奖励数据
            		
				} else {
					alert("删除失败");
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	
};
function deleteUser(userId) {
	
	$('#myDeleteModal').modal('show');
	var B_id ="javascript:suredeleteUser("
	+ userId 
	+ ")";
	$(".sureUserDelete").attr("onclick",B_id);
	
};
//修改一条用户信息
function editUser(userId) {	
	var B_id ="javascript:sureEditUser("
		+ userId 
		+ ")";
		$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					url : '/zzxt/userController/findOneUserInfo.do',
					async : false,
					data : {
						userId:userId
					},
					dataType : 'json',
					success : function(msg) {
						if (msg.result == true) {
							//在input显示框用户信息
							$("#user_name1").val(msg.user.userName);
							
							$("#college_name1").val(instid(msg.user.userInstid));
							 						    							
							$("#user_loginname1").val(msg.user.userLoginname);
							$("#user_password1").val(msg.user.userPassword);
							
							$("#user_type1").val(type(msg.user.userType));
								 							 						      												
							$('#myEditUserModal').modal('show');
						} else {
							alert("获取信息失败");
						}
					},
					error : function(msg) {
						alert("网络超时！");
						flag = false;
					}
				});
		$(".sureEditUserInfo").attr("onclick",B_id);
}
function  sureEditUser(userId) {	
	//确定修改
		
		var userName = $("#user_name1").val();
		var userInstid; 
			      
		userInstid=instname($("#college_name1").val());
		var userLoginname = $("#user_loginname1").val();
		var userPassword = $("#user_password1").val();
		var userType;
	
		userType=typename($("#user_type1").val());
	
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/userController/editUserInfo.do',
			async : false,
			data : {
				userId:userId,
				userName:userName,
				userInstid:userInstid,
				userLoginname:userLoginname,
				userPassword:userPassword,
				userType:userType,
				
			},
			dataType : 'json',
			success : function(msg) {
				    alert("修改成功！");
					$('#myEditUserModal').modal('hide');					
					showAllUserInfo();
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	
};
//添加用户信息验证
function onuserNameCheck()
{
	if($("#user_name11").val()=="")
	{
		document.getElementById("usertip011").style.display="block";
	}else if($("#user_name11").val().length>20){
		document.getElementById("usertip012").style.display="block";
	}else{
		document.getElementById("usertip011").style.display="none";
		document.getElementById("usertip012").style.display="none";
	}
}
function onuserNameClean()
{
	document.getElementById("usertip011").style.display="none";
	document.getElementById("usertip012").style.display="none";
}

function onloginNameCheck()
{
	if($("#user_loginname11").val()=="")
	{
		document.getElementById("usertip013").style.display="block";
	}else if($("#user_loginname11").val().length>20){
		document.getElementById("usertip014").style.display="block";
	}
	else{
		document.getElementById("usertip013").style.display="none";
		document.getElementById("usertip014").style.display="none";
	}
}
function onloginNameClean()
{
	document.getElementById("usertip013").style.display="none";
	document.getElementById("usertip014").style.display="none";
}
function onpasswordCheck()
{
	if($("#user_password11").val()=="")
	{
		document.getElementById("usertip015").style.display="block";
	}else if($("#user_password11").val().length>20){
		document.getElementById("usertip016").style.display="block";
	}else{
		document.getElementById("usertip015").style.display="none";
		document.getElementById("usertip016").style.display="none";
	}
}
function onpasswordClean()
{
	document.getElementById("usertip015").style.display="none";
	document.getElementById("usertip016").style.display="none";
}



//修改用户信息验证
function onuserNameCheck1()
{
	if($("#user_name1").val()=="")
	{
		document.getElementById("usertip01").style.display="block";
	}else if($("#user_name1").val().length>20){
		document.getElementById("usertip02").style.display="block";
	}else{
		document.getElementById("usertip01").style.display="none";
		document.getElementById("usertip02").style.display="none";
	}
}
function onuserNameClean1()
{
	document.getElementById("usertip01").style.display="none";
	document.getElementById("usertip02").style.display="none";
}

function onloginNameCheck1()
{
	if($("#user_loginname1").val()=="")
	{
		document.getElementById("usertip03").style.display="block";
	}else if($("#user_loginname1").val().length>20){
		document.getElementById("usertip04").style.display="block";
	}
	else{
		document.getElementById("usertip03").style.display="none";
		document.getElementById("usertip04").style.display="none";
	}
}
function onloginNameClean1()
{
	document.getElementById("usertip03").style.display="none";
	document.getElementById("usertip04").style.display="none";
}
function onpasswordCheck1()
{
	if($("#user_password1").val()=="")
	{
		document.getElementById("usertip05").style.display="block";
	}else if($("#user_password1").val().length>20){
		document.getElementById("usertip06").style.display="block";
	}else{
		document.getElementById("usertip05").style.display="none";
		document.getElementById("usertip06").style.display="none";
	}
}
function onpasswordClean1()
{
	document.getElementById("usertip05").style.display="none";
	document.getElementById("usertip06").style.display="none";
}
function checkuserInst(){
	var userInstid;
	
	userInstid=instname($("#userInst").val());
	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/showAllUserInst.do',
		async : false,
		data : {
			userInstid:userInstid
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
			var allUserTable="";
			
			allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
			$.each(msg.firstUserList,function(key,val){
				    allUserTable +="<tr><td>"+
					val.userName + "</td><td> " ;
				   
				    allUserTable +=instid(val.userInstid)+"</td><td>";  
				    
				    allUserTable += val.userLoginname +  "</td><td> " +
					                val.userPassword +  "</td><td> " ;
				  
				    allUserTable +=type(val.userType)+"</td><td>";
				    	
					   if(val.userLastlogintime!=null)             
					{      
                           var time1=time(val.userLastlogintime);																   
						   allUserTable += time1 +  "</td> " ;
					}             
					   else
						   {
						   allUserTable +=" "+"</td> ";
						   }
					   allUserTable+="<td>"
							 + "<a href=\"javascript:editUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
							 +"</td><td>"
							 + "<a href=\"javascript:deleteUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
							 +"</td><td>"
							 +"<button type='button' class='btn btn-success btn-xs'" +
							 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
							 + "</td>" + "</tr>" + "</tbody>";
			});
			$("#showAllUsers").empty().append(allUserTable);
			$("#demo5").paginate({
				count 		: msg.pageCount,
				start 		: 1,
				display     : 50,
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
					
											$.ajax({
												type : "post",
												contentType : "application/x-www-form-urlencoded;charset=UTF-8",
												url : '/zzxt/userController/showOnePageUserInst.do',
												async : false,
												data : {
													page:page,
													userInstid:userInstid
												},
												dataType : 'json',
												success : function(msg) {
													if(msg.result == true){
														allUserTable="";
													
														allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
													$.each(msg.pageUserList,function(key,val){
														 allUserTable +="<tr><td>"+
															val.userName + "</td><td> " ;
														   
														    allUserTable +=instid(val.userInstid)+"</td><td>";
														    
														    allUserTable += val.userLoginname +  "</td><td> " +
															                val.userPassword +  "</td><td> " ;
														    
														       allUserTable +=type(val.userType)+"</td><td>";
														       
															   if(val.userLastlogintime!=null)             
															{
                                                                   var time1=time(val.userLastlogintime);																   
																   allUserTable += time1 +  "</td> " ;
															}                
															   else
																   {
																   allUserTable +=" "+"</td> ";
																   }
															   allUserTable+="<td>"
																	 + "<a href=\"javascript:editUser("
																	 + val.userId
																	 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
																	 +"</td><td>"
																	 + "<a href=\"javascript:deleteUser("
																	 + val.userId
																	 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
																	 +"</td><td>"
																	 +"<button type='button' class='btn btn-success btn-xs'" +
																	 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
																	 + "</td>" + "</tr>" + "</tbody>";
													});
													$("#showAllUsers").empty().append(allUserTable);
													}else{
														alert(msg.message);
													}
												},error: function(msg){
											        alert("网络超时！");
												}
											});
				}
			});
			}else{
				alert(msg.message);
			}
			},error: function(msg){
		        alert("网络超时！");
			}
	});		
	
}
function checkuserType(){
	var userType;
	
	userType=typename($("#userType").val());

	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/showAllUserType.do',
		async : false,
		data : {
			userType:userType
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
			var allUserTable="";
			
			allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
			$.each(msg.firstUserList,function(key,val){
				    allUserTable +="<tr><td>"+
					val.userName + "</td><td> " ;
				   
				    allUserTable +=instid(val.userInstid)+"</td><td>";
				    	
				    allUserTable += val.userLoginname +  "</td><td> " +
					                val.userPassword +  "</td><td> " ;
				   
				    allUserTable+=type(val.userType)+"</td><td>";
				    
					   if(val.userLastlogintime!=null)             
					{
						   							 				
                           var time1=time(val.userLastlogintime);																   
						   allUserTable += time1 +  "</td> " ;
					}                
					   else
						   {
						   allUserTable +=" "+"</td> ";
						   }
					   allUserTable+="<td>"
							 + "<a href=\"javascript:editUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
							 +"</td><td>"
							 + "<a href=\"javascript:deleteUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
							 +"</td><td>"
							 +"<button type='button' class='btn btn-success btn-xs'" +
							 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
							 + "</td>" + "</tr>" + "</tbody>";
			});
			$("#showAllUsers").empty().append(allUserTable);
			$("#demo5").paginate({
				count 		: msg.pageCount,
				start 		: 1,
				display     : 50,
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
					
											$.ajax({
												type : "post",
												contentType : "application/x-www-form-urlencoded;charset=UTF-8",
												url : '/zzxt/userController/showOnePageUserType.do',
												async : false,
												data : {
													page:page,
													userType:userType
												},
												dataType : 'json',
												success : function(msg) {
													if(msg.result == true){
														allUserTable="";
													
														allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
													$.each(msg.pageUserList,function(key,val){
														 allUserTable +="<tr><td>"+
															val.userName + "</td><td> " ;
														  
														    allUserTable +=instid(val.userInstid)+"</td><td>";
														    
														    allUserTable += val.userLoginname +  "</td><td> " +
															                val.userPassword +  "</td><td> " ;
														   
														    allUserTable +=type(val.userType)+"</td><td>";
														    
															   if(val.userLastlogintime!=null)             
															{
                                                                   var time1=time(val.userLastlogintime);																   
																   allUserTable += time1 +  "</td> " ;
																 										
															}                
															   else
																   {
																   allUserTable +=" "+"</td> ";
																   }
															   allUserTable+="<td>"
																	 + "<a href=\"javascript:editUser("
																	 + val.userId
																	 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
																	 +"</td><td>"
																	 + "<a href=\"javascript:deleteUser("
																	 + val.userId
																	 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
																	 +"</td><td>"
																	 +"<button type='button' class='btn btn-success btn-xs'" +
																	 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
																	 + "</td>" + "</tr>" + "</tbody>";
													});
													$("#showAllUsers").empty().append(allUserTable);
													}else{
														alert(msg.message);
													}
												},error: function(msg){
											        alert("网络超时！");
												}
											});
				}
			});
			}else{
				alert(msg.message);
			}
			},error: function(msg){
		        alert("网络超时！");
			}
	});		
	
}
function checkuserInstAndType(){
	
	var userType;
	
	userType=typename($("#userType").val());
	
	var userInstid;
	
	userInstid = instname($("#userInst").val());
	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/showAllUserInstAndType.do',
		async : false,
		data : {
			userInstid:userInstid,
			userType:userType
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
			var allUserTable="";
			
			allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
			$.each(msg.firstUserList,function(key,val){
				    allUserTable +="<tr><td>"+
					val.userName + "</td><td> " ;
				   
				    allUserTable += instid(val.userInstid)+"</td><td>";
				    
				    allUserTable += val.userLoginname +  "</td><td> " +
					                val.userPassword +  "</td><td> " ;
				   
				    allUserTable +=type(val.userType)+"</td><td>";
				    
					   if(val.userLastlogintime!=null)             
					{
						   var time1=time(val.userLastlogintime);
						   
						   allUserTable += time1 +  "</td> " ;
					}                
					   else
						   {
						   allUserTable +=" "+"</td> ";
						   }
					   allUserTable+="<td>"
							 + "<a href=\"javascript:editUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
							 +"</td><td>"
							 + "<a href=\"javascript:deleteUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
							 +"</td><td>"
							 +"<button type='button' class='btn btn-success btn-xs'" +
							 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
							 + "</td>" + "</tr>" + "</tbody>";
			});
			$("#showAllUsers").empty().append(allUserTable);
			$("#demo5").paginate({
				count 		: msg.pageCount,
				start 		: 1,
				display     : 50,
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
					
											$.ajax({
												type : "post",
												contentType : "application/x-www-form-urlencoded;charset=UTF-8",
												url : '/zzxt/userController/showOnePageUserInstAndType.do',
												async : false,
												data : {
													page:page,
													userInstid:userInstid,
													userType:userType
												},
												dataType : 'json',
												success : function(msg) {
													if(msg.result == true){
														allUserTable="";
													
														allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
													$.each(msg.pageUserList,function(key,val){
														 allUserTable +="<tr><td>"+
															val.userName + "</td><td> " ;
														   
														    allUserTable +=instid(val.userInstid)+"</td><td>";
														    
														    allUserTable += val.userLoginname +  "</td><td> " +
															                val.userPassword +  "</td><td> " ;
														   
														    allUserTable +=type(val.userType)+"</td><td>";
														    
															   if(val.userLastlogintime!=null)             
															{
																   var time1=time(val.userLastlogintime);
																   
																   allUserTable += time1 +  "</td> " ;
																 
										
															}                
															   else
																   {
																   allUserTable +=" "+"</td> ";
																   }
															   allUserTable+="<td>"
																	 + "<a href=\"javascript:editUser("
																	 + val.userId
																	 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
																	 +"</td><td>"
																	 + "<a href=\"javascript:deleteUser("
																	 + val.userId
																	 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
																	 +"</td><td>"
																	 +"<button type='button' class='btn btn-success btn-xs'" +
																	 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
																	 + "</td>" + "</tr>" + "</tbody>";
													});
													$("#showAllUsers").empty().append(allUserTable);
													}else{
														alert(msg.message);
													}
												},error: function(msg){
											        alert("网络超时！");
												}
											});
				}
			});
			}else{
				alert(msg.message);
			}
			},error: function(msg){
		        alert("网络超时！");
			}
	});		
	
	
}
function checkuserLoginnameOrName(){
	var userLoginnameOrName=$("#loginnameOrname").val();
	if(userLoginnameOrName!=""){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/userController/checkUserInfo.do',
		async : false,
		data : {
			userLoginnameOrName:userLoginnameOrName
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
			var allUserTable="";
			
			allUserTable +="<thead><tr><th>姓&nbsp;&nbsp;&nbsp;名</th><th>学&nbsp;&nbsp;&nbsp;院</th><th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th><th>用&nbsp;户&nbsp;密&nbsp;码</th><th>用&nbsp;户&nbsp;类&nbsp;型</th><th>最后登录时间</th><th>修改</th><th>删除</th><th>设置</th></tr></thead>";
			$.each(msg.user1,function(key,val){
				    allUserTable +="<tr><td>"+
					val.userName + "</td><td> " ;
				    allUserTable +=instid(val.userInstid)+"</td><td>";
				    
				    allUserTable += val.userLoginname +  "</td><td> " +
					                val.userPassword +  "</td><td> " ;
				 
				    allUserTable +=type(val.userType)+"</td><td>";
				    
					   if(val.userLastlogintime!=null)             
					{
						   var time1=time(val.userLastlogintime);
						   
						   allUserTable += time1 +  "</td> " ;
					}                
					   else
						   {
						   allUserTable +=" "+"</td> ";
						   }
					   allUserTable+="<td>"
							 + "<a href=\"javascript:editUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-warning btn-xs'>修改</button>" + "</a>"
							 +"</td><td>"
							 + "<a href=\"javascript:deleteUser("
							 + val.userId
							 + ")\"><button type='button' class='btn btn-danger btn-xs'>删除</button>" + "</a>" 
							 +"</td><td>"
							 +"<button type='button' class='btn btn-success btn-xs'" +
							 	"data-toggle='modal' data-target='#myModal'onclick='editRole("+val.userId+")'>角色设置</button></a>"
							 + "</td>" + "</tr>" + "</tbody>";
			});
			$("#showAllUsers").empty().append(allUserTable);
			
			$("#demo5").paginate({
				count 		: 1,
				start 		: 1,
				display     : 50,
				border					: true,
				border_color			: '#fff',
				text_color  			: '#fff',
				background_color    	: 'rgb(66,139,202)',
				border_hover_color		: '#ccc',
				text_hover_color  		: '#000',
				background_hover_color	: '#fff', 
				images					: false,
				mouse					: 'press',
				
													
												
				});	
			}else{
				alert(msg.message);
			}
			},error: function(msg){
		        alert("网络超时！");
			}
	});		
	}else{
		
		alert("输入条件不能为空！");
	}
}
function time(date)
{
	 var time= new Date(date);
	   var year = time.getFullYear();
	   var month = time.getMonth()+1;//月份要加1
	   var hour = time.getHours();
	   var day = time.getDate();
	   var second = time.getSeconds();
	   var minute = time.getMinutes();
	   if(month<10)
		{
		   month ="0"+month;  
		}
	   
	   if(day<10)
		{
		   day ="0"+day;  
		}
	  
	   if(hour<10)
		{
		   hour ="0"+hour;  
		}
		
		if(minute<10)
			{
			  minute ="0"+minute;  
			}
		
		if(second<10)
		{
			second ="0"+second;  
		}
		var time1=year+"年"+month+"月"+day+"日"+" "+hour+":"+minute+":"+second;
	   
	   return   time1;
}
function instid(id)
{
	 if(id==1)
	 {
		 allUserTable="计科";
	 }
    else if(id==2)
	 {
		 allUserTable="信息";
	 }
	 else if(id==3)
	 {
		 allUserTable="制造";
	 }
	 else if(id==4)
	 {
		 allUserTable="土建";
	 }
	 else if(id==5)
	 {
		 allUserTable="环资";
	 }
    
	 else if(id==6)
	 {
		 allUserTable="材料";
	 }
	 else if(id==7)
	 {
		 allUserTable="生命";
	 }
	 else if(id==8)
	 {
		 allUserTable="理学";
	 }
	 else if(id==9)
	 {
		 allUserTable="经管";
	 }
	 else if(id==10)
	 {
		 allUserTable="文艺";
	 }
	 else if(id==11)
	 {
		 allUserTable="法学";
	 }else if(id==12)
	 {
		 allUserTable="政治";
	 }else if(id==13)
	 {
		 allUserTable="外语";
	 }else if(id==14)
	 {
		 allUserTable="体育";
	 }else if(id==15)
	 {
		 allUserTable+="成网";
	 }else if(id==16)
	 {
		 allUserTable="应技";
	 }else if(id==17)
	 {
		 allUserTable="国防";
	 }else if(id==18)
	 {
		 allUserTable="拉美";
	 }else 
	 {
		 allUserTable="学工";
	 }
	 return allUserTable;
}
function type(id)
{
	 if(id==1)
	 {
		 allUserTable="学生";
	 }
    else if(id==2)
	 {
		 allUserTable="辅导员";
	 }
	 else if(id==3)
	 {
		 allUserTable="经办老师";
	 }
	 else if(id==4)
	 {
		 allUserTable="学办主任";
	 }
	 else if(id==5)
	 {
		 allUserTable="学院分管副书记";
	 } 
	 else if(id==6)
	 {
		 allUserTable="学生处领导";
	 } 
	 else 
	 {
		 allUserTable="其他部门角色";
	 }
	 return allUserTable;
}

function instname(name){
	
	if(name=="计科")
	 {
		userInstid=1;
	 }
   else if(name=="信息")
	 {   
   	
   	userInstid=2;
	 }
	 else if(name=="制造")
	 {
		 userInstid=3;
		
	 }
	 else if(name=="土建")
	 {
		 
		 userInstid=4;
	 }
	 else if(name=="环资")
	 {
		
		 userInstid=5;
	 }
   
	 else if(name=="材料")
	 {
		 userInstid=6;
		
	 }
	 else if(name=="生命")
	 {
		 userInstid=7;
		
	 }
	 else if(name=="理学")
	 {
		 
		 userInstid=8;
	 }
	 else if(name=="经管")
	 {
		 
		 userInstid=9;
	 }
	 else if(name=="文艺")
	 {
		
		 userInstid=10;
	 }
	 else if(name=="法学")
	 {
		 userInstid=11;
		 
	 }else if(name=="政治")
	 {
		 userInstid=12;
		
	 }else if(name=="外语")
	 {
		 userInstid=13;
		
	 }else if(name=="体育")
	 {
		 userInstid=14;
		
	 }else if(name=="成网")
	 {
		 userInstid=15;
		
	 }else if(name=="应技")
	 {
		 userInstid=16;
		 
	 }else if(name=="国防")
	 {
		 userInstid=17;
		 
	 }else if(name=="拉美")
	 {
		 userInstid=18;
		
	 }else 
	 {
		 userInstid=19;
		 
	 }
	
	return userInstid;
	
}

function typename(name){
	
	if(name=="学生")
	 {
		userType=1;
	 }
   else if(name=="辅导员")
	 {   
   	
   	    userType=2;
	 }
	 else if(name=="经办老师")
	 {
		 userType=3;
		
	 }
	 else if(name=="学办主任")
	 {
		 
		 userType=4;
	 }
	 else if(name=="学院分管副书记")
	 {
		
		 userType=5;
	 }
   
	 else if(name=="学生处领导")
	 {
		 userType=6;
		
	 } else{
		
		 userType=7;
	 }
	return userType;
	
}