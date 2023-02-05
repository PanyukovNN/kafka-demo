package org.panyukovnn.mssender.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic customTopic() {
        return new NewTopic("custom", 2, (short) 1);
    }
}
