package ru.kkb.bot.viber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.kkb.bot.viber.config.BotApiConfig;

/**
 * @author Marchenko_DS in 31/05/2021 - 17:51
 */
@Service
public class SendService implements ISendService {

    @Autowired
    private final BotApiConfig viberConfig;


    public SendService(BotApiConfig viberConfig) {
        this.viberConfig = viberConfig;
    }

    /**
     * Send message to Api
     * @param
     * @return
     */
    @Override
    public ResponseEntity<String> sendMessage() {
        return null;
    }
}
