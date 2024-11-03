package com.bootcamp.ex.sb_jph_exercise2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.ex.sb_jph_exercise2.controller.JphOperation;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.PostPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.UserPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.service.JphService;

@RestController
public class JphController implements JphOperation {
  @Autowired
  private JphService jphService;

  @Override
  public List<UserPlaceHolder> getRawUsers() {
    return this.jphService.getRawUsers();
  }

  @Override
  public List<PostPlaceHolder> getRawPosts() {
    return this.jphService.getRawPosts();
  }

  @Override
  public List<CommentPlaceHolder> getRawComments() {
    return this.jphService.getRawComments();
  }
}
