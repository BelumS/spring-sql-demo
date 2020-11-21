package com.poc.bem.demo.controllers.advice;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created by bel-sahn on 7/29/19
 */
@JsonPropertyOrder({"request", "response"})
@Getter
@ToString
@RequiredArgsConstructor
public final class ApiResponse {
    private final ApiRequest request;
    private final Object payload;
}
