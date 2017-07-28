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
		 $('#addApplyForm_xm').validate({  
	           errorElement : 'span',  
	           errorClass : 'help-block',  
	           focusInvalid : false,  
	           rules : { 
	        	   projectType : {required : true},  
	        	   companyId : {required : true},  
	        	   applierName : {required : true, maxlength : 100},  
	        	   idcardNum : {required : true, maxlength : 100,userid:true},
	        	   phoneNum : {required : true, maxlength : 100,phone:true},  
	        	   email : {required : true, maxlength : 100,mail:true},
	        	   projectName : {required : true, maxlength : 100,projectName:true},
	        	   projectDetail : { maxlength : 1000},
	           },  
	           
	           messages : {  
	        	   companyId : {required : "所属公司不可为空"},  
	        	   applierName : {required : "申请人姓名必填", maxlength : "最大长度100"},  
	        	   idcardNum : {required : "申请人身份证号必填", maxlength : "最大长度100"},
	        	   phoneNum : {required : "申请人电话必填", maxlength : "最大长度100"},  
	        	   email : {required : "申请人邮箱必填", maxlength :"最大长度100"},
	        	   projectName : {required : "申请项目必填", maxlength : "最大长度100"},
	        	   projectDetail : { maxlength : "最大长度1000"},
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
		 
		 $.validator.addMethod("projectName", function(value, element){
			 var re ;
			 $.ajax({
				    url:"<%=path %>/apply/validateXM_name",    
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
         }, "该项目名称已存在或已申请过！");
		 
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
	
	function initCompanySelectOption(){
		$.ajax({
			url:"<%=path %>/apply/initCompanySelectOption",
			data:{},
			success:function(data){
				$("#companyId").empty();
	        	  $("#companyId").append("<option value=''>请选择</option>");
				$(data).each(function(index,value){
					$("#companyId").append("<option value='" + value.gsId+"'>"+ value.gsName + "</option>");
				});
				$("#companyId").selectpicker('refresh');
			},
			error:function(){
				alert_danger("初始化数据","获取公司列表失败，请稍后重试！");
			}
		});
	}
	  
	function saveApply_xm() {
		  //表单验证
		 if ($('#addApplyForm_xm').validate().form()){
		      $.ajax({
		          url : "<%=path %>/apply/register_xm",
		          data : $('#addApplyForm_xm').serialize(),
		          type : "post",
		          success : function(data) {
		        	  $("#registerModal").hide();
		        	  var email = $("#email").val();
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
		<form id="addApplyForm_xm" class="form-horizontal" role="form">
		
			<div class="form-group">
				<label for="companyId" class="col-md-2 control-label"> 所属公司  </label>
				<div class="col-md-10 data-validate" id="cssType">
					<select name="companyId" id="companyId" class="selectpicker  show-tick">
					</select> 
				</div>
			</div>		
			<div class="form-group">
				<label for="projectType" class="col-md-2 control-label"> 项目类型  </label>
				<div class="col-md-10 data-validate" id="cssType">
					<select name="projectType" id="projectType" data-width="100%" class="selectpicker show-tick">
						<option value="桥梁">桥梁</option>
						<option value="路基">路基</option>
						<option value="隧道">隧道</option>
					</select> 
				</div>
			</div>		
			<div class="form-group">
				<label for="projectName" class="col-md-2 control-label"> 项目名称  </label>
				<div class="col-md-10 data-validate">
					<input type="text" class="form-control" name="projectName" placeholder="填写申请项目名称"
						id="projectName" > 
				</div>
			</div>	
			
			<div class="form-group" id ="divAdd1">
				<label for="applierName" class="col-md-2 control-label"> 负责人 </label>
				<div class="col-md-10 data-validate">
					<input type="text" class="form-control" name="applierName" placeholder="填写申请人的中文名"
						id="applierName" >
				</div>
			</div>	
			<div class="form-group" id ="divAdd2">
				<label for="idcardNum" class="col-md-2 control-label"> 身份证号 </label>
				<div class="col-md-10 data-validate">
					<input type="text" class="form-control" name="idcardNum" placeholder="填写申请人身份证号"
						id="idcardNum" >
				</div>
			</div>
			
			<div class="form-group" id ="divAdd3">
				<label for="phoneNum" class="col-md-2 control-label"> 联系电话 </label>
				<div class="col-md-10 data-validate">
					<input type="text" name="phoneNum"  placeholder="填写申请人联系电话" class="form-control" >
				</div>
			</div>
			
			<div class="form-group" id ="divAdd3">
				<label for="email" class="col-md-2 control-label"> 邮箱 </label>
				<div class="col-md-10 data-validate">
					<input type="text" name="email" id="email" placeholder="填写申请人邮箱" class="form-control" >
				</div>
			</div>
			
			
			<div class="form-group" id ="divAdd4">
				<label for="projectDetail" class="col-md-2 control-label"> 项目简介 </label>
				<div class="col-md-10 data-validate">
					<textarea name="projectDetail" id="projectDetail" rows="3"  placeholder="填写申请项目描述" class="form-control" ></textarea>
				</div>
			</div>
			
			<div class="form-group" align="center">
				<button type="reset" class="btn btn-default">重置</button>
				<button type="button" class="btn btn-primary" onclick="saveApply_xm()">提交</button>
			</div>
		</form>
	</div>
	
</body>
</html>
