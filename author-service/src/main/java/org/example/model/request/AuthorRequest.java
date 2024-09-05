package org.example.model.request;

import lombok.*;
import org.example.model.Author;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AuthorRequest {
    private String authorName;
    private Long age;
    private String national;

    public Author toEntity(Long authorId) {
        return new Author(authorId,this.authorName, this.age,this.national);
    }
}
