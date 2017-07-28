package baseMachineMng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.fastjson.JSON;

import baseMachineMng.service.FileUploadService;
import baseMachineMng.service.ProjectMachineImportService;
import baseMachineMng.service.ReadExcelService;
import baseMachineMng.vo.ImportProjectMachineInfoReturnVO;
import baseMachineMng.vo.ImportProjectMachineInfo_gsReturnVO;
import baseMachineMng.vo.Project_Instrument_Info_Temp;

@Controller
@RequestMapping("/projectMachineImportController")
@EnableWebMvc
public class ProjectMachineController {
		
	@Autowired
	private ProjectMachineImportService projectMachineImportService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private ReadExcelService readExcelService;
	
	@ResponseBody
	@RequestMapping("getImportedProjectMachineInfo")
	public List<ImportProjectMachineInfoReturnVO> getImportedProjectMachineInfo(String supplierID){
		return projectMachineImportService.getImportedProjectMachineInfo(supplierID);
	}
	
	@ResponseBody
	@RequestMapping("getImportedProjectMachineInfo_gs")
	public List<ImportProjectMachineInfo_gsReturnVO> getImportedProjectMachineInfo_gs(String companyID){
		return projectMachineImportService.getImportedProjectMachineInfo_gs(companyID);
	}
	
	@ResponseBody
	@RequestMapping(value = "machineUpload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 得到上传的文件
		String filePath = fileUploadService.returnFilePath(multipartRequest.getFile("file"), request);
		ArrayList<String[]> data = readExcelService.readExcel(filePath, 3,19);
		String projectID = (String) request.getSession().getAttribute("userID");
		ArrayList<String[]> message = new ArrayList<String[]>();
//		message = projectMachineImportService.addInfo(data, projectID);
		// return message;
		response.getWriter().write(JSON.toJSONString(message));
	}
	
	@ResponseBody
	@RequestMapping(value = "machineUpload_baseMachineImport", method = RequestMethod.POST)
	public void machineUpload_baseMachineImport(HttpServletResponse response,HttpServletRequest request) throws IOException, FileUploadException {
		Map<String,String> map = fileUploadService.returnFilePath_baseMachineInfoImport(request);
		String filePath = map.get("filePath");
		String projectID = map.get("projectID");
		ArrayList<String[]> data = readExcelService.readExcel(filePath, 3,10);
		String supplierID = (String) request.getSession().getAttribute("userID");
		ArrayList<String[]> message = new ArrayList<String[]>();
		message = projectMachineImportService.insertMachine_temp(data, projectID,supplierID);
		// return message;
		response.getWriter().write(JSON.toJSONString(message));
	}
	
	@ResponseBody
	@RequestMapping("getImportedMachineDetail")
	public List<Project_Instrument_Info_Temp> getImportedMachineDetail(String supplierID,String projectID,String applyState) throws IOException, FileUploadException {
		List<Project_Instrument_Info_Temp> result = projectMachineImportService.getImportedMachineDetail(supplierID,projectID,applyState);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("getImportedMachineDetail_gs")
	public List<Project_Instrument_Info_Temp> getImportedMachineDetail_gs(String supplierID,String projectID,String applyState) throws IOException, FileUploadException {
		List<Project_Instrument_Info_Temp> result = projectMachineImportService.getImportedMachineDetail_gs(supplierID,projectID,applyState);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("addSingleMachine")
	public void addSingleMachine(Project_Instrument_Info_Temp vo){
		projectMachineImportService.addSingleMachine(vo);
	}
	
	@ResponseBody
	@RequestMapping("updateSingleMachine")
	public void updateSingleMachine(Project_Instrument_Info_Temp vo){
		projectMachineImportService.updateSingleMachine(vo);
	}
	
	@ResponseBody
	@RequestMapping("getSingleMachineInfoByID")
	public Project_Instrument_Info_Temp getSingleMachineInfoByID(String machineID){
		return projectMachineImportService.getSingleMachineInfoByID(machineID);
	}
	
	@ResponseBody
	@RequestMapping("removeMachineInfoByIDs")
	public void removeMachineInfoByIDs(String machineIDs){
		projectMachineImportService.removeMachineInfoByIDs(machineIDs);
	}
	
	@ResponseBody
	@RequestMapping("toSubmitMachineApprovalApply")
	public void toSubmitMachineApprovalApply(String projectIDs,String supplierID){
		projectMachineImportService.toSubmitMachineApprovalApply(projectIDs,supplierID);
	}
	
	@ResponseBody
	@RequestMapping("toPassApprovalApply")
	public void toPassApprovalApply(String machineIDs){
		projectMachineImportService.toPassApprovalApply(machineIDs);
	}
	
	@ResponseBody
	@RequestMapping("toNotPassApprovalApply")
	public void toNotPassApprovalApply(String machineIDs){
		projectMachineImportService.toNotPassApprovalApply(machineIDs);
	}
}
