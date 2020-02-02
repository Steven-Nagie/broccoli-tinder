package com.steven.nagie.api.impl;

import com.steven.nagie.domain.api.users.UserService;
import com.steven.nagie.schema.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserEndpoint {

  @Autowired
  private UserService service;

  @PostMapping
  @PutMapping
  public User saveUser(@RequestBody User user) {
    return service.saveUser(user);
  }
  
  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable("userId") Long userId) {
    service.deleteUser(userId);
  }
  
  @GetMapping("/{userId}")
  public User findUser(@PathVariable("userId") Long userId) {
    return service.findUser(userId);
  }
}
