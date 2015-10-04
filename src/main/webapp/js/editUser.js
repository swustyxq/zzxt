
var zTree1;
	var setting;

		setting = {
			checkable: true,
			callback: {
				change:	zTreeOnChange
			}
		};

	$(document).ready(function(){
		refreshTree();/* 
		alert($("#treeDemo_1_check").val()); */
	});

	function zTreeOnChange(event, treeId, treeNode) {
		getCheckedNodesLength();
	}

	function getCheckBoxType() {
		var py = $("#py").attr("checked")? "p":"";
		var sy = $("#sy").attr("checked")? "s":"";
		var pn = $("#pn").attr("checked")? "p":"";
		var sn = $("#sn").attr("checked")? "s":"";
		
		var type = { "Y":py + sy, "N":pn + sn};
		return type;
	}

	function refreshTree() {
		var checkType = getCheckBoxType();
		setting.checkType = checkType;
		var zNodes ="";
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/editController/showMessage.do',
			async : false,
			data : {
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					for(var i=0;i<msg.role.length;i++){
						zNodes=msg.zNodes;
					}
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
		
		zTree1 = $("#treeDemo").zTree(setting, clone(zNodes));
		$("#checkTypeCode").html("{\"Y\":" + checkType.Y + ", \"N\":" + checkType.N + "}");
		getCheckedNodesLength();
	}

	function getCheckedNodesLength() {
		var tmp = zTree1.getCheckedNodes();
		$("#checkedNum").html(tmp.length);
		tmp = zTree1.getChangeCheckedNodes();
		$("#checkedChangeNum").html(tmp.length);
		if ($("#changeYes").attr("checked")) {
			for (var i=0; i<tmp.length; i++) {
				tmp[i].checkedOld = tmp[i].checked;
				alert(tmp[i].id+" "+tmp[i].pId);
			}
		}
	}
	
	 function onCheck(e,treeId,treeNode){
         var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
         nodes=treeObj.getCheckedNodes(true),
         v="";
         for(var i=0;i<nodes.length;i++){
         v+=nodes[i].name + ",";
         }
         }


//为用户新添加一个角色
function AddRole(userId,roleId) {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/editController/addRole.do',
		async : false,
		data : {
			userId:userId,
			roleId:roleId,
		},
		dataType : 'json',
		success : function(msg) {			
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});	
};

//删除一个用户的角色
function DeleteRole(userId,roleId) {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/editController/deleteRole.do',
		async : false,
		data : {
			userId:userId,
			roleId:roleId,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
			}
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});	
};

//检查复选框中被选中的值
function save(){
	Check();
	alert("修改成功");
};
function Check(){	
	var obj=document.getElementsByName("role");
	var userId=0;
	var Request = new Object();
	Request = GetRequest();
	if(Request!=null)
	{
		userId=Request['id'];
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/zzxt/editController/checkbox.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				for ( var i = 0; i < msg.allrole.length; i++) {
					if (!obj[i].checked) {
						DeleteRole(userId,msg.allrole[i].roleId);// 未写功能
					} else {
						AddRole(userId,msg.allrole[i].roleId);
					}
				}					
			}
			
		},
		error : function(msg) {
			alert("网络超时！");
		}
	});	
};


//获取网页传递的值
/*var Request = new Object();
Request = GetRequest();
if(Request!=null)
{
	userId=Request['id'];
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
*/