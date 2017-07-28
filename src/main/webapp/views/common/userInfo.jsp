<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">

<title>用户信息</title>
</head>
<script type="text/javascript">
var userID = '<%=request.getSession().getAttribute("userID")%>';
var preName ;
	$(document).ready(function(){
		$.ajax({
		    url:"<%=path %>/apply/getUserInfo.do",    
		    dataType:"json",   //返回格式为json
		    async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		    data:{"userID":userID},    //参数值
		    type:"GET",
		    cache:false,
		    success:function(data){
		    	var userType ;
		    	var userStatus;
		    	if(data.userType=="1"){
		    		userType="公司本部 ";
		    	}else if(data.userType=="2"){
		    		userType="项目分部 ";
		    	}else if(data.userType=="3"){
		    		userType="供应商 ";
		    	}else if(data.userType=="4"){
		    		userType="超级管理员 ";
		    	}
		    	$("#userType").append("<option value=" + data.userType+ ">"+ userType + "</option>");
		    	if(data.userStatus=="0"){
		    		userStatus="初始";
		    	}else if(data.userStatus=="1"){
		    		userStatus="正常";
		    	}else{
		    		userStatus="注销";
		    	}
		    	$("#userStatus").append("<option value=" + data.userStatus+ ">"+ userStatus + "</option>");
		    	$("#loginName").val(data.userName);
		    	$("#loginPassword").val(data.password);
		    	$("#name").val(data.name);
		    	$("#phoneNum").val(data.phone);
		    	$("#sex").selectpicker('val',data.sex);
		    	$("#userType").selectpicker('val',data.userType);
		    	$("#userStatus").selectpicker('val',data.userStatus);
		    	$("#birthday").val(data.birth);
		    	preName = data.userName;
		    },
		    error:function(){
		    	
		    }
		});
		 
	
		 $("#see").click(function(){
			 var type = $("#loginPassword")[0].type;
			 if(type=="password"){
				 $("#loginPassword")[0].type="text";
			 }else if(type=="text"){
				 $("#loginPassword")[0].type="password";
			 }
		 });
		 
		 $('#updateUserForm').validate({  
	           errorElement : 'span',  
	           errorClass : 'help-block',  
	           focusInvalid : false,  
	           rules : {  
	        	   loginName : {required : true, maxlength : 32,userName:true},  
	        	   loginPassword : {required : true, maxlength : 12,password:true},
	        	   phoneNum : {required : true, maxlength : 11,phone:true},  
	        	 
	           },  
	           
	           messages : {  
	        	   loginName : {required : "账号必填", maxlength : "最大长度32"},  
	        	   loginPassword : {required : "密码必填", maxlength : "最大长度12"},
	        	   phoneNum : {required : "电话必填", maxlength : "最大长度11"},  
	
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
		 
		 $.validator.addMethod("userName", function(value, element){
			 var re = 0;
			 if(preName==value){
			 }else{
				 $.ajax({
					    url:"<%=path %>/apply/validate.do",    
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
			 }
      	     return this.optional(element) || (re==0);     
         }, "用户名已存在");
		 
		 $.validator.addMethod("password", function(value, element){
			 var re=/(?=.*\d)(?=.*[a-zA-Z]).{6,12}/;
      	     return this.optional(element) || (re.test(value));     
         }, "密码太简单：6-12位字母、数字组合");
		 
		 $.validator.addMethod("phone", function(value, element){
			 var re = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\d{8}$/;
      	     return this.optional(element) || (re.test(value));     
         }, "电话号码格式错误");
		 
		
		 $("#save").click(function(){
			 if ($('#updateUserForm').validate().form()){
				 $("#userId").val(userID);
				 $.ajax({
			          url : "<%=path %>/apply/saveUserInfo.do",
			          data : $('#updateUserForm').serialize(),
			          type : "post",
			          success : function(data) {			
			              alert_success('【修改信息】','修改成功！');
			              window.location.Reload();
			          },
			          error : function(request) {
			        	  alert_warning('【修改信息】','修改失败！');
			        	  window.location.Reload();
			          }
			      }); 
			 }
		 });
		 
	  });
	  
	  
	  
</script>

<body>
    <div class="container" style="margin:10px;width: 98%;">
	<!-- message -->
	<div id="addFieldHintDiv" class="alert alert-success alert-dismissible"
		style="display: none" role="alert">
		<button type="button" onclick="MessageCommonDivHide('addFieldHintDiv')" class="close">
			<span>&times;</span><span class="sr-only">关闭</span>
		</button>
		<strong><span id="addFieldTitle"></span></strong> <span id="addFieldBody"></span>
	</div> 
	<!-- message -->
	<form class="form-horizontal" role="form" id="updateUserForm">
    <fieldset>
        <legend >用户信息</legend>      
 	      <div class="form-group">
				<label for="loginName" class="col-sm-2 control-label"> 账户账号  </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="loginName" placeholder="填写账户账号"
						id="loginName" > 
				</div>
				<label for="loginPassword" class="col-sm-2 control-label"> 账户密码 </label>
				<div class="col-sm-3 data-validate" >
					<div style="position:relative; width:100%;">
					<input type="password" class="form-control" name="loginPassword"  placeholder="填写账户密码"
						id="loginPassword" >
				    <div class="glyphicon glyphicon-eye-open" id="see" 
				    style="position:absolute ;width:16px;height:16px;top:9px; right:5px;color:#ccc;"></div>
				    </div>	
				</div>
			</div>	
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名 </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="name" placeholder="用户姓名"
						id="name" >
				</div>
				<label for="phoneNum" class="col-sm-2 control-label"> 联系电话 </label>
				<div class="col-sm-3 data-validate">
					<input type="text" name="phoneNum" id="phoneNum" placeholder="填写联系电话" class="form-control" >
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label"> 性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别 </label>
				<div class="col-sm-3 data-validate" >
					<select name="sex" id="sex" class="selectpicker show-tick " data-width="100%">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
				<label for="birthday" class="col-sm-2 control-label"> 出生日期 </label>
				<div class="col-sm-3 data-validate">
					<input size="20" type="text" name="birthday" id="birthday" value="" class="form-control form_datetime" placeholder="请选择日期" readonly>
						<script type="text/javascript">
							$("#birthday").datetimepicker({format: 'yyyy-mm-dd',autoclose:true,todayBtn:"linked",todayHighlight:true,language:'zh-CN',minView:2});  
						</script>
				</div>
			</div>
			<div class="form-group" >
				<label for="userType" class="col-sm-2 control-label"> 用户类型 </label>
				<div class="col-sm-3 data-validate">
					<select name="userType" id="userType" class="selectpicker show-tick " data-width="100%" ></select>
				</div>
				<label for="userStatus" class="col-sm-2 control-label"> 用户状态 </label>
				<div class="col-sm-3 data-validate">
					<select name="userStatus" id="userStatus" class="selectpicker show-tick " data-width="100%"></select>
				</div>
			</div>
			<input type="hidden" name="userId" id="userId" >
	   </fieldset>
       
      <div class="control-group"  style="text-align: right; margin-right: 80px;">
          <div class="controls">
            <button class="btn btn-success" id="save">保存</button>
          </div>
       </div> 
  
  </form>
</div>		
</body>
</html>
