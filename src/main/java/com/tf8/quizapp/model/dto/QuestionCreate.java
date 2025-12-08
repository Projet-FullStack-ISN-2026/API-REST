package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;

import com.tf8.quizapp.model.dto.OptionCreate;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * DTO pour la création d&#x27;une question avec ses options.
 */
@Schema(description = "DTO pour la création d'une question avec ses options.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class QuestionCreate   {
  @JsonProperty("question")

  private String question = null;

  @JsonProperty("options")
  @Valid
  private List<OptionCreate> options = new ArrayList<OptionCreate>();

  public QuestionCreate question(String question) { 

    this.question = question;
    return this;
  }

  /**
   * Get question
   * @return question
   **/
  
  @Schema(example = "Combien font 2+2 ?", required = true, description = "")
  
  @NotNull
  public String getQuestion() {  
    return question;
  }



  public void setQuestion(String question) { 

    this.question = question;
  }

  public QuestionCreate options(List<OptionCreate> options) { 

    this.options = options;
    return this;
  }

  public QuestionCreate addOptionsItem(OptionCreate optionsItem) {
    this.options.add(optionsItem);
    return this;
  }

  /**
   * Get options
   * @return options
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
@Size(min=2,max=4)   public List<OptionCreate> getOptions() {  
    return options;
  }



  public void setOptions(List<OptionCreate> options) { 

    this.options = options;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuestionCreate questionCreate = (QuestionCreate) o;
    return Objects.equals(this.question, questionCreate.question) &&
        Objects.equals(this.options, questionCreate.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(question, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionCreate {\n");
    
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
