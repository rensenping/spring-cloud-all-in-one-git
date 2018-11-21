package com.itmuch.cloud.study.controller;

import com.jack.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jack.common.repository.UserRepository;

/**
 * @author yangyueming
 */
@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return userRepository.findById(id).orElse(null);
  }
}
