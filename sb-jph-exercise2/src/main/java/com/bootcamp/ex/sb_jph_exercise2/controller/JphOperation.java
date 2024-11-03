package com.bootcamp.ex.sb_jph_exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.PostPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.UserPlaceHolder;

public interface JphOperation {
  @GetMapping(value = "/raw/users")
  List<UserPlaceHolder> getRawUsers();

  @GetMapping(value = "/raw/posts")
  List<PostPlaceHolder> getRawPosts();

  @GetMapping(value = "/raw/comments")
  List<CommentPlaceHolder> getRawComments();
}
