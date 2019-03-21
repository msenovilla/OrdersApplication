package tech.espublico.job;
/**
 * Class where all the jobs needed for the application are included.
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.espublico.entity.OrderEntity;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  private static final Log LOG = LogFactory.getLog(BatchConfiguration.class);

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  Job job(JobCompletionNotificationListener listener, StepBuilderFactory sbf, Step1 step1,
      Step2 step2) {
    LOG.debug("=== job ===");

    try {
      //Step for read from CSV and store on BBDD
      Step s1 = sbf.get("step1").<OrderEntity, OrderEntity>chunk(10).reader(step1.fileReader())
          .writer(step1.jdbcWriter(null)).build();

      //Step for read from BBDD and write to processed CSV
      Step s2 = sbf.get("step2").<OrderEntity, OrderEntity>chunk(10).reader(step2.reader(null))
          .writer(step2.databaseCsvItemWriter()).build();

      return jobBuilderFactory.get("importOrderJob").incrementer(new RunIdIncrementer()).start(s1)
          .next(s2).listener(listener).build();
    } catch (Exception e) {
      LOG.error(e.getMessage());
      return null;
    }

  }

}
