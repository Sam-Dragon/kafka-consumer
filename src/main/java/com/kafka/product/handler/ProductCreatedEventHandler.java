package com.kafka.product.handler;

import com.kafka.product.constants.KafkaConstants;
import com.kafka.product.model.pubsub.ProductCreatedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = KafkaConstants.CREATE_PRODUCT_TOPIC)
public class ProductCreatedEventHandler implements ProductService {

    @KafkaHandler
    public void handle(ProductCreatedEvent productCreatedEvent) {
        System.out.println("Received message :: " + productCreatedEvent);
        System.out.println("Sending email notification...");
    }
}
