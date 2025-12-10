package com.tf8.quizapp.repository;

import com.tf8.quizapp.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author DIENE Serigne Fallou
 */

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmail(String email);
}
