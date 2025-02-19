package com.example.customerapp.controller;

import com.example.customerapp.dto.CustomerRequestDto;
import com.example.customerapp.dto.CustomerResponseDto;
import com.example.customerapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("{id}")
    public CustomerResponseDto getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }
    @PostMapping
    public void createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        customerService.add(customerRequestDto);
    }
    @GetMapping
    public List<CustomerResponseDto> getCustomers() {
        return customerService.findAll();
    }
    @PutMapping("{id}")
    public void updateCustomer(@PathVariable Long id,@RequestBody CustomerRequestDto customerRequestDto) {
        customerService.update(id, customerRequestDto);
    }
    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}
