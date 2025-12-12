package com.tf8.quizapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tf8.quizapp.model.dto.QuizDTO;
import com.tf8.quizapp.model.entity.QuizEntity;

/**
 * @author imane
 */

@Mapper(componentModel = "spring", uses = { QuestionMapper.class })
public interface QuizMapper {
	
    @Mapping(target = "listQuestions", ignore = true)
    QuizDTO toDTO(QuizEntity entity);
    
    @Mapping(target = "questions", ignore = true)
    QuizEntity toEntity(QuizDTO dto);
}

