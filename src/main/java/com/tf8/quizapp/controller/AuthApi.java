package com.tf8.quizapp.controller;

import com.tf8.quizapp.model.dto.UserLogin;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.validation.Valid;

@Validated
public interface AuthApi {

    @Operation(summary = "Login")
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    ResponseEntity<?> authLoginPost(@Valid @RequestBody UserLogin body);

    @Operation(summary = "Register")
    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    ResponseEntity<?> authRegisterPost(@Valid @RequestBody UserRequestDTO body);
}