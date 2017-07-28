package mail.persistent;

import java.util.List;
import mail.vo.UserMail;
import mail.vo.UserMailExample;
import org.apache.ibatis.annotations.Param;

public interface UserMailMapper {
    int countByExample(UserMailExample example);

    int deleteByExample(UserMailExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserMail record);

    int insertSelective(UserMail record);

    List<UserMail> selectByExample(UserMailExample example);

    UserMail selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserMail record, @Param("example") UserMailExample example);

    int updateByExample(@Param("record") UserMail record, @Param("example") UserMailExample example);

    int updateByPrimaryKeySelective(UserMail record);

    int updateByPrimaryKey(UserMail record);
}