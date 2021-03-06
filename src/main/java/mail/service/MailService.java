package mail.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import baseMachineMng.vo.Project_Instrument_Info;
import common.persistent.ProjectMapper;
import common.vo.Project;
import mail.persistent.MailToSendMapper;
import mail.persistent.UserMailMapper;
import mail.vo.MailToSend;
import mail.vo.MailToSendExample;
import mail.vo.UserMail;

@Service
public class MailService {

	@Autowired
	private MailToSendMapper mailToSendMapper;
	@Autowired
	private UserMailMapper userMailMapper;
	@Autowired
	private ProjectMapper projectMapper;

	@Scheduled(fixedRate = 90000) // 每90秒执行一下
	public void toSendMail() {
		List<MailToSend> mailToSendList = getToSendMail();
		for (MailToSend mailToSend : mailToSendList) {
			try {
				sendMail(mailToSend);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setMailSendedState_success(Integer mailToSendID) {
		MailToSend mail = mailToSendMapper.selectByPrimaryKey(mailToSendID);
		mail.setMailState(1);
		mail.setTimeSend(new Date());
		mailToSendMapper.updateByPrimaryKey(mail);
	}
	
	public void setMailSendedState_error(Integer mailToSendID) {
		MailToSend mail = mailToSendMapper.selectByPrimaryKey(mailToSendID);
		mail.setMailState(2);
		mail.setTimeSend(new Date());
		mailToSendMapper.updateByPrimaryKey(mail);
	}

	public void sendMail(MailToSend mailToSend) throws Exception {
		String sendUserID = mailToSend.getSendUserid();
		UserMail userMail = userMailMapper.selectByPrimaryKey(sendUserID);
		try {
			MailUtil_simple.sendMail(mailToSend.getSendUseraddress(),userMail.getMailAuthUser(),
					userMail.getMailAuthPassword(), mailToSend.getReceiveUseraddress(), mailToSend.getMailTitle(),
					mailToSend.getMailContext());
			setMailSendedState_success(mailToSend.getId());
		} catch (Exception e) {
			setMailSendedState_error(mailToSend.getId());
		}
	}

	public void addToSendMail(String sendUserID, String receiveUserID, String mailTitle, String mailContext)
			throws Exception {
		UserMail sendMail = userMailMapper.selectByPrimaryKey(sendUserID);
		UserMail receiveMail = userMailMapper.selectByPrimaryKey(receiveUserID);
		MailToSend mailToSend = new MailToSend();
		mailToSend.setMailContext(mailContext);
		mailToSend.setMailState(0);
		mailToSend.setMailTitle(mailTitle);
		mailToSend.setReceiveUseraddress(receiveMail.getMailAddress());
		mailToSend.setReceiveUserid(receiveUserID);
		mailToSend.setSendUseraddress(sendMail.getMailAddress());
		mailToSend.setSendUserid(sendUserID);
		mailToSend.setTimeAdd(new Date());
		mailToSendMapper.insert(mailToSend);
	}
	
	public void addToSendMail_register_failure(String sendUserID, String receiveAddress, String mailTitle, String mailContext)
			throws Exception {
		UserMail sendMail = userMailMapper.selectByPrimaryKey(sendUserID);
		MailToSend mailToSend = new MailToSend();
		mailToSend.setMailContext(mailContext);
		mailToSend.setMailState(0);
		mailToSend.setMailTitle(mailTitle);
		mailToSend.setReceiveUseraddress(receiveAddress);
		mailToSend.setSendUseraddress(sendMail.getMailAddress());
		mailToSend.setSendUserid(sendUserID);
		mailToSend.setTimeAdd(new Date());
		mailToSendMapper.insert(mailToSend);
	}

	public List<MailToSend> getToSendMail() {
		MailToSendExample example = new MailToSendExample();
		example.createCriteria().andMailStateNotEqualTo(1);
		List<MailToSend> mailToSendList = mailToSendMapper.selectByExample(example);
		return mailToSendList;
	}
	
	public void addMachineSengOutMail(String projectID,String supplierID,String context){
		Project project = projectMapper.selectByPrimaryKey(projectID);
		context = "你好，"+project.getProjectName()+"项目中的以下设备已发货，请注意查收！<br/>"+context;
		try{
			String companyID = project.getCompanyId();
			addToSendMail("1",companyID,"设备管理平台("+project.getProjectName()+"项目)设备发货通知",context);
		}catch (Exception e) {
			System.out.println(e);
		}
		try {
			addToSendMail("1",projectID,"设备管理平台("+project.getProjectName()+"项目)设备发货通知",context);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addMachineSengInMail(Project_Instrument_Info machine) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String context = "<table><tr><td>设备名称</td><td>设备规格</td><td>设备型号</td><td>数量</td><td>验收时间</td></tr>";
		context+="<tr><td>"+machine.getMachineName()+"</td>";
		context+="<td>"+machine.getMachineSize()+"</td>";
		context+="<td>"+machine.getMachineType()+"</td>";
		context+="<td>1</td>";
		context+="<td>"+format.format(new Date())+"</td></tr></table>";
		Project project = projectMapper.selectByPrimaryKey(machine.getProjectId());
		context = "你好，"+project.getProjectName()+"项目中的以下设备已验收完成！<br/>"+context;
		try{
			String companyID = project.getCompanyId();
			addToSendMail("1",companyID,"设备管理平台("+project.getProjectName()+"项目)设备设备进场验收通知",context);
		}catch (Exception e) {
			System.out.println(e);
		}
		try {
			addToSendMail("1",machine.getProjectId(),"设备管理平台("+project.getProjectName()+"项目)设备设备进场验收通知",context);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
