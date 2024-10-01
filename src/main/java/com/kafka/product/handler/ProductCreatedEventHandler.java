package com.kafka.product.handler;

import com.kafka.product.constants.KafkaConstants;
import com.kafka.product.error.NotRetryableException;
import com.kafka.product.error.RetryableException;
import com.kafka.product.model.pubsub.ProductCreatedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@KafkaListener(topics = KafkaConstants.CREATE_PRODUCT_TOPIC)
public class ProductCreatedEventHandler implements ProductService {

    @KafkaHandler
    public void handle(ProductCreatedEvent productCreatedEvent) {
        System.out.println("Received message :: " + productCreatedEvent);

        if (productCreatedEvent.getQuantity() <= 0) {
            System.out.println("Failed to send email notification...");
            throw new NotRetryableException("Not Retry...");
        } else if (BigDecimal.ONE.compareTo(productCreatedEvent.getPrice()) > 0) {
            System.out.println("Trying to send email notification...");
            throw new RetryableException("Retry...");
        } else {
            System.out.println("Successfully Sending email notification...");
        }

    }
}
