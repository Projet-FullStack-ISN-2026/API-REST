package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;

import com.tf8.quizapp.model.dto.QuestionDetailed;
import com.tf8.quizapp.model.dto.Quiz;
import com.tf8.quizapp.model.dto.QuizStatusEnum;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Vue administrative complète d&#x27;un quiz avec toutes ses questions et réponses.
 */
@Schema(description = "Vue administrative complète d'un quiz avec toutes ses questions et réponses.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class QuizDetailed extends Quiz  {
  @JsonProperty("questions")
  @Valid
  private List<QuestionDetailed> questions = null;

  public QuizDetailed questions(List<QuestionDetailed> questions) { 

    this.questions = questions;
    return this;
  }

  public QuizDetailed addQuestionsItem(QuestionDetailed questionsItem) {
    if (this.questions == null) {
      this.questions = new ArrayList<QuestionDetailed>();
    }
    this.questions.add(questionsItem);
    return this;
  }

  /**
   * Get questions
   * @return questions
   **/
  
  @Schema(description = "")
  @Valid
  public List<QuestionDetailed> getQuestions() {  
    return questions;
  }



  public void setQuestions(List<QuestionDetailed> questions) { 
    this.questions = questions;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuizDetailed quizDetailed = (QuizDetailed) o;
    return Objects.equals(this.questions, quizDetailed.questions) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questions, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuizDetailed {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
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
