package com.example.book.service;

import com.example.book.dto.AliVeNinoDto;
import com.example.book.dto.BooksDto;
import com.example.book.dto.LibrafClientDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BookService {
List<LibrafClientDto> getLibrafClients();
void addLibrafClient(LibrafClientDto librafClientDto);
Map<String,List<BooksDto>> getAllBooks();
void addAliVeNino(AliVeNinoDto dto);

}
