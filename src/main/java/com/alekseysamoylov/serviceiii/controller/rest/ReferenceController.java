package com.alekseysamoylov.serviceiii.controller.rest;

import com.alekseysamoylov.serviceiii.entity.reference.Customer;
import com.alekseysamoylov.serviceiii.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alekseysamoylov on 1/1/17.
 */
@RestController
@RequestMapping(value = "/rest")
public class ReferenceController {

    private CustomerService customerService;

    @Autowired
    public ReferenceController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @CrossOrigin
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Long addUser(@RequestBody Customer customer) {
        return customerService.saveCustomerAndGetUserId(customer);
    }


}
