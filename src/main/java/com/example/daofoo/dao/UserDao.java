package com.example.daofoo.dao;

import com.example.daofoo.entity.User;
import java.util.List;

public interface UserDao {

  User getUserById(Long userId);

  List<User> getAllUsers();

  User saveUser(User user);

  void deleteUser(Long userId);
}
