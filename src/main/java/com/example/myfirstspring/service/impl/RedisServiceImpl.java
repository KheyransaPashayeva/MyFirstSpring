package com.example.myfirstspring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl {

    private final RedisTemplate<String,Object> redisTemplate;

    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public void delete(String key){
            redisTemplate.delete(key);
    }
}
