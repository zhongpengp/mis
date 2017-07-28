<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目管理——我的项目</title>
<style type="text/css">
	.form-group{
		margin-bottom: 3px;
	}
</style>
<script type="text/javascript">
	var projectList_gs_selectedProjectName;
	var projectList_gs_selectedProjectID;
	$(function(){
		initTable_projectList_gs();
	});
	
	function initTable_projectList_gs(){
		$("#projectList_gs").bootstrapTable("destroy");
		$("#projectList_gs").bootstrapTable({
			url: '<%=path%>/projectController/getCompanyProjects',
			method: 'get',
	        //toolbar: '#toolbar',    //工具按钮用哪个容器
	        striped: true,      //是否显示行间隔色
	        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,     //是否显示分页（*）
	        maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        //sortable: false,      //是否启用排序
	        //sortOrder: "asc",     //排序方式
	        pageNumber:1,      //初始化加载第一页，默认第一页
	        pageSize:17,
	        pageList: [17, 25, 50, 100],  //可供选择的每页的行数（*）
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
	        queryParams:$("#projectList_gs_searchForm").serialize(),
			<%-- queryParams : function(data) {
			    data.teacherID='<%=userID%>'
				return data;
			}, --%>
			onLoadSuccess:function(data){
			},
			columns : [
				{field : 'check_box', checkbox : true},
				{field : 'projectName',title:'项目名称',visible : true},
				{field : 'projectType',title:'项目类型',visible : true},
				{field : 'projectStatue',title:'项目状态',visible : true,
					formatter:function(value,row,index){
						return getProjectStateName_html(value);
					}
				},
				{field : 'projectStep',title:'项目进度',visible : true,
					formatter:function(value,row,index){
						return getProjectStepName(row.projectType,value);
					}},
				{field : 'projectDetail',title:'项目描述',visible : true},
		]
		});
	}
	
	function viewProjectStep(projectID){
		alert("建设中……");
	}
	
	function viewProjectDetail(){
		var projectList_gs_selecteds = $("#projectList_gs").bootstrapTable('getSelections');
		if(projectList_gs_selecteds.length==0){
			alert_danger("查看项目详情","请先选择要查看的项目！");
		}else if(projectList_gs_selecteds.length!=1){
			alert_danger("查看项目详情","只能选择一个项目进行查看");
		}else{
			var selectedProjectID = projectList_gs_selecteds[0].projectId;
			initProjectDetailByID(selectedProjectID);
		}
	}
	
	function addProjectSuppliers(){
		var addProjectSupplierModal_table_selecteds = $("#addProjectSupplierModal_table").bootstrapTable('getSelections');
		if(addProjectSupplierModal_table_selecteds.length==0){
			alert_danger("添加项目供应商","请先选择要添加的供应商！");
		}else{
			var supplier_IDs = '';
			$(addProjectSupplierModal_table_selecteds).each(function(index,value){
				if(index==addProjectSupplierModal_table_selecteds.length-1){
					supplier_IDs+=value.supplier_ID;
				}else{
					supplier_IDs+=value.supplier_ID+',';
				}
			});
			$.ajax({
				url:'<%=path%>/supplierController/addProjectSuppliersByIDs',
				data:{
					projectID:projectList_gs_selectedProjectID,
					supplierIDs:supplier_IDs
				},
				success:function(){
					$("#addProjectSupplierModal").modal('hide');
					alert_success("添加供应商","添加供应商成功！");
					initProjectSuppliers(projectList_gs_selectedProjectID);
				},
				error:function(){
					alert_danger("添加供应商","添加供应商失败，请重试！");
				}
			});
		}
	}
	
	function removeProjectSupplier(){
		var projectSupplierList_gs_selecteds = $("#projectSupplierList_gs").bootstrapTable('getSelections');
		if(projectSupplierList_gs_selecteds.length==0){
			alert_danger("移除供应商","请先选择要移除的供应商！");
		}else{
			var dialogInstance = BootstrapDialog.show({
				title:'移除供应商',
				type:'type-danger',
				closable:false,
				message:'您即将移除供应商，是否确认移除？！',
				buttons:[
					{
						label:'取消',
						action:function(dialog){
							dialog.close();
						}
					},
					{
						 icon: 'glyphicon glyphicon-repeat',
						 label:'确认移除',
						 cssClass:'btn-danger',
						 autospan:true,
						 action:function(dialog){
							 dialog.enableButtons(false);
							 dialog.setClosable(false);
							 var supplier_IDs = '';
								$(projectSupplierList_gs_selecteds).each(function(index,value){
									if(index==projectSupplierList_gs_selecteds.length-1){
										supplier_IDs+=value.supplier_ID;
									}else{
										supplier_IDs+=value.supplier_ID+',';
									}
								});
							 $.ajax({
								url:'<%=path%>/supplierController/removeProjectSuppliersByID',
								data:{
									projectID:projectList_gs_selectedProjectID,
									supplierIDs:supplier_IDs
								},
								success:function(){
									dialogInstance.close();
									alert_success("移除供应商","移除供应商成功！");
									initProjectSuppliers(projectList_gs_selectedProjectID);
								},
								error:function(){
									dialogInstance.close();
									alert_danger("移除供应商","移除供应商失败，请重试！");
								}
							});
							
						 }
					}
					
				]
			});
		}
	}
	
	function initProjectNotOwnSuppliersTable(){
		$("#addProjectSupplierModal_table").bootstrapTable("destroy");
		$("#addProjectSupplierModal_table").bootstrapTable({
			url: '<%=path%>/supplierController/getProjectNotOwnerSuppliers',
			method: 'get',
	        //toolbar: '#toolbar',    //工具按钮用哪个容器
	        striped: true,      //是否显示行间隔色
	        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,     //是否显示分页（*）
	        maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        //sortable: false,      //是否启用排序
	        //sortOrder: "asc",     //排序方式
	        pageNumber:1,      //初始化加载第一页，默认第一页
	        pageSize:17,
	        pageList: [17, 25, 50, 100],  //可供选择的每页的行数（*）
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
			    data.projectID=projectList_gs_selectedProjectID;
			    data.companyID='<%=userID %>';
				return data;
			},
			onLoadSuccess:function(data){
				$("#addProjectSupplierModal").modal('show');
			},
			columns : [
				{field : 'check_box', checkbox : true},
				{field : 'supplier_Name',title:'供应商名称',visible : true},
				{field : 'supplier_Desc',title:'供应商描述',visible : true},
				{field : 'user_name',title:'联系人',visible : true},
				{field : 'user_email',title:'联系邮箱',visible : true},
				{field : 'user_phone',title:'联系电话',visible : true},
		]
		});
	}
	
	function initProjectDetailByID(selectedProjectID){
		$.ajax({
			url:'<%=path%>/projectController/getProjectDetailByID',
			data:{
				projectID:selectedProjectID
			},
			success:function(data){
			   $("#projectDetailModal_title").text("项目详情——"+data.project_name);
			   $('#projectDetailModal_projectName').val(data.project_name);
		       $('#projectDetailModal_projectState').val(getProjectStateName(data.project_state));
		       $('#projectDetailModal_projectType').val(data.project_type);
		       $('#projectDetailModal_projectStep').val(getProjectStepName(data.project_type,data.project_step));
		       $('#projectDetailModal_projecDetail').val(data.project_desc);
		       $('#projectDetailModal_person_name').val(data.person_name);
		       $('#projectDetailModal_person_sex').val(data.person_sex);
		       $('#projectDetailModal_person_birthday').val(data.person_birthday);
		       $('#projectDetailModal_person_email').val(data.person_email);
		       $('#projectDetailModal_person_phone').val(data.person_phone);
		       $("#projectDetailModal").modal('show');
			},
			error:function(){
				alert_danger("查看项目详情","获取项目详细信息失败，请重试！");
			}
		});
	}
	
	function projectSupplierMng(){
		var projectList_gs_selecteds = $("#projectList_gs").bootstrapTable('getSelections');
		if(projectList_gs_selecteds.length==0){
			alert_danger("项目供应商管理","请先选择要管理的项目！");
		}else if(projectList_gs_selecteds.length!=1){
			alert_danger("项目供应商管理","只能选择一个项目进行管理");
		}else{
			var selectedProjectID = projectList_gs_selecteds[0].projectId;
			projectList_gs_selectedProjectID = selectedProjectID;
			initProjectSuppliers(selectedProjectID);
			projectList_gs_selectedProjectName = projectList_gs_selecteds[0].projectName;
			$("#projectSupplierModal_title").text("项目供应商管理——"+projectList_gs_selectedProjectName);
			$("#projectSupplierModal").modal('show');
		}
	}
	
	function initProjectSuppliers(selectedProjectID){
		$("#projectSupplierList_gs").bootstrapTable("destroy");
		$("#projectSupplierList_gs").bootstrapTable({
			url: '<%=path%>/projectController/getProjectSuppliers',
			method: 'get',
	        //toolbar: '#toolbar',    //工具按钮用哪个容器
	        striped: true,      //是否显示行间隔色
	        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,     //是否显示分页（*）
	        maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
	        //sortable: false,      //是否启用排序
	        //sortOrder: "asc",     //排序方式
	        pageNumber:1,      //初始化加载第一页，默认第一页
	        pageSize:17,
	        pageList: [17, 25, 50, 100],  //可供选择的每页的行数（*）
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
			    data.projectID=selectedProjectID;
				return data;
			},
			onLoadSuccess:function(data){
			},
			columns : [
				{field : 'check_box', checkbox : true},
				{field : 'applyState',title:'申请状态',visible : true,
					formatter:function(value,row,index){
						if(value==1){
							return "<font color='orange'>待审批</font>";
						}else if(value==2){
							return "<font color='green'>审批通过</font>";
						}else if(value==3){
							return "<font color='red'>审批未通过</font><a href='#' onclick='reReply(\""+row.supplier_ID+"\")'>(重新申请)</>";
						}
					}
				},
				{field : 'supplier_Name',title:'供应商名称',visible : true},
				{field : 'supplier_Desc',title:'供应商简介',visible : true},
				{field : 'user_name',title:'联系人',visible : true},
				{field : 'user_email',title:'联系邮箱',visible : true},
				{field : 'user_phone',title:'联系电话',visible : true},
		]
		});
	}
	
	function reReply(supplier_ID){
		var dialogInstance = BootstrapDialog.show({
			title:'重新申请添加供应商',
			type:'type-warning',
			closable:false,
			message:'您即将重新申请添加供应商，是否确认申请？！',
			buttons:[
				{
					label:'取消',
					action:function(dialog){
						dialog.close();
					}
				},
				{
					 icon: 'glyphicon glyphicon-repeat',
					 label:'确认申请',
					 cssClass:'btn-success',
					 autospan:true,
					 action:function(dialog){
						 dialog.enableButtons(false);
						 dialog.setClosable(false);
						 $.ajax({
							url:'<%=path%>/supplierController/reReplyProjectSuppliersByID',
							data:{
								projectID:projectList_gs_selectedProjectID,
								supplierID:supplier_ID
							},
							success:function(){
								dialogInstance.close();
								alert_success("添加供应商","重新申请供应商成功！请等待供应商审核。");
								initProjectSuppliers(projectList_gs_selectedProjectID);
							},
							error:function(){
								dialogInstance.close();
								alert_danger("添加供应商","重新申请供应商失败，请重试！");
							}
						});
						
					 }
				}
				
			]
		});
	}
	
	function getProjectStateName(value){
		if(value=="0"){
			return '未开始';
		}else if(value=="2"){
			return '进行中';
		}else if(value=="3"){
			return '已完成';
		}else if(value=="4"){
			return '已注销';
		}
	}
	
	function getProjectStateName_html(value){
		if(value=="0"){
			return '<font color="">未开始</font>';
		}else if(value=="2"){
			return '<font color="blue">进行中</font>';
		}else if(value=="3"){
			return '<font color="green">已完成</font>';
		}else if(value=="4"){
			return '<font color="red">已注销</font>';
		}
	}
	
	function getProjectStepName(projectType,value){
		var name;
		if(projectType=="桥梁"){
			if(value=="0"){
				return '未开始';
			}else if(value=="1"){
				name = '(1/9)桩基础';
			}else if(value=="2"){
				name = '(2/9)系梁';
			}else if(value=="3"){
				name = '(3/9)墩柱';
			}else if(value=="4"){
				name = '(4/9)盖梁';
			}else if(value=="5"){
				name = '(5/9)桥台';
			}else if(value=="6"){
				name = '(6/9)支座及垫石';
			}else if(value=="7"){
				name = '(7/9)空心板预制及安装';
			}else if(value=="8"){
				name = '(8/9)桥面铺装及栏杆';
			}else if(value=="9"){
				name = '(9/9)附属工程';
			}
		}else if(projectType=="路基"){
			if(value=="0"){
				return '未开始';
			}else if(value=="1"){
				name = '(1/10)准备工作';
			}else if(value=="2"){
				name = '(2/10)土方工程';
			}else if(value=="3"){
				name = '(3/10)路基施工';
			}else if(value=="4"){
				name = '(4/10)沥青路面施工';
			}else if(value=="5"){
				name = '(5/10)边缘石施工';
			}else if(value=="6"){
				name = '(6/10)涂料施工';
			}else if(value=="7"){
				name = '(7/10)绿化施工';
			}else if(value=="8"){
				name = '(8/10)管道施工';
			}else if(value=="9"){
				name = '(9/10)铺道板施工';
			}else if(value=="10"){
				name = '(10/10)收尾工程';
			}
		}else if(projectType=="隧道"){
			if(value=="0"){
				return '未开始';
			}else if(value=="1"){
				name = '(1/10)施工准备';
			}else if(value=="2"){
				name = '(2/10)进口洞口边仰坡';
			}else if(value=="3"){
				name = '(3/10)进口管棚、防护';
			}else if(value=="4"){
				name = '(4/10)出口明洞回填、洞门';
			}else if(value=="5"){
				name = '(5/10)进口洞身开挖支护';
			}else if(value=="6"){
				name = '(6/10)出口明洞衬砌';
			}else if(value=="7"){
				name = '(7/10)二次衬砌、管件安装';
			}else if(value=="8"){
				name = '(8/10)洞内外排水、电缆沟';
			}else if(value=="9"){
				name = '(9/10)装饰及机电安装调试';
			}else if(value=="10"){
				name = '(10/10)隧道内路面装饰';
			}
		}
		return name;
	}
	
