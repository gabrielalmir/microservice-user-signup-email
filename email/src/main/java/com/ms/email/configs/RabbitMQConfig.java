package com.ms.email.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {
    @Value("${broker.queue.email.name}")
    private String emailQueue;

    @Bean
    Queue emailQueue() {
        return new Queue(emailQueue, true);
    }

    @Bean
    Jackson2JsonMessageConverter messageConverter() {
        var objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
