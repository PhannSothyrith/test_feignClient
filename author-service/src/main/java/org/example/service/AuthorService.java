package org.example.service;


import org.example.model.Author;
import org.example.model.request.AuthorRequest;

public interface AuthorService {
    Author createAuthor (AuthorRequest authorRequest);

    Author getAuthorById(Long authorId);
}
