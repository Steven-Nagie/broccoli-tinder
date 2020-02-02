package com.steven.nagie.domain.impl.users;

import com.steven.nagie.domain.api.repository.UserRepository;
import com.steven.nagie.domain.api.users.UserService;
import com.steven.nagie.schema.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserRepository userRepository;
  
  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }
  
  @Override
  public void deleteUser(Long userId) {
    userRepository.findById(userId).ifPresent(u -> userRepository.delete(u));
  }
  
  @Override
  public User findUser(Long userId) {
    return userRepository.findById(userId).orElseThrow();
  }
}
