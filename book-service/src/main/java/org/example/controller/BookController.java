package org.example.controller;

import org.example.model.Book;
import org.example.model.request.BookRequest;
import org.example.model.response.ApiResponse;
import org.example.model.response.BookResponse;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("create-book")
    public ResponseEntity<ApiResponse<BookResponse>> createBook(@RequestBody BookRequest bookRequest){
        BookResponse bookResponse = bookService.createBook(bookRequest);
        ApiResponse<BookResponse> apiResponse = ApiResponse.<BookResponse>builder()
                .message("Book created successfully")
                .status(HttpStatus.CREATED)
                .payload(bookResponse)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("get-all-books")
    public ResponseEntity<ApiResponse<List<BookResponse>>> getAllBooks(){
        List<BookResponse> bookResponses = bookService.getAllBooks();
        ApiResponse<List<BookResponse>> apiResponse = ApiResponse.<List<BookResponse>>builder()
                .message("Get all books successfully")
                .status(HttpStatus.OK)
                .payload(bookResponses)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBookById(@PathVariable Long id){
        BookResponse bookResponse = bookService.getBookById(id);
        ApiResponse<BookResponse> apiResponse = ApiResponse.<BookResponse>builder()
                .message("Get book with id "+ id + " successfully")
                .status(HttpStatus.OK)
                .payload(bookResponse)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest){
        BookResponse bookResponse = bookService.updateBookById(id, bookRequest);
        ApiResponse<BookResponse> apiResponse = ApiResponse.<BookResponse>builder()
                .message("Update book with id "+ id + " successfully")
                .status(HttpStatus.OK)
                .payload(bookResponse)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        ApiResponse <BookResponse> apiResponse = ApiResponse.<BookResponse>builder()
                .message("Delete book with id "+ id + " successfully")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
