package com.bootcamp.ex.sb_jph_exercise2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.ex.sb_jph_exercise2.entity.UserEntity;
import com.bootcamp.ex.sb_jph_exercise2.exception.ErrorCode;
import com.bootcamp.ex.sb_jph_exercise2.exception.UserNotFoundException;
import com.bootcamp.ex.sb_jph_exercise2.mapping.Mapper;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentDto;
import com.bootcamp.ex.sb_jph_exercise2.model.UserCommentDto;
import com.bootcamp.ex.sb_jph_exercise2.model.UserDto;
import com.bootcamp.ex.sb_jph_exercise2.repository.UserRepository;
import com.bootcamp.ex.sb_jph_exercise2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return this.userRepository.saveAll(userEntities);
  }

  @Override
  public List<UserEntity> getAll() {
    return this.userRepository.findAll();
  }

  @Override
  public UserEntity getUserById(Long id) {
    return this.getAll().stream()
      .filter(u -> u.getId().equals(id))
      .findFirst()
      // .get();
      .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
  }

  @Override
  public List<UserCommentDto> getUserCommentById(Long id) {
    // raw: post1 [comment1, comment2], post2 [comment3, comment4]
    // expect: user1 [comment1, comment2, comment3, comment4]
    // List<List<CommentDto>> convert to List<Comment>
    // flatMap()
    // Input to Output 1 input -> 1 output 1 input -> n outputs (flattened)
    UserEntity userEntity = this.getAll().stream()
      .filter(u -> u.getId().equals(id))
      .findFirst()
      .get();

    UserDto userDto = this.mapper.map(userEntity);

    List<CommentDto> targetCommentDtos = userDto.getPosts().stream()
      .flatMap(postDto -> postDto.getComments().stream())
      .collect(Collectors.toList());

    List<UserCommentDto> result = new ArrayList<>();
    UserCommentDto target = UserCommentDto.builder()
      .id(userDto.getId())
      .username(userDto.getUsername())
      .comments(targetCommentDtos)
      .build();

    result.add(target);

    return result;
  }
}
