package common.persistent;

import common.vo.RegisterApplyGS;
import common.vo.RegisterApplyGSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegisterApplyGSMapper {
    int countByExample(RegisterApplyGSExample example);

    int deleteByExample(RegisterApplyGSExample example);

    int deleteByPrimaryKey(String applyId);

    int insert(RegisterApplyGS record);

    int insertSelective(RegisterApplyGS record);

    List<RegisterApplyGS> selectByExample(RegisterApplyGSExample example);

    RegisterApplyGS selectByPrimaryKey(String applyId);

    int updateByExampleSelective(@Param("record") RegisterApplyGS record, @Param("example") RegisterApplyGSExample example);

    int updateByExample(@Param("record") RegisterApplyGS record, @Param("example") RegisterApplyGSExample example);

    int updateByPrimaryKeySelective(RegisterApplyGS record);

    int updateByPrimaryKey(RegisterApplyGS record);
}