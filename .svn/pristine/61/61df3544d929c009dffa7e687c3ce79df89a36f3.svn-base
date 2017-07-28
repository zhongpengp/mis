<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
	String path = request.getContextPath();
	response.setHeader("Pragma","No-cache");    
	response.setHeader("Cache-Control","no-cache");    
	response.setDateHeader("Expires", 0);  
%>
<%
	String userType = (String)request.getSession().getAttribute("userType");
	String userName = (String)request.getSession().getAttribute("userName");
	String userID = (String)request.getSession().getAttribute("userID");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">   
<title>xxxx管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-3.3.7.min.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-table.min.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-treeview.min.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/fileinput.min.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-select.min.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/multi-select.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/dataselect.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrapValidator.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-dialog.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/select2.min.css"/>


<script type="text/javascript" src="<%=path %>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/echarts.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-3.3.7.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-treeview.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/fileinput.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="<%=path %>/js/defaults-zh_CN.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/data-format.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.multi-select.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/tableExport.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/html2canvas.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jspdf.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jspdf.plugin.autotable.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-table-export.js"></script>
<script type="text/javascript" src="<%=path %>/js/select2.full.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-form.js"></script>
<script type="text/javascript">
	function alert_success(title,message){
		BootstrapDialog.alert({
            title: title,
            message: message,
            size:'size-small',
            type:'type-success', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
            closable: true, // <-- Default value is false
            draggable: true, // <-- Default value is false
            buttonLabel: '确定', // <-- Default value is 'OK',
            callback: function(result) {
                // result will be true if button was click, while it will be false if users close the dialog directly.
            }
        });
	}
	function alert_warning(title,message){
		BootstrapDialog.alert({
            title: title,
            message: message,
            size:'size-small',
            type:'type-warning', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
            closable: true, // <-- Default value is false
            draggable: true, // <-- Default value is false
            buttonLabel: '确定', // <-- Default value is 'OK',
            callback: function(result) {
                // result will be true if button was click, while it will be false if users close the dialog directly.
            }
        });
	}
	function alert_danger(title,message){
		BootstrapDialog.alert({
            title: title,
            message: message,
            size:'size-small',
            type:'type-danger', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
            closable: true, // <-- Default value is false
            draggable: true, // <-- Default value is false
            buttonLabel: '确定', // <-- Default value is 'OK',
            callback: function(result) {
                // result will be true if button was click, while it will be false if users close the dialog directly.
            }
        });
	}
	function alert_info(title,message){
		BootstrapDialog.alert({
            title: title,
            message: message,
            size:'size-small',
            type:'type-info', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
            closable: true, // <-- Default value is false
            draggable: true, // <-- Default value is false
            buttonLabel: '确定', // <-- Default value is 'OK',
            callback: function(result) {
                // result will be true if button was click, while it will be false if users close the dialog directly.
            }
        });
	}
</script>
<script type="text/javascript">
$(function(){
	var userID = '<%=userID%>';
	if(userID=='null'||userID==null){
		$("#toLoginout").submit();
	}
});
	
</script>
</head>
<body>
<form id="toLoginout" action="<%=path%>/logout"></form>
</body>
</html>