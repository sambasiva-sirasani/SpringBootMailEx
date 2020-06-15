package com.siva;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	
	@Autowired
	private JavaMailSender mail;
	
	public boolean mail(String to,
						String cc[],
						String bcc[],
						String subject,
						String text,
						FileSystemResource file) {
		boolean flag=false;
		
		try {
			//1.Create Mime Message
			MimeMessage msg=mail.createMimeMessage();
			//2. Create Mime Message Helper class object
			MimeMessageHelper helper=new MimeMessageHelper(msg,file!=null?true:false);
			
			//3. provide message details
			helper.setTo(to);
			if(cc!=null) {
				helper.setCc(cc);
			}
			if(bcc!=null) {
				helper.setBcc(bcc);
			}
			helper.setSubject(subject);
			helper.setText(text);
			if(file!=null) {
				helper.addAttachment(file.getFilename(), file);
			}
			mail.send(msg);
			flag=true;
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
		
	}

}
