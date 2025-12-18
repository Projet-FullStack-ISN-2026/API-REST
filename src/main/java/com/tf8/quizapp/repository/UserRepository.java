package com.tf8.quizapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tf8.quizapp.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

	
	Optional<UserEntity> findByEmail(String email);

}
