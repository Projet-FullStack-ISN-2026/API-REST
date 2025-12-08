package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;

import com.tf8.quizapp.model.dto.QuizStatusEnum;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * L&#x27;état en direct d&#x27;un quiz en cours, piloté par l&#x27;animateur.
 */
@Schema(description = "L'état en direct d'un quiz en cours, piloté par l'animateur.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class QuizState   {
  @JsonProperty("quizId")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long quizId = null;

  @JsonProperty("status")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private QuizStatusEnum status = null;

  @JsonProperty("currentQuestionNumber")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer currentQuestionNumber = null;

  /**
   * 10: display question, 20: pourcentage, 30: answer, 40: classement
   */
  public enum StepEnum {
    NUMBER_10(10),
    
    NUMBER_20(20),
    
    NUMBER_30(30),
    
    NUMBER_40(40);

    private Integer value;

    StepEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StepEnum fromValue(String text) {
      for (StepEnum b : StepEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("step")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private StepEnum step = null;

  @JsonProperty("startQuestionTime")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime startQuestionTime = null;


  public QuizState quizId(Long quizId) { 

    this.quizId = quizId;
    return this;
  }

  /**
   * Get quizId
   * @return quizId
   **/
  
  @Schema(description = "")
  
  public Long getQuizId() {  
    return quizId;
  }



  public void setQuizId(Long quizId) { 
    this.quizId = quizId;
  }

  public QuizState status(QuizStatusEnum status) { 

    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  
  @Schema(description = "")
  
@Valid
  public QuizStatusEnum getStatus() {  
    return status;
  }



  public void setStatus(QuizStatusEnum status) { 
    this.status = status;
  }

  public QuizState currentQuestionNumber(Integer currentQuestionNumber) { 

    this.currentQuestionNumber = currentQuestionNumber;
    return this;
  }

  /**
   * Numéro de la question active (base 1).
   * @return currentQuestionNumber
   **/
  
  @Schema(example = "3", description = "Numéro de la question active (base 1).")
  
  public Integer getCurrentQuestionNumber() {  
    return currentQuestionNumber;
  }



  public void setCurrentQuestionNumber(Integer currentQuestionNumber) { 
    this.currentQuestionNumber = currentQuestionNumber;
  }

  public QuizState step(StepEnum step) { 

    this.step = step;
    return this;
  }

  /**
   * 10: display question, 20: pourcentage, 30: answer, 40: classement
   * @return step
   **/
  
  @Schema(description = "10: display question, 20: pourcentage, 30: answer, 40: classement")
  
  public StepEnum getStep() {  
    return step;
  }



  public void setStep(StepEnum step) { 
    this.step = step;
  }

  public QuizState startQuestionTime(OffsetDateTime startQuestionTime) { 

    this.startQuestionTime = startQuestionTime;
    return this;
  }

  /**
   * Timestamp du début de l'affichage de la question actuelle.
   * @return startQuestionTime
   **/
  
  @Schema(description = "Timestamp du début de l'affichage de la question actuelle.")
  
@Valid
  public OffsetDateTime getStartQuestionTime() {  
    return startQuestionTime;
  }



  public void setStartQuestionTime(OffsetDateTime startQuestionTime) { 
    this.startQuestionTime = startQuestionTime;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuizState quizState = (QuizState) o;
    return Objects.equals(this.quizId, quizState.quizId) &&
        Objects.equals(this.status, quizState.status) &&
        Objects.equals(this.currentQuestionNumber, quizState.currentQuestionNumber) &&
        Objects.equals(this.step, quizState.step) &&
        Objects.equals(this.startQuestionTime, quizState.startQuestionTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quizId, status, currentQuestionNumber, step, startQuestionTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuizState {\n");
    
    sb.append("    quizId: ").append(toIndentedString(quizId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    currentQuestionNumber: ").append(toIndentedString(currentQuestionNumber)).append("\n");
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
    sb.append("    startQuestionTime: ").append(toIndentedString(startQuestionTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
