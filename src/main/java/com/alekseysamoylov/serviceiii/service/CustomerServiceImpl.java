package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.reference.Customer;
import com.alekseysamoylov.serviceiii.entity.security.User;
import com.alekseysamoylov.serviceiii.entity.security.UserRole;
import com.alekseysamoylov.serviceiii.repository.CustomerRepository;
import com.alekseysamoylov.serviceiii.repository.UserRepository;
import com.alekseysamoylov.serviceiii.repository.UserRoleRepository;
import com.alekseysamoylov.serviceiii.service.security.MyPasswordEncoder;
import com.alekseysamoylov.serviceiii.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Реализация {@link CustomerService}
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final MyPasswordEncoder myPasswordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, MyPasswordEncoder myPasswordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.customerRepository = customerRepository;
        this.myPasswordEncoder = myPasswordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    @Transactional
    public Long saveCustomerAndGetUserId(Customer customer) {
        String pass = customer.getUser().getPass();
        String encodedPass = myPasswordEncoder.encodePassword(pass);
        customer.getUser().setPass(encodedPass);
        User userDB = userRepository.saveAndFlush(customer.getUser());
        UserRole userRole = new UserRole(userDB, RoleEnum.ROLE_CUSTOMER);
        userRoleRepository.saveAndFlush(userRole);
        customer.setUser(userDB);
        customerRepository.saveAndFlush(customer);
        return userDB.getId();
    }
}
