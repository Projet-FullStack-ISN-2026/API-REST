package com.tf8.quizapp.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tf8.quizapp.model.dto.AdminStatDTO;
import com.tf8.quizapp.model.dto.AnswerDTO;
import com.tf8.quizapp.model.dto.ChooseDTO;
import com.tf8.quizapp.model.dto.ClassementDTO;
import com.tf8.quizapp.model.dto.ClassementEntryDTO;
import com.tf8.quizapp.model.dto.DistributionDTO;
import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.dto.QuestionLinkDTO;
import com.tf8.quizapp.model.dto.QuizDTO;
import com.tf8.quizapp.model.dto.QuizDetailDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.model.entity.*;
import com.tf8.quizapp.repository.ChooseRepository;
import com.tf8.quizapp.repository.ClassementRepository;
import com.tf8.quizapp.repository.OptionsRepository;
import com.tf8.quizapp.repository.QuestionRepository;
import com.tf8.quizapp.repository.QuizRepository;
import com.tf8.quizapp.repository.UserRepository;


import com.tf8.quizapp.service.QuizService;

import jakarta.transaction.Transactional;

@Service
public class QuizServiceImpl implements QuizService {

	//private final QuizRepository quizrepository;
	private final QuizRepository quizRepository;
	private final OptionsRepository optionRepository;
	private final UserRepository userRepository;
	private final ChooseRepository chooseRepository;
	private final QuestionRepository questionRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final ClassementRepository classementRepository;

	
	
	/**
     * Injection de dépendance.
     */
	public QuizServiceImpl(QuizRepository quizRepository, OptionsRepository optionRepository, UserRepository userRepository, ChooseRepository chooseRepository, QuestionRepository questionRepository, ClassementRepository classementRepository, BCryptPasswordEncoder passwordEncoder ) {
		this.quizRepository = quizRepository;
		this.optionRepository = optionRepository;
		this.userRepository = userRepository;
		this.chooseRepository = chooseRepository;
		this.questionRepository = questionRepository;
		this.classementRepository = classementRepository;
		this.passwordEncoder = passwordEncoder;

	}
	
	
	//méthode GET de la liste des quiz
	public List<QuizDTO> quizGet(){
		return quizRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
	}
	
