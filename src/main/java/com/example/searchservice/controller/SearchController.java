package com.example.searchservice.controller;


import com.example.searchservice.entity.SearchEntity;
import com.example.searchservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {


    private SearchRepository repository;

    @Autowired
    public SearchController(SearchRepository repository) {
        this.repository = repository;
    }

        @GetMapping("/text/{text}")
    List<SearchEntity> searchByText(@PathVariable String text) {


        return repository.findByMessageContaining(text);


    }
    @GetMapping("/findAll")
    List<SearchEntity> getAllPosts() {
        return repository.findAll();
    }


}
