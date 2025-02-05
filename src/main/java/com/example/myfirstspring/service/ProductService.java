package com.example.myfirstspring.service;

import com.example.myfirstspring.dto.ProductRequestDto;
import com.example.myfirstspring.dto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public interface ProductService {
    void addProduct(ProductRequestDto dto);
    List<ProductResponseDto> getProdut();
    ProductResponseDto getbyId(Long id) throws Exception;
    ProductRequestDto updateProduct(ProductRequestDto dto,Long id);
    String deleteProductById(Long id) throws Exception;
    public List<ProductResponseDto> getByPrice(BigDecimal price);
    public List<ProductResponseDto> getByName(String name);
    List<ProductResponseDto> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<Object[]> getProductByCategory();

    List<ProductResponseDto> getByNameContains(String name);

    Long countProducts();

    ProductResponseDto getMostExpensiveProduct();

    List<ProductResponseDto> getLatestProducts();

    BigDecimal getAveragePrice();

    List<Object[]> getProductCountByCategory();

    List<Object[]> getProductNamesAndPrices();

    List<ProductResponseDto> getProductsByDate(LocalDate date);

    List<String> getDistinctProductNames();

    List<ProductResponseDto> getByNameAndPriceGreaterThan(String name, BigDecimal price);
}
