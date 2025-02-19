package com.example.customerapp.mapper;

import com.example.customerapp.dao.entity.CustomerEntity;
import com.example.customerapp.dto.CustomerRequestDto;
import com.example.customerapp.dto.CustomerResponseDto;
import org.mapstruct.*;

import javax.swing.*;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    @Mapping(source = "name",target = "name")
    List<CustomerResponseDto> customerListToDto(List<CustomerEntity> entities);
    CustomerResponseDto customerToDto(CustomerEntity entity);
    CustomerEntity dtoToCustomer(CustomerRequestDto dto);
}
