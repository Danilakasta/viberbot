package ru.kkb.bot.viber.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Bot Api Config
 *
 * @author Marchenko_DS in 31/05/2021 - 18:22
 */
@Configuration
@ConfigurationProperties(prefix = "application.viberbot")
@Setter
@Getter
public class BotApiConfig {

    public String authtoken;
    public String webhookurl;
    public  String name;
    public  String avatar;

}
