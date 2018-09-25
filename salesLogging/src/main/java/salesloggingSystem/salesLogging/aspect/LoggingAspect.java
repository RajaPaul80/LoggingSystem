package salesloggingSystem.salesLogging.aspect;

import java.util.HashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.stereotype.Component;

import salesloggingSystem.salesLogging.bean.SalesData;

@Aspect
@Component
public class LoggingAspect {
	private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	private int count = 10;
	private double totalSale = 0.0;

	@Autowired
	private JmsListenerEndpointRegistry registry;

	private final HashMap<Integer, SalesData> hmap = new HashMap<Integer, SalesData>();

	@Around(value = "execution(* salesloggingSystem.salesLogging.listener.*.*(..)) and args(salesdata)")
	public void afterAdvice(ProceedingJoinPoint joinPoint, SalesData salesdata) {
		hmap.put(salesdata.getSaleNumber(), salesdata);
		if (hmap.size() == count) {
			count += 10;
			hmap.forEach((k, v) -> {
				totalSale += v.getSaleAmount();
				log.info(v.toString());
			});
			log.info("---------------------------------------------------------------------------------------------");
			log.info("-----------------------------------------Total Sale------------------------------------------");
			log.info(
					"-----------------------------------------" + totalSale + "--------------------------------------");
		}

		if (hmap.size() == 50) {
			// Stop Accepting Messages
			registry.stop();
			log.info("-----------------The Application is Pausing and is stopped accepting new Messages------------");
			log.info("------------------------------------Total Sale So Far------------------------------------------");
			log.info("------------------------------------" + totalSale + "------------------------------------------");

		}

		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			log.error(e.getMessage());
		}
	}

}
