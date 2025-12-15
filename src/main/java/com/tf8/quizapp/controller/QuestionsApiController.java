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

/*import com.fasterxml.jackson.databind.ObjectMapper;

import com.tf8.quizapp.model.dto.QuestionCreate;
import com.tf8.quizapp.model.dto.QuestionDetailed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionsApiController implements QuestionsApi {

    private static final Logger log = LoggerFactory.getLogger(QuestionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public QuestionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<QuestionDetailed>> questionsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<QuestionDetailed>>(objectMapper.readValue("[ {\n  \"question\" : \"Quelle est la capitale de la France ?\",\n  \"options\" : [ \"\", \"\" ],\n  \"id\" : 0\n}, {\n  \"question\" : \"Quelle est la capitale de la France ?\",\n  \"options\" : [ \"\", \"\" ],\n  \"id\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<QuestionDetailed>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<QuestionDetailed>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuestionDetailed> questionsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody QuestionCreate body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuestionDetailed>(objectMapper.readValue("{\n  \"question\" : \"Quelle est la capitale de la France ?\",\n  \"options\" : [ \"\", \"\" ],\n  \"id\" : 0\n}", QuestionDetailed.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuestionDetailed>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuestionDetailed>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> questionsQuestionIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID unique de la question.", required=true, schema=@Schema()) @PathVariable("questionId") Long questionId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuestionDetailed> questionsQuestionIdGet(@Parameter(in = ParameterIn.PATH, description = "ID unique de la question.", required=true, schema=@Schema()) @PathVariable("questionId") Long questionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuestionDetailed>(objectMapper.readValue("{\n  \"question\" : \"Quelle est la capitale de la France ?\",\n  \"options\" : [ \"\", \"\" ],\n  \"id\" : 0\n}", QuestionDetailed.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuestionDetailed>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuestionDetailed>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuestionDetailed> questionsQuestionIdPut(@Parameter(in = ParameterIn.PATH, description = "ID unique de la question.", required=true, schema=@Schema()) @PathVariable("questionId") Long questionId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody QuestionCreate body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuestionDetailed>(objectMapper.readValue("{\n  \"question\" : \"Quelle est la capitale de la France ?\",\n  \"options\" : [ \"\", \"\" ],\n  \"id\" : 0\n}", QuestionDetailed.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuestionDetailed>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuestionDetailed>(HttpStatus.NOT_IMPLEMENTED);
    }

}*/


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
