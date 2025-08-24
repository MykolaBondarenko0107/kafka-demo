package com.example.demo.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DemoProducer {

    private final KafkaTemplate<String, String> template;

    public CompletableFuture<SendResult<String, String>> send(String key, String value) {
        return template.send("demo", key, value);
    }


}
