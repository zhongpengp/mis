package common.persistent;

import java.util.List;
import java.util.Map;
import common.vo.MessageVO;
import common.vo.Project;
import common.vo.UserVO;

public interface MessageVOMapper {
	List<MessageVO> getMessageByUserId(Map<String, Object> param);
	
	List<Project> selectProjectInfoByUserType(Map<String, Object> param);
	
	void insertNewMessage(Map<String, Object> param);
	
	List<UserVO> getUserByGS(String userID);
	
	List<UserVO> getUserByGYS(String userID);
	
	List<UserVO> getUserByXM(String userID);
	
	void recevieMessage(Map<String, Object> param);

	void updateMsgRead(Map<String, String> map);
}
