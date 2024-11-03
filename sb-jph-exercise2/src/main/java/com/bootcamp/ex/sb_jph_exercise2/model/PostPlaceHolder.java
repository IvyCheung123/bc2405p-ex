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
public class PostPlaceHolder {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
