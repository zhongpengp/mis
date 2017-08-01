<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>设备查询</title>
<script type="text/javascript"> 
var userID = '<%=request.getSession().getAttribute("userID")%>';
var userType = '<%=request.getSession().getAttribute("userType")%>';
    $(document).ready(function () {
    	
    	getProjectInfo();
        //点击查询后重新加载dataTable的数据
        $("#query").click(function() {
        	$('#tableD').bootstrapTable('destroy');
        	bootStrapTableInit();
        });
       	 
    	$('#addModal').on('hidden.bs.modal', function (e) {
            $('#tableD').bootstrapTable('refresh');
        });
    	
       $("#queryReset").click(function() {  
           //赋空值
           	$('#body').val("");
			$('#begintimequery').val("");
			$('#endtimequery').val("");
			$('.form_datetime').datetimepicker('setStartDate', null);
   		    $('.form_datetime').datetimepicker('setEndDate', null);
       });
       
       $("#begintimequery").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
  		$("#endtimequery").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
  		$('#begintimequery').datetimepicker().on('changeDate', function(ev){
  			$('#endtimequery').datetimepicker('setStartDate',$("#begintimequery").val());
  		});
  		$('#endtimequery').datetimepicker().on('changeDate', function(ev){
  			$('#begintimequery').datetimepicker('setEndDate',$("#endtimequery").val());
  		});
    });
    
	function bootStrapTableInit() {
		$('#tableD').bootstrapTable({
			url: '<%=path%>/apply/listNewMachineApproval.do',
            method: 'get',
            //toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: true,      //是否启用排序
            //pageNumber:1,      //初始化加载第一页，默认第一页
            sortName:'applyDate',
            sortOrder:'desc',
            pageSize: 10,      //每页的记录行数（*）
            pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
            queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
            //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
            sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
            //search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            ////strictSearch: true,
            //showColumns: true,     //是否显示所有的列
            //showRefresh: true,     //是否显示刷新按钮
            //minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            queryParams : function(data) {
            	data.body = $('#body').val();
			    data.startTime=$('#begintimequery').val();
			    data.endTime=$('#endtimequery').val();
			    data.state = $('input:radio:checked').val();
			    data.projectID = $('#projectId option:selected').val();
			    data.userID = userID;
				return data;
			},
			onDblClickRow : function(row,$element,field) {
				initsubTable(row.applyID);
				$('#detailModal').modal('toggle');
			},
			columns : [{field : 'check_box', checkbox : true},
					   {field : 'applyID', visible : false},
					   {field : 'applyState', title : '审批状态', align: 'center',
						   formatter: function(value,row,index){
							   if(value=="0"){
									return "<span style='color:#EE0000'>待审批</span>"
							   }else if(value=="1"){
								   return "<span style='color:green'>已通过</span>";
							   }else{
								   return "<span style='color:#7A378B'>已拒绝</span>";
							   }
						   }	   
					   },
					   {field : 'projectId', title : '项目名称', align: 'center'},
					   {field : 'applyUser', title : '申请人', align: 'center'},
					   {field : 'applyBody', title : '申请内容', align: 'center'},
					   {field : 'applyReason', title : '申请原因', align: 'center'},
					   {field : 'applyDate', title : '申请时间', align: 'center'},
					   {field : 'remark', title : '备注', align: 'center'},
					   {field : 'approvalDetail', title : '审批内容', align: 'center'},
					   {field : 'approvalDate', title : '审批时间', align: 'center'},
					   {field : 'applyFile', title : '操作', align: 'center',formatter:function(value,row,index){ 
						   if(row.applyFile!=null&&row.applyFile!=""){
								return '<a href="<%=path%>/FileDownload?filename='+row.applyFile+'">下载</a>';
							}else{
								return "无附件";
							}
					   }}
					]
        });
	}
	
	function openDetail(){
		$("#instanceListHintDiv").hide();
   	   	var selectobj = $('#tableD').bootstrapTable('getSelections');
  	   	var length =  selectobj.length;
        if (length == 1) {
        	initsubTable(selectobj[0].applyID);
			$('#detailModal').modal('toggle');
        } else if (length > 1){
     	   instanceList_Hint(1,"只能选择其中1条数据！");
        } else {
     	   instanceList_Hint(1,"当前没有被选中的数据！");
        }
	}
	
	function openAdd() {
		if($('input:radio:checked').val()!="0"){
			instanceList_Hint(1,"该申请已审批，请勿重复操作！");
			return false;
		}
		$("#instanceListHintDiv").hide();
   	   	var selectobj = $('#tableD').bootstrapTable('getSelections');
  	   	var length =  selectobj.length;
        if (length == 1) {
            setData(selectobj[0]);
			$('#approval').modal('toggle');
        } else if (length > 1){
     	   instanceList_Hint(1,"只能选择其中1条数据！");
        } else {
     	   instanceList_Hint(1,"当前没有被选中的数据！");
        }
		
	}
	
	function setData(data){
		$("#projectName").val(data.projectId);
		$("#applyUser").val(data.applyUser);
		$("#applyBody").val(data.applyBody);
		$("#applyReason").val(data.applyReason);
		$("#applyID").val(data.applyID);
	}
	
	function  addsave(){
		if ($('#checkForm').validate().form()){
			 var applyID = $("#applyID").val();
			 var state =$('#applyState option:selected').val();
			 var detail = $("#approvalDetail").val();
			 $.ajax({
		          url : "<%=path %>/projectController/updateMachineApproval.do",
		          data : {"applyID":applyID,"state":state,"detail":detail,"userID":userID},
		          type : "post",
		          success : function(data) {
		        	  $('#tableD').bootstrapTable('refresh');
		        	  closeAdd();
		              alert_success('【审批结果】','审批成功！');
		          },
		          error : function(request) {
		        	  alert_warning('【审批结果】','审批失败！');
		        	  closeAdd();
		          }
		      }); 
		}
	}
	
	
	function closeAdd(){
		$("#checkForm")[0].reset();
		$("#approval").modal("hide");
	}
	
	function instanceList_Hint(hintType,hintInfo){
		 messageCommonDiv(hintType, hintInfo, "instanceListBody","instanceListTitle","instanceListHintDiv");
	}
	//消息提醒
	 function messageCommonDiv(iStatus, messageBody, bodyspan, titleSpan, messageDiv) {
  	     $('#'+bodyspan).text(messageBody);
  	     if (iStatus == 0) {
  	         $('#'+titleSpan).text("成功：");
  	         $('#'+messageDiv).removeClass("alert-warning").addClass(
  	                 "alert-success");

  	     } else if (iStatus == 1) {
  	    	$('#'+titleSpan).text("警告：");
  	    	$('#'+messageDiv).removeClass("alert-success").addClass(
  	                 "alert-warning");
  	     } else {
  	     }
  	     $('#'+messageDiv).show();
  	 }

  	 function MessageCommonDivHide(messageDiv) {
  		 $('#'+messageDiv).hide();
  	 }
	//消息提醒结束
    function initsubTable(id){
    	$('#subtableD').bootstrapTable('destroy');
        $('#subtableD').bootstrapTable({
          	url: '<%=path%>/apply/listApplyDetail.do',
            method: 'get',
            //toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: false,      //是否启用排序
            //sortOrder: "asc",     //排序方式
            //pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize: 100,      //每页的记录行数（*）
            pageList: [10, 25, 50, 100,200],  //可供选择的每页的行数（*）
            queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
            //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
            sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
            //search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            //strictSearch: true,
            //showColumns: true,     //是否显示所有的列
            //showRefresh: true,     //是否显示刷新按钮
            //minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
		 	queryParams : function(data) {
			    data.applyID = id;
				return data;
			},
			columns : [
			           {field : 'machineName', title : '设备名称', align: 'center'},
					   {field : 'machineType', title : '设备型号', align: 'center'},
					   {field : 'machineSize', title : '设备规格', align: 'center'},
					   {field : 'machineNum', title : '设备数量', align: 'center'},
					   {field : 'unit', title : '计量单位', align: 'center'},
					   {field : 'producter', title : '生成厂家', align: 'center'},
					   {field : 'applyReason', title : '申购原因', align: 'center'}
					]
		});
    }
	
    function getProjectInfo(){
		$.ajax({
          url : "<%=path %>/file/getProjectByType.do",
          contentType : "application/json;charset=utf-8",
          data:{"userType":userType,"userID":userID}, 
       	  cache:false,
          success : function(data) {
        	  $("#projectId").empty();
        	  for (var i = 0; i < data.length; i++) {
       			  $("#projectId").append("<option value=" + data[i].projectId+ ">"+ data[i].projectName + "</option>");
              }
        	  $("#projectId").selectpicker('val', data[0].projectId);
              $('#projectId').selectpicker('refresh');
            //table加载
              bootStrapTableInit();
          },
          error : function(request) {
          }
      });
	}
