package com.example.aliveninoapp.controller;

import com.example.aliveninoapp.dto.AliVeNinoRequestDto;
import com.example.aliveninoapp.dto.AliVeNinoResponseDto;
import com.example.aliveninoapp.service.AliVeNinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/alino")
public class AliVeNinoController {
    private final AliVeNinoService aliVeNinoService;

    @GetMapping("{id}")
    public AliVeNinoResponseDto getLibraf(@PathVariable Long id) throws Exception {
        return aliVeNinoService.getLibrafById(id);
    }
    @PostMapping
    public void createLibraf(@RequestBody AliVeNinoRequestDto dto) {

        aliVeNinoService.addLibraf(dto);
    }
    @GetMapping("/all")
    public List<AliVeNinoResponseDto> getAllLibraf()  {

        return aliVeNinoService.getAllLibraf();
    }
    @DeleteMapping
    public void deleteLibraf(@PathVariable Long id) {

        aliVeNinoService.deleteLibrafById(id);
    }
    @PutMapping("{id}")
    public void updateLibraf(@PathVariable Long id, @RequestBody AliVeNinoRequestDto dto) {
        aliVeNinoService.updateAlino(id, dto);
    }

}
