package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;

import com.tf8.quizapp.model.dto.OptionDetailed;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Une question d&#x27;un quiz (vue Admin), avec les bonnes réponses.
 */
@Schema(description = "Une question d'un quiz (vue Admin), avec les bonnes réponses.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class QuestionDetailed   {
  @JsonProperty("id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long id = null;

  @JsonProperty("question")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String question = null;

  @JsonProperty("options")
  @Valid
  private List<OptionDetailed> options = null;

  public QuestionDetailed id(Long id) { 

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  @Schema(description = "")
  
  public Long getId() {  
    return id;
  }



  public void setId(Long id) { 
    this.id = id;
  }

  public QuestionDetailed question(String question) { 

    this.question = question;
    return this;
  }

  /**
   * Get question
   * @return question
   **/
  
  @Schema(example = "Quelle est la capitale de la France ?", description = "")
  
  public String getQuestion() {  
    return question;
  }



  public void setQuestion(String question) { 
    this.question = question;
  }

  public QuestionDetailed options(List<OptionDetailed> options) { 

    this.options = options;
    return this;
  }

  public QuestionDetailed addOptionsItem(OptionDetailed optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<OptionDetailed>();
    }
    this.options.add(optionsItem);
    return this;
  }

  /**
   * Get options
   * @return options
   **/
  
  @Schema(description = "")
  @Valid
  public List<OptionDetailed> getOptions() {  
    return options;
  }



  public void setOptions(List<OptionDetailed> options) { 
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
    QuestionDetailed questionDetailed = (QuestionDetailed) o;
    return Objects.equals(this.id, questionDetailed.id) &&
        Objects.equals(this.question, questionDetailed.question) &&
        Objects.equals(this.options, questionDetailed.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, question, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionDetailed {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
