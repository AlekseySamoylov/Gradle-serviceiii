package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.reference.Customer;
import com.alekseysamoylov.serviceiii.entity.security.User;
import com.alekseysamoylov.serviceiii.entity.work.Work;
import com.alekseysamoylov.serviceiii.repository.UserRepository;
import com.alekseysamoylov.serviceiii.service.security.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация {@link UserService}.
 */
@Service
@CacheConfig(cacheNames = Work.CACHE_NAME)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final MyPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MyPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Cacheable
    public User findByUsername(String username) {
        return userRepository.findOneByUsernameFetchLazy(username);
    }

    @Override
    @CacheEvict(value = {User.CACHE_NAME, Customer.CACHE_NAME}, allEntries = true) // чистим кэш для групп работ
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

    @Override
    @Cacheable
    public List<String> getLoginList() {
        List<String> loginList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            loginList.add(user.getUsername());
        }
        return loginList;
    }
}
