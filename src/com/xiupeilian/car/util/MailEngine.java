package com.xiupeilian.car.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sun.mail.util.MailSSLSocketFactory;

@Component
public class MailEngine {
	protected static final Log log = LogFactory.getLog(MailEngine.class);
	/*@Resource
	private MailSender mailSender;*/

	


	/**
	 * �����ʼ�
	 * 
	 * @param emailAddress
	 *            �ռ���Email��ַ������
	 * @param fromEmail
	 *            �ļ���Email��ַ
	 * @param bodyText
	 *            �ʼ�����
	 * @param subject
	 *            �ʼ�����
	 * @param attachmentName
	 *            ������
	 * @param resource
	 *            ����
	 * @throws MessagingException
	 */
	/*public void sendMessage(String[] emailAddresses, String fromEmail, String bodyText, String subject, String attachmentName, ClassPathResource resource) throws MessagingException {
		Session session = new Session() ;
		java.util.Properties p = new Properties() ;
		MimeMessage message = ((JavaMailSenderImpl) mailSender).createMimeMessage();
		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(emailAddresses);
		if (fromEmail != null) {
			helper.setFrom(fromEmail);
		}
		helper.setText(bodyText);
		helper.setSubject(subject);
		
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		if (attachmentName != null && resource != null)
			helper.addAttachment(attachmentName, resource);

		((JavaMailSenderImpl) mailSender).send(message);
	}*/

	/**
	 * ���ͼ��ʼ�
	 * 
	 * @param msg
	 * @throws GeneralSecurityException 
	 *//*
	public void send(SimpleMailMessage msg) {
		try {
			((JavaMailSenderImpl) mailSender).send(msg);
		} catch (MailException ex) {
			// log it and go on
			log.error(ex.getMessage());
		}
	}

*/
	public void sendMessage(String password,String address) throws MessagingException, GeneralSecurityException {

	 Properties props = new Properties();

     // 开启debug调试
     props.setProperty("mail.debug", "true");
     // 发送服务器需要身份验证
     props.setProperty("mail.smtp.auth", "true");
     // 设置邮件服务器主机名
     props.setProperty("mail.host", "smtp.qq.com");
     // 发送邮件协议名称
     props.setProperty("mail.transport.protocol", "smtp");

     MailSSLSocketFactory sf = new MailSSLSocketFactory();
     sf.setTrustAllHosts(true);
     props.put("mail.smtp.ssl.enable", "true");
     props.put("mail.smtp.ssl.socketFactory", sf);

     Session session = Session.getInstance(props);

     Message msg = new MimeMessage(session);
     msg.setSubject(password);
     msg.setText(password);
     msg.setFrom(new InternetAddress("1750417482@qq.com"));
     Transport transport = session.getTransport();
     transport.connect("smtp.qq.com", "1750417482@qq.com", "wmhtdilhoosnedie");

     transport.sendMessage(msg, new Address[] { new InternetAddress(address) });
     transport.close();
	}
}