package com.example.customerapp.service;

import com.example.customerapp.dto.CustomerRequestDto;
import com.example.customerapp.dto.CustomerResponseDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface CustomerService {
    CustomerResponseDto findById(Long id);
    List<CustomerResponseDto> findAll();
    void add(CustomerRequestDto customerRequestDto);
    void update(Long id,CustomerRequestDto customerRequestDto);
    void deleteById(Long id);
    void decreaseBalance(Long customerid, BigDecimal price);
}
