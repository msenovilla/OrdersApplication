package tech.espublico.entity.batch;
/**
 * Represents BATCH_STEP_EXECUTION_CONTEXT table needed for Batch Boot
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
@Table(name = "BATCH_STEP_EXECUTION_CONTEXT")
public class BatchStepExecutionContext {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "step_execution_id")
  private Long id;

  @Column(name = "SHORT_CONTEXT", length = 2500)
  @NonNull
  private String shortContext;

  @Column(name = "SERIALIZED_CONTEXT", columnDefinition = "BLOB")
  private byte[] serializedContext;

  public BatchStepExecutionContext() {

  }

  /**
   * BatchStepExecutionContext constructor with all fields.
   * 
   * @param id Id
   * @param shortContext Short context
   * @param serializedContext Serialized context
   */
  public BatchStepExecutionContext(Long id, String shortContext, byte[] serializedContext) {
    super();
    this.id = id;
    this.shortContext = shortContext;
    this.serializedContext = serializedContext;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getShortContext() {
    return shortContext;
  }

  public void setShortContext(String shortContext) {
    this.shortContext = shortContext;
  }

  public byte[] getSerializedContext() {
    return serializedContext;
  }

  public void setSerializedContext(byte[] serializedContext) {
    this.serializedContext = serializedContext;
  }


}
