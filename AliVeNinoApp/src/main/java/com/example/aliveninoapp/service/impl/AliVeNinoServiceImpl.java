package com.example.aliveninoapp.service.impl;

import com.example.aliveninoapp.dao.entity.AliVeNinoEntity;
import com.example.aliveninoapp.dao.repository.AliVeNinoRepository;
import com.example.aliveninoapp.dto.AliVeNinoRequestDto;
import com.example.aliveninoapp.dto.AliVeNinoResponseDto;
import com.example.aliveninoapp.mapper.AliVeNinoMapper;
import com.example.aliveninoapp.mapper.AliVeNinoMappper;
import com.example.aliveninoapp.service.AliVeNinoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AliVeNinoServiceImpl implements AliVeNinoService {
    private final AliVeNinoRepository repository;
//    private final AliVeNinoMapper mapper;
    private final AliVeNinoMappper mapper;
    @Override
    public AliVeNinoResponseDto getLibrafById(Long id) throws RuntimeException {
         return  repository.findById(id)
                 .map(mapper::toResponseDto)
                 .orElseThrow(()->new RuntimeException());
    }

    @Override
    public List<AliVeNinoResponseDto> getAllLibraf() {
         return repository.findAll().stream()
                 .map(mapper::toResponseDto)
                 .toList();
    }

    @Override
    public void deleteLibrafById(Long id) {
        repository.findById(id).ifPresent(entity -> repository.deleteById(id));
    }

    @Override
    public void addLibraf(AliVeNinoRequestDto dto) {
       AliVeNinoEntity aliVeNinoEntity =mapper.toEntity(dto);
       mapper.toResponseDto(repository.save(aliVeNinoEntity));
    }

    @Override
    public void updateAlino(Long id,AliVeNinoRequestDto dto) {
         AliVeNinoEntity entity = repository.findById(id).orElseThrow(()->new RuntimeException());
         mapper.updateFromRequetToEntity(dto, entity);
         repository.save(entity);
//         mapper.toResponseDto(entity);
//
    }
}
