package com.tf8.quizapp.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.entity.OptionsEntity;
import com.tf8.quizapp.model.entity.QuestionEntity;

class QuestionMapperTest {

    private QuestionMapper questionMapper;
    private OptionsMapper optionsMapper;

    @BeforeEach
    void setUp() {
        optionsMapper = Mappers.getMapper(OptionsMapper.class);
        questionMapper = Mappers.getMapper(QuestionMapper.class);
    }

    @Test
    void testToDTO() {
        QuestionEntity entity = new QuestionEntity();
        entity.setId(1L);
        entity.setQuestion("What is JVM ?");

        OptionsEntity option = new OptionsEntity();
        option.setId(10L);
        option.setText("Java Virtual Machine");
        option.setIsCorrect(true);

        entity.setOptions(List.of(option));

        QuestionDTO dto = questionMapper.toDTO(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getQuestion(), dto.getQuestion());

        assertNotNull(dto.getOptions());
        assertTrue(dto.getOptions().isEmpty());
    }

    @Test
    void testToEntity() {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(2L);
        dto.setQuestion("What is JVM ?");

        OptionsDTO optDto = new OptionsDTO();
        optDto.setId(20L);
        optDto.setText("Java Virtual Machine");
        optDto.setIsCorrect(true);

        dto.setOptions(List.of(optDto));

        QuestionEntity entity = questionMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getQuestion(), entity.getQuestion());

        assertNull(entity.getQuiz());

        assertNotNull(entity.getOptions());
        assertTrue(entity.getOptions().isEmpty());
    }
}
