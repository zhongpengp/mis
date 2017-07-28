package common.vo;

public class LoginLog
{
  String loginName;
  String loginPassword;
  String loginIP;
  String loginTime;
  String loginMessage;
  
  public LoginLog() {}
  
  public LoginLog(String loginName, String loginPassword, String loginIP, String loginTime, String loginMessage)
  {
    this.loginName = loginName;
    this.loginPassword = loginPassword;
    this.loginIP = loginIP;
    this.loginTime = loginTime;
    this.loginMessage = loginMessage;
  }
  
  public String getLoginName()
  {
    return this.loginName;
  }
  
  public void setLoginName(String loginName)
  {
    this.loginName = loginName;
  }
  
  public String getLoginPassword()
  {
    return this.loginPassword;
  }
  
  public void setLoginPassword(String loginPassword)
  {
    this.loginPassword = loginPassword;
  }
  
  public String getLoginIP()
  {
    return this.loginIP;
  }
  
  public void setLoginIP(String loginIP)
  {
    this.loginIP = loginIP;
  }
  
  public String getLoginTime()
  {
    return this.loginTime;
  }
  
  public void setLoginTime(String loginTime)
  {
    this.loginTime = loginTime;
  }
  
  public String getLoginMessage()
  {
    return this.loginMessage;
  }
  
  public void setLoginMessage(String loginMessage)
  {
    this.loginMessage = loginMessage;
  }
}
