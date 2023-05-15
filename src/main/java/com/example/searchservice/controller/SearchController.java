package com.example.searchservice.controller;


import com.example.searchservice.entity.SearchEntity;
import com.example.searchservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {


    private SearchRepository repository;

    @Autowired
    public SearchController(SearchRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/insert")
    public void insertPost(@RequestBody SearchEntity searchEntity) {
        repository.save(searchEntity);
    }

        @GetMapping("/text/{text}")
    List<SearchEntity> searchByText(@PathVariable String text) {
        return repository.findByTextContaining(text);


    }
    @GetMapping("/hashtag/{hashtag}")
    List<SearchEntity> searchByHashtag(@PathVariable String hashtag) {
        return repository.findByHashtag(hashtag);


    }
    @GetMapping("/findAll")
    List<SearchEntity> getAllPosts() {
        return repository.findAll();
    }


}
