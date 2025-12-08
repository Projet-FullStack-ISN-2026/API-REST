package com.tf8.quizapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.tf8.quizapp.model.dto.ApiError;
import com.tf8.quizapp.model.dto.AuthResponse;
import com.tf8.quizapp.model.dto.User;
import com.tf8.quizapp.model.dto.UserLogin;
import com.tf8.quizapp.model.dto.UserRegister;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")
@RestController
public class AuthApiController implements AuthApi {

    private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private final UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public AuthApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userService = userService;
    }

public ResponseEntity<AuthResponse> authLoginPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UserLogin body) {
        
        // Nous retirons la vérification 'Accept' et la logique de mock data.
        
        try {
            // 1. Appeler votre Service d'Authentification.
            // NOTE: Dans un vrai projet, ceci irait dans un AuthService dédié.
            // On suppose que cette méthode gère la vérification du mot de passe et génère le jeton JWT.
            
            // Ici, nous supposons que UserLogin est suffisamment simple pour être passé directement.
            // Vous devriez ajouter une méthode mapSwaggerLoginToRequestDTO(body) si nécessaire.
            
            AuthResponse authResponse = userService.loginUser(body); 
            
            // 2. Si la connexion réussit, le service retourne l'objet AuthResponse.
            return new ResponseEntity<>(authResponse, HttpStatus.OK);

        } catch (BadCredentialsException e) {
            // Cette exception doit être levée par le Service si l'email/mot de passe est incorrect.
            log.warn("Tentative de connexion échouée pour l'utilisateur : {}", body.getEmail());
            // Retourne 401 Unauthorized, comme spécifié dans votre schéma Swagger.
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            
        } catch (Exception e) {
            // Gestion des erreurs internes (ex: problème de BDD, erreur de génération de jeton).
            log.error("Erreur interne lors de la connexion.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<User> authRegisterPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UserRegister body
) {
    	try {
            // 1. Convertir le modèle Swagger d'entrée (UserRegister) en votre DTO interne (UserRequestDTO)
            UserRequestDTO requestDTO = mapSwaggerRegisterToRequestDTO(body);
            
            // 2. Appeler votre logique métier (qui gère l'enregistrement, hachage, etc.)
            UserResponseDTO createdUserDTO = userService.createUser(requestDTO);
            
            // 3. Convertir votre DTO de réponse interne (UserResponseDTO) en modèle Swagger de sortie (User)
            User responseBody = mapResponseDTOToSwaggerUser(createdUserDTO);

            // 4. Retourner le statut 201 CREATED (tel que défini dans Swagger)
            return new ResponseEntity<>(responseBody, HttpStatus.CREATED);

        } catch (Exception e) {
            // Gérez les erreurs spécifiques ici (ex: email déjà existant -> 400 Bad Request)
            log.error("Erreur lors de l'inscription de l'utilisateur", e);
            // Retourne une erreur 400 pour les données invalides
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
    }
    
    /**
     * Convertit le modèle d'inscription Swagger en DTO de requête interne.
     */
    private UserRequestDTO mapSwaggerRegisterToRequestDTO(UserRegister swagger) {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setEmail(swagger.getEmail());
        dto.setPassword(swagger.getPassword()); // Assurez-vous que UserRegister a un getPassword()
        dto.setFirstname(swagger.getFirstName());
        dto.setLastname(swagger.getLastName());
        return dto;
    }

    /**
     * Convertit le DTO de réponse interne en modèle utilisateur Swagger.
     */
    private User mapResponseDTOToSwaggerUser(UserResponseDTO custom) {
        User user = new User();
        user.setId(custom.getId());
        user.setEmail(custom.getEmail());
        user.setFirstName(custom.getFirstname());
        user.setLastName(custom.getLastname());
        user.setRole(custom.getRole()); // Assurez-vous que User a un setRole(int)
        return user;
    }

}
