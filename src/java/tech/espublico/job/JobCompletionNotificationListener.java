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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log =
      LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Shows different fields counts at console.
   * 
   *  @param jobExecution Job executed
   */
  @Override
  public void afterJob(JobExecution jobExecution) {
    log.info("### afterJob");
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("===== ORDERS PROCESSED =====");
      System.out.println("===== ORDERS PROCESSED =====");
      
      String query1 = "SELECT count(distinct(region)) FROM order_processed";
      Integer count1 = (Integer) jdbcTemplate.queryForObject(query1, Integer.class);
      log.info("== TOTAL of regions: " + count1);
      System.out.println("== TOTAL of regions: " + count1);

      String query2 = "SELECT count(distinct(country)) FROM order_processed";
      Integer count2 = (Integer) jdbcTemplate.queryForObject(query2, Integer.class);
      log.info("== TOTAL of countries: " + count2);
      System.out.println("== TOTAL of countries: " + count2);

      String query3 = "SELECT count(distinct(item_type)) FROM order_processed";
      Integer count3 = (Integer) jdbcTemplate.queryForObject(query3, Integer.class);
      log.info("== TOTAL of item types: " + count3);
      System.out.println("== TOTAL of item types: " + count3);

      String query4 = "SELECT count(distinct(sales_channel)) FROM order_processed";
      Integer count4 = (Integer) jdbcTemplate.queryForObject(query4, Integer.class);
      log.info("== TOTAL of sales channels: " + count4);
      System.out.println("== TOTAL of sales channels: " + count4);

      String query5 = "SELECT count(distinct(order_priority)) FROM order_processed";
      Integer count5 = (Integer) jdbcTemplate.queryForObject(query5, Integer.class);
      log.info("== TOTAL of order priorities: " + count5);
      System.out.println("== TOTAL of order priorities: " + count5);
    }
  }
}
