package com.poly.util;

import lombok.Data;

@Data
public class _enum {
  public enum RoleUserEnum {
    ADMIN(0),
    OWNER(1),
    USER(2);

    private final int value;

    RoleUserEnum(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }

  }

  public enum AuthTypeEnum {
    LOCAL,
    GOOGLE,
    FACEBOOK
  }
}