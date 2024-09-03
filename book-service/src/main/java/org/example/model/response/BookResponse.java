package org.example.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookResponse {
    private Long bookId;
    private String title;
    private String description;
    private AuthorResponse authorResponse;
}
