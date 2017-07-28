package uploadFile.persistent;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import common.vo.Project;
import uploadFile.vo.FILEUPLOAD;
import uploadFile.vo.FILEUPLOADExample;

public interface FILEUPLOADMapper {
    int countByExample(FILEUPLOADExample example);

    int deleteByExample(FILEUPLOADExample example);

    int deleteByPrimaryKey(String fileId);

    int insert(FILEUPLOAD record);

    int insertSelective(FILEUPLOAD record);

    List<FILEUPLOAD> selectByExample(FILEUPLOADExample example);

    FILEUPLOAD selectByPrimaryKey(String fileId);

    int updateByExampleSelective(@Param("record") FILEUPLOAD record, @Param("example") FILEUPLOADExample example);

    int updateByExample(@Param("record") FILEUPLOAD record, @Param("example") FILEUPLOADExample example);

    int updateByPrimaryKeySelective(FILEUPLOAD record);

    int updateByPrimaryKey(FILEUPLOAD record);

	List<Project> getProjectByGS(String userID);

	List<Project> getProjectByXM(String userID);

	List<Project> getProjectByGYS(String userID);

	List<Project> getProjectAll();
}