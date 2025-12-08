package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;

import com.tf8.quizapp.model.dto.User;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Entrée individuelle dans le classement.
 */
@Schema(description = "Entrée individuelle dans le classement.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class LeaderboardEntry   {
  @JsonProperty("rank")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer rank = null;

  @JsonProperty("user")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private User user = null;

  @JsonProperty("score")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer score = null;


  public LeaderboardEntry rank(Integer rank) { 

    this.rank = rank;
    return this;
  }

  /**
   * Get rank
   * @return rank
   **/
  
  @Schema(example = "1", description = "")
  
  public Integer getRank() {  
    return rank;
  }



  public void setRank(Integer rank) { 
    this.rank = rank;
  }

  public LeaderboardEntry user(User user) { 

    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  
  @Schema(description = "")
  
@Valid
  public User getUser() {  
    return user;
  }



  public void setUser(User user) { 
    this.user = user;
  }

  public LeaderboardEntry score(Integer score) { 

    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
   **/
  
  @Schema(example = "8", description = "")
  
  public Integer getScore() {  
    return score;
  }



  public void setScore(Integer score) { 
    this.score = score;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LeaderboardEntry leaderboardEntry = (LeaderboardEntry) o;
    return Objects.equals(this.rank, leaderboardEntry.rank) &&
        Objects.equals(this.user, leaderboardEntry.user) &&
        Objects.equals(this.score, leaderboardEntry.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, user, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LeaderboardEntry {\n");
    
    sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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
