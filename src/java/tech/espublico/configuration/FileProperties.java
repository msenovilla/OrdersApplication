package tech.espublico.configuration;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("inputfile")
public class FileProperties {
  private String name;
  private List<String> columns;

  public FileProperties() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getColumns() {
    return columns;
  }

  public void setColumns(List<String> columns) {
    this.columns = columns;
  }

  @Override
  public String toString() {
    return "FileProperties [name=" + name + ", columns=" + columns + "]";
  }


}
