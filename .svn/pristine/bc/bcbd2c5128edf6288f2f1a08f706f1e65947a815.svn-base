<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/header.jsp"%>
<title>回复消息</title>
<script type="text/javascript">
	$(function(){
		$("#input-file").fileinput({
			language : 'zh', //
			showUpload : false,
			maxFileCount : 1
		});
		$("#successMessage").hide();
		$("#errorMessage").hide();
		$('#recMessageForm').validate({  
	           errorElement : 'span',  
	           errorClass : 'help-block',  
	           focusInvalid : false,  
	           rules : {  
	        	   messageReply : {required : true, maxlength : 500}
	           },  
	           
	           messages : {  
	        	   messageReply : {required : "回复内容必填", maxlength : "最大长度500"}  
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
		 $('#hiddenIFrame').load(function(){
			 $("#successMessage").hide();
				$("#errorMessage").hide();
			    var wnd = this.contentWindow;
			    var str = $(wnd.document.body).text();
				if(str.indexOf("success")>=0){
					$("#recMessageForm")[0].reset();
					$('#recevieModal').modal('hide');
					alert_success('【回复结果】','回复成功！');
				}else if(str.indexOf("error")>=0){
					alert_warning('【回复结果】','回复失败！');
				}
		}); 
	});
	
	//保存回复内容
	function saveRecMessage(){
		if ($('#recMessageForm').validate().form()){
			$("#selectFileMessage").hide();
			$("#selectFileTypeMessage").hide();
			var filenamee = $("#input-file").val();
			var point = filenamee.lastIndexOf("."); 
		    var type = filenamee.substr(point);
			$("#successMessage").hide();
			var filestr = $("#input-file").val();
			var catalogstr = $("#selectCatalogTreeName").val();
			
			if(filestr!=null&&filestr!=""){
				if(type!=".xls"&&type!=".xlsx"&&type!=".doc"&&type!=".docx"){
					$("#selectFileTypeMessage").show();
					return false;
				}
			}
			$("#recMessageForm").submit();
		}
	}
	
	//加载初始数据
	function initRecData(messageId){
		$("#messageId").val(messageId);
	}
</script>
</head>
<body>
<div class="container" style="margin:10px;width: 98%;">
	<div id="viewAddModelDiv" style="margin-top: 20px;">
		<iframe name="hiddenIFrame" id="hiddenIFrame" style="display:none"></iframe>
			<form name="recMessageForm" id="recMessageForm" class="form-horizontal"  method="post" action="<%=path%>/message/recevieMessageUpLoad.do"  enctype="multipart/form-data" target="hiddenIFrame">
				<input type="hidden" id="messageId" name = "messageId">
				<div class="form-group">
					<label for="messageReply" class="col-md-2 control-label">消息内容</label>
					<div class="col-md-8 data-validate">
						<textarea name="messageReply" id="messageReply" rows="3" class="form-control" ></textarea>
					</div>
				</div>
	            
				<div class="form-group">
	             	<label for="taskNo" class="col-md-2 control-label">消息附件</label>
					<div class="col-md-8 data-validate">	
						<input id="input-file" type="file" id="file" name="file" data-show-preview="false"/>
					    <div align="center" id="selectFileMessage" style="display: none"><font color="red">请选择要上传的文件！</font> </div>
					    <div align="center" id="selectFileTypeMessage" style="display: none"><font color="red">该文件类型不允许上传，请重新选择！</font> </div>
					</div>
				</div>
		</form>
	</div>
</div>
</body>
</html>