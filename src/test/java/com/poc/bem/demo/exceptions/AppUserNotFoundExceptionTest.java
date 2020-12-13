package com.poc.bem.demo.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class AppUserNotFoundExceptionTest {
    private AppUserNotFoundException exception;

    @BeforeEach
    void setup() {
        exception = new AppUserNotFoundException();
    }

    @Test
    void test() {
        assertNotNull(exception);
    }

    @Test
    void testMessage() {
        exception = new AppUserNotFoundException("Message");
        assertNotNull(exception);
    }

    @Test
    void testCause() {
        exception = new AppUserNotFoundException(new IllegalArgumentException());
        assertNotNull(exception);
    }

    @Test
    void testAlt() {
        exception = new AppUserNotFoundException("Message", new IllegalArgumentException());
        assertNotNull(exception);
    }
}
