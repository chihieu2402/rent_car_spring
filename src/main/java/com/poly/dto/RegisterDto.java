package com.poly.dto;

import com.poly.dto.RegisterDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterDto {

  private String name;


  private String password;
}
