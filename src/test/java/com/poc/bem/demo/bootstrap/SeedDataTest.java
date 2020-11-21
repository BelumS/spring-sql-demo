package com.poc.bem.demo.bootstrap;

import com.poc.bem.demo.constants.ApiConstants;
import com.poc.bem.demo.services.AppUserDAOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class SeedDataTest {

    @Mock
    private AppUserDAOService mockService;

    @InjectMocks
    private SeedData seed;

    @BeforeEach
    void setup() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty(ApiConstants.APP_NAME, "TEST");
        seed = new SeedData(mockService, mockEnvironment);
    }

    @Test
    void testConstructor() {
        assertNotNull(seed);
    }

    @Test
    void testOnApplicationEvent() {
        assertDoesNotThrow(() -> seed.onApplicationEvent(new ContextRefreshedEvent(new GenericApplicationContext())));
    }

}
