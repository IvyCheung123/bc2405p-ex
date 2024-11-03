package com.bootcamp.ex.sb_jph_exercise2.exception;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException {
  @Getter
  private String code;

  public UserNotFoundException(ErrorCode errorCode) {
    this(errorCode.getCode(), errorCode.getMessage());
  }
  
  private UserNotFoundException(String code, String message) {
    super(message);
    this.code = code;
  }
}
