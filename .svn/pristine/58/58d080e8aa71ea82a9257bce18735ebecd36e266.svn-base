package projectMng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.persistent.ProjectMapper;
import common.vo.Project;
import common.vo.ProjectExample;
import common.vo.ProjectExample.Criteria;
import projectMng.vo.ProjectListQueryVO;

@Service
public class ProjectMngService {
	
	@Autowired
	private ProjectMapper projectMapper;

	public List<Project> getProjectListByGS(ProjectListQueryVO vo) {
		ProjectExample example = new ProjectExample();
		Criteria criteria = example.createCriteria().andCompanyIdEqualTo(vo.getCompanyID()).andProjectStatueLike(vo.getProjectState()).andProjectTypeLike(vo.getProjectType());
		if("1".equals(vo.getProjectName_jingque())){
			criteria.andProjectNameEqualTo(vo.getProjectName());
		}else{
			criteria.andProjectNameLike(vo.getProjectName());
		}
		List<Project> result = projectMapper.selectByExample(example);
		return result;
	}

}
