package common.persistent;

import common.vo.Project;
import common.vo.ProjectExample;
import common.vo.RepairMachineVO;
import common.vo.UnCheckMachineVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(String projectId);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

	List<UnCheckMachineVO> getUncheckList(Map<String, String> map);

	List<UnCheckMachineVO> getCheckedList(Map<String, String> map);

	void inserCheckMachine(UnCheckMachineVO vo);

	void updateMachine(UnCheckMachineVO vo);

	List<RepairMachineVO> getUnRepairList(Map<String, String> map);

	List<RepairMachineVO> getRepairedList(Map<String, String> map);

	void inserRepairMachine(RepairMachineVO vo);

	void updateMachineState(String id);

	void machineDestroy(@Param("ids")String ids);

	Map<String, String> machineAlarmInfo(@Param("id")String id);

	void updateMachineApproval(Map<String, String> map);
}