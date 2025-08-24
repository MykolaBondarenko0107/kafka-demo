package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaConfig {

    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder.name("demo")
                .partitions(3)
                .replicas(1)
                .build();
    }


}
