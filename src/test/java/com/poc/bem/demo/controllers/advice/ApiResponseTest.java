package com.poc.bem.demo.controllers.advice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class ApiResponseTest {
    private ApiResponse response;

    @BeforeEach
    void setup() {
        response = new ApiResponse(new ApiRequest("200", "MSG"), "{}");
    }

    @Test
    void test() {
        assertNotNull(response);
    }

    @Test
    void testGetRequest() {
        assertNotNull(response.getRequest());
    }

    @Test
    void testGetPayload() {
        assertNotNull(response.getPayload());
    }

    @Test
    void testToString() {
        assertNotNull(response.toString());
    }
}
