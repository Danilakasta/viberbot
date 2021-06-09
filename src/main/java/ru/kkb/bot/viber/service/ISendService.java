package ru.kkb.bot.viber.service;

import org.springframework.http.ResponseEntity;

/**
 * @author Marchenko_DS in 01/06/2021 - 11:19
 */
public interface ISendService {
    ResponseEntity<String> sendMessage();
}
