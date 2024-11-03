package com.bootcamp.ex.sb_jph_exercise2.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
  private Long id;
  private String name;
  private String username;
  @Column(name = "user_email")
  private String email;
  private AddressDto addressDto;
  private String phone;
  private String website;
  private CompanyDto companyDto;
  @Builder.Default
  private List<PostDto> posts = new ArrayList<>();

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  @Builder
  @JsonIgnoreProperties
  public static class AddressDto {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geoDto;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties
    public static class GeoDto {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  @Builder
  @JsonIgnoreProperties
  public static class CompanyDto {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
