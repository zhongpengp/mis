package mail.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
}
