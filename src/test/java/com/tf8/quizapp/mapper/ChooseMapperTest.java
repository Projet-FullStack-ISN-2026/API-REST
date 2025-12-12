package com.tf8.quizapp.mapper;
 
import com.tf8.quizapp.model.dto.ChooseDTO;
import com.tf8.quizapp.model.entity.ChooseEntity;
import com.tf8.quizapp.model.entity.OptionsEntity;
import com.tf8.quizapp.model.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
 
import java.sql.Timestamp;
import java.time.Instant;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
/**
* Unit tests for the ChooseMapper.
* This class verifies the correct data transformation between ChooseEntity
* and ChooseDTO.
*
* @author DIENE Serigne Fallou
*/
class ChooseMapperTest {
 
    // Retrieve the mapper instance via the MapStruct factory.
    private final ChooseMapper chooseMapper = Mappers.getMapper(ChooseMapper.class);
 
    /**
     * Verifies that a ChooseEntity is correctly mapped to a ChooseDTO.
     * It specifically checks if the IDs of the associated User.
     */
    @Test
    void shouldMapEntityToDto() {
        
        UserEntity user = new UserEntity();
        user.setId(42L); // The ID expected in the DTO
        user.setEmail("joueur@test.com");
 
        // Ensure OptionsEntity exists and has setId()
        OptionsEntity option = new OptionsEntity();
        option.setId(101L);
 
        // Create the Choose entity that links them
        ChooseEntity entity = new ChooseEntity();
        entity.setId(1L);
        entity.setDate(Timestamp.from(Instant.now()));
        entity.setUser(user);       // Link with User
        entity.setOption(option);   // Link with Option
 
        ChooseDTO dto = chooseMapper.toDto(entity);
        assertNotNull(dto, "The resulting DTO must not be null");
        assertEquals(42L, dto.getIdUser(), "The User ID was not mapped correctly");
        assertEquals(101L, dto.getIdOption(), "The Option ID was not mapped correctly");
    }
}