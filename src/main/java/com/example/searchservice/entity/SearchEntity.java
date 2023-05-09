package com.example.searchservice.entity;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Getter
@Setter
@Document(indexName = "search")
public class SearchEntity {

    @Id
private Long id;

private String hashtag;

private String text;


}
