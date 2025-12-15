package com.tf8.quizapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.entity.QuestionEntity;

/**
 * @author imane
 */

@Mapper(componentModel = "spring", uses = { OptionsMapper.class })
public interface QuestionMapper {

    @Mapping(target = "options", ignore = true)
    QuestionDTO toDTO(QuestionEntity entity);
    
    @Mapping(target = "options", ignore = true)
    QuestionEntity toEntity(QuestionDTO dto);
}

