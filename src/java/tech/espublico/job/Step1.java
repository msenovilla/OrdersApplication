package tech.espublico.job;
/**
 * Class where step 1 of job is defined. In this step, it reads from original CSV at store the
 * information at BBDD.
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import tech.espublico.configuration.FileProperties;
import tech.espublico.entity.OrderEntity;

@Configuration
public class Step1 {

  private static final Log LOG = LogFactory.getLog(Step1.class);
  private static final String QUERY_INSERT_ORDERS = new StringBuffer("INSERT INTO order_processed")
      .append(
          "(country,item_type,order_date,order_id,order_priority,region,sales_channel,ship_date,")
      .append("total_cost,total_profit,total_revenue,unit_cost,unit_price,units_sold)")
      .append(" VALUES (:country,:itemType,:orderDate,:orderId,:orderPriority,:region,")
      .append(":salesChannel,:shipDate,:totalCost,:totalProfit,:totalRevenue,:unitCost,")
      .append(":unitPrice,:unitsSold)").toString();

  @Autowired
  private FileProperties fileProperties;

  /**
   * Bean for read original CSV.
   * 
   * @return Reader
   * @throws FileNotFoundException Exception
   **/
  @Bean
  public FlatFileItemReader<OrderEntity> fileReader() throws FileNotFoundException {
    LOG.debug("=== filename: " + fileProperties.getName());

    File fr = new File(fileProperties.getName());
    if (fr.isDirectory() || !fr.isFile()) {
      // The file doesn't exist or is a directory
      LOG.error("Fichero no existe");
      throw new FileNotFoundException(
          "File " + fileProperties.getName() + " doesn't exit or is a directory");
    }

    // Create resource
    Resource resource = new FileSystemResource(fileProperties.getName());

    // Read input file in FlatFileItemReaderBuilder class
    FlatFileItemReaderBuilder<OrderEntity> flatItemReader =
        new FlatFileItemReaderBuilder<OrderEntity>();
    flatItemReader.resource(resource);
    flatItemReader.name("orderItemReader");
    flatItemReader.linesToSkip(1); // Avoid first line
    flatItemReader.delimited().names(fileProperties.getColumns().toArray(new String[0]));

    flatItemReader.fieldSetMapper(new BeanWrapperFieldSetMapper<OrderEntity>() {
      {
        setTargetType(OrderEntity.class);
      }
    });
    return flatItemReader.build();
  }

  /**
   * Bean for write to BBDD.
   * 
   * @param dataSource Datasource
   * @return JdbcBatchItemWriter
   */
  @Bean
  public JdbcBatchItemWriter<OrderEntity> jdbcWriter(DataSource dataSource) {
    JdbcBatchItemWriterBuilder<OrderEntity> itemWriterBuilder =
        new JdbcBatchItemWriterBuilder<OrderEntity>();
    itemWriterBuilder
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
    itemWriterBuilder.dataSource(dataSource);
    itemWriterBuilder.sql(QUERY_INSERT_ORDERS);

    return itemWriterBuilder.build();

  }

}
