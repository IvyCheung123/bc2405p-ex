package com.bootcamp.ex.sb_jph_exercise2.service;

import java.util.List;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.PostPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.UserPlaceHolder;

public interface JphService {
  List<UserPlaceHolder> getRawUsers();

  List<PostPlaceHolder> getRawPosts();

  List<CommentPlaceHolder> getRawComments();
}
