<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">

<title>设备申请审批</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	 $('#checkForm').validate({  
          errorElement : 'span',  
          errorClass : 'help-block',  
          focusInvalid : false,  
          rules : { 
          approvalDetail: {required : true},  
          applyState: {required : true},  		
          },  
          messages : { 
           approvalDetail: {required : "审批内容必填"},  
           applyState: {required : "审批状态必填"},  
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
  

	  
</script>

<body>
    <div class="container" style="margin:10px;width: 98%; text-align: center;">
		<form class="form-horizontal" role="form" id="checkForm">
			<input type="hidden" name="applyID" id="applyID" >
	 	    <div class="form-group">
				<label for="projectName" class="col-sm-2 control-label"> 项目名称  </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="projectName" placeholder="填写项目名称"
						id="projectName" readonly> 
				</div>
				<label for="applyUser" class="col-sm-2 control-label"> 申请人</label>
				<div class="col-sm-3 data-validate" >
					<input type="text" class="form-control" name="applyUser" id="applyUser" 
					    placeholder="填写申请人 " readonly>
			    </div>
			</div> 
	 	    <div class="form-group">
				<label for="applyBody" class="col-sm-2 control-label"> 申请内容  </label>
				<div class="col-sm-8 data-validate">
					<textarea class="form-control" name="applyBody" placeholder="填写申请内容"
						id="applyBody" readonly> </textarea>
				</div>
			</div>
				
			<div class="form-group">	
				<label for="applyReason" class="col-sm-2 control-label"> 申请原因</label>
				<div class="col-sm-8 data-validate" >
					<textarea class="form-control" name="applyReason" id="applyReason" 
					    placeholder="填写申请原因" readonly></textarea>
			    </div>
			</div>   	
			<div class="form-group">
				<label for="applyState" class="col-sm-2 control-label"> 审批结果</label>
				<div class="col-md-8 data-validate">
					<select name=applyState id="applyState" data-width="100%" class="selectpicker show-tick">
						<option value="1">通过</option>
						<option value="2">不通过</option>
					</select>
				</div>	
			</div>
			<div class="form-group">
				<label for="approvalDetail" class="col-sm-2 control-label"> 审批内容 </label>
				<div class="col-md-8 data-validate">
					<textarea name="approvalDetail" id="approvalDetail" rows="3" class="form-control" placeholder="填写审批内容"></textarea>
			    </div>
		    </div>	
	    </form>
 
   </div>		
</body>
</html>