	public QuizDetailDTO quizPost(QuizEntity body) {
		if (body.getQuestionsList() != null) {
	        for (QuestionEntity question : body.getQuestionsList()) {
	            // Pour chaque question, vérifier si elle contient des options
	            if (question.getOptions() != null) {
	                for (OptionsEntity option : question.getOptions()) {
	                    // CRUCIAL : Lier l'option à la question parente
	                    // Cela permet à Hibernate de remplir la colonne 'question_id'
	                    option.setQuestion(question);
	                }
	            }
	        }
	    }
	    
	    // Une fois les liens établis, on sauvegarde le quiz
	    QuizEntity savedQuiz = quizRepository.save(body);
	    return mapToDetailDTO(savedQuiz);
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
	public QuizDetailDTO quizQuestionPost(Long quizId, QuestionLinkDTO questionId) {
		Optional<QuizEntity> quizEntityOptional = quizRepository.findById(quizId);
		Optional<QuestionEntity> questionEntityOptional = questionRepository.findById(questionId.getQuestionId());

    	if (quizEntityOptional.isPresent() && questionEntityOptional.isPresent()) {
    		
    		QuizEntity quiz = quizEntityOptional.get();
    		QuestionEntity question = questionEntityOptional.get();
    		
    		List<QuestionEntity> questionList = quiz.getQuestionsList();
    		questionList.add(question);
    		
    		quiz.setQuestionsList(questionList);
    		
    		QuizEntity savedQuiz = quizRepository.save(quiz);
    		return mapToDetailDTO(savedQuiz);
    		
    	} else {
           
    		return null; 
    	}
		
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
	 
	 
	 @Override
	    @Transactional
		public QuestionDTO getCurrentQuestion(Long id) {
		 Optional<QuizEntity> quizEntity = quizRepository.findById(id);

	        // 2. Vérifier si l'entité existe
	    	if (quizEntity.isPresent()) {
	    		QuizEntity quiz = quizEntity.get();

                Integer index = quiz.getCurrentQuestionNumber();

		   		 List<QuestionEntity> lstQuestionQuiz = new ArrayList<>();
				 lstQuestionQuiz = quiz.getQuestionsList();		 
				 
				 QuestionEntity currentQuestion = lstQuestionQuiz.get(index-1);
				
	    		return mapToQuestionDTO(currentQuestion);
	    	} else {
	            // 4. Si la question n'est pas trouvée, retourner null ou, 
	            //    mieux, lancer une exception personnalisée (non implémentée ici)
	    		return null; 
	    	}
		}
	 
	 @Override
	    @Transactional
		public QuestionDTO getNextQuestion(Long id) {
		 Optional<QuizEntity> quizEntity = quizRepository.findById(id);

	        // 2. Vérifier si l'entité existe
	    	if (quizEntity.isPresent()) {
	    		QuizEntity quiz = quizEntity.get();

                Integer index = quiz.getCurrentQuestionNumber()+1;

		   		 List<QuestionEntity> lstQuestionQuiz = new ArrayList<>();
				 lstQuestionQuiz = quiz.getQuestionsList();		 
				 
				 QuestionEntity currentQuestion = lstQuestionQuiz.get(index-1);
				 quiz.setCurrentQuestionNumber(index);
				 quizRepository.save(quiz);
	    		return mapToQuestionDTO(currentQuestion);
	    	} else {
	            // 4. Si la question n'est pas trouvée, retourner null ou, 
	            //    mieux, lancer une exception personnalisée (non implémentée ici)
	    		return null; 
	    	}
		}
	 
	 public ChooseDTO saveAnswer(ChooseDTO body) {

		 	UserEntity user = userRepository.findById(body.getIdUser())
		            .orElseThrow(() -> new RuntimeException("User not found"));

	        QuizEntity quiz = quizRepository.findById(body.getIdQuiz())
	            .orElseThrow(() -> new RuntimeException("Quiz not found"));

	        OptionsEntity option = optionRepository.findById(body.getIdOption())
	            .orElseThrow(() -> new RuntimeException("Option not found"));

	        ChooseEntity choose = new ChooseEntity();
	        choose.setUser(user);
	        choose.setQuiz(quiz);
	        choose.setOption(option);
	        LocalDateTime ldt = LocalDateTime.now();
	        Timestamp ts = Timestamp.valueOf(ldt);
	        choose.setDate(ts);
	        
	        chooseRepository.save(choose);

	        return mapToChooseDTO(choose);
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
	
public ClassementDTO getClassement(Long quizId) {
		
		UserServiceImpl userService = new UserServiceImpl(userRepository, passwordEncoder);

	    // DTO principal
	    ClassementDTO classementDTO = new ClassementDTO();
	    classementDTO.setQuizId(quizId);

	    List<ClassementEntryDTO> entries = new ArrayList<>();

	    // Données brutes
	    SqlRowSet rowSet = classementRepository.getClassementRaw(quizId);

	    int rank = 1;

	    while (rowSet.next()) {

	        // --- User ---
	        UserResponseDTO user = new UserResponseDTO();
	        long id_joueur = rowSet.getInt("user_id");
	        user = userService.getUserById(id_joueur);
	        // --- Entry ---
	        ClassementEntryDTO entry = new ClassementEntryDTO();
	        entry.setRank(rank++);
	        entry.setUser(user);
	        entry.setScore(rowSet.getInt("Score"));

	        entries.add(entry);
	    }

	    classementDTO.setEntries(entries);

	    return classementDTO;
	}
	
	
	public AnswerDTO adminAnswer(Long quizId) {
		Optional<QuizEntity> quizEntity = quizRepository.findById(quizId);
		Long correctOptionId = (long) 0;
		Long questionId =  (long) 0 ;
        // 2. Vérifier si l'entité existe
    	if (quizEntity.isPresent()) {
    		QuizEntity quiz = quizEntity.get();
			 List<QuestionEntity> lstQuestionQuiz = new ArrayList<>();
			 lstQuestionQuiz = quiz.getQuestionsList();		 
			 
			 QuestionEntity question = lstQuestionQuiz.get(quiz.getCurrentQuestionNumber()-1);
    		
			questionId = question.getId();
    		Set<OptionsEntity> options = new HashSet<>();
    		options = question.getOptions();	
    		
    		
    		for (OptionsEntity option : options) {
    			if (option.isCorrect()) {
    				correctOptionId = option.getId();
    			}
    		}
    		AnswerDTO response = new AnswerDTO();
    		
    		response.setCorrectOptionId(correctOptionId);
    		response.setQuestionId(questionId);
    		return response;
    	} else {
            // 4. Si la question n'est pas trouvée, retourner null ou, 
            //    mieux, lancer une exception personnalisée (non implémentée ici)
    		return null; 
    	}
	}
	
	public AdminStatDTO getAdminStats(Long quizId){

		AdminStatDTO adminStat = new AdminStatDTO();
		Integer totalVotesQuestion;
		List<DistributionDTO> listDistributions;

		QuizEntity quiz = quizRepository.getById(quizId);
		List<QuestionEntity> listQuestions = quiz.getQuestionsList();

		List<ChooseEntity> allChoices = chooseRepository.findAll();
		List<ChooseEntity> choicesQuiz = new ArrayList<>();
		for(int i=0; i<allChoices.size();i++) {
			if(allChoices.get(i).getQuiz().getId().equals(quizId))
				choicesQuiz.add(allChoices.get(i));
		}

	
		Integer currentQuestionNumber = 1;
		if(quiz.getCurrentQuestionNumber()!=null)
			currentQuestionNumber = quiz.getCurrentQuestionNumber();
		Long currentQuestionId = new Long(1);
		currentQuestionId = Long.valueOf(listQuestions.get(currentQuestionNumber-1).getId());
		
		
		//stats de la question en cours
		totalVotesQuestion = 0;
		listDistributions = new ArrayList<>();

		//id de la question
		adminStat.setQuestionId(currentQuestionId);

		//nombre total de votes pour la question
		for(int i=0; i<choicesQuiz.size(); i++) {
			OptionsEntity choiceOption = choicesQuiz.get(i).getOption();
			QuestionEntity choiceQuestion = choiceOption.getQuestion();
			if(choiceQuestion.getId().equals(adminStat.getQuestionId())) {
				totalVotesQuestion = totalVotesQuestion + 1;
			}
		}
		adminStat.setTotalVotes(totalVotesQuestion);

		//Pour l'ensemble des distributions des options d'une question
		DistributionDTO distribution;
		List<OptionsEntity> allOptions = optionRepository.findAll();
		List<OptionsEntity> optionsQuestion = new ArrayList<>();
		for(int i=0; i<allOptions.size() ;i++) {
			if(allOptions.get(i).getQuestion().getId().equals(adminStat.getQuestionId())) {
				optionsQuestion.add(allOptions.get(i));
			}
		}

		for(int i=0; i<optionsQuestion.size(); i++) {
			distribution = new DistributionDTO();
			distribution.setOptionId(optionsQuestion.get(i).getId());
			Integer countOption = 0;
			for(int j=0; j<choicesQuiz.size() ;j++) {
				if(choicesQuiz.get(j).getOption().getId().equals(distribution.getOptionId()))
					countOption = countOption + 1;
			}
			distribution.setCount(countOption);
			Double percentage = (double) countOption*100 / (double) totalVotesQuestion ; 
			distribution.setPercentage(percentage);

			listDistributions.add(distribution);
		}
		adminStat.setListDistribution(listDistributions);


		return adminStat;
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
                optDto.setIsCorrect(optEntity.isCorrect());
                return optDto;
            }).collect(Collectors.toList());
            dto.setOptions(optionsDtos);
        }
        
        return dto;
    }
	
	private ChooseDTO mapToChooseDTO(ChooseEntity entity) {
		ChooseDTO dto = new ChooseDTO();
        dto.setIdOption(entity.getOption().getId());
        dto.setIdQuiz(entity.getQuiz().getId()); 
        dto.setIdUser(entity.getUser().getId()); 
        
        
        return dto;
    }
	



	
}