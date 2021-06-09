package ru.kkb.bot.viber.config;

import com.viber.bot.ViberSignatureValidator;
import com.viber.bot.api.ViberBot;
import com.viber.bot.profile.BotProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * App config
 *
 * @author Marchenko_DS in 31/05/2021 - 17:51
 */
@Configuration
@ComponentScan({"ru.kkb.bot.viber.service,ru.kkb.bot.viber.component"})
public class AppConfig {

    private final BotApiConfig botApiConfig;

    @Autowired
    public AppConfig(BotApiConfig botApiConfig) {
        this.botApiConfig = botApiConfig;
    }

    @Bean
    ViberBot viberBot() {
        return new ViberBot(new BotProfile(botApiConfig.getName(), botApiConfig.getAvatar()), botApiConfig.getAuthtoken());
    }

    @Bean
    ViberSignatureValidator signatureValidator() {
        return new ViberSignatureValidator(botApiConfig.getAuthtoken());
    }
}
