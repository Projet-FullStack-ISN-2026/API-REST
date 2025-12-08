package com.tf8.quizapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

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

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-01T13:32:49.487155975Z[GMT]")
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

}
