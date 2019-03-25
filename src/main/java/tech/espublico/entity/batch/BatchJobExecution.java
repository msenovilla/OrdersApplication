package tech.espublico.entity.batch;
/**
 * Represents BATCH_JOB_EXECUTION table needed for Batch Boot
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "batch_job_execution")
public class BatchJobExecution {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "job_execution_id")
  private Long id;

  private Long version;

  @Column(name = "job_instance_id")
  @NonNull
  private Long jobInstanceId;

  @Column(name = "create_time", columnDefinition = "TIMESTAMP NOT NULL")
  private Date createTime;

  @Column(name = "start_time", columnDefinition = "TIMESTAMP DEFAULT NULL")
  private Date startTime;

  @Column(name = "end_time", columnDefinition = "TIMESTAMP DEFAULT NULL")
  private Date endTime;

  private String status;

  @Column(name = "exit_code")
  private String exitCode;

  @Column(name = "exit_message", length = 2500)
  private String exitMessage;

  @Column(name = "last_updated", columnDefinition = "TIMESTAMP")
  private Date lastUpdated;

  @Column(name = "job_configuration_location", length = 2500)
  @Nullable
  private String jobConfigurationLocation;

  public BatchJobExecution() {

  }

  /**
   * BatchJobExecution constructor with all fields.
   * 
   * @param id Id
   * @param version Version
   * @param jobInstanceId Job instance Id
   * @param createTime Create Time
   * @param startTime Start Time
   * @param endTime End Time
   * @param status Status
   * @param exitCode Exit Code
   * @param exitMessage Exit Message
   * @param lastUpdated Last Updated
   * @param jobConfigurationLocation Job Configuration Location
   */
  public BatchJobExecution(Long id, Long version, Long jobInstanceId, Date createTime,
      Date startTime, Date endTime, String status, String exitCode, String exitMessage,
      Date lastUpdated, String jobConfigurationLocation) {
    super();
    this.id = id;
    this.version = version;
    this.jobInstanceId = jobInstanceId;
    this.createTime = createTime;
    this.startTime = startTime;
    this.endTime = endTime;
    this.status = status;
    this.exitCode = exitCode;
    this.exitMessage = exitMessage;
    this.lastUpdated = lastUpdated;
    this.jobConfigurationLocation = jobConfigurationLocation;
  }



  public String getJobConfigurationLocation() {
    return jobConfigurationLocation;
  }

  public void setJobConfigurationLocation(String jobConfigurationLocation) {
    this.jobConfigurationLocation = jobConfigurationLocation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Long getJobInstanceId() {
    return jobInstanceId;
  }

  public void setJobInstanceId(Long jobInstanceId) {
    this.jobInstanceId = jobInstanceId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getExitCode() {
    return exitCode;
  }

  public void setExitCode(String exitCode) {
    this.exitCode = exitCode;
  }

  public String getExitMessage() {
    return exitMessage;
  }

  public void setExitMessage(String exitMessage) {
    this.exitMessage = exitMessage;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

}
