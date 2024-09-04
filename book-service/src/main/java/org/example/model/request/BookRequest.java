package org.example.model.request;

import lombok.*;
import org.example.model.Book;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookRequest {
    private String title;
    private String description;
    private Long authorId;

    public Book toEntity(){
        return new Book(null,this.title, this.description, this.authorId);

    }
    public Book toEntity(Long id){
        return new Book(id,this.title, this.description, this.authorId);

    }



}
