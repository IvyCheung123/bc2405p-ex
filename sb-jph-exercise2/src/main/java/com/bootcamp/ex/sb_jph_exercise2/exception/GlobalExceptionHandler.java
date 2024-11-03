package com.bootcamp.ex.sb_jph_exercise2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND) // 404
  public ErrorResponse handleUserNotFoundException() {
    return ErrorResponse.builder()
      .code(ErrorCode.USER_NOT_FOUND_EXCEPTION.getCode())
      .message(ErrorCode.USER_NOT_FOUND_EXCEPTION.getMessage())
      .build();
  }

  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleInvalidInputException() {
    return ErrorResponse.builder()
      .code(ErrorCode.INVALID_INPUT_EXCEOTION.getCode())
      .message(ErrorCode.INVALID_INPUT_EXCEOTION.getMessage())
      .build();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleRuntimeException() {
    return ErrorResponse.builder()
      .code(ErrorCode.RUNTIME_ERROR.getCode())
      .message(ErrorCode.RUNTIME_ERROR.getMessage())
      .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleException() {
    return ErrorResponse.builder()
      .code(ErrorCode.UNKNOWN_ERROR.getCode())
      .message(ErrorCode.UNKNOWN_ERROR.getMessage())
      .build();
  }
}
