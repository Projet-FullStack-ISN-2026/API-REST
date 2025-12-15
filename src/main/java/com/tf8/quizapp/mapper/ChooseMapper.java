package com.tf8.quizapp.mapper;

import com.tf8.quizapp.model.dto.ChooseDTO;
import com.tf8.quizapp.model.entity.ChooseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
 
/**
* @author DIENE Serigne Fallou
*/
 
/**
* Mapping interface for Choice Management (Player Responses).
* MapStruct will generate the implementation automatically during compilation.
*/

@Mapper(componentModel = "spring")
public interface ChooseMapper {
 
	/**
     * Converts the Entity (DB) to the DTO (API).
     */
    @Mapping(source = "user.id", target = "idUser")
    @Mapping(source = "option.id", target = "idOption")
    ChooseDTO toDto(ChooseEntity entity);

    // No toEntity(ChooseDTO dto) method here.
    // The inverse transformation requires database calls (findById)
    // to transform Long (IDs) into objects (UserEntity, OptionsEntity).
    // This logic will be implemented in ChooseService.
}
 