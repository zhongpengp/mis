package log.persistent;

import java.util.List;
import java.util.Map;

import common.vo.MailVO;
import common.vo.UserVO;
import common.vo.applyMachineInfoVO;
import common.vo.newMachineApplyVO;
import common.vo.registerUserVO;

public interface ApplyMapper {

	void saveApply(registerUserVO vo);

	List<registerUserVO> listApply(Map<String,String> map);

	void saveUser(Map<String, String> userMap);

	void applyUpdate(Map<String, String> statusMap);

	void saveProject(Map<String, String> projectMap);

	MailVO getMail();

	int validate(String name);

	Map<String, String> getUserInfo(String userID);

	int validateProject(String name);

	Map<String, String> getProjectInfo(String projectID);

	void updateProject(Map<String, String> map);

	int validateGys_name(String name);

	int validateGS_Name(String name);

	void newMachineApply(Map<String, String> map);

	Map<String, String> getApplyUserInfo(String userID);

	List<newMachineApplyVO> listNewMachineApply(Map<String, String> map);

	void UpdateMachineApply(Map<String, String> map);

	List<applyMachineInfoVO> listApplyDetail(String applyID);

	void addApplyMachineInfo(applyMachineInfoVO tableTatol);


}
