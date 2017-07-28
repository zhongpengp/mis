<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册审批——项目</title>
<style type="text/css">
	registerList_xm_searchForm .form-group{
		margin-bottom: 1px;
	}
	registerList_xm_searchForm .form-group label{
		margin-left:15px;
	}
</style>
<script type="text/javascript">
	$(function(){
		initTable_registerList_xm();
		
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
	
	function initTable_registerList_xm(){
		$("#registerList_xm").bootstrapTable("destroy");
		$("#registerList_xm").bootstrapTable({
			url: '<%=path%>/approvalRegisterController/getRegisterApplyList_xm',
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
	        queryParams:$("#registerList_xm_searchForm").serialize(),
			<%-- queryParams : function(data) {
			    data.teacherID='<%=userID%>'
				return data;
			}, --%>
			onLoadSuccess:function(data){
			},
			columns : [
				{field : 'applyStatue',title:'审批状态',visible : true,
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
				{field : 'projectName',title:'项目名称',visible : true},
				{field : 'projectType',title:'项目类型',visible : true},
				{field : 'applierName',title:'申请人姓名',visible : true},
				{field : 'idcardNum',title:'身份证号码',visible : true},
				{field : 'phoneNum',title:'联系电话',visible : true},
				{field : 'email',title:'联系邮箱',visible : true},
				{field : 'applyTime',title:'申请时间',visible : true,
					formatter:function(value,row,index){
						value = new Date(value);
						return value.format("yyyy-MM-dd");
					}
				},
				{field : 'projectDetail',title:'项目简介',visible : false},
				{field : 'applyIp',title:'申请IP',visible : true},
				{field : 'approvalDetail',title:'审批详情',visible : false},
		]
		});
	}
	
	function toApproval(applyID){
		$.ajax({
			url:'<%=path%>/approvalRegisterController/getXMApplyByID',
			data:{
				applyID:applyID
			},
			success:function(data){
				$("#projectName_approval").val(data.projectName);
				$("#applierName").val(data.applierName);
				$("#idcardNum").val(data.idcardNum);
				$("#phoneNum").val(data.phoneNum);
				$("#projectDetail").val(data.projectDetail);
				$("#email").val(data.email);
				$("#approvalDetail").val(data.approvalDetail);
				$("#applyState").prop(data.applyStatue);
				$("#applyId").val(data.applyId);
				$("#approval_xm").modal("show");
				$("#approvalDetail").val(data.approvalDetail);
			},
			error:function(){
				alert_danger("项目注册审批","获取项目注册信息失败，请稍后重试！");
			}
		});
	}
	
	function saveapproval_xm(){
		var applyID=$("#applyId").val();
		var applyStatue=$("#applyState").val();
		var applyapprovalDetailID=$("#approvalDetail").val();
		$.ajax({
			url:'<%=path%>/approvalRegisterController/approvalApply_xm',
			data:{
				applyID:applyID,
				applyState:applyStatue,
				approvalDetail:applyapprovalDetailID
			},
			success:function(){
				$("#approval_xm").modal("hide");
				alert_success("项目注册审批","审批成功");
				initTable_registerList_xm();
			},
			error:function(){
				alert_danger("项目注册审批","审批出现问题，请稍后重试！");
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
						<li class="active">项目审批</li>
					</ul>
				</div>
				<div class="page-content">
					<div id="main" class="drmtable">
						<div class="tjsx_title">条件筛选：</div>
						<div id="filter">
							<div class="filtrate_box clearfix" style="margin-bottom: 0">
								<form id="registerList_xm_searchForm" class="form-horizontal" role="form">
									<input type="text" name="companyID" value="<%=userID %>" style="display: none">
									<ul class="filtrate_list">
							      		<li class="child_li first_sort bac_bl" >
							      			<div class="form-group">
							      				<label for="approvalState" class="col-sm-1 control-label">审批状态</label>
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
								      		<div class="form-group" style="margin-top: 1px;">
											    <label for="applyDate" class="col-sm-1 control-label">申请日期</label>
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
								      		<div class="form-group">
											    <label for="projectName" class="col-sm-1 control-label">项目名称</label>
											    <div class="col-sm-3">
											      <input type="text" class="form-control" id="projectName" name="projectName" placeholder="请输入项目名称">
											    </div>
											    <div class="checkbox col-md-2" >
													<label style="padding-left: 0px;margin-left: 0px;">
													  <input type="checkbox" id="ifPrecise" name="projectName_jingque" value="1"> 精确查询
													</label>
												</div>
												<div class="col-sm-5" align="center">
													<button id="registerList_xm_searchFormQueryReset" type="button" class="btn btn-warning">重置</button>
													<button id="registerList_xm_searchFormQuery" type="button" class="btn btn-info" onclick="initTable_registerList_xm()">查询</button>
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
				<table id="registerList_xm" class="table table-condensed" data-toolbar="#toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="approval_xm" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">项目注册审批</h4>
		            </div>
		            <div class="modal-body" style="padding-bottom: 3px;">
		            	<form id="applyForm_gs" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="projectName_approval" class="col-md-2 control-label"> 项目名称  </label>
								<div class="col-md-10 data-validate">
									<input type="text" id="applyId" style="display: none">
									<input type="text" class="form-control" id="projectName_approval" name="projectName_approval" placeholder="填写项目名称"
										id="projectName_approval" readonly> 
								</div>
							</div>	
							
							<div class="form-group" id ="divAdd1">
								<label for="applierName" class="col-md-2 control-label"> 负责人 </label>
								<div class="col-md-10 data-validate">
									<input type="text" class="form-control" id="applierName" name="applierName" placeholder="填写申请人的中文名"
										id="applierName" readonly>
								</div>
							</div>	
							<div class="form-group" id ="divAdd2">
								<label for="idcardNum" class="col-md-2 control-label"> 身份证号 </label>
								<div class="col-md-10 data-validate">
									<input type="text" class="form-control" id="idcardNum" name="idcardNum" placeholder="填写申请人身份证号"
										id="idcardNum" readonly>
								</div>
							</div>
							
							<div class="form-group" id ="divAdd3">
								<label for="phoneNum" class="col-md-2 control-label"> 联系电话 </label>
								<div class="col-md-10 data-validate">
									<input type="text" id="phoneNum"  name="phoneNum"  placeholder="填写申请人联系电话" class="form-control" readonly>
								</div>
							</div>
							
							<div class="form-group" id ="divAdd3">
								<label for="email" class="col-md-2 control-label"> 邮箱 </label>
								<div class="col-md-10 data-validate">
									<input type="text" name="email" id="email" placeholder="填写申请人邮箱" class="form-control" readonly>
								</div>
							</div>
							
							
							<div class="form-group" id ="divAdd4">
								<label for="projectDetail" class="col-md-2 control-label"> 项目描述 </label>
								<div class="col-md-10 data-validate">
									<textarea name="projectDetail" id="projectDetail" rows="3"  placeholder="填写申请的项目描述" class="form-control" readonly></textarea>
								</div>
							</div>
							
							<div class="form-group" id ="">
								<label for="name"class="col-md-2 control-label">审批操作</label>
								<div class="col-md-10">
								    <select name="applyState" id="applyState" >
								      <option value="2">通过</option>
								      <option value="3">不通过</option>
								    </select>
								</div>
							</div>
							
							<div class="form-group" id ="divAdd4">
								<label for="approvalDetail" class="col-md-2 control-label"> 审批意见 </label>
								<div class="col-md-10 data-validate">
									<textarea name="approvalDetail" id="approvalDetail" rows="3" class="form-control"></textarea>
								</div>
							</div>
							
							<div class="form-group" align="center">
								<button type="reset" class="btn btn-default">重置</button>
								<button type="button" class="btn btn-primary" onclick="saveapproval_xm()">提交</button>
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