package com.carsharing.services;

import com.carsharing.models.User;
import com.carsharing.repositories.UserRepository;
import com.carsharing.validators.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserService(
            UserRepository userRepository,
            UserValidator userValidator
    ) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        userValidator.validate(id, userRepository.findAll());
        return userRepository.findById(id).orElseThrow();
    }

    public User save(User user) {
        userValidator.validate(user, userRepository.findAll());
        return userRepository.save(user);
    }

    public User update(User user, Long id) {
        userValidator.validate(user, userRepository.findAll());
        return userRepository.update(id, user);
    }

    public String delete(Long id) {
        userValidator.validate(id, userRepository.findAll());
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }
}
