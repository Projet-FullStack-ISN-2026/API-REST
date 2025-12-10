package com.tf8.quizapp.service;
import com.tf8.quizapp.model.dto.AuthResponse;
import com.tf8.quizapp.model.dto.UserLogin;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;

/**
 * Interface définissant le contrat de la couche Service pour les utilisateurs.
 */
public interface UserService {
    /**
     * Recherche un utilisateur par son ID.
     * @param id L'ID de l'utilisateur.
     * @return Le DTO de réponse de l'utilisateur.
     * @throws java.util.NoSuchElementException si l'utilisateur n'est pas trouvé.
     */
	UserResponseDTO getUserById(Long id);
	
	/**
     * Crée un nouvel utilisateur.
     * @param UserDTO Le DTO contenant les données de création.
     * @return Le DTO de réponse de l'utilisateur créé.
     */
	UserResponseDTO createUser(UserRequestDTO userRequestDTO);
	
	AuthResponse loginUser(UserLogin userLogin);
}


