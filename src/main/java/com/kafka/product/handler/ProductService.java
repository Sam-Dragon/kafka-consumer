package com.kafka.product.handler;

import com.kafka.product.model.pubsub.ProductCreatedEvent;

public interface ProductService {

    void handle(ProductCreatedEvent productCreatedEvent);
}
