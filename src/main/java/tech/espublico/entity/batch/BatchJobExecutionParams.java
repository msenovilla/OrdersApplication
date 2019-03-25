package tech.espublico.entity.batch;
/**
 * Represents BATCH_JOB_EXECUTION_PARAMS table needed for Batch Boot
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "BATCH_JOB_EXECUTION_PARAMS")
public class BatchJobExecutionParams {
  @Id
  @Column(name = "job_execution_id")
  @NonNull
  private Long id;

  @Column(name = "TYPE_CD")
  @NonNull
  private String typeCd;

  @Column(name = "KEY_NAME")
  @NonNull
  private String keyName;

  @Column(name = "STRING_VAL")
  private String stringVal;

  @Column(name = "DATE_VAL", columnDefinition = "DATETIME DEFAULT NULL")
  private Date dateVal;

  @Column(name = "LONG_VAL")
  private int longVal;

  @Column(name = "DOUBLE_VAL")
  private double doubleVal;

  @Column(name = "IDENTIFYING")
  @NonNull
  private String identifyng;

  public BatchJobExecutionParams() {
    dateVal = null;
  }

  /**
   * BatchJobExecutionParams constructor with all fields.
   * 
   * @param id Id
   * @param typeCd Type Cd
   * @param keyName Key Name
   * @param stringVal String Value
   * @param dateVal Date Value
   * @param longVal Long Value
   * @param doubleVal Double Value
   * @param identifyng Identifyng
   */
  public BatchJobExecutionParams(Long id, String typeCd, String keyName, String stringVal,
      Date dateVal, int longVal, double doubleVal, String identifyng) {
    super();
    this.id = id;
    this.typeCd = typeCd;
    this.keyName = keyName;
    this.stringVal = stringVal;
    this.dateVal = dateVal;
    this.longVal = longVal;
    this.doubleVal = doubleVal;
    this.identifyng = identifyng;
  }



  public double getDoubleVal() {
    return doubleVal;
  }

  public void setDoubleVal(double doubleVal) {
    this.doubleVal = doubleVal;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTypeCd() {
    return typeCd;
  }

  public void setTypeCd(String typeCd) {
    this.typeCd = typeCd;
  }

  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public String getStringVal() {
    return stringVal;
  }

  public void setStringVal(String stringVal) {
    this.stringVal = stringVal;
  }

  public Date getDateVal() {
    return dateVal;
  }

  public void setDateVal(Date dateVal) {
    this.dateVal = dateVal;
  }

  public int getLongVal() {
    return longVal;
  }

  public void setLongVal(int longVal) {
    this.longVal = longVal;
  }

  public String getIdentifyng() {
    return identifyng;
  }

  public void setIdentifyng(String identifyng) {
    this.identifyng = identifyng;
  }


}
