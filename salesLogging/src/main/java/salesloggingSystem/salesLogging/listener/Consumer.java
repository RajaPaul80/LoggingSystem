package salesloggingSystem.salesLogging.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import salesloggingSystem.salesLogging.bean.SalesData;

@Component
public class Consumer {
	private static Logger log = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = "sales.queue",containerFactory = "myFactory")
	public void listener( SalesData salesdata) {
		log.info("received <" + salesdata + ">");
		
	}
	
}
