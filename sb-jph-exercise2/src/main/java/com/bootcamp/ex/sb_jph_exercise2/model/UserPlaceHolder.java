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
public class UserPlaceHolder {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  // One to One
  @Getter
  @ToString
  public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @ToString
    public class Geo {
      private String lat;
      private String lng;
    }
  }

  // One to One
  @Getter
  @ToString
  public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
