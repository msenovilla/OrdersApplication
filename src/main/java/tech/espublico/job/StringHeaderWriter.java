package tech.espublico.job;
/**
 * Class for define FlatFileHeaderCallback
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.io.IOException;
import java.io.Writer;
import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class StringHeaderWriter implements FlatFileHeaderCallback {

  private final String header;

  StringHeaderWriter(String header) {
    this.header = header;
  }

  @Override
  public void writeHeader(Writer writer) throws IOException {
    writer.write(header);
  }
}
