package log.service;

import common.vo.LoginLog;
import java.util.List;

public abstract interface LogService
{
  public abstract List<LoginLog> getAllLoginLog();
}
