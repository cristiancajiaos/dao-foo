package com.example.daofoo.service;

import com.example.daofoo.dto.UserDTO;
import com.example.daofoo.entity.User;
import java.util.List;

public interface UserService {

  UserDTO getUserById(Long userId);

  List<UserDTO> getAllUsers();

  UserDTO saveUser(UserDTO userDTO);

  void deleteUser(Long userId);

}
