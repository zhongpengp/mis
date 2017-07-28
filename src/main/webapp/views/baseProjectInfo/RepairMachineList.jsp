<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>待维修设备列表</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/showDialog.css">
<script type="text/javascript" src="<%=path %>/js/showDialog.js"></script>
<script type="text/javascript">
	var userType = '<%=request.getSession().getAttribute("userType")%>';
	var userID = '<%=request.getSession().getAttribute("userID")%>';
    $(document).ready(function () {   		
        $("#query").click(function() {
        	$('#tableD').bootstrapTable('destroy');
        	bootStrapTableInit();
        });
        //table加载
        bootStrapTableInit();
       
    });
    
	function bootStrapTableInit() {
		var state = $('input:radio:checked').val();
		$('#tableD').bootstrapTable('destroy');
		var url = '<%=path%>/projectController/getUnRepairList.do';
		if(state=='1'){			
			url = '<%=path%>/projectController/getRepairedList.do';
		}
        //页面加载时初始化dataTable
        $('#tableD').bootstrapTable({
        	url:url,
			method: 'get',
			 //toolbar: '#toolbar',    //工具按钮用哪个容器
		       striped: true,      //是否显示行间隔色
		       cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		       pagination: true,     //是否显示分页（*）
		       maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
		       //sortable: false,      //是否启用排序
		       //sortOrder: "asc",     //排序方式
		       //sortName:'studentCode',
		       pageNumber:1,      //初始化加载第一页，默认第一页
		       pageSize:10,
		       pageList: [10, 20, 30, 50],  //可供选择的每页的行数（*）
		       queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
		                           // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
		       //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
		       sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
		       search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		       //showColumns: true,     //是否显示所有的列
		       //showRefresh: true,     //是否显示刷新按钮
		       clickToSelect: true,    //是否启用点击选中行
		       showExport:true,
		       exportTypes:['excel', 'doc',  'pdf', 'png', 'xml', 'csv', 'txt', 'sql','json'],
		 	queryParams : function(data) {
		 		data.projectId = userID;
		 		data.macState = state;
		 		data.macName = $('#macName').val();
				return data;
			},
			
			onLoadSuccess : function(data) {
			},
			onLoadError : function(data) {
			},
			
			columns : [{field : 'check_box', checkbox : true},				  
					   {field : 'machineId', visible : false},
					   {field : 'machineName', title : '设备名称', align: 'center'},
					   {field : 'producer', title : '生产厂家', align: 'center'},
					   {field : 'gyxName', title : '供应商', align: 'center'},
					   {field : 'machineState', title : '设备状态', align: 'center',
						   formatter:function(value,row,index){
							   if($("#old").prop('checked')){
								   return "已维修";
							   }else{
								   return "待维修";
							   }
						   } 
					   },
					   {field : 'repairDate', title : '维修日期', align: 'center'},
					   {field : 'zhibaoqi', title : '质保期', align: 'center',
				   		   formatter:function(value,row,index){
							   return value.substring(0,10);
						   } 	
					   },
					   {field : "issue", title : '问题描述', align:'center'},
					   {field : 'repairUnit', title:'维修单位',align: 'center'},
					   {field : 'repairCost', title : '维修花费',align:'center'},					   
					   {field : "repairBody", title : '维修内容', align:'center'}					   
					]
		});
	}
	
	function seeDetail() {
		if($("#old").prop('checked')){
			instanceList_Hint(1,"已维修数据仅提供查看！");
			return false;
		}	
		$("#instanceListHintDiv").hide();
   	   	var selectobj = $('#tableD').bootstrapTable('getSelections');
  	   	var length =  selectobj.length;
        if (length == 1) {
        	setData(selectobj[0]);
			$('#addModal').modal('toggle');
        } else if (length > 1){
     	   instanceList_Hint(1,"只能选择其中1条数据操作！");
        } else {
     	   instanceList_Hint(1,"当前没有被选中的数据！");
        }
	}
	
	function setData(data){
		$("#projectId").val(data.projectId);
		$("#machineId").val(data.machineId);
		$("#machineName").val(data.machineName);
		$("#producer").val(data.producer);
		$("#gyxName").val(data.gyxName);
		$("#zhibaoqi").val(data.zhibaoqi);
	}
	
	function addsave(){
		 if ($('#checkForm').validate().form()){
			 $.ajax({
		          url : "<%=path %>/projectController/inserRepairMachine.do",
		          data : $('#checkForm').serialize(),
		          type : "post",
		          success : function(data) {
		        	  alert_success('【维修信息】','修改成功！');
		        	  bootStrapTableInit();
		              closeAdd();
		          },
		          error : function(request) {
		        	  alert_warning('【维修信息】','修改失败！');
		        	  closeAdd();
		          }
		      }); 
		}
	}
	
	function closeAdd(){
		$("#checkForm")[0].reset();
		$("#checkForm").data('bootstrapValidator').resetForm();
		$("#addModal").modal("hide");
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
	
  	 function destroy(){
  		if($("#old").prop('checked')){
			instanceList_Hint(1,"已维修数据仅提供查看！");
			return false;
		}	
  		var selectRow=$('#tableD').bootstrapTable('getSelections');
  	   	var length =  selectRow.length;
  	  	g_paramIDs='';
        if (length > 0){
        	$(selectRow).each(function(index,value){
        		if(index==length-1){
        			g_paramIDs+=value.machineId;
        		}else{
        			g_paramIDs+=value.machineId+",";
        		}
        	});
  		 showConfirm('【删除数据】', '请确认是否要删除所选择的数据？此项操作不可恢复！', function(){
   		   $.ajax({
                  url: "<%=path%>/projectController/machineDestroy.do",
                  data: { 'ids': g_paramIDs},
                  type: "post",
                  success: function(data) {
               	   if(data=='success') {
               		   $('#tableD').bootstrapTable('refresh',{silent: true});
               		   showConfirm('【删除数据】', '删除成功！', function(){
               		  });
               		}
               	   else instanceList_Hint(1,"删除设备失败！");
                  },
                  error: function(request) {
                	  instanceList_Hint(1,"删除设备出错！");
                  }
         	   });
   	   });
       }else {
     	   instanceList_Hint(1,"当前没有被选中的数据！");
       }	 
  	    
  	 }
	
</script>

</head>

<body>
		<div class="content">
		<div class="page-content-wrapper" style="margin-left:15px;">
			<div id=page_title>
				<ul class="breadcrumb" style="margin-bottom:0;">   
					<li>设备管理</li>  
					<li class="active">维修信息</li>
				</ul>
			</div>
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
				    <ul class="filtrate_list" >
				       <li class="child_li first_sort bac_bl" >
					        <div class="list_left">设备状态：</div>
					        <div class="list_right" style="width:880px; margin-top:7px;">
								<label class="checkbox-inline">
							    	<input type="radio" name="state" id="" value="0" checked>待维修
							  	</label>
							  	<label class="checkbox-inline">
							    	<input type="radio" name="state" id="old" value="1">已维修
							  	</label>
						  	</div>
				      </li> 					      
				      <li class="child_li first_sort" >
				        <div class="list_left">设备名称：</div>
				        <div class="list_right  mig_top" style="width:880px;padding-bottom:6px;">
				          <div class="list_content fix_list">
				           	<div class="col-md-3">
								<input type="text" class="form-control" id="macName" placeholder="设备名称模糊查询">
							</div>
							<div class="col-md-3">
								<button id="query" type="button" class="btn btn-primary">查询</button>	  
							</div>
				          </div>
				        </div>
				      </li>
				    </ul>
				</div>
							
				<div class="row">
					<div class="col-sm-12" style="width: 100%">
						<div id="toolbar" class="btn-group">
							<div align="center"><font id="tableTitle" style="font-size: large;font-weight: bold;"></font></div>
							<button id="detail" type="button" class="btn btn-primary"  onclick="seeDetail()">维修信息录入</button>
							<button  type="button" class="btn btn-danger"  onclick="destroy()">报废信息录入</button>
						</div>
						<!-- table -->
						<table id="tableD"class="table table-condensed" data-toolbar="#toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
							<thead style="background:#ace4ff;">
								<tr></tr>
							</thead>
						</table>
					</div>
			  </div>
			  
			  <!-- Modal add-->
					<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
						aria-labelledby="addModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="width: 880px">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="addModalLabel">【维修信息】</h4>
								</div>
								<div class="modal-body">
									<jsp:include page="RepairMachineInfo.jsp"></jsp:include>
								</div>
								 <div class="modal-footer">
									  <button type="button" class="btn btn-default"
									 	data-dismiss="modal" >关闭</button>
									 <button type="button" class="btn btn-primary" onclick="addsave()">保存</button>
								 </div>
							</div>
						</div>
					</div>
					<!-- Modal -->
			</div>			
			</div>
			</div>
		</div>
</body>
</html>