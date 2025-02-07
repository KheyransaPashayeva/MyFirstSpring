package com.example.book.service.impl;

import com.example.book.client.AliVeNinoFeingClient;
import com.example.book.client.LibrafFeingClient;
import com.example.book.dao.repository.BookRepository;
import com.example.book.dto.AliVeNinoDto;
import com.example.book.dto.BooksDto;
import com.example.book.dto.LibrafClientDto;
import com.example.book.mapper.BookMapper;
import com.example.book.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
private final LibrafFeingClient librafFeingClient;
private final AliVeNinoFeingClient aliVeNinoFeingClient;
private final BookMapper mapper;
private final BookRepository bookRepository;

    @Override
    public List<LibrafClientDto> getLibrafClients() {
        return librafFeingClient.getLibrafAll();
    }

    @Override
    public void addLibrafClient(LibrafClientDto librafClientDto) {
        librafFeingClient.addLibraf(librafClientDto);
    }

    @Override
    public Map<String, List<BooksDto>> getAllBooks() {
        List<AliVeNinoDto >aliVeNinoDto=  aliVeNinoFeingClient.getAliNoAll();
        List<LibrafClientDto>librafClientDto =librafFeingClient.getLibrafAll();

        return mapper.listMapAllBooks(aliVeNinoDto,librafClientDto);
    }



    @Override
    public void addAliVeNino(AliVeNinoDto dto) {

    }
}
