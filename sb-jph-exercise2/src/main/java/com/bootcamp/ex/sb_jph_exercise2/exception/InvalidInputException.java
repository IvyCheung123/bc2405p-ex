package com.bootcamp.ex.sb_jph_exercise2.exception;

// Long.perseLong() throws NumberFormatException
public class InvalidInputException extends NumberFormatException {
  public InvalidInputException(String messgae) {
    super(messgae);
  }
}
