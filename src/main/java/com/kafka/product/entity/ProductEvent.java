package com.kafka.product.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "product-events")
@Entity
@Data
public class ProductEvent {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String messageId;

    @Column(nullable = false)
    private String productId;

    public ProductEvent(String messageId, String productId) {
        this.messageId = messageId;
        this.productId = productId;
    }
}
