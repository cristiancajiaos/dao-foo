package com.example.daofoo.service;

import com.example.daofoo.dao.UserDao;
import com.example.daofoo.dto.UserDTO;
import com.example.daofoo.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public UserDTO getUserById(Long userId) {
    User foundUser = userDao.getUserById(userId);
    return convertToDTO(foundUser);
  }

  @Override
  public List<UserDTO> getAllUsers() {
    return userDao.getAllUsers().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public UserDTO saveUser(UserDTO userDTO) {
    User userToCreateOrUpdate = convertToEntity(userDTO);
    User createdOrUpdatedUser = userDao.saveUser(userToCreateOrUpdate);
    return convertToDTO(createdOrUpdatedUser);
  }

  @Transactional
  @Override
  public void deleteUser(Long userId) {
    userDao.deleteUser(userId);
  }

  private User convertToEntity(UserDTO userDTO) {
    return new User(userDTO.userId(), userDTO.userName(), userDTO.userEmail());
  }

  private UserDTO convertToDTO(User user) {
    return new UserDTO(user.getUserId(), user.getUserName(), user.getUserEmail());
  }
}
