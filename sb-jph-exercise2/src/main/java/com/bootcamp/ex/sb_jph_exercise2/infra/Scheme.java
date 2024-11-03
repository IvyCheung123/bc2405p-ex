package com.bootcamp.ex.sb_jph_exercise2.infra;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTP("http"),
  HTTPS("https"),
  ;

  private String protocol;

  private Scheme(String protocol) {
    this.protocol = protocol;
  }
}
