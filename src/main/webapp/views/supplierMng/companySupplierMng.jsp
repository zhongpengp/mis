<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司供应商管理</title>
<script type="text/javascript">
	$(function(){
		initCompanySupplierTable();
	});
	
	function initCompanySupplierTable(){
		$("#companySupplierTable").bootstrapTable("destroy");
		$("#companySupplierTable").bootstrapTable({
			url: '<%=path%>/supplierController/getCompanySuppliers',
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
	        //strictSearch: true,
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
							url:'<%=path%>/supplierController/reReplyCompanySuppliersByID',
							data:{
								companyID:'<%=userID%>',
								supplierID:supplier_ID
							},
							success:function(){
								dialogInstance.close();
								alert_success("添加供应商","重新申请供应商成功！请等待供应商审核。");
								initCompanySupplierTable();
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
	
	function addSupplier(){
		var addCompanySupplierModal_table_selecteds = $("#addCompanySupplierModal_table").bootstrapTable('getSelections');
		if(addCompanySupplierModal_table_selecteds.length==0){
			alert_danger("添加供应商","请先选择要添加的供应商！");
		}else{
			var supplier_IDs = '';
			$(addCompanySupplierModal_table_selecteds).each(function(index,value){
				if(index==addCompanySupplierModal_table_selecteds.length-1){
					supplier_IDs+=value.supplier_ID;
				}else{
					supplier_IDs+=value.supplier_ID+',';
				}
			});
			$.ajax({
				url:'<%=path%>/supplierController/addCompanySuppliersByIDs',
				data:{
					companyID:'<%=userID%>',
					supplierIDs:supplier_IDs
				},
				success:function(){
					$("#addCompanySupplierModal").modal('hide');
					alert_success("添加供应商","添加供应商成功！请等待供应商审核。");
					initCompanySupplierTable();
				},
				error:function(){
					alert_danger("添加供应商","添加供应商失败，请重试！");
				}
			});
			
		}
	}
	
	function initCompanyNotOwnSuppliersTable(){
		$("#addCompanySupplierModal_table").bootstrapTable("destroy");
		$("#addCompanySupplierModal_table").bootstrapTable({
			url: '<%=path%>/supplierController/getCompanyNotOwnerSuppliers',
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
	        //strictSearch: true,
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
				$("#addCompanySupplierModal").modal('show');
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
	
	function deleteSupplier(){
		var companySupplierTable_selecteds = $("#companySupplierTable").bootstrapTable('getSelections');
		if(companySupplierTable_selecteds.length==0){
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
								$(companySupplierTable_selecteds).each(function(index,value){
									if(index==companySupplierTable_selecteds.length-1){
										supplier_IDs+=value.supplier_ID;
									}else{
										supplier_IDs+=value.supplier_ID+',';
									}
								});
							 $.ajax({
								url:'<%=path%>/supplierController/removeCompanySuppliersByID',
								data:{
									companyID:'<%=userID%>',
									supplierIDs:supplier_IDs
								},
								success:function(){
									dialogInstance.close();
									alert_success("移除供应商","移除供应商成功！");
									initCompanySupplierTable();
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
</script>
</head>
<body>
	<div class="container" style="margin: 0 0 0 0 ;width: 100%;">
		<div class="page-content-wrapper">
			<div class="page-content-wrapper">
				<div id=page_title>
					<ul class="breadcrumb" style="margin-bottom:0;">   
						<li>    供应商管理</li>  
						<li class="active">我的供应商</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 3px">
			<div class="col-sm-12" style="width: 100%">
				<div id="toolbar_companySupplierTable" >
					<button type="button" class="btn btn-success" onClick="initCompanyNotOwnSuppliersTable()">添加供应商</button>
					<button type="button" class="btn btn-danger" onClick="deleteSupplier()">移除供应商</button>
				</div>
				<table id="companySupplierTable" class="table table-condensed" data-toolbar="#toolbar_companySupplierTable"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
		
		<!-- 模态框（Modal）新增供应商 -->
		<div class="modal fade" id="addCompanySupplierModal" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="projectSupplierModal" aria-hidden="true">
		    <div class="modal-dialog" style="width: 80%">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="">添加供应商</h4>
		            </div>
		            <div class="modal-body" style="padding-bottom: 3px;">
		            	<div class="row" style="margin-top: 3px">
							<div class="col-sm-12" style="width: 100%">
								<table id="addCompanySupplierModal_table" class="table table-condensed" data-toolbar="" data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
									<thead style="background-color: #87CEFF"></thead>
								</table>
							</div>
						</div>
		            </div>
		            <div class="modal-footer" >
		            	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            	<button type="button" class="btn btn-success" onclick="addSupplier()">确认添加</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>		
	</div>
</body>
</html>