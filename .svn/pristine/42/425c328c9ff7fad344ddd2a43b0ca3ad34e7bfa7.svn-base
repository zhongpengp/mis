package mail.persistent;

import java.util.List;
import mail.vo.MailToSend;
import mail.vo.MailToSendExample;
import org.apache.ibatis.annotations.Param;

public interface MailToSendMapper {
    int countByExample(MailToSendExample example);

    int deleteByExample(MailToSendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailToSend record);

    int insertSelective(MailToSend record);

    List<MailToSend> selectByExample(MailToSendExample example);

    MailToSend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailToSend record, @Param("example") MailToSendExample example);

    int updateByExample(@Param("record") MailToSend record, @Param("example") MailToSendExample example);

    int updateByPrimaryKeySelective(MailToSend record);

    int updateByPrimaryKey(MailToSend record);
}