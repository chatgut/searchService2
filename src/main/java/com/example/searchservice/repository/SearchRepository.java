package com.example.searchservice.repository;

import com.example.searchservice.entity.SearchEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SearchRepository extends ElasticsearchRepository<SearchEntity,String> {



    List<SearchEntity> findByMessageContaining(String text);




    List<SearchEntity> findAll();
}