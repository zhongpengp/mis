package baseMachineMng.persistent;

import baseMachineMng.vo.Project_Instrument_Info;
import baseMachineMng.vo.Project_Instrument_InfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Project_Instrument_InfoMapper {
    int countByExample(Project_Instrument_InfoExample example);

    int deleteByExample(Project_Instrument_InfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Project_Instrument_Info record);

    int insertSelective(Project_Instrument_Info record);

    List<Project_Instrument_Info> selectByExample(Project_Instrument_InfoExample example);

    Project_Instrument_Info selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Project_Instrument_Info record, @Param("example") Project_Instrument_InfoExample example);

    int updateByExample(@Param("record") Project_Instrument_Info record, @Param("example") Project_Instrument_InfoExample example);

    int updateByPrimaryKeySelective(Project_Instrument_Info record);

    int updateByPrimaryKey(Project_Instrument_Info record);

	void deleteErrorByIDs(List<String> list);
}