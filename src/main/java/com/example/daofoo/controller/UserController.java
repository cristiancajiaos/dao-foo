package com.example.daofoo.controller;

import com.example.daofoo.dto.UserDTO;
import com.example.daofoo.entity.User;
import com.example.daofoo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
    try {
      UserDTO createdUser = userService.saveUser(userDTO);
      return ResponseEntity.ok(createdUser);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    try {
      List<UserDTO> foundUsers = userService.getAllUsers();
      return ResponseEntity.ok(foundUsers);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "userId") Long userId) {
    try {
      UserDTO foundUser = userService.getUserById(userId);
      return ResponseEntity.ok(foundUser);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping
  public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
    try {
      UserDTO updatedUser = userService.saveUser(userDTO);
      return ResponseEntity.ok(updatedUser);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
    try {
      userService.deleteUser(userId);
      return ResponseEntity.ok("Delete ok");
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }
}
