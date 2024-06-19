package com.src.practiceredis.dao;

import com.src.practiceredis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER";

    // Save User
    public User save(User user) {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    // Get user by userId
    public User getUserById(String userId) {
        User user = (User) redisTemplate.opsForHash().get(KEY, userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    // Update user by userId
    public User updateUser(User user) {
        User userToBeUpdated = getUserById(user.getUserId());
        if (userToBeUpdated == null) {
            throw new RuntimeException("User not found");
        }
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    // Find All
    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    // Delete user by userId
    public void deleteUserById(String userId) {
        User userToBeDeleted = getUserById(userId);
        if (userToBeDeleted == null) {
            throw new RuntimeException("User not found");
        }
        redisTemplate.opsForHash().delete(KEY, userId);
    }
}
