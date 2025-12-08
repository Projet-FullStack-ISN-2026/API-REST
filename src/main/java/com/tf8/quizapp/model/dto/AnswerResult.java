package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Résultat renvoyé au joueur après que l&#x27;animateur ait révélé la réponse.
 */
@Schema(description = "Résultat renvoyé au joueur après que l'animateur ait révélé la réponse.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class AnswerResult   {
  @JsonProperty("isCorrect")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean isCorrect = null;

  @JsonProperty("correctOptionId")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long correctOptionId = null;

  @JsonProperty("scoreGained")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer scoreGained = null;


  public AnswerResult isCorrect(Boolean isCorrect) { 

    this.isCorrect = isCorrect;
    return this;
  }

  /**
   * Get isCorrect
   * @return isCorrect
   **/
  
  @Schema(example = "true", description = "")
  
  public Boolean isIsCorrect() {  
    return isCorrect;
  }



  public void setIsCorrect(Boolean isCorrect) { 
    this.isCorrect = isCorrect;
  }

  public AnswerResult correctOptionId(Long correctOptionId) { 

    this.correctOptionId = correctOptionId;
    return this;
  }

  /**
   * Get correctOptionId
   * @return correctOptionId
   **/
  
  @Schema(example = "3", description = "")
  
  public Long getCorrectOptionId() {  
    return correctOptionId;
  }



  public void setCorrectOptionId(Long correctOptionId) { 
    this.correctOptionId = correctOptionId;
  }

  public AnswerResult scoreGained(Integer scoreGained) { 

    this.scoreGained = scoreGained;
    return this;
  }

  /**
   * Get scoreGained
   * @return scoreGained
   **/
  
  @Schema(example = "1", description = "")
  
  public Integer getScoreGained() {  
    return scoreGained;
  }



  public void setScoreGained(Integer scoreGained) { 
    this.scoreGained = scoreGained;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnswerResult answerResult = (AnswerResult) o;
    return Objects.equals(this.isCorrect, answerResult.isCorrect) &&
        Objects.equals(this.correctOptionId, answerResult.correctOptionId) &&
        Objects.equals(this.scoreGained, answerResult.scoreGained);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isCorrect, correctOptionId, scoreGained);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnswerResult {\n");
    
    sb.append("    isCorrect: ").append(toIndentedString(isCorrect)).append("\n");
    sb.append("    correctOptionId: ").append(toIndentedString(correctOptionId)).append("\n");
    sb.append("    scoreGained: ").append(toIndentedString(scoreGained)).append("\n");
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
