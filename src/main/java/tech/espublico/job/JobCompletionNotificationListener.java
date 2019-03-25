package tech.espublico.job;
/**
 * Class where final tasks after jobs executions are defined.
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.espublico.service.OrdersService;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	@Autowired
	private OrdersService orderService;

	/**
	 * Shows different fields counts at console.
	 * 
	 * @param jobExecution Job executed
	 */
	@Override
	public void afterJob(JobExecution jobExecution) {
		log.debug("### afterJob");
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("===== ORDERS PROCESSED =====");
			System.out.println("===== ORDERS PROCESSED =====");

			int count1 = orderService.getTotalRegions();
			log.info("== TOTAL of regions: " + count1);
			System.out.println("== TOTAL of regions: " + count1);

			int count2 = orderService.getTotalContries();
			log.info("== TOTAL of countries: " + count2);
			System.out.println("== TOTAL of countries: " + count2);

			int count3 = orderService.getTotalItemTypes();
			log.info("== TOTAL of item types: " + count3);
			System.out.println("== TOTAL of item types: " + count3);

			int count4 = orderService.getTotalChannels();
			log.info("== TOTAL of sales channels: " + count4);
			System.out.println("== TOTAL of sales channels: " + count4);

			int count5 = orderService.getTotalOrdersprocessed();
			log.info("== TOTAL of order priorities: " + count5);
			System.out.println("== TOTAL of order priorities: " + count5);
		}
	}
}
