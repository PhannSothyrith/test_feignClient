package org.example.feign;

import org.example.model.request.AuthorRequest;
import org.example.model.response.AuthorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "author-service", url = "http://localhost:8081/api/v1/author")
public interface AuthorServiceFeignClient {
    @GetMapping("/get-author/{authorId}")
    AuthorResponse getAuthorById(@PathVariable Long authorId);
    @PostMapping("create-author")   
    AuthorResponse createAuthor(@RequestBody AuthorRequest authorRequest);
}
