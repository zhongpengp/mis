package baseMachineMng.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baseMachineMng.persistent.Project_Instrument_InfoMapper;
import baseMachineMng.persistent.Project_Instrument_Info_TempMapper;
import baseMachineMng.vo.ImportProjectMachineInfoReturnVO;
import baseMachineMng.vo.ImportProjectMachineInfo_gsReturnVO;
import baseMachineMng.vo.Project_Instrument_Info;
import baseMachineMng.vo.Project_Instrument_InfoExample;
import baseMachineMng.vo.Project_Instrument_InfoExample.Criteria;
import baseMachineMng.vo.Project_Instrument_Info_Temp;
import baseMachineMng.vo.Project_Instrument_Info_TempExample;
import baseMachineMng.vo.SendOutProjectMachineInfo;
import baseMachineMng.vo.SendOutProjectMachineInfo_gs;
import common.vo.applyMachineInfoVO;
import log.persistent.ApplyMapper;
import mail.service.MailService;
import util.UUID_Util;

@Service
public class ProjectMachineImportService {
	@Autowired
	private MailService mailService; 
	@Autowired
	private ApplyMapper applyMapper; 
	@Autowired
	private Project_Instrument_Info_TempMapper project_Instrument_Info_TempMapper;
	@Autowired
	private Project_Instrument_InfoMapper project_Instrument_InfoMapper;

	public List<ImportProjectMachineInfoReturnVO> getImportedProjectMachineInfo(String supplierID) {
		return project_Instrument_Info_TempMapper.getImportedProjectMachineInfo(supplierID);
	}

	public ArrayList<String[]> insertMachine_temp(ArrayList<String[]> s, String projectID, String supplierID) {
		ArrayList<String[]> resultMessage = new ArrayList<>();
		if (s.size() == 0) {
			String messgae[] = new String[2];
			messgae[0] = "设备信息导入失败！";
			messgae[1] = "未从Excel中读取到数据！";
			resultMessage.add(messgae);
		} else {
			int index = 0;
			int successIndex = 0;
			int errorIndex = 0;
			for (String machineInfo[] : s) {
				String errLog = "";
				index++;
				String messgae[] = new String[2];
				boolean hasError = false;
				if ("设备".equals(machineInfo[0]) || "耗材".equals(machineInfo[0])) {
				} else {
					hasError = true;
					errLog += "【设备类型不正确，只能填写“设备”或“耗材”】";
				}
				if (machineInfo[1] == null || machineInfo[1].equals("")) {
					hasError = true;
					errLog += "【设备名称不可为空】";
				}
				if (machineInfo[2] == null || machineInfo[2].equals("")) {
					hasError = true;
					errLog += "【设备型号不可为空】";
				}
				if (machineInfo[3] == null || machineInfo[3].equals("")) {
					hasError = true;
					errLog += "【设备规格不可为空】";
				}
				if (machineInfo[4] == null || machineInfo[4].equals("")) {
					hasError = true;
					errLog += "【设备数量不可为空】";
				} else {
					try {
						double num = Double.valueOf(machineInfo[4]);
					} catch (Exception e) {
						hasError = true;
						errLog += "【设备数量不正确，请填写数字】";
					}
				}
				if (machineInfo[6] == null || machineInfo[6].equals("")) {
					hasError = true;
					errLog += "【计量单位不可为空】";
				}
				if (machineInfo[7] == null || machineInfo[7].equals("")) {
					hasError = true;
					errLog += "【生产厂家不可为空】";
				}
				if (machineInfo[8] == null || machineInfo[8].equals("")) {
					hasError = true;
					errLog += "【设备单价不可为空】";
				} else {
					try {
						double num = Double.valueOf(machineInfo[8]);
					} catch (Exception e) {
						hasError = true;
						errLog += "【设备单价不正确，请填写数字】";
					}
				}
				if (hasError) {
					errorIndex++;
					messgae[0] = "处理第" + index + "条数据-->";
					messgae[1] = "失败：" + "【类型：" + machineInfo[0] + "】【名称：" + machineInfo[1] + "】【型号：" + machineInfo[2]
							+ "】【规格：" + machineInfo[3] + "】【数量：" + machineInfo[4] + "】【单价：" + machineInfo[8] + "】"
							+ "【该行数据存在问题，请检查后重新导入该行数据！】具体错误如下：" + errLog;
					resultMessage.add(messgae);
					continue;
				}
				Project_Instrument_Info_Temp machine = new Project_Instrument_Info_Temp();
				try {
					machine.init(machineInfo, projectID, supplierID);
					project_Instrument_Info_TempMapper.insert(machine);
					successIndex++;
					messgae[0] = "处理第" + index + "条数据-->";
					messgae[1] = "成功：【类型：" + machineInfo[0] + "】【名称：" + machineInfo[1] + "】【型号：" + machineInfo[2]
							+ "】【规格：" + machineInfo[3] + "】【数量：" + machineInfo[4] + "】【单价：" + machineInfo[8] + "】";
					resultMessage.add(messgae);
				} catch (Exception e) {
					errorIndex++;
					System.out.println(e);
					messgae[0] = "处理第" + index + "条数据-->";
					messgae[1] = "失败：【类型：" + machineInfo[0] + "】【名称：" + machineInfo[1] + "】【型号：" + machineInfo[2]
							+ "】【规格：" + machineInfo[3] + "】【数量：" + machineInfo[4] + "】【单价：" + machineInfo[8]
							+ "】【数据异常，请修改Excel数据后重试，或手动录入该条记录】详细异常：" + e.getMessage();
					resultMessage.add(messgae);
					continue;
				}
			}
			String resultAll[] = new String[2];
			resultAll[0] = "所有数据处理完毕";
			resultAll[1] = "所有数据处理完毕，共处理" + s.size() + "条数据###成功" + successIndex + "条，失败" + errorIndex + "条。";
			resultMessage.add(resultAll);
		}
		return resultMessage;
	}

