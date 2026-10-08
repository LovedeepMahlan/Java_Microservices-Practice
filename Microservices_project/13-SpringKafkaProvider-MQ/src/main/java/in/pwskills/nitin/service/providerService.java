package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class providerService {

	@Autowired
	KafkaTemplate<String, String> kft;
	
	@Value("${my.topic.name}")
	String topicName;
	
	public void sendMessage(String message) {
		kft.send(topicName, message);
	}	
}
