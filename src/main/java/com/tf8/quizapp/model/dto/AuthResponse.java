package com.tf8.quizapp.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;

import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.config.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Réponse d&#x27;authentification incluant le token JWT.
 */
@Schema(description = "Réponse d'authentification incluant le token JWT.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class AuthResponse   {
  @JsonProperty("token")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String token = null;

  @JsonProperty("user")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private UserResponseDTO user = null;


  public AuthResponse token(String token) { 

    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   **/
  
  @Schema(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIi...", description = "")
  
  public String getToken() {  
    return token;
  }



  public void setToken(String token) { 
    this.token = token;
  }

  public AuthResponse user(UserResponseDTO user) { 

    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  
  @Schema(description = "")
  
@Valid
  public UserResponseDTO getUser() {  
    return user;
  }



  public void setUser(UserResponseDTO user) { 
    this.user = user;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthResponse authResponse = (AuthResponse) o;
    return Objects.equals(this.token, authResponse.token) &&
        Objects.equals(this.user, authResponse.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthResponse {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
