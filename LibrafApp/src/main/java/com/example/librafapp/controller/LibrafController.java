package com.example.librafapp.controller;

import com.example.librafapp.dto.LibrafRequestDto;
import com.example.librafapp.dto.LibrafResponseDto;
import com.example.librafapp.service.LibrafService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraf")
public class LibrafController {
    private final LibrafService librafService;

    @GetMapping("{id}")
    public LibrafResponseDto getLibraf(@PathVariable Long id) throws Exception {
        return librafService.getLibrafById(id);
    }
    @PostMapping
    public void createLibraf(@RequestBody LibrafRequestDto dto) {
        librafService.addLibraf(dto);
    }
    @GetMapping("/all")
    public List<LibrafResponseDto> getAllLibraf()  {
        return librafService.getAllLibraf();
    }
    @DeleteMapping
    public void deleteLibraf(@PathVariable Long id) {
        librafService.deleteLibrafById(id);
    }
}
