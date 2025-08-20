package com.example.daofoo.dao;

import com.example.daofoo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @PersistenceContext
  private EntityManager em;

  @Override
  public User getUserById(Long userId) {
    User user = em.find(User.class, userId);
    return user;
  }

  @Override
  public List<User> getAllUsers() {
    TypedQuery<User> userQuery = em.createQuery("FROM User", User.class);
    List<User> users = userQuery.getResultList();
    return users;
  }

  @Override
  public User saveUser(User user) {
    User dbUser = em.merge(user);
    return dbUser;
  }

  @Override
  public void deleteUser(Long userId) {
    User user = em.find(User.class, userId);
    em.remove(user);
  }
}
