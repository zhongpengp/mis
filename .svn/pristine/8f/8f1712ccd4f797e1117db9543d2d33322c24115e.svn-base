<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header_fileUpload.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础设备信息管理</title>
<style type="text/css">
	#baseMachineTableSearchForm .form-group{
		margin-bottom: 1px;
	}
	#baseMachineTableSearchForm .form-group label{
		margin-left:15px;
	}
</style>
<script type="text/javascript">
var baseMachineTableSelectCourseArrangeID;
var baseMachineTableSelectCourseName;
var baseMachineListModalTableSelectStudentID;
$(function(){
	$("#baseMachineDetailChart_allDIV").height($(window).height());
	$("#gouzhiriqi1").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
	$("#gouzhiriqi2").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
	$('#gouzhiriqi1').datetimepicker().on('changeDate', function(ev){
		$('#gouzhiriqi2').datetimepicker('setStartDate',$("#gouzhiriqi1").val());
	});
	$('#gouzhiriqi2').datetimepicker().on('changeDate', function(ev){
		$('#gouzhiriqi1').datetimepicker('setEndDate',$("#gouzhiriqi2").val());
	});
	
	$("#daoruxitongriqi1").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
	$("#daoruxitongriqi2").datetimepicker({format: 'yyyy-mm-dd', autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});
	$('#daoruxitongriqi1').datetimepicker().on('changeDate', function(ev){
		$('#daoruxitongriqi2').datetimepicker('setStartDate',$("#daoruxitongriqi1").val());
	});
	$('#daoruxitongriqi2').datetimepicker().on('changeDate', function(ev){
		$('#daoruxitongriqi1').datetimepicker('setEndDate',$("#daoruxitongriqi2").val());
	});
	
	$("#baseMachineTableSearchFormQuery").on("click",function(){
		initBaseMachineTable();
	});
	
	initBaseMachineTable();
	editScoreFormValidator();
	$('#excelImportModal').on('show.bs.modal', function (e) {
		$("#input-index").val("");
		$("#excelImportForm").show();
		$("#excelImportForm")[0].reset();
		$("#importMessageTitle").empty();
		$("#importMessageBody").empty();
		$("#selectFileMessage").hide();
		$("#selectFileTypeMessage").hide();
		$("#processbar").hide();
    });
	
	$("#editScoreModalBtnSave").on("click",function(){
		$("#editScoreModalForm").bootstrapValidator('validate');
		var isValid = $("#editScoreModalForm").data("bootstrapValidator").isValid();
		if(isValid==true){
			var dialogInstance = BootstrapDialog.confirm({
	            title: '修改成绩',
	            message: '您即将修改成绩，是否继续？',
	            type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
	            closable: false, // <-- Default value is false
	            draggable: false, // <-- Default value is false
	            btnCancelLabel: '取消', // <-- Default value is 'Cancel',
	            btnOKLabel: '确定修改', // <-- Default value is 'OK',
	            btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
	            callback: function(result) {
	                // result will be true if button was click, while it will be false if users close the dialog directly.
	                if(result) {
	                	var score = $("#editScoreModalFormScore").val();
	                	$.ajax({
	    					url:'<%=path%>/gradeController/editStudentScoreByID.zp',
	    					method:'post',
	    					data:{
	    						studentID:baseMachineListModalTableSelectStudentID,
	    						courseArrangeID:baseMachineTableSelectCourseArrangeID,
	    						score:score
	    					},
	    					success:function(data){
	    						$("#editScoreModal").modal('hide');
	    						BootstrapDialog.alert({
	    				            title: '修改成绩',
	    				            message: '修改成绩成功!',
	    				            size:'size-small',
	    				            type:'type-success', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
	    				            closable: true, // <-- Default value is false
	    				            buttonLabel: '确定', // <-- Default value is 'OK',
	    				            callback: function(result) {
	    				                // result will be true if button was click, while it will be false if users close the dialog directly.
	    				            }
	    				        });
	    						$("#editScoreModalForm").bootstrapValidator('resetForm');
	    						initBaseMachineTable();
	    						initCourseGradeDetail(baseMachineTableSelectCourseArrangeID,baseMachineTableSelectCourseName);
	    					}
	    				});
	                }else {
	                	dialogInstance.close();
	                }
	            }
	        });
			
		}
	});
});
function editScoreFormValidator(){
	$('#editScoreModalForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {/*输入框不同状态，显示图片的样式*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {/*验证*/
        	score: {/*键名username和input name值对应*/
                message: '输入的成绩无效',
                validators: {
                    notEmpty: {/*非空提示*/
                        message: '成绩不能为空'
                    },
                    regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
                        regexp: /^(100|[1-9]\d|\d)$/,
                        message: '只能输入0～100之间的数字'
                    }
                }
            }
        }
    });
}
function initBaseMachineTable(){
	$("#baseMachineTable").bootstrapTable("destroy");
	$("#baseMachineTable").bootstrapTable({
		url: '<%=path%>/baseMachineSearchController/searchByForm',
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
        queryParams:$("#baseMachineTableSearchForm").serialize(),
		<%-- queryParams : function(data) {
		    data.teacherID='<%=userID%>'
			return data;
		}, --%>
		onLoadSuccess:function(data){
		},
		columns : [
			//{field : 'check_box', checkbox : true},
			{field : 'name',title:'设备名称',visible : true},
			{field : 'xinghao', title : '型号', visible : true},
			{field : 'guige', title : '规格', visible : true},
			{field : 'shuliang', title : '数量', visible : true},
			{field : 'danwei', title : '单位', visible : true},
			{field : 'shengchangchangjia', title : '生产厂家', visible : true},
			{field : 'danjia', title : '单价', visible : true},
			{field : 'xinjiuchengdu', title : '新旧程度', visible : true},
			{field : 'gouzhiriqi', title : '购置日期', visible : true},
			{field : 'jiandingdanwei', title : '检定单位', visible : true},
			{field : 'jiandingdanjia', title : '检定单价', visible : true},
			{field : 'shangcijiandingsj', title : '上次检定时间', visible : true},
			{field : 'jiandingzhouqi', title : '检定周期', visible : true},
			{field : 'tigongyiqidanwei', title : '提供仪器单位', visible : true},
			{field : 'yiweixiucishu', title : '已维修次数', visible : true},
			{field : 'shifoubaoxiuqi', title : '是否保修期', visible : true},
			{field : 'weixiudanwei', title : '维修单位', visible : true},
			{field : 'weixiufeiyong', title : '维修费用', visible : true},
			{field : 'weixiuneirong', title : '维修内容', visible : true},
			{field : 'importtime', title : '导入系统时间', visible : true},
	]
	});
}


