package common.service;

import java.util.List;
import java.util.Map;

import common.vo.Apply_gys_vo;
import common.vo.Company;
import common.vo.RegisterApplyGS;
import common.vo.RegisterApplyGYS;
import common.vo.RegisterApplyXM;
import common.vo.UserVO;
import common.vo.applyMachineInfoVO;
import common.vo.newMachineApplyVO;
import common.vo.registerUserVO;

public interface ApplyService {
	
	void saveApply(registerUserVO vo);
	
	List<registerUserVO> listApply(String startTime,String endTime,String approveStatus);

	void saveApprove(registerUserVO vo);

	int validate(String name);
	
	Map<String,String> getUserInfo(String userID);

	int validateProject(String name);

	Map<String, String> getProjectInfo(String projectID);

	void saveUserInfo(UserVO vo);

	void updateProject(String projectID, String projectDESC, String step);

	int validateGys_name(String name);

	void saveApply_gys(RegisterApplyGYS vo);

	int validateGS_Name(String name);

	void register_gs(RegisterApplyGS vo);

	List<RegisterApplyGS> listCompanyApply(String startTime, String endTime, String approveStatus);

	List<Company> initCompanySelectOption();

	int validateXM_name(String name);

	void register_xm(RegisterApplyXM vo);

	void newMachineApply(newMachineApplyVO vo);

	Map<String, String> getApplyUserInfo(String userID);

	List<newMachineApplyVO> listNewMachineApply(String begintimequery, String endtimequery, String body, String userID);

	void UpdateMachineApply(String applyID, String filePath);

	List<applyMachineInfoVO> listApplyDetail(String applyID);
}
