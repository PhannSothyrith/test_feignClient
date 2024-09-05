package org.example.service.serviceImpl;

import org.example.model.Author;
import org.example.model.request.AuthorRequest;
import org.example.repository.AuthorRepository;
import org.example.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author createAuthor(AuthorRequest authorRequest) {

        Author author = new Author();
        author.setAuthorName(authorRequest.getAuthorName());
        System.out.println("hello world");
        author.setAge(authorRequest.getAge());
        author.setNational(authorRequest.getNational());
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }
}
