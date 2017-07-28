package common.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import common.persistent.ProjectMapper;
import common.persistent.SupplierMapper;
import common.persistent.UserVOMapper;
import common.persistent.XM_GYSMapper;
import common.vo.CompanyProjectsQueryVO;
import common.vo.Project;
import common.vo.ProjectDetailReturnVO;
import common.vo.ProjectExample;
import common.vo.ProjectExample.Criteria;
import common.vo.RepairMachineVO;
import common.vo.UnCheckMachineVO;
import common.vo.UserVO;
import mail.persistent.UserMailMapper;
import mail.vo.UserMail;
import supplierMng.vo.SuppliersRetuenVO;
import util.UUID_Util;

@Service
public class ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private UserVOMapper userVOMapper;
	@Autowired
	private UserMailMapper userMailMapper;
	@Autowired
	private XM_GYSMapper xm_GYSMapper;
	@Autowired
	private SupplierMapper supplierMapper;

	public List<Project> getCompanyProjects(CompanyProjectsQueryVO vo) {
		ProjectExample example = new ProjectExample();
		Criteria criteria = example.createCriteria();
		String companyID = vo.getCompanyID();
		String projectName = vo.getProjectName();
		String projectType = vo.getProjectType();
		String projectState = vo.getProjectState();
		String projectName_isExact = vo.getProjectName_isExact();
		criteria.andCompanyIdEqualTo(companyID);
		if (projectType != null && !projectType.equals("")) {
			criteria.andProjectTypeEqualTo(projectType);
		}
		if (projectState != null && !projectState.equals("")) {
			criteria.andProjectStepEqualTo(projectState);
		}
		if (projectName != null && !projectName.equals("")) {
			if ("1".equals(projectName_isExact)) {
				criteria.andProjectNameEqualTo(projectName);
			} else {
				criteria.andProjectNameLike(projectName);
			}
		}
		return projectMapper.selectByExample(example);
	}

	public ProjectDetailReturnVO getProjectDetailByID(String projectID) {
		Project project = projectMapper.selectByPrimaryKey(projectID);
		UserVO user = userVOMapper.selectByPrimaryKey(projectID);
		UserMail mail = userMailMapper.selectByPrimaryKey(projectID);
		ProjectDetailReturnVO result = new ProjectDetailReturnVO();
		result.setPerson_birthday(user.getBirthday());
		result.setPerson_email(mail.getMailAddress());
		result.setPerson_name(user.getUserName());
		result.setPerson_phone(user.getPhoneNum());
		result.setPerson_sex(user.getSex());
		result.setProject_desc(project.getProjectDetail());
		result.setProject_name(project.getProjectName());
		result.setProject_state(project.getProjectStatue());
		result.setProject_step(project.getProjectStep());
		result.setProject_type(project.getProjectType());
		return result;
	}

	public List<SuppliersRetuenVO> getProjectSuppliers(String projectID) {
		return supplierMapper.getProjectSuppliers(projectID);
	}
	
	public List<UnCheckMachineVO> getUncheckList(String projectId,String macName, String startTime, String endTime) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("projectId",projectId );
		map.put("macName", macName);
		map.put("startTime",startTime );
		map.put("endTime", endTime);
		List<UnCheckMachineVO> list = projectMapper.getUncheckList(map);
		return list;
	}
	
	public List<UnCheckMachineVO> getCheckedList(String projectId, String macName, String startTime, String endTime) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("projectId",projectId );
		map.put("macName", macName);
		map.put("startTime",startTime );
		map.put("endTime", endTime);
		List<UnCheckMachineVO> list = projectMapper.getCheckedList(map);
		return list;
	}

	public void inserCheckMachine(UnCheckMachineVO vo) {
		vo.setId(UUID_Util.getUUID());
		vo.setCheckState("1");
		projectMapper.inserCheckMachine(vo);
		int period = Integer.parseInt(vo.getCheckPeriod());
		try {
			SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date next = sdf.parse(vo.getCheckDate());
			Calendar ca = Calendar.getInstance();
			ca.setTime(next);
			ca.add(Calendar.MONTH, period);
			next = ca.getTime();
			vo.setCheckDate(sdf.format(next));
		} catch (ParseException e) {
		}
		projectMapper.updateMachine(vo);
	}

	public List<RepairMachineVO> getUnRepairList(String projectId, String macName) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("projectId",projectId );
		map.put("macName", macName);
		return projectMapper.getUnRepairList(map);
	}

	public List<RepairMachineVO> getRepairedList(String projectId, String macName) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("projectId",projectId );
		map.put("macName", macName);
		return projectMapper.getRepairedList(map);
	}

	public void inserRepairMachine(RepairMachineVO vo) {
		vo.setId(UUID_Util.getUUID());
		vo.setRepairDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		vo.setZhibaoqi(vo.getZhibaoqi().substring(0, 10));
		projectMapper.inserRepairMachine(vo);
		projectMapper.updateMachineState(vo.getMachineId());
	}

	public void machineDestroy(String ids) {
		ids = "'"+ids.replace(",", "','")+"'";
		projectMapper.machineDestroy(ids);
		
	}

	
}
