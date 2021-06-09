package ru.kkb.bot.viber.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.kkb.bot.viber.config.BotApiConfig;
import ru.kkb.bot.viber.service.ISendService;

/**
 * Integration test send controller
 * @author Marchenko_DS in 01/06/2021 - 13:28
 */
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"ru.kkb.bot.viber.service"})
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SendControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    //@MockBean //дeргает заглушку сервиса
    @Autowired //Дергает реальную реализацию
    private ISendService service;

    @Autowired
    private BotApiConfig botApiConfig;

    /**
     * {"result":[{"code":"OK","messageId":"3617113923859110273","segmentsId":null}]}
     */
    @Test
    @Description("Test send message")
    public void testSend() throws Exception {

    }

}