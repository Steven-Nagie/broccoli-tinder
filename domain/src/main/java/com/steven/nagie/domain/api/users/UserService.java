package com.steven.nagie.domain.api.users;

import com.steven.nagie.schema.security.User;

public interface UserService {

  User saveUser(User user);
  
  void deleteUser(Long userId);
  
  User findUser(Long userId);
}
