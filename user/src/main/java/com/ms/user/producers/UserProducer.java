package com.ms.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.User;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;


    UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void publishMessageEmail(User user) {
        var emailDto = new EmailDto();

        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(user.getName() + ", seja bem vindo(a)!\nAgradecemos o seu cadastro, aproveite agora seu acesso.");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
