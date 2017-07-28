<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>文件列表</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/dataselect.css">
<script type="text/javascript">
	var userType = '<%=request.getSession().getAttribute("userType")%>';
	var userID = '<%=request.getSession().getAttribute("userID")%>';
    $(document).ready(function () {
    	getProjectInfo();
    	if(userType!="2"){
    		$('#checkbox').css("display","");
		}
    	$('#startTime').datetimepicker().on('changeDate', function(ev){
   			$('#endTime').datetimepicker('setStartDate',$("#startTime").val());
   		});
   		$('#endTime').datetimepicker().on('changeDate', function(ev){
   			$('#startTime').datetimepicker('setEndDate',$("#endTime").val());
   		});
		   
        //点击查询后重新加载dataTable的数据
        $("#query").click(function() {
        	$('#tableD').bootstrapTable('destroy');
        	bootStrapTableInit();
        });
        //table加载
        //bootStrapTableInit();
       
    });
    
    function getProjectInfo(){
		var theUrl = "<%=path %>/file/getProjectByType.do"
		$.ajax({
          url : theUrl,
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
              bootStrapTableInit();
          },
          error : function(request) {
          }
      });
	}
    
	function bootStrapTableInit() {
		$('#tableD').bootstrapTable('destroy');
        //页面加载时初始化dataTable
        $('#tableD').bootstrapTable({
        	url:'<%=path%>/file/getFileList.do',
			method: 'get',
			 //toolbar: '#toolbar',    //工具按钮用哪个容器
		       striped: true,      //是否显示行间隔色
		       cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		       pagination: true,     //是否显示分页（*）
		       maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
		       //sortable: false,      //是否启用排序
		       //sortOrder: "asc",     //排序方式
		       sortName:'studentCode',
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
		 		data.userType = userType;
		 		data.fileType = $('input:radio:checked').val();
		 		data.startTime = $("#startTime").val();
		 		data.endTime = $("#endTime").val();
		 		data.projectId = $('#projectId option:selected').val();
				return data;
			},
			
			onLoadSuccess : function(data) {
			},
			onLoadError : function(data) {
			},
			
			columns : [				  
					   {field : 'fileId',  visible : false},
					   {field : 'fileName', title : '文件名称', align: 'center'},
					   {field : 'projectName', title : '所属项目', align: 'center',
					   		formatter: function(value,row,index){
					   			return $('#projectId option:selected').text();
					   		}
					   },
					   {field : 'uploadUserid', title : '上传人', align: 'center'},
					   {field : 'fileType', title : '文档类型', align: 'center',
						   formatter: function(value,row,index){
								if(value=="0"){
									return "申购";
								}
								if(value=="1"){
									return "设备管理";
								}
								if(value=="2"){
									return "档案管理";
								}
							}
					   },
					   {field : 'uploadTime', title : '上传时间', align: 'center'},
					   {field : 'fileDesc', title:'文件描述',align: 'left'},
					   {fieid : "fileAddress", title : '文件下载', align:'center' ,  
							formatter: function(value,row,index){
								if(row.fileAddress!=""){
									return '<a href="<%=path%>/FileDownload?filename='+row.fileAddress+'">下载</a>';
								}else{
									return "无附件";
								}
						    }
					   }
					]
		});
	}

	
	
</script>

</head>

<body>
		<div class="content">
		<div class="page-content-wrapper" style="margin-left:15px;">
			<div id=page_title>
				<ul class="breadcrumb" style="margin-bottom:0;">   
					<li>附件管理</li>  
					<li class="active">附件列表</li>
				</ul>
			</div>
			<div class="page-content">
				<div class="tjsx_title">条件筛选：</div>
				<div class="row" >
					<div class="col-md-4 ">
						<span>所属项目：</span>
						<select name=projectId id="projectId"  class="selectpicker show-tick">
	   					</select>
					</div>	
				</div>
				<div class="row bac_bl" style="height:34px;padding-top:6px;">
					<div class="col-md-6 ">
					    <span>文件类型：</span>
						<label class="checkbox-inline">
					    	<input type="radio" name="fileType" id="" value="0">申购
					  	</label>
					  	<label class="checkbox-inline">
					    	<input type="radio" name="fileType" id="" value="1">设备管理
					  	</label>
					  	<label class="checkbox-inline" id="checkbox" style="display:none;">
					    	<input type="radio" name="fileType" id="" value="2">档案管理
					  	</label>
					</div>	
				</div>
				<div class="row" style="padding-top: 5px;">
					<div class="col-md-1" style="width:100px;"><span>上传日期：</span></div>
					<div class="col-md-2">
						<input size="20" type="text" id="startTime" value="" class="form-control form_datetime" readonly>
						<script type="text/javascript">
							$("#startTime").datetimepicker({format: 'yyyy-mm-dd',autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});  
						</script>
					</div>
					<div class="col-md-2" style="vertical-align: middle;width: 10px;min-width: 10px;height: 38px;padding-left: 0px;padding-top: 7px;">
					至
					</div>
					<div class="col-md-2">
						<input size="20" type="text" id="endTime" value="" class="form-control form_datetime" readonly>
						<script type="text/javascript">
							$("#endTime").datetimepicker({format: 'yyyy-mm-dd',autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});  
						</script>
					</div>
					<div class="col-md-2">
						<button id="query" type="button" class="btn btn-primary">查询</button>	  
					</div>
				</div>
							
						<div class="row">
							<div class="col-sm-12" style="width: 100%">
								<div id="toolbar" class="btn-group">
									<div align="center"><font id="tableTitle" style="font-size: large;font-weight: bold;"></font></div>
								</div>
													<!-- table -->
									<div id="bodyFrame">
										<table id="tableD"class="table table-condensed" data-toolbar="#toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
											<thead style="background:#ace4ff;">
												<tr></tr>
											</thead>
										</table>
									</div>
							</div>
						</div>
				</div>
			</div>
		</div>
</body>
</html>