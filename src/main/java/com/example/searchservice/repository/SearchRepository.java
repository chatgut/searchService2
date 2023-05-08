package com.example.searchservice.repository;

import com.example.searchservice.entity.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<SearchEntity,Long> {

    List<SearchEntity> findByHashtag(String hashtag);
    List<SearchEntity> findByText(String text);


}
