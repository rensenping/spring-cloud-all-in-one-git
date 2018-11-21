package com.itmuch.cloud.study.controller;

import com.jack.common.entity.User;
import com.jack.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yangyueming
 */
@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return (User) userRepository.findById(id).orElse(null);
  }

  @GetMapping("/get")
  public User get(User user) {
    return user;
  }

  @PostMapping("/post")
  public User post(@RequestBody User user) {
    return user;
  }
}
