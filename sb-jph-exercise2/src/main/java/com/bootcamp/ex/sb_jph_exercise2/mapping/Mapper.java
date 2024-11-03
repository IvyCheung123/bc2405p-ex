package com.bootcamp.ex.sb_jph_exercise2.mapping;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.bootcamp.ex.sb_jph_exercise2.entity.AddressEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.CommentEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.CompanyEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.GeoEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.PostEntity;
import com.bootcamp.ex.sb_jph_exercise2.entity.UserEntity;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentDto;
import com.bootcamp.ex.sb_jph_exercise2.model.CommentPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.PostDto;
import com.bootcamp.ex.sb_jph_exercise2.model.PostPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.UserDto;
import com.bootcamp.ex.sb_jph_exercise2.model.UserPlaceHolder;
import com.bootcamp.ex.sb_jph_exercise2.model.UserDto.AddressDto;
import com.bootcamp.ex.sb_jph_exercise2.model.UserDto.CompanyDto;
import com.bootcamp.ex.sb_jph_exercise2.model.UserDto.AddressDto.GeoDto;

@Component
public class Mapper {
  public UserEntity map(UserPlaceHolder userPlaceHolder) {
    return UserEntity.builder()
      .name(userPlaceHolder.getName())
      .username(userPlaceHolder.getUsername())
      .email(userPlaceHolder.getEmail())
      .phone(userPlaceHolder.getPhone())
      .website(userPlaceHolder.getWebsite())
      .build();
  }

  public AddressEntity map(UserPlaceHolder.Address address) {
    return AddressEntity.builder()
      .street(address.getStreet())
      .suite(address.getSuite())
      .city(address.getCity())
      .zipcode(address.getZipcode())
      .build();
  }

  public GeoEntity map(UserPlaceHolder.Address.Geo geo) {
    return GeoEntity.builder()
      .lat(geo.getLat())
      .lng(geo.getLng())
      .build();
  }

  public CompanyEntity map(UserPlaceHolder.Company company) {
    return CompanyEntity.builder()
      .name(company.getName())
      .catchPhrase(company.getCatchPhrase())
      .bs(company.getBs())
      .build();
  }

  public PostEntity map(PostPlaceHolder postPlaceHolder) {
    return PostEntity.builder()
      .title(postPlaceHolder.getTitle())
      .body(postPlaceHolder.getBody())
      .build();
  }

  public CommentEntity map(CommentPlaceHolder commentPlaceHolder) {
    return CommentEntity.builder()
      .name(commentPlaceHolder.getName())
      .email(commentPlaceHolder.getEmail())
      .body(commentPlaceHolder.getBody())
      .build();
  }

  public CommentDto map(CommentEntity commentEntity) {
    return CommentDto.builder()
      .postId(commentEntity.getPost().getId())
      .id(commentEntity.getId())
      .name(commentEntity.getName())
      .email(commentEntity.getEmail())
      .body(commentEntity.getBody())
      .build();
  }

  public PostDto map(PostEntity postEntity) {
    return PostDto.builder()
      .id(postEntity.getId())
      .title(postEntity.getTitle())
      .body(postEntity.getBody())
      .build();
  }

  public UserDto map(UserEntity userEntity) {
    GeoDto geoDto = GeoDto.builder()
      .lat(userEntity.getAddress().getGeo().getLat())
      .lng(userEntity.getAddress().getGeo().getLng())
      .build();

    AddressDto addressDto = AddressDto.builder()
      .street(userEntity.getAddress().getStreet())
      .suite(userEntity.getAddress().getSuite())
      .city(userEntity.getAddress().getCity())
      .zipcode(userEntity.getAddress().getZipcode())
      .geoDto(geoDto)
      .build();

    CompanyDto companyDto = CompanyDto.builder()
      .name(userEntity.getCompany().getName())
      .catchPhrase(userEntity.getCompany().getCatchPhrase())
      .bs(userEntity.getCompany().getBs())
      .build();

    List<CommentDto> commentDtos = userEntity.getPosts().stream()
      .map(postEntity -> {
        CommentDto commentDto = postEntity.getComments().stream()
          .map(commentEntity -> this.map(commentEntity))
          .findFirst()
          .get();
        return commentDto;
      }).collect(Collectors.toList());

    List<PostDto> postDtos = userEntity.getPosts().stream()
      .map(postEntity -> {
        PostDto postDto = this.map(postEntity);
        postDto.setComments(commentDtos);
        return postDto;
      }).collect(Collectors.toList());
    
    return UserDto.builder()
      .name(userEntity.getName())
      .username(userEntity.getUsername())
      .email(userEntity.getEmail())
      .addressDto(addressDto)
      .phone(userEntity.getPhone())
      .website(userEntity.getWebsite())
      .companyDto(companyDto)
      .posts(postDtos)
      .build();
  }
}
