package com.example.aliveninoapp.service;

import com.example.aliveninoapp.dto.AliVeNinoRequestDto;
import com.example.aliveninoapp.dto.AliVeNinoResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AliVeNinoService {
    AliVeNinoResponseDto getLibrafById(Long id) throws Exception;
    List<AliVeNinoResponseDto> getAllLibraf();
    void deleteLibrafById(Long id);
    void addLibraf(AliVeNinoRequestDto dto);
}
