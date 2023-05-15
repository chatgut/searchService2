package com.example.searchservice.repository;

import com.example.searchservice.entity.SearchEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SearchRepository extends ElasticsearchRepository<SearchEntity,String> {

    List<SearchEntity> findByHashtag(String hashtag);

    List<SearchEntity> findByTextContaining(String text);


    void save(SearchEntity searchEntity);


    List<SearchEntity> findAll();
}