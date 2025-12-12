package com.tf8.quizapp.mapper;
 
import com.tf8.quizapp.model.dto.UserDTO;
import com.tf8.quizapp.model.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
 
import static org.junit.jupiter.api.Assertions.*;
 
/**
* @author DIENE Serigne Fallou
*/
 
/**
* Unit tests for the UserMapper.
* This class verifies the correct data transformation between UserEntity
* and UserDTO using the MapStruct generated implementation.
*/
class UserMapperTest {
 
    // Retrieves the mapper instance via MapStruct factory.
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
 
    /**
     * Verifies that a UserEntity is correctly mapped to UserDTO.
     */
    @Test
    void shouldMapEntityToDto() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setEmail("test@quiz.com");
        entity.setFirstname("Jean");
        entity.setLastname("Dupont");
        entity.setPassword("secret123");
        entity.setRole(1);
 
        UserDTO dto = userMapper.toDto(entity);
 
        assertNotNull(dto, "The resulting DTO should not be null");
        assertEquals(1L, dto.getId());
        assertEquals("test@quiz.com", dto.getEmail());
        assertEquals("Jean", dto.getFirstname());
        assertEquals(1, dto.getRole());
    }
 
    /**
     * Verifies that a UserDTO is correctly mapped to a UserEntity.
     * Also checks that specific fields (like 'choices') are ignored during mapping.
     */
    @Test
    void shouldMapDtoToEntity() {
        UserDTO dto = new UserDTO();
        dto.setEmail("nouveau@quiz.com");
        dto.setPassword("pass123");
        dto.setFirstname("Marie");
 
        UserEntity entity = userMapper.toEntity(dto);
 
        assertNotNull(entity, "The resulting Entity should not be null");
        assertEquals("nouveau@quiz.com", entity.getEmail());
        assertEquals("Marie", entity.getFirstname());
 
        // The 'choices' list must be null (because it is ignored in the mapper)
        assertNull(entity.getChoices(), "The choices list should be ignored during DTO");
    }
}
 