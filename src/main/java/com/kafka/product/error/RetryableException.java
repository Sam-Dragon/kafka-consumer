package com.kafka.product.error;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RetryableException extends RuntimeException {

    public RetryableException(String message) {
        super(message);
        System.out.println("RetryableException Exception Message :: " + message);
    }

    public RetryableException(Throwable cause) {
        super(cause);
        System.out.println("RetryableException Exception Throwable :: " + cause);
    }
}
