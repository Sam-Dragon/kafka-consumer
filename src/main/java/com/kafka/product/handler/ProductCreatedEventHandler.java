package com.kafka.product.handler;

import com.kafka.product.constants.KafkaConstants;
import com.kafka.product.entity.ProductEvent;
import com.kafka.product.error.NotRetryableException;
import com.kafka.product.error.RetryableException;
import com.kafka.product.model.pubsub.ProductCreatedEvent;
import com.kafka.product.repository.ProductRepository;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@KafkaListener(topics = KafkaConstants.CREATE_PRODUCT_TOPIC)
public class ProductCreatedEventHandler {
    private final ProductRepository repository;

    public ProductCreatedEventHandler(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @KafkaHandler
    public void handle(@Payload ProductCreatedEvent productCreatedEvent, @Header("messageId") String messageId,
                       @Header(KafkaHeaders.RECEIVED_KEY) String messageKey) {
        System.out.println("Received message :: " + productCreatedEvent);

        if (repository.existsByMessageId(messageId)) {
            System.out.println("Message is already processed with message-id:: " + messageId);
            return;
        }

        if (productCreatedEvent.getQuantity() <= 0) {
            System.out.println("Failed to send email notification...");
            throw new NotRetryableException("Not Retry...");
        } else if (BigDecimal.ONE.compareTo(productCreatedEvent.getPrice()) > 0) {
            System.out.println("Trying to send email notification...");
            throw new RetryableException("Retry...");
        } else {
            System.out.println("Successfully Sending email notification...");
        }

        try {
            ProductEvent saveEvent = new ProductEvent(messageId, productCreatedEvent.getId());
            repository.save(saveEvent);
        } catch (Exception e) {
            throw new NotRetryableException(e);
        }
    }
}
