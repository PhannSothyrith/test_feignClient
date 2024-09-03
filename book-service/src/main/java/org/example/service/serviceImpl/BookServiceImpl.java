package org.example.service.serviceImpl;

import org.example.feign.AuthorServiceFeignClient;
import org.example.model.Book;
import org.example.model.request.AuthorRequest;
import org.example.model.request.BookRequest;
import org.example.model.response.AuthorResponse;
import org.example.model.response.BookResponse;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorServiceFeignClient authorServiceFeignClient;

    public BookServiceImpl(BookRepository bookRepository, AuthorServiceFeignClient authorServiceFeignClient) {
        this.bookRepository = bookRepository;
        this.authorServiceFeignClient = authorServiceFeignClient;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        System.out.println(bookRequest.getAuthorId());
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setAuthorId(bookRequest.getAuthorId());
        bookRepository.save(book);
        BookResponse bookResponse = book.toResponse();
        AuthorResponse authorResponse = authorServiceFeignClient.getAuthorById(bookRequest.getAuthorId());
        System.out.println(authorResponse);
        bookResponse.setAuthorResponse(authorResponse);
        return bookResponse;
    }
}
