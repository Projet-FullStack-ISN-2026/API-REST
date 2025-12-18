package com.tf8.quizapp.model.dto;
/**
* DTO utilisé pour renvoyer les données utilisateur au client REST (GET, POST réussi).
* Il exclut les champs sensibles comme le mot de passe.
*/
public class UserResponseDTO {

 private Long id;
 private String email;
 private String lastName;
 private String firstName;
 private int role; // Le rôle est souvent inclus pour les besoins de l'interface utilisateur.

 // Note : Le champ 'password' est délibérément omis.

 // --- Getters et Setters ---

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getLastname() {
     return lastName;
 }

 public void setLastname(String lastname) {
     this.lastName = lastname;
 }

 public String getFirstname() {
     return firstName;
 }

 public void setFirstname(String firstname) {
     this.firstName = firstname;
 }

 public int getRole() {
     return role;
 }

 public void setRole(int role) {
     this.role = role;
 }
}