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
          checkUnit: {required : true},  
       	  checkCost: {required : true,cost:true},  		
       	  checkProve : {required : true, maxlength : 2024},  
       	  checkPay : {required : true, maxlength : 2024},
       	 
          },  
          
          messages : { 
           checkUnit: {required : "检定单位必填"},  
       	   checkCost: {required : "检定花费必填"},  
           checkProve : {required : ""},  
           checkPay : {required : "" },
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
			<input type="hidden" name="checkDate" id="checkDate" > 
			<input type="hidden" name="gyxName" id="gyxName" > 
			<input type="hidden" name="checkPeriod" id="checkPeriod" > 
	 	    <div class="form-group">
				<label for="machineName" class="col-sm-2 control-label"> 设备名称  </label>
				<div class="col-sm-4 data-validate">
					<input type="text" class="form-control" name="machineName" placeholder="填写设备名称"
						id="machineName" readonly> 
				</div>
				<label for="producer" class="col-sm-2 control-label"> 生产厂家</label>
				<div class="col-sm-4 data-validate" >
					<input type="text" class="form-control" name="producer" id="producer" 
					    placeholder="填写生产厂家 " readonly>
			    </div>
			</div> 
	 	    <div class="form-group">
				<label for="checkUnit" class="col-sm-2 control-label"> 检定单位  </label>
				<div class="col-sm-4 data-validate">
					<input type="text" class="form-control" name="checkUnit" placeholder="填写定检单位"
						id="checkUnit" > 
				</div>
				<label for="checkCost" class="col-sm-2 control-label"> 检定花费</label>
				<div class="col-sm-4 data-validate" >
					<input type="text" class="form-control" name="checkCost" id="checkCost" 
					    placeholder="填写检定花费 " >
			    </div>
			</div>   	
			<div class="form-group">
				<label for="checkProve" class="col-sm-2 control-label"> 检定证书</label>
				<div class="col-md-4 data-validate">
					<select name="checkProve" id="checkProve" class="selectpicker show-tick " data-width="100%">
						<option value="0">已取</option>
						<option value="1">未取</option>
					</select>
				</div>
				<label for="checkPay" class="col-sm-2 control-label"> 检定付费 </label>
				<div class="col-md-4 data-validate">
					<select name="checkPay" id="checkPay" class="selectpicker show-tick " data-width="100%">
						<option value="0">已付</option>
						<option value="1">未付</option>
					</select>
				</div>
			</div>	
	    </form>
 
   </div>		
</body>
</html>
