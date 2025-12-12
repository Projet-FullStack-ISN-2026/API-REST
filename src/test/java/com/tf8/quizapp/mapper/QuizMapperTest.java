package com.tf8.quizapp.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.tf8.quizapp.model.dto.QuizDTO;
import com.tf8.quizapp.model.entity.QuizEntity;
import com.tf8.quizapp.model.entity.QuestionEntity;

public class QuizMapperTest {
	

    private QuizMapperImpl mapper;
   
    @BeforeEach
    void setUp() {
        mapper = new QuizMapperImpl();
        mapper.setQuestionMapper(Mappers.getMapper(QuestionMapper.class));
    }

    @Test
    void testToDTO() {
        QuizEntity entity = new QuizEntity();
        entity.setId(100L);
        entity.setTitle("Java Quiz");
        entity.setStatus(10);
        entity.setStartQuestionTime(new Timestamp(0));
        entity.setCurrentQuestionNumber(1);
        entity.setStep(10);

        QuestionEntity q = new QuestionEntity();
        q.setId(1L);
        q.setQuestion("What is JVM ?");

        entity.setQuestions(List.of(q));

        QuizDTO dto = mapper.toDTO(entity);

        assertEquals(100L, dto.getId());
        assertEquals("Java Quiz", dto.getTitle());
        assertEquals(1, dto.getQuestionList().size());
        assertEquals("What is JVM ?", dto.getQuestionList().get(0).getQuestion());
    }

    @Test
    void testToEntity() {
        QuizDTO dto = new QuizDTO();
        dto.setId(2L);
        dto.setTitle("DTO Quiz");

        QuizEntity entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getTitle(), entity.getTitle());
        assertNotNull(entity.getQuestions());
        assertTrue(entity.getQuestions().isEmpty());
    }

}
