package com.example.myfirstspring.controller;


import com.example.myfirstspring.dto.ProductRequestDto;
import com.example.myfirstspring.dto.ProductResponseDto;
import com.example.myfirstspring.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("api/v2/product")

public class ProductController {

    private final ProductService productService;


    @PostMapping("/post")
    public void addProduct(@RequestBody ProductRequestDto dto){
        productService.addProduct(dto);
    }
    @GetMapping("/get")
    public List<ProductResponseDto> getProduct(){
        return productService.getProdut();
    }

    @GetMapping("/get/{id}")
    public ProductResponseDto getById(@PathVariable Long id) throws Exception{
        return productService.getbyId(id);
    }
    @PostMapping("/update/{id}")
    public ProductRequestDto updateById(@RequestBody ProductRequestDto dto,@PathVariable Long id){
        return productService.updateProduct(dto,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProductId(@PathVariable Long id) throws Exception{
        return productService.deleteProductById(id);
    }

    @GetMapping(value = "/get", params = "type=price")
    public List<ProductResponseDto> getByPrice(@RequestParam BigDecimal price){
        return productService.getByPrice(price);
    }
    @GetMapping(value = "/get", params = "type=all")
    public List<ProductResponseDto> getByName(@RequestParam String name){

        return productService.getByName(name);
    }
    @GetMapping("/price-range")
    public List<ProductResponseDto> getByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        return productService.getByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/search")
    public List<ProductResponseDto> getByNameContains(@RequestParam String name) {
        return productService.getByNameContains(name);
    }

    @GetMapping("/count")
    public Long countProducts() {
        return productService.countProducts();
    }

    @GetMapping("/most-expensive")
    public ProductResponseDto getMostExpensiveProduct() {
        return productService.getMostExpensiveProduct();
    }

    @GetMapping("/latest")
    public List<ProductResponseDto> getLatestProducts() {
        return productService.getLatestProducts();
    }

    @GetMapping("/average-price")
    public BigDecimal getAveragePrice() {
        return productService.getAveragePrice();
    }

    @GetMapping("/category-count")
    public List<Object[]> getProductCountByCategory() {
        return productService.getProductCountByCategory();
    }

    @GetMapping("/names-prices")
    public List<Object[]> getProductNamesAndPrices() {
        return productService.getProductNamesAndPrices();
    }

    @GetMapping("/by-date")
    public List<ProductResponseDto> getProductsByDate(@RequestParam LocalDate date) {
        return productService.getProductsByDate(date);
    }

    @GetMapping("/distinct-names")
    public List<String> getDistinctProductNames() {
        return productService.getDistinctProductNames();
    }

    @GetMapping("/search-price")
    public List<ProductResponseDto> getByNameAndPriceGreaterThan(
            @RequestParam String name,
            @RequestParam BigDecimal price) {
        return productService.getByNameAndPriceGreaterThan(name, price);
    }

    @GetMapping("/category")
    public List<Object[]> get(){
     return productService.getProductByCategory();
    }
}