</script>
</head>

<body>
	<div class="container" style="margin: 0 0 0 0 ;width: 100%;">
		<div class="page-content-wrapper">
		<ul class="breadcrumb" style="margin-bottom:0; font-size:12px;">  
			<li>  设备管理 </li>  
			<li class="active">设备申请</li>
		</ul>
			<div class="page-content">
				<div id="main" class="drmtable">
					<div class="tjsx_title">条件筛选：</div>
					<!-- message -->
					<div id="instanceListHintDiv" class="alert alert-success alert-dismissible" style="display: none" role="alert">
						<button type="button" onclick="MessageCommonDivHide('instanceListHintDiv')" class="close">
							<span>&times;</span><span class="sr-only">关闭</span>
						</button>
						<strong><span id="instanceListTitle"></span></strong> 
						<span id="instanceListBody"></span>
					</div>
					<!-- message -->
						 <div class="filtrate_box clearfix"  style="margin-bottom: 3px" >
						  <form class="form-horizontal" role="form">
						    <ul class="filtrate_list" >
						    	<li class="child_li first_sort" >
					      			<div class="form-group">
					      				<label for="projectId" class="col-sm-1 control-label">所属项目</label>
									    <div class="col-md-3">
											<select name=projectId id="projectId" class="selectpicker show-tick"> </select>
									  	</div>
					      			</div>
							     </li>	
						        <li class="child_li first_sort bac_bl" >
							        <div class="form-group">
					      				<label for="" class="col-sm-1 control-label">申请时间</label>
							            <div class="col-md-3">
											<input placeholder="开始时间" type="text" id="begintimequery" size="10" class="form-control form_datetime" name="begintimequery" readonly>
										</div>
							            <div class="col-md-3">
											<input placeholder="结束时间" type="text" id="endtimequery" size="10" class="form-control form_datetime" name="endtimequery" readonly>
										</div>  
							         </div>
						        </li>				      
						        <li class="child_li first_sort" >
					      			<div class="form-group">
					      				<label for="state" class="col-sm-1 control-label">审批状态</label>
									    <div class="col-md-4">
											<label class="checkbox-inline">
										    	<input type="radio" name="state" id="" value="0" checked>待审批
										  	</label>
										  	<label class="checkbox-inline">
										    	<input type="radio" name="state" id="" value="1">已通过
										  	</label>
										  	<label class="checkbox-inline">
										    	<input type="radio" name="state" id="" value="2">未通过
										  	</label>
									  	</div>
					      			</div>
							     </li>
						      
						     <li class="child_li first_sort bac_bl" >
						        <div class="form-group">
					      			<label for="body" class="col-sm-1 control-label">申请内容</label>
						           	<div class="col-md-3">
										<input type="text" placeholder="填写申请内容查询" class="form-control" name="body" id="body" >
									</div>
									<button id="query" type="button" class="btn btn-info">
									 查询 
									</button>										
									<button id="queryReset" type="button" class="btn btn-warning">
									 重置 
									</button>
						        </div>
						      </li>
						    </ul>
						  </form>  
						</div>
						<div class="col-md-12 text-left page-offset">
							<button type="button" class="btn btn-success"
									data-toggle="modal" onclick="openAdd()">申请审批</button>
							<button type="button" class="btn btn-info"
									data-toggle="modal" onclick="openDetail()">申请详情</button>		
						</div>
					
					<!-- Modal detail-->
					<div class="modal fade" id="detailModal" tabindex="-1" role="dialog"
						aria-labelledby="ApplyDetail" aria-hidden="true">
						<div class="modal-dialog" style="width: 880px">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="ApplyDetail">【申请详情】</h4>
								</div>
								<div id="detailBody" class="modal-body">
									<jsp:include page="applyDetail.jsp" />
								</div>
								 <div class="modal-footer">
									  <button type="button" class="btn btn-default"
									 	data-dismiss="modal">关闭</button>
								 </div>
							</div>
						</div>
					</div>
					<!-- Modal -->
					
					<!-- Modal approval-->
					<div class="modal fade" id="approval" tabindex="-1" role="dialog"
						aria-labelledby="newApproval" aria-hidden="true">
						<div class="modal-dialog" style="width: 880px">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="newApproval">【设备申请审批】</h4>
								</div>
								<div id="detailBody" class="modal-body">
									<jsp:include page="newMachineAppInfo.jsp" />
								</div>
								 <div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									 <button type="button" class="btn btn-primary" onclick="addsave()">保存</button>	
								 </div>
							</div>
						</div>
					</div>
					<!-- Modal -->
					
					<!-- table -->
					<div id="bodyFrame">
						<table id="tableD" data-click-to-select="true" class="table table-condensed">
							<thead style="background:#ace4ff;">
								<tr></tr>
							</thead>
						</table>
					</div>
					<!-- table -->
				</div>
			</div>
		</div>
	</div>
</body>

</html>