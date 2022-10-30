package r.supervin.dispatcher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import r.supervin.dispatcher.controller.UpdateController;
import r.supervin.dispatcher.service.AnswerConsumer;

import static ru.supervin.commonrabbitmq.model.RabbitQueue.ANSWER_MESSAGE;

@Service
@AllArgsConstructor
public class AnswerConsumerImpl implements AnswerConsumer {

    private UpdateController updateController;

    @Override
    @RabbitListener(queues = ANSWER_MESSAGE)
    public void consume(SendMessage sendMessage) {
        updateController.setView(sendMessage);
    }
}
