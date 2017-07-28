package mail.vo;

import java.util.Date;

public class MailToSend {
    private Integer id;

    private String mailTitle;

    private String mailContext;

    private Date timeAdd;

    private Date timeSend;

    private Integer mailState;

    private String receiveUseraddress;

    private String sendUseraddress;

    private String sendUserid;

    private String receiveUserid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailContext() {
        return mailContext;
    }

    public void setMailContext(String mailContext) {
        this.mailContext = mailContext;
    }

    public Date getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(Date timeAdd) {
        this.timeAdd = timeAdd;
    }

    public Date getTimeSend() {
        return timeSend;
    }

    public void setTimeSend(Date timeSend) {
        this.timeSend = timeSend;
    }

    public Integer getMailState() {
        return mailState;
    }

    public void setMailState(Integer mailState) {
        this.mailState = mailState;
    }

    public String getReceiveUseraddress() {
        return receiveUseraddress;
    }

    public void setReceiveUseraddress(String receiveUseraddress) {
        this.receiveUseraddress = receiveUseraddress;
    }

    public String getSendUseraddress() {
        return sendUseraddress;
    }

    public void setSendUseraddress(String sendUseraddress) {
        this.sendUseraddress = sendUseraddress;
    }

    public String getSendUserid() {
        return sendUserid;
    }

    public void setSendUserid(String sendUserid) {
        this.sendUserid = sendUserid;
    }

    public String getReceiveUserid() {
        return receiveUserid;
    }

    public void setReceiveUserid(String receiveUserid) {
        this.receiveUserid = receiveUserid;
    }
}