package com.tf8.quizapp.mapper;
 
import com.tf8.quizapp.model.dto.UserDTO;
import com.tf8.quizapp.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* @author DIENE Serigne Fallou
*/

/**
* Mapping interface for the user.
* MapStruct will generate the implementation automatically during compilation.
*/
@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Converts the Entity (DB) to the DTO (API).
     */
    UserDTO toDto(UserEntity entity);
    /**
     * Converts the DTO (API) to the Entity (DB).
     */
    // The 'choices' list is ignored because the DTO does not contain the game history.
    @Mapping(target = "choices", ignore = true)
    UserEntity toEntity(UserDTO dto);
}
 