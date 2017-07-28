package projectMng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import common.vo.Project;
import projectMng.service.ProjectMngService;
import projectMng.vo.ProjectListQueryVO;

@Controller
@EnableWebMvc
@RequestMapping("/ProjectMngController")
public class ProjectMngController {
	
	@Autowired
	private ProjectMngService projectMngService;
	
	@ResponseBody
	@RequestMapping("getProjectList_gs")
	public List<Project> getProjectListByGS(ProjectListQueryVO vo) {
		return projectMngService.getProjectListByGS(vo);
	}
}
