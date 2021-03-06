<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目设备信息</title>
<script type="text/javascript">
	$(function(){
		initProjectMachine_Table();
		
		$('#viewMachineDetailModal').on('hide.bs.modal', function (e) {
			$("#ProjectMachine_Table").bootstrapTable('refresh',{silent: true});
		});
	});
	
	function initProjectMachine_Table(){
		$("#ProjectMachine_Table").bootstrapTable("destroy");
		$("#ProjectMachine_Table").bootstrapTable({
			url: '<%=path%>/projectMachineImportController/getProjectMachineInfo_gs',
			method: 'get',
	        //toolbar: '#toolbar',    //工具按钮用哪个容器
	        striped: true,      //是否显示行间隔色
	        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,     //是否显示分页（*）
	        maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        //sortable: false,      //是否启用排序
	        //sortOrder: "asc",     //排序方式
	        pageNumber:1,      //初始化加载第一页，默认第一页
	        pageSize:5,
	        pageList: [5, 10, 15, 20,25,30,40,50,100],   //可供选择的每页的行数（*）
	        maintainSelected:true, 	//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
	                            // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
	        //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
	        sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
	        search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	        ////strictSearch: true,
	        //showColumns: true,     //是否显示所有的列
	        //showRefresh: true,     //是否显示刷新按钮
	        clickToSelect: true,    //是否启用点击选中行
	        showExport:true,
	        showFilter:true,
	        filterControl:true,
	        filterShowClear:true,
	        exportTypes:['excel', 'doc',  'pdf', 'png', 'xml', 'csv', 'txt', 'sql','json'],
	        //queryParams:$("#projectList_gs_searchForm").serialize(),
			queryParams : function(data) {
			    data.companyID='<%=userID %>';
				return data;
			},
			onLoadSuccess:function(data){
			},
			columns : [
				/*
				private String projectID;
				private String projectName;
				private String supplierID;
				private String supplierName;
				private String companyID;
				private String companyName;
				private Integer waitNum;
				private Integer hasNum;
				private Integer hasSendInNum;
				*/
				{field : 'check_box', checkbox : true},
				{field : 'projectName',title:'项目名称',visible : true},
				{field : 'companyName',title:'供应商名称',visible : true},
				{field : 'waitSendOutNum',title:'待发货',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="orange">'+value+'台</font><a href="#" onclick="viewMachineDetail(\''+row.projectID+'\',\''+row.supplierID+'\',\''+row.projectName+'\',\'4\')">  <font color="orange">(查看详情)</font></a>';
						}
					}
				},
				{field : 'hasSendOutNum',title:'待收货',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="blue">'+value+'台</font><a href="#" onclick="viewMachineDetail(\''+row.projectID+'\',\''+row.supplierID+'\',\''+row.projectName+'\',\'5\')">  <font color="blue">(查看详情)</font></a>';
						}
					}
				},
				{field : 'hasSendInNum',title:'使用中',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="green">'+value+'台</font><a href="#" onclick="viewMachineDetail(\''+row.projectID+'\',\''+row.supplierID+'\',\''+row.projectName+'\',\'0\')">  <font color="green">(查看详情)</font></a>';
						}
					}
				},
				{field : 'unusedNum',title:'闲置',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="#8B8970">'+value+'台</font><a href="#" onclick="viewMachineDetail(\''+row.projectID+'\',\''+row.supplierID+'\',\''+row.projectName+'\',\'1\')">  <font color="#8B8970">(查看详情)</font></a>';
						}
					}
				},
				{field : 'waitRepaireNum',title:'待维修',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="red">'+value+'台</font><a href="#" onclick="viewMachineDetail(\''+row.projectID+'\',\''+row.supplierID+'\',\''+row.projectName+'\',\'2\')">  <font color="red">(查看详情)</font></a>';
						}
					}
				},
				{field : 'scarpNum',title:'报废',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="">'+value+'台</font><a href="#" onclick="viewMachineDetail(\''+row.projectID+'\',\''+row.supplierID+'\',\''+row.projectName+'\',\'3\')">  <font color="">(查看详情)</font></a>';
						}
					}
				},
		]
		});
	}
	
	function viewMachineDetail(projectID,supplierID,projectName,machineState){
		$("#viewMachineDetailModal_Table_sendBtn").hide();
		$("#viewMachineDetailModal_Table_sendingBtn").hide();
		if(machineState==0){
			$("#viewMachineDetailModal_Title").text(projectName+"项目设备（使用中）详情");
		}else if(machineState==4){
			$("#viewMachineDetailModal_Table_sendBtn").show();
			$("#viewMachineDetailModal_Title").text(projectName+"项目设备（待发货）详情");
		}else if(machineState==5){
			$("#viewMachineDetailModal_Title").text(projectName+"项目设备（待收货）详情");
		}else if(machineState==1){
			$("#viewMachineDetailModal_Title").text(projectName+"项目设备（闲置）详情");
		}else if(machineState==2){
			$("#viewMachineDetailModal_Title").text(projectName+"项目设备（待维修）详情");
		}else if(machineState==3){
			$("#viewMachineDetailModal_Title").text(projectName+"项目设备（报废）详情");
		}
		$("#viewMachineDetailModal_Table").bootstrapTable("destroy");
		$("#viewMachineDetailModal_Table").bootstrapTable({
			url: '<%=path%>/projectMachineImportController/viewMachineDetail_gs',
			method: 'get',
	        //toolbar: '#toolbar',    //工具按钮用哪个容器
	        striped: true,      //是否显示行间隔色
	        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,     //是否显示分页（*）
	        maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        //sortable: false,      //是否启用排序
	        //sortOrder: "asc",     //排序方式
	        pageNumber:1,      //初始化加载第一页，默认第一页
	        pageSize:5,
	        pageList: [5, 10, 15, 20,25,30,40,50,100],   //可供选择的每页的行数（*）
	        maintainSelected:true, 	//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
	                            // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
	        //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
	        sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
	        search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	        //////strictSearch: true,
	        //showColumns: true,     //是否显示所有的列
	        //showRefresh: true,     //是否显示刷新按钮
	        clickToSelect: true,    //是否启用点击选中行
	        showExport:true,
	        showFilter:true,
	        filterControl:true,
	        filterShowClear:true,
	        exportTypes:['excel', 'doc',  'pdf', 'png', 'xml', 'csv', 'txt', 'sql','json'],
	        //queryParams:$("#projectList_gs_searchForm").serialize(),
			queryParams : function(data) {
				data.projectID=projectID;
				data.supplierID=supplierID;
				data.machineState=machineState;
				return data;
			},
			onLoadSuccess:function(data){
			},
			columns : [
				/*
				private String id;
			    private String gyxId;
			    private String projectId;
			    private String machineName;
			    private String machineType;
			    private String machineSize;
			    private String rangeJingdu;
			    private String producerOrd;
			    private String machineState;
			    private String unit;
			    private String producer;
			    private String oldNew;
			    private Date sendDate;
			    private Date importDate;
			    private Date installDate;
			    private Date checkDate;
			    private String checkPeriod;
			    private Date baozhiqi;
			    private Integer repairNum;
			    private Double unitPrice;
			    private String machineClassify;
			    private String remark;
				*/
				{field : 'check_box', checkbox : true},
				{field : 'machineState',title:'状态',visible : true,
					formatter:function(value,row,index){
						if(value==0){
							return '<font color="green">已收货</font>';
						}else if(value==4){
							return '<font color="orange">待发货</font>';
						}else if(value==5){
							return '<font color="blue">已发货</font>';
						}
					}
				},
				{field : 'machineClassify',title:'类型',visible : true},
				{field : 'machineName',title:'名称',visible : true},
				{field : 'machineType',title:'型号',visible : true},
				{field : 'machineSize',title:'规格',visible : true},
				{field : 'rangeJingdu',title:'度量精度',visible : true},
				{field : 'unit',title:'单位',visible : true},
				{field : 'unitPrice',title:'价格',visible : true},
				{field : 'producer',title:'生产厂家',visible : true},
				{field : 'remark',title:'备注',visible : false}
		]
		});
		$("#viewMachineDetailModal").modal('show');
	}
	
	function toMachines(){
		var selects = $("#viewMachineDetailModal_Table").bootstrapTable('getSelections');
		if(selects.length<=0){
			alert_warning("设备发货","请先选择要发货的设备");
		}else{
			$("#viewMachineDetailModal_Table_sendBtn").hide();
			$("#viewMachineDetailModal_Table_sendingBtn").show();
			var machineIDs = '';			
			$(selects).each(function(index,value){
				if(index==selects.length-1){
					machineIDs+=value.id;
				}else{
					machineIDs+=value.id+',';
				}
			});
			$.ajax({
				url:'<%=path%>/projectMachineImportController/toMachines',
				data:{
					'machineIDs':machineIDs
				},
				success:function(data){
					$("#viewMachineDetailModal_Table").bootstrapTable("refresh",{silent:true});
					$("#viewMachineDetailModal_Table_sendBtn").show();
					$("#viewMachineDetailModal_Table_sendingBtn").hide();
					alert_success("设备发货","发货成功！");
				},
				error:function(data){
					alert_danger("设备发货","发货失败，请稍后重试！");
					$("#viewMachineDetailModal_Table_sendBtn").show();
					$("#viewMachineDetailModal_Table_sendingBtn").hide();
				}
			});
		}
	}
