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
 * DTO pour lier une question existante à un quiz.
 */
@Schema(description = "DTO pour lier une question existante à un quiz.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class QuestionLink   {
  @JsonProperty("questionId")

  private Long questionId = null;


  public QuestionLink questionId(Long questionId) { 

    this.questionId = questionId;
    return this;
  }

  /**
   * Get questionId
   * @return questionId
   **/
  
  @Schema(example = "1024", required = true, description = "")
  
  @NotNull
  public Long getQuestionId() {  
    return questionId;
  }



  public void setQuestionId(Long questionId) { 

    this.questionId = questionId;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuestionLink questionLink = (QuestionLink) o;
    return Objects.equals(this.questionId, questionLink.questionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionLink {\n");
    
    sb.append("    questionId: ").append(toIndentedString(questionId)).append("\n");
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
