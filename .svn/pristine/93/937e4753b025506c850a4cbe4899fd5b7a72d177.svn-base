<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息详情</title>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript">
	function setData(data){
		$("#messageThemeDe").val(data.messageTheme);
		var recuser = data.recevieProjectName;
		$("#recevieUserIdDe").val(recuser);
		$("#messageSendDe").val(data.messageSend);
		var attachmentSend = data.attachmentSend;
		if(attachmentSend!=null&&attachmentSend!=""){
			$("#sendFilDownload").attr("href","../../.."+attachmentSend);
			$("#sendFilDownload").show();
			$("#sendFile").hide();
		}else{
			$("#sendFilDownload").hide();
			$("#sendFile").show();
		}
		var senuser = data.sendProjectName;
		$("#sendProjectNameDe").val(data.sendProjectName);
		$("#messageReplyDe").val(data.messageReply);
		var attachmentReply = data.attachmentReply;
		if(attachmentReply!=null&&attachmentReply!=""){
			$("#recFilDownload").attr("href","../../.."+attachmentReply);
			$("#recFilDownload").show();
			$("#recFile").hide();
		}else{
			$("#recFilDownload").hide();
			$("#recFile").show();
		}
	}
</script>
</head>
<body>
<div class="container" style="margin:10px;width: 98%;">
	<div id="viewAddModelDiv" style="margin-top: 20px;">
		<fieldset disabled>
			<form name="addNewMessageForm" id="addNewMessageForm" class="form-horizontal">
			<div class="form-group data-validate">
				<label for="messageTheme" class="col-md-2 control-label">消息主题</label>
				<div class="col-md-8 data-validate">
					<input id="messageThemeDe" class="form-control" name="messageTheme" type="text" />
				</div>
			</div>
 			<div class="form-group">
				<label for="recevieUserId" class="col-md-2 control-label">收件人</label>
				<div class="col-xs-8 data-validate">
					<input type="text" class="form-control" id="recevieUserIdDe" name="recevieUserId"/>
				</div>				
			</div>
			<div class="form-group">
				<label for="messageSend" class="col-md-2 control-label">发件人</label>
				<div class="col-md-8 data-validate">
					<input name="sendProjectName" id="sendProjectNameDe" class="form-control" />
				</div>
			</div>	           
			<div class="form-group">
				<label for="messageSend" class="col-md-2 control-label">消息内容</label>
				<div class="col-md-8 data-validate">
					<textarea name="messageSend" id="messageSendDe" rows="3" class="form-control" ></textarea>
				</div>
			</div>
			<div class="form-group">
             	<label for="taskNo" class="col-md-2 control-label">消息附件</label>
				<div class="col-md-8 data-validate">	
					<a href="#" id="sendFilDownload" style="display: none;">下载</a>
					<input type="text" id="sendFile" style="display: none;" class="form-control" value="无"/>
				</div>
			</div>
			<div class="form-group">
				<label for="messageSend" class="col-md-2 control-label">回复内容</label>
				<div class="col-md-8 data-validate">
					<textarea name="messageReply" id="messageReplyDe" rows="3" class="form-control" ></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="messageSend" class="col-md-2 control-label">回复附件</label>
				<div class="col-md-8 data-validate">
					<a href="#" id="recFilDownload" style="display: none;">下载</a>
					<input type="text" id="recFile" class="form-control" style="display: none;" value="无"/>
				</div>
			</div>
			</form>
			</fieldset>
	</div>
</div>
</body>
</html>