function initCourseGradeDetail(courseArrangeID,courseName){
	//$("#baseMachineListModal").modal("hide");
	baseMachineTableSelectCourseName=courseName;
	baseMachineTableSelectCourseArrangeID=courseArrangeID;
	$("#baseMachineListModalTitle").text(baseMachineTableSelectCourseName);
	$("#baseMachineListModalTable").bootstrapTable("destroy");
	$("#baseMachineListModalTable").bootstrapTable({
		url: '<%=path%>/gradeController/getCourseStudentScoreByArrangeID.zp',
 		method: 'get',
       //toolbar: '#toolbar',    //工具按钮用哪个容器
       striped: true,      //是否显示行间隔色
       cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
       pagination: true,     //是否显示分页（*）
       maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
       //sortable: false,      //是否启用排序
       //sortOrder: "asc",     //排序方式
       search:true,
       searchAlign:'left',
       sortName:'studentCode',
       pageNumber:1,      //初始化加载第一页，默认第一页
       pageSize:10,
       pageList: [10, 20, 30, 50],  //可供选择的每页的行数（*）
       queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                           // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
       //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
       sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
       //search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
       //showColumns: true,     //是否显示所有的列
       //showRefresh: true,     //是否显示刷新按钮
       clickToSelect: true,    //是否启用点击选中行
       showExport:true,
       exportTypes:['excel', 'doc',  'pdf', 'png', 'xml', 'csv', 'txt', 'sql','json'],
		queryParams : function(data) {
		    data.courseArrangeID=courseArrangeID
			return data;
		},
		onLoadSuccess:function(data){
			//initStudentGradeDetailTable(data);
		},
		columns : [
				//{field : 'check_box', checkbox : true},
				{field : 'studentCode', title : '学生学号', visible : true,
					formatter:function(value,row,index){
						return '<a class="btn" style="padding:0;margin:0" onclick="initStudentScoreEdit(\''+row.studentID+'\',\''+row.studentCode+'\',\''+row.studentName+'\')">'+value+'</a>';
					}
				},
				{field : 'studentName', title : '学生姓名', visible : true},
				{field : 'studentID', title : '学生ID', visible : false},
				{field : 'sex', title : '学生性别', visible : true},
				{field : 'score', title : '考试成绩', visible : true},
		]
	});
	$("#baseMachineListModal").modal("show");
}
function initStudentScoreEdit(studentID,studentCode,StudentName){
	$("#editScoreModalTitle").text(baseMachineTableSelectCourseName);
	baseMachineListModalTableSelectStudentID=studentID;
	$.ajax({
		url: '<%=path%>/gradeController/getStudentScoreByID.zp',
		data:{
			studentID:studentID,
			courseArrangeID:baseMachineTableSelectCourseArrangeID
		},
		success:function(data){
			$("#editScoreModalFormStudentCode").val(studentCode);
			$("#editScoreModalFormStudentName").val(StudentName);
			$("#editScoreModalFormScore").val(data);
			$("#editScoreModal").modal("show");
			$("#editScoreModalForm").bootstrapValidator('resetForm');
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
						<li>    设备管理</li>  
						<li class="active">设备基础信息管理</li>
					</ul>
				</div>
				<div class="page-content">
					<div id="main" class="drmtable">
						<div class="tjsx_title">条件筛选：</div>
						<div id="filter">
							<div class="filtrate_box clearfix" style="margin-bottom: 0">
								<form id="baseMachineTableSearchForm" class="form-horizontal" role="form">
									<ul class="filtrate_list">
										 <li class="child_li first_sort" >
										 <div class="form-group">
										    <label for="shengchanchangjia" class="col-sm-1 control-label">生产厂家</label>
										    <div class="col-sm-4">
										      <input type="text" class="form-control" id="shengchangchangjia" name="shengchangchangjia" placeholder="模糊查询，多个名称请用中文逗号“，”分隔">
										    </div>
										    <label for="tigongyiqidanwei" class="col-sm-2 control-label">提供仪器单位</label>
										    <div class="col-sm-4">
										      <input type="text" class="form-control" id="tigongyiqidanwei" name="tigongyiqidanwei" placeholder="模糊查询，多个名称请用中文逗号“，”分隔">
										    </div>
										 </div>
							      		</li>
							      		<li class="child_li first_sort bac_bl" >
							      			<div class="form-group">
							      				<label for="xinjiuchengdu" class="col-sm-1 control-label">新旧程度</label>
											    <div class="col-md-4">
													<label class="checkbox-inline">
												    	<input type="radio" name="xinjiuchengdu" id="" checked value="all">不限
												  	</label>
													<label class="checkbox-inline">
												    	<input type="radio" name="xinjiuchengdu" id="" value="全新">1
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="xinjiuchengdu" id="" value="全新">2
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="xinjiuchengdu" id="" value="全新">3
												  	</label>
											  	</div>
											    <label for="shifoubaoxiuqinei" class="col-sm-2 control-label">是否保修期内</label>
											    <div class="col-md-4">
									        		<label class="checkbox-inline">
												    	<input type="radio" name="shifoubaoxiuqi" id="" checked value="all">不限
												  	</label>
									        		<label class="checkbox-inline">
												    	<input type="radio" name="shifoubaoxiuqi" id="" value="是">是
												  	</label>
												  	<label class="checkbox-inline">
												    	<input type="radio" name="shifoubaoxiuqi" id="" value="否">否
												  	</label>
											  	</div>
							      			</div>
							      		</li>
							      		<li class="child_li first_sort " >
								      		<div class="form-group" style="margin-top: 1px;">
											    <label for="gouzhiriqi" class="col-sm-1 control-label">购置日期</label>
											    <div class="col-sm-4">
											    	<div class="col-sm-5" style="padding: 0">
												      <input placeholder="开始时间" type="text" id="gouzhiriqi1"  class="form-control form_datetime" name="gouzhiriqi1" readonly>
											    	</div>
											    	<label for="" class="col-sm-1 control-label" style="padding-right: 21px;margin-left: 0px;">~</label>
											    	<div class="col-sm-5"style="padding: 0">
												      <input placeholder="结束时间" type="text" id="gouzhiriqi2"  class="form-control form_datetime" name="gouzhiriqi2" readonly>
											    	</div>
											    </div>
											    <label for="daoruxitongriqi" class="col-sm-2 control-label">导入系统日期</label>
											    <div class="col-sm-4">
											        <div class="col-sm-5" style="padding: 0">
												      <input placeholder="开始时间" type="text" id="daoruxitongriqi1"  class="form-control form_datetime" name="daoruxitongriqi1" readonly>
											    	</div>
											    	<label for="" class="col-sm-1 control-label" style="padding-right: 21px;margin-left: 0px;">~</label>
											    	<div class="col-sm-5"style="padding: 0">
												      <input placeholder="结束时间" type="text" id="daoruxitongriqi2"  class="form-control form_datetime" name="daoruxitongriqi2" readonly>
											    	</div>
											   </div>
										   </div>
							      		</li>
							      		<li class="child_li first_sort bac_bl" >
								      		<div class="form-group">
											    <label for="shebeimingcheng" class="col-sm-1 control-label">设备名称</label>
											    <div class="col-sm-3">
											      <input type="text" class="form-control" id="name" name="name" placeholder="请输入设备名称">
											    </div>
											    <div class="checkbox col-md-2" >
													<label style="padding-left: 0px;margin-left: 0px;">
													  <input type="checkbox" id="ifPrecise" name="shebeimingchengjingquechaxun" value="1"> 精确查询
													</label>
												</div>
												<div class="col-sm-5" align="center">
													<button id="baseMachineTableSearchFormQueryReset" type="button" class="btn btn-warning">重置</button>
													<button id="baseMachineTableSearchFormQuery" type="button" class="btn btn-info">查询</button>
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
					<button id="excelImport" type="button" class="btn btn-info" data-toggle="modal" data-target="#excelImportModal">导入Excel数据</button>
				</div>
				<table id="baseMachineTable" class="table table-condensed" data-toolbar="#toolbar"data-toggle="table" data-striped="true" data-search="true"  data-show-columns="true">
					<thead style="background-color: #87CEFF"></thead>
				</table>
			</div>
		</div>
	</div>
	<!-- 学生成绩模态框（Modal） -->
	<div class="modal fade" id="baseMachineListModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">【学生成绩：<font id="baseMachineListModalTitle"></font>】</h4>
	            </div>
	            <div class="modal-body">
					<table id="baseMachineListModalTable" class="table table-condensed" data-toolbar="#toolbar">
						<thead style="background-color: #87CEFF"></thead>
					</table>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	<!-- Modal excelImport-->
	<div class="modal fade" id="excelImportModal" tabindex="-1" role="dialog"
		aria-labelledby="excelImportModalLabel" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div id="excelImportModalBody" class="modal-body" style="padding-top: 0;padding-bottom: 0">
					<jsp:include page="excelUpload.jsp"></jsp:include>
				</div>
				
			</div>
		</div>
	</div>
	<!-- Modal -->
	<!-- 修改成绩模态框（Modal） -->
	<div class="modal fade" id="editScoreModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">【修改成绩：<font id="editScoreModalTitle"></font>】</h4>
	            </div>
	            <div class="modal-body">
					<form id="editScoreModalForm" method="post" class="form form-horizontal">
		                <div class="form-group">
		                    <label for="ScoreName" class="col-sm-3 control-label">学生学号</label>
		                    <div class="col-sm-9">
		                        <input type="text" id="editScoreModalFormStudentCode" class="form-control" name="studentCode" readonly/>
		                    </div>
		                </div>
		                
		                <div class="form-group">
		                    <label class="col-sm-3 control-label">学生姓名</label>
		                    <div class="col-sm-9">
		                        <input type="text" id="editScoreModalFormStudentName" class="form-control" name="studentName" readonly/>
		                    </div>
		                </div>
		                
		                <div class="form-group">
		                    <label class="col-sm-3 control-label">考试成绩</label>
		                    <div class="col-sm-9">
		                        <input type="text" id="editScoreModalFormScore" class="form-control" name="score" />
		                    </div>
		                </div>
		
		                <div class="form-group">
		                    <div class="col-sm-9 col-sm-offset-3">
		                        <button id="editScoreModalBtnReset" type="button" class="btn btn-primary">重置</button>
		                        <button id="editScoreModalBtnSave" type="button" class="btn btn-primary">保存</button>
		                    </div>
		                </div>
		            </form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
</body>
</html>