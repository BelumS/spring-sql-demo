package com.poc.bem.demo.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class SwaggerConfigTest {
    private SwaggerConfig config;

    @BeforeEach
    void setup() {
        config = new SwaggerConfig();
    }

    @Test
    void test() {
        assertNotNull(config);
    }

    @Test
    void testApiV1() {
        assertNotNull(config.apiV1());
    }

    @Test
    void testApiV2() {
        assertNotNull(config.apiV2());
    }
}