</script>
</head>
<body>
	<div class="container" style="margin: 0 0 0 0 ;width: 100%;">
		<div class="page-content-wrapper">
			<div class="page-content-wrapper">
				<div id=page_title>
					<ul class="breadcrumb" style="margin-bottom:0;">   
						<li>    设备管理</li>  
						<li class="active">项目设备信息</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 3px">
			<div class="col-sm-12" style="width: 100%">
				<div id="ProjectMachine_Table_Toolbar" >
				</div>
				<table id="ProjectMachine_Table" class="table table-condensed" data-toolbar="#ProjectMachine_Table_Toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
		
				<!-- 模态框（Modal） -->
		<div class="modal fade" id="viewMachineDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		    <div class="modal-dialog" style="width: 80%">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="viewMachineDetailModal_Title"></h4>
		            </div>
		            <div class="modal-body" id="viewMachineDetailModalBody">
	            		<div class="row" style="margin-top: 3px">
							<div class="col-sm-12" style="width: 100%">
								<div id="viewMachineDetailModal_Table_Toolbar" >
								</div>
								<table id="viewMachineDetailModal_Table" class="table table-condensed" data-toolbar="#viewMachineDetailModal_Table_Toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
									<thead style="background-color: #87CEFF"></thead>
								</table>
							</div>
						</div>
					</div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
	</div>
</body>
</html>