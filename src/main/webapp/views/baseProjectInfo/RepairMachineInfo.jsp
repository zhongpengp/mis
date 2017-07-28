<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">

<title>设备申购申请</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	 $('#checkForm').validate({  
          errorElement : 'span',  
          errorClass : 'help-block',  
          focusInvalid : false,  
          rules : { 
          repairUnit: {required : true},  
          repairCost: {required : true,cost:true},  		
          issue : {required : true, maxlength : 2024},  
          repairBody : {required : true, maxlength : 2024},
       	 
          },  
          
          messages : { 
           repairUnit: {required : "维修单位必填"},  
           repairCost: {required : "维修花费必填"},  
           issue : {required : "问题描述"},  
           repairBody : {required : "维修内容" },
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
	 
	 $.validator.addMethod("cost", function(value, element){
		 var re = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
  	     return this.optional(element) || (re.test(value));     
     }, "请填写正确金额格式"); 
	 
 });
  

	  
</script>

<body>
    <div class="container" style="margin:10px;width: 98%; text-align: center;">
		<form class="form-horizontal" role="form" id="checkForm">
			<input type="hidden" name="machineId" id="machineId" >
			<input type="hidden" name="projectId" id="projectId" >
			<input type="hidden" name="gyxName" id="gyxName" >
			<input type="hidden" name="zhibaoqi" id="zhibaoqi" >  
	 	    <div class="form-group">
				<label for="machineName" class="col-sm-2 control-label"> 设备名称  </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="machineName" placeholder="填写设备名称"
						id="machineName" readonly> 
				</div>
				<label for="producer" class="col-sm-2 control-label"> 生产厂家</label>
				<div class="col-sm-3 data-validate" >
					<input type="text" class="form-control" name="producer" id="producer" 
					    placeholder="填写生产厂家 " readonly>
			    </div>
			</div> 
	 	    <div class="form-group">
				<label for="repairUnit" class="col-sm-2 control-label"> 维修单位  </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="repairUnit" placeholder="填写维修单位"
						id="repairUnit" > 
				</div>
				<label for="repairCost" class="col-sm-2 control-label"> 维修花费</label>
				<div class="col-sm-3 data-validate" >
					<input type="text" class="form-control" name="repairCost" id="repairCost" 
					    placeholder="填写维修花费 " >
			    </div>
			</div>   	
			<div class="form-group">
				<label for="checkProve" class="col-sm-2 control-label"> 问题描述</label>
				<div class="col-md-8 data-validate">
					<textarea name="issue" id="issue" rows="3" class="form-control" placeholder="填写设备问题描述"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="checkPay" class="col-sm-2 control-label"> 维修内容 </label>
				<div class="col-md-8 data-validate">
					<textarea name="repairBody" id="repairBody" rows="3" class="form-control" placeholder="填写设备维修内容"></textarea>
			    </div>
		    </div>	
	    </form>
 
   </div>		
</body>
</html>
