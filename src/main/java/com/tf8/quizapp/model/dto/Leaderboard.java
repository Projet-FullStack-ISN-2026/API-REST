package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;

import com.tf8.quizapp.model.dto.LeaderboardEntry;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Le classement Top 10 pour un quiz.
 */
@Schema(description = "Le classement Top 10 pour un quiz.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class Leaderboard   {
  @JsonProperty("quizId")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long quizId = null;

  @JsonProperty("entries")
  @Valid
  private List<LeaderboardEntry> entries = null;

  public Leaderboard quizId(Long quizId) { 

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

  public Leaderboard entries(List<LeaderboardEntry> entries) { 

    this.entries = entries;
    return this;
  }

  public Leaderboard addEntriesItem(LeaderboardEntry entriesItem) {
    if (this.entries == null) {
      this.entries = new ArrayList<LeaderboardEntry>();
    }
    this.entries.add(entriesItem);
    return this;
  }

  /**
   * Get entries
   * @return entries
   **/
  
  @Schema(description = "")
  @Valid
  public List<LeaderboardEntry> getEntries() {  
    return entries;
  }



  public void setEntries(List<LeaderboardEntry> entries) { 
    this.entries = entries;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Leaderboard leaderboard = (Leaderboard) o;
    return Objects.equals(this.quizId, leaderboard.quizId) &&
        Objects.equals(this.entries, leaderboard.entries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quizId, entries);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leaderboard {\n");
    
    sb.append("    quizId: ").append(toIndentedString(quizId)).append("\n");
    sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
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
