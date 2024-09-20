package com.example.correction_tps.exception;

public class RateLimitExceededException extends Throwable {
    public RateLimitExceededException(String limiteDeRequêtesNormalesDépassée) {
    }
}
