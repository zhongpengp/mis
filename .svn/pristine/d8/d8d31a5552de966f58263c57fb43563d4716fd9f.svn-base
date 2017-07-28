<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	response.setHeader("Pragma","No-cache");    
	response.setHeader("Cache-Control","no-cache");    
	response.setDateHeader("Expires", 0);  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">

<title>用户申请</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		 $('#addApplyForm_gs').validate({  
	           errorElement : 'span',  
	           errorClass : 'help-block',  
	           focusInvalid : false,  
	           rules : { 
	        	   applyGsName : {required : true, maxlength : 100,gsName:true},  
	        	   applyGsUserName : {required : true, maxlength : 100},  
	        	   applyGsUserIdnum : {required : true, maxlength : 100,userid:true},
	        	   applyGsUserPhone : {required : true, maxlength : 100,phone:true},  
	        	   applyGsUserEmail : {required : true, maxlength : 100,mail:true},
	        	   applyGsUserDesc : { maxlength : 1000},
	           },  
	           
	           messages : {  
	        	   applyGsUserName : {required : "申请人姓名必填", maxlength : "最大长度100"},  
	        	   applyGsUserIdnum : {required : "申请人身份证号必填", maxlength : "最大长度100"},
	        	   applyGsUserPhone : {required : "申请人电话必填", maxlength : "最大长度100"},  
	        	   applyGsUserEmail : {required : "申请人邮箱必填", maxlength :"最大长度100"},
	        	   applyGsName : {required : "公司名称必填", maxlength : "最大长度100"},
	        	   applyGsUserDesc : { maxlength : "最大长度1000"},
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
	           },
	 
	     }); 
		 
		 $.validator.addMethod("gsName", function(value, element){
			 var re ;
			 $.ajax({
				    url:"<%=path %>/apply/validateGS_Name",    
				    dataType:"json",   //返回格式为json
				    async:false,//请求是否异步，默认为异步，这也是ajax重要特性
				    data:{"name":value},    //参数值
				    type:"GET",   
				    success:function(data){
				    	re = data;
				    },
				    error:function(){
				    }
				});
      	     return this.optional(element) || (re==0);     
         }, "该公司名称已存在或已申请过");
		 
		 $.validator.addMethod("userid", function(value, element){
			 var re=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
      	     return this.optional(element) || (re.test(value));     
         }, "身份证格式错误");
		 
		 $.validator.addMethod("mail", function(value, element){
			 var re=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      	     return this.optional(element) || (re.test(value));     
         }, "邮箱格式错误");
		 
		 $.validator.addMethod("phone", function(value, element){
			 var re = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\d{8}$/;
      	     return this.optional(element) || (re.test(value));     
         }, "电话号码格式错误");
		 
		
	  });
	  
	function saveApply_gs() {
		  //表单验证
		 if ($('#addApplyForm_gs').validate().form()){
		      $.ajax({
		          url : "<%=path %>/apply/register_gs",
		          data : $('#addApplyForm_gs').serialize(),
		          type : "post",
		          success : function(data) {
		        	  $("#registerModal").hide();
		        	  var email = $("#applyGsUserEmail").val();
		        	  BootstrapDialog.alert({
		  	            title: '提交注册申请',
		  	            message: '提交成功!审批结果将通过邮件方式发送至您的邮箱：'+email+'，请注意查收。',
		  	           // size:'size-small',
		  	            type:'type-success', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
		  	            closable: true, // <-- Default value is false
		  	            draggable: true, // <-- Default value is false
		  	            buttonLabel: '确定', // <-- Default value is 'OK',
		  	            callback: function(result) {
							window.location.href="<%=path%>/index.jsp";
		  	            }
		  	        });
		          },
		          error : function(request) {
		        	  BootstrapDialog.alert({
			  	            title: '提交注册申请',
			  	            message: '提交失败!请重试。',
			  	           // size:'size-small',
			  	            type:'type-danger', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
			  	            closable: true, // <-- Default value is false
			  	            draggable: true, // <-- Default value is false
			  	            buttonLabel: '确定', // <-- Default value is 'OK',
			  	            callback: function(result) {
								window.location.href="<%=path%>/index.jsp";
			  	            }
			  	        });
		          }
		      });
			 
		 }
	}  	  
</script>

<body>
	<div id="addFieldDiv">
		<form id="addApplyForm_gs" class="form-horizontal" role="form">
		
			<div class="form-group">
				<label for="applyGsName" class="col-md-2 control-label"> 公司名称  </label>
				<div class="col-md-10 data-validate">
					<input type="text" class="form-control" name="applyGsName" placeholder="填写公司名称"
						id="applyGsName" > 
				</div>
			</div>	
			
			<div class="form-group" id ="divAdd1">
				<label for="applyGsUserName" class="col-md-2 control-label"> 负责人 </label>
				<div class="col-md-10 data-validate">
					<input type="text" class="form-control" name="applyGsUserName" placeholder="填写申请人的中文名"
						id="applyGsUserName" >
				</div>
			</div>	
			<div class="form-group" id ="divAdd2">
				<label for="applyGsUserIdnum" class="col-md-2 control-label"> 身份证号 </label>
				<div class="col-md-10 data-validate">
					<input type="text" class="form-control" name="applyGsUserIdnum" placeholder="填写申请人身份证号"
						id="applyGsUserIdnum" >
				</div>
			</div>
			
			<div class="form-group" id ="divAdd3">
				<label for="applyGsUserPhone" class="col-md-2 control-label"> 联系电话 </label>
				<div class="col-md-10 data-validate">
					<input type="text" name="applyGsUserPhone"  placeholder="填写申请人联系电话" class="form-control" >
				</div>
			</div>
			
			<div class="form-group" id ="divAdd3">
				<label for="applyGsUserEmail" class="col-md-2 control-label"> 邮箱 </label>
				<div class="col-md-10 data-validate">
					<input type="text" name="applyGsUserEmail" id="applyGsUserEmail" placeholder="填写申请人邮箱" class="form-control" >
				</div>
			</div>
			
			
			<div class="form-group" id ="divAdd4">
				<label for="applyGsUserDesc" class="col-md-2 control-label"> 公司简介 </label>
				<div class="col-md-10 data-validate">
					<textarea name="applyGsUserDesc" id="applyGsUserDesc" rows="3"  placeholder="填写申请的公司描述" class="form-control" ></textarea>
				</div>
			</div>
			
			<div class="form-group" align="center">
				<button type="reset" class="btn btn-default">重置</button>
				<button type="button" class="btn btn-primary" onclick="saveApply_gs()">提交</button>
			</div>
		</form>
	</div>
	
</body>
</html>
