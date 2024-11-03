package com.bootcamp.ex.sb_jph_exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.ex.sb_jph_exercise2.entity.UserEntity;
import com.bootcamp.ex.sb_jph_exercise2.model.UserCommentDto;

public interface UserOperation {
  @GetMapping(value = "/getAllUserPostComment")
  List<UserEntity> getAllUserPostComment();

  @GetMapping(value = "/getUserById")
  UserEntity getUserById(@RequestParam String id);

  @GetMapping(value = "/getUserCommentById")
  List<UserCommentDto> getUserCommentById(@RequestParam String id);
}
