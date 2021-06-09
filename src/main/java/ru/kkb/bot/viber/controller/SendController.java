package ru.kkb.bot.viber.controller;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;
import com.viber.bot.Request;
import com.viber.bot.ViberSignatureValidator;
import com.viber.bot.api.ViberBot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kkb.bot.viber.config.BotApiConfig;
import ru.kkb.bot.viber.service.SendService;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;


/**
 * Rest Endpoint for api bot
 *
 * @author Marchenko_DS in 31/05/2021 - 17:51
 */

@RestController
@Log
@Api(value = "Send message controller")
public class SendController {

    private final BotApiConfig botApiConfig;
    private final SendService sendService;
    private final ViberBot bot;
    private final ViberSignatureValidator signatureValidator;

    @Autowired
    public SendController(BotApiConfig botApiConfig, SendService sendService, ViberBot bot, ViberSignatureValidator signatureValidator) {
        this.botApiConfig = botApiConfig;
        this.sendService = sendService;
        this.bot = bot;
        this.signatureValidator = signatureValidator;
    }


    @PostMapping(value = "/", produces = "application/json")
    public String incoming(@RequestBody String json,
                           @RequestHeader("X-Viber-Content-Signature") String serverSideSignature)
            throws ExecutionException, InterruptedException, IOException {
        Preconditions.checkState(signatureValidator.isSignatureValid(serverSideSignature, json), "invalid signature");
        @Nullable InputStream response = bot.incoming(Request.fromJsonString(json)).get();
        return response != null ? CharStreams.toString(new InputStreamReader(response, Charsets.UTF_16)) : null;
    }

    @GetMapping("/GetWebHook")
    @ApiOperation(value = "Webhook connect", notes = "Webhook connect", response = String.class)
    public ResponseEntity<String> getWebHook() throws Exception {
        bot.setWebhook(botApiConfig.getWebhookurl()).get();
        return ResponseEntity.ok("Ok");
    }

}
