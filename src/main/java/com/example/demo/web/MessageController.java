package com.example.demo.web;

import com.example.demo.kafka.DemoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {
    private final DemoProducer producer;

    @PostMapping
    public CompletableFuture<String> send(@RequestParam String key, @RequestParam String value) {
        return producer.send(key, value)
                .thenApply(r -> "ok: partition=" + r.getRecordMetadata().partition()
                        + ", offset=" + r.getRecordMetadata().offset());
    }


}
