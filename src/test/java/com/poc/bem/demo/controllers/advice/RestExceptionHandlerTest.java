package com.poc.bem.demo.controllers.advice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
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
        assertNotNull(handler.handleCatchAllException(new Exception("An Exception occurred!")));
    }
}
