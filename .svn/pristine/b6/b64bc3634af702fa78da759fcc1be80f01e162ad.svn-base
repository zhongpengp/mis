package common.persistent;

import common.vo.RegisterApplyGYS;
import common.vo.RegisterApplyGYSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegisterApplyGYSMapper {
    int countByExample(RegisterApplyGYSExample example);

    int deleteByExample(RegisterApplyGYSExample example);

    int deleteByPrimaryKey(String applyId);

    int insert(RegisterApplyGYS record);

    int insertSelective(RegisterApplyGYS record);

    List<RegisterApplyGYS> selectByExample(RegisterApplyGYSExample example);

    RegisterApplyGYS selectByPrimaryKey(String applyId);

    int updateByExampleSelective(@Param("record") RegisterApplyGYS record, @Param("example") RegisterApplyGYSExample example);

    int updateByExample(@Param("record") RegisterApplyGYS record, @Param("example") RegisterApplyGYSExample example);

    int updateByPrimaryKeySelective(RegisterApplyGYS record);

    int updateByPrimaryKey(RegisterApplyGYS record);
}