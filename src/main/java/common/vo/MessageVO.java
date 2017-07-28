package common.vo;

/**
 * 实体类（消息实体）
 * @author Kaven He
 *
 */
public class MessageVO {
	//消息ID
	private String messageId;
	//发送人
	private String sendUserId;
	//接收人
	private String recevieUserId;
	//发送时间
	private String sendTime;
	//消息内容
	private String messageSend;
	//消息附件
	private String attachmentSend;
	//回复内容
	private String messageReply;
	//回复附件
	private String attachmentReply;
	//是否回复
	private String isRecevierRead;
	//消息主题
	private String messageTheme;
	//发送人项目名称
	private String sendProjectName;
	//接收人项目名称
	private String recevieProjectName;
	//接收人是否阅读
	private String isRead;
	
	public String getSendProjectName() {
		return sendProjectName;
	}
	public void setSendProjectName(String sendProjectName) {
		this.sendProjectName = sendProjectName;
	}
	public String getRecevieProjectName() {
		return recevieProjectName;
	}
	public void setRecevieProjectName(String recevieProjectName) {
		this.recevieProjectName = recevieProjectName;
	}
	public String getMessageTheme() {
		return messageTheme;
	}
	public void setMessageTheme(String messageTheme) {
		this.messageTheme = messageTheme;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getRecevieUserId() {
		return recevieUserId;
	}
	public void setRecevieUserId(String recevieUserId) {
		this.recevieUserId = recevieUserId;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getMessageSend() {
		return messageSend;
	}
	public void setMessageSend(String messageSend) {
		this.messageSend = messageSend;
	}
	public String getAttachmentSend() {
		return attachmentSend;
	}
	public void setAttachmentSend(String attachmentSend) {
		this.attachmentSend = attachmentSend;
	}
	public String getMessageReply() {
		return messageReply;
	}
	public void setMessageReply(String messageReply) {
		this.messageReply = messageReply;
	}
	public String getAttachmentReply() {
		return attachmentReply;
	}
	public void setAttachmentReply(String attachmentReply) {
		this.attachmentReply = attachmentReply;
	}
	public String getIsRecevierRead() {
		return isRecevierRead;
	}
	public void setIsRecevierRead(String isRecevierRead) {
		this.isRecevierRead = isRecevierRead;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	
	
}
