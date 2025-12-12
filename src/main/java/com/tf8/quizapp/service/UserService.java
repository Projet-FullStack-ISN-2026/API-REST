package com.tf8.quizapp.service;

import com.tf8.quizapp.model.dto.UserLogin;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;

/**
 * Interface définissant le contrat de la couche Service pour les utilisateurs.
 */
public interface UserService {

    /**
     * Tente de connecter un utilisateur.
     * @param userLogin Les identifiants (email, password).
     * @return Les informations de l'utilisateur connecté (sans mot de passe).
     */
    UserResponseDTO loginUser(UserLogin userLogin);

    /**
     * Crée un nouveau compte utilisateur.
     * @param userRequestDTO Les données d'inscription (email, pass, nom, prénom).
     * @return Les informations de l'utilisateur créé.
     */
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    /**
     * Récupère un utilisateur par son ID.
     * @param id L'identifiant unique.
     * @return Les informations de l'utilisateur.
     */
    UserResponseDTO getUserById(Long id);
}