package org.example.service.serviceImpl;

import org.example.exception.NotFoundException;
import org.example.model.Author;
import org.example.model.request.AuthorRequest;
import org.example.repository.AuthorRepository;
import org.example.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Author updateAuthorById(Long authorId, AuthorRequest authorRequest) {
       if (authorRepository.findById(authorId).isEmpty()) {
           throw new NotFoundException("Author not found");
       }
       Author author = authorRequest.toEntity(authorId);
       return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
    @Override
    public void deleteAuthorById(Long authorId) {
        if(authorRepository.findById(authorId).isEmpty()){
            throw new NotFoundException("Author not found");
        }
        authorRepository.deleteById(authorId);
    }
}
