package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.security.User;
import com.alekseysamoylov.serviceiii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link UserService}.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findOneByUsernameFetchLazy(username);
    }
}
