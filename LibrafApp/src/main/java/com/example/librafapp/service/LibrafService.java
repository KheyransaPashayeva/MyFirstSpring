package com.example.librafapp.service;

import com.example.librafapp.dto.LibrafRequestDto;
import com.example.librafapp.dto.LibrafResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LibrafService {
    LibrafResponseDto getLibrafById(Long id) throws Exception;
    List<LibrafResponseDto> getAllLibraf();
    void deleteLibrafById(Long id);
    void addLibraf(LibrafRequestDto dto);
}
