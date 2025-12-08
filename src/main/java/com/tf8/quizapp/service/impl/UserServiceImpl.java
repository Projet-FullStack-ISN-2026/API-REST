package com.tf8.quizapp.service.impl;
import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import com.tf8.quizapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tf8.quizapp.service.UserService;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.tf8.quizapp.model.entity.UserEntity;
import com.tf8.quizapp.exception.UserAlreadyExistsException;
import com.tf8.quizapp.model.dto.UserLogin;     
import com.tf8.quizapp.model.dto.AuthResponse;
/**
 * Implémentation concrète de l'interface UserService.
 * Contient la logique métier et utilise le Repository.
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder; // Décommenter dans un vrai projet

    /**
     * Injection de dépendance.
     */
    public UserServiceImpl(UserRepository userRepository /*, PasswordEncoder passwordEncoder */) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder; 
    }

    // --- Méthode existante (GET) ---
    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(Long id) {
    	UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User non trouvé avec l'ID: " + id));

        return mapToDTO(user);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AuthResponse loginUser(UserLogin userLogin) {
        
        // 1. Chercher l'utilisateur par email.
        // NOTE: Vous devez ajouter la méthode findByEmail au UserRepository.
    	UserEntity user = userRepository.findByEmail(userLogin.getEmail())
                // Si l'utilisateur n'est pas trouvé, lancez une exception de mauvaises informations
                // Dans Spring Security, c'est BadCredentialsException. Ici, nous la simulons.
                .orElseThrow(() -> new RuntimeException("Email ou mot de passe incorrect.")); 
                // .orElseThrow(() -> new BadCredentialsException("Email ou mot de passe incorrect."));
        
        // 2. Vérification du mot de passe.
        // **LOGIQUE DE SÉCURITÉ : Comparaison du mot de passe clair avec le hachage stocké**
        
        // Simulation de la vérification du mot de passe haché
        String expectedHashedPassword = "HASHED_" + userLogin.getPassword();
        
        if (!user.getPassword().equals(expectedHashedPassword)) {
            // Le mot de passe ne correspond pas au hachage stocké.
            throw new RuntimeException("Email ou mot de passe incorrect.");
            // throw new BadCredentialsException("Email ou mot de passe incorrect.");
        }
        
        // 3. Si la vérification réussit : Générer le Jeton JWT (simulé)
        String jwtToken = "simulated_jwt_token_for_" + user.getId();
        
        // 4. Mapper l'Entity en DTO de réponse utilisateur
        UserResponseDTO userDTO = mapToDTO(user);
        
        // 5. Construire l'objet de Réponse d'Authentification
        AuthResponse response = new AuthResponse();
        response.setUser(userDTO);
        response.setToken(jwtToken);
        
        return response;
    }
    
    // --- Nouvelle méthode (POST) ---
    @Override
    @Transactional // Opération d'écriture
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
    	
    	// 1. **LOGIQUE DE VÉRIFICATION :** Vérifier si l'e-mail est déjà utilisé.
        Optional<UserEntity> existingUser = userRepository.findByEmail(userRequestDTO.getEmail());
        
        if (existingUser.isPresent()) {
            // Le compte existe déjà. Lancez une exception pour indiquer une erreur 400 dans le Controller.
            throw new UserAlreadyExistsException("Un utilisateur avec cet email existe déjà.");
            // NOTE: Vous devez créer cette classe UserAlreadyExistsException.
        }
        
        // 1. Transformation du DTO d'entrée en Entité.
    	UserEntity newUser = mapToEntity(userRequestDTO);
        
        // **Ici, vous pouvez ajouter d'autres validations, ex: vérifier si l'email existe déjà.**
        
        // 2. Appel du Repository pour sauvegarder l'Entity.
    	UserEntity savedUser = userRepository.save(newUser);
        
        // 3. Transformation de l'Entity sauvegardée en DTO de réponse.
        return mapToDTO(savedUser);
    }
    
    // --- Méthodes Utilitaire de Mapping ---
    
    /**
     * Méthode utilitaire pour mapper l'Entity vers le DTO de Réponse.
     */
    private UserResponseDTO mapToDTO(UserEntity user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setRole(user.getRole());
        // Pas de mot de passe!
        return dto;
    }
    
    /**
     * Méthode utilitaire pour mapper le DTO de Requête vers l'Entity.
     */
    private UserEntity mapToEntity(UserRequestDTO dto) {
    	UserEntity user = new UserEntity();
        // L'ID est null (la BDD va le générer)
        user.setEmail(dto.getEmail());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        
        // **IMPORTANT : HACHAGE du mot de passe avant de le mettre dans l'Entité**
        // user.setPassword(passwordEncoder.encode(dto.getPassword()));
        
        // Pour l'instant, sans PasswordEncoder, on simule :
        user.setPassword("HASHED_" + dto.getPassword()); 
        
        // **LOGIQUE MÉTIER : Attribution du rôle par défaut**
        user.setRole(1); // Ex: 1 = Rôle "USER" par défaut.
        
        return user;
    }
}
