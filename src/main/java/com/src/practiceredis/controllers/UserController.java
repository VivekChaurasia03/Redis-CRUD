package com.src.practiceredis.controllers;

import com.src.practiceredis.dao.UserDao;
import com.src.practiceredis.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    // Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Save User triggered!");
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    // Get single User
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    // Update User
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User user) {
        User existingUser = userDao.getUserById(userId);
        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }
        user.setUserId(userId); // Ensure the userId in the path is set to the user object
        return userDao.updateUser(user);
    }

    // Find all Users
    @GetMapping
    public List<User> getAllUsers() {
        Map<Object, Object> allUsers = userDao.findAll();
        Collection<Object> values = allUsers.values();
        return values.stream().map(value -> (User) value).toList();
    }

    // Delete User
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        User existingUser = userDao.getUserById(userId);
        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }
        userDao.deleteUserById(userId);
    }
}
