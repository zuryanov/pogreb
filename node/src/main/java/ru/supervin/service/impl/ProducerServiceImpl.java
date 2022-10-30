package ru.supervin.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.supervin.service.ProducerService;

import static ru.supervin.commonrabbitmq.model.RabbitQueue.ANSWER_MESSAGE;

@Service
@AllArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private RabbitTemplate rabbitTemplate;

    @Override
    public void producerAnswer(SendMessage sendMessage) {
        rabbitTemplate.convertAndSend(ANSWER_MESSAGE, sendMessage);
    }
}
