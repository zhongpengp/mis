<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">

<title>设备申购申请</title>
</head>
<script type="text/javascript">
var userID = '<%=request.getSession().getAttribute("userID")%>';
var userName = '<%=request.getSession().getAttribute("userName")%>';
	$(document).ready(function(){
   	 	$("#User").val(userName);
   	 	$.ajax({
		    url:"<%=path %>/apply/getApplyUserInfo.do",    
		    dataType:"json",   //返回格式为json
		    async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		    data:{"userID":userID},    //参数值
		    type:"GET",
		    cache:false,
		    success:function(data){
		    	 $("#proName").val(data.projectName);
		    },
			error:function(){}
		});
		 $('#updateUserForm').validate({  
	           errorElement : 'span',  
	           errorClass : 'help-block',  
	           focusInvalid : false,  
	           rules : { 
	        	   proName: {required : true},  
	        	   User: {required : true},  		
	        	   Body : {required : true, maxlength : 2024},  
	        	   Reason : {required : true, maxlength : 2024},
	        	 
	           },  
	           
	           messages : { 
	        	   proName: {required : "项目必填"},  
	        	   User: {required : "申请人必填"},  
	        	   Body : {required : "申请内容必填", maxlength : "最大长度2024"},  
	        	   Reason : {required : "申请原因必填", maxlength : "最大长度2024"},
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
		 
	  });
	  
	 function addsave(){
		 if ($('#updateUserForm').validate().form()){
			 var Body = $("#Body").val();
			 var Reason = $("#Reason").val();
			 var Remark = $("#Remark").val();
			 $.ajax({
		          url : "<%=path %>/apply/newMachine.do",
		          data : {"applyUser":userName,"projectId":userID,"applyBody":Body,"applyReason":Reason,"remark":Remark},
		          type : "post",
		          success : function(data) {			
		              closeAdd();
		              alert_success('【申请信息】','申请成功！');
		          },
		          error : function(request) {
		        	  closeAdd();
		        	  alert_warning('【申请信息】','申请失败！');
		          }
		      }); 
	 	}
	 }	 
	
	function closeAdd(){
		$("#Body").val("");
		$("#Reason").val("");
		$("#Remark").val("");
		$(".modal-backdrop").remove();
		$("#addModal").modal("hide");
	}
	  
	  
</script>

<body>
    <div class="container" style="margin:10px;width: 98%; text-align: center;">
	<form class="form-horizontal" role="form" id="updateUserForm">
    <fieldset>  
 	      <div class="form-group">
				<label for="proName" class="col-sm-2 control-label"> 项目名称  </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="proName" placeholder="填写项目名称"
						id="proName" readonly> 
				</div>
				<label for="User" class="col-sm-2 control-label"> 申请人 </label>
				<div class="col-sm-3 data-validate" >
					<input type="text" class="form-control" name="User" id="User" 
					    placeholder="填写申请人 " readonly>
			    </div>
			</div>   	
			<div class="form-group">
				<label for="Body" class="col-sm-2 control-label"> 申购内容 </label>
				<div class="col-md-8 data-validate">
					<textarea name="Body" id="Body" rows="3"  class="form-control" placeholder="填写申购内容"></textarea>
				</div>
			</div>
			<div class="form-group" >
				<label for="Reason" class="col-sm-2 control-label"> 申购原因 </label>
				<div class="col-md-8 data-validate">
					<textarea name="Reason" id="Reason" rows="3"  class="form-control" placeholder="填写申购原因"></textarea>
				</div>
			</div>	
			<div class="form-group" >	
				<label for="Remark" class="col-sm-2 control-label"> 备注 </label>
				<div class="col-md-8 data-validate">
					<textarea name="Remark" id="Remark" rows="3" class="form-control" placeholder="填写备注"></textarea>
				</div>
			</div>
	   </fieldset>
  </form>
 
</div>		
</body>
</html>
