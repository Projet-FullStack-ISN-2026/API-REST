package com.tf8.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.tf8.quizapp.model.dto.OptionsDTO;
 
/**
 * @author imane
 */
@Repository
public interface OptionsRepository  extends JpaRepository<OptionsDTO, Long> {
 
}