package org.example.service.serviceImpl;
import org.example.exception.NotFoundException;
import org.example.feign.AuthorServiceFeignClient;
import org.example.model.Book;
import org.example.model.request.BookRequest;
import org.example.model.response.AuthorResponse;
import org.example.model.response.BookResponse;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        AuthorResponse authorResponse;
        try {
            authorResponse = authorServiceFeignClient.getAuthorById(bookRequest.getAuthorId());
        } catch (Exception e) {
            throw new NotFoundException("Author not found with ID: " + bookRequest.getAuthorId());
        }
        Book book = bookRequest.toEntity();
        bookRepository.save(book);
        return book.toResponse(authorResponse);
    }


    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> {
            AuthorResponse authorResponse = authorServiceFeignClient.getAuthorById(book.getAuthorId());
            book.toResponse(authorResponse).setAuthorResponse(authorResponse);
            return book.toResponse(authorResponse);
        }).toList();
    }

    @Override
    public BookResponse getBookById(Long id) {
      Book book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found"));
      AuthorResponse authorResponse = authorServiceFeignClient.getAuthorById(book.getAuthorId());
      book.toResponse(authorResponse).setAuthorResponse(authorResponse);
      return book.toResponse(authorResponse);
    }

    @Override
    public BookResponse updateBookById(Long id, BookRequest bookRequest) {
       if (bookRepository.findById(id).isPresent()){
           Book book = bookRequest.toEntity(id);
           bookRepository.save(book);
           AuthorResponse authorResponse = authorServiceFeignClient.getAuthorById(bookRequest.getAuthorId());
           book.toResponse(authorResponse).setAuthorResponse(authorResponse);
           return book.toResponse(authorResponse);
       }
       throw  new NotFoundException("Book not found");
    }

    @Override
    public void deleteBookById(Long id) {
      if (bookRepository.findById(id).isEmpty()){
          throw new NotFoundException("Book not found");
      }
       bookRepository.deleteById(id);
    }
}

