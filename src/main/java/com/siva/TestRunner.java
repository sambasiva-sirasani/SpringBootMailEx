package com.siva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner{
	
	@Autowired
	private MailService mailService;
	@Override
	public void run(String... args) throws Exception {
		FileSystemResource file=new FileSystemResource("F:\\Saved Pictures\\pk.jpg");
		boolean sent=mailService.mail("sirasanisivapadmarao@gmail.com", 
		    new String[] {
		    		"paleti.venkatasiva@gmail.com"
		    }, 
		    new String[] {
		    		"paleti.venkatasiva@gmail.com"
		    }, "Welcome To SB_Mail", "Hello H r uuu!!", file);
		if(sent) {
			System.out.println("Email sent");
		}else {
			System.out.println("Errors!!!!");
		}
		
	}

}
