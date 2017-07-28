<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册审批——供应商</title>
<style type="text/css">
	registerList_gys_searchForm .form-group{
		margin-bottom: 1px;
	}
	registerList_gys_searchForm .form-group label{
		margin-left:15px;
	}
</style>
<script type="text/javascript">
	$(function(){
		initTable_registerList_gys();
		
		$("#applyState").select2({
			  placeholder: "请选择",
			  minimumResultsForSearch: Infinity
		});
		$("#applyDate1").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
		$("#applyDate2").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
		$('#applyDate1').datetimepicker().on('changeDate', function(ev){
			$('#applyDate2').datetimepicker('setStartDate',$("#applyDate1").val());
		});
		$('#applyDate2').datetimepicker().on('changeDate', function(ev){
			$('#applyDate1').datetimepicker('setEndDate',$("#applyDate2").val());
		});
	});
	
	function initTable_registerList_gys(){
		$("#registerList_gys").bootstrapTable("destroy");
		$("#registerList_gys").bootstrapTable({
			url: '<%=path%>/approvalRegisterController/getRegisterApplyList_gys',
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
	        queryParams:$("#registerList_gys_searchForm").serialize(),
			<%-- queryParams : function(data) {
			    data.teacherID='<%=userID%>'
				return data;
			}, --%>
			onLoadSuccess:function(data){
			},
			columns : [
				{field : 'applyState',title:'审批状态',visible : true,
					formatter:function(value,row,index){
						if(value=="1"){
							return '<a href="#" onclick="toApproval(\''+row.applyId+'\')"><font color="#EE7621">待审批</font></a>';
						}else if(value=="2"){
							return '<font color="green">审批通过</font>';
						}else if(value=="3"){
							return '<font color="red">审批未通过</font>';
						}
					}
				},
				{field : 'applyName',title:'供应商名称',visible : true},
				{field : 'applyUserName',title:'申请人姓名',visible : true},
				{field : 'applyUserIdnum',title:'身份证号码',visible : true},
				{field : 'applyUserPhone',title:'联系电话',visible : true},
				{field : 'applyUserEmail',title:'联系邮箱',visible : true},
				{field : 'applyDate',title:'申请时间',visible : true,
					formatter:function(value,row,index){
						value = new Date(value);
						return value.format("yyyy-MM-dd");
					}
				},
				{field : 'applyDesc',title:'供应商简介',visible : false},
				{field : 'applyIp',title:'申请IP',visible : true},
				{field : 'replyDetail',title:'审批详情',visible : false},
		]
		});
	}
	
	function toApproval(applyID){
		$.ajax({
			url:'<%=path%>/approvalRegisterController/getGYSApplyByID',
			data:{
				applyID:applyID
			},
			success:function(data){
				$("#applyName").val(data.applyName);
				$("#applyUserName").val(data.applyUserName);
				$("#applyUserIdnum").val(data.applyUserIdnum);
				$("#applyUserPhone").val(data.applyUserPhone);
				$("#applyDesc").val(data.applyDesc);
				$("#applyUserEmail").val(data.applyUserEmail);
				$("#replyDetail").val(data.replyDetail);
				$("#applyState").prop(data.applyState);
				$("#applyId").val(data.applyId);
				$("#approval_gys").modal("show");
				$("#replyDetail").val(data.replyDetail);
			},
			error:function(){
				alert_danger("供应商注册审批","获取供应商注册信息失败，请稍后重试！");
			}
		});
	}
	
	function saveapproval_gys(){
		var applyID=$("#applyId").val();
		var applyState=$("#applyState").val();
		var applyreplyDetailID=$("#replyDetail").val();
		$.ajax({
			url:'<%=path%>/approvalRegisterController/approvalApply_gys',
			data:{
				applyID:applyID,
				applyState:applyState,
				replyDetail:applyreplyDetailID
			},
			success:function(){
				$("#approval_gys").modal("hide");
				alert_success("供应商注册审批","审批成功");
				initTable_registerList_gys();
			},
			error:function(){
				alert_danger("供应商注册审批","审批出现问题，请稍后重试！");
			}
		});
	}
