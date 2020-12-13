package com.poc.bem.demo.controllers.advice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class ApiRequestTest {
    private ApiRequest request;
    private static final String CODE = "200";
    private static final String MESSAGE = "Hello, world!";

    @BeforeEach
    void setup() {
        request = new ApiRequest(CODE, MESSAGE);
    }

    @Test
    void test() {
        assertNotNull(request);
    }

    @Test
    void testGetCode() {
        assertNotNull(request.getCode());
    }

    @Test
    void testGetMessage() {
        assertNotNull(request.getMessage());
    }

    @Test
    void testGetTimestamp() {
        assertNotEquals(0L, request.getTimeStamp());
    }

    @Test
    void testToString() {
        assertNotNull(request.toString());
    }
}
