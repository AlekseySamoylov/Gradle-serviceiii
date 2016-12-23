package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.security.User;
import com.alekseysamoylov.serviceiii.repository.UserRepository;
import com.alekseysamoylov.serviceiii.service.security.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link UserService}.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final MyPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MyPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findOneByUsernameFetchLazy(username);
    }

    @Override
    public Long save(User user) {
        return userRepository.saveAndFlush(user).getId();
    }

    @Override
    public Long login(User user) {
        User userFromDB = userRepository.findOneByUsernameFetchLazy(user.getUsername());
        boolean isPasswordRight = false;
        if (userFromDB != null) {
            isPasswordRight = passwordEncoder.matchPassword(user.getPassword(), userFromDB.getPassword());
        }
        if (userFromDB != null && isPasswordRight) {
            return userFromDB.getId();
        } else {
            return null;
        }
    }
}
