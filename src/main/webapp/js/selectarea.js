
	//省的父id为0，直接通过fuid查找
		var areaParentId1 = 0;
		findArea(areaParentId1,"#province");
	//省、市、县、镇四级联动
	function cityChange(){
		var areaParentId2 = $("#province").val();
		findArea(areaParentId2,"#city");
		var areaParentId3 = $("#city").val();
		findArea(areaParentId3,"#county");
		var areaParentId4 = $("#county").val();
		findArea(areaParentId4,"#town");
	}
	//市、县、镇三级联动
	function countyChange(){
		var areaParentId3 = $("#city").val();
		findArea(areaParentId3,"#county");
		var areaParentId4 = $("#county").val();
		findArea(areaParentId4,"#town");
	}
	//县、镇、两级联动
	function townChange(){
		var areaParentId4 = $("#county").val();
		findArea(areaParentId4,"#town");
	}
	
/*	
	
	//省的父id为0，直接通过fuid查找
	var areaParentId1 = 0;
	findArea(areaParentId1,"#province1");
	//省、市、县、镇四级联动
	function cityChange1(){
		var areaParentId2 = $("#province1").val();
		findArea(areaParentId2,"#city1");
		var areaParentId3 = $("#city1").val();
		findArea(areaParentId3,"#county1");
		var areaParentId4 = $("#county1").val();
		findArea(areaParentId4,"#town1");
	}
	//市、县、镇三级联动
	function countyChange1(){
		var areaParentId3 = $("#city1").val();
		findArea(areaParentId3,"#county1");
		var areaParentId4 = $("#county1").val();
		findArea(areaParentId4,"#town1");
	}
	//县、镇、两级联动
	function townChange1(){
		var areaParentId4 = $("#county1").val();
		findArea(areaParentId4,"#town1");
	}*/
	
	//查找
    initArea();
	function findArea(areaParentId,selectId){
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/AreaController/searchAreasByAreaParentId.do',
			async : false,
			data : {
				areaParentId : areaParentId
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					var provinceName="";
					//option遍历输出
					$.each(msg.areaList,function(key,val){
						provinceName +='<option value="' + val.areaId + '">' + val.areaName + '</option>';
						//先清空，再传值
					});
					//加了这个默认值才能显示
					$(selectId).empty().append("<option value='0' disabled='disabled' selected='selected'>请选择</option>"+provinceName);
				} else{
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});

	};


	// 初始化四组选择框
function initArea() {
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/informationController/showDeatilInformation.do',
			async : false,
			data : {
			
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					findArea(msg.county,"#town");
					findArea(msg.city,"#county");
					findArea(msg.province,"#city");
					findArea(0,"#province");
				} else {
					findArea(areaParentId1,"#province");
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});
	}

/*function findArea1(areaParentId,selectId){
	$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/zzxt/AreaController/searchAreasByAreaParentId.do',
			async : false,
			data : {
				areaParentId : areaParentId
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					var provinceName="";
					//option遍历输出
					$.each(msg.areaList,function(key,val){
						provinceName +='<option value="' + val.areaId + '">' + val.areaName + '</option>';
						//先清空，再传值
					});
					//加了这个默认值才能显示
					$(selectId).empty().append("<option value='0' disabled='disabled' >请选择</option>"+provinceName);
				} else{
					alert(msg.message);
				}
			},
			error : function(msg) {
				alert("网络超时！");
			}
		});

	};
*/
