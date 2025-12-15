/*package com.tf8.quizapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

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
