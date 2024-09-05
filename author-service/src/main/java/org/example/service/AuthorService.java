package org.example.service;


import org.example.model.Author;
import org.example.model.request.AuthorRequest;

import java.util.List;

public interface AuthorService {
    Author createAuthor (AuthorRequest authorRequest);

    Author getAuthorById(Long authorId);
    Author updateAuthorById(Long authorId, AuthorRequest authorRequest);
    List<Author> getAllAuthor();

    void deleteAuthorById(Long authorId);
}
