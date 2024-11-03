package com.bootcamp.ex.sb_jph_exercise2.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class ApiUtil {
  @Value("${api.url.domain}")
  private String domain;

  public String getUrl(Scheme scheme, String endpoint) {
    return UriComponentsBuilder.newInstance() //
      .scheme(scheme.getProtocol()) //
      .host(this.domain) //
      .path(endpoint)
      .toUriString();
  }
}
