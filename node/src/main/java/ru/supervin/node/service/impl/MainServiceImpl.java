package ru.supervin.node.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.supervin.node.dao.RawDataDao;
import ru.supervin.node.entity.RawData;
import ru.supervin.node.service.MainService;
import ru.supervin.node.service.ProducerService;

@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService {

    private RawDataDao rawDataDao;
    private ProducerService producerService;

    @Override
    public void processTextMessage(Update update) {
        saveRawData(update);

        var message = update.getMessage();
        var sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from NODE");
        producerService.producerAnswer(sendMessage);
    }

    private void saveRawData(Update update) {
        RawData rawData = RawData.builder()
                .event(update)
                .build();
        rawDataDao.save(rawData);
    }
}
