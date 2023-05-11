package com.example.searchservice.service;

import com.example.searchservice.entity.SearchEntity;
import com.example.searchservice.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public void savePostsIndex(final List<SearchEntity> posts) {
    searchRepository.saveAll(posts);

}

}
