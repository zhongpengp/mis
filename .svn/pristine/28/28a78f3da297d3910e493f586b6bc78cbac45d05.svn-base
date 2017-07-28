package common.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.persistent.CompanyMapper;
import common.persistent.ProjectMapper;
import common.persistent.RegisterApplyGSMapper;
import common.persistent.RegisterApplyGYSMapper;
import common.persistent.RegisterApplyXMMapper;
import common.persistent.SupplierMapper;
import common.persistent.UserVOMapper;
import common.vo.Company;
import common.vo.Project;
import common.vo.RegisterApplyGS;
import common.vo.RegisterApplyGSExample;
import common.vo.RegisterApplyGSExample.Criteria;
import common.vo.RegisterApplyGYS;
import common.vo.RegisterApplyGYSExample;
import common.vo.RegisterApplyQueryVO_gs;
import common.vo.RegisterApplyQueryVO_gys;
import common.vo.RegisterApplyQueryVO_xm;
import common.vo.RegisterApplyXM;
import common.vo.RegisterApplyXMExample;
import common.vo.Supplier;
import common.vo.UserVO;
import mail.persistent.UserMailMapper;
import mail.service.MailService;
import mail.vo.UserMail;
import util.UUID_Util;

@Service
public class ApprovalRegisterService {

	@Autowired
	private RegisterApplyGSMapper registerApplyGSMapper;
	@Autowired
	private RegisterApplyGYSMapper registerApplyGYSMapper;
	@Autowired
	private RegisterApplyXMMapper registerApplyXMMapper;

	@Autowired
	private UserVOMapper userVOMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private UserMailMapper userMailMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private MailService mailService;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

