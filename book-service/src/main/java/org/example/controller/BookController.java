package org.example.controller;

import org.example.model.request.BookRequest;
import org.example.model.response.BookResponse;
import org.example.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("create=book")
    public BookResponse createBook(@RequestBody BookRequest bookRequest){
        return bookService.createBook(bookRequest);
    }
}
