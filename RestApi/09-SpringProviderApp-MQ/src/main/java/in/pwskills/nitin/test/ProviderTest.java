package in.pwskills.nitin.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.service.ProviderService;

@Component
public class ProviderTest {

	@Autowired
	ProviderService service;
	
	@Scheduled(cron="*/10 * * * * *")
	public void sedMessage() {
		String data="HELLO :: "+new Date() ;
		service.sendData(data);
		System.out.println("Provider send data");
	}
	
}
