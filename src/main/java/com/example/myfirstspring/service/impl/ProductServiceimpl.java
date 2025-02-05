package com.example.myfirstspring.service.impl;

import com.example.myfirstspring.dao.entity.ProductEntity;
import com.example.myfirstspring.dao.repository.ProductRepository;
import com.example.myfirstspring.dto.ProductRequestDto;
import com.example.myfirstspring.dto.ProductResponseDto;
import com.example.myfirstspring.mapper.ProductMapper;
import com.example.myfirstspring.service.ProductService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Data
@Builder
@Service
public class ProductServiceimpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void addProduct(ProductRequestDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
        productRepository.save(entity);
    }

    @Override
    public List<ProductResponseDto> getProdut() {
        List<ProductEntity> entity = productRepository.findAll();

        return productMapper.getProduct(entity);
    }


    @Override
    public ProductResponseDto getbyId(Long id) throws Exception {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        ProductEntity entity = ProductEntity.builder().build();
        if (optionalProductEntity.isPresent()) {
            entity = optionalProductEntity.get();
            return productMapper.getById(entity);
        }

        throw new Exception("bele bir id yoxdur!!!");
    }

    @Override
    public ProductRequestDto updateProduct(ProductRequestDto dto, Long id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if(optionalProductEntity.isPresent()){
            ProductEntity  productEntity= optionalProductEntity.get();
            productEntity.setName(dto.getName());
            productEntity.setPrice(dto.getPrice());
            productRepository.save(productEntity);
        }
        return ProductRequestDto.builder()
                .name(dto.getName())
                .price(dto.getPrice()).
                updated_at(dto.getUpdated_at())
                .created_at(dto.getCreated_at())
                .build();
    }

    @Override
    public String deleteProductById(Long id)throws Exception {
        Optional<ProductEntity> entity = productRepository.findById(id);

        if(entity.isPresent()) {
            productRepository.deleteById(id);
            return "row is deleted";
        }
        throw new Exception("Id not found!!!");
    }

    public List<ProductResponseDto> getByPrice(BigDecimal price){
        List<ProductEntity> entity = productRepository.findByPrice(price);
        return productMapper.getProduct(entity);

    }

    @Override
    public List<ProductResponseDto> getByName(String name) {
        List<ProductEntity> entities = productRepository.findByName(name);
        return productMapper.getProduct(entities);
    }
    public List<ProductResponseDto> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        List<ProductEntity> entities = productRepository.findByPriceRange(minPrice, maxPrice);
        return productMapper.getProduct(entities);
    }

    @Override
    public List<Object[]> getProductByCategory() {

        return productRepository.findProductWithCategory();
    }

    public List<ProductResponseDto> getByNameContains(String name) {
        List<ProductEntity> entities = productRepository.findByNameContains(name);
        return productMapper.getProduct(entities);
    }

    public Long countProducts() {
        return productRepository.countProducts();
    }

    public ProductResponseDto getMostExpensiveProduct() {
        ProductEntity entity = productRepository.findMostExpensiveProduct();
        return productMapper.getById(entity);
    }

    public List<ProductResponseDto> getLatestProducts() {
        List<ProductEntity> entities = productRepository.findLatestProducts();
        return productMapper.getProduct(entities);
    }

    public BigDecimal getAveragePrice() {
        return productRepository.findAveragePrice();
    }

    public List<Object[]> getProductCountByCategory() {
        return productRepository.findProductCountByCategory();
    }

    public List<Object[]> getProductNamesAndPrices() {
        return productRepository.findProductNamesAndPrices();
    }

    public List<ProductResponseDto> getProductsByDate(LocalDate date) {
        List<ProductEntity> entities = productRepository.findProductsByDate(date);
        return productMapper.getProduct(entities);
    }

    public List<String> getDistinctProductNames() {
        return productRepository.findDistinctProductNames();
    }

    public List<ProductResponseDto> getByNameAndPriceGreaterThan(String name, BigDecimal price) {
        List<ProductEntity> entities = productRepository.findByNameAndPriceGreaterThan(name, price);
        return productMapper.getProduct(entities);
    }

}
