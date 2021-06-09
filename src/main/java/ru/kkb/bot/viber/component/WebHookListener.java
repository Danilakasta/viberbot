package ru.kkb.bot.viber.component;


import com.google.common.util.concurrent.Futures;
import com.viber.bot.api.ViberBot;
import com.viber.bot.message.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.kkb.bot.viber.config.BotApiConfig;

import java.util.Optional;

/**
 * Event lisener init;
 *
 * @author Marchenko_DS in 08/06/2021 - 18:22
 */
@Component
public class WebHookListener implements ApplicationListener<ApplicationReadyEvent> {

    private final ViberBot bot;
    private  final BotApiConfig botApiConfig;

    @Autowired
    public WebHookListener(ViberBot bot, BotApiConfig botApiConfig) {
        this.bot = bot;
        this.botApiConfig = botApiConfig;
    }

    /**
     * Init event listener
     * @param appReadyEvent
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent appReadyEvent) {
        setWebHook();

        bot.onMessageReceived((event, message, response) -> response.send(message));
        bot.onConversationStarted(event -> Futures.immediateFuture(Optional.of(
                new TextMessage("Салам папалам " + event.getUser().getName() + "! Че как жизнь петушок?"))));
    }

    /**
     * Set web Hook
     */
    private void setWebHook(){
        try {
            bot.setWebhook(botApiConfig.getWebhookurl()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
