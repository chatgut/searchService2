package com.example.searchservice.controller;


import com.example.searchservice.entity.SearchEntity;
import com.example.searchservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {


    SearchRepository repository;

    public SearchController(SearchRepository repository) {
        this.repository = repository;
    }


//    public void savePostsIndex(List<SearchEntity> posts) {
//        repository.save(posts);
//
//
//    }
//
    @GetMapping("/text")
    List<SearchEntity> searchByText(@RequestParam String text) {
        return repository.findByTextContaining(text);


    }
    @GetMapping("/hashtag")
    List<SearchEntity> searchByHashtag(@RequestParam String hashtag) {
        return repository.findByHashtag(hashtag);


    }
}
