package com.example.searchservice.entity;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Getter
@Setter
@Document(indexName = "searchindex")
public class SearchEntity {

    @Id
private String id;


    @Field(type = FieldType.Text, name = "message")
private String message;




}
