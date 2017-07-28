<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息审批</title>
<script type="text/javascript">
var importProjectMachineApproval_Table_selectProjectID='';
var importProjectMachineApproval_Table_selectProjectName='';
var importProjectMachineApproval_Table_selectSupplierID='';
var viewDetailType='';
	$(function(){
		initimportProjectMachineApproval_Table();
		
		$('#viewImportedMachineDetailModal').on('hide.bs.modal', function (e) {
			$("#importProjectMachineApproval_Table").bootstrapTable('refresh',{silent: true});
		});
	});
	
	function initimportProjectMachineApproval_Table(){
		$("#importProjectMachineApproval_Table").bootstrapTable("destroy");
		$("#importProjectMachineApproval_Table").bootstrapTable({
			url: '<%=path%>/projectMachineImportController/getImportedProjectMachineInfo_gs',
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
	        strictSearch: true,
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
				{field : 'check_box', checkbox : true},
				{field : 'applyState',title:'审批状态',visible : true,
					formatter:function(value,row,index){
						var waitApprovalNum=row.machine_waitApprovalNum;
						var passApprovalNum=row.machine_passNum;
						if(waitApprovalNum>0){
							return '<font color="orange">待审批</font>';
						}else if(passApprovalNum>0){
							return '<font color="green">审批完成</font>';
						}else{
							return '<font color="blue">无设备信息</font>';
						}
					}
				},
				{field : 'project_Name',title:'项目名称',visible : true},
				{field : 'project_supplierName',title:'设备供应商',visible : true},
				{field : 'machine_waitApprovalNum',title:'待审批设备',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="orange">'+value+'</font><a href="#" onclick="viewImportedMachineDetail(\''+row.project_supplierID+'\',\''+row.project_ID+'\',\''+row.project_Name+'\',\'2\')">  <font color="orange">(查看详情)</font></a>';
						}
					}
				},
				{field : 'machine_passNum',title:'审批通过设备',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="green">'+value+'</font><a href="#" onclick="viewImportedMachineDetail(\''+row.project_supplierID+'\',\''+row.project_ID+'\',\''+row.project_Name+'\',\'3\')">  <font color="green">(查看详情)</font></a>';
						}
					}
				},
				{field : 'machine_notPassNum',title:'审批未通过设备',visible : true,
					formatter:function(value,row,index){
						if(value=="0"){
							return value;
						}else{
							return '<font color="red">'+value+'</font><a href="#" onclick="viewImportedMachineDetail(\''+row.project_supplierID+'\',\''+row.project_ID+'\',\''+row.project_Name+'\',\'4\')">  <font color="red">(查看详情)</font></a>';
						}
					}
				},
				{field : 'lastImportTime',title:'导入/更新时间',visible : true,
					formatter:function(value,row,index){
						return getSmpFormatDateByLong(value,true);
					}
				},
		]
		});
	}
	
	function toViewImportedMachineDetail(){
		var importProjectMachineInfo_Table_selects = $("#importProjectMachineApproval_Table").bootstrapTable("getSelections");
		if(importProjectMachineInfo_Table_selects.length==0){
			alert_warning("查看设备详情","请先选择要查看的项目！");
		}else if(importProjectMachineInfo_Table_selects.length!=1){
			alert_warning("查看设备详情","只能选择一个项目进行查看！");
		}else if(importProjectMachineInfo_Table_selects.length==1){
			importProjectMachineApproval_Table_selectProjectID = importProjectMachineInfo_Table_selects[0].project_ID;
			importProjectMachineApproval_Table_selectProjectName = importProjectMachineInfo_Table_selects[0].project_Name;
			importProjectMachineApproval_Table_selectSupplierID = importProjectMachineInfo_Table_selects[0].project_supplierID;
			viewImportedMachineDetail(importProjectMachineInfo_Table_selectProjectID,importProjectMachineInfo_Table_selectProjectName,0);
		}
	}
	
	function passApproval(){
		var viewImportedMachineDetailModal_Table_selects = $("#viewImportedMachineDetailModal_Table").bootstrapTable("getSelections");
		if(viewImportedMachineDetailModal_Table_selects.length==0){
			alert_warning("审批设备","请先选择要审批的设备！");
		}else{
			var machineIDs = '';
			$(viewImportedMachineDetailModal_Table_selects).each(function(index,value){
				if(index==viewImportedMachineDetailModal_Table_selects.length-1){
					machineIDs+=value.id;
				}else{
					machineIDs+=value.id+",";
				}
			});
			var dialogInstance = BootstrapDialog.show({
				title:'审批设备',
				type:'type-warning',
				closable:false,
				message:'您即将通过所选择的设备审批申请，通过后将无法撤销，是否确认通过？！(改过程可能耗时较长，请耐心等待！)',
				buttons:[
					{
						label:'取消',
						action:function(dialog){
							dialog.close();
						}
					},
					{
						 icon: 'glyphicon glyphicon-ok',
						 label:'确认通过',
						 cssClass:'btn-danger',
						 autospan:true,
						 action:function(dialog){
							 dialog.enableButtons(false);
							 dialog.setClosable(false);
							 $.ajax({
								url:'<%=path%>/projectMachineImportController/toPassApprovalApply',
								data:{
									'machineIDs':machineIDs
								},
								success:function(data){
									$("#viewImportedMachineDetailModal_Table").bootstrapTable('refresh',{silent: true});
									dialogInstance.close();
									BootstrapDialog.alert({
										title:'审批设备',
										message:'审批设备成功！',
										type:'type-success',
										size:'size-small'
									});
								},error:function(data){
									alert_danger("审批设备","审批设备失败，请重试！");
								}
							 });
						 }
					}
					
				]
			});
		}
	}
	function notPassApproval(){
		var viewImportedMachineDetailModal_Table_selects = $("#viewImportedMachineDetailModal_Table").bootstrapTable("getSelections");
		if(viewImportedMachineDetailModal_Table_selects.length==0){
			alert_warning("审批设备","请先选择要审批的设备！");
		}else{
			var machineIDs = '';
			var isRemove = true ;
			alert(isRemove);
			$(viewImportedMachineDetailModal_Table_selects).each(function(index,value){
				if(value.applyState==3){
					isRemove=false;
				}
				if(index==viewImportedMachineDetailModal_Table_selects.length-1){
					machineIDs+=value.id;
				}else{
					machineIDs+=value.id+",";
				}
			});
			if(!isRemove){
				alert_danger("审批设备","已审批通过的设备无法再操作！请选择非审批通过的设备后重试！");
			}else{
				var dialogInstance = BootstrapDialog.show({
					title:'审批设备',
					type:'type-warning',
					closable:false,
					message:'您即将拒绝所选择的设备审批申请，是否确认拒绝？！',
					buttons:[
						{
							label:'取消',
							action:function(dialog){
								dialog.close();
							}
						},
						{
							 icon: 'glyphicon glyphicon-ok',
							 label:'确认拒绝',
							 cssClass:'btn-danger',
							 autospan:true,
							 action:function(dialog){
								 dialog.enableButtons(false);
								 dialog.setClosable(false);
								 $.ajax({
									url:'<%=path%>/projectMachineImportController/toNotPassApprovalApply',
									data:{
										'machineIDs':machineIDs
									},
									success:function(data){
										$("#viewImportedMachineDetailModal_Table").bootstrapTable('refresh',{silent: true});
										dialogInstance.close();
										BootstrapDialog.alert({
											title:'审批设备',
											message:'审批设备成功！',
											type:'type-success',
											size:'size-small'
										});
									},error:function(data){
										alert_danger("审批设备","审批设备失败，请重试！");
									}
								 });
							 }
						}
						
					]
				});
			}
		}
	}
	
	function viewImportedMachineDetail(supplierID,projectID,projectName,applyState){
		importProjectMachineApproval_Table_selectProjectID = projectID;
		importProjectMachineApproval_Table_selectProjectName = projectName;
		importProjectMachineApproval_Table_selectSupplierID = supplierID;
		viewDetailType=applyState;
		if(applyState==2){
			$("#viewImportedMachineDetailModal_Title").text(projectName+"项目设备（待审批）详情");
		}else if(applyState==3){
			$("#viewImportedMachineDetailModal_Title").text(projectName+"项目设备（审批通过）详情");
		}
		else if(applyState==4){
			$("#viewImportedMachineDetailModal_Title").text(projectName+"项目设备（审批未通过）详情");
		}else{
			$("#viewImportedMachineDetailModal_Title").text(projectName+"项目设备详情");
		}
		
		$("#viewImportedMachineDetailModal_Table").bootstrapTable("destroy");
		$("#viewImportedMachineDetailModal_Table").bootstrapTable({
			url: '<%=path%>/projectMachineImportController/getImportedMachineDetail_gs',
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
	        pageList: [5, 10, 15, 20,25,30,40,50,100],  //可供选择的每页的行数（*）
	        maintainSelected:true, 	//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
	                            // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
	        //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
	        sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
	        search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	        strictSearch: true,
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
			    data.supplierID=supplierID;
			    data.projectID=projectID;
			    data.applyState=applyState;
				return data;
			},
			onLoadSuccess:function(data){
			},
			columns : [
				{field : 'check_box', checkbox : true},
				{field : 'applyState',title:'状态',visible : true,
					formatter:function(value,row,index){
						if(value==3){
							return '<font color="green">审批通过</font>';
						}else if(value==2){
							return '<font color="blue">待审批</font>';
						}else if(value==4){
							return '<font color="red">审批未通过</font>';
						}
					}
				},
				{field : 'machineClassify',title:'类型',visible : true},
				{field : 'machineName',title:'名称',visible : true},
				{field : 'machineType',title:'型号',visible : true},
				{field : 'machineSize',title:'规格',visible : true},
				{field : 'rangeJingdu',title:'度量精度',visible : true},
				{field : 'unit',title:'单位',visible : true},
				{field : 'machineNum',title:'数量',visible : true},
				{field : 'unitPrice',title:'单价',visible : true},
				{field : 'totalPrice',title:'总价',visible : true,
					formatter:function(value,row,index){
						return row.machineNum*row.unitPrice;
					}
				},
				{field : 'producer',title:'生产厂家',visible : true},
				{field : 'remark',title:'备注',visible : false},
				{field : 'applyTime',title:'导入/更新时间',visible : true,
					formatter:function(value,row,index){
						return getSmpFormatDateByLong(value,true);
					}
				}
		]
		});
		$("#viewImportedMachineDetailModal").modal("show");
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
						<li class="active">项目设备基础信息审批</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 3px">
			<div class="col-sm-12" style="width: 100%">
				<div id="importProjectMachineApproval_Table_Toolbar" >
					<button type="button" class="btn btn-info" onClick="toViewImportedMachineDetail()">查看设备详情</button>
				</div>
				<table id="importProjectMachineApproval_Table" class="table table-condensed" data-toolbar="#importProjectMachineApproval_Table_Toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
		
				<!-- 模态框（Modal） -->
		<div class="modal fade" id="viewImportedMachineDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		    <div class="modal-dialog" style="width: 80%">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="viewImportedMachineDetailModal_Title"></h4>
		            </div>
		            <div class="modal-body" id="viewImportedMachineDetailModalBody">
	            		<div class="row" style="margin-top: 3px">
							<div class="col-sm-12" style="width: 100%">
								<div id="viewImportedMachineDetailModal_Table_Toolbar" >
									<button type="button" class="btn btn-success" onclick="passApproval()">审批通过</button>
									<button type="button" class="btn btn-danger" onclick="notPassApproval()">审批不通过</button>
								</div>
								<table id="viewImportedMachineDetailModal_Table" class="table table-condensed" data-toolbar="#viewImportedMachineDetailModal_Table_Toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
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