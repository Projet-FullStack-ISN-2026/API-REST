package com.tf8.quizapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tf8.quizapp.model.dto.UserLogin;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.service.UserService;
import com.tf8.quizapp.exception.UserAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class AuthApiController implements AuthApi {

    private final UserService userService;

    public AuthApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<?> authLoginPost(@Valid @RequestBody UserLogin body) {
        try {
            UserResponseDTO response = userService.loginUser(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            // Retourne un simple message texte en cas d'erreur
            return new ResponseEntity<>("Email ou mot de passe incorrect", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> authRegisterPost(@Valid @RequestBody UserRequestDTO body) {
        try {
            UserResponseDTO response = userService.createUser(body);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>("Cet email est déjà pris", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}