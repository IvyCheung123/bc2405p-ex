package com.bootcamp.ex.sb_jph_exercise2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.ex.sb_jph_exercise2.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  
}
