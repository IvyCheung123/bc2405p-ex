package com.bootcamp.ex.sb_jph_exercise2.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ErrorResponse {
  private String code;
  private String message;
}
