package com.bootcamp.ex.sb_jph_exercise2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentDto {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
