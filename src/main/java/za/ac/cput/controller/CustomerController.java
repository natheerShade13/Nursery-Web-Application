package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;

// Build objects using Factory to utilize Helper classes;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public void registerCustomer(@RequestBody Customer customer){
        customerService.create(customer);
    }

    @PutMapping("/update") //
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.update(customer);
    }

}
