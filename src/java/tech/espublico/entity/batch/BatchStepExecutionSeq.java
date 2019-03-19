package tech.espublico.entity.batch;
/**
 * Represents BATCH_STEP_EXECUTION_SEQ table needed for Batch Boot
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "BATCH_STEP_EXECUTION_SEQ")
public class BatchStepExecutionSeq {
  @NonNull
  @Id
  private Long id;

  public BatchStepExecutionSeq() {

  }

  public BatchStepExecutionSeq(Long id) {
    super();
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
