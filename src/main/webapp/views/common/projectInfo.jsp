<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header_noCheckSession.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<link rel="stylesheet" href="<%=path %>/css/step-dc-style1.css" />
<title>项目信息</title>
</head>
<script type="text/javascript">
    var bridge = ["桩基础","系梁","墩柱","盖梁","桥台","支座及垫石","空心板预制及安装","桥面铺装及栏杆","附属工程"];
    var road = ["准备工作","土方工程","路基施工","沥青路面施工","边缘石施工","涂料施工","绿化施工","管道施工","铺道板施工","收尾工程"];
    var tube = ["施工准备","进口洞口边仰坡","进口管棚、防护","出口明洞回填、洞门","进口洞身开挖支护","出口明洞衬砌","二次衬砌、管件安装","洞内外排水、电缆沟","装饰及机电安装调试","隧道内路面装饰"];
    var userID = '<%=request.getSession().getAttribute("userID")%>';
    var userType = '<%=request.getSession().getAttribute("userType")%>';
    var step;
	$(document).ready(function(){
		$.ajax({
		    url:"<%=path %>/apply/getProjectInfo.do",    
		    dataType:"json",   //返回格式为json
		    async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		    data:{"projectID":userID},    //参数值
		    type:"GET",   
		    success:function(data){
		    	var type = data.projectType;
		    	$span_arr = $("#ol").find("span");
		    	if(type=="桥梁"){
		    		for(var i =0;i<bridge.length;i++){
		    			$($span_arr[i]).html(bridge[i]);
		    		}
		    	}
		    	if(type=="路基"){
		    		for(var i =0;i<road.length;i++){
		    			$($span_arr[i]).html(road[i]);
		    		}
		    	}
		    	if(type=="隧道"){
		    		for(var i =0;i<tube.length;i++){
		    			$($span_arr[i]).html(tube[i]);
		    		}
		    	}
		    	var step = data.projectStep;
		    	$points = $('.progress-points').first();
		    	$points.data('current',step);
		    	$point_arr = $('[data-point]');
		    	$point_arr.slice(0, parseInt(step)).addClass('completed');
		    	$progress = $('.progress').first();
		    	$progress.css('width', (11.1*parseInt(step)) + "%");
		    	
		    	$("#projectName").val(data.projectName);
		    	$("#projectStatus").val(data.projectStatus);
		    	$("#proName").val(data.name);
		    	$("#phone").val(data.phone);
		    	$("#applyTime").val(data.applyTime);
		    	$("#projectDESC").val(data.projectDESC);
		    	$("#projectType").val(type);
		    	
		    },
		    error:function(){
		    	
		    }
		});
		  	 
		 $('#updateUserForm').validate({  
	           errorElement : 'span',  
	           errorClass : 'help-block',  
	           focusInvalid : false,  
	           rules : {  
	        	   userName : {required : true, maxlength : 32,userName:true},  
	        	   password : {required : true, maxlength : 12,password:true},
	        	   phone : {required : true, maxlength : 11,phone:true},  
	        	   projectDESC : { maxlength : 1000},
	           },  
	           
	           messages : {  
	        	   userName : {required : "账号必填", maxlength : "最大长度32"},  
	        	   password : {required : "密码必填", maxlength : "最大长度12"},
	        	   phone : {required : "电话必填", maxlength : "最大长度11"},  
	        	   projectDESC : { maxlength : "最大长度1000"},
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
			 var re ;
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
			 var desc = $("#projectDESC").val();
		      $.ajax({
		          url : "<%=path %>/apply/updateProject.do",
		          data : {"projectID":userID,"projectDESC":desc,"step":step},
		          type : "post",
		          success : function(data) {
		              alert_success('【项目更新】','更新成功！');
		              window.location.Reload();
		          },
		          error : function(request) {
		        	  alert_warning('【项目更新】','更新失败！');
		        	  window.location.Reload();
		          }
		      }); 
		 });
		//图
		 (function() {
			 if(userType=="1"){
				 $("#projectDESC").attr("readonly","readonly");
				 $("#save").css("display","none");
			 } else{
			  var $point_arr, $points, $progress, $trigger, activate, active, max, tracker, val;

			  $trigger = $('.trigger').first();

			  $points = $('.progress-points').first();

			  $point_arr = $('[data-point]');

			  $progress = $('.progress').first();

			  val = parseInt($points.data('current'));

			  max = $point_arr.length - 1;

			  tracker = active = 0;

			  activate = function(index) {
			    if (index !== active) {
			      active = index;
			      $point_arr.removeClass('completed active');
			      $point_arr.slice(0, index).addClass('completed');
			      $point_arr.eq(active).addClass('active');
			      return $progress.css('width', (index / max * 100) + "%");
			    }
			  };

			  $points.on('click', 'li', function(event) {
			    var _index;
			    _index = $point_arr.index(this);//项目进度值
			    step = _index;
			    tracker = _index === 0 ? 1 : _index === val ? 0 : tracker;
			    return activate(_index);
			  });

			  $trigger.on('click', function() {
			    return activate(tracker++ % 2 === 0 ? 0 : val);
			  });

			  setTimeout((function() {
			    return activate(val);
			  }), 1000);
		 }	
			}).call(this);
	  //图 
		 
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
	<form class="form-horizontal" role="form" id="updateProjectForm">
	   
	   <fieldset>
         <legend >项目信息</legend>
         <div class="form-group">
				<label for="projectName" class="col-sm-2 control-label"> 项目名称  </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="projectName" placeholder="填写申请项目名称"
						id="projectName" readonly> 
				</div>
				<label for="projectStatus" class="col-sm-2 control-label"> 项目状态 </label>
				<div class="col-sm-3 data-validate" id="cssprojectStatus">
					<input type="text" class="form-control" name="projectStatus" id="projectStatus" readonly> 
				</div>
			</div>	
			<div class="form-group">
				
				<label for="projectType" class="col-sm-2 control-label"> 项目类型  </label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="projectType" id="projectType" readonly> 
				</div>
				
				<label for="proName" class="col-sm-2 control-label"> 负责人</label>
				<div class="col-sm-3 data-validate">
					<input type="text" class="form-control" name="proName" placeholder="填写项目负责人"
						id="proName" readonly>
				</div>	
			</div>
			<div class="form-group">
				<label for="applyTime" class="col-sm-2 control-label"> 申请时间 </label>
				<div class="col-sm-3 data-validate">
					<input type="text" name="applyTime" id="applyTime" placeholder="填写申请时间" class="form-control" readonly>
				</div>
				<label for="phone" class="col-sm-2 control-label"> 联系电话 </label>
				<div class="col-sm-3 data-validate">
					<input type="text" name="phone" id="phone" placeholder="填写联系电话" class="form-control" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="projectDESC" class="col-md-2 control-label"> 项目描述 </label>
				<div class="col-sm-8 data-validate">
					<textarea name="projectDESC" id="projectDESC" rows="3"  placeholder="填写项目描述" class="form-control" ></textarea>
				</div>
			</div> 
       </fieldset>  
  </form>
   <!-- 进度图 -->
   <div class="modal-footer"></div>
   <span style="font-size: 21px;">项目进度</span>
   <div class="inliner"></div>
		<div class="inlined">
		  <div class="progress-meter">
		    <div class="track">
		      <span class="progress"></span> <!-- 加width属性红线百分比 -->
		    </div>
		    <ol class="progress-points" data-current="" id="ol">
		      <li class="progress-point " data-point="0">  <!-- 完成加 completed class-->
		        <span class="label"></span>
		      </li>
		      <li class="progress-point " data-point="1">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point " data-point="2">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point " data-point="3">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point " data-point="4">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point" data-point="5">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point" data-point="6">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point" data-point="7">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point" data-point="8">
		        <span class="label"></span>
		      </li>
		      <li class="progress-point" data-point="9">
		        <span class="label">结束</span>
		      </li>
		    </ol>
		  </div>
		</div>
   <!-- 进度图  end -->
   	  <div class="control-group" id="save" style="text-align: right; margin-right: 80px;">
          <div class="controls">
            <button class="btn btn-success"> 更新项目</button>
          </div>
       </div> 
</div>		
</body>
</html>
