package com.ohar.pdbserver.service;

import com.ohar.pdbserver.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUserById(long id);

    User getUserByLogin(String login);

    User editUser(User user);

    boolean deleteUser(long id);

    List<User> getAllUsers();
}
