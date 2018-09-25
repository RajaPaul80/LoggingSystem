package salesloggingSystem.salesLogging.resource;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import salesloggingSystem.salesLogging.bean.SalesData;

@Component
public class ProducerResource {
	private static Logger log = LoggerFactory.getLogger(ProducerResource.class);
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;

	public void send(SalesData salesdata) {
		log.info("sending with convertAndSend() to queue <" + salesdata + ">");
		jmsTemplate.convertAndSend(queue, salesdata);
	}
}
