package com.poc.bem.demo.controllers.advice;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@JsonPropertyOrder({"code", "message", "timeStamp"})
@Getter
@ToString
public final class ApiRequest {
    private String code;
    private String message;
    private final long timeStamp;

    public ApiRequest(String code, String message) {
        this.code = code;
        this.message = message;
        this.timeStamp = Instant.now().toEpochMilli();
    }
}
