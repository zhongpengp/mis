package common.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.persistent.UserVOMapper;
import common.vo.LoginLog;
import common.vo.LoginQueryVO;
import common.vo.UserVO;
import common.vo.UserVOExample;
import util.IpUtil;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserVOMapper userMapper;

	public UserVO checkLogin(LoginQueryVO vo) {
		UserVOExample userExample = new UserVOExample();
		userExample.createCriteria().andLoginNameEqualTo(vo.getLoginName());
		try{
			UserVO queryUser = userMapper.selectByExample(userExample).get(0);
			if ((queryUser != null) && (queryUser.getLoginPassword().trim().equals(vo.getLoginPassword().trim()))) {
				return queryUser;
			}else{
				return null;
			}
		}catch (Exception e) {
			return null;
		}
		
		
	}

	public void saveLoginLog(LoginQueryVO user, HttpServletRequest request, String loginMessage) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String loginTime = format.format(new Date(System.currentTimeMillis()));
		String loginName = user.getLoginName();
		String loginPassword = user.getLoginPassword();
		String loginIP = IpUtil.getIpAddress(request);
		LoginLog loginLog = new LoginLog(loginName, loginPassword, loginIP, loginTime, loginMessage);
		this.userMapper.saveLoginLog(loginLog);
	}
}
