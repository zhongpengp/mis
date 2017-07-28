package common.persistent;

import common.vo.RegisterApplyXM;
import common.vo.RegisterApplyXMExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegisterApplyXMMapper {
    int countByExample(RegisterApplyXMExample example);

    int deleteByExample(RegisterApplyXMExample example);

    int deleteByPrimaryKey(String applyId);

    int insert(RegisterApplyXM record);

    int insertSelective(RegisterApplyXM record);

    List<RegisterApplyXM> selectByExample(RegisterApplyXMExample example);

    RegisterApplyXM selectByPrimaryKey(String applyId);

    int updateByExampleSelective(@Param("record") RegisterApplyXM record, @Param("example") RegisterApplyXMExample example);

    int updateByExample(@Param("record") RegisterApplyXM record, @Param("example") RegisterApplyXMExample example);

    int updateByPrimaryKeySelective(RegisterApplyXM record);

    int updateByPrimaryKey(RegisterApplyXM record);
}