	public List<Project_Instrument_Info_Temp> getImportedMachineDetail(String supplierID, String projectID,
			String applyState) {
		Project_Instrument_Info_TempExample example = new Project_Instrument_Info_TempExample();
		if (applyState.equals("0")) {
			example.createCriteria().andSupplierIdEqualTo(supplierID).andProjectIdEqualTo(projectID);
		} else {
			example.createCriteria().andSupplierIdEqualTo(supplierID).andProjectIdEqualTo(projectID)
					.andApplyStateEqualTo(Integer.valueOf(applyState));
		}
		return project_Instrument_Info_TempMapper.selectByExample(example);
	}

	public List<Project_Instrument_Info_Temp> getImportedMachineDetail_gs(String supplierID, String projectID,
			String applyState) {
		Project_Instrument_Info_TempExample example = new Project_Instrument_Info_TempExample();
		if (applyState.equals("0")) {
			example.createCriteria().andSupplierIdEqualTo(supplierID).andProjectIdEqualTo(projectID)
					.andApplyStateNotEqualTo(1);
		} else {
			example.createCriteria().andSupplierIdEqualTo(supplierID).andProjectIdEqualTo(projectID)
					.andApplyStateEqualTo(Integer.valueOf(applyState));
		}
		return project_Instrument_Info_TempMapper.selectByExample(example);
	}

	public void addSingleMachine(Project_Instrument_Info_Temp vo) {
		vo.setId(UUID_Util.getUUID());
		vo.setApplyTime(new Date());
		vo.setApplyState(1);
		project_Instrument_Info_TempMapper.insert(vo);
	}

	public Project_Instrument_Info_Temp getSingleMachineInfoByID(String machineID) {
		return project_Instrument_Info_TempMapper.selectByPrimaryKey(machineID);
	}

	public void updateSingleMachine(Project_Instrument_Info_Temp vo) {
		vo.setApplyState(1);
		vo.setApplyTime(new Date());
		project_Instrument_Info_TempMapper.updateByPrimaryKeySelective(vo);
	}

	public void removeMachineInfoByIDs(String machineIDs) {
		String ids[] = machineIDs.split(",");
		for (String id : ids) {
			project_Instrument_Info_TempMapper.deleteByPrimaryKey(id);
		}
	}

	public void toSubmitMachineApprovalApply(String projectIDs, String supplierID) {
		project_Instrument_Info_TempMapper.toSubmitMachineApprovalApply(Arrays.asList(projectIDs.split(",")),
				supplierID);
	}

	public List<ImportProjectMachineInfo_gsReturnVO> getImportedProjectMachineInfo_gs(String companyID) {
		return project_Instrument_Info_TempMapper.getImportedProjectMachineInfo_gs(companyID);
	}

	public void toPassApprovalApply(String machineIDs) {
		List<String> machineIDList = Arrays.asList(machineIDs.split(","));
		List<String> insertIDList = new ArrayList<>();
		try {
			// 1.修改设备申请状态
			project_Instrument_Info_TempMapper.toPassApprovalApply(machineIDList);
			// 2.将设备插入正式表
			for (String machineID : machineIDList) {
				Project_Instrument_Info_Temp temp = project_Instrument_Info_TempMapper.selectByPrimaryKey(machineID);
				Project_Instrument_Info info = new Project_Instrument_Info();
				info.setGyxId(temp.getSupplierId());
				info.setProjectId(temp.getProjectId());
				info.setMachineName(temp.getMachineName());
				info.setMachineType(temp.getMachineType());
				info.setMachineSize(temp.getMachineSize());
				info.setMachineClassify(temp.getMachineClassify());
				info.setRangeJingdu(temp.getRangeJingdu());
				info.setUnit(temp.getUnit());
				info.setUnitPrice(temp.getUnitPrice());
				info.setProducer(temp.getProducer());
				info.setRemark(temp.getRemark());
				info.setMachineState("4");// 待发货
				int num = temp.getMachineNum();
				for (int i = 0; i < num; i++) {
					info.setId(UUID_Util.getUUID());
					project_Instrument_InfoMapper.insert(info);
					insertIDList.add(info.getId());
				}
			}
		} catch (Exception e) {
			project_Instrument_Info_TempMapper.toResetApprovalApply(machineIDList);
			project_Instrument_InfoMapper.deleteErrorByIDs(insertIDList);
			throw e;
		}

	}

	public void toNotPassApprovalApply(String machineIDs) {
		List<String> machineIDList = Arrays.asList(machineIDs.split(","));
		try {
			// 1.修改设备申请状态
			project_Instrument_Info_TempMapper.toNotPassApprovalApply(machineIDList);
		} catch (Exception e) {
			project_Instrument_Info_TempMapper.toResetApprovalApply(machineIDList);
			throw e;
		}
	}

	public List<SendOutProjectMachineInfo> getSendOutProjectMachineInfo_gys(String supplierID) {
		return project_Instrument_InfoMapper.getSendOutProjectMachineInfo_gys(supplierID);
	}
	
	public List<SendOutProjectMachineInfo_gs> getProjectMachineInfo_gs(String companyID) {
		return project_Instrument_InfoMapper.getProjectMachineInfo_gs(companyID);
	}

	public List<Project_Instrument_Info> viewSendOutMachineDetail_gys(String projectID, String supplierID,
			String machineState) {
		Project_Instrument_InfoExample example = new Project_Instrument_InfoExample();
		example.createCriteria().andProjectIdEqualTo(projectID).andMachineStateEqualTo(machineState).andGyxIdEqualTo(supplierID);
		return project_Instrument_InfoMapper.selectByExample(example);
	}
	public List<Project_Instrument_Info> viewMachineDetail_gs(String projectID, String supplierID,
			String machineState) {
		Project_Instrument_InfoExample example = new Project_Instrument_InfoExample();
		example.createCriteria().andProjectIdEqualTo(projectID).andMachineStateEqualTo(machineState).andGyxIdEqualTo(supplierID);
		return project_Instrument_InfoMapper.selectByExample(example);
	}
	
	public List<Project_Instrument_Info> getProjectMachineInfo_xm(String projectID, String machineState, String machineName) {
		Project_Instrument_InfoExample example = new Project_Instrument_InfoExample();
		Criteria c = example.createCriteria();
		c.andProjectIdEqualTo(projectID);
		if(machineName!=null && !machineName.equals("")&& !machineName.equals("null")){
			c.andMachineNameLike(machineName);
		}
		if(!machineState.equals("all")){
			c.andMachineStateEqualTo(machineState);
		}
		return project_Instrument_InfoMapper.selectByExample(example);
	}
	
