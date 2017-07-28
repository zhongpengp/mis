<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增上传文件</title>
<script type="text/javascript">
	var userName = '<%=request.getSession().getAttribute("userName")%>';
	var userID = '<%=request.getSession().getAttribute("userID")%>';
	$(function(){
		$("#fileType").val("0");
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
	            		$("#updateModal").modal("hide");
	            	}else{
	            		alert_success('【上传结果】','上传成功！');
	            		$('#addNewMessageForm')[0].reset();
	            		var appID = $('#applyId').val();
	            		$.ajax({
	      		          url : "<%=path %>/apply/UpdateMachineApply.do",
	      		          data : {"applyID":appID,"filePath":data},
	      		          type : "post",
	      		          success : function(data) {},
	      		          error : function(request) {}
	      		      	});
	            		$("#updateModal").modal("hide");
	            	}
	            },
	            error : function(xhr, status, err) {
	            	alert_warning('【上传结果】','上传失败！');
	            	$('#addNewMessageForm')[0].reset();
	            	$("#updateModal").modal("hide");
	            }  
	        };   
	        $("#addNewMessageForm").submit(function(){   
	            $(this).ajaxSubmit(options);   
	            return false;   //防止表单自动提交  
	        });  
	});
		
	function saveNewMessage(){
		if ($('#addNewMessageForm').validate().form()){
			$("#userID").val(userName);
			$("#projectId").val(userID);
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

</script>
</head>
<body>
<div class="container" style="margin:10px;width: 98%;">
	<div id="viewAddModelDiv" style="margin-top: 20px;">
			<iframe name="hiddenIFrame" id="hiddenIFrame" style="display:none"></iframe>
			<input id="applyId" name="applyId" type="hidden"/>
			<form name="addNewMessageForm" id="addNewMessageForm" class="form-horizontal"  method="post" action="<%=path%>/file/FileUpload.do"  enctype="multipart/form-data" target="hiddenIFrame">
			<input type="hidden" id ="userID" name="userID">
 			<div class="form-group">
				<label for="projectId" class="col-md-2 control-label">所属项目</label>
				<div class="col-xs-8 data-validate">
					<input id="Name" class="form-control" name="projectName" type="text" readonly/>
					<input id="projectId" name="projectId" type="hidden"/>
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
					<input  value="申购"  class="form-control"  type="text" readonly/>
					<input id="fileType" value="0" name="fileType" type="hidden" />
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
	</div>
</div>
</body>
</html>