package com.ohar.pdbserver.service.impl;

import com.ohar.pdbserver.entity.User;
import com.ohar.pdbserver.repository.UserRepository;
import com.ohar.pdbserver.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public User editUser(User user) {
        return repository.findById(user.getId())
                .map(item -> {
                    item.setFirstName(user.getFirstName());
                    item.setLastName(user.getLastName());
                    item.setMail(user.getMail());
                    item.setLogin(user.getLogin());
                    item.setPassword(user.getPassword());
                    item.setStatus(user.getStatus());
                    item.setActivation(user.getActivation());
                    return repository.save(item);
                }).orElse(null);
    }

    @Override
    public boolean deleteUser(long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return true;
                }).orElse(false);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
