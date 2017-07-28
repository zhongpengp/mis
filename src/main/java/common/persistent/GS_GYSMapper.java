package common.persistent;

import common.vo.GS_GYS;
import common.vo.GS_GYSExample;
import common.vo.GS_GYSKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GS_GYSMapper {
    int countByExample(GS_GYSExample example);

    int deleteByExample(GS_GYSExample example);

    int deleteByPrimaryKey(GS_GYSKey key);

    int insert(GS_GYS record);

    int insertSelective(GS_GYS record);

    List<GS_GYS> selectByExample(GS_GYSExample example);

    GS_GYS selectByPrimaryKey(GS_GYSKey key);

    int updateByExampleSelective(@Param("record") GS_GYS record, @Param("example") GS_GYSExample example);

    int updateByExample(@Param("record") GS_GYS record, @Param("example") GS_GYSExample example);

    int updateByPrimaryKeySelective(GS_GYS record);

    int updateByPrimaryKey(GS_GYS record);

	void reReplyCompanySuppliersByID(String companyID, String supplierID);

}