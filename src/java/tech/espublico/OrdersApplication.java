package tech.espublico;
/**
 * Main class OrdersApplication
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class OrdersApplication {

  private static final Log LOG = LogFactory.getLog(OrdersApplication.class);

  /**
   * Main method of application.
   * 
   * @param args Arguments
   * @throws Exception Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      if (args.length == 0) {
        throw new Exception("Filename must be specified");
      }

      Properties properties = new Properties();
      properties.put("inputfile.name", args[0].replaceFirst("--", ""));

      SpringApplication application = new SpringApplication(OrdersApplication.class);
      application.setDefaultProperties(properties);
      application.run(args);
    } catch (Exception e) {
      LOG.error(e.getMessage());
      System.out.println("ERROR: " + e.getMessage());
    }

  }

}
