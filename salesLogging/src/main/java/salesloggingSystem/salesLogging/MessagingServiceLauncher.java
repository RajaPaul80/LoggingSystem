package salesloggingSystem.salesLogging;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import salesloggingSystem.salesLogging.bean.SalesData;
import salesloggingSystem.salesLogging.resource.ProducerResource;

@SpringBootApplication
public class MessagingServiceLauncher implements ApplicationRunner {
	private static Logger log = LoggerFactory.getLogger(MessagingServiceLauncher.class);
	@Autowired
	private ProducerResource producer;

	public static void main(String[] args) {
		SpringApplication.run(MessagingServiceLauncher.class, args);
	}

	public void run(ApplicationArguments applicationArguments) throws Exception {
		for (int i = 1; i <= 100; i++) {
			SalesData salesMsg = new SalesData(i, "Grocery", "Grocery", 0.0+i, new Date());
			producer.send(salesMsg);
		}

		log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
		TimeUnit.SECONDS.sleep(3);
		System.exit(-1);
	}
}
