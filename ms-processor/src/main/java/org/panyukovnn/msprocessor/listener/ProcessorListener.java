package org.panyukovnn.msprocessor.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessorListener {

    @KafkaListener(topics = "custom")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group foo: " + message);
    }
}
