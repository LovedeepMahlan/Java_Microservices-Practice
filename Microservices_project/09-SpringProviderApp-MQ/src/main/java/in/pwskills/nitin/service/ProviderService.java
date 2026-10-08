package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Component
public class ProviderService {

	@Autowired
	JmsTemplate template;
	
	@Value("${my.app.desti-name}")
	private String destination;
	
	public void sendData(String message) {
		
		template.send(destination,session->session.createTextMessage(message));
	
	/*	template.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage=session.createTextMessage(message);
				System.out.println("Message class name :: "+message.getClass().getName());
				System.out.println("Session class name :: "+session.getClass().getName());
				return textMessage;
			}
		});*/
	}
}
