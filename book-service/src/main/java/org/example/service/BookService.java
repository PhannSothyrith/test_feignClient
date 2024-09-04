package org.example.service;

import org.example.model.Book;
import org.example.model.request.BookRequest;
import org.example.model.response.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse createBook(BookRequest bookRequest);
    List<BookResponse> getAllBooks();
    BookResponse getBookById(Long id);
    BookResponse updateBookById(Long id, BookRequest bookRequest);
    void  deleteBookById(Long id);
}
