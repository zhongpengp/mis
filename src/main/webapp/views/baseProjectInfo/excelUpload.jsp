<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//避免浏览器缓存
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
String path=request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>数据导入</title>
<script type="text/javascript">
$(document).ready(function() {

	$("#input-index").fileinput({
		language : 'zh', //
		showUpload : false,
		maxFileCount : 1,
		showPreview:false,
		mainClass : "input-group-lg"
	});
	
	$("#indexSubmitBtn").on("click",function(){
		var filenamee = $("#input-index").val();
		var point = filenamee.lastIndexOf("."); 
	    var type = filenamee.substr(point);
		var filestr = $("#input-index").val();
		if(filestr==null||filestr==""){
			$("#selectFileMessage").show();
		}else{
			$("#selectFileMessage").hide();
			if(type==".xls"||type==".xlsx"){
				$("#selectFileMessage").hide();
				$("#selectFileTypeMessage").hide();
				$("#processbar").show();
				$("#excelImportForm").hide();
				$("#excelImportForm").submit();
			}else{
				$("#selectFileTypeMessage").show();
			}
		}
	});
	
	$("#hiddenIFrame").load(function(){
	    var wnd = this.contentWindow;
	    var str = $(wnd.document.body).text();
	    var message =[];
	    message = JSON.parse(str);
	    showMessage(message);
		//if(str.indexOf("success")>=0){
			//callback();
			$("#excelImportForm").hide();
			$("#processbar").hide();
		//}
	  });
});
		
	  function showMessage(data){
		  var result = "";
		  result+=("<div class='panel panel-info'><div class='panel-heading'><h3 class='panel-title' align='left' style='color: red'>详细信息</h3></div><div align='left' class='panel-body' style='padding: 0 0 0 0'>");
		  $.each(data,function(i,value){
	   		 if(i==data.length-1){
	   			 var sss= value[1];
	   			 if(sss.indexOf("未从Excel")>=0){
	   				result+=("<font color='red'>未从所选择的Excel中读取到设备信息，请检查后重试！</font></div></div>");
	   			 }
				 sss=sss.replace(/\###/g, "<br>");
	   			 $("#importMessageTitle").empty();
	   			 $("#importMessageTitle").append("<h2 align='center'>"+sss+"</h2>");
	   		 }else{
	   			 if(value[1].indexOf("失败")>=0){
	   				 var sss= value[1];
	   				 sss=sss.replace(/\###/g, "<br>");
	   				 if(i==data.length-2){
	   					result+=("<font color='red'>"+value[0]+sss+"</font></div></div>");
	   				 }else{
	   					result+=("<font color='red'>"+value[0]+sss+"</font><br/>");
	   				 }
        		}else{
        			var sss= value[1];
	   				 sss=sss.replace(/\###/g, "<br>");
        			if(i==data.length-2){
        				result+=("<font color='green'>"+value[0]+sss+"</font></div></div>");
	   				 }else{
	   					result+=("<font color='green'>"+value[0]+sss+"</font><br/>");
	   				 }
        		}
	   			if(i!=data.length-2){
		   			result+='<hr style="border:1px dashed rgb(217,237,247);margin-top: 3px; margin-bottom: 3px" />';
	   			}
	   		 }
   	 });
		  $("#importMessageBody").empty();
		  $("#importMessageBody").append(result);
		  $("#importMessageBody").append('<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>');
	  }
</script>
</head>
<body>
		<div class="row clearfix">
			<div>
				<div id="excelPanel">
					<div class="panel panel-primary" style="margin-bottom: 0">
						<div class="panel-heading">
							<h3 class="panel-title" align="center">设备基础信息导入</h3>
						</div>
						<div class="panel-body" align="center" >
							<div id="processbar" style="display: none">
								<div class="progress progress-striped active">
								    <div class="progress-bar progress-bar-success" role="progressbar"
								         aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"
								         style="width: 55%;">
								        <span class="sr-only">55% 完成</span>
								    </div>
								</div>
								<div align="center"><font>处理中，请稍后……</font> </div>
							</div>
							<iframe name="hiddenIFrame" id="hiddenIFrame" style="display:none"></iframe>
							<form name="excelImportForm" id="excelImportForm" method="post" action="<%=path%>/projectMachineImportController/machineUpload_baseMachineImport"  enctype="multipart/form-data" target="hiddenIFrame">   
									<input type="text" name="selectedImportProjectID" id="selectedImportProjectID" style="display: none">
									<label class="control-label">请选择填好数据的<font color="red">模版文件</font></label>
									<a href="<%=path%>/resource/MachineImportExcel.xlsx" download="">(模板文件下载)</a><br/><br/>
									<input id="input-index" type="file" id="file" name="file"  data-allowed-file-extensions='["xls", "xlsx"]'/>
									<div align="center" id="selectFileMessage" style="display: none"><font color="red">请选择要上传的文件,仅支持xls或者xlsx格式的文件！</font> </div>
								    <div align="center" id="selectFileTypeMessage" style="display: none"><font color="red">该文件类型不允许上传，请重新选择！</font> </div>
									<br />
									<button type="button" class="btn btn-danger" data-dismiss="modal"> 关 闭 </button>
									<button id="indexSubmitBtn" type="button" class="btn btn-primary"> 导 入 </button>
							</form>
						<div id="importMessageTitle"></div>
						<div id="importMessageBody"></div>
						</div>
				</div>
		</div>
	</div>
	</div>
</body>
</html>