package com.tf8.quizapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.dto.QuestionDTO;

import jakarta.validation.Valid;



@RestController
public class QuestionsApiController implements QuestionsApi {
	// --- 1. LISTER TOUTES LES QUESTIONS ---
    @Override
    public ResponseEntity<?> listAllQuestions() {
        // Mock : Liste de 2 questions
        QuestionDTO q1 = new QuestionDTO();
        q1.setId(101L);
        q1.setQuestion("Quelle est la capitale de l'Espagne ?");
        
        QuestionDTO q2 = new QuestionDTO();
        q2.setId(102L);
        q2.setQuestion("Combien de continents y a-t-il ?");

        return ResponseEntity.ok(Arrays.asList(q1, q2));
    }

    // --- 2. CRÉER UNE QUESTION ---
    @Override
    public ResponseEntity<?> createQuestion(@Valid QuestionDTO body) {
        // Mock : On simule la création en renvoyant l'objet reçu avec un ID généré
    	QuestionDTO createdQuestion = new QuestionDTO();
        createdQuestion.setId(999L); // ID simulé
        createdQuestion.setQuestion(body.getQuestion());
        
        // On suppose qu'on transforme les OptionCreate en OptionDetailed
        List<OptionsDTO> detailedOptions = new ArrayList<>();
        if (body.getOptions() != null) {
            long optId = 1;
            for (OptionsDTO optSource : body.getOptions()) {
            	OptionsDTO optDest = new OptionsDTO();
                optDest.setId(optId++);
                optDest.setText(optSource.getText());
                optDest.setIsCorrect(optSource.getIsCorrect());
                detailedOptions.add(optDest);
            }
        }
        createdQuestion.setOptions(detailedOptions);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    // --- 3. OBTENIR UNE QUESTION ---
    @Override
    public ResponseEntity<?> getQuestion(Long questionId) {
        // Mock : Une question détaillée avec ses réponses
        QuestionDTO q = new QuestionDTO();
        q.setId(questionId);
        q.setQuestion("En quelle année a eu lieu la bataille de Marignan ?");

        // Options
        OptionsDTO o1 = new OptionsDTO(); o1.setId(10L); o1.setText("1515"); o1.setIsCorrect(true);
        OptionsDTO o2 = new OptionsDTO(); o2.setId(11L); o2.setText("1789"); o2.setIsCorrect(false);
        OptionsDTO o3 = new OptionsDTO(); o3.setId(12L); o3.setText("1945"); o3.setIsCorrect(false);
        OptionsDTO o4 = new OptionsDTO(); o4.setId(12L); o4.setText("1947"); o4.setIsCorrect(false);
        
        q.setOptions(Arrays.asList(o1, o2, o3));

        return ResponseEntity.ok(q);
    }

    // --- 4. MODIFIER UNE QUESTION ---
    @Override
    public ResponseEntity<?> modifyQuestion(Long questionId, @Valid QuestionDTO body) {
        // Mock : On renvoie la question mise à jour
    	QuestionDTO updatedQ = new QuestionDTO();
        updatedQ.setId(questionId);
        updatedQ.setQuestion(body.getQuestion()); // Nouveau texte
        
        // Simuler la mise à jour des options (simplifié)
        updatedQ.setOptions(new ArrayList<>()); 

        return ResponseEntity.ok(updatedQ);
    }

    // --- 5. SUPPRIMER UNE QUESTION ---
    @Override
    public ResponseEntity<?> deleteQuestion(Long questionId) {
        // Mock : 204 No Content -> Suppression réussie
        return ResponseEntity.noContent().build();
    }
	
	
}
