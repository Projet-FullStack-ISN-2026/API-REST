package com.tf8.quizapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.entity.OptionsEntity;

/**
 * @author imane
 */

@Mapper(componentModel = "spring")
public interface OptionsMapper {

    @Mapping(target = "isCorrect", source = "isCorrect")
	OptionsDTO toDTO(OptionsEntity entity);
    
    @Mapping(target = "isCorrect", source = "isCorrect")
    @Mapping(target = "question", ignore = true)
	OptionsEntity toEntity(OptionsDTO dto);
}
