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
 * DTO pour créer une nouvelle option.
 */
@Schema(description = "DTO pour créer une nouvelle option.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class OptionCreate   {
  @JsonProperty("text")

  private String text = null;

  @JsonProperty("isCorrect")

  private Boolean isCorrect = null;


  public OptionCreate text(String text) { 

    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
   **/
  
  @Schema(example = "Berlin", required = true, description = "")
  
  @NotNull
  public String getText() {  
    return text;
  }



  public void setText(String text) { 

    this.text = text;
  }

  public OptionCreate isCorrect(Boolean isCorrect) { 

    this.isCorrect = isCorrect;
    return this;
  }

  /**
   * Get isCorrect
   * @return isCorrect
   **/
  
  @Schema(example = "false", required = true, description = "")
  
  @NotNull
  public Boolean isIsCorrect() {  
    return isCorrect;
  }



  public void setIsCorrect(Boolean isCorrect) { 

    this.isCorrect = isCorrect;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OptionCreate optionCreate = (OptionCreate) o;
    return Objects.equals(this.text, optionCreate.text) &&
        Objects.equals(this.isCorrect, optionCreate.isCorrect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, isCorrect);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OptionCreate {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    isCorrect: ").append(toIndentedString(isCorrect)).append("\n");
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
