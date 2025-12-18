package com.tf8.quizapp.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.entity.OptionsEntity;
import com.tf8.quizapp.model.entity.QuestionEntity;
import com.tf8.quizapp.repository.QuestionRepository;
import com.tf8.quizapp.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    
    @Override
    @Transactional
    public QuestionDTO getQuestion (Long id) {
    	Optional<QuestionEntity> questionEntity = questionRepository.findById(id);

        // 2. Vérifier si l'entité existe
    	if (questionEntity.isPresent()) {
            // 3. Mapper l'entité trouvée en DTO et la retourner
    		return mapToDTO(questionEntity.get());
    	} else {
            // 4. Si la question n'est pas trouvée, retourner null ou, 
            //    mieux, lancer une exception personnalisée (non implémentée ici)
    		return null; 
    	}
    }
    

    @Override
    @Transactional
    public QuestionDTO createQuestion(QuestionDTO dto) {
        // 1. Créer l'entité Question
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestion(dto.getQuestion());

        // 2. Transformer les options DTO en Entités et les lier
        if (dto.getOptions() != null) {
            Set<OptionsEntity> optionsEntities = new HashSet<>();
            
            for (OptionsDTO optDto : dto.getOptions()) {
                OptionsEntity optEntity = new OptionsEntity();
                optEntity.setText(optDto.getText());
                optEntity.setIsCorrect(optDto.isCorrect());
                
                // IMPORTANT : On dit à l'option "Voici ta question parente"
                optEntity.setQuestion(questionEntity);
                
                optionsEntities.add(optEntity);
            }
            questionEntity.setOptions(optionsEntities);
        }

        // 3. Sauvegarder (Tout se fait en une fois grâce au Cascade)
        QuestionEntity savedEntity = questionRepository.save(questionEntity);

        // 4. Convertir le résultat en DTO pour le renvoyer au contrôleur
        return mapToDTO(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Convertit une Entité BDD en DTO JSON
    private QuestionDTO mapToDTO(QuestionEntity entity) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(entity.getId());
        dto.setQuestion(entity.getQuestion());
        
        if (entity.getOptions() != null) {
            List<OptionsDTO> optionsDtos = entity.getOptions().stream().map(optEntity -> {
                OptionsDTO optDto = new OptionsDTO();
                optDto.setId(optEntity.getId());
                optDto.setText(optEntity.getText());
                optDto.setIsCorrect(optEntity.getIsCorrect());
                return optDto;
            }).collect(Collectors.toList());
            dto.setOptions(optionsDtos);
        }
        
        return dto;
    }
	
}




















