package com.example.myfirstspring.dao.repository;

import com.example.myfirstspring.dao.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByPrice(BigDecimal price);
    List<ProductEntity> findByName(String name);

        @Query(value = "SELECT * FROM products WHERE price BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
        List<ProductEntity> findByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

        @Query(value = "SELECT * FROM products WHERE name LIKE %:name%", nativeQuery = true)
        List<ProductEntity> findByNameContains(@Param("name") String name);

        @Query(value = "SELECT COUNT(*) FROM products", nativeQuery = true)
        Long countProducts();

        @Query(value = "SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products)", nativeQuery = true)
        ProductEntity findMostExpensiveProduct();

        @Query(value = "SELECT * FROM products ORDER BY created_at DESC LIMIT 10", nativeQuery = true)
        List<ProductEntity> findLatestProducts();

        @Query(value = "SELECT AVG(price) FROM products", nativeQuery = true)
        BigDecimal findAveragePrice();

        @Query(value = "SELECT category, COUNT(*) as count FROM products GROUP BY category", nativeQuery = true)
        List<Object[]> findProductCountByCategory();

        @Query(value = "SELECT name, price FROM products", nativeQuery = true)
        List<Object[]> findProductNamesAndPrices();

        @Query(value = "SELECT * FROM products WHERE DATE(created_at) = :date", nativeQuery = true)
        List<ProductEntity> findProductsByDate(@Param("date") LocalDate date);

        @Query(value = "SELECT DISTINCT name FROM products", nativeQuery = true)
        List<String> findDistinctProductNames();

        @Query(value = "SELECT * FROM products WHERE name LIKE %:name% AND price > :price", nativeQuery = true)
        List<ProductEntity> findByNameAndPriceGreaterThan(@Param("name") String name, @Param("price") BigDecimal price);

        @Query(value = "select product23.id as id, product23.name as productName, category.name as name\n" +
                "from product23 left join category  on product23.category_id = category.id",nativeQuery = true)
        List<Object[]> findProductWithCategory();
    }



