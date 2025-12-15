package com.tf8.quizapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.dto.QuizDTO;
import com.tf8.quizapp.model.dto.QuizDetailDTO;
import com.tf8.quizapp.model.entity.*;
import com.tf8.quizapp.repository.QuizRepository;
import com.tf8.quizapp.service.*;


import com.tf8.quizapp.service.QuizService;

import jakarta.transaction.Transactional;

@Service
public class QuizServiceImpl implements QuizService {

	//private final QuizRepository quizrepository;
	private final QuizRepository quizRepository;
	
	
	/**
     * Injection de dépendance.
     */
	public QuizServiceImpl(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}
	
	
	//méthode GET de la liste des quiz
	public List<QuizDTO> quizGet(){
		return quizRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
	}
	
	
	@Override
	@Transactional
	public List<QuestionDTO> quizQuizIdQuestionsGet(Long quizId) {
		
		// 1. Récupérer le Quiz par son ID
		Optional<QuizEntity> quizEntityOptional = quizRepository.findById(quizId);
		
		if (quizEntityOptional.isEmpty()) {
			// Si le Quiz n'existe pas, on retourne une liste vide
			return List.of(); 
		}
		
		QuizEntity quiz = quizEntityOptional.get();
		
		
		// Si le champ est 'questionsList' comme suggéré par votre code commenté:
		List<QuestionEntity> listQuestion = new ArrayList<>(quiz.getQuestionsList());		
		
		// 3. Mapper la liste des Entités Question en QuestionDTOs
		return listQuestion.stream()
				.map(this::mapToQuestionDTO) // Utilisation de la nouvelle méthode de mapping
				.collect(Collectors.toList());
	}
	
	
	 
	 @Override
    @Transactional
    public QuizDetailDTO quizQuizIdGetDetail (Long id) {
    	Optional<QuizEntity> quizEntity = quizRepository.findById(id);

        // 2. Vérifier si l'entité existe
    	if (quizEntity.isPresent()) {
            // 3. Mapper l'entité trouvée en DTO et la retourner
    		return mapToDetailDTO(quizEntity.get());
    	} else {
            // 4. Si la question n'est pas trouvée, retourner null ou, 
            //    mieux, lancer une exception personnalisée (non implémentée ici)
    		return null; 
    	}
    }
	 
	 @Override
	    @Transactional
	    public QuizDTO quizStart (Long id) {
	    	Optional<QuizEntity> quizEntity = quizRepository.findById(id);

	        // 2. Vérifier si l'entité existe
	    	if (quizEntity.isPresent()) {
	    		QuizEntity quiz = quizEntity.get();
	    		quiz.setStatus(20);
	    		QuizEntity updatedQuiz = quizRepository.save(quiz);
	    		return mapToDTO(updatedQuiz);
	    	} else {
	            // 4. Si la question n'est pas trouvée, retourner null ou, 
	            //    mieux, lancer une exception personnalisée (non implémentée ici)
	    		return null; 
	    	}
	    }
	 
	 @Override
	    @Transactional
	    public QuizDTO quizFinish (Long id) {
	    	Optional<QuizEntity> quizEntity = quizRepository.findById(id);

	        // 2. Vérifier si l'entité existe
	    	if (quizEntity.isPresent()) {
	    		QuizEntity quiz = quizEntity.get();
	    		quiz.setStatus(30);
	    		QuizEntity updatedQuiz = quizRepository.save(quiz);
	    		return mapToDTO(updatedQuiz);
	    	} else {
	            // 4. Si la question n'est pas trouvée, retourner null ou, 
	            //    mieux, lancer une exception personnalisée (non implémentée ici)
	    		return null; 
	    	}
	    }
	
	//méthode POST d'un quiz
	public QuizEntity quizPost(QuizEntity body) {
		return quizRepository.save(body);
	}
	
	
	
	public void quizQuizIdQuestionsQuestionIdDelete(Long quizId, Long questionId) {
		
	}
	
	//méthode PUT(modification) d'un quiz
	public QuizEntity quizQuizIdPut(Long quizId, QuizEntity body) {
		//récupération du quiz d'ID quizId
		QuizEntity modifiedQuiz = quizRepository.getById(quizId);
		
		//modification des valeurs du quiz récupéré
		modifiedQuiz.setTitle(body.getTitle());
		modifiedQuiz.setStatus(body.getStatus());
		modifiedQuiz.setStartQuestionTime(body.getStartQuestionTime());
		modifiedQuiz.setCurrentQuestionNumber(body.getCurrentQuestionNumber());
		modifiedQuiz.setStep(body.getStep());
		
		//modification du quiz dans la base de données
		return quizRepository.save(modifiedQuiz);
		
	}
	
	private QuizDTO mapToDTO(QuizEntity entity) {
		QuizDTO dto = new QuizDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setStatus(entity.getStatus());
        dto.setStartQuestionTime(entity.getStartQuestionTime());
        dto.setCurrentQuestionNumber(entity.getCurrentQuestionNumber());
        dto.setStep(entity.getStep());
       
        return dto;
    }
	
	private QuizDetailDTO mapToDetailDTO(QuizEntity entity) {
		QuizDetailDTO dto = new QuizDetailDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setStatus(entity.getStatus());
        dto.setStartQuestionTime(entity.getStartQuestionTime());
        dto.setCurrentQuestionNumber(entity.getCurrentQuestionNumber());
        dto.setStep(entity.getStep());
        
        if (entity.getQuestionsList() != null) {
            
            // On mappe la collection d'Entités Question en une collection de QuestionDTO
            List<QuestionDTO> questionsDtos = entity.getQuestionsList().stream()
                // Chaque QuestionEntity est mappée en QuestionDTO
                .map(this::mapToQuestionDTO) 
                .collect(Collectors.toList());
                
            // On assigne la liste de DTOs des questions au champ dans QuizDetailDTO
            // Le champ dans QuizDetailDTO doit exister et s'appeler 'questionsList'
            dto.setQuestionsList(questionsDtos);
        }
       
        return dto;
    }
	
	private QuestionDTO mapToQuestionDTO(QuestionEntity entity) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(entity.getId());
        dto.setQuestion(entity.getQuestion()); // Assumé que la question est dans le champ 'question'
        
        // Mapping des options
        if (entity.getOptions() != null) {
            List<OptionsDTO> optionsDtos = entity.getOptions().stream().map(optEntity -> {
                OptionsDTO optDto = new OptionsDTO();
                optDto.setId(optEntity.getId());
                optDto.setText(optEntity.getText());
                optDto.setCorrect(optEntity.getIsCorrect());
                return optDto;
            }).collect(Collectors.toList());
            dto.setOptions(optionsDtos);
        }
        
        return dto;
    }
	
}