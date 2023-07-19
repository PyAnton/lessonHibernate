package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {
    void addUser();
    void dellUser();
    List<User> getAllUsers();
    User findUser();


}
