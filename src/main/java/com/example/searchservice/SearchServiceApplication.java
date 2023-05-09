package com.example.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }

}

//TODO: Rabbitmq och elasticsearch
// 2. producer är postservice och consumer är searchservice
// 3. fanout kommer användas i rabbitmq.
// 4. fixa endpoints i controller
// 7. Query? i repositoryklassen?


