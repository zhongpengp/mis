package mail.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import common.vo.MailVO;
import common.vo.registerUserVO;

public class MailUtil {
		
	  public static void sendMessage(MailVO vo,registerUserVO bo){ 
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String date = sdf.format(new Date());
		    Properties props = new Properties();
	        props.setProperty("mail.smtp.auth", "true");  
	        props.setProperty("mail.transport.protocol", "smtp");  
	        Session session = Session.getInstance(props);  
	        session.setDebug(true);  
	        Message msg = new MimeMessage(session);
			String user = bo.getApplyproject();
			String password = bo.getApplyuserID().substring(bo.getApplyuserID().length()-6);
	        try {
	        	msg.setSubject("申请结果信息");
	        	StringBuffer sb = new StringBuffer();
	        	sb.append("您所申请的项目：").append(bo.getApplyproject());
	        	if("1".equals(bo.getApplyStatus())){
	        		sb.append("申请成功!\n");
	        		sb.append("登录账号：").append(user).append(";  ").append("登录密码：").append(password).append("\n");
	        	}else{
	        		sb.append("申请未通过!\n");
	        	}
	        	sb.append("审批信息：").append(bo.getApproveBody()).append("\n");
	        	sb.append("审批日期：").append(date);
	        	msg.setText(sb.toString());
	        	msg.saveChanges();
		        msg.setFrom(new InternetAddress(vo.getAddress()));  
		        Transport transport = session.getTransport(); 
		        String station = "smtp."+ vo.getAddress().split("@")[1];
		        transport.connect(station, vo.getPort(), vo.getAddress(), vo.getCode());  
		        transport.sendMessage(msg,  
		                new Address[]{new InternetAddress(bo.getApplymail())});
		        transport.close();  
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	  }
	  
	
}
