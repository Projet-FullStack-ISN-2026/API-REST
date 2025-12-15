package com.tf8.quizapp.controller;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tf8.quizapp.model.dto.*;
import com.tf8.quizapp.model.entity.QuizEntity;

import jakarta.validation.Valid;

/*import com.fasterxml.jackson.databind.ObjectMapper;

import com.tf8.quizapp.model.dto.AnswerSubmit;
import com.tf8.quizapp.model.dto.Leaderboard;
import com.tf8.quizapp.model.dto.Question;
import com.tf8.quizapp.model.dto.QuestionDetailed;
import com.tf8.quizapp.model.dto.QuestionLink;
import com.tf8.quizapp.model.dto.Quiz;
import com.tf8.quizapp.model.dto.QuizCreate;
import com.tf8.quizapp.model.dto.QuizDetailed;
import com.tf8.quizapp.model.dto.QuizState;
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
public class QuizApiController implements QuizApi {

    private static final Logger log = LoggerFactory.getLogger(QuizApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public QuizApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Quiz>> quizGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Quiz>>(objectMapper.readValue("[ {\n  \"id\" : 0,\n  \"title\" : \"Quiz de Géographie\",\n  \"status\" : 6\n}, {\n  \"id\" : 0,\n  \"title\" : \"Quiz de Géographie\",\n  \"status\" : 6\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Quiz>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Quiz>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuizDetailed> quizPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody QuizCreate body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizDetailed>(objectMapper.readValue("\"\"", QuizDetailed.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizDetailed>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizDetailed>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuizState> quizQuizIdControlFinishPost(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizState>(objectMapper.readValue("{\n  \"currentQuestionNumber\" : 3,\n  \"startQuestionTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"quizId\" : 0,\n  \"step\" : 1,\n  \"status\" : 6\n}", QuizState.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizState>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizState>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuizState> quizQuizIdControlNextStepPost(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizState>(objectMapper.readValue("{\n  \"currentQuestionNumber\" : 3,\n  \"startQuestionTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"quizId\" : 0,\n  \"step\" : 1,\n  \"status\" : 6\n}", QuizState.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizState>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizState>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuizState> quizQuizIdControlStartPost(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizState>(objectMapper.readValue("{\n  \"currentQuestionNumber\" : 3,\n  \"startQuestionTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"quizId\" : 0,\n  \"step\" : 1,\n  \"status\" : 6\n}", QuizState.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizState>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizState>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> quizQuizIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuizDetailed> quizQuizIdGet(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizDetailed>(objectMapper.readValue("\"\"", QuizDetailed.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizDetailed>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizDetailed>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> quizQuizIdPlayAnswerPost(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AnswerSubmit body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Question> quizQuizIdPlayCurrentQuestionGet(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Question>(objectMapper.readValue("{\n  \"question\" : \"Quelle est la capitale de la France ?\",\n  \"options\" : [ {\n    \"id\" : 6,\n    \"text\" : \"Paris\"\n  }, {\n    \"id\" : 6,\n    \"text\" : \"Paris\"\n  } ],\n  \"id\" : 0\n}", Question.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Question>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Leaderboard> quizQuizIdPlayLeaderboardGet(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Leaderboard>(objectMapper.readValue("{\n  \"entries\" : [ {\n    \"score\" : 8,\n    \"rank\" : 1,\n    \"user\" : {\n      \"firstName\" : \"Guillaume\",\n      \"lastName\" : \"RENOUARD\",\n      \"role\" : 0,\n      \"id\" : 101,\n      \"email\" : \"guillaume.renouard@groupe-esigelec.org\"\n    }\n  }, {\n    \"score\" : 8,\n    \"rank\" : 1,\n    \"user\" : {\n      \"firstName\" : \"Guillaume\",\n      \"lastName\" : \"RENOUARD\",\n      \"role\" : 0,\n      \"id\" : 101,\n      \"email\" : \"guillaume.renouard@groupe-esigelec.org\"\n    }\n  } ],\n  \"quizId\" : 0\n}", Leaderboard.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Leaderboard>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Leaderboard>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuizState> quizQuizIdPlayStateGet(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizState>(objectMapper.readValue("{\n  \"currentQuestionNumber\" : 3,\n  \"startQuestionTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"quizId\" : 0,\n  \"step\" : 1,\n  \"status\" : 6\n}", QuizState.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizState>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizState>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<QuizDetailed> quizQuizIdPut(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody QuizCreate body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizDetailed>(objectMapper.readValue("\"\"", QuizDetailed.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizDetailed>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizDetailed>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<QuestionDetailed>> quizQuizIdQuestionsGet(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
) {
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

    public ResponseEntity<QuizDetailed> quizQuizIdQuestionsPost(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody QuestionLink body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<QuizDetailed>(objectMapper.readValue("\"\"", QuizDetailed.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<QuizDetailed>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<QuizDetailed>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> quizQuizIdQuestionsQuestionIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID unique du quiz.", required=true, schema=@Schema()) @PathVariable("quizId") Long quizId
,@Parameter(in = ParameterIn.PATH, description = "ID unique de la question.", required=true, schema=@Schema()) @PathVariable("questionId") Long questionId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}*/


