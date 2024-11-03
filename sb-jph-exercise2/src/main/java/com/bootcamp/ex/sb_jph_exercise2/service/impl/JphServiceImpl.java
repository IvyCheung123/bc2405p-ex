package com.bootcamp.ex.sb_jph_exercise2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.ex.sb_jph_exercise2.infra.ApiUtil;
import com.bootcamp.ex.sb_jph_exercise2.infra.Scheme;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.PostPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.UserPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.service.JphService;

@Service
public class JphServiceImpl implements JphService {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ApiUtil apiUtil;

  @Value("${api.url.endpoint.user}")
  private String userEndpoint;

  @Value("${api.url.endpoint.post}")
  private String postEndpoint;

  @Value("${api.url.endpoint.comment}")
  private String commentEndpoint;

  @Override
  public List<UserPlaceHolder> getRawUsers() {
    String url = this.apiUtil.getUrl(Scheme.HTTPS, this.userEndpoint);
    List<UserPlaceHolder> users = List.of(this.restTemplate.getForObject(url, UserPlaceHolder[].class));
    return users;
  }

  @Override
  public List<PostPlaceHolder> getRawPosts() {
    String url = this.apiUtil.getUrl(Scheme.HTTPS, this.postEndpoint);
    List<PostPlaceHolder> posts = List.of(this.restTemplate.getForObject(url, PostPlaceHolder[].class));
    return posts;
  }

  @Override
  public List<CommentPlaceHolder> getRawComments() {
    String url = this.apiUtil.getUrl(Scheme.HTTPS, this.commentEndpoint);
    List<CommentPlaceHolder> comments = List.of(this.restTemplate.getForObject(url, CommentPlaceHolder[].class));
    return comments;
  }
}
