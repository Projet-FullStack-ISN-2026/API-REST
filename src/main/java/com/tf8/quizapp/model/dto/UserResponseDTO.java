package com.tf8.quizapp.model.dto;
/**
* DTO utilisé pour renvoyer les données utilisateur au client REST (GET, POST réussi).
* Il exclut les champs sensibles comme le mot de passe.
*/
public class UserResponseDTO {

 private Long id;
 private String email;
 private String lastname;
 private String firstname;
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
     return lastname;
 }

 public void setLastname(String lastname) {
     this.lastname = lastname;
 }

 public String getFirstname() {
     return firstname;
 }

 public void setFirstname(String firstname) {
     this.firstname = firstname;
 }

 public int getRole() {
     return role;
 }

 public void setRole(int role) {
     this.role = role;
 }
}