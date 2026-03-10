package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public List<User> getUsersByLevel(int level) {
        return userRepository.findByLevel(level);
    }

    public User addUser(User user) {
        try {
            return userRepository.insert(user);
        } catch (Exception e) {
            System.err.println("Failed to add user: " + e.getMessage());
        }

        return null;
    }

    public User updateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            System.err.println("Failed to update user: " + e.getMessage());
        }

        return null;
    }

    public boolean deleteUser(String id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Failed to delete user: " + e);

            return false;
        }

        return true;
    }
}