@RestController
public class QuizApiController implements QuizApi {

	@Override
    public ResponseEntity<?> listQuiz() {
        // Mock : Une liste de 2 quiz simples
        QuizDTO quiz1 = new QuizDTO();
        quiz1.setId(1L);
        quiz1.setTitle("Quiz de Culture Générale");
        quiz1.setStatus(10); // Not started

        QuizDTO quiz2 = new QuizDTO();
        quiz2.setId(2L);
        quiz2.setTitle("Quiz de Géographie");
        quiz2.setStatus(20); // Running

        return ResponseEntity.ok(Arrays.asList(quiz1, quiz2));
    }

    // --- 2. AJOUTER UN QUIZ ---
    @Override
    public ResponseEntity<?> addQuiz(@Valid QuizDTO body) {
        // Mock : On renvoie l'objet reçu avec un ID généré
    	QuizDTO createdQuiz = new QuizDTO();
        createdQuiz.setId(101L); // ID simulé
        createdQuiz.setTitle(body.getTitle());
        createdQuiz.setStatus(10);
        createdQuiz.setQuestions(new ArrayList<>()); // Liste vide au début

        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }

    // --- 3. OBTENIR UN QUIZ (DÉTAILLÉ) ---
    @Override
    public ResponseEntity<?> getQuiz(Long quizId) {
        // Mock : Un quiz complet avec une question et des options
    	QuizDTO quiz = new QuizDTO();
        quiz.setId(quizId);
        quiz.setTitle("Quiz Complet Mocké");
        quiz.setStatus(10);

        // Création d'une question mockée
        QuestionDTO question = new QuestionDTO();
        question.setId(50L);
        question.setQuestion("Quelle est la capitale de la France ?");
        
        // Options
        OptionsDTO opt1 = new OptionsDTO();
        opt1.setId(1L); opt1.setText("Paris"); opt1.setIsCorrect(true);
        
        OptionsDTO opt2 = new OptionsDTO();
        opt2.setId(2L); opt2.setText("Berlin"); opt2.setIsCorrect(false);

        question.setOptions(Arrays.asList(opt1, opt2));
        quiz.setQuestions((ArrayList) Arrays.asList(question));

        return ResponseEntity.ok(quiz);
    }

    // --- 4. MODIFIER UN QUIZ ---
    @Override
    public ResponseEntity<?> modifyQuiz(Long quizId, @Valid QuizDTO body) {
        // Mock : On renvoie le quiz avec le nouveau titre
        QuizDTO updatedQuiz = new QuizDTO();
        updatedQuiz.setId(quizId);
        updatedQuiz.setTitle(body.getTitle()); // Titre modifié
        updatedQuiz.setStatus(10);
        updatedQuiz.setQuestions(new ArrayList<>());

        return ResponseEntity.ok(updatedQuiz);
    }

    // --- 5. SUPPRIMER UN QUIZ ---
    @Override
    public ResponseEntity<?> deleteQuiz(Long quizId) {
        // Mock : Pas de contenu (204) pour dire que c'est bien supprimé
        return ResponseEntity.noContent().build();
    }

    // --- 6. OBTENIR LES QUESTIONS D'UN QUIZ ---
    @Override
    public ResponseEntity<?> getQuizQuestions(Long quizId) {
        // Mock : Liste de questions
        QuestionDTO q1 = new QuestionDTO();
        q1.setId(10L);
        q1.setQuestion("Question A");
        
        QuestionDTO q2 = new QuestionDTO();
        q2.setId(11L);
        q2.setQuestion("Question B");

        return ResponseEntity.ok(Arrays.asList(q1, q2));
    }

