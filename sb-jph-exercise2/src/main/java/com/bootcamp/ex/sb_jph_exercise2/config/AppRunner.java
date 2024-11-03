package com.bootcamp.ex.sb_jph_exercise2.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.ex.sb_jph_exercise2.entity.AddressEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.CommentEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.CompanyEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.GeoEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.PostEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.UserEntity;
import com.bootcamp.ex.sb_jph_exercise2.mapping.Mapper;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.PostPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.UserPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.repository.CommentRepository;
import com.bootcamp.ex.sb_jph_exercise2.repository.PostRepository;
import com.bootcamp.ex.sb_jph_exercise2.repository.UserRepository;
import com.bootcamp.ex.sb_jph_exercise2.service.JphService;
import com.bootcamp.ex.sb_jph_exercise2.service.UserService;

@Configuration // Server start can run "run(String... args) method"
public class AppRunner implements CommandLineRunner { // CommandLineRunner -> run once server start
  @Autowired
  private JphService jphService;

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public void run(String... args) throws Exception {
    List<UserPlaceHolder> users = this.jphService.getRawUsers();
    List<PostPlaceHolder> posts = this.jphService.getRawPosts();
    List<CommentPlaceHolder> comments = this.jphService.getRawComments();

    // Convert and construct List<UserEntity>
    List<UserEntity> userEntities = users.stream()
      .map(u -> {
        UserEntity userEntity = this.mapper.map(u);

        AddressEntity addressEntity = this.mapper.map(u.getAddress());
        GeoEntity geoEntity = this.mapper.map(u.getAddress().getGeo());
        geoEntity.setAddress(addressEntity);
        addressEntity.setGeo(geoEntity);
        addressEntity.setUser(userEntity);

        userEntity.setAddress(addressEntity);

        CompanyEntity companyEntity = this.mapper.map(u.getCompany());
        companyEntity.setUser(userEntity);

        userEntity.setCompany(companyEntity);

        List<PostEntity> postEntities = posts.stream()
          .filter(p -> p.getUserId().equals(u.getId()))
          .map(p -> {
            PostEntity postEntity = this.mapper.map(p);

            List<CommentEntity> commentEntities = comments.stream()
              .filter(c -> c.getPostId().equals(p.getId()))
              .map(c -> {
                CommentEntity commentEntity = this.mapper.map(c);
                commentEntity.setPost(postEntity);
                return commentEntity;
              }).collect(Collectors.toList());

            postEntity.setComments(commentEntities);
            postEntity.setUser(userEntity);

            return postEntity;
          }).collect(Collectors.toList());

        userEntity.setPosts(postEntities);

        return userEntity;
      }).collect(Collectors.toList());

      this.userService.saveAll(userEntities);
  }
}
