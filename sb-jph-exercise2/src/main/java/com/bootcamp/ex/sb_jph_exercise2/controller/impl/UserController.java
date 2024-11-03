package com.bootcamp.ex.sb_jph_exercise2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.ex.sb_jph_exercise2.controller.UserOperation;
import com.bootcamp.ex.sb_jph_exercise2.entity.UserEntity;
import com.bootcamp.ex.sb_jph_exercise2.model.UserCommentDto;
import com.bootcamp.ex.sb_jph_exercise2.service.UserService;

@RestController
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;

  @Override
  public List<UserEntity> getAllUserPostComment() {
    return this.userService.getAll();
  }

  @Override
  public UserEntity getUserById(String id) {
    return this.userService.getUserById(Long.parseLong(id));
  }
  
  @Override
  public List<UserCommentDto> getUserCommentById(String id) {
    return this.userService.getUserCommentById(Long.parseLong(id));
  }
}
