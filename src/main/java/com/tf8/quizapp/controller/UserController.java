package com.tf8.quizapp.controller;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.service.UserService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException; 

/**
 * Contrôleur REST pour la gestion des utilisateurs.
 * C'est le point d'entrée de l'API.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService; // Injection de l'interface Service

    /**
     * Injection de dépendance du Service par constructeur.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * Endpoint: POST /api/v1/users
     * Crée un nouvel utilisateur.
     */
    @PostMapping 
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        
        // La validation @Valid vérifie les contraintes définies dans UserRequestDTO.
        
        UserResponseDTO createdUserDTO = userService.createUser(userRequestDTO);
        
        // Retourne le statut 201 Created
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    /**
     * Endpoint pour récupérer un utilisateur par ID.
     * URI: GET /api/v1/users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        try {
            // 1. Appel du service (la logique métier est cachée ici)
        	UserResponseDTO userDTO = userService.getUserById(id);
            
            // 2. Retourne le DTO dans une réponse 200 OK
            return ResponseEntity.ok(userDTO);
            
        } catch (NoSuchElementException e) {
            // Dans un cas réel, utilisez un GlobalExceptionHandler ou une ResourceNotFoundException
            // pour retourner un statut 404 NOT FOUND.
            return ResponseEntity.notFound().build(); 
        }
    }
}
