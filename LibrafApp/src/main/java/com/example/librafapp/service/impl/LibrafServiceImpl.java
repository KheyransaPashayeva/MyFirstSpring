package com.example.librafapp.service.impl;

import com.example.librafapp.dao.entity.LibrafEntity;
import com.example.librafapp.dao.repository.LibrafRepository;
import com.example.librafapp.dto.LibrafRequestDto;
import com.example.librafapp.dto.LibrafResponseDto;
import com.example.librafapp.mapper.LibrafMapper;
import com.example.librafapp.service.LibrafService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LibrafServiceImpl implements LibrafService {
    private final LibrafRepository repository;
    private final LibrafMapper mapper;
    @Override
    public LibrafResponseDto getLibrafById(Long id) throws Exception {
        LibrafEntity entity=repository.findById(id).orElseThrow(() -> new Exception());
        return mapper.entityToDto(entity);
    }

    @Override
    public List<LibrafResponseDto> getAllLibraf() {
        List<LibrafEntity> list=repository.findAll();
        return mapper.entityListToDto(list);
    }

    @Override
    public void deleteLibrafById(Long id) {
     repository.deleteById(id);
    }

    @Override
    public void addLibraf(LibrafRequestDto dto) {
       LibrafEntity entity=LibrafEntity.builder()
               .bookName(dto.getBookName())
               .category(dto.getCategory())
               .stock(dto.getStock())
               .build();
        repository.save(entity);
    }
}