</script>
</head>
<body>
	<div class="container" style="margin: 0 0 0 0 ;width: 100%;">
		<div class="page-content-wrapper">
			<div class="page-content-wrapper">
				<div id=page_title>
					<ul class="breadcrumb" style="margin-bottom:0;">   
						<li>    项目管理</li>  
						<li class="active">我的项目</li>
					</ul>
				</div>
				<div class="page-content">
					<div id="main" class="drmtable">
						<div class="tjsx_title">条件筛选：</div>
						<div id="filter">
							<div class="filtrate_box clearfix" style="margin-bottom: 0">
								<form id="projectList_gs_searchForm" class="form-horizontal" role="form">
									<input type="text" name="companyID" value="<%=userID %>" style="display: none;">
									<ul class="filtrate_list">
							      		<li class="child_li first_sort bac_bl" >
							      			<div class="form-group" style="margin-bottom: 1px;">
							      				<label for="projectState" class="col-sm-1 control-label">项目状态</label>
											    <div class="col-md-10">
													<label class="checkbox-inline">
												    	<input type="radio" name="projectState" id="" value="">全部
												  	</label>
													<label class="checkbox-inline">
												    	<input type="radio" name="projectState" id="" value="0">未开始
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="projectState" id="" value="2">进行中
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="projectState" id="" value="3">已结束
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="projectState" id="" value="4">已注销
												  	</label>
											  	</div>
							      			</div>
							      		</li>
							      		<li class="child_li first_sort" >
							      			<div class="form-group">
							      				<label for="projectType" class="col-sm-1 control-label">项目类型</label>
											    <div class="col-md-10">
													<label class="checkbox-inline">
												    	<input type="radio" name="projectType" id="" value="">全部
												  	</label>
													<label class="checkbox-inline">
												    	<input type="radio" name="projectType" id="" value="桥梁">桥梁
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="projectType" id="" value="路基">路基
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="projectType" id="" value="隧道">隧道
												  	</label>
											  	</div>
							      			</div>
							      		</li>
							      		<li class="child_li first_sort bac_bl" >
								      		<div class="form-group">
											    <label for="projectName" class="col-sm-1 control-label">项目名称</label>
											    <div class="col-sm-3">
											      <input type="text" class="form-control" id="projectName" name="projectName" placeholder="请输入项目名称">
											    </div>
											    <div class="checkbox col-md-2" >
													<label style="padding-left: 0px;margin-left: 0px;">
													  <input type="checkbox" id="ifPrecise" name="projectName_isExact" value="1"> 精确查询
													</label>
												</div>
												<div class="col-sm-5" align="center">
													<button id="projectList_gs_searchFormQueryReset" type="button" class="btn btn-warning">重置</button>
													<button id="projectList_gs_searchFormQuery" type="button" class="btn btn-info" onclick="initTable_projectList_gs()">查询</button>
												</div>
											 </div>
							      		</li>
									</ul>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row" style="margin-top: 3px">
			<div class="col-sm-12" style="width: 100%">
				<div id="toolbar_projectList_gs" >
					<button type="button" class="btn btn-info" onClick="viewProjectDetail()">项目详情</button>
					<button type="button" class="btn btn-primary" onClick="projectSupplierMng()">项目供应商</button>
				</div>
				<table id="projectList_gs" class="table table-condensed" data-toolbar="#toolbar_projectList_gs"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
		
		<!-- 模态框（Modal）项目详情 -->
		<div class="modal fade" id="projectDetailModal" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="projectDetailModal" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="projectDetailModal_title"></h4>
		            </div>
		            <div class="modal-body" style="padding-bottom: 3px;">
		            	<form id="applyForm_gs" class="form-horizontal" role="form">
			            	<div class="panel panel-info">
							    <div class="panel-heading">
							        <h3 class="panel-title">项目信息</h3>
							    </div>
							    <div class="panel-body">
							       <div class="form-group">
										<label for="projectDetailModal_projectName" class="col-md-2 control-label"> 项目名称  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_projectName" readonly> 
										</div>
										<label for="projectDetailModal_projectState" class="col-md-2 control-label"> 项目状态  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_projectState" readonly> 
										</div>
									</div>	
									<div class="form-group">
										<label for="projectDetailModal_projectType" class="col-md-2 control-label"> 项目类型  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_projectType" readonly> 
										</div>
										<label for="projectDetailModal_projectStep" class="col-md-2 control-label"> 项目进度  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_projectStep" readonly> 
										</div>
									</div>	
									<div class="form-group">
										<label for="projectDetailModal_projecDetail" class="col-md-2 control-label"> 项目简介  </label>
										<div class="col-md-10 data-validate">
											<textarea class="form-control" rows="3" cols="" id="projectDetailModal_projecDetail" readonly="readonly"></textarea>
										</div>
									</div>
							    </div>
							</div>
			            	<div class="panel panel-info">
							    <div class="panel-heading">
							        <h3 class="panel-title">负责人信息</h3>
							    </div>
							    <div class="panel-body">
							       <div class="form-group">
										<label for="projectDetailModal_person_name" class="col-md-2 control-label"> 姓名  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_person_name" readonly> 
										</div>
										<label for="projectDetailModal_person_sex" class="col-md-2 control-label"> 性别  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_person_sex" readonly> 
										</div>
									</div>	
									<div class="form-group">
										<label for="projectDetailModal_person_birthday" class="col-md-2 control-label"> 出生年月  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_person_birthday" readonly> 
										</div>
										<label for="projectDetailModal_person_phone" class="col-md-2 control-label"> 电话  </label>
										<div class="col-md-4 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_person_phone" readonly> 
										</div>
									</div>	
									<div class="form-group">
										<label for="projectDetailModal_person_email" class="col-md-2 control-label"> 邮箱  </label>
										<div class="col-md-10 data-validate">
											<input type="text" class="form-control" id="projectDetailModal_person_email" readonly> 
										</div>
									</div>	
							    </div>
							</div>
						</form>
		            </div>
		            <div class="modal-footer" >
		            	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!-- 模态框（Modal）项目供应商详情 -->
		<div class="modal fade" id="projectSupplierModal" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="projectSupplierModal" aria-hidden="true">
		    <div class="modal-dialog" style="width: 80%">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="projectSupplierModal_title"></h4>
		            </div>
		            <div class="modal-body" style="padding-bottom: 3px;">
		            	<div class="row" style="margin-top: 3px">
							<div class="col-sm-12" style="width: 100%">
								<div id="toolbar_projectSupplierList_gs" >
									<button type="button" class="btn btn-success" onClick="initProjectNotOwnSuppliersTable()">新增供应商</button>
									<button type="button" class="btn btn-danger" onClick="removeProjectSupplier()">删除供应商</button>
								</div>
								<table id="projectSupplierList_gs" class="table table-condensed" data-toolbar="#toolbar_projectSupplierList_gs"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
									<thead style="background-color: #87CEFF"></thead>
								</table>
							</div>
						</div>
		            </div>
		            <div class="modal-footer" >
		            	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!-- 模态框（Modal）新增供应商 -->
		<div class="modal fade" id="addProjectSupplierModal" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="projectSupplierModal" aria-hidden="true">
		    <div class="modal-dialog" style="width: 80%">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="">添加供应商</h4>
		            </div>
		            <div class="modal-body" style="padding-bottom: 3px;">
		            	<div class="row" style="margin-top: 3px">
							<div class="col-sm-12" style="width: 100%">
								<table id="addProjectSupplierModal_table" class="table table-condensed" data-toolbar="" data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
									<thead style="background-color: #87CEFF"></thead>
								</table>
							</div>
						</div>
		            </div>
		            <div class="modal-footer" >
		            	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            	<button type="button" class="btn btn-success" onclick="addProjectSuppliers()">确认添加</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>		
		
	</div>
</body>
</html>