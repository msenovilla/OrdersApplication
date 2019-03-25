package tech.espublico.job;
/**
 * Class where step 2 of job is defined. In this step, it reads from DB at store the information
 * at a CSV processing the information.
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.ArrayList;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import tech.espublico.configuration.FileProperties;
import tech.espublico.entity.OrderEntity;

@Configuration
public class Step2 {

  private static final Log LOG = LogFactory.getLog(Step2.class);
  private static final String QUERY_FIND_ORDERS = new StringBuffer()
      .append("SELECT country,region,item_type,sales_channel,order_priority,order_date,")
      .append("order_id,ship_date,units_sold,")
      .append("unit_price,unit_cost,total_revenue,total_cost,total_profit")
      .append(" FROM order_processed").append(" ORDER BY order_id").toString();

  @Autowired
  private FileProperties fileProperties;

  /**
   * Reader of DB to extract all the orders.
   * 
   * @param dataSource Datasource
   * @return OrderEntity with the order
   */
  @Bean
  public ItemReader<OrderEntity> reader(DataSource dataSource) {
    LOG.debug("=== reader");
    JdbcCursorItemReader<OrderEntity> databaseReader = new JdbcCursorItemReader<>();

    databaseReader.setDataSource(dataSource);
    databaseReader.setSql(QUERY_FIND_ORDERS);
    databaseReader.setRowMapper(new BeanPropertyRowMapper<>(OrderEntity.class));

    return databaseReader;
  }


  /**
   * Writer to CSV file.
   * 
   * @return Write to OrderEntity
   */
  @Bean
  public ItemWriter<OrderEntity> databaseCsvItemWriter() {
    LOG.debug("=== databaseCsvItemWriter");
    FlatFileItemWriter<OrderEntity> csvFileWriter = new FlatFileItemWriter<>();

    // Extracting column names from properties file
    ArrayList<String> columns = (ArrayList<String>) fileProperties.getColumns();
    String columnsHeaders = "";
    for (int i = 0; i < columns.size(); i++) {
      columnsHeaders += columns.get(i);
      if (i < (columns.size() - 1)) {
        columnsHeaders += ",";
      }
    }
    LOG.debug("=== columnsHeaders=>" + columnsHeaders);

    StringHeaderWriter headerWriter = new StringHeaderWriter(columnsHeaders);
    csvFileWriter.setHeaderCallback(headerWriter);

    // Extracting destination file from properties file, adding de suffix Processed
    String exportFilePath =
        fileProperties.getName().substring(0, fileProperties.getName().lastIndexOf('.'))
            + "Processed.csv";
    LOG.debug("=== exportFilePath=>" + exportFilePath);
    csvFileWriter.setResource(new FileSystemResource(exportFilePath));

    LineAggregator<OrderEntity> lineAggregator = createOrderLineAggregator();
    csvFileWriter.setLineAggregator(lineAggregator);

    return csvFileWriter;
  }

  /**
   * Defines the line aggregator for a CVS file.
   * 
   * @return LineAggregator for OrderEntity
   */
  private LineAggregator<OrderEntity> createOrderLineAggregator() {
    DelimitedLineAggregator<OrderEntity> lineAggregator = new DelimitedLineAggregator<>();
    lineAggregator.setDelimiter(",");

    FieldExtractor<OrderEntity> fieldExtractor = createOrderFieldExtractor();
    lineAggregator.setFieldExtractor(fieldExtractor);

    return lineAggregator;
  }

  /**
   * Defines the field extractor for OrderEntity.
   * 
   * @return FieldExtractor for OrderEntity
   */
  private FieldExtractor<OrderEntity> createOrderFieldExtractor() {
    BeanWrapperFieldExtractor<OrderEntity> extractor = new BeanWrapperFieldExtractor<>();
    extractor.setNames(new String[] {"region", "country", "itemType", "salesChannel",
        "orderPriority", "orderDate", "orderId", "shipDate", "unitsSold", "unitPrice", "unitCost",
        "totalCost", "totalRevenue", "totalProfit"});
    return extractor;
  }

}
