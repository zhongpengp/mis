<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商审批——公司</title>
<script type="text/javascript">
	$(function(){
		initApprovalSupplierApplyFromGS_Table();
	});
	
	function initApprovalSupplierApplyFromGS_Table(){
		$("#approvalSupplierApplyFromGS_Table").bootstrapTable("destroy");
		$("#approvalSupplierApplyFromGS_Table").bootstrapTable({
			url: '<%=path%>/supplierController/getApprovalSupplierApplyFromGS',
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
			    data.supplierID='<%=userID %>';
				return data;
			},
			onLoadSuccess:function(data){
			},
			columns : [
				{field : 'check_box', checkbox : true},
				{field : 'apply_state',title:'审批状态',visible : true,
					formatter:function(value,row,index){
						if(value==1){
							return '<font color="orange">待审批</font>';
						}else if(value==2){
							return '<font color="green">已通过</font>';
						}else if(value==3){
							return '<font color="red">未通过</font><a href="#" onclick="reApproval(\''+row.company_id+'\')">(点我通过)</a>';
						}
					}
				},
				{field : 'company_name',title:'公司名称',visible : true},
				{field : 'company_desc',title:'公司描述',visible : true},
				{field : 'user_name',title:'联系人',visible : true},
				{field : 'user_phone',title:'联系电话',visible : true},
				{field : 'user_email',title:'联系邮箱',visible : true},
		]
		});
	}
	
	function passApproval(){
		var approvalSupplierApplyFromGS_Table_selecteds = $("#approvalSupplierApplyFromGS_Table").bootstrapTable('getSelections');
		if(approvalSupplierApplyFromGS_Table_selecteds.length==0){
			alert_danger("合作审批","请先选择要进行审批的公司！");
		}else{
			var dialogInstance = BootstrapDialog.show({
				title:'合作审批',
				type:'type-warning',
				closable:false,
				message:'您即将通过所选公司的供应商合作申请，通过后将无法撤销，是否确认通过审批？！',
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
						 cssClass:'btn-success',
						 autospan:true,
						 action:function(dialog){
							 dialog.enableButtons(false);
							 dialog.setClosable(false);
							 var companyIDs = '';
								$(approvalSupplierApplyFromGS_Table_selecteds).each(function(index,value){
									if(index==approvalSupplierApplyFromGS_Table_selecteds.length-1){
										companyIDs+=value.company_id;
									}else{
										companyIDs+=value.company_id+',';
									}
								});
							 $.ajax({
								url:'<%=path%>/supplierController/passCompanySupplierApproval',
								data:{
									supplierID:'<%=userID%>',
									companyIDs:companyIDs
								},
								success:function(){
									dialogInstance.close();
									alert_success("合作审批","审批成功！");
									initApprovalSupplierApplyFromGS_Table();
								},
								error:function(){
									dialogInstance.close();
									alert_danger("合作审批","审批失败，请重试！");
								}
							});
							
						 }
					}
					
				]
			});
		}
	}
	
	function reApproval(company_id){
		var dialogInstance = BootstrapDialog.show({
			title:'合作审批',
			type:'type-warning',
			closable:false,
			message:'您即将通过所选公司的供应商合作申请，通过后将无法撤销，是否确认通过审批？！',
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
					 cssClass:'btn-success',
					 autospan:true,
					 action:function(dialog){
						 dialog.enableButtons(false);
						 dialog.setClosable(false);
						 $.ajax({
							url:'<%=path%>/supplierController/passCompanySupplierApproval',
							data:{
								supplierID:'<%=userID%>',
								companyIDs:company_id
							},
							success:function(){
								dialogInstance.close();
								alert_success("合作审批","审批成功！");
								initApprovalSupplierApplyFromGS_Table();
							},
							error:function(){
								dialogInstance.close();
								alert_danger("合作审批","审批失败，请重试！");
							}
						});
						
					 }
				}
				
			]
		});
	}
	
	function notPassApproval(){
		var approvalSupplierApplyFromGS_Table_selecteds = $("#approvalSupplierApplyFromGS_Table").bootstrapTable('getSelections');
		if(approvalSupplierApplyFromGS_Table_selecteds.length==0){
			alert_danger("合作审批","请先选择要进行审批的公司！");
		}else{
			var dialogInstance = BootstrapDialog.show({
				title:'合作审批',
				type:'type-warning',
				closable:false,
				message:'您即将拒绝所选公司的供应商合作申请，是否确认拒绝审批？！',
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
							 var companyIDs = '';
								$(approvalSupplierApplyFromGS_Table_selecteds).each(function(index,value){
									if(index==approvalSupplierApplyFromGS_Table_selecteds.length-1){
										companyIDs+=value.company_id;
									}else{
										companyIDs+=value.company_id+',';
									}
								});
							 $.ajax({
								url:'<%=path%>/supplierController/notPassCompanySupplierApproval',
								data:{
									supplierID:'<%=userID%>',
									companyIDs:companyIDs
								},
								success:function(){
									dialogInstance.close();
									alert_success("合作审批","审批成功！");
									initApprovalSupplierApplyFromGS_Table();
								},
								error:function(){
									dialogInstance.close();
									alert_danger("合作审批","审批失败，请重试！");
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
						<li>    合作审批</li>  
						<li class="active">公司审批</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 3px">
			<div class="col-sm-12" style="width: 100%">
				<div id="approvalSupplierApplyFromGS_Table_Toolbar" >
					<button type="button" class="btn btn-success" onClick="passApproval()">通过审批</button>
					<button type="button" class="btn btn-danger" onClick="notPassApproval()">不通过审批</button>
				</div>
				<table id="approvalSupplierApplyFromGS_Table" class="table table-condensed" data-toolbar="#approvalSupplierApplyFromGS_Table_Toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>