	public List<RegisterApplyGS> getRegisterApplyList_gs(RegisterApplyQueryVO_gs vo) {
		String approvalState = vo.getApprovalState();
		String applyDate1 = vo.getApplyDate1();
		String applyDate2 = vo.getApplyDate2();
		String companyName = vo.getCompanyName();
		String companyName_jingque = vo.getCompanyName_jingque();
		RegisterApplyGSExample example = new RegisterApplyGSExample();
		example.clear();
		Criteria criteria = example.createCriteria();
		if (approvalState != null && !approvalState.equals("")) {
			criteria.andApplyStateEqualTo(Integer.valueOf(approvalState));
		}
		if (applyDate1 != null && !applyDate1.equals("")) {
			try {
				criteria.andApplyGsTimeGreaterThanOrEqualTo(dateFormat.parse(applyDate1));
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		if (applyDate2 != null && !applyDate2.equals("")) {
			try {
				criteria.andApplyGsTimeLessThanOrEqualTo(dateFormat.parse(applyDate2));
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		if (companyName != null && !companyName.equals("")) {
			if ("1".equals(companyName_jingque)) {
				criteria.andApplyGsNameEqualTo(companyName);
			} else {
				criteria.andApplyGsNameLike(companyName);
			}
		}
		return registerApplyGSMapper.selectByExample(example);
	}

	public RegisterApplyGS getApplyByID(String applyID) {
		return registerApplyGSMapper.selectByPrimaryKey(applyID);
	}

	@Transactional
	public void approvalApply_gs(String applyID, String applyState, String replyDetail) {
		RegisterApplyGS apply = registerApplyGSMapper.selectByPrimaryKey(applyID);
		if (applyState.equals("2")) {// 通过
			String userID = UUID_Util.getUUID();
			try {
				// 1.注册状态设为通过
				apply.setApplyState(2);
				apply.setReplyDetail(replyDetail);
				registerApplyGSMapper.updateByPrimaryKey(apply);
				// 2.插入用户

				UserVO user = new UserVO();
				user.setUserId(userID);
				user.setApplyId(applyID);
				user.setLoginName(apply.getApplyGsName());
				user.setLoginPassword(apply.getApplyGsUserIdnum().substring(apply.getApplyGsUserIdnum().length() - 6));
				user.setPhoneNum(apply.getApplyGsUserPhone());
				user.setUserType("1");
				user.setUserName(apply.getApplyGsUserName());
				user.setUserStatue("0");
				userVOMapper.insert(user);
				// 3.插入公司信息
				Company company = new Company();
				company.setGsId(userID);
				company.setGsName(apply.getApplyGsName());
				company.setGsDesc(apply.getApplyGsUserDesc());
				company.setGsState(1);
				companyMapper.insert(company);
				// 4.插入邮箱信息
				UserMail mail = new UserMail();
				mail.setUserId(userID);
				mail.setMailAddress(apply.getApplyGsUserEmail());
				mail.setMailName(apply.getApplyGsUserEmail());
				userMailMapper.insert(mail);
				// 5.发送邮件通知
				try {
					mailService.addToSendMail("1", userID, "设备供应与项目管理平台注册结果", "您好，您在本系统注册的公司【" + apply.getApplyGsName()
							+ "】已被审批通过啦！\n请及时登录系统修改个人信息！\n您的登录名为【" + apply.getApplyGsName() + "】密码为您注册时填写的身份证号码后六位！");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				apply.setApplyState(0);
				apply.setReplyDetail(replyDetail);
				registerApplyGSMapper.updateByPrimaryKey(apply);
				userVOMapper.deleteByPrimaryKey(userID);
				companyMapper.deleteByPrimaryKey(userID);
				userMailMapper.deleteByPrimaryKey(userID);
			}
		} else {
			try {
				// 1.注册状态设为不通过
				apply.setApplyState(3);
				apply.setReplyDetail(replyDetail);
				registerApplyGSMapper.updateByPrimaryKey(apply);
				// 2.发送邮件通知
				try {
					mailService.addToSendMail_register_failure("1", apply.getApplyGsUserEmail(), "设备供应与项目管理平台注册结果",
							"您好，您在本系统注册的公司【" + apply.getApplyGsName() + "】审批未被通过！审批意见为【" + replyDetail + "】");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				apply.setApplyState(1);
				apply.setReplyDetail(replyDetail);
				registerApplyGSMapper.updateByPrimaryKey(apply);
			}

		}
	}

	public void approvalApply_gys(String applyID, String applyState, String replyDetail) {
		RegisterApplyGYS apply = registerApplyGYSMapper.selectByPrimaryKey(applyID);
		if (applyState.equals("2")) {// 通过
			String userID = UUID_Util.getUUID();
			try {
				// 1.注册状态设为通过
				apply.setApplyState(2);
				apply.setReplyDetail(replyDetail);
				registerApplyGYSMapper.updateByPrimaryKey(apply);
				// 2.插入用户

				UserVO user = new UserVO();
				user.setUserId(userID);
				user.setApplyId(applyID);
				user.setLoginName(apply.getApplyName());
				user.setLoginPassword(apply.getApplyUserIdnum().substring(apply.getApplyUserIdnum().length() - 6));
				user.setPhoneNum(apply.getApplyUserPhone());
				user.setUserType("3");
				user.setUserName(apply.getApplyUserName());
				user.setUserStatue("0");
				userVOMapper.insert(user);
				// 3.插入供应商信息
				Supplier supplier = new Supplier();
				supplier.setSupplierId(userID);
				supplier.setSupplierName(apply.getApplyName());
				supplier.setSupplierDesc(apply.getApplyDesc());
				supplier.setSupplierState(1);
				supplierMapper.insert(supplier);
				// 4.插入邮箱信息
				UserMail mail = new UserMail();
				mail.setUserId(userID);
				mail.setMailAddress(apply.getApplyUserEmail());
				mail.setMailName(apply.getApplyUserEmail());
				userMailMapper.insert(mail);
				// 5.发送邮件通知
				try {
					mailService.addToSendMail("1", userID, "设备供应与项目管理平台注册结果", "您好，您在本系统注册的供应商【" + apply.getApplyName()
							+ "】已被审批通过啦！\n请及时登录系统修改个人信息！\n您的登录名为【" + apply.getApplyName() + "】密码为您注册时填写的身份证号码后六位！");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				apply.setApplyState(0);
				apply.setReplyDetail(replyDetail);
				registerApplyGYSMapper.updateByPrimaryKey(apply);
				userVOMapper.deleteByPrimaryKey(userID);
				supplierMapper.deleteByPrimaryKey(userID);
				userMailMapper.deleteByPrimaryKey(userID);
			}
		} else {
			try {
				// 1.注册状态设为不通过
				apply.setApplyState(3);
				apply.setReplyDetail(replyDetail);
				registerApplyGYSMapper.updateByPrimaryKey(apply);
				// 2.发送邮件通知
				try {
					mailService.addToSendMail_register_failure("1", apply.getApplyUserEmail(), "设备供应与项目管理平台注册结果",
							"您好，您在本系统注册的供应商【" + apply.getApplyName() + "】审批未被通过！审批意见为【" + replyDetail + "】");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				apply.setApplyState(1);
				apply.setReplyDetail(replyDetail);
				registerApplyGYSMapper.updateByPrimaryKey(apply);
			}

		}
	}

	public void approvalApply_xm(String applyID, String applyState, String replyDetail) {
		RegisterApplyXM apply = registerApplyXMMapper.selectByPrimaryKey(applyID);
		if (applyState.equals("2")) {// 通过
			String userID = UUID_Util.getUUID();
			try {
				// 1.注册状态设为通过
				apply.setApplyStatue(applyState);
				apply.setApprovalDetail(replyDetail);
				registerApplyXMMapper.updateByPrimaryKey(apply);
				// 2.插入用户
				UserVO user = new UserVO();
				user.setUserId(userID);
				user.setApplyId(applyID);
				user.setLoginName(apply.getProjectName());
				user.setLoginPassword(apply.getIdcardNum().substring(apply.getIdcardNum().length() - 6));
				user.setPhoneNum(apply.getPhoneNum());
				user.setUserType("2");
				user.setUserName(apply.getApplierName());
				user.setUserStatue("0");
				userVOMapper.insert(user);
				// 3.插入项目信息
				Project project = new Project();
				project.setCompanyId(apply.getCompanyId());
				project.setProjectDetail(apply.getProjectDetail());
				project.setProjectId(userID);
				project.setProjectName(apply.getProjectName());
				project.setProjectStatue("0");
				project.setProjectType(apply.getProjectType());
				project.setUserId(userID);
				project.setProjectStep("0");
				projectMapper.insert(project);
				// 4.插入邮箱信息
				UserMail mail = new UserMail();
				mail.setUserId(userID);
				mail.setMailAddress(apply.getEmail());
				mail.setMailName(apply.getEmail());
				userMailMapper.insert(mail);
				// 5.发送邮件通知
				try {
					mailService.addToSendMail("1", userID, "设备供应与项目管理平台注册结果", "您好，您在本系统注册的项目【" + apply.getProjectName()
							+ "】已被审批通过啦！\n请及时登录系统修改个人信息！\n您的登录名为【" + apply.getProjectName() + "】密码为您注册时填写的身份证号码后六位！");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				apply.setApplyStatue("3");
				apply.setApprovalDetail(replyDetail);
				registerApplyXMMapper.updateByPrimaryKey(apply);
				userVOMapper.deleteByPrimaryKey(userID);
				projectMapper.deleteByPrimaryKey(userID);
				userMailMapper.deleteByPrimaryKey(userID);
				System.out.println(e);
			}
		} else {
			try {
				// 1.注册状态设为不通过
				apply.setApplyStatue("3");
				apply.setApprovalDetail(replyDetail);
				registerApplyXMMapper.updateByPrimaryKey(apply);
				// 2.发送邮件通知
				try {
					mailService.addToSendMail_register_failure("1", apply.getEmail(), "设备供应与项目管理平台注册结果",
							"您好，您在本系统注册的项目【" + apply.getProjectName() + "】审批未被通过！审批意见为【" + replyDetail + "】");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				apply.setApplyStatue("1");
				apply.setApprovalDetail(replyDetail);
				registerApplyXMMapper.updateByPrimaryKey(apply);
			}

		}
	}

	public List<RegisterApplyGYS> getRegisterApplyList_gys(RegisterApplyQueryVO_gys vo) {
		String approvalState = vo.getApprovalState();
		String applyDate1 = vo.getApplyDate1();
		String applyDate2 = vo.getApplyDate2();
		String supplierName = vo.getSupplierName();
		String supplierName_jingque = vo.getSupplierName_jingque();
		RegisterApplyGYSExample example = new RegisterApplyGYSExample();
		example.clear();
		RegisterApplyGYSExample.Criteria criteria = example.createCriteria();
		if (approvalState != null && !approvalState.equals("")) {
			criteria.andApplyStateEqualTo(Integer.valueOf(approvalState));
		}
		if (applyDate1 != null && !applyDate1.equals("")) {
			try {
				criteria.andApplyDateGreaterThanOrEqualTo(dateFormat.parse(applyDate1));
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		if (applyDate2 != null && !applyDate2.equals("")) {
			try {
				criteria.andApplyDateLessThanOrEqualTo(dateFormat.parse(applyDate2));
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		if (supplierName != null && !supplierName.equals("")) {
			if ("1".equals(supplierName_jingque)) {
				criteria.andApplyNameEqualTo(supplierName);
			} else {
				criteria.andApplyNameLike(supplierName);
			}
		}
		return registerApplyGYSMapper.selectByExample(example);
	}

	public RegisterApplyGYS getGYSApplyByID(String applyID) {
		return registerApplyGYSMapper.selectByPrimaryKey(applyID);
	}

	public List<RegisterApplyXM> getRegisterApplyList_xm(RegisterApplyQueryVO_xm vo) {
		String companyID = vo.getCompanyID();
		String approvalState = vo.getApprovalState();
		String applyDate1 = vo.getApplyDate1();
		String applyDate2 = vo.getApplyDate2();
		String projectName = vo.getProjectName();
		String projectName_jingque = vo.getProjectName_jingque();
		RegisterApplyXMExample example = new RegisterApplyXMExample();
		example.clear();
		RegisterApplyXMExample.Criteria criteria = example.createCriteria();
		if (approvalState != null && !approvalState.equals("")) {
			criteria.andApplyStatueEqualTo(approvalState);
		}
		if (applyDate1 != null && !applyDate1.equals("")) {
			try {
				criteria.andApplyTimeGreaterThanOrEqualTo(dateFormat.parse(applyDate1));
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		if (applyDate2 != null && !applyDate2.equals("")) {
			try {
				criteria.andApplyTimeLessThanOrEqualTo(dateFormat.parse(applyDate2));
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		if (projectName != null && !projectName.equals("")) {
			if ("1".equals(projectName_jingque)) {
				criteria.andProjectNameEqualTo(projectName);
			} else {
				criteria.andProjectNameLike(projectName);
			}
		}
		criteria.andCompanyIdEqualTo(companyID);
		return registerApplyXMMapper.selectByExample(example);
	}

	public RegisterApplyXM getXMApplyByID(String applyID) {
		return registerApplyXMMapper.selectByPrimaryKey(applyID);
	}

}
