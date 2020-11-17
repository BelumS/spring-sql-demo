package com.poc.bem.demo.controllers.advice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RestExceptionHandlerTest {
    private RestExceptionHandler handler;

    @BeforeEach
    void setup() {
        handler = new RestExceptionHandler();
    }

    @Test
    void test() {
        assertNotNull(handler);
    }

    @Test
    void testCatchAllException() {
        assertNotNull(handler.handleCatchAllException(new Exception()));
    }
}
