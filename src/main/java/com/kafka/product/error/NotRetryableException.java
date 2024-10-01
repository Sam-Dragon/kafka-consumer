package com.kafka.product.error;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotRetryableException extends RuntimeException {

    public NotRetryableException(String message) {
        super(message);
        System.out.println("NotRetryableException Exception Message :: " + message);
    }

    public NotRetryableException(Throwable cause) {
        super(cause);
        System.out.println("NotRetryableException Exception Throwable :: " + cause);
    }
}
