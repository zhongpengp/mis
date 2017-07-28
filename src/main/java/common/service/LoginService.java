package common.service;


import javax.servlet.http.HttpServletRequest;

import common.vo.LoginQueryVO;
import common.vo.UserVO;

public abstract interface LoginService
{
  public abstract UserVO checkLogin(LoginQueryVO paramLoginQueryVO);
  
  public abstract void saveLoginLog(LoginQueryVO paramLoginQueryVO, HttpServletRequest paramHttpServletRequest, String paramString);
}
