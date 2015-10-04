$(document).ready(function (){
	onload();
	
	$("#Query").click(function(){
		var page=1;
		var type=$('#type option:selected') .val();
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/announcementController/showAnnouncementsByType.do',
			async : false,
			data : {
				page:page,
				type:type
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){		
					var content="";
					$.each(msg.pageList,function(key,val){
						content+="<tr><td>"+val.type+"</td><td><a href='#' onclick='showDetail("+val.id+")'>"+val.title+"</a></td><td>"+val.lastModifyTime+"</td><td>"+
						"<div class='form-group'><button onclick='modify("+val.id+")' type='button' class='btn btn-warning btn-xs'>修改</button></div>"+
						"<div class='form-group'><button onclick='deleteOne("+val.id+")' type='button' class='btn btn-danger btn-xs'>删除</button></div>"
						+"</td></tr>";
					});
					$("#announcements").empty().append(content);
					$("#announcementList").paginate({
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
							showOnePageAnnouncement(page,type);
						}
					});
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
	});
});

function  showOnePageAnnouncement(page,type){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/announcementController/showAnnouncementsByType.do',
		async : false,
		data : {
			page:page,
			type:type
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){						
				var content="";
				$.each(msg.pageList,function(key,val){
					if(msg.user.userType==6){
						content+="<tr><td>"+val.type+"</td><td><a href='#' onclick='showDetail("+val.id+")'>"+val.title+"</a></td><td>"+val.lastModifyTime+"</td><td>"+
						"<div class='form-group'><button onclick='modify("+val.id+")' type='button' class='btn btn-warning btn-xs'>修改</button></div>"+
						"<div class='form-group'><button onclick='deleteOne("+val.id+")' type='button' class='btn btn-danger btn-xs'>删除</button></div>"
						+"</td></tr>";
					}else{
						content+="<tr><td>"+val.type+"</td><td><a href='#' onclick='showDetail("+val.id+")'>"+val.title+"</a></td><td>"+val.lastModifyTime+"</td><td>"+
						"<div class='form-group'><button onclick='showDetail("+val.id+")' type='button' class='btn btn-success btn-xs'>查看详细信息</button></div>"
						+"</td></tr>";
					}
				});
				$("#announcements").empty().append(content);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
}

function showDetail(id){
	window.location.href = "seeAnnouncementDetail.html?id="+id;
}

function modify(id){
	window.location.href = "modifyInfo.html?id="+id;
}

function deleteOne(id){
	if(window.confirm('你确定要删除吗？')){
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/announcementController/deleteAnnouncement.do',
			async : false,
			data : {
				id:id
			},
			dataType : 'json',
			success : function(msg) {
				if(msg.result ==true){
					alert("删除成功！");
				}else{
					alert(msg.message);
				}
			},error: function(msg){
			    alert("网络超时！");
			}
		});
		onload();
		
        return true;
     }else{
        return false;
    }
}

function onload(){
	var Request = new Object();
	Request = GetRequest();
	
	var type=0;
	if (Request != null) {
		type = Request['type'];
	}
	
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/announcementController/showAllannouncementType.do',
		async : false,
		data : {
			
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){
				var typeString="<option value='0'>全部</option>";
				$.each(msg.type,function(key,val){
					if(val.antpId==type){
						typeString+="<option selected='selected' value='"+val.antpId+"'>"+val.antpName+"</option>";
					}else{
						typeString+="<option value='"+val.antpId+"'>"+val.antpName+"</option>";
					}
				});
				$("#type").empty().append(typeString);
			}else{
				alert(msg.message);
			}
		},error: function(msg){
		    alert("网络超时！");
		}
	});
	var page=1;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/announcementController/showAnnouncementsByType.do',
		async : false,
		data : {
			page:page,
			type:type
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){		
				var content="";
				$.each(msg.pageList,function(key,val){
					if(msg.user.userType==6){
						content+="<tr><td>"+val.type+"</td><td><a href='#' onclick='showDetail("+val.id+")'>"+val.title+"</a></td><td>"+val.lastModifyTime+"</td><td>"+
						"<div class='form-group'><button onclick='modify("+val.id+")' type='button' class='btn btn-warning btn-xs'>修改</button></div>"+
						"<div class='form-group'><button onclick='deleteOne("+val.id+")' type='button' class='btn btn-danger btn-xs'>删除</button></div>"
						+"</td></tr>";
					}else{
						content+="<tr><td>"+val.type+"</td><td><a href='#' onclick='showDetail("+val.id+")'>"+val.title+"</a></td><td>"+val.lastModifyTime+"</td><td>"+
						"<div class='form-group'><button onclick='showDetail("+val.id+")' type='button' class='btn btn-success btn-xs'>查看详细信息</button></div>"
						+"</td></tr>";
					}
				});
				$("#announcements").empty().append(content);
				$("#announcementList").paginate({
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
						showOnePageAnnouncement(page,type);
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


function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();

	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for ( var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	if (url.indexOf("type") == -1) {
		theRequest = null;
	}
	return theRequest;
}