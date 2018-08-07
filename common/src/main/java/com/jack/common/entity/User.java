package com.jack.common.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yangyueming
 */
@Data
public class User {
  private Long id;
  private String username;
  private String name;
  private Integer age;
  private BigDecimal balance;
}