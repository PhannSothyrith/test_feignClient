package org.example.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AuthorRequest {
    private String authorName;
    private Long age;
    private String national;

}
