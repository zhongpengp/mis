<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增上传文件</title>
<script type="text/javascript" src="<%=path %>/js/jquery-form.js"></script>
<script type="text/javascript">
	var userType = '<%=request.getSession().getAttribute("userType")%>';
	var userName = '<%=request.getSession().getAttribute("userName")%>';
	var userID = '<%=request.getSession().getAttribute("userID")%>';
	$(function(){
		getProjectInfo();
		if(userType!="2"){
			$("#fileType").append('<option value="2">档案管理</option>');
			$("#fileType").selectpicker('refresh');
		}
		$("#input-file").fileinput({
			language : 'zh', 
			showUpload : false,
			maxFileCount : 1
		});
		$("#successMessage").hide();
		$("#errorMessage").hide();
		$('#addNewMessageForm').validate({  
	           errorElement : 'span',  
	           errorClass : 'help-block',  
	           focusInvalid : false,  
	           rules : {  
	        	   fileName : {required : true, maxlength : 60},
	        	   projectName : {required : true},  
	        	   fileType : {required : true}
	           },  
	           
	           messages : {  
	        	   fileName : {required : "文件名称必填", maxlength : "最大长度60"},  
	        	   projectName : {required : "所属项目必填"},  
	        	   fileType : {required : "文档类型必填"}
	        	   
	           },  
	 
	           highlight : function(element) {  
	               $(element).closest('.data-validate').addClass('has-error');  
	           },  
	 
	           success : function(label) {  
	               label.closest('.data-validate').removeClass('has-error');  
	               label.remove();  
	           },  
	 
	           errorPlacement : function(error, element) {  
	        	   element.parent('div').append(error);  
	           }  
		});
		var options = {   
	            type: 'POST',  
	            url: "<%=path%>/file/FileUpload.do",
	            dataType: 'text', 
	            success : function(data) {
	            	if(data=="error"){
	            		alert_warning('【上传结果】','上传失败！');
	            		$('#addNewMessageForm')[0].reset();
	            	}else{
	            		alert_success('【上传结果】','上传成功！');
	            		$('#addNewMessageForm')[0].reset();
	            	}
	            },
	            error : function(xhr, status, err) {
	            	alert_warning('【上传结果】','上传失败！');
	            	$('#addNewMessageForm')[0].reset();
	            }  
	        };   
	        $("#addNewMessageForm").submit(function(){   
	            $(this).ajaxSubmit(options);   
	            return false;   //防止表单自动提交  
	        });  
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
              $("#projectId").selectpicker('val', '');
              $("#projectId").selectpicker('refresh');
          },
          error : function(request) {
          }
      });
	}
	
	function saveNewMessage(){
		if ($('#addNewMessageForm').validate().form()){
			$("#userID").val(userName)
			$("#selectFileMessage").hide();
			$("#selectFileTypeMessage").hide();
			$("#successMessage").hide();
			var filestr = $("#input-file").val();
			if(filestr==null||filestr==""){
				$("#selectFileTypeMessage").show();
				return false;
			}
			$("#addNewMessageForm").submit();
		}
	}
	//取消
	function reload(){
		location.reload();
	}
</script>
</head>
<body>
<div class="container" style="margin:10px;width: 98%;">
	<div id=page_title>
		<ul class="breadcrumb" style="margin-bottom:0;">   
			<li>附件管理</li>  
			<li class="active">附件上传</li>
		</ul>
	</div>
	<div id="viewAddModelDiv" style="margin-top: 20px;">
			<iframe name="hiddenIFrame" id="hiddenIFrame" style="display:none"></iframe>
			<form name="addNewMessageForm" id="addNewMessageForm" class="form-horizontal"  method="post" action="<%=path%>/file/FileUpload.do"  enctype="multipart/form-data" target="hiddenIFrame">
			
			<input type="hidden" id ="userID" name="userID">
 			<div class="form-group">
				<label for="projectId" class="col-md-2 control-label">所属项目</label>
				<div class="col-xs-8 data-validate">
					<select name=projectId id="projectId" data-width="100%" class="selectpicker show-tick" multiple placeholder="请选择。。。">
					</select>
				</div>				
			</div>
			<div class="form-group data-validate">
				<label for="fileName" class="col-md-2 control-label">文件名称</label>
				<div class="col-md-8 data-validate">
					<input id="fileName" class="form-control" name="fileName" type="text" />
				</div>
			</div>	
			<div class="form-group">
				<label for="fileType" class="col-sm-2 control-label"> 文档类型 </label>
				<div class="col-xs-8 data-validate" >
					<select name="fileType" id="fileType" class="selectpicker show-tick " data-width="100%">
						<option value="0">申购</option>
						<option value="1">设备管理</option>
					</select>
				</div>
			</div>	           
			<div class="form-group">
				<label for="fileDesc" class="col-md-2 control-label">文件描述</label>
				<div class="col-md-8 data-validate">
					<textarea name="fileDesc" id="fileDesc" rows="3" class="form-control" ></textarea>
				</div>
			</div>
            
			<div class="form-group">
             	<label for="taskNo" class="col-md-2 control-label">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</label>
				<div class="col-md-8 data-validate">	
					<input id="input-file" type="file" id="file" name="file" data-show-preview="false"/>
				    <div align="center" id="selectFileMessage" style="display: none"><font color="red">请选择要上传的文件！</font> </div>
				    <div align="center" id="selectFileTypeMessage" style="display: none"><font color="red">未选择任何文件！</font> </div>
				</div>
			</div>
			<div class="form-group">
				<font id="successMessage" color="green">上传成功！</font>
				<font id="errorMessage" color="red">上传失败，请重试！</font>
			</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" onclick="reload()">取消</button>
				<button type="button" class="btn btn-primary" onclick="saveNewMessage()">保存</button>
			</div>
	</div>
</div>
</body>
</html>