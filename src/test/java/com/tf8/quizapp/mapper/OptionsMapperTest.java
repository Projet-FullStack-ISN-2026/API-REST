package com.tf8.quizapp.mapper;

import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.entity.OptionsEntity;

public class OptionsMapperTest {

	
    private final OptionsMapper mapper = Mappers.getMapper(OptionsMapper.class);

    @Test
    void testToDTO() {
        OptionsEntity entity = new OptionsEntity();
        entity.setId(10L);
        entity.setText("Yes");
        entity.setIsCorrect(true);
        OptionsDTO dto = mapper.toDTO(entity);

        assertNotNull(dto);
        assertEquals(10L, dto.getId());
        assertEquals("Yes", dto.getText());
    }
    
    @Test
    void testToEntity() {
        OptionsDTO dto = new OptionsDTO();
        dto.setId(5L);
        dto.setText("No");

        OptionsEntity entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(5L, entity.getId());
        assertEquals("No", entity.getText());
    }
}
