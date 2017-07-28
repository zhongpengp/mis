package log.controller;

import common.vo.LoginLog;
import log.service.LogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping({"/logController"})
public class LogController
{
  @Autowired
  private LogService logService;
  
  @ResponseBody
  @RequestMapping({"getAllLoginLog"})
  public List<LoginLog> getAllLoginLog()
  {
    return this.logService.getAllLoginLog();
  }
}
