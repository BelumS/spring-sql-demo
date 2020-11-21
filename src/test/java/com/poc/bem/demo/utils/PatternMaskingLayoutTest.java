package com.poc.bem.demo.utils;

import ch.qos.logback.classic.spi.LoggingEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class PatternMaskingLayoutTest {
    private PatternMaskingLayout layout;

    @BeforeEach
    void setup() {
        layout = new PatternMaskingLayout();
    }

    @Test
    void test() {
        assertNotNull(layout);
    }

    @Test
    void testDoLayout() {
        assertNotNull(layout.doLayout(new LoggingEvent()));
    }
}
