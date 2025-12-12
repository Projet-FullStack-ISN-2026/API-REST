package com.tf8.quizapp.mapper;

import org.mapstruct.Mapper;

import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.entity.OptionsEntity;

/**
 * @author imane
 */

@Mapper(componentModel = "spring")
public interface OptionsMapper {

	OptionsDTO toDTO(OptionsEntity entity);

	OptionsEntity toEntity(OptionsDTO dto);
}
