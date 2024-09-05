package org.example.controller;
import org.example.model.Author;
import org.example.model.request.AuthorRequest;
import org.example.model.response.ApiResponse;
import org.example.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping("create-author")
    public ResponseEntity<ApiResponse<Author>> createAuthor(@RequestBody AuthorRequest authorRequest){
        Author author = authorService.createAuthor(authorRequest);
        ApiResponse<Author> apiResponse = ApiResponse.<Author>builder()
                 .message("Author created successfully")
                .status(HttpStatus.CREATED)
                .payload(author)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("get-author/{authorId}")
//    public Author getAuthorById(@PathVariable Long authorId){
//        return authorService.getAuthorById(authorId);
//    }
    public ResponseEntity<ApiResponse<Author>> getAuthorById(@PathVariable Long authorId){
        Author author = authorService.getAuthorById(authorId);
        ApiResponse<Author> apiResponse = ApiResponse.<Author>builder()
                .message("Get author with id "+ authorId + " successfully")
                .status(HttpStatus.OK)
                .payload(author)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("update-author/{authorId}")
    public ResponseEntity<ApiResponse<Author>> updateAuthorById(@PathVariable Long authorId, @RequestBody AuthorRequest authorRequest){
        Author author = authorService.updateAuthorById(authorId,authorRequest);
        ApiResponse<Author> apiResponse = ApiResponse.<Author>builder()
                .message("Update author with id "+ authorId + " successfully")
                .status(HttpStatus.OK)
                .payload(author)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthor(){
        List<Author> authors = authorService.getAllAuthor();
        ApiResponse<List<Author>> apiResponse = ApiResponse.<List<Author>>builder()
                .message("Get all authors successfully")
                .status(HttpStatus.OK)
                .payload(authors)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("delete-id/{authorId}")
    public ResponseEntity<ApiResponse<Author>> deleteAuthorById(@PathVariable Long authorId){
        authorService.deleteAuthorById(authorId);
        ApiResponse<Author> apiResponse = ApiResponse.<Author>builder()
                .message("Delete author with id "+ authorId + " successfully")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
