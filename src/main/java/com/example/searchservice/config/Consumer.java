package com.example.searchservice.config;

import com.example.searchservice.entity.SearchEntity;
import com.example.searchservice.repository.SearchRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.searchservice.entity.SearchEntity;
import com.example.searchservice.repository.SearchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    final String MESSAGE_1 = "messages";


    private final SearchRepository searchRepository;

    private ObjectMapper objectMapper;

    @Autowired
    public Consumer(SearchRepository searchRepository, ObjectMapper objectMapper) {
        this.searchRepository = searchRepository;
        this.objectMapper = objectMapper;
    }

//
//    @Bean
//    public Declarables fanoutBindings() {
//        Queue fanoutQueue1 = new Queue("fanout.queue1", false);
//        FanoutExchange fanoutExchange = new FanoutExchange("fanout.messages");
//
//        return new Declarables(
//                fanoutQueue1,
//                fanoutExchange,
//                BindingBuilder.bind(fanoutQueue1).to(fanoutExchange));
//    }

    @RabbitListener(queues = {MESSAGE_1})
    public void receiveMessageFromFanout1(String jsonMessage) {
        try {

            SearchEntity searchEntity = objectMapper.readValue(jsonMessage, SearchEntity.class);

            System.out.println("Received 1 message: " + jsonMessage);
            searchRepository.save(searchEntity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}