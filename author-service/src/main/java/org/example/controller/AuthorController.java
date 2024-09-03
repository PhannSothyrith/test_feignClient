package org.example.controller;
import org.example.model.Author;
import org.example.model.request.AuthorRequest;
import org.example.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping("create-author")
    public Author createAuthor(@RequestBody AuthorRequest authorRequest){
        return authorService.createAuthor(authorRequest);
    }
    @GetMapping("get-author/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }
}
