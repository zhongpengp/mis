package common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import common.vo.MessageVO;
import common.vo.Project;
import common.vo.UserVO;


public interface MessageService {
	List<MessageVO> getMessageByUserId(String startTime,String endTime,String queryType,HttpServletRequest request,String msgtheme);
	
	List<Project> getProjectInfoByUserType(HttpServletRequest request);
	
	void addNewMessage(MessageVO message);
	
	List<UserVO> getHeadquartersUser(String userType, String userID);
	
	void recevieMessage(MessageVO message);

	void updateMsgRead(String msgId);
}
