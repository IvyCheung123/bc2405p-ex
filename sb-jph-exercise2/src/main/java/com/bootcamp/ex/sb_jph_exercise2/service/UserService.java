package com.bootcamp.ex.sb_jph_exercise2.service;

import java.util.List;
import com.bootcamp.ex.sb_jph_exercise2.entity.UserEntity;
import com.bootcamp.ex.sb_jph_exercise2.model.UserCommentDto;

public interface UserService {
  List<UserEntity> saveAll(List<UserEntity> userEntities);

  List<UserEntity> getAll();

  UserEntity getUserById(Long id);

  List<UserCommentDto> getUserCommentById(Long id);
}
