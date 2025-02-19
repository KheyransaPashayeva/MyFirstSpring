package com.example.myfirstspring.controller;

import com.example.myfirstspring.dto.ProductRedisDto;
import com.example.myfirstspring.dto.ProductResponseDto;
import com.example.myfirstspring.service.impl.RedisServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/redis")
@RequiredArgsConstructor
public class RedisController {
//    private final RedisTemplate<Object,String> redisTemplate;
//    private final RedisServiceImpl redisService;
    private final RedisTemplate<String, Object> redisTemplate; // Düzəliş edildi ✅
    private final RedisServiceImpl redisService;

    @GetMapping
    public void set() {
        redisService.set("hello", "world");
        redisTemplate.opsForValue().set("test", "test3");
        redisTemplate.opsForValue().set("product", new ProductRedisDto(1L, "apple", 5));
    }
//    @GetMapping
//    public void set() {
//        redisService.set("hello", "world");
//        redisTemplate.opsForValue().set("test","test3");
//        redisTemplate.opsForValue().set("product",new ProductRedisDto(1L,"apple",5).toString());
//    }
    @GetMapping("all")
    public ArrayList<String> getElementsExcept (){
        var list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");

        var list2 =  Arrays.asList("a", "b", "c", "Z");

        for(String e : list2) {
            list1.remove(e);
        }
        return  list1;
    }

}
