package com.steven.nagie.bootstrap;

import com.steven.nagie.api.impl.UserEndpoint;
import com.steven.nagie.schema.security.User;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.FileAssert.fail;

@ContextConfiguration(classes = ITConfig.class)
@TestPropertySource("classpath:test-application.properties")
@WebAppConfiguration
public class BroccoliTinderTestIt extends AbstractTestNGSpringContextTests {
  
  @Autowired
  private UserEndpoint userEndpoint;
  
  @Test
  public void testUserFlow() {
    String testName = "testUserFlow";
    User created = userEndpoint.saveUser(new User(testName));
    assertEquals(created.getUsername(), testName);
    assertNotNull(created.getId());
    User found = userEndpoint.findUser(created.getId());
    assertEquals(found.getUsername(), testName);
    assertEquals(found.getId(), created.getId());
    userEndpoint.deleteUser(created.getId());
    
    try {
      found = userEndpoint.findUser(created.getId());
      fail("User does not exist, should have thrown an error");
    } catch (Exception e) {}
  }
}