    // --- 7. LIER DES QUESTIONS ---
    @Override
    public ResponseEntity<?> linkQuizQuestions(Long quizId) {
        // Mock : On suppose qu'on reçoit un ID de question et on renvoie le quiz mis à jour
        // Simplification : on renvoie juste un 200 OK ou le quiz detail
        return getQuiz(quizId); // Réutilise le mock getQuiz
    }

    // --- 9. LANCER LE QUIZ (Start) ---
    @Override
    public ResponseEntity<?> launchQuiz(Long quizId) {
        // Mock : État qui passe à RUNNING (20)
        QuizDTO state = new QuizDTO();
        state.setId(quizId);
        state.setStatus(20); // Running
        state.setCurrentQuestionNumber(1);
        state.setStep(10); // Display Question
        state.setStartQuestionTime(OffsetDateTime.now()); // Heure actuelle

        return ResponseEntity.ok(state);
    }

    // --- 10. TERMINER LE QUIZ (Finish) ---
    @Override
    public ResponseEntity<?> finishQuiz(Long quizId) {
        // Mock : État qui passe à FINISHED (30)
        QuizDTO state = new QuizDTO();
        state.setId(quizId);
        state.setStatus(30); // Finished
        state.setCurrentQuestionNumber(0);
        state.setStep(0);
        
        return ResponseEntity.ok(state);
    }

    @Override
    public ResponseEntity<?> unlinkQuizQuestions(Long quizId, Long questionId) {
        // Mock : 204 No Content (standard pour une suppression/déliaison réussie)
        return ResponseEntity.ok("Unliked");
    }


    @Override
    public ResponseEntity<?> joinQuiz(Long quizId) {
        // Mock : 200 OK pour confirmer l'inscription du joueur
        return ResponseEntity.ok("Joueur inscrit avec succès au quiz " + quizId);
    }

    @Override
    public ResponseEntity<?> getQuizLobbyStatus(Long quizId) {
        return ResponseEntity.ok("C'est pas fait");
    }

    // --- DÉROULEMENT DES QUESTIONS ---

    @Override
    public ResponseEntity<?> getCurrentQuestion(Long quizId) {
        // Mock : La question actuelle affichée aux joueurs
        QuestionDTO currentQ = new QuestionDTO();
        currentQ.setId(105L);
        currentQ.setQuestion("Quelle est la vitesse de la lumière ?");
        
        // On ajoute des options factices
        OptionsDTO opt1 = new OptionsDTO(); opt1.setId(1L); opt1.setText("300 000 km/s");
        OptionsDTO opt2 = new OptionsDTO(); opt2.setId(2L); opt2.setText("100 km/h");
        currentQ.setOptions(Arrays.asList(opt1, opt2));

        return ResponseEntity.ok(currentQ);
    }

    @Override
    public ResponseEntity<?> getNextQuestion(Long quizId) {
        // Mock : La question suivante (prévisualisation animateur)
    	QuestionDTO nextQ = new QuestionDTO();
        nextQ.setId(106L);
        nextQ.setQuestion("Qui a peint la Joconde ?");
        
        OptionsDTO optA = new OptionsDTO(); optA.setId(3L); optA.setText("Leonardo da Vinci");
        OptionsDTO optB = new OptionsDTO(); optB.setId(4L); optB.setText("Picasso");
        nextQ.setOptions(Arrays.asList(optA, optB));

        return ResponseEntity.ok(nextQ);
    }

    @Override
    public ResponseEntity<?> submitAnswer(Long quizId) {
        // Mock : 202 Accepted (La réponse a été reçue et sera traitée)
        return ResponseEntity.accepted().body("Réponse enregistrée");
    }

    // --- RÉSULTATS & STATS ---

    @Override
    public ResponseEntity<?> getLeaderboard(Long quizId) {
        return ResponseEntity.ok("C'est pas fait");
    }

    @Override
    public ResponseEntity<?> getQuizStats(Long quizId) {
        return ResponseEntity.ok("C'est pas fait");
    }

    @Override
    public ResponseEntity<?> getCorrectAnswer(Long quizId) {
        return ResponseEntity.ok("C'est pas fait");
    }
	
}
