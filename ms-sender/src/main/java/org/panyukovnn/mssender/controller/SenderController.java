package org.panyukovnn.mssender.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SenderController {

    private final KafkaTemplate<String, String> template;

    @PostMapping("/{messageCount}")
    public void sendEvent(@PathVariable("messageCount") Integer messageCount) {
        Stream.generate(() -> UUID.randomUUID().toString())
                .limit(messageCount)
                .parallel()
                .forEach((message) -> {
                    template.send("custom", message)
                            .thenRun(() -> log.info("Message sent to topic '{}': {}", "custom", message));
                });
    }
}
