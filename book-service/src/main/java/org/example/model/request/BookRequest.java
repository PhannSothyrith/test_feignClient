package org.example.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookRequest {
    private String title;
    private String description;
    private Long authorId;


}
