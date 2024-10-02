package com.kafka.product.repository;

import com.kafka.product.entity.ProductEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEvent, Long> {

    boolean existsByMessageId(String messageId);
}
