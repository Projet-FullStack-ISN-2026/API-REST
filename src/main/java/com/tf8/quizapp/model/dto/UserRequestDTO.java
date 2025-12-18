package com.tf8.quizapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO utilisé pour recevoir les données de l'utilisateur lors de la création (POST) 
 * ou la mise à jour (PUT) d'un compte.
 */
public class UserRequestDTO {

    // L'ID est omis car il est généré par la BDD.

    @NotBlank(message = "L'email est requis.")
    @Email(message = "Format d'email invalide.")
    private String email;

    @NotBlank(message = "Le mot de passe est requis.")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères.")
    private String password; 

    @NotBlank(message = "Le nom est requis.")
    private String lastName;
    
    @NotBlank(message = "Le prénom est requis.")
    private String firstName;

    // Le 'role' n'est pas exposé ici car il est géré par la logique métier/sécurité.

    // --- Getters et Setters ---

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}