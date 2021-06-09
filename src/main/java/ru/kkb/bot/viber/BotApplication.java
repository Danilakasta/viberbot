package ru.kkb.bot.viber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Microservice bot for viber api
 * @author Marchenko_DS in 31/05/2021 - 17:51
 */
@SpringBootApplication
@ConfigurationPropertiesScan("ru.kkb.bot.viber.config")
public class BotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);
	}

}
