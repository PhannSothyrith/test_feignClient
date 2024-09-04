package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.model.response.AuthorResponse;
import org.example.model.response.BookResponse;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private String description;
    private Long authorId;
    public BookResponse toResponse(AuthorResponse authorResponse) {
        return new BookResponse(
                this.bookId, this.title, this.description, authorResponse
        );
    }
}