package com.airbnbclone.airbnbclone.Service;

import com.airbnbclone.airbnbclone.Entity.User;
import com.airbnbclone.airbnbclone.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get All User

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // Create A User

    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get User By ID

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Delete User

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
