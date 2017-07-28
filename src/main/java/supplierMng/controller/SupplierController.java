package supplierMng.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import supplierMng.service.SupplierService;
import supplierMng.vo.CompanySupplierApplyReturnVo;
import supplierMng.vo.ProjectSupplierApplyReturnVo;
import supplierMng.vo.SuppliersRetuenVO;

@Controller
@EnableWebMvc
@RequestMapping("/supplierController")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@ResponseBody
	@RequestMapping("getCompanySuppliers")
	public List<SuppliersRetuenVO> getCompanySuppliers(String companyID){
		return supplierService.getCompanySuppliers(companyID);
	}
	
	@ResponseBody
	@RequestMapping("addCompanySuppliersByIDs")
	public void addCompanySuppliersByIDs(String companyID,String supplierIDs){
		String[] ids = supplierIDs.split(",");
		supplierService.addCompanySuppliersByIDs(companyID,Arrays.asList(ids));
	}
	
	@ResponseBody
	@RequestMapping("addProjectSuppliersByIDs")
	public void addProjectSuppliersByIDs(String projectID,String supplierIDs){
		String[] ids = supplierIDs.split(",");
		supplierService.addProjectSuppliersByIDs(projectID,Arrays.asList(ids));
	}
	
	@ResponseBody
	@RequestMapping("getCompanyNotOwnerSuppliers")
	public List<SuppliersRetuenVO> getCompanyNotOwnerSuppliers(String companyID){
		return supplierService.getCompanyNotOwnerSuppliers(companyID);
	}
	
	@ResponseBody
	@RequestMapping("getProjectNotOwnerSuppliers")
	public List<SuppliersRetuenVO> getProjectNotOwnerSuppliers(String projectID,String companyID){
		return supplierService.getProjectNotOwnerSuppliers(projectID,companyID);
	}
	
	@ResponseBody
	@RequestMapping("reReplyCompanySuppliersByID")
	public void reReplyCompanySuppliersByID(String companyID,String supplierID){
		supplierService.reReplyCompanySuppliersByID(companyID,supplierID);
	}
	
	@ResponseBody
	@RequestMapping("reReplyProjectSuppliersByID")
	public void reReplyProjectSuppliersByID(String projectID,String supplierID){
		supplierService.reReplyProjectSuppliersByID(projectID,supplierID);
	}
	
	@ResponseBody
	@RequestMapping("removeCompanySuppliersByID")
	public void removeCompanySuppliersByID(String companyID,String supplierIDs){
		String[] ids = supplierIDs.split(",");
		supplierService.removeCompanySuppliersByID(companyID,Arrays.asList(ids));
	}
	
	@ResponseBody
	@RequestMapping("removeProjectSuppliersByID")
	public void removeProjectSuppliersByID(String projectID,String supplierIDs){
		String[] ids = supplierIDs.split(",");
		supplierService.removeProjectSuppliersByID(projectID,Arrays.asList(ids));
	}
	
	@ResponseBody
	@RequestMapping("getApprovalSupplierApplyFromGS")
	public List<CompanySupplierApplyReturnVo> getApprovalSupplierApplyFromGS(String supplierID){
		return supplierService.getApprovalSupplierApplyFromGS(supplierID);
	}
	
	@ResponseBody
	@RequestMapping("getapprovalSupplierApplyFromXM")
	public List<ProjectSupplierApplyReturnVo> getapprovalSupplierApplyFromXM(String supplierID){
		List<ProjectSupplierApplyReturnVo> result = supplierService.getapprovalSupplierApplyFromXM(supplierID);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("passCompanySupplierApproval")
	public void passCompanySupplierApproval(String supplierID,String companyIDs){
		String[] ids = companyIDs.split(",");
		supplierService.passCompanySupplierApproval(supplierID,Arrays.asList(ids));
	}
	
	@ResponseBody
	@RequestMapping("notPassCompanySupplierApproval")
	public void notPassCompanySupplierApproval(String supplierID,String companyIDs){
		String[] ids = companyIDs.split(",");
		supplierService.notPassCompanySupplierApproval(supplierID,Arrays.asList(ids));
	}
	
	@ResponseBody
	@RequestMapping("passProjectSupplierApproval")
	public void passProjectSupplierApproval(String supplierID,String projectIDs){
		String[] ids = projectIDs.split(",");
		supplierService.passProjectSupplierApproval(supplierID,Arrays.asList(ids));
	}
	
	@ResponseBody
	@RequestMapping("notPassProjectSupplierApproval")
	public void notPassProjectSupplierApproval(String supplierID,String projectIDs){
		String[] ids = projectIDs.split(",");
		supplierService.notPassProjectSupplierApproval(supplierID,Arrays.asList(ids));
	}
}
