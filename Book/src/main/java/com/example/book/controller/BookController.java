package com.example.book.controller;

import com.example.book.dto.BooksDto;
import com.example.book.dto.LibrafClientDto;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public Map<String,List<BooksDto>> getAllBooks() {

        return bookService.getAllBooks();
    }
    @PostMapping
    public void createBook(@RequestBody LibrafClientDto dto) {
        bookService.addLibrafClient(dto);
    }
}
