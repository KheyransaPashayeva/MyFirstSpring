package com.example.aliveninoapp.service.impl;

import com.example.aliveninoapp.dao.entity.AliVeNinoEntity;
import com.example.aliveninoapp.dao.repository.AliVeNinoRepository;
import com.example.aliveninoapp.dto.AliVeNinoRequestDto;
import com.example.aliveninoapp.dto.AliVeNinoResponseDto;
import com.example.aliveninoapp.mapper.AliVeNinoMapper;
import com.example.aliveninoapp.service.AliVeNinoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AliVeNinoServiceImpl implements AliVeNinoService {
    private final AliVeNinoRepository repository;
    private final AliVeNinoMapper mapper;
    @Override
    public AliVeNinoResponseDto getLibrafById(Long id) throws Exception {
        AliVeNinoEntity entity=repository.findById(id).orElseThrow(() -> new Exception());
        return mapper.entityToDto(entity);
    }

    @Override
    public List<AliVeNinoResponseDto> getAllLibraf() {
        List<AliVeNinoEntity> list=repository.findAll();
        return mapper.entityListToDto(list);
    }

    @Override
    public void deleteLibrafById(Long id) {

    }

    @Override
    public void addLibraf(AliVeNinoRequestDto dto) {
        AliVeNinoEntity entity=AliVeNinoEntity.builder()
                .name(dto.getName())
                .author(dto.getAuthor())
                .stock(dto.getStock())
                .price(dto.getPrice())
                .build();
        repository.save(entity);
    }
}
