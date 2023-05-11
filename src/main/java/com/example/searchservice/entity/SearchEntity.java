package com.example.searchservice.entity;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Getter
@Setter
@Document(indexName = "searchindex")
public class SearchEntity {

    @Id
private Long id;

    @Field(type = FieldType.Keyword, name = "hashtag")
private String hashtag;


    @Field(type = FieldType.Text, name = "text")
private String text;


}
