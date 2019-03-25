package tech.espublico.entity.batch;
/**
 * Represents BATCH_STEP_EXECUTION table needed for Batch Boot
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

@Entity
@Table(name = "batch_step_execution")
public class BatchStepExecution {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "STEP_EXECUTION_ID")
  @NonNull
  private Long id;

  @NonNull
  private Long version;

  @Column(name = "STEP_NAME")
  @NonNull
  private String stepName;

  @Column(name = "JOB_EXECUTION_ID")
  @NonNull
  private Long jobExecutionId;

  @Column(name = "start_time", columnDefinition = "TIMESTAMP NOT NULL")
  private Date startTime;

  @Column(name = "end_time", columnDefinition = "TIMESTAMP DEFAULT NULL")
  private Date endTime;

  @Column(name = "COMMIT_COUNT")
  private Long commitCount;

  @Column(name = "READ_COUNT")
  private Long readCount;

  @Column(name = "FILTER_COUNT")
  private Long filterCount;

  @Column(name = "WRITE_COUNT")
  private Long writeCount;

  @Column(name = "READ_SKIP_COUNT")
  private Long readSkipCount;

  @Column(name = "WRITE_SKIP_COUNT")
  private Long writeSkipCount;

  @Column(name = "PROCESS_SKIP_COUNT")
  private Long processSkipCount;

  @Column(name = "ROLLBACK_COUNT")
  private Long rollbackCount;

  @Column(name = "exit_code")
  private String exitCode;

  private String status;

  @Column(name = "exit_message", length = 2500)
  private String exitMessage;

  @Column(name = "last_updated", columnDefinition = "TIMESTAMP")
  private Date lastUpdated;

  public BatchStepExecution() {

  }


  /**
   * BatchStepExecution constructor with all fields.
   * 
   * @param id Id
   * @param version Version
   * @param stepName Step Name
   * @param jobExecutionId Job execution id
   * @param startTime Start time
   * @param endTime End time
   * @param commitCount Commit count
   * @param readCount Read count
   * @param filterCount Filter count
   * @param writeCount Write count
   * @param readSkipCount Read skip count
   * @param writeSkipCount Write skip count
   * @param processSkipCount Process skip count
   * @param rollbackCount Rollback count
   * @param exitCode Exit code
   * @param exitMessage Exit message
   * @param lastUpdated Last updated
   */
  public BatchStepExecution(Long id, Long version, String stepName, Long jobExecutionId,
      Date startTime, Date endTime, Long commitCount, Long readCount, Long filterCount,
      Long writeCount, Long readSkipCount, Long writeSkipCount, Long processSkipCount,
      Long rollbackCount, String exitCode, String exitMessage, Date lastUpdated) {
    super();
    this.id = id;
    this.version = version;
    this.stepName = stepName;
    this.jobExecutionId = jobExecutionId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.commitCount = commitCount;
    this.readCount = readCount;
    this.filterCount = filterCount;
    this.writeCount = writeCount;
    this.readSkipCount = readSkipCount;
    this.writeSkipCount = writeSkipCount;
    this.processSkipCount = processSkipCount;
    this.rollbackCount = rollbackCount;
    this.exitCode = exitCode;
    this.exitMessage = exitMessage;
    this.lastUpdated = lastUpdated;
  }



  public String getStatus() {
    return status;
  }



  public void setStatus(String status) {
    this.status = status;
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

  public String getStepName() {
    return stepName;
  }

  public void setStepName(String stepName) {
    this.stepName = stepName;
  }

  public Long getJobExecutionId() {
    return jobExecutionId;
  }

  public void setJobExecutionId(Long jobExecutionId) {
    this.jobExecutionId = jobExecutionId;
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

  public Long getCommitCount() {
    return commitCount;
  }

  public void setCommitCount(Long commitCount) {
    this.commitCount = commitCount;
  }

  public Long getReadCount() {
    return readCount;
  }

  public void setReadCount(Long readCount) {
    this.readCount = readCount;
  }

  public Long getFilterCount() {
    return filterCount;
  }

  public void setFilterCount(Long filterCount) {
    this.filterCount = filterCount;
  }

  public Long getWriteCount() {
    return writeCount;
  }

  public void setWriteCount(Long writeCount) {
    this.writeCount = writeCount;
  }

  public Long getReadSkipCount() {
    return readSkipCount;
  }

  public void setReadSkipCount(Long readSkipCount) {
    this.readSkipCount = readSkipCount;
  }

  public Long getWriteSkipCount() {
    return writeSkipCount;
  }

  public void setWriteSkipCount(Long writeSkipCount) {
    this.writeSkipCount = writeSkipCount;
  }

  public Long getProcessSkipCount() {
    return processSkipCount;
  }

  public void setProcessSkipCount(Long processSkipCount) {
    this.processSkipCount = processSkipCount;
  }

  public Long getRollbackCount() {
    return rollbackCount;
  }

  public void setRollbackCount(Long rollbackCount) {
    this.rollbackCount = rollbackCount;
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
