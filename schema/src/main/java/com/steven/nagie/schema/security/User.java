package com.steven.nagie.schema.security;

import javax.persistence.*;

@Entity
@Table(schema = "security")
public class User {
  
  private Long id;
  private String username;
  
  public User(String username) {
    this.username = username;
  }
  
  public User() {
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
}
