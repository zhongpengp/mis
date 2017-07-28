package common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import common.service.ApprovalRegisterService;
import common.vo.RegisterApplyGS;
import common.vo.RegisterApplyGYS;
import common.vo.RegisterApplyQueryVO_gs;
import common.vo.RegisterApplyQueryVO_gys;
import common.vo.RegisterApplyQueryVO_xm;
import common.vo.RegisterApplyXM;

@Controller
@RequestMapping("/approvalRegisterController")
@EnableWebMvc
public class ApprovalRegisterController {
	
	@Autowired
	private ApprovalRegisterService approvalRegisterService;

	@ResponseBody
	@RequestMapping("getRegisterApplyList_gs")
	public List<RegisterApplyGS> getRegisterApplyList_gs(RegisterApplyQueryVO_gs vo) {
		return approvalRegisterService.getRegisterApplyList_gs(vo);
	}
	@ResponseBody
	@RequestMapping("getRegisterApplyList_gys")
	public List<RegisterApplyGYS> getRegisterApplyList_gys(RegisterApplyQueryVO_gys vo) {
		return approvalRegisterService.getRegisterApplyList_gys(vo);
	}
	@ResponseBody
	@RequestMapping("getRegisterApplyList_xm")
	public List<RegisterApplyXM> getRegisterApplyList_xm(RegisterApplyQueryVO_xm vo) {
		return approvalRegisterService.getRegisterApplyList_xm(vo);
	}
	
	@ResponseBody
	@RequestMapping("getApplyByID")
	public RegisterApplyGS getApplyByID(String applyID) {
		return approvalRegisterService.getApplyByID(applyID);
	}
	@ResponseBody
	@RequestMapping("getGYSApplyByID")
	public RegisterApplyGYS getGYSApplyByID(String applyID) {
		return approvalRegisterService.getGYSApplyByID(applyID);
	}
	@ResponseBody
	@RequestMapping("getXMApplyByID")
	public RegisterApplyXM getXMApplyByID(String applyID) {
		return approvalRegisterService.getXMApplyByID(applyID);
	}
	
	@ResponseBody
	@RequestMapping("approvalApply_gs")
	public void approvalApply_gs(String applyID,String applyState,String replyDetail) {
		approvalRegisterService.approvalApply_gs(applyID,applyState,replyDetail);
	}
	@ResponseBody
	@RequestMapping("approvalApply_gys")
	public void approvalApply_gys(String applyID,String applyState,String replyDetail) {
		approvalRegisterService.approvalApply_gys(applyID,applyState,replyDetail);
	}
	@ResponseBody
	@RequestMapping("approvalApply_xm")
	public void approvalApply_xm(String applyID,String applyState,String replyDetail) {
		approvalRegisterService.approvalApply_xm(applyID,applyState,replyDetail);
	}
	
	
}
