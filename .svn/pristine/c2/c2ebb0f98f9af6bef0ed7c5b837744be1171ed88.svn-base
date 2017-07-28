package log.service;

import common.vo.LoginLog;
import log.persistent.LogMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl
  implements LogService
{
  @Autowired
  private LogMapper logMapper;
  
  public List<LoginLog> getAllLoginLog()
  {
    return this.logMapper.getAllLoginLog();
  }
}
