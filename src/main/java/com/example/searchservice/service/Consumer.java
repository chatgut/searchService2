package com.example.searchservice.service;

import com.example.searchservice.entity.SearchEntity;
import com.example.searchservice.repository.SearchRepository;
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

    final String MESSAGE_2 = "messages";

    private final SearchRepository searchRepository;

    @Autowired
    public Consumer(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }


    @Bean
    public Declarables fanoutBindings() {
        Queue fanoutQueue1 = new Queue("fanout.queue1", false);
        Queue fanoutQueue2 = new Queue("fanout.queue2", false);
        FanoutExchange fanoutExchange = new FanoutExchange("fanout.exchange");

        return new Declarables(
                fanoutQueue1,
                fanoutQueue2,
                fanoutExchange,
                BindingBuilder.bind(fanoutQueue1).to(fanoutExchange),
                BindingBuilder.bind(fanoutQueue2).to(fanoutExchange));
    }

    @RabbitListener(queues = {MESSAGE_1})
    public void receiveMessageFromFanout1(String message) {
        System.out.println("Received 1 message: " + message);
        searchRepository.save(new SearchEntity(message));
    }

    @RabbitListener(queues = {MESSAGE_2})
    public void receiveMessageFromFanout2(String message) {
        System.out.println("Received 1 message: " + message);
        searchRepository.save(new SearchEntity(message));
    }
}