	public void toSendOutMachines(String machineIDs) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String context = "<table><tr><td>设备名称</td><td>设备规格</td><td>设备型号</td><td>数量</td><td>发货时间</td></tr>";
		String projectID = null;
		String supplierID = null;
		String ids[] = machineIDs.split(",");
		for (String id : ids) {
			Project_Instrument_Info vo = project_Instrument_InfoMapper.selectByPrimaryKey(id);
			if(projectID==null||supplierID==null){
				projectID = vo.getProjectId();
				supplierID = vo.getGyxId();
			}
			context+="<tr><td>"+vo.getMachineName()+"</td>";
			context+="<td>"+vo.getMachineSize()+"</td>";
			context+="<td>"+vo.getMachineType()+"</td>";
			context+="<td>1</td>";
			context+="<td>"+format.format(new Date())+"</td></tr>";
			try {
				vo.setSendDate(new Date());
				vo.setMachineState("5");
				project_Instrument_InfoMapper.updateByPrimaryKeySelective(vo);
			} catch (Exception e) {
				System.out.println(e);
				try {
					vo.setMachineState("4");
					project_Instrument_InfoMapper.updateByPrimaryKeySelective(vo);
				} catch (Exception e1) {
					System.out.println(e1);
					continue;
				}
				throw e;
			}
		}
		context+="</table>";
		try {
			mailService.addMachineSengOutMail(projectID, supplierID, context);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<String[]> applyMachineInfo(ArrayList<String[]> data, String applyID) {
		ArrayList<String[]> resultMessage = new ArrayList<>();
		if (data.size() == 0) {
			String messgae[] = new String[2];
			messgae[0] = "申请设备信息导入失败！";
			messgae[1] = "未从Excel中读取到数据！";
			resultMessage.add(messgae);
		} else {
			int index = 0;
			int successIndex = 0;
			int errorIndex = 0;
			for (String grade[] : data) {
				index++;
				String messgae[] = new String[2];
				boolean hasEmpty = false;
				for (String string : grade) {
					if (string.equals("")) {
						hasEmpty = true;
						break;
					}
				}
				if (hasEmpty) {
					errorIndex++;
					messgae[0] = "处理第" + index + "条数据-->";
					messgae[1] = "失败：【该行记录存在空值，请检查】";
					resultMessage.add(messgae);
					continue;
				}
				applyMachineInfoVO tableTatol = new applyMachineInfoVO();
				try {
					tableTatol.init(grade, applyID);
					applyMapper.addApplyMachineInfo(tableTatol);
					successIndex++;
				} catch (Exception e) {
					errorIndex++;
					System.out.println(e);
					messgae[0] = "处理第" + index + "条数据-->";
					messgae[1] = "失败：【数据异常，请修改Excel数据后重试，或手动录入该条记录】详细异常：" + e.getMessage();
					resultMessage.add(messgae);
					continue;
				}
			}
			String resultAll[] = new String[2];
			resultAll[0] = "所有数据处理完毕";
			resultAll[1] = "所有数据处理完毕，共处理" + data.size() + "条数据###成功" + successIndex + "条，失败" + errorIndex + "条。";
			resultMessage.add(resultAll);
		}
		return resultMessage;
	}

	public void saveMachineSendInInfo(String id, String form_1, String form_2, String form_3, String form_4,
			String form_5, String form_6, String form_7) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Project_Instrument_Info vo = new Project_Instrument_Info();
		vo.setId(id);
		vo.setProducerOrd(form_1);
		vo.setOldNew(form_2);
		vo.setCheckPeriod(form_3);
		vo.setMachineState("0");
		vo.setRepairNum(0);
		try {
			vo.setImportDate(format.parse(form_4));
		} catch (ParseException e) {
			e.printStackTrace();
			vo.setImportDate(new Date());
		}
		try {
			vo.setInstallDate(format.parse(form_5));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			vo.setInstallDate(new Date());
			e.printStackTrace();
		}
		try {
			vo.setCheckDate(format.parse(form_6));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setCheckDate(new Date());
		}
		try {
			vo.setBaozhiqi(format.parse(form_7));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setBaozhiqi(new Date());
		}
		project_Instrument_InfoMapper.updateByPrimaryKeySelective(vo);
		try {
			Project_Instrument_Info machine = project_Instrument_InfoMapper.selectByPrimaryKey(id);
			mailService.addMachineSengInMail(machine);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void machineToRepareOrXianzhi(String machineIDs, String state) {
		project_Instrument_InfoMapper.machineToRepareOrXianzhi(Arrays.asList(machineIDs.split(",")),state);
	}


}
