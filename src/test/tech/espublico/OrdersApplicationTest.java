package tech.espublico;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;


class OrdersApplicationTest {

  private static final String FILENAME = "D:\\\\RegistroVentas1.csv";
  private static final Log LOG = LogFactory.getLog(OrdersApplicationTest.class);

  @Test
  public void fileGenerationTest() throws Exception {
    String[] args = new String[1];
    args[0] = FILENAME;
    OrdersApplication.main(args);
    String fileOutput = new StringBuffer().append(FILENAME.substring(0, FILENAME.lastIndexOf(".")))
        .append("Processed.csv").toString();

    File resultFile = new File(fileOutput);
    LOG.debug("file=>" + fileOutput + " exists=)>" + resultFile.exists());
    assertTrue(resultFile.exists());
  }

  @Test
  public void wrongFileTest() throws Exception {
    String[] args = new String[1];
    args[0] = "wrongFile.cvs";
    OrdersApplication.main(args);

    String fileOutput = new StringBuffer().append("./")
        .append(args[0].substring(0, args[0].lastIndexOf("."))).append("Processed.cvs").toString();
    File resultFile = new File(fileOutput);
    assertTrue(!resultFile.exists());
  }

  @Test
  public void checkArgsTest() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
    String[] args = new String[0];

    OrdersApplication.main(args);
    assertTrue(outContent.toString().contains("Filename must be specified"));

    System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));
  }

}
