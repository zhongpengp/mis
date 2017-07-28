package mail.service;

import java.security.Security;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil_simple {
	public static void sendMail(String fromMail, String user, String password, String toMail, String mailTitle,
			String mailContent) throws Exception {
		// Properties props = new Properties(); // 可以加载一个配置文件
		// // 使用smtp：简单邮件传输协议
		// props.put("mail.smtp.host", "smtp.exmail.qq.com");// 存储发送邮件服务器的信息
		// props.put("mail.smtp.port", "465");// 存储发送邮件服务器的信息
		// props.put("mail.smtp.auth", "true");// 同时通过验证

		// 设置SSL连接、邮件环境
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.qq.com");// 存储发送邮件服务器的信息
		props.put("mail.smtp.port", "465");// 存储发送邮件服务器的信息
		props.put("mail.smtp.auth", "true");// 同时通过验证
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		// 建立邮件会话
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			// 身份认证
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Session session = Session.getInstance(props);// 根据属性新建一个邮件会话
		session.setDebug(true); // 有他会打印一些调试信息。

		MimeMessage message = new MimeMessage(session);// 由邮件会话新建一个消息对象
		message.setFrom(new InternetAddress(fromMail));// 设置发件人的地址
		message.setRecipients(Message.RecipientType.TO, toMail);// 设置收件人,并设置其接收类型为TO
		message.setSubject(mailTitle);// 设置标题
		// 设置信件内容
		// message.setText(mailContent); //发送 纯文本 邮件 todo
		message.setContent(mailContent, "text/html;charset=gbk"); // 发送HTML邮件，内容样式比较丰富
		message.setSentDate(new Date());// 设置发信时间
		message.saveChanges();// 存储邮件信息

		// 发送邮件
		// Transport transport = session.getTransport("smtp");
		// Transport transport = session.getTransport();
		// transport.connect(user, password);
		Transport.send(message);
		// transport.close();
	}

	// public static void main(String[] args) {
	// try {
	// long s = System.currentTimeMillis();
	// sendMail("1205715205@qq.com","1205715205@qq.com","dztzxzijjinxhjjj",new
	// String[]{"1205715205@qq.com"},"LOL","OMG");
	// System.out.println(System.currentTimeMillis()-s);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				// task to run goes here
				try {
					sendMail("1205715205@qq.com", "1205715205@qq.com", "dztzxzijjinxhjjj",
							 "294578887@qq.com" , "定时邮件轰炸开始", "哈哈哈哈");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(runnable, 10, 5, TimeUnit.SECONDS);
	}
}
