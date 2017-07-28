package supplierMng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.persistent.GS_GYSMapper;
import common.persistent.SupplierMapper;
import common.persistent.UserVOMapper;
import common.persistent.XM_GYSMapper;
import common.vo.GS_GYS;
import common.vo.GS_GYSExample;
import common.vo.XM_GYS;
import common.vo.XM_GYSExample;
import common.vo.XM_GYSExample.Criteria;
import supplierMng.vo.CompanySupplierApplyReturnVo;
import supplierMng.vo.ProjectSupplierApplyReturnVo;
import supplierMng.vo.SuppliersRetuenVO;

@Service
public class SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private UserVOMapper userVOMapper;
	@Autowired
	private GS_GYSMapper gs_GYSMapper;
	@Autowired
	private XM_GYSMapper xm_GYSMapper;

	public List<SuppliersRetuenVO> getCompanySuppliers(String companyID) {
		return supplierMapper.getCompanySuppliers(companyID);
	}

	public void addCompanySuppliersByIDs(String companyID, List<String> supplierIDs) {
		for (String supplierID : supplierIDs) {
			try {
				GS_GYS vo = new GS_GYS();
				vo.setGsUserId(companyID);
				vo.setGysUserId(supplierID);
				vo.setApplyState(1);
				gs_GYSMapper.insert(vo);
			} catch (Exception e) {
				continue;
			}
		}
	}

	public List<SuppliersRetuenVO> getCompanyNotOwnerSuppliers(String companyID) {
		return supplierMapper.getCompanyNotOwnerSuppliers(companyID);
	}

	public void reReplyCompanySuppliersByID(String companyID, String supplierID) {
		gs_GYSMapper.reReplyCompanySuppliersByID(companyID,supplierID);
	}

	public void removeCompanySuppliersByID(String companyID, List<String> list) {
		//删除公司-供应商信息
		GS_GYSExample gs_gysExample = new GS_GYSExample();
		gs_gysExample.createCriteria().andGsUserIdEqualTo(companyID).andGysUserIdIn(list);
		gs_GYSMapper.deleteByExample(gs_gysExample);
		
		//删除项目-供应商信息
		xm_GYSMapper.removeProjectSuppliersByCompanyID(companyID,list);
	}

	public List<SuppliersRetuenVO> getProjectNotOwnerSuppliers(String projectID,String companyID) {
		return supplierMapper.getProjectNotOwnerSuppliers(projectID,companyID);
	}

	public void addProjectSuppliersByIDs(String projectID, List<String> supplierIDs) {
		for (String supplierID : supplierIDs) {
			try {
				XM_GYS vo = new XM_GYS();
				vo.setXmUserId(projectID);
				vo.setGysUserId(supplierID);
				vo.setApplyState(1);
				xm_GYSMapper.insert(vo);
			} catch (Exception e) {
				continue;
			}
		}
	}

	public void removeProjectSuppliersByID(String projectID, List<String> asList) {
		XM_GYSExample example = new XM_GYSExample();
		Criteria criteria = example.createCriteria();
		criteria.andXmUserIdEqualTo(projectID).andGysUserIdIn(asList);
		xm_GYSMapper.deleteByExample(example);
	}

	public List<CompanySupplierApplyReturnVo> getApprovalSupplierApplyFromGS(String supplierID) {
		return supplierMapper.getApprovalSupplierApplyFromGS(supplierID);
	}

	public void passCompanySupplierApproval(String supplierID, List<String> list) {
		GS_GYSExample example = new GS_GYSExample();
		example.createCriteria().andGysUserIdEqualTo(supplierID).andGsUserIdIn(list);
		List<GS_GYS> gs_gys = gs_GYSMapper.selectByExample(example);
		for (GS_GYS gs_GYS2 : gs_gys) {
			gs_GYS2.setApplyState(2);
			gs_GYSMapper.updateByPrimaryKey(gs_GYS2);
		}
	}

	public void notPassCompanySupplierApproval(String supplierID, List<String> asList) {
		GS_GYSExample example = new GS_GYSExample();
		example.createCriteria().andGysUserIdEqualTo(supplierID).andGsUserIdIn(asList);
		List<GS_GYS> gs_gys = gs_GYSMapper.selectByExample(example);
		for (GS_GYS gs_GYS2 : gs_gys) {
			gs_GYS2.setApplyState(3);
			gs_GYSMapper.updateByPrimaryKey(gs_GYS2);
		}
	}

	public List<ProjectSupplierApplyReturnVo> getapprovalSupplierApplyFromXM(String supplierID) {
		return supplierMapper.getapprovalSupplierApplyFromXM(supplierID);
	}

	public void passProjectSupplierApproval(String supplierID, List<String> asList) {
		XM_GYSExample example = new XM_GYSExample();
		example.createCriteria().andGysUserIdEqualTo(supplierID).andXmUserIdIn(asList);
		List<XM_GYS> xm_gys = xm_GYSMapper.selectByExample(example);
		for (XM_GYS xm_GYS2 : xm_gys) {
			xm_GYS2.setApplyState(2);
			xm_GYSMapper.updateByPrimaryKey(xm_GYS2);
		}
	}
	
	public void notPassProjectSupplierApproval(String supplierID, List<String> asList) {
		XM_GYSExample example = new XM_GYSExample();
		example.createCriteria().andGysUserIdEqualTo(supplierID).andXmUserIdIn(asList);
		List<XM_GYS> xm_gys = xm_GYSMapper.selectByExample(example);
		for (XM_GYS xm_GYS2 : xm_gys) {
			xm_GYS2.setApplyState(3);
			xm_GYSMapper.updateByPrimaryKey(xm_GYS2);
		}
	}

	public void reReplyProjectSuppliersByID(String projectID, String supplierID) {
		xm_GYSMapper.reReplyProjectSuppliersByID(projectID,supplierID);
	}
	

}
