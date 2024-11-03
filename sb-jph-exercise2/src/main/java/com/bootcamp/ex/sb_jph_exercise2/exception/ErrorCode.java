package com.bootcamp.ex.sb_jph_exercise2.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  USER_NOT_FOUND_EXCEPTION("000001", "User does not exist."),
  POST_NOT_FOUND_EXCEPTION("000002", "Post does not exist."),
  COMMENT_NOT_FOUND_EXCEPTION("000003", "Comment does not exist."),
  INVALID_INPUT_EXCEOTION("000004", "Invalid input."),
  RUNTIME_ERROR("000666", "Runtime error."),
  UNKNOWN_ERROR("000777", "Unknown error."),
  ;

  private String code;
  private String message;

  private ErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
