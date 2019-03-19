package tech.espublico.entity.batch;
/**
 * Represents BATCH_JOB_INSTANCE table needed for Batch Boot
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "batch_job_instance")
public class BatchJobInstance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "job_instance_id")
  private Long id;

  private Long version;

  @Column(name = "job_name")
  @NonNull
  private String jobName;

  @Column(name = "job_key", length = 2500)
  private String jobKey;

  public BatchJobInstance() {

  }

  /**
   * BatchJobInstance constructor with all fields.
   * 
   * @param id Id
   * @param version Version
   * @param jobName Job name
   * @param jobKey Job key
   */
  public BatchJobInstance(Long id, Long version, String jobName, String jobKey) {
    super();
    this.id = id;
    this.version = version;
    this.jobName = jobName;
    this.jobKey = jobKey;
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

  public String getJobKey() {
    return jobKey;
  }

  public void setJobKey(String jobKey) {
    this.jobKey = jobKey;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

}
