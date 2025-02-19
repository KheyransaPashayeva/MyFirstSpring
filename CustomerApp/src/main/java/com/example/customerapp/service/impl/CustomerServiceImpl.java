package com.example.customerapp.service.impl;

import com.example.customerapp.dao.entity.CustomerEntity;
import com.example.customerapp.dao.repository.CustomerRepository;
import com.example.customerapp.dto.CustomerRequestDto;
import com.example.customerapp.dto.CustomerResponseDto;
import com.example.customerapp.exception.CustomerNotFoundException;
import com.example.customerapp.mapper.CustomerMapper;
import com.example.customerapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper customerMapper;
    @Override
    public CustomerResponseDto findById(Long id) {
        return  repository.findById(id)
                .map(customerMapper::customerToDto)
                .orElseThrow(()->new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public List<CustomerResponseDto> findAll() {
        List<CustomerEntity> list = repository.findAll();
        return customerMapper.customerListToDto(list);
    }

    @Override
    public void add(CustomerRequestDto customerRequestDto) {
        repository.save(customerMapper.dtoToCustomer(customerRequestDto));

    }

    @Override
    public void update(Long id, CustomerRequestDto customerRequestDto) {
        CustomerEntity entity =repository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found"));
        entity.setAge(customerRequestDto.getAge());
        entity.setFullName(customerRequestDto.getFullName());
        entity.setBalance(customerRequestDto.getBalance());
        repository.save(entity);

    }

    @Override
    public void deleteById(Long id) {
          repository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found"));
          repository.deleteById(id);
//          if(!repository.existsById(id)) {
//              throw new CustomerNotFoundException("Customer not found");
//          }
//          repository.deleteById(id);
    }

    @Override
    public void decreaseBalance(Long customerid, BigDecimal price) {
          CustomerEntity entity =repository.findById(customerid)
                  .orElseThrow(()->new CustomerNotFoundException("Customer not found"));
          entity.setBalance(entity.getBalance().subtract(price));
          repository.save(entity);
    }
}
