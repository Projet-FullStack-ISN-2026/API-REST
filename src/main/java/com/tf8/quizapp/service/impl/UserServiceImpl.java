package com.tf8.quizapp.service.impl;

import com.tf8.quizapp.model.dto.UserLogin;
import com.tf8.quizapp.model.dto.UserRequestDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.repository.UserRepository;
import com.tf8.quizapp.service.UserService;
import com.tf8.quizapp.model.entity.UserEntity;
import com.tf8.quizapp.exception.UserAlreadyExistsException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    // ON A SUPPRIMÉ LA LIGNE "private final PasswordEncoder passwordEncoder;"

    // ON A RETIRÉ "PasswordEncoder" DU CONSTRUCTEUR
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO loginUser(UserLogin userLogin) {
        UserEntity user = userRepository.findByEmail(userLogin.getEmail())
                .orElseThrow(() -> new RuntimeException("Email ou mot de passe incorrect"));

        // COMPARAISON TEXTE BRUT (Car plus d'encodeur)
        if (!user.getPassword().equals(userLogin.getPassword())) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }
        return mapToResponseDTO(user);
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        if (userRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Cet email est déjà utilisé.");
        }

        UserEntity user = new UserEntity();
        user.setEmail(requestDTO.getEmail());
        user.setFirstname(requestDTO.getFirstname());
        user.setLastname(requestDTO.getLastname());
        
        // STOCKAGE TEXTE BRUT (à sécurisé)
        user.setPassword(requestDTO.getPassword());
        
        user.setRole(0);

        UserEntity savedUser = userRepository.save(user);
        return mapToResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("User introuvable"));
        return mapToResponseDTO(user);
    }

    private UserResponseDTO mapToResponseDTO(UserEntity user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setRole(user.getRole());
        return dto;
    }
}