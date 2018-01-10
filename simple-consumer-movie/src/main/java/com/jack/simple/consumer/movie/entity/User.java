package com.jack.simple.consumer.movie.entity;

import java.math.BigDecimal;
import lombok.Data;

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