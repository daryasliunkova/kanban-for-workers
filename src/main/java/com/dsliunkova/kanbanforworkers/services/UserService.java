package com.dsliunkova.kanbanforworkers.services;

import com.dsliunkova.kanbanforworkers.entities.User;
import com.dsliunkova.kanbanforworkers.repositories.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(new Integer(id));
    }

    public void insertUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}
