package com.example.book.mapper;

import com.example.book.dto.AliVeNinoDto;
import com.example.book.dto.BooksDto;
import com.example.book.dto.LibrafClientDto;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component

public class BookMapper {
    public List<BooksDto> getAlino(List<AliVeNinoDto> aliVeNinoDtos) {
        List<BooksDto> booksDtos = new ArrayList<>();
        for(AliVeNinoDto a : aliVeNinoDtos){
            BooksDto booksDto = BooksDto.builder()
                    .nameBook(a.getName())
                    .stock(a.getStock())
                    .price(a.getPrice())
                    .build();
            booksDtos.add(booksDto);
        }
        return booksDtos;

    }
    public List<BooksDto> getLibraf(List<LibrafClientDto> librafClientDtos) {
        List<BooksDto> booksDtos = new ArrayList<>();
        for(LibrafClientDto a : librafClientDtos){
            BooksDto booksDto = BooksDto.builder()
                    .nameBook(a.getBookName())
                    .stock(a.getStock())
                    .build();
            booksDtos.add(booksDto);
        }
        return booksDtos;

    }
    public Map<String ,List<BooksDto>> listMapAllBooks(List<AliVeNinoDto> alino,List<LibrafClientDto> libraf){

        Map<String ,List<BooksDto>> map = new HashMap<>();
        map.put("AliVeNinoShop",getAlino(alino));
        map.put("LibrafClientShop",getLibraf(libraf));
        return map;
    }

}
