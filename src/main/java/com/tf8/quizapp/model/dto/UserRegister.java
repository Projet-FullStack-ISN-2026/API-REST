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
 * Données requises pour l&#x27;inscription d&#x27;un nouvel utilisateur.
 */
@Schema(description = "Données requises pour l'inscription d'un nouvel utilisateur.")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")


public class UserRegister   {
  @JsonProperty("firstName")

  private String firstName = null;

  @JsonProperty("lastName")

  private String lastName = null;

  @JsonProperty("email")

  private String email = null;

  @JsonProperty("password")

  private String password = null;


  public UserRegister firstName(String firstName) { 

    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  
  @Schema(example = "Guillaume", required = true, description = "")
  
  @NotNull
  public String getFirstName() {  
    return firstName;
  }



  public void setFirstName(String firstName) { 

    this.firstName = firstName;
  }

  public UserRegister lastName(String lastName) { 

    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  
  @Schema(example = "RENOUARD", required = true, description = "")
  
  @NotNull
  public String getLastName() {  
    return lastName;
  }



  public void setLastName(String lastName) { 

    this.lastName = lastName;
  }

  public UserRegister email(String email) { 

    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  
  @Schema(example = "Guillaume.renouard@groupe-esigelec.org", required = true, description = "")
  
  @NotNull
  public String getEmail() {  
    return email;
  }



  public void setEmail(String email) { 

    this.email = email;
  }

  public UserRegister password(String password) { 

    this.password = password;
    return this;
  }

  /**
   * Le mot de passe doit être haché en SHA-256 par le client avant d'être envoyé.
   * @return password
   **/
  
  @Schema(example = "5a84b2325c345ab46b04a984c3c328957a056581335a4b5f8846141445167667", required = true, description = "Le mot de passe doit être haché en SHA-256 par le client avant d'être envoyé.")
  
  @NotNull
  public String getPassword() {  
    return password;
  }



  public void setPassword(String password) { 

    this.password = password;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRegister userRegister = (UserRegister) o;
    return Objects.equals(this.firstName, userRegister.firstName) &&
        Objects.equals(this.lastName, userRegister.lastName) &&
        Objects.equals(this.email, userRegister.email) &&
        Objects.equals(this.password, userRegister.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRegister {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
