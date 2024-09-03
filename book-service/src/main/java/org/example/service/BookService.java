package org.example.service;

import org.example.model.Book;
import org.example.model.request.BookRequest;
import org.example.model.response.BookResponse;

public interface BookService {
    BookResponse createBook(BookRequest bookRequest);
}