</script>
</head>
<body>
	<div class="container" style="margin: 0 0 0 0 ;width: 100%;">
		<div class="page-content-wrapper">
			<div class="page-content-wrapper">
				<div id=page_title>
					<ul class="breadcrumb" style="margin-bottom:0;">   
						<li>    注册审批</li>  
						<li class="active">供应商审批</li>
					</ul>
				</div>
				<div class="page-content">
					<div id="main" class="drmtable">
						<div class="tjsx_title">条件筛选：</div>
						<div id="filter">
							<div class="filtrate_box clearfix" style="margin-bottom: 0">
								<form id="registerList_gys_searchForm" class="form-horizontal" role="form">
									<ul class="filtrate_list">
							      		<li class="child_li first_sort bac_bl" >
							      			<div class="form-group" style="margin-bottom: 3px">
							      				<label for="approvalState" class="col-sm-2 control-label">审批状态</label>
											    <div class="col-md-4">
													<label class="checkbox-inline">
												    	<input type="radio" name="approvalState" id="" value="1">待审批
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="approvalState" id="" value="2">审批通过
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="approvalState" id="" value="3">审批未通过
												  	</label>
											  	</div>
							      			</div>
							      		</li>
							      		<li class="child_li first_sort " >
								      		<div class="form-group" style="margin-top: 1px;margin-bottom: 3px;">
											    <label for="applyDate" class="col-sm-2 control-label">申请日期</label>
											    <div class="col-sm-4">
											    	<div class="col-sm-5" style="padding: 0">
												      <input placeholder="开始时间" type="text" id="applyDate1"  class="form-control form_datetime" name="applyDate1" readonly>
											    	</div>
											    	<label for="" class="col-sm-1 control-label" style="padding-right: 21px;margin-left: 0px;">~</label>
											    	<div class="col-sm-5"style="padding: 0">
												      <input placeholder="结束时间" type="text" id="applyDate2"  class="form-control form_datetime" name="applyDate2" readonly>
											    	</div>
											    </div>
										   </div>
							      		</li>
							      		<li class="child_li first_sort bac_bl" >
								      		<div class="form-group" style="margin-bottom: 3px;">
											    <label for="supplierName" class="col-sm-2 control-label">供应商名称</label>
											    <div class="col-sm-3">
											      <input type="text" class="form-control" id="supplierName" name="supplierName" placeholder="请输入供应商名称">
											    </div>
											    <div class="checkbox col-md-2" >
													<label style="padding-left: 0px;margin-left: 0px;">
													  <input type="checkbox" id="ifPrecise" name="supplierName_jingque" value="1"> 精确查询
													</label>
												</div>
												<div class="col-sm-5" align="center">
													<button id="registerList_gys_searchFormQueryReset" type="button" class="btn btn-warning">重置</button>
													<button id="registerList_gys_searchFormQuery" type="button" class="btn btn-info" onclick="initTable_registerList_gys()">查询</button>
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
				<div id="toolbar" class="btn-group">
					<div align="center"><font id="tableTitle" style="font-size: large;font-weight: bold;"></font></div>
				</div>
				<table id="registerList_gys" class="table table-condensed" data-toolbar="#toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="approval_gys" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">供应商注册审批</h4>
		            </div>
		            <div class="modal-body" style="padding-bottom: 3px;">
		            	<form id="applyForm_gys" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="applyName" class="col-md-3 control-label"> 供应商名称  </label>
								<div class="col-md-9 data-validate">
									<input type="text" id="applyId" style="display: none">
									<input type="text" class="form-control" id="applyName" name="applyName" placeholder="填写供应商名称"
										id="applyName" readonly> 
								</div>
							</div>	
							
							<div class="form-group" id ="divAdd1">
								<label for="applyUserName" class="col-md-3 control-label"> 负责人 </label>
								<div class="col-md-9 data-validate">
									<input type="text" class="form-control" id="applyUserName" name="applyUserName" placeholder="填写申请人的中文名"
										id="applyUserName" readonly>
								</div>
							</div>	
							<div class="form-group" id ="divAdd2">
								<label for="applyUserIdnum" class="col-md-3 control-label"> 身份证号 </label>
								<div class="col-md-9 data-validate">
									<input type="text" class="form-control" id="applyUserIdnum" name="applyUserIdnum" placeholder="填写申请人身份证号"
										id="applyUserIdnum" readonly>
								</div>
							</div>
							
							<div class="form-group" id ="divAdd3">
								<label for="applyUserPhone" class="col-md-3 control-label"> 联系电话 </label>
								<div class="col-md-9 data-validate">
									<input type="text" id="applyUserPhone"  name="applyUserPhone"  placeholder="填写申请人联系电话" class="form-control" readonly>
								</div>
							</div>
							
							<div class="form-group" id ="divAdd3">
								<label for="applyUserEmail" class="col-md-3 control-label"> 邮箱 </label>
								<div class="col-md-9 data-validate">
									<input type="text" name="applyUserEmail" id="applyUserEmail" placeholder="填写申请人邮箱" class="form-control" readonly>
								</div>
							</div>
							
							
							<div class="form-group" id ="divAdd4">
								<label for="applyDesc" class="col-md-3 control-label"> 供应商描述 </label>
								<div class="col-md-9 data-validate">
									<textarea name="applyDesc" id="applyDesc" rows="3"  placeholder="填写申请的供应商描述" class="form-control" readonly></textarea>
								</div>
							</div>
							
							<div class="form-group" id ="">
								<label for="name"class="col-md-3 control-label">审批操作</label>
								<div class="col-md-9">
								    <select name="applyState" id="applyState" >
								      <option value="2">通过</option>
								      <option value="3">不通过</option>
								    </select>
								</div>
							</div>
							
							<div class="form-group" id ="divAdd4">
								<label for="replyDetail" class="col-md-3 control-label"> 审批意见 </label>
								<div class="col-md-9 data-validate">
									<textarea name="replyDetail" id="replyDetail" rows="3" class="form-control"></textarea>
								</div>
							</div>
							
							<div class="form-group" align="center">
								<button type="reset" class="btn btn-default">重置</button>
								<button type="button" class="btn btn-primary" onclick="saveapproval_gys()">提交</button>
							</div>
						</form>
		            </div>
		            <div class="modal-footer" >
		            	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
	</div>
</body>
</html>