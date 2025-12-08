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
 * DTO pour un joueur soumettant une réponse.
 */
@Schema(description = "DTO pour un joueur soumettant une réponse.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class AnswerSubmit   {
  @JsonProperty("optionId")

  private Long optionId = null;


  public AnswerSubmit optionId(Long optionId) { 

    this.optionId = optionId;
    return this;
  }

  /**
   * Get optionId
   * @return optionId
   **/
  
  @Schema(example = "3", required = true, description = "")
  
  @NotNull
  public Long getOptionId() {  
    return optionId;
  }



  public void setOptionId(Long optionId) { 

    this.optionId = optionId;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnswerSubmit answerSubmit = (AnswerSubmit) o;
    return Objects.equals(this.optionId, answerSubmit.optionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(optionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnswerSubmit {\n");
    
    sb.append("    optionId: ").append(toIndentedString(optionId)).append("\n");
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
