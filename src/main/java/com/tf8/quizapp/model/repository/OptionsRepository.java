package com.tf8.quizapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tf8.quizapp.model.dto.OptionsDTO;

public interface OptionsRepository  extends JpaRepository<OptionsDTO, Long> {